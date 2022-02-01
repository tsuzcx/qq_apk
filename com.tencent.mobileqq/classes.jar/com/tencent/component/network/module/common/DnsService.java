package com.tencent.component.network.module.common;

import android.text.TextUtils;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.utils.thread.ThreadPool;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DnsService
{
  private static final int CACHE_TIME = 3600000;
  private static final byte[] DATA_LOCK = new byte[0];
  private static final byte[] INSTANCE_LOCK;
  private static final int SLEEP_INTERVAL = 20;
  private static final String TAG = "DnsService";
  private static final byte[] TASKLIST_LOCK = new byte[0];
  private static final String THREADPOOL_NAME_COMMON = "resolver_threadpool_name_common";
  private static final String THREADPOOL_NAME_INTERNAL = "resolver_threadpool_name_internal";
  private static final int THREADPOOL_SIZE_COMMON = 2;
  private static final int THREADPOOL_SIZE_INTERANL = 4;
  private static final int TIME_OUT = 20000;
  private static final int TRY_TIMES = 1;
  private static final Pattern ipReg = Pattern.compile("((\\d{1,3}\\.){3}\\d{1,3}|(\\w{1,4}:){5}\\w{1,4})", 2);
  private static DnsService sIntance = null;
  private boolean enableHttpDns = false;
  private List<DnsService.ResolverDomainTask> mActiveTaskList = Collections.synchronizedList(new ArrayList());
  private ConcurrentHashMap<String, ArrayList<String>> mBackupIp = new ConcurrentHashMap();
  private HashSet<String> mBlackList = new HashSet();
  private ConcurrentHashMap<String, DnsService.IpRecord> mDomainMap = new ConcurrentHashMap();
  private Executor mExecutor;
  private List<Pattern> mFilter;
  private String mKey = "none";
  private final HashMap<String, ThreadPool> mThreadPoolMap = new HashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<Long, Integer>> mTryTimes = new ConcurrentHashMap();
  private List<String> waitingList = Collections.synchronizedList(new ArrayList());
  
  static
  {
    INSTANCE_LOCK = new byte[0];
  }
  
  private DnsService()
  {
    initFilter();
  }
  
  private void addCurrTryTimes(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      synchronized (DATA_LOCK)
      {
        if (this.mTryTimes.get(paramString) != null)
        {
          ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.mTryTimes.get(paramString);
          Iterator localIterator = localConcurrentHashMap.entrySet().iterator();
          if (localIterator.hasNext())
          {
            Object localObject = (Map.Entry)localIterator.next();
            Long localLong = (Long)((Map.Entry)localObject).getKey();
            localObject = (Integer)((Map.Entry)localObject).getValue();
            if (localObject == null) {
              break label183;
            }
            i = ((Integer)localObject).intValue();
            i += 1;
            localConcurrentHashMap.put(localLong, Integer.valueOf(i));
            if (!QDLog.isInfoEnable()) {
              continue;
            }
            QDLog.i("DnsService", "DNSService domain:" + paramString + " key:" + localLong + " times:" + i);
          }
        }
      }
      return;
      label183:
      int i = 0;
    }
  }
  
  private void clearCurrTryTimes(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (DATA_LOCK)
    {
      if (this.mTryTimes.get(paramString) != null)
      {
        paramString = (ConcurrentHashMap)this.mTryTimes.get(paramString);
        Long localLong = Long.valueOf(Thread.currentThread().getId());
        if (paramString.get(localLong) != null) {
          paramString.remove(localLong);
        }
      }
      return;
    }
  }
  
  private boolean enableCustomDns()
  {
    return Config.enableDns114();
  }
  
  private boolean ensureNotRepeat(String paramString)
  {
    return !isQuerying(paramString);
  }
  
  private int getCurrTryTimes(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    for (;;)
    {
      synchronized (DATA_LOCK)
      {
        if (this.mTryTimes.get(paramString) == null) {
          break label122;
        }
        paramString = (ConcurrentHashMap)this.mTryTimes.get(paramString);
        localObject = Long.valueOf(Thread.currentThread().getId());
        if (paramString.get(localObject) == null) {
          break label108;
        }
        Integer localInteger = (Integer)paramString.get(localObject);
        if (localInteger != null)
        {
          i = localInteger.intValue();
          break;
          return i;
        }
      }
      paramString.put(localObject, Integer.valueOf(0));
      break label167;
      label108:
      paramString.put(localObject, Integer.valueOf(0));
      break label167;
      label122:
      Object localObject = new ConcurrentHashMap();
      ((ConcurrentHashMap)localObject).put(Long.valueOf(Thread.currentThread().getId()), Integer.valueOf(0));
      this.mTryTimes.put(paramString, localObject);
    }
    for (;;)
    {
      break;
      label167:
      i = 0;
    }
  }
  
  private ThreadPool getDomainResolverThreadPool(String paramString)
  {
    String str = getThreadPoolName(paramString);
    ThreadPool localThreadPool = (ThreadPool)this.mThreadPoolMap.get(str);
    paramString = localThreadPool;
    int i;
    if (localThreadPool == null)
    {
      i = 2;
      if ("resolver_threadpool_name_internal".equals(str)) {
        i = 4;
      }
      if (this.mExecutor == null) {
        break label72;
      }
    }
    label72:
    for (paramString = new ThreadPool(this.mExecutor);; paramString = new ThreadPool(str, i, i, new LinkedBlockingQueue()))
    {
      this.mThreadPoolMap.put(str, paramString);
      return paramString;
    }
  }
  
  private String getIPFromCache(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    DnsService.IpRecord localIpRecord = (DnsService.IpRecord)this.mDomainMap.get(paramString);
    if (localIpRecord == null) {
      return null;
    }
    if (localIpRecord.isValid()) {
      return localIpRecord.ip;
    }
    this.mDomainMap.remove(paramString);
    return null;
  }
  
  /* Error */
  public static DnsService getInstance()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 64	com/tencent/component/network/module/common/DnsService:sIntance	Lcom/tencent/component/network/module/common/DnsService;
    //   6: ifnonnull +27 -> 33
    //   9: getstatic 66	com/tencent/component/network/module/common/DnsService:INSTANCE_LOCK	[B
    //   12: astore_0
    //   13: aload_0
    //   14: monitorenter
    //   15: getstatic 64	com/tencent/component/network/module/common/DnsService:sIntance	Lcom/tencent/component/network/module/common/DnsService;
    //   18: ifnonnull +13 -> 31
    //   21: new 2	com/tencent/component/network/module/common/DnsService
    //   24: dup
    //   25: invokespecial 303	com/tencent/component/network/module/common/DnsService:<init>	()V
    //   28: putstatic 64	com/tencent/component/network/module/common/DnsService:sIntance	Lcom/tencent/component/network/module/common/DnsService;
    //   31: aload_0
    //   32: monitorexit
    //   33: getstatic 64	com/tencent/component/network/module/common/DnsService:sIntance	Lcom/tencent/component/network/module/common/DnsService;
    //   36: astore_0
    //   37: ldc 2
    //   39: monitorexit
    //   40: aload_0
    //   41: areturn
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    //   47: astore_0
    //   48: ldc 2
    //   50: monitorexit
    //   51: aload_0
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   47	5	0	localObject2	Object
    //   42	4	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   15	31	42	finally
    //   31	33	42	finally
    //   43	45	42	finally
    //   3	15	47	finally
    //   33	37	47	finally
    //   45	47	47	finally
  }
  
  private String getKey()
  {
    String str = null;
    if (NetworkManager.isMobile()) {
      str = NetworkManager.getApnValue();
    }
    while (!NetworkManager.isWifi()) {
      return str;
    }
    return NetworkManager.getBSSID();
  }
  
  private String getThreadPoolName(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "resolver_threadpool_name_common";
    }
    Iterator localIterator = this.mFilter.iterator();
    while (localIterator.hasNext()) {
      if (Utils.match((Pattern)localIterator.next(), paramString)) {
        return "resolver_threadpool_name_internal";
      }
    }
    return "resolver_threadpool_name_common";
  }
  
  private void initFilter()
  {
    int i = 0;
    String[] arrayOfString = new String[7];
    arrayOfString[0] = "a[0-9].qpic.cn";
    arrayOfString[1] = "m.qpic.cn";
    arrayOfString[2] = "t[0-9].qpic.cn";
    arrayOfString[3] = "qlogo[0-9].store.qq.com";
    arrayOfString[4] = "mmsns.qpic.cn";
    arrayOfString[5] = "ugc.qpic.cn";
    arrayOfString[6] = "b\\d+.photo.store.qq.com";
    this.mFilter = new ArrayList();
    while (i < arrayOfString.length)
    {
      Pattern localPattern = Pattern.compile(arrayOfString[i], 2);
      this.mFilter.add(localPattern);
      i += 1;
    }
  }
  
  private boolean isIPValid(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while ((paramString.startsWith("192.168")) || (paramString.equals("127.0.0.1")) || (paramString.equals("0.0.0.0")) || (paramString.equals("255.255.255.255"))) {
      return false;
    }
    return true;
  }
  
  private void setResolveResult(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    if ((!TextUtils.isEmpty(paramString2)) && (isIPValid(paramString2))) {
      this.mDomainMap.put(paramString1, new DnsService.IpRecord(this, paramString2, System.currentTimeMillis()));
    }
    this.waitingList.remove(paramString1);
    addCurrTryTimes(paramString1);
  }
  
  public void addQuery(String paramString)
  {
    ThreadPool localThreadPool;
    String str1;
    if ((!TextUtils.isEmpty(paramString)) && (ensureNotRepeat(paramString)))
    {
      this.waitingList.add(paramString);
      localThreadPool = getDomainResolverThreadPool(paramString);
      if (QDLog.isInfoEnable()) {
        QDLog.i("DnsService", "add query:" + paramString);
      }
      String str2 = NetworkManager.getApnValue();
      str1 = str2;
      if ("wifi".equals(str2)) {
        str1 = NetworkManager.getBSSID();
      }
    }
    try
    {
      localThreadPool.submit(new DnsService.ResolverDomainTask(this, paramString, str1));
      return;
    }
    catch (Throwable paramString)
    {
      QDLog.e("DnsService", "exception when add query to DNSService.", paramString);
    }
  }
  
  public String getDomainIP(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      localObject = null;
    }
    do
    {
      return localObject;
      localObject = paramString;
    } while (ipReg.matcher(paramString).find());
    long l2 = System.currentTimeMillis();
    String str = getIPFromCache(paramString);
    Object localObject = str;
    if (TextUtils.isEmpty(str))
    {
      long l1 = 0L;
      for (;;)
      {
        localObject = getIPFromCache(paramString);
        if ((!TextUtils.isEmpty((CharSequence)localObject)) || (l1 > 20000L) || (getCurrTryTimes(paramString) >= 1)) {
          break;
        }
        try
        {
          addQuery(paramString);
          Thread.sleep(20L);
          l1 += 20L;
        }
        catch (InterruptedException localInterruptedException)
        {
          QDLog.e("DnsService", "DNSService getDomainIP InterruptedException", localInterruptedException);
        }
      }
    }
    clearCurrTryTimes(paramString);
    QDLog.w("DnsService", "DNSService domain:" + paramString + " ip:" + localInterruptedException + " time:" + (System.currentTimeMillis() - l2) + " threadId:" + Thread.currentThread().getId());
    return localInterruptedException;
  }
  
  public boolean isQuerying(String paramString)
  {
    return this.waitingList.contains(paramString);
  }
  
  public void reset()
  {
    String str = getKey();
    if (QDLog.isInfoEnable()) {
      QDLog.i("DnsService", "DNSService reset. Key:" + this.mKey + " currKey:" + str);
    }
    if ((str == null) || (!str.equalsIgnoreCase(this.mKey))) {
      synchronized (TASKLIST_LOCK)
      {
        Iterator localIterator = this.mActiveTaskList.iterator();
        if (localIterator.hasNext()) {
          ((DnsService.ResolverDomainTask)localIterator.next()).setIsExpired(true);
        }
      }
    }
    this.mKey = localObject;
    this.mDomainMap.clear();
    addQuery("m.qpic.cn");
  }
  
  public void setThreadPoolExecutor(Executor paramExecutor)
  {
    if (this.mExecutor != null) {
      this.mExecutor = paramExecutor;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.module.common.DnsService
 * JD-Core Version:    0.7.0.1
 */