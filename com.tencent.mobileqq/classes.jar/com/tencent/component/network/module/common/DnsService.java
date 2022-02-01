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
  private static final byte[] INSTANCE_LOCK = new byte[0];
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
  private static DnsService sIntance;
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
  
  private DnsService()
  {
    initFilter();
  }
  
  private void addCurrTryTimes(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    synchronized (DATA_LOCK)
    {
      if (this.mTryTimes.get(paramString) != null)
      {
        ConcurrentHashMap localConcurrentHashMap = (ConcurrentHashMap)this.mTryTimes.get(paramString);
        Iterator localIterator = localConcurrentHashMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (Map.Entry)localIterator.next();
          Long localLong = (Long)((Map.Entry)localObject).getKey();
          localObject = (Integer)((Map.Entry)localObject).getValue();
          int i = 0;
          if (localObject != null) {
            i = ((Integer)localObject).intValue();
          }
          i += 1;
          localConcurrentHashMap.put(localLong, Integer.valueOf(i));
          if (QDLog.isInfoEnable())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("DNSService domain:");
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(" key:");
            ((StringBuilder)localObject).append(localLong);
            ((StringBuilder)localObject).append(" times:");
            ((StringBuilder)localObject).append(i);
            QDLog.i("DnsService", ((StringBuilder)localObject).toString());
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw paramString;
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
    return isQuerying(paramString) ^ true;
  }
  
  private int getCurrTryTimes(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int i = 0;
    Integer localInteger1 = Integer.valueOf(0);
    if (bool) {
      return 0;
    }
    synchronized (DATA_LOCK)
    {
      Object localObject;
      if (this.mTryTimes.get(paramString) != null)
      {
        paramString = (ConcurrentHashMap)this.mTryTimes.get(paramString);
        localObject = Long.valueOf(Thread.currentThread().getId());
        if (paramString.get(localObject) != null)
        {
          Integer localInteger2 = (Integer)paramString.get(localObject);
          if (localInteger2 != null) {
            i = localInteger2.intValue();
          } else {
            paramString.put(localObject, localInteger1);
          }
        }
        else
        {
          paramString.put(localObject, localInteger1);
        }
      }
      else
      {
        localObject = new ConcurrentHashMap();
        ((ConcurrentHashMap)localObject).put(Long.valueOf(Thread.currentThread().getId()), localInteger1);
        this.mTryTimes.put(paramString, localObject);
      }
      return i;
    }
  }
  
  private ThreadPool getDomainResolverThreadPool(String paramString)
  {
    String str = getThreadPoolName(paramString);
    ThreadPool localThreadPool = (ThreadPool)this.mThreadPoolMap.get(str);
    paramString = localThreadPool;
    if (localThreadPool == null)
    {
      int i = 2;
      if ("resolver_threadpool_name_internal".equals(str)) {
        i = 4;
      }
      paramString = this.mExecutor;
      if (paramString != null) {
        paramString = new ThreadPool(paramString);
      } else {
        paramString = new ThreadPool(str, i, i, new LinkedBlockingQueue());
      }
      this.mThreadPoolMap.put(str, paramString);
    }
    return paramString;
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
  
  public static DnsService getInstance()
  {
    try
    {
      if (sIntance == null) {
        synchronized (INSTANCE_LOCK)
        {
          if (sIntance == null) {
            sIntance = new DnsService();
          }
        }
      }
      ??? = sIntance;
      return ???;
    }
    finally {}
  }
  
  private String getKey()
  {
    if (NetworkManager.isMobile()) {
      return NetworkManager.getApnValue();
    }
    if (NetworkManager.isWifi()) {
      return NetworkManager.getBSSID();
    }
    return null;
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
    String[] arrayOfString = new String[7];
    int i = 0;
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
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if ((!paramString.startsWith("192.168")) && (!paramString.equals("127.0.0.1")) && (!paramString.equals("0.0.0.0"))) {
      return !paramString.equals("255.255.255.255");
    }
    return false;
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
    if ((!TextUtils.isEmpty(paramString)) && (ensureNotRepeat(paramString)))
    {
      this.waitingList.add(paramString);
      ThreadPool localThreadPool = getDomainResolverThreadPool(paramString);
      if (QDLog.isInfoEnable())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("add query:");
        ((StringBuilder)localObject).append(paramString);
        QDLog.i("DnsService", ((StringBuilder)localObject).toString());
      }
      String str = NetworkManager.getApnValue();
      Object localObject = str;
      if ("wifi".equals(str)) {
        localObject = NetworkManager.getBSSID();
      }
      try
      {
        localThreadPool.submit(new DnsService.ResolverDomainTask(this, paramString, (String)localObject));
        return;
      }
      catch (Throwable paramString)
      {
        QDLog.e("DnsService", "exception when add query to DNSService.", paramString);
      }
    }
  }
  
  public String getDomainIP(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (ipReg.matcher(paramString).find()) {
      return paramString;
    }
    long l2 = System.currentTimeMillis();
    Object localObject2 = getIPFromCache(paramString);
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      long l1 = 0L;
      for (;;)
      {
        localObject1 = getIPFromCache(paramString);
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) || (l1 > 20000L) || (getCurrTryTimes(paramString) >= 1)) {
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
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("DNSService domain:");
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(" ip:");
    ((StringBuilder)localObject2).append(localInterruptedException);
    ((StringBuilder)localObject2).append(" time:");
    ((StringBuilder)localObject2).append(System.currentTimeMillis() - l2);
    ((StringBuilder)localObject2).append(" threadId:");
    ((StringBuilder)localObject2).append(Thread.currentThread().getId());
    QDLog.w("DnsService", ((StringBuilder)localObject2).toString());
    return localInterruptedException;
  }
  
  public boolean isQuerying(String paramString)
  {
    return this.waitingList.contains(paramString);
  }
  
  public void reset()
  {
    String str = getKey();
    if (QDLog.isInfoEnable())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("DNSService reset. Key:");
      ((StringBuilder)???).append(this.mKey);
      ((StringBuilder)???).append(" currKey:");
      ((StringBuilder)???).append(str);
      QDLog.i("DnsService", ((StringBuilder)???).toString());
    }
    if ((str == null) || (!str.equalsIgnoreCase(this.mKey))) {}
    synchronized (TASKLIST_LOCK)
    {
      Iterator localIterator = this.mActiveTaskList.iterator();
      while (localIterator.hasNext()) {
        ((DnsService.ResolverDomainTask)localIterator.next()).setIsExpired(true);
      }
      this.mKey = str;
      this.mDomainMap.clear();
      addQuery("m.qpic.cn");
      return;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public void setThreadPoolExecutor(Executor paramExecutor)
  {
    if (this.mExecutor != null) {
      this.mExecutor = paramExecutor;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.common.DnsService
 * JD-Core Version:    0.7.0.1
 */