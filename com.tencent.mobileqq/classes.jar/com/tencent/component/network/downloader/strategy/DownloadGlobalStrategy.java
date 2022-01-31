package com.tencent.component.network.downloader.strategy;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.downloader.common.IPInfo;
import com.tencent.component.network.downloader.common.Utils;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.statistics.ProxyStatistics;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

public class DownloadGlobalStrategy
{
  private static Context jdField_a_of_type_AndroidContentContext;
  public static final DownloadGlobalStrategy.StrategyInfo a;
  private static volatile DownloadGlobalStrategy jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy = null;
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  private static final byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  public static final DownloadGlobalStrategy.StrategyInfo b;
  private static ArrayList jdField_b_of_type_JavaUtilArrayList;
  public static final DownloadGlobalStrategy.StrategyInfo c;
  private static ArrayList c;
  public static final DownloadGlobalStrategy.StrategyInfo d;
  public static final DownloadGlobalStrategy.StrategyInfo e;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long = 0L;
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private PortConfigStrategy jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy;
  private ConcurrentHashMap jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private boolean jdField_a_of_type_Boolean = true;
  private volatile int jdField_b_of_type_Int = 0;
  
  static
  {
    jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = new DownloadGlobalStrategy.StrategyInfo(1, false, false, false);
    jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = new DownloadGlobalStrategy.StrategyInfo(2, true, false, false);
    jdField_c_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo = new DownloadGlobalStrategy.StrategyInfo(3, true, true, false);
    d = new DownloadGlobalStrategy.StrategyInfo(4, false, false, true);
    e = new DownloadGlobalStrategy.StrategyInfo(5, false, false, false, true);
    jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    jdField_b_of_type_JavaUtilArrayList = new ArrayList();
    jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private DownloadGlobalStrategy(Context paramContext)
  {
    this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy = DownloaderFactory.getInstance(paramContext).getPortStrategy();
    jdField_a_of_type_JavaUtilArrayList.add(jdField_c_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo);
    jdField_a_of_type_JavaUtilArrayList.add(jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo);
    jdField_a_of_type_JavaUtilArrayList.add(jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo);
    jdField_a_of_type_JavaUtilArrayList.add(e);
    jdField_a_of_type_JavaUtilArrayList.add(e);
    jdField_a_of_type_JavaUtilArrayList.add(d);
    jdField_a_of_type_JavaUtilArrayList.add(d);
    jdField_a_of_type_JavaUtilArrayList.add(jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo);
    jdField_b_of_type_JavaUtilArrayList.add(jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo);
    jdField_b_of_type_JavaUtilArrayList.add(jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo);
    jdField_b_of_type_JavaUtilArrayList.add(jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo);
    jdField_b_of_type_JavaUtilArrayList.add(e);
    jdField_b_of_type_JavaUtilArrayList.add(e);
    jdField_b_of_type_JavaUtilArrayList.add(d);
    jdField_b_of_type_JavaUtilArrayList.add(d);
    jdField_b_of_type_JavaUtilArrayList.add(jdField_c_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo);
    jdField_c_of_type_JavaUtilArrayList.add(jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo);
    jdField_c_of_type_JavaUtilArrayList.add(jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo);
    jdField_c_of_type_JavaUtilArrayList.add(e);
    jdField_c_of_type_JavaUtilArrayList.add(e);
    jdField_c_of_type_JavaUtilArrayList.add(d);
    jdField_c_of_type_JavaUtilArrayList.add(d);
    jdField_c_of_type_JavaUtilArrayList.add(jdField_c_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo);
    jdField_c_of_type_JavaUtilArrayList.add(jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo);
    jdField_a_of_type_AndroidContentContext = paramContext;
    if (jdField_a_of_type_AndroidContentContext != null) {
      this.jdField_a_of_type_AndroidContentSharedPreferences = jdField_a_of_type_AndroidContentContext.getSharedPreferences("downloa_stragegy", 0);
    }
    b();
  }
  
  public static DownloadGlobalStrategy a(Context paramContext)
  {
    if (jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy == null) {}
    synchronized (jdField_a_of_type_ArrayOfByte)
    {
      if (jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy == null) {
        jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy = new DownloadGlobalStrategy(paramContext);
      }
      return jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy;
    }
  }
  
  private String a(String paramString1, String paramString2)
  {
    String str = "";
    if ("wifi".equals(paramString2))
    {
      str = NetworkManager.getBSSID();
      if (!TextUtils.isEmpty(str)) {
        break label54;
      }
    }
    label54:
    for (str = "";; str = "_" + str) {
      return paramString1 + "_" + paramString2 + str;
    }
  }
  
  private boolean a(DownloadGlobalStrategy.StrategyInfo paramStrategyInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    return paramStrategyInfo != null;
  }
  
  /* Error */
  private void b()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 99	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: aload_0
    //   11: getfield 63	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   14: invokevirtual 146	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   17: aload_0
    //   18: getfield 99	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   21: ldc 148
    //   23: iconst_1
    //   24: invokeinterface 154 3 0
    //   29: iconst_1
    //   30: if_icmpne +5 -> 35
    //   33: iconst_1
    //   34: istore_1
    //   35: aload_0
    //   36: iload_1
    //   37: putfield 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_Boolean	Z
    //   40: aload_0
    //   41: aload_0
    //   42: getfield 99	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   45: ldc 156
    //   47: invokestatic 162	java/lang/System:currentTimeMillis	()J
    //   50: invokeinterface 166 4 0
    //   55: putfield 69	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_Long	J
    //   58: ldc 168
    //   60: ldc 170
    //   62: ldc2_w 171
    //   65: invokestatic 177	com/tencent/component/network/module/base/Config:a	(Ljava/lang/String;Ljava/lang/String;J)J
    //   68: lstore_2
    //   69: invokestatic 162	java/lang/System:currentTimeMillis	()J
    //   72: aload_0
    //   73: getfield 69	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_Long	J
    //   76: lsub
    //   77: lload_2
    //   78: ldc2_w 178
    //   81: lmul
    //   82: lcmp
    //   83: ifle +15 -> 98
    //   86: aload_0
    //   87: iconst_1
    //   88: putfield 67	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_Boolean	Z
    //   91: aload_0
    //   92: invokestatic 162	java/lang/System:currentTimeMillis	()J
    //   95: putfield 69	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_Long	J
    //   98: aload_0
    //   99: getfield 99	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   102: ldc 181
    //   104: aconst_null
    //   105: invokeinterface 184 3 0
    //   110: astore 4
    //   112: aload 4
    //   114: ifnull -105 -> 9
    //   117: aload 4
    //   119: iconst_0
    //   120: invokestatic 189	com/tencent/component/network/utils/Base64:a	(Ljava/lang/String;I)[B
    //   123: invokestatic 195	com/tencent/component/network/downloader/common/Utils:unmarshall	([B)Landroid/os/Parcel;
    //   126: astore 5
    //   128: aload 5
    //   130: astore 4
    //   132: aload 5
    //   134: aload_0
    //   135: getfield 63	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   138: getstatic 89	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   141: invokevirtual 199	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   144: invokevirtual 205	android/os/Parcel:readMap	(Ljava/util/Map;Ljava/lang/ClassLoader;)V
    //   147: aload 5
    //   149: ifnull -140 -> 9
    //   152: aload 5
    //   154: invokevirtual 208	android/os/Parcel:recycle	()V
    //   157: return
    //   158: astore 6
    //   160: aconst_null
    //   161: astore 5
    //   163: aload 5
    //   165: astore 4
    //   167: ldc 210
    //   169: ldc 212
    //   171: aload 6
    //   173: invokestatic 217	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   176: aload 5
    //   178: ifnull -169 -> 9
    //   181: aload 5
    //   183: invokevirtual 208	android/os/Parcel:recycle	()V
    //   186: return
    //   187: astore 5
    //   189: aconst_null
    //   190: astore 4
    //   192: aload 4
    //   194: ifnull +8 -> 202
    //   197: aload 4
    //   199: invokevirtual 208	android/os/Parcel:recycle	()V
    //   202: aload 5
    //   204: athrow
    //   205: astore 5
    //   207: goto -15 -> 192
    //   210: astore 6
    //   212: goto -49 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	215	0	this	DownloadGlobalStrategy
    //   1	36	1	bool	boolean
    //   68	10	2	l	long
    //   110	88	4	localObject1	Object
    //   126	56	5	localParcel	android.os.Parcel
    //   187	16	5	localObject2	Object
    //   205	1	5	localObject3	Object
    //   158	14	6	localThrowable1	java.lang.Throwable
    //   210	1	6	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   117	128	158	java/lang/Throwable
    //   117	128	187	finally
    //   132	147	205	finally
    //   167	176	205	finally
    //   132	147	210	java/lang/Throwable
  }
  
