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
    paramContext = mContext;
    if (paramContext != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("download_stragegy_");
      localStringBuilder.append(getProcessName(mContext));
      this.mSetting = paramContext.getSharedPreferences(localStringBuilder.toString(), 0);
    }
    loadStrategy();
  }
  
  private boolean checkStrategyValid(DownloadGlobalStrategy.StrategyInfo paramStrategyInfo, boolean paramBoolean1, boolean paramBoolean2)
  {
    return paramStrategyInfo != null;
  }
  
  private String getDomainStrategyCacheKey(String paramString1, String paramString2)
  {
    boolean bool = "wifi".equals(paramString2);
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (bool)
    {
      localObject1 = NetworkManager.getBSSID();
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = localObject2;
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("_");
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject1 = ((StringBuilder)localObject2).toString();
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString1);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(paramString2);
    ((StringBuilder)localObject2).append((String)localObject1);
    return ((StringBuilder)localObject2).toString();
  }
  
  public static DownloadGlobalStrategy getInstance(Context paramContext)
  {
    if (mInstance == null) {
      synchronized (INSTANCE_LOCK)
      {
        if (mInstance == null) {
          mInstance = new DownloadGlobalStrategy(paramContext);
        }
      }
    }
    return mInstance;
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
      boolean bool = TextUtils.isEmpty(paramContext);
      if (!bool) {
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
    //   0: aload_0
    //   1: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mSetting	Landroid/content/SharedPreferences;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 82	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mapBestDomainStrategyCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   12: invokevirtual 198	java/util/concurrent/ConcurrentHashMap:clear	()V
    //   15: aload_0
    //   16: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mSetting	Landroid/content/SharedPreferences;
    //   19: ldc 200
    //   21: iconst_1
    //   22: invokeinterface 206 3 0
    //   27: iconst_1
    //   28: if_icmpne +8 -> 36
    //   31: iconst_1
    //   32: istore_1
    //   33: goto +5 -> 38
    //   36: iconst_0
    //   37: istore_1
    //   38: aload_0
    //   39: iload_1
    //   40: putfield 86	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:httpsSupport	Z
    //   43: aload_0
    //   44: aload_0
    //   45: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mSetting	Landroid/content/SharedPreferences;
    //   48: ldc 208
    //   50: invokestatic 213	java/lang/System:currentTimeMillis	()J
    //   53: invokeinterface 217 4 0
    //   58: putfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:httpsSupportTimestamp	J
    //   61: ldc 219
    //   63: ldc 221
    //   65: ldc2_w 222
    //   68: invokestatic 229	com/tencent/component/network/module/base/Config:getConfig	(Ljava/lang/String;Ljava/lang/String;J)J
    //   71: lstore_2
    //   72: invokestatic 213	java/lang/System:currentTimeMillis	()J
    //   75: aload_0
    //   76: getfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:httpsSupportTimestamp	J
    //   79: lsub
    //   80: lload_2
    //   81: ldc2_w 230
    //   84: lmul
    //   85: lcmp
    //   86: ifle +15 -> 101
    //   89: aload_0
    //   90: iconst_1
    //   91: putfield 86	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:httpsSupport	Z
    //   94: aload_0
    //   95: invokestatic 213	java/lang/System:currentTimeMillis	()J
    //   98: putfield 88	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:httpsSupportTimestamp	J
    //   101: aload_0
    //   102: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mSetting	Landroid/content/SharedPreferences;
    //   105: astore 6
    //   107: aconst_null
    //   108: astore 4
    //   110: aconst_null
    //   111: astore 5
    //   113: aload 6
    //   115: ldc 233
    //   117: aconst_null
    //   118: invokeinterface 236 3 0
    //   123: astore 6
    //   125: aload 6
    //   127: ifnull +94 -> 221
    //   130: aload 6
    //   132: iconst_0
    //   133: invokestatic 242	com/tencent/component/network/utils/Base64:decode	(Ljava/lang/String;I)[B
    //   136: invokestatic 246	com/tencent/component/network/downloader/common/Utils:unmarshall	([B)Landroid/os/Parcel;
    //   139: astore 6
    //   141: aload 6
    //   143: astore 5
    //   145: aload 6
    //   147: astore 4
    //   149: aload 6
    //   151: aload_0
    //   152: getfield 82	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mapBestDomainStrategyCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   155: getstatic 108	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mContext	Landroid/content/Context;
    //   158: invokevirtual 250	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   161: invokevirtual 256	android/os/Parcel:readMap	(Ljava/util/Map;Ljava/lang/ClassLoader;)V
    //   164: aload 6
    //   166: ifnull +55 -> 221
    //   169: aload 6
    //   171: astore 4
    //   173: goto +29 -> 202
    //   176: astore 4
    //   178: goto +30 -> 208
    //   181: astore 6
    //   183: aload 4
    //   185: astore 5
    //   187: ldc 21
    //   189: ldc_w 257
    //   192: aload 6
    //   194: invokestatic 263	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   197: aload 4
    //   199: ifnull +22 -> 221
    //   202: aload 4
    //   204: invokevirtual 266	android/os/Parcel:recycle	()V
    //   207: return
    //   208: aload 5
    //   210: ifnull +8 -> 218
    //   213: aload 5
    //   215: invokevirtual 266	android/os/Parcel:recycle	()V
    //   218: aload 4
    //   220: athrow
    //   221: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	222	0	this	DownloadGlobalStrategy
    //   32	8	1	bool	boolean
    //   71	10	2	l	long
    //   108	64	4	localObject1	Object
    //   176	43	4	localObject2	Object
    //   111	103	5	localObject3	Object
    //   105	65	6	localObject4	Object
    //   181	12	6	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   130	141	176	finally
    //   149	164	176	finally
    //   187	197	176	finally
    //   130	141	181	java/lang/Throwable
    //   149	164	181	java/lang/Throwable
  }
  
  public DownloadGlobalStrategy.StrategyInfo getBestStrategyInfo(String paramString1, String paramString2)
  {
    boolean bool1 = TextUtils.isEmpty(paramString1);
    Object localObject1 = null;
    Object localObject2 = null;
    if (!bool1)
    {
      if (TextUtils.isEmpty(paramString2)) {
        return null;
      }
      localObject1 = getDomainStrategyCacheKey(paramString2, NetworkManager.getApnValue());
      paramString1 = (DownloadGlobalStrategy.StrategyInfo)this.mapBestDomainStrategyCache.get(localObject1);
      if ((paramString1 != null) && (!paramString1.isIPValid()))
      {
        this.mapBestDomainStrategyCache.remove(localObject1);
        this.mCacheModifyCount += 1;
        saveStrategy();
        paramString1 = localObject2;
        if (QDLog.isInfoEnable())
        {
          paramString1 = new StringBuilder();
          paramString1.append("best strategy invalid! domain:");
          paramString1.append(paramString2);
          paramString1.append(" threadId:");
          paramString1.append(Thread.currentThread().getId());
          QDLog.i("DownloadGlobalStrategy", paramString1.toString());
          paramString1 = localObject2;
        }
      }
      bool1 = ProxyStatistics.getInstance().getAllowProxy();
      boolean bool2 = ProxyStatistics.getInstance().getAPNProxy();
      localObject1 = paramString1;
      if (!checkStrategyValid(paramString1, bool1, bool2)) {
        localObject1 = new DownloadGlobalStrategy.StrategyInfo(bool1, bool2, false);
      }
    }
    return localObject1;
  }
  
  public DownloadGlobalStrategy.StrategyLib getStrategyLib(String paramString1, String paramString2, boolean paramBoolean)
  {
    DownloadGlobalStrategy.StrategyLib localStrategyLib = new DownloadGlobalStrategy.StrategyLib(this);
    DownloadGlobalStrategy.StrategyLib.access$402(localStrategyLib, getBestStrategyInfo(paramString1, paramString2));
    if (!NetworkManager.isWap()) {
      DownloadGlobalStrategy.StrategyLib.access$502(localStrategyLib, StrategyLib_NWAP);
    } else {
      DownloadGlobalStrategy.StrategyLib.access$502(localStrategyLib, StrategyLib_WAP);
    }
    int j = 80;
    int i;
    if (paramBoolean)
    {
      i = 443;
    }
    else
    {
      paramString1 = this.mPortConfig;
      i = j;
      if (paramString1 != null)
      {
        i = j;
        if (paramString1.supportExtraPort(paramString2))
        {
          i = j;
          if (DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib) != null)
          {
            i = j;
            if (DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib).getIPInfo() != null)
            {
              i = j;
              if (DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib).isIPValid())
              {
                i = DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib).getIPInfo().port;
                if (!Utils.isPortValid(i)) {
                  i = j;
                }
              }
            }
          }
        }
      }
    }
    localStrategyLib.setPort(i);
    if ((DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib) != null) && (DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib).getIPInfo() != null) && (DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib).isIPValid()) && (!TextUtils.isEmpty(DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib).getIPInfo().ip)))
    {
      if (DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib).id == Strategy_BACKUPIP.id)
      {
        localStrategyLib.setBackupIP(DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib).getIPInfo().ip);
        return localStrategyLib;
      }
      if (DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib).id == Strategy_DOMAIN_FORCE.id)
      {
        localStrategyLib.setDnsIP(DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib).getIPInfo().ip);
        return localStrategyLib;
      }
      if (DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib).id == Strategy_DomainDirect.id) {
        localStrategyLib.setDirectIP(DownloadGlobalStrategy.StrategyLib.access$400(localStrategyLib).getIPInfo().ip);
      }
    }
    return localStrategyLib;
  }
  
  public void report(Context paramContext, String paramString1, String paramString2, DownloadGlobalStrategy.StrategyInfo paramStrategyInfo, boolean paramBoolean)
  {
    try
    {
      if ((!TextUtils.isEmpty(paramString1)) && (paramStrategyInfo != null))
      {
        paramString1 = NetworkManager.getApnValue();
        if (paramString2 != null)
        {
          paramString1 = getDomainStrategyCacheKey(paramString2, paramString1);
          paramString2 = (DownloadGlobalStrategy.StrategyInfo)this.mapBestDomainStrategyCache.get(paramString1);
          if (paramBoolean)
          {
            if ((!paramStrategyInfo.equals(paramString2)) && (DownloadGlobalStrategy.StrategyInfo.compare(paramStrategyInfo, paramString2) >= 0))
            {
              this.mapBestDomainStrategyCache.put(paramString1, paramStrategyInfo);
              this.mCacheModifyCount += 1;
              saveStrategy();
            }
          }
          else if (paramStrategyInfo.equals(paramString2))
          {
            this.mapBestDomainStrategyCache.remove(paramString1);
            this.mCacheModifyCount += 1;
            saveStrategy();
          }
          if (this.mCacheModifyCount > 0) {
            saveStrategy();
          }
        }
        if ((paramBoolean) && ((paramStrategyInfo.id == Strategy_DomainProxy_CON.id) || (paramStrategyInfo.id == Strategy_DomainProxy_SYS.id))) {
          ProxyStatistics.getInstance().report(paramContext, paramStrategyInfo.allowProxy, paramStrategyInfo.useConfigApn);
        }
        return;
      }
      return;
    }
    finally {}
  }
  
  public void reportHttps(String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1) {
      return;
    }
    try
    {
      paramString = new StringBuilder();
      paramString.append("https download result:");
      paramString.append(paramBoolean2);
      paramString.append(" failCount:");
      paramString.append(this.mHttpsFailCount);
      QDLog.e("DownloadGlobalStrategy", paramString.toString());
      if (!paramBoolean2)
      {
        this.mHttpsFailCount += 1;
        long l = Config.getConfig("PhotoSvrList", "disable_https_failcount", 6L);
        if ((this.mHttpsFailCount >= l) && (this.httpsSupport))
        {
          this.httpsSupport = false;
          this.httpsSupportTimestamp = System.currentTimeMillis();
          this.mSetting.edit().putInt("download_support_https", 0);
          this.mSetting.edit().putLong("download_support_https_timestamp", this.httpsSupportTimestamp);
          this.mSetting.edit().commit();
        }
      }
      else
      {
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
      return;
    }
    finally {}
  }
  
  /* Error */
  public void saveStrategy()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mSetting	Landroid/content/SharedPreferences;
    //   6: ifnull +182 -> 188
    //   9: aload_0
    //   10: getfield 90	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mCacheModifyCount	I
    //   13: ifne +6 -> 19
    //   16: goto +172 -> 188
    //   19: invokestatic 451	com/tencent/component/network/downloader/impl/DownloadTask:getCurrTotalTaskCount	()I
    //   22: ifle +16 -> 38
    //   25: aload_0
    //   26: getfield 90	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mCacheModifyCount	I
    //   29: istore_1
    //   30: iload_1
    //   31: iconst_5
    //   32: if_icmpge +6 -> 38
    //   35: aload_0
    //   36: monitorexit
    //   37: return
    //   38: aload_0
    //   39: iconst_0
    //   40: putfield 90	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mCacheModifyCount	I
    //   43: invokestatic 454	com/tencent/component/network/module/base/QDLog:isDebugEnable	()Z
    //   46: ifeq +11 -> 57
    //   49: ldc 21
    //   51: ldc_w 456
    //   54: invokestatic 459	com/tencent/component/network/module/base/QDLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: aconst_null
    //   58: astore_2
    //   59: aconst_null
    //   60: astore_3
    //   61: invokestatic 463	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   64: astore 4
    //   66: aload 4
    //   68: astore_3
    //   69: aload 4
    //   71: astore_2
    //   72: aload 4
    //   74: aload_0
    //   75: getfield 82	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mapBestDomainStrategyCache	Ljava/util/concurrent/ConcurrentHashMap;
    //   78: invokevirtual 467	android/os/Parcel:writeMap	(Ljava/util/Map;)V
    //   81: aload 4
    //   83: astore_3
    //   84: aload 4
    //   86: astore_2
    //   87: new 150	java/lang/String
    //   90: dup
    //   91: aload 4
    //   93: invokevirtual 471	android/os/Parcel:marshall	()[B
    //   96: iconst_0
    //   97: invokestatic 475	com/tencent/component/network/utils/Base64:encode	([BI)[B
    //   100: invokespecial 478	java/lang/String:<init>	([B)V
    //   103: astore 5
    //   105: aload 4
    //   107: astore_3
    //   108: aload 4
    //   110: astore_2
    //   111: aload_0
    //   112: getfield 133	com/tencent/component/network/downloader/strategy/DownloadGlobalStrategy:mSetting	Landroid/content/SharedPreferences;
    //   115: invokeinterface 432 1 0
    //   120: ldc 233
    //   122: aload 5
    //   124: invokeinterface 482 3 0
    //   129: invokeinterface 445 1 0
    //   134: pop
    //   135: aload 4
    //   137: ifnull +38 -> 175
    //   140: aload 4
    //   142: astore_2
    //   143: aload_2
    //   144: invokevirtual 266	android/os/Parcel:recycle	()V
    //   147: goto +28 -> 175
    //   150: astore_2
    //   151: goto +27 -> 178
    //   154: astore 4
    //   156: aload_2
    //   157: astore_3
    //   158: ldc 21
    //   160: ldc_w 483
    //   163: aload 4
    //   165: invokestatic 263	com/tencent/component/network/module/base/QDLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   168: aload_2
    //   169: ifnull +6 -> 175
    //   172: goto -29 -> 143
    //   175: aload_0
    //   176: monitorexit
    //   177: return
    //   178: aload_3
    //   179: ifnull +7 -> 186
    //   182: aload_3
    //   183: invokevirtual 266	android/os/Parcel:recycle	()V
    //   186: aload_2
    //   187: athrow
    //   188: aload_0
    //   189: monitorexit
    //   190: return
    //   191: astore_2
    //   192: aload_0
    //   193: monitorexit
    //   194: goto +5 -> 199
    //   197: aload_2
    //   198: athrow
    //   199: goto -2 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	DownloadGlobalStrategy
    //   29	4	1	i	int
    //   58	86	2	localObject1	Object
    //   150	37	2	localObject2	Object
    //   191	7	2	localObject3	Object
    //   60	123	3	localObject4	Object
    //   64	77	4	localParcel	android.os.Parcel
    //   154	10	4	localThrowable	Throwable
    //   103	20	5	str	String
    // Exception table:
    //   from	to	target	type
    //   61	66	150	finally
    //   72	81	150	finally
    //   87	105	150	finally
    //   111	135	150	finally
    //   158	168	150	finally
    //   61	66	154	java/lang/Throwable
    //   72	81	154	java/lang/Throwable
    //   87	105	154	java/lang/Throwable
    //   111	135	154	java/lang/Throwable
    //   2	16	191	finally
    //   19	30	191	finally
    //   38	57	191	finally
    //   143	147	191	finally
    //   182	186	191	finally
    //   186	188	191	finally
  }
  
  public boolean supportHttps()
  {
    return this.httpsSupport;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.downloader.strategy.DownloadGlobalStrategy
 * JD-Core Version:    0.7.0.1
 */