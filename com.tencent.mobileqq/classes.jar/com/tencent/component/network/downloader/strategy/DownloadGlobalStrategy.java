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
  private static final byte[] INSTANCE_LOCK = new byte[0];
  private static ArrayList<DownloadGlobalStrategy.StrategyInfo> StrategyLib_NWAP;
  private static ArrayList<DownloadGlobalStrategy.StrategyInfo> StrategyLib_WAP;
  private static ArrayList<DownloadGlobalStrategy.StrategyInfo> StrategyLib_WAP1;
  public static final DownloadGlobalStrategy.StrategyInfo Strategy_BACKUPIP;
  public static final DownloadGlobalStrategy.StrategyInfo Strategy_DOMAIN_FORCE;
  public static final DownloadGlobalStrategy.StrategyInfo Strategy_DomainDirect = new DownloadGlobalStrategy.StrategyInfo(1, false, false, false);
  public static final DownloadGlobalStrategy.StrategyInfo Strategy_DomainProxy_CON;
  public static final DownloadGlobalStrategy.StrategyInfo Strategy_DomainProxy_SYS = new DownloadGlobalStrategy.StrategyInfo(2, true, false, false);
  private static final String TAG = "DownloadGlobalStrategy";
  private static Context mContext;
  private static volatile DownloadGlobalStrategy mInstance;
  private boolean httpsSupport = true;
  private long httpsSupportTimestamp = 0L;
  private volatile int mCacheModifyCount = 0;
  private int mHttpsFailCount = 0;
  private PortConfigStrategy mPortConfig;
  private SharedPreferences mSetting;
  private ConcurrentHashMap<String, DownloadGlobalStrategy.StrategyInfo> mapBestDomainStrategyCache = new ConcurrentHashMap();
  
  static
  {
    Strategy_DomainProxy_CON = new DownloadGlobalStrategy.StrategyInfo(3, true, true, false);
    Strategy_BACKUPIP = new DownloadGlobalStrategy.StrategyInfo(4, false, false, true);
    Strategy_DOMAIN_FORCE = new DownloadGlobalStrategy.StrategyInfo(5, false, false, false, true);
    StrategyLib_WAP = new ArrayList();
    StrategyLib_WAP1 = new ArrayList();
    StrategyLib_NWAP = new ArrayList();
    mInstance = null;
  }
  
  private DownloadGlobalStrategy(Context paramContext)
  {
    this.mPortConfig = DownloaderFactory.getInstance(paramContext).getPortStrategy();
    StrategyLib_WAP.add(Strategy_DomainProxy_CON);
    StrategyLib_WAP.add(Strategy_DomainDirect);
    StrategyLib_WAP.add(Strategy_DomainDirect);
    StrategyLib_WAP.add(Strategy_DOMAIN_FORCE);
    StrategyLib_WAP.add(Strategy_DOMAIN_FORCE);
    StrategyLib_WAP.add(Strategy_BACKUPIP);
    StrategyLib_WAP.add(Strategy_BACKUPIP);
    StrategyLib_WAP.add(Strategy_DomainProxy_SYS);
    StrategyLib_WAP1.add(Strategy_DomainProxy_SYS);
    StrategyLib_WAP1.add(Strategy_DomainDirect);
    StrategyLib_WAP1.add(Strategy_DomainDirect);
    StrategyLib_WAP1.add(Strategy_DOMAIN_FORCE);
    StrategyLib_WAP1.add(Strategy_DOMAIN_FORCE);
    StrategyLib_WAP1.add(Strategy_BACKUPIP);
    StrategyLib_WAP1.add(Strategy_BACKUPIP);
    StrategyLib_WAP1.add(Strategy_DomainProxy_CON);
    StrategyLib_NWAP.add(Strategy_DomainDirect);
    StrategyLib_NWAP.add(Strategy_DomainDirect);
    StrategyLib_NWAP.add(Strategy_DOMAIN_FORCE);
    StrategyLib_NWAP.add(Strategy_DOMAIN_FORCE);
    StrategyLib_NWAP.add(Strategy_BACKUPIP);
    StrategyLib_NWAP.add(Strategy_BACKUPIP);
    StrategyLib_NWAP.add(Strategy_DomainProxy_CON);
    StrategyLib_NWAP.add(Strategy_DomainProxy_SYS);
    mContext = paramContext;
    if (mContext != null) {
      this.mSetting = mContext.getSharedPreferences("download_stragegy_" + getProcessName(mContext), 0);
    }
    loadStrategy();
  }
  
  private boolean checkStrategyValid(DownloadGlobalStrategy.StrategyInfo paramStrategyInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    return paramStrategyInfo != null;
  }
  
  private String getDomainStrategyCacheKey(String paramString1, String paramString2)
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
  
  public static DownloadGlobalStrategy getInstance(Context paramContext)
  {
    if (mInstance == null) {}
    synchronized (INSTANCE_LOCK)
    {
      if (mInstance == null) {
        mInstance = new DownloadGlobalStrategy(paramContext);
      }
      return mInstance;
    }
  }
  
  private String getProcessName(Context paramContext)
  {
    try
    {
      String str = Utils.getCurrentProcessName(paramContext);
      paramContext = str;
      if (str != null)
      {
        paramContext = str;
        if (str.contains(":"))
        {
          int i = str.lastIndexOf(":");
          paramContext = str;
          if (i > 0) {
            paramContext = str.substring(i + 1);
          }
        }
      }
      if (!TextUtils.isEmpty(paramContext)) {
        return paramContext;
      }
      return "";
    }
    catch (Throwable paramContext) {}
    return "";
  }
  
  public static long getRecentIPValidCacheTime()
  {
    return 259200L;
  }
  
  /* Error */
  private void loadStrategy()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mSetting	Landroid/content/SharedPreferences;
    //   6: ifnonnull +4 -> 10
    //   9: return
    //   10: aload_0
    //   11: getfield 82	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mapBestDomainStrategyCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   14: invokevirtual 198	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   17: aload_0
    //   18: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mSetting	Landroid/content/SharedPreferences;
    //   21: ldc 200
    //   23: iconst_1
    //   24: invokeinterface 206 3 0
    //   29: iconst_1
    //   30: if_icmpne +5 -> 35
    //   33: iconst_1
    //   34: istore_1
    //   35: aload_0
    //   36: iload_1
    //   37: putfield 86	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:httpsSupport	Z
    //   40: aload_0
    //   41: aload_0
    //   42: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mSetting	Landroid/content/SharedPreferences;
    //   45: ldc 208
    //   47: invokestatic 213	java/lang/System:currentTimeMillis	()J
    //   50: invokeinterface 217 4 0
    //   55: putfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:httpsSupportTimestamp	J
    //   58: ldc 219
    //   60: ldc 221
    //   62: ldc2_w 222
    //   65: invokestatic 229	com/tencent/component/network/module/base/Config:getConfig	(Ljava/lang/String;Ljava/lang/String;J)J
    //   68: lstore_2
    //   69: invokestatic 213	java/lang/System:currentTimeMillis	()J
    //   72: aload_0
    //   73: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:httpsSupportTimestamp	J
    //   76: lsub
    //   77: lload_2
    //   78: ldc2_w 230
    //   81: lmul
    //   82: lcmp
    //   83: ifle +15 -> 98
    //   86: aload_0
    //   87: iconst_1
    //   88: putfield 86	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:httpsSupport	Z
    //   91: aload_0
    //   92: invokestatic 213	java/lang/System:currentTimeMillis	()J
    //   95: putfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:httpsSupportTimestamp	J
    //   98: aload_0
    //   99: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mSetting	Landroid/content/SharedPreferences;
    //   102: ldc 233
    //   104: aconst_null
    //   105: invokeinterface 236 3 0
    //   110: astore 4
    //   112: aload 4
    //   114: ifnull -105 -> 9
    //   117: aload 4
    //   119: iconst_0
    //   120: invokestatic 242	com/tencent/component/network/utils/Base64:decode	(Ljava/lang/String;I)[B
    //   123: invokestatic 246	com/tencent/component/network/downloader/common/Utils:unmarshall	([B)Landroid/os/Parcel;
    //   126: astore 5
    //   128: aload 5
    //   130: astore 4
    //   132: aload 5
    //   134: aload_0
    //   135: getfield 82	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mapBestDomainStrategyCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   138: getstatic 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mContext	Landroid/content/Context;
    //   141: invokevirtual 250	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   144: invokevirtual 256	android/os/Parcel:readMap	(Ljava/util/Map;Ljava/lang/ClassLoader;)V
    //   147: aload 5
    //   149: ifnull -140 -> 9
    //   152: aload 5
    //   154: invokevirtual 259	android/os/Parcel:recycle	()V
    //   157: return
    //   158: astore 6
    //   160: aconst_null
    //   161: astore 5
    //   163: aload 5
    //   165: astore 4
    //   167: ldc 21
    //   169: ldc_w 260
    //   172: aload 6
    //   174: invokestatic 266	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   177: aload 5
    //   179: ifnull -170 -> 9
    //   182: aload 5
    //   184: invokevirtual 259	android/os/Parcel:recycle	()V
    //   187: return
    //   188: astore 5
    //   190: aconst_null
    //   191: astore 4
    //   193: aload 4
    //   195: ifnull +8 -> 203
    //   198: aload 4
    //   200: invokevirtual 259	android/os/Parcel:recycle	()V
    //   203: aload 5
    //   205: athrow
    //   206: astore 5
    //   208: goto -15 -> 193
    //   211: astore 6
    //   213: goto -50 -> 163
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	DownloadGlobalStrategy
    //   1	36	1	bool	boolean
    //   68	10	2	l	long
    //   110	89	4	localObject1	Object
    //   126	57	5	localParcel	android.os.Parcel
    //   188	16	5	localObject2	Object
    //   206	1	5	localObject3	Object
    //   158	15	6	localThrowable1	Throwable
    //   211	1	6	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   117	128	158	java/lang/Throwable
    //   117	128	188	finally
    //   132	147	206	finally
    //   167	177	206	finally
    //   132	147	211	java/lang/Throwable
  }
  
  public DownloadGlobalStrategy.StrategyInfo getBestStrategyInfo(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      paramString2 = null;
    }
    boolean bool1;
    boolean bool2;
    do
    {
      return paramString2;
      String str = getDomainStrategyCacheKey(paramString2, NetworkManager.getApnValue());
      DownloadGlobalStrategy.StrategyInfo localStrategyInfo = (DownloadGlobalStrategy.StrategyInfo)this.mapBestDomainStrategyCache.get(str);
      paramString1 = localStrategyInfo;
      if (localStrategyInfo != null)
      {
        paramString1 = localStrategyInfo;
        if (!localStrategyInfo.isIPValid())
        {
          this.mapBestDomainStrategyCache.remove(str);
          this.mCacheModifyCount += 1;
          saveStrategy();
          if (QDLog.isInfoEnable()) {
            QDLog.i("DownloadGlobalStrategy", "best strategy invalid! domain:" + paramString2 + " threadId:" + Thread.currentThread().getId());
          }
          paramString1 = null;
        }
      }
      bool1 = ProxyStatistics.getInstance().getAllowProxy();
      bool2 = ProxyStatistics.getInstance().getAPNProxy();
      paramString2 = paramString1;
    } while (checkStrategyValid(paramString1, bool1, bool2));
    return new DownloadGlobalStrategy.StrategyInfo(bool1, bool2, false);
  }
  
  public DownloadGlobalStrategy.StrategyLib getStrategyLib(String paramString1, String paramString2, boolean paramBoolean)
  {
    int j = 80;
    DownloadGlobalStrategy.StrategyLib localStrategyLib = new DownloadGlobalStrategy.StrategyLib(this);
    DownloadGlobalStrategy.StrategyLib.access$402(localStrategyLib, getBestStrategyInfo(paramString1, paramString2));
    int i;
    if (!NetworkManager.isWap())
    {
      DownloadGlobalStrategy.StrategyLib.access$502(localStrategyLib, StrategyLib_NWAP);
      if (!paramBoolean) {
        break label152;
      }
      i = 443;
      label50:
      localStrategyLib.setPort(i);
      if ((DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib) != null) && (DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib).getIPInfo() != null) && (DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib).isIPValid()) && (!TextUtils.isEmpty(DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib).getIPInfo().ip)))
      {
        if (DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib).id != Strategy_BACKUPIP.id) {
          break label252;
        }
        localStrategyLib.setBackupIP(DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib).getIPInfo().ip);
      }
    }
    label152:
    label252:
    do
    {
      return localStrategyLib;
      DownloadGlobalStrategy.StrategyLib.access$502(localStrategyLib, StrategyLib_WAP);
      break;
      i = j;
      if (this.mPortConfig == null) {
        break label50;
      }
      i = j;
      if (!this.mPortConfig.supportExtraPort(paramString2)) {
        break label50;
      }
      i = j;
      if (DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib) == null) {
        break label50;
      }
      i = j;
      if (DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib).getIPInfo() == null) {
        break label50;
      }
      i = j;
      if (!DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib).isIPValid()) {
        break label50;
      }
      int k = DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib).getIPInfo().port;
      i = j;
      if (!Utils.isPortValid(k)) {
        break label50;
      }
      i = k;
      break label50;
      if (DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib).id == Strategy_DOMAIN_FORCE.id)
      {
        localStrategyLib.setDnsIP(DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib).getIPInfo().ip);
        return localStrategyLib;
      }
    } while (DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib).id != Strategy_DomainDirect.id);
    localStrategyLib.setDirectIP(DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib).getIPInfo().ip);
    return localStrategyLib;
  }
  
  public void report(Context paramContext, String paramString1, String paramString2, DownloadGlobalStrategy.StrategyInfo paramStrategyInfo, boolean paramBoolean)
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
          paramString1 = getDomainStrategyCacheKey(paramString2, paramString1);
          paramString2 = (DownloadGlobalStrategy.StrategyInfo)this.mapBestDomainStrategyCache.get(paramString1);
          if (!paramBoolean) {
            break label165;
          }
          if ((!paramStrategyInfo.equals(paramString2)) && (DownloadGlobalStrategy.StrategyInfo.compare(paramStrategyInfo, paramString2) >= 0))
          {
            this.mapBestDomainStrategyCache.put(paramString1, paramStrategyInfo);
            this.mCacheModifyCount += 1;
            saveStrategy();
          }
          if (this.mCacheModifyCount > 0) {
            saveStrategy();
          }
        }
        if ((!paramBoolean) || ((paramStrategyInfo.id != Strategy_DomainProxy_CON.id) && (paramStrategyInfo.id != Strategy_DomainProxy_SYS.id))) {
          continue;
        }
        ProxyStatistics.getInstance().report(paramContext, paramStrategyInfo.allowProxy, paramStrategyInfo.useConfigApn);
        continue;
        if (!paramStrategyInfo.equals(paramString2)) {
          continue;
        }
      }
      finally {}
      label165:
      this.mapBestDomainStrategyCache.remove(paramString1);
      this.mCacheModifyCount += 1;
      saveStrategy();
    }
  }
  
  public void reportHttps(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {}
    for (;;)
    {
      return;
      try
      {
        QDLog.e("DownloadGlobalStrategy", "https download result:" + paramBoolean2 + " failCount:" + this.mHttpsFailCount);
        if (!paramBoolean2)
        {
          this.mHttpsFailCount += 1;
          long l = Config.getConfig("PhotoSvrList", "disable_https_failcount", 6L);
          if ((this.mHttpsFailCount < l) || (!this.httpsSupport)) {
            continue;
          }
          this.httpsSupport = false;
          this.httpsSupportTimestamp = System.currentTimeMillis();
          this.mSetting.edit().putInt("download_support_https", 0);
          this.mSetting.edit().putLong("download_support_https_timestamp", this.httpsSupportTimestamp);
          this.mSetting.edit().commit();
          continue;
        }
      }
      finally {}
      this.mHttpsFailCount = 0;
      if (!this.httpsSupport)
      {
        this.httpsSupport = true;
        this.httpsSupportTimestamp = System.currentTimeMillis();
        this.mSetting.edit().putInt("download_support_https", 1);
        this.mSetting.edit().putLong("download_support_https_timestamp", this.httpsSupportTimestamp);
        this.mSetting.edit().commit();
      }
    }
  }
  
  /* Error */
  public void saveStrategy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mSetting	Landroid/content/SharedPreferences;
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: getfield 90	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mCacheModifyCount	I
    //   13: istore_1
    //   14: iload_1
    //   15: ifne +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: invokestatic 451	com/tencent/component/network/downloader/impl/DownloadTask:getCurrTotalTaskCount	()I
    //   24: ifle +11 -> 35
    //   27: aload_0
    //   28: getfield 90	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mCacheModifyCount	I
    //   31: iconst_5
    //   32: if_icmplt -14 -> 18
    //   35: aload_0
    //   36: iconst_0
    //   37: putfield 90	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mCacheModifyCount	I
    //   40: invokestatic 454	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   43: ifeq +11 -> 54
    //   46: ldc 21
    //   48: ldc_w 456
    //   51: invokestatic 459	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aconst_null
    //   55: astore_3
    //   56: aconst_null
    //   57: astore_2
    //   58: invokestatic 463	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   61: astore 4
    //   63: aload 4
    //   65: astore_2
    //   66: aload 4
    //   68: astore_3
    //   69: aload 4
    //   71: aload_0
    //   72: getfield 82	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mapBestDomainStrategyCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   75: invokevirtual 467	android/os/Parcel:writeMap	(Ljava/util/Map;)V
    //   78: aload 4
    //   80: astore_2
    //   81: aload 4
    //   83: astore_3
    //   84: new 152	java/lang/String
    //   87: dup
    //   88: aload 4
    //   90: invokevirtual 471	android/os/Parcel:marshall	()[B
    //   93: iconst_0
    //   94: invokestatic 475	com/tencent/component/network/utils/Base64:encode	([BI)[B
    //   97: invokespecial 478	java/lang/String:<init>	([B)V
    //   100: astore 5
    //   102: aload 4
    //   104: astore_2
    //   105: aload 4
    //   107: astore_3
    //   108: aload_0
    //   109: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mSetting	Landroid/content/SharedPreferences;
    //   112: invokeinterface 432 1 0
    //   117: ldc 233
    //   119: aload 5
    //   121: invokeinterface 482 3 0
    //   126: invokeinterface 445 1 0
    //   131: pop
    //   132: aload 4
    //   134: ifnull -116 -> 18
    //   137: aload 4
    //   139: invokevirtual 259	android/os/Parcel:recycle	()V
    //   142: goto -124 -> 18
    //   145: astore_2
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_2
    //   149: athrow
    //   150: astore 4
    //   152: aload_2
    //   153: astore_3
    //   154: ldc 21
    //   156: ldc_w 483
    //   159: aload 4
    //   161: invokestatic 266	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   164: aload_2
    //   165: ifnull -147 -> 18
    //   168: aload_2
    //   169: invokevirtual 259	android/os/Parcel:recycle	()V
    //   172: goto -154 -> 18
    //   175: astore_2
    //   176: aload_3
    //   177: ifnull +7 -> 184
    //   180: aload_3
    //   181: invokevirtual 259	android/os/Parcel:recycle	()V
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
    //   150	10	4	localThrowable	Throwable
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
    //   58	63	150	java/lang/Throwable
    //   69	78	150	java/lang/Throwable
    //   84	102	150	java/lang/Throwable
    //   108	132	150	java/lang/Throwable
    //   58	63	175	finally
    //   69	78	175	finally
    //   84	102	175	finally
    //   108	132	175	finally
    //   154	164	175	finally
  }
  
  public boolean supportHttps()
  {
    return this.httpsSupport;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy
 * JD-Core Version:    0.7.0.1
 */