  public DownloadGlobalStrategy.StrategyInfo a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      paramString2 = null;
    }
    boolean bool1;
    boolean bool2;
    do
    {
      return paramString2;
      String str = a(paramString2, NetworkManager.getApnValue());
      DownloadGlobalStrategy.StrategyInfo localStrategyInfo = (DownloadGlobalStrategy.StrategyInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(str);
      paramString1 = localStrategyInfo;
      if (localStrategyInfo != null)
      {
        paramString1 = localStrategyInfo;
        if (!localStrategyInfo.a())
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(str);
          this.jdField_b_of_type_Int += 1;
          a();
          if (QDLog.b()) {
            QDLog.b("DownloadGlobalStrategy", "best strategy invalid! domain:" + paramString2 + " threadId:" + Thread.currentThread().getId());
          }
          paramString1 = null;
        }
      }
      bool1 = ProxyStatistics.a().a();
      bool2 = ProxyStatistics.a().b();
      paramString2 = paramString1;
    } while (a(paramString1, bool1, bool2));
    return new DownloadGlobalStrategy.StrategyInfo(bool1, bool2, false);
  }
  
  public DownloadGlobalStrategy.StrategyLib a(String paramString1, String paramString2, boolean paramBoolean)
  {
    int j = 80;
    DownloadGlobalStrategy.StrategyLib localStrategyLib = new DownloadGlobalStrategy.StrategyLib(this);
    DownloadGlobalStrategy.StrategyLib.a(localStrategyLib, a(paramString1, paramString2));
    int i;
    if (!NetworkManager.isWap())
    {
      DownloadGlobalStrategy.StrategyLib.a(localStrategyLib, jdField_c_of_type_JavaUtilArrayList);
      if (!paramBoolean) {
        break label152;
      }
      i = 443;
      label50:
      localStrategyLib.a(i);
      if ((DownloadGlobalStrategy.StrategyLib.a(localStrategyLib) != null) && (DownloadGlobalStrategy.StrategyLib.a(localStrategyLib).a() != null) && (DownloadGlobalStrategy.StrategyLib.a(localStrategyLib).a()) && (!TextUtils.isEmpty(DownloadGlobalStrategy.StrategyLib.a(localStrategyLib).a().jdField_a_of_type_JavaLangString)))
      {
        if (DownloadGlobalStrategy.StrategyLib.a(localStrategyLib).jdField_a_of_type_Int != d.jdField_a_of_type_Int) {
          break label252;
        }
        localStrategyLib.c(DownloadGlobalStrategy.StrategyLib.a(localStrategyLib).a().jdField_a_of_type_JavaLangString);
      }
    }
    label152:
    label252:
    do
    {
      return localStrategyLib;
      DownloadGlobalStrategy.StrategyLib.a(localStrategyLib, jdField_a_of_type_JavaUtilArrayList);
      break;
      i = j;
      if (this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy == null) {
        break label50;
      }
      i = j;
      if (!this.jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyPortConfigStrategy.a(paramString2)) {
        break label50;
      }
      i = j;
      if (DownloadGlobalStrategy.StrategyLib.a(localStrategyLib) == null) {
        break label50;
      }
      i = j;
      if (DownloadGlobalStrategy.StrategyLib.a(localStrategyLib).a() == null) {
        break label50;
      }
      i = j;
      if (!DownloadGlobalStrategy.StrategyLib.a(localStrategyLib).a()) {
        break label50;
      }
      int k = DownloadGlobalStrategy.StrategyLib.a(localStrategyLib).a().jdField_a_of_type_Int;
      i = j;
      if (!Utils.isPortValid(k)) {
        break label50;
      }
      i = k;
      break label50;
      if (DownloadGlobalStrategy.StrategyLib.a(localStrategyLib).jdField_a_of_type_Int == e.jdField_a_of_type_Int)
      {
        localStrategyLib.b(DownloadGlobalStrategy.StrategyLib.a(localStrategyLib).a().jdField_a_of_type_JavaLangString);
        return localStrategyLib;
      }
    } while (DownloadGlobalStrategy.StrategyLib.a(localStrategyLib).jdField_a_of_type_Int != jdField_a_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int);
    localStrategyLib.a(DownloadGlobalStrategy.StrategyLib.a(localStrategyLib).a().jdField_a_of_type_JavaLangString);
    return localStrategyLib;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 99	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 71	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_b_of_type_Int	I
    //   13: istore_1
    //   14: iload_1
    //   15: ifne +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: invokestatic 324	com/tencent/component/network/downloader/impl/DownloadTask:a	()I
    //   24: ifle +11 -> 35
    //   27: aload_0
    //   28: getfield 71	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_b_of_type_Int	I
    //   31: iconst_5
    //   32: if_icmplt -14 -> 18
    //   35: aload_0
    //   36: iconst_0
    //   37: putfield 71	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_b_of_type_Int	I
    //   40: invokestatic 325	com/tencent/component/network/module/base/QDLog:a	()Z
    //   43: ifeq +11 -> 54
    //   46: ldc 210
    //   48: ldc_w 327
    //   51: invokestatic 329	com/tencent/component/network/module/base/QDLog:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aconst_null
    //   55: astore_3
    //   56: aconst_null
    //   57: astore_2
    //   58: invokestatic 333	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   61: astore 4
    //   63: aload 4
    //   65: astore_2
    //   66: aload 4
    //   68: astore_3
    //   69: aload 4
    //   71: aload_0
    //   72: getfield 63	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap	Ljava/util/concurrent/ConcurrentHashMap;
    //   75: invokevirtual 337	android/os/Parcel:writeMap	(Ljava/util/Map;)V
    //   78: aload 4
    //   80: astore_2
    //   81: aload 4
    //   83: astore_3
    //   84: new 112	java/lang/String
    //   87: dup
    //   88: aload 4
    //   90: invokevirtual 341	android/os/Parcel:marshall	()[B
    //   93: iconst_0
    //   94: invokestatic 344	com/tencent/component/network/utils/Base64:b	([BI)[B
    //   97: invokespecial 347	java/lang/String:<init>	([B)V
    //   100: astore 5
    //   102: aload 4
    //   104: astore_2
    //   105: aload 4
    //   107: astore_3
    //   108: aload_0
    //   109: getfield 99	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:jdField_a_of_type_AndroidContentSharedPreferences	Landroid/content/SharedPreferences;
    //   112: invokeinterface 351 1 0
    //   117: ldc 181
    //   119: aload 5
    //   121: invokeinterface 357 3 0
    //   126: invokeinterface 360 1 0
    //   131: pop
    //   132: aload 4
    //   134: ifnull -116 -> 18
    //   137: aload 4
    //   139: invokevirtual 208	android/os/Parcel:recycle	()V
    //   142: goto -124 -> 18
    //   145: astore_2
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_2
    //   149: athrow
    //   150: astore 4
    //   152: aload_2
    //   153: astore_3
    //   154: ldc 210
    //   156: ldc_w 362
    //   159: aload 4
    //   161: invokestatic 217	com/tencent/component/network/module/base/QDLog:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   164: aload_2
    //   165: ifnull -147 -> 18
    //   168: aload_2
    //   169: invokevirtual 208	android/os/Parcel:recycle	()V
    //   172: goto -154 -> 18
    //   175: astore_2
    //   176: aload_3
    //   177: ifnull +7 -> 184
    //   180: aload_3
    //   181: invokevirtual 208	android/os/Parcel:recycle	()V
    //   184: aload_2
    //   185: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	DownloadGlobalStrategy
    //   13	2	1	i	int
    //   57	48	2	localObject1	Object
    //   145	24	2	localObject2	Object
    //   175	10	2	localObject3	Object
    //   55	126	3	localObject4	Object
    //   61	77	4	localParcel	android.os.Parcel
    //   150	10	4	localException	java.lang.Exception
    //   100	20	5	str	String
    // Exception table:
    //   from	to	target	type
    //   2	14	145	finally
    //   21	35	145	finally
    //   35	54	145	finally
    //   137	142	145	finally
    //   168	172	145	finally
    //   180	184	145	finally
    //   184	186	145	finally
    //   58	63	150	java/lang/Exception
    //   69	78	150	java/lang/Exception
    //   84	102	150	java/lang/Exception
    //   108	132	150	java/lang/Exception
    //   58	63	175	finally
    //   69	78	175	finally
    //   84	102	175	finally
    //   108	132	175	finally
    //   154	164	175	finally
  }
  
  public void a(Context paramContext, String paramString1, String paramString2, DownloadGlobalStrategy.StrategyInfo paramStrategyInfo, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        boolean bool = TextUtils.isEmpty(paramString1);
        if ((bool) || (paramStrategyInfo == null)) {
          return;
        }
        paramString1 = NetworkManager.getApnValue();
        if (paramString2 != null)
        {
          paramString1 = a(paramString2, paramString1);
          paramString2 = (DownloadGlobalStrategy.StrategyInfo)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString1);
          if (!paramBoolean) {
            break label165;
          }
          if ((!paramStrategyInfo.equals(paramString2)) && (DownloadGlobalStrategy.StrategyInfo.a(paramStrategyInfo, paramString2) >= 0))
          {
            this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString1, paramStrategyInfo);
            this.jdField_b_of_type_Int += 1;
            a();
          }
          if (this.jdField_b_of_type_Int > 0) {
            a();
          }
        }
        if ((!paramBoolean) || ((paramStrategyInfo.jdField_a_of_type_Int != jdField_c_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int) && (paramStrategyInfo.jdField_a_of_type_Int != jdField_b_of_type_ComTencentComponentNetworkDownloaderStrategyDownloadGlobalStrategy$StrategyInfo.jdField_a_of_type_Int))) {
          continue;
        }
        ProxyStatistics.a().a(paramContext, paramStrategyInfo.jdField_a_of_type_Boolean, paramStrategyInfo.b);
        continue;
        if (!paramStrategyInfo.equals(paramString2)) {
          continue;
        }
      }
      finally {}
      label165:
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString1);
      this.jdField_b_of_type_Int += 1;
      a();
    }
  }
  
  public void a(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {}
    for (;;)
    {
      return;
      try
      {
        QDLog.d("DownloadGlobalStrategy", "https download result:" + paramBoolean2 + " failCount:" + this.jdField_a_of_type_Int);
        if (!paramBoolean2)
        {
          this.jdField_a_of_type_Int += 1;
          long l = Config.a("PhotoSvrList", "disable_https_failcount", 6L);
          if ((this.jdField_a_of_type_Int < l) || (!this.jdField_a_of_type_Boolean)) {
            continue;
          }
          this.jdField_a_of_type_Boolean = false;
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("download_support_https", 0);
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("download_support_https_timestamp", this.jdField_a_of_type_Long);
          this.jdField_a_of_type_AndroidContentSharedPreferences.edit().commit();
          continue;
        }
      }
      finally {}
      this.jdField_a_of_type_Int = 0;
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Long = System.currentTimeMillis();
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("download_support_https", 1);
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putLong("download_support_https_timestamp", this.jdField_a_of_type_Long);
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().commit();
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy
 * JD-Core Version:    0.7.0.1
 */