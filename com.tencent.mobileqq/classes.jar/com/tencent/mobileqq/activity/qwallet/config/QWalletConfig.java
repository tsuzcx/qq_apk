package com.tencent.mobileqq.activity.qwallet.config;

import Wallet.RspWalletConfig;
import akpb;
import akpc;
import akpd;
import akpg;
import akph;
import akxc;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONObject;

public class QWalletConfig
  implements Serializable
{
  public static final int OCCASION_FOREGROUND = 4;
  public static final int OCCASION_FOREGROUND_WAIT = 1024;
  public static final int OCCASION_INVALID = -1;
  public static final int OCCASION_LOGIN = 1;
  public static final int OCCASION_LOGIN_WAIT = 256;
  public static final int OCCASION_PUSH = 0;
  public static final int OCCASION_RECONNECT = 2;
  public static final int OCCASION_RECONNECT_WAIT = 512;
  public static final int REFRESH_TYPE_DEFAULT = 0;
  public static final int REQ_TYPE_ALL = 0;
  public static final long REQ_TYPE_GOLDMSG = 1L;
  private static final byte[] c = new byte[0];
  private static final long serialVersionUID = 1L;
  private transient int jdField_a_of_type_Int;
  private transient String jdField_a_of_type_JavaLangString;
  private transient Map<String, List<akph>> jdField_a_of_type_JavaUtilMap;
  private transient byte[] jdField_a_of_type_ArrayOfByte;
  private int action;
  private transient String jdField_b_of_type_JavaLangString;
  private transient Map<String, Object> jdField_b_of_type_JavaUtilMap;
  private transient byte[] jdField_b_of_type_ArrayOfByte;
  public String commonMsg;
  public Map<String, String> configs = new HashMap();
  public int lastAppId;
  public long lastReqTime;
  private Map<Long, Long> lastReqTimes = new HashMap();
  private Map<String, Long> localVersions = new HashMap();
  public int refreshTime;
  private Map<Long, Integer> refreshTimes = new HashMap();
  public int refreshType;
  public long seriesNo;
  
  private static String a(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime == null) || (TextUtils.isEmpty(paramAppRuntime.getAccount()))) {
      return null;
    }
    paramAppRuntime = new StringBuilder(akxc.c).append(paramAppRuntime.getAccount()).append("/.config/");
    paramAppRuntime.append(".config");
    return paramAppRuntime.toString();
  }
  
  private void a(long paramLong)
  {
    this.lastReqTime = paramLong;
    Iterator localIterator = this.lastReqTimes.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      this.lastReqTimes.put(localEntry.getKey(), Long.valueOf(paramLong));
    }
  }
  
  private void a(long paramLong1, long paramLong2, RspWalletConfig paramRspWalletConfig)
  {
    long l2 = 1L;
    long l1 = paramLong2;
    paramLong2 = l2;
    while (l1 != 0L) {
      if ((paramLong2 & l1) != 0L)
      {
        this.lastReqTimes.put(Long.valueOf(paramLong2), Long.valueOf(paramLong1));
        this.refreshTimes.put(Long.valueOf(paramLong2), Integer.valueOf(paramRspWalletConfig.refreshTime));
        l1 &= (0xFFFFFFFF ^ paramLong2);
        paramLong2 <<= 1;
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramQQAppInterface != null) {}
    for (paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();; paramQQAppInterface = "")
    {
      this.jdField_b_of_type_JavaLangString = paramQQAppInterface;
      this.jdField_a_of_type_JavaUtilMap = new HashMap();
      this.jdField_b_of_type_JavaUtilMap = new ConcurrentHashMap();
      this.jdField_a_of_type_ArrayOfByte = new byte[0];
      this.jdField_b_of_type_ArrayOfByte = new byte[0];
      if (this.localVersions == null) {
        this.localVersions = new HashMap();
      }
      return;
    }
  }
  
  /* Error */
  private void a(Map<String, String> paramMap, boolean paramBoolean, long paramLong)
  {
    // Byte code:
    //   0: new 185	java/util/LinkedList
    //   3: dup
    //   4: invokespecial 186	java/util/LinkedList:<init>	()V
    //   7: astore 6
    //   9: aload_0
    //   10: getfield 178	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig:jdField_b_of_type_ArrayOfByte	[B
    //   13: astore 5
    //   15: aload 5
    //   17: monitorenter
    //   18: iload_2
    //   19: ifeq +176 -> 195
    //   22: aload_1
    //   23: ifnull +163 -> 186
    //   26: aload_0
    //   27: getfield 66	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig:configs	Ljava/util/Map;
    //   30: invokeinterface 114 1 0
    //   35: invokeinterface 120 1 0
    //   40: astore 7
    //   42: aload 7
    //   44: invokeinterface 126 1 0
    //   49: ifeq +89 -> 138
    //   52: aload 7
    //   54: invokeinterface 130 1 0
    //   59: checkcast 132	java/util/Map$Entry
    //   62: astore 8
    //   64: aload_1
    //   65: aload 8
    //   67: invokeinterface 135 1 0
    //   72: invokeinterface 190 2 0
    //   77: ifne -35 -> 42
    //   80: aload 6
    //   82: aload 8
    //   84: invokeinterface 135 1 0
    //   89: invokevirtual 193	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   92: pop
    //   93: goto -51 -> 42
    //   96: astore_1
    //   97: aload 5
    //   99: monitorexit
    //   100: aload_1
    //   101: athrow
    //   102: astore_1
    //   103: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   106: ifeq +31 -> 137
    //   109: ldc 200
    //   111: iconst_2
    //   112: new 87	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   119: ldc 203
    //   121: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: aload_1
    //   125: invokevirtual 206	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   128: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 210	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   137: return
    //   138: aload 6
    //   140: invokevirtual 211	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   143: astore 7
    //   145: aload 7
    //   147: invokeinterface 126 1 0
    //   152: ifeq +34 -> 186
    //   155: aload 7
    //   157: invokeinterface 130 1 0
    //   162: checkcast 213	java/lang/String
    //   165: astore 8
    //   167: aload_0
    //   168: getfield 72	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig:localVersions	Ljava/util/Map;
    //   171: aload 8
    //   173: lload_3
    //   174: invokestatic 141	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   177: invokeinterface 145 3 0
    //   182: pop
    //   183: goto -38 -> 145
    //   186: aload_0
    //   187: getfield 66	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig:configs	Ljava/util/Map;
    //   190: invokeinterface 216 1 0
    //   195: aload_1
    //   196: ifnull +86 -> 282
    //   199: aload_1
    //   200: invokeinterface 114 1 0
    //   205: invokeinterface 120 1 0
    //   210: astore 7
    //   212: aload 7
    //   214: invokeinterface 126 1 0
    //   219: ifeq +63 -> 282
    //   222: aload 7
    //   224: invokeinterface 130 1 0
    //   229: checkcast 132	java/util/Map$Entry
    //   232: astore 8
    //   234: aload_0
    //   235: getfield 66	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig:configs	Ljava/util/Map;
    //   238: aload 8
    //   240: invokeinterface 135 1 0
    //   245: aload 8
    //   247: invokeinterface 219 1 0
    //   252: invokeinterface 145 3 0
    //   257: pop
    //   258: aload_0
    //   259: getfield 72	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig:localVersions	Ljava/util/Map;
    //   262: aload 8
    //   264: invokeinterface 135 1 0
    //   269: lload_3
    //   270: invokestatic 141	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   273: invokeinterface 145 3 0
    //   278: pop
    //   279: goto -67 -> 212
    //   282: aload 5
    //   284: monitorexit
    //   285: aload_1
    //   286: astore 5
    //   288: iload_2
    //   289: ifeq +60 -> 349
    //   292: aload_1
    //   293: astore 5
    //   295: aload 6
    //   297: invokevirtual 223	java/util/LinkedList:size	()I
    //   300: ifle +49 -> 349
    //   303: new 63	java/util/HashMap
    //   306: dup
    //   307: aload_1
    //   308: invokespecial 226	java/util/HashMap:<init>	(Ljava/util/Map;)V
    //   311: astore 5
    //   313: aload 6
    //   315: invokevirtual 211	java/util/LinkedList:iterator	()Ljava/util/Iterator;
    //   318: astore_1
    //   319: aload_1
    //   320: invokeinterface 126 1 0
    //   325: ifeq +33 -> 358
    //   328: aload 5
    //   330: aload_1
    //   331: invokeinterface 130 1 0
    //   336: checkcast 213	java/lang/String
    //   339: aconst_null
    //   340: invokeinterface 145 3 0
    //   345: pop
    //   346: goto -27 -> 319
    //   349: aload_0
    //   350: aload 5
    //   352: iload_2
    //   353: lload_3
    //   354: invokespecial 228	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig:b	(Ljava/util/Map;ZJ)V
    //   357: return
    //   358: goto -9 -> 349
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	361	0	this	QWalletConfig
    //   0	361	1	paramMap	Map<String, String>
    //   0	361	2	paramBoolean	boolean
    //   0	361	3	paramLong	long
    //   13	338	5	localObject1	Object
    //   7	307	6	localLinkedList	LinkedList
    //   40	183	7	localIterator	Iterator
    //   62	201	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   26	42	96	finally
    //   42	93	96	finally
    //   97	100	96	finally
    //   138	145	96	finally
    //   145	183	96	finally
    //   186	195	96	finally
    //   199	212	96	finally
    //   212	279	96	finally
    //   282	285	96	finally
    //   0	18	102	java/lang/Throwable
    //   100	102	102	java/lang/Throwable
    //   295	319	102	java/lang/Throwable
    //   319	346	102	java/lang/Throwable
    //   349	357	102	java/lang/Throwable
  }
  
  private void b(Map<String, String> paramMap, boolean paramBoolean, long paramLong)
  {
    Iterator localIterator;
    Map.Entry localEntry;
    if (paramMap != null)
    {
      localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        akpc.a(this.jdField_b_of_type_JavaLangString, (String)localEntry.getKey(), (String)localEntry.getValue());
      }
      if (!paramBoolean) {
        break label89;
      }
      this.jdField_b_of_type_JavaUtilMap.clear();
    }
    for (;;)
    {
      notifyUpdateListeners(paramMap, paramLong);
      return;
      label89:
      localIterator = paramMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        this.jdField_b_of_type_JavaUtilMap.remove(localEntry.getKey());
      }
    }
  }
  
  /* Error */
  public static QWalletConfig readConfig(QQAppInterface paramQQAppInterface)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_0
    //   5: invokestatic 253	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig:a	(Lmqq/app/AppRuntime;)Ljava/lang/String;
    //   8: astore 4
    //   10: aload 4
    //   12: invokestatic 85	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifne +104 -> 119
    //   18: aload_3
    //   19: astore_1
    //   20: getstatic 57	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig:c	[B
    //   23: astore 5
    //   25: aload_3
    //   26: astore_1
    //   27: aload 5
    //   29: monitorenter
    //   30: aload 4
    //   32: invokestatic 258	akww:a	(Ljava/lang/String;)Ljava/lang/Object;
    //   35: checkcast 2	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig
    //   38: astore_1
    //   39: aload 5
    //   41: monitorexit
    //   42: aload_1
    //   43: astore_2
    //   44: aload_1
    //   45: ifnonnull +11 -> 56
    //   48: new 2	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig
    //   51: dup
    //   52: invokespecial 259	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig:<init>	()V
    //   55: astore_2
    //   56: aload_2
    //   57: aload_0
    //   58: aload 4
    //   60: invokespecial 261	com/tencent/mobileqq/activity/qwallet/config/QWalletConfig:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   63: invokestatic 198	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +29 -> 95
    //   69: ldc 200
    //   71: iconst_2
    //   72: new 87	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 201	java/lang/StringBuilder:<init>	()V
    //   79: ldc_w 263
    //   82: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: aload_2
    //   86: invokevirtual 266	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 105	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 269	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aload_2
    //   96: areturn
    //   97: astore_3
    //   98: aload_2
    //   99: astore_1
    //   100: aload_1
    //   101: astore_2
    //   102: aload 5
    //   104: monitorexit
    //   105: aload_3
    //   106: athrow
    //   107: astore_2
    //   108: aload_2
    //   109: invokevirtual 272	java/lang/Exception:printStackTrace	()V
    //   112: goto -70 -> 42
    //   115: astore_3
    //   116: goto -16 -> 100
    //   119: aconst_null
    //   120: astore_1
    //   121: goto -79 -> 42
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramQQAppInterface	QQAppInterface
    //   19	102	1	localObject1	Object
    //   3	99	2	localObject2	Object
    //   107	2	2	localException	java.lang.Exception
    //   1	25	3	localObject3	Object
    //   97	9	3	localObject4	Object
    //   115	1	3	localObject5	Object
    //   8	51	4	str	String
    //   23	80	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   30	39	97	finally
    //   102	105	97	finally
    //   20	25	107	java/lang/Exception
    //   27	30	107	java/lang/Exception
    //   105	107	107	java/lang/Exception
    //   39	42	115	finally
  }
  
  public void addUpdateListener(String paramString, akph paramakph)
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramakph != null))
      {
        List localList = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        Object localObject = localList;
        if (localList == null)
        {
          localObject = new LinkedList();
          this.jdField_a_of_type_JavaUtilMap.put(paramString, localObject);
        }
        if (!((List)localObject).contains(paramakph)) {
          ((List)localObject).add(paramakph);
        }
      }
      return;
    }
  }
  
  public String getConfig(String paramString)
  {
    synchronized (this.jdField_b_of_type_ArrayOfByte)
    {
      paramString = (String)this.configs.get(paramString);
      return paramString;
    }
  }
  
  public akpb getConfigInfo(String paramString)
  {
    akpb localakpb = new akpb();
    localakpb.jdField_a_of_type_JavaLangString = paramString;
    for (;;)
    {
      synchronized (this.jdField_b_of_type_ArrayOfByte)
      {
        localakpb.jdField_b_of_type_JavaLangString = getConfig(paramString);
        paramString = (Long)this.localVersions.get(paramString);
        if (paramString != null)
        {
          l = paramString.longValue();
          localakpb.jdField_a_of_type_Long = l;
          return localakpb;
        }
      }
      long l = 0L;
    }
  }
  
  public Object getParsedConfig(String paramString)
  {
    JSONArray localJSONArray = null;
    String str = getConfig(paramString);
    paramString = localJSONArray;
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      paramString = new JSONObject(str);
      if (paramString != null) {}
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        try
        {
          localJSONArray = new JSONArray(str);
          paramString = localJSONArray;
          return paramString;
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
        paramString = paramString;
        paramString.printStackTrace();
        paramString = null;
      }
    }
    return paramString;
  }
  
  public int getValidReqOcca(int paramInt)
  {
    if ((this.refreshType == 0) || (this.action == 3) || (isVersionUpdate())) {
      return paramInt;
    }
    int i;
    if (NetConnInfoCenter.getServerTimeMillis() - this.lastReqTime >= this.refreshTime * 1000)
    {
      i = 1;
      switch (paramInt)
      {
      }
    }
    do
    {
      do
      {
        do
        {
          return -1;
          i = 0;
          break;
          if ((this.refreshType & 0x1) != 0) {
            return 1;
          }
        } while ((i == 0) || ((this.refreshType & 0x100) == 0));
        return 256;
        if ((this.refreshType & 0x2) != 0) {
          return 2;
        }
      } while ((i == 0) || ((this.refreshType & 0x200) == 0));
      return 512;
      if ((this.refreshType & 0x4) != 0) {
        return 4;
      }
    } while ((i == 0) || ((this.refreshType & 0x400) == 0));
    return 1024;
  }
  
  public void handleRsp(RspWalletConfig paramRspWalletConfig, long paramLong, akpg paramakpg, akpd paramakpd)
  {
    if ((paramRspWalletConfig == null) || (paramRspWalletConfig.result != RspWalletConfig.RET_SUCC)) {
      return;
    }
    int i;
    long l;
    if (paramRspWalletConfig.refreshTime > 86400)
    {
      i = 86400;
      paramRspWalletConfig.refreshTime = i;
      l = NetConnInfoCenter.getServerTimeMillis();
      if (paramLong != 0L) {
        break label351;
      }
      a(l);
      this.action = paramRspWalletConfig.action;
      if (paramRspWalletConfig.action != 1) {
        break label135;
      }
      label69:
      if (paramRspWalletConfig.action != 3) {
        this.jdField_a_of_type_Int = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QWalletConfig", 2, "after update|" + this);
      }
      this.lastAppId = AppSetting.a();
      saveConfig();
      return;
      i = paramRspWalletConfig.refreshTime;
      break;
      label135:
      if (paramRspWalletConfig.action == 0)
      {
        this.seriesNo = paramRspWalletConfig.seriesNo;
        this.refreshType = paramRspWalletConfig.refreshType;
        this.refreshTime = paramRspWalletConfig.refreshTime;
        this.commonMsg = paramRspWalletConfig.commonMsg;
        a(paramRspWalletConfig.mConfig, true, l);
        break label69;
      }
      if (paramRspWalletConfig.action == 2)
      {
        this.seriesNo = paramRspWalletConfig.seriesNo;
        this.refreshType = paramRspWalletConfig.refreshType;
        this.refreshTime = paramRspWalletConfig.refreshTime;
        this.commonMsg = paramRspWalletConfig.commonMsg;
        a(paramRspWalletConfig.mConfig, false, l);
        break label69;
      }
      if (paramRspWalletConfig.action != 3) {
        break label69;
      }
      if (this.seriesNo == paramRspWalletConfig.seriesNo) {}
      for (i = 1;; i = 0)
      {
        this.seriesNo = paramRspWalletConfig.seriesNo;
        this.refreshType = paramRspWalletConfig.refreshType;
        this.refreshTime = paramRspWalletConfig.refreshTime;
        this.commonMsg = paramRspWalletConfig.commonMsg;
        a(paramRspWalletConfig.mConfig, false, l);
        if ((paramakpd == null) || (i != 0) || (this.jdField_a_of_type_Int >= 100)) {
          break;
        }
        paramakpd.a();
        this.jdField_a_of_type_Int += 1;
        break;
      }
      label351:
      a(l, paramLong, paramRspWalletConfig);
      a(paramRspWalletConfig.mConfig, false, l);
      notifyListener(paramakpg);
    }
  }
  
  public boolean isValidToReq(long paramLong)
  {
    boolean bool = false;
    long l3 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = 1L;
    long l1 = paramLong;
    paramLong = l2;
    for (;;)
    {
      if (l1 != 0L) {
        if ((paramLong & l1) != 0L) {
          if (this.lastReqTimes.containsKey(Long.valueOf(paramLong)))
          {
            l2 = ((Long)this.lastReqTimes.get(Long.valueOf(paramLong))).longValue();
            if (!this.refreshTimes.containsKey(Long.valueOf(paramLong))) {
              break label185;
            }
            i = ((Integer)this.refreshTimes.get(Long.valueOf(paramLong))).intValue();
            if (Math.abs(l3 - Long.valueOf(l2).longValue()) < i * 1000) {
              break label190;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QWalletConfig", 2, "isValidToReq true when" + l1 + "|" + paramLong);
            }
            bool = true;
          }
        }
      }
    }
    label185:
    label190:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        return bool;
        l2 = 0L;
        continue;
        int i = 0;
      }
      l1 &= (0xFFFFFFFF ^ paramLong);
      paramLong <<= 1;
      break;
    }
    QLog.d("QWalletConfig", 2, "isValidToReq false" + l1);
    return false;
  }
  
  public boolean isVersionUpdate()
  {
    return this.lastAppId != AppSetting.a();
  }
  
  public void notifyListener(akpg paramakpg)
  {
    if (paramakpg != null) {}
    synchronized (this.jdField_b_of_type_ArrayOfByte)
    {
      HashMap localHashMap = new HashMap(this.configs);
      paramakpg.a(this.jdField_b_of_type_JavaLangString, localHashMap);
      return;
    }
  }
  
  public void notifyUpdateListeners(Map<String, String> paramMap, long paramLong)
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if (paramMap.size() <= 0) {
        return;
      }
      Object localObject1;
      String str;
      label116:
      do
      {
        paramMap = paramMap.entrySet().iterator();
        break label116;
        do
        {
          do
          {
            if (!paramMap.hasNext()) {
              break;
            }
            localObject1 = (Map.Entry)paramMap.next();
            str = (String)((Map.Entry)localObject1).getKey();
            localObject1 = (String)((Map.Entry)localObject1).getValue();
          } while (TextUtils.isEmpty(str));
          localObject2 = (List)this.jdField_a_of_type_JavaUtilMap.get(str);
        } while (localObject2 == null);
        Object localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          akph localakph = (akph)((Iterator)localObject2).next();
          try
          {
            localakph.a(str, (String)localObject1, new akpb(str, (String)localObject1, paramLong));
          }
          catch (Throwable localThrowable) {}
        }
      } while (!QLog.isColorLevel());
      QLog.e("QWalletConfig", 2, "notifyUpdateListeners|key=" + str + "|config=" + (String)localObject1 + "|errmsg=" + localThrowable.getMessage());
    }
  }
  
  public void onDestroy()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.jdField_b_of_type_JavaUtilMap.clear();
      return;
    }
  }
  
  public void removeUpdateListener(String paramString, akph paramakph)
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if ((!TextUtils.isEmpty(paramString)) && (paramakph != null))
      {
        paramString = (List)this.jdField_a_of_type_JavaUtilMap.get(paramString);
        if (paramString != null) {
          paramString.remove(paramakph);
        }
      }
      return;
    }
  }
  
  public void saveConfig()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      ThreadManager.getFileThreadHandler().post(new QWalletConfig.1(this));
    }
  }
  
  public String toString()
  {
    return "QWalletConfig{seriesNo=" + this.seriesNo + ", refreshType=" + this.refreshType + ", refreshTime=" + this.refreshTime + ", lastReqTime=" + this.lastReqTime + ", commonMsg='" + this.commonMsg + '\'' + ", configs=" + this.configs + ", refreshTimes=" + this.refreshTimes + ", lastReqTimes=" + this.lastReqTimes + ", mSavePath='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mCurUin='" + this.jdField_b_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.config.QWalletConfig
 * JD-Core Version:    0.7.0.1
 */