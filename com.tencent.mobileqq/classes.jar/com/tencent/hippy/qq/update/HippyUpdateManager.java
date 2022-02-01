package com.tencent.hippy.qq.update;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.TrpcProxy.TrpcInovkeRsp;
import com.tencent.hippy.qq.api.HippyConfig;
import com.tencent.hippy.qq.api.IHippyUtils;
import com.tencent.hippy.qq.api.IUpdateListener;
import com.tencent.hippy.qq.api.TabFile;
import com.tencent.hippy.qq.update.config.TabPreloadConfigManager;
import com.tencent.hippy.qq.update.sso.HippyUnissoHandler;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.AbsPreDownloadTask;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.transfile.predownload.RunnableTask;
import com.tencent.mobileqq.vas.download.api.IDownloaderFactory;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.CommonMobileConfQueryRsp;
import com.tencent.trpcprotocol.gamecenter.mobileConfSvr.mobileConfSvr.MobileConfRsp;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import mqq.util.WeakReference;
import org.json.JSONArray;
import org.json.JSONObject;

public class HippyUpdateManager
  extends DownloadListener
  implements Manager
{
  public static final int DEFAULT_MAX_FAILED_CNT = 2;
  public static final long DEFAULT_PRELOAD_HIPPY_INTERVAL = 600L;
  public static final long DEFAULT_UPDATE_HIPPY_INTERVAL = 120L;
  public static final String GAME_CENTER_SHARED_PREFERECE_NAME = "game_center_sp";
  public static final String HIPPY_DOWNLOADER_BUSINESSCODE = "gamecenter_hippy";
  public static final String KEY_DOWNLOAD_FAILED_URLS = "key_download_failed_urls";
  public static final String KEY_HIPPY_CONFIG = "key_hippy_config";
  public static final String KEY_LAST_PRELOAD_HIPPY_TIMESTAMP = "key_last_preload_hippy_timestamp";
  public static final String KEY_PREDOWNLOAD_HIPPY = "preDownloadHippyKey";
  public static final String KEY_PRELOAD_HIPPY_INTERVAL = "key_preload_hippy_interval";
  public static final String KEY_TAB_FILES = "key_tab_files";
  public static final String KEY_UNZIP_FAILED_URLS = "key_unzip_failed_urls";
  public static final String PREFIX = "hippyUpdateAction-";
  public static final int SERVER_STATUS_CODE_NO_UPDATE = 2;
  public static final int SERVER_STATUS_CODE_SUCCESS = 1;
  public static final String TAG;
  public static final int UPDATE_JS_BUNDLE_TYPE_PRELODAD = 1;
  public static final int UPDATE_JS_BUNDLE_TYPE_SINGLE = 2;
  private static int mCurRequestId = 0;
  private static volatile HippyUpdateManager sHippyUpdateManager;
  private Map<String, HippyUpdateManager.BundleInfo> mBundleInfos = new HashMap();
  private String mCurrentUin;
  private Map<String, Integer> mDownFailedUrls;
  private DownloaderInterface mDownloader;
  private HippyConfig mHippyConfig;
  private HashMap<String, Long> mJsBundleLastUpdateTimes = new HashMap();
  private HashMap<String, ArrayList<IUpdateListener>> mJsBundleUpdateListeners = new HashMap();
  private long mLastPreloadTimeStamp = 0L;
  private List<WeakReference<IUpdateListener>> mListeners = new ArrayList();
  private long mPreloadInterval = 600L;
  private Map<String, TabFile> mTabFiles;
  TabPreloadConfigManager mTabPreloadConfigManager;
  private List<String> mUnzipFailedUrls;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hippyUpdateAction-");
    localStringBuilder.append(HippyUpdateManager.class.getSimpleName());
    TAG = localStringBuilder.toString();
  }
  
  private HippyUpdateManager()
  {
    initData();
  }
  
  private boolean checkPreDownloadInterval()
  {
    this.mLastPreloadTimeStamp = getLastPreloadDownTimeStamp();
    boolean bool;
    if (NetConnInfoCenter.getServerTime() - this.mLastPreloadTimeStamp / 1000L < this.mPreloadInterval) {
      bool = false;
    } else {
      bool = true;
    }
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[checkPreloadInterval] ret=");
      localStringBuilder.append(bool);
      localStringBuilder.append(",mLastPreloadTimeStamploc = ");
      localStringBuilder.append(this.mLastPreloadTimeStamp / 1000L);
      localStringBuilder.append(", interval = ");
      localStringBuilder.append(this.mPreloadInterval);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    return bool;
  }
  
  private void doDownloadBundle(HippyUpdateManager.BundleInfo paramBundleInfo, int paramInt)
  {
    if ((paramBundleInfo != null) && (!TextUtils.isEmpty(paramBundleInfo.downloadUrl)))
    {
      if (QLog.isColorLevel())
      {
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[doDownloadBundle] download bundle:");
        ((StringBuilder)localObject2).append(paramBundleInfo.toString());
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      Object localObject1 = this.mDownFailedUrls;
      if ((localObject1 != null) && (((Map)localObject1).containsKey(paramBundleInfo.downloadUrl)) && (((Integer)this.mDownFailedUrls.get(paramBundleInfo.downloadUrl)).intValue() > paramBundleInfo.maxFailedCnt))
      {
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[doDownloadBundle]currentFailedCnt:");
        ((StringBuilder)localObject2).append(this.mDownFailedUrls.get(paramBundleInfo.downloadUrl));
        ((StringBuilder)localObject2).append(", url:");
        ((StringBuilder)localObject2).append(paramBundleInfo.downloadUrl);
        QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        notifyUpdateStatus(mCurRequestId, -5, paramBundleInfo.bundleName, paramInt);
        return;
      }
      localObject1 = this.mUnzipFailedUrls;
      if ((localObject1 != null) && (((List)localObject1).contains(paramBundleInfo.downloadUrl)))
      {
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[doDownloadBundle]ever uinzip failed:, url:");
        ((StringBuilder)localObject2).append(paramBundleInfo.downloadUrl);
        QLog.e((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        notifyUpdateStatus(mCurRequestId, -6, paramBundleInfo.bundleName, paramInt);
        return;
      }
      if (UpdateSetting.getInstance().isModuleVersionFileExists(paramBundleInfo.bundleName, paramBundleInfo.bundleVersion))
      {
        localObject1 = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[doDownloadBundle]file exist:");
        ((StringBuilder)localObject2).append(paramBundleInfo.bundleName);
        ((StringBuilder)localObject2).append(",ver: ");
        ((StringBuilder)localObject2).append(paramBundleInfo.bundleVersion);
        QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        notifyUpdateStatus(mCurRequestId, 1, paramBundleInfo.bundleName, paramInt);
        return;
      }
      localObject1 = HippyQQFileUtil.getZipFile(paramBundleInfo.bundleName, paramBundleInfo.bundleVersion);
      localObject1 = new DownloadTask(paramBundleInfo.downloadUrl, (File)localObject1);
      ((DownloadTask)localObject1).p = true;
      ((DownloadTask)localObject1).n = true;
      ((DownloadTask)localObject1).f = "gamecenter_hippy";
      ((DownloadTask)localObject1).b = 0;
      ((DownloadTask)localObject1).q = true;
      ((DownloadTask)localObject1).r = true;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramBundleInfo.bundleName);
      ((StringBuilder)localObject2).append(paramBundleInfo.bundleVersion);
      ((DownloadTask)localObject1).jdField_a_of_type_JavaLangString = ((StringBuilder)localObject2).toString();
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("bundleName", paramBundleInfo.bundleName);
      ((Bundle)localObject2).putInt("bundleVersion", paramBundleInfo.bundleVersion);
      ((Bundle)localObject2).putString("bundleMd5", paramBundleInfo.bundleMd5);
      ((Bundle)localObject2).putInt("source", paramInt);
      if (this.mDownloader == null) {
        this.mDownloader = ((IDownloaderFactory)QRoute.api(IDownloaderFactory.class)).getDownloader(5);
      }
      this.mDownloader.startDownload((DownloadTask)localObject1, this, (Bundle)localObject2);
      return;
    }
    QLog.i(TAG, 1, "[doDownloadBundle] info or downloadUrl is null, return.");
  }
  
  /* Error */
  private void downloadJsBundleImmediately(Intent paramIntent, HippyUpdateManager.BundleInfo paramBundleInfo)
  {
    // Byte code:
    //   0: aload_2
    //   1: getfield 227	com/tencent/hippy/qq/update/HippyUpdateManager$BundleInfo:bundleName	Ljava/lang/String;
    //   4: aload_2
    //   5: getfield 249	com/tencent/hippy/qq/update/HippyUpdateManager$BundleInfo:bundleVersion	I
    //   8: invokestatic 269	com/tencent/hippy/qq/update/HippyQQFileUtil:getZipFile	(Ljava/lang/String;I)Ljava/io/File;
    //   11: astore 4
    //   13: new 271	com/tencent/mobileqq/vip/DownloadTask
    //   16: dup
    //   17: aload_2
    //   18: getfield 182	com/tencent/hippy/qq/update/HippyUpdateManager$BundleInfo:downloadUrl	Ljava/lang/String;
    //   21: aload 4
    //   23: invokespecial 274	com/tencent/mobileqq/vip/DownloadTask:<init>	(Ljava/lang/String;Ljava/io/File;)V
    //   26: astore 5
    //   28: aload 5
    //   30: iconst_1
    //   31: putfield 278	com/tencent/mobileqq/vip/DownloadTask:p	Z
    //   34: aload 5
    //   36: iconst_1
    //   37: putfield 281	com/tencent/mobileqq/vip/DownloadTask:n	Z
    //   40: aload 5
    //   42: iconst_2
    //   43: putfield 287	com/tencent/mobileqq/vip/DownloadTask:b	I
    //   46: aload 5
    //   48: iconst_1
    //   49: putfield 290	com/tencent/mobileqq/vip/DownloadTask:q	Z
    //   52: aload 5
    //   54: iconst_1
    //   55: putfield 293	com/tencent/mobileqq/vip/DownloadTask:r	Z
    //   58: ldc_w 319
    //   61: invokestatic 325	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   64: checkcast 319	com/tencent/mobileqq/vas/download/api/IDownloaderFactory
    //   67: aload 5
    //   69: getstatic 347	mqq/app/MobileQQ:sMobileQQ	Lmqq/app/MobileQQ;
    //   72: aconst_null
    //   73: invokevirtual 351	mqq/app/MobileQQ:waitAppRuntime	(Lmqq/app/BaseActivity;)Lmqq/app/AppRuntime;
    //   76: invokeinterface 355 3 0
    //   81: ifne +327 -> 408
    //   84: aload 4
    //   86: invokevirtual 360	java/io/File:exists	()Z
    //   89: ifeq +319 -> 408
    //   92: aload 4
    //   94: invokevirtual 363	java/io/File:length	()J
    //   97: lconst_0
    //   98: lcmp
    //   99: ifgt +6 -> 105
    //   102: goto +306 -> 408
    //   105: aload 4
    //   107: invokevirtual 366	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   110: invokestatic 372	com/tencent/hippy/qq/update/sign/MD5:getFileMd5	(Ljava/lang/String;)Ljava/lang/String;
    //   113: astore 5
    //   115: aload 5
    //   117: ifnull +15 -> 132
    //   120: aload 5
    //   122: aload_2
    //   123: getfield 313	com/tencent/hippy/qq/update/HippyUpdateManager$BundleInfo:bundleMd5	Ljava/lang/String;
    //   126: invokevirtual 377	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   129: ifne +15 -> 144
    //   132: aload_0
    //   133: aload_1
    //   134: aload_2
    //   135: getfield 227	com/tencent/hippy/qq/update/HippyUpdateManager$BundleInfo:bundleName	Ljava/lang/String;
    //   138: bipush 253
    //   140: aconst_null
    //   141: invokespecial 135	com/tencent/hippy/qq/update/HippyUpdateManager:notifyJsBundleUpdate	(Landroid/content/Intent;Ljava/lang/String;ILjava/lang/String;)V
    //   144: aload 4
    //   146: aload_2
    //   147: getfield 227	com/tencent/hippy/qq/update/HippyUpdateManager$BundleInfo:bundleName	Ljava/lang/String;
    //   150: aload_2
    //   151: getfield 249	com/tencent/hippy/qq/update/HippyUpdateManager$BundleInfo:bundleVersion	I
    //   154: invokestatic 381	com/tencent/hippy/qq/update/HippyQQFileUtil:unzipModulePackage	(Ljava/io/File;Ljava/lang/String;I)Z
    //   157: ifeq +62 -> 219
    //   160: invokestatic 246	com/tencent/hippy/qq/update/UpdateSetting:getInstance	()Lcom/tencent/hippy/qq/update/UpdateSetting;
    //   163: aload_2
    //   164: getfield 227	com/tencent/hippy/qq/update/HippyUpdateManager$BundleInfo:bundleName	Ljava/lang/String;
    //   167: aload_2
    //   168: getfield 249	com/tencent/hippy/qq/update/HippyUpdateManager$BundleInfo:bundleVersion	I
    //   171: invokevirtual 384	com/tencent/hippy/qq/update/UpdateSetting:setModuleVersion	(Ljava/lang/String;I)V
    //   174: aload_2
    //   175: getfield 227	com/tencent/hippy/qq/update/HippyUpdateManager$BundleInfo:bundleName	Ljava/lang/String;
    //   178: astore 5
    //   180: iconst_0
    //   181: istore_3
    //   182: aload_0
    //   183: aload_1
    //   184: aload 5
    //   186: iconst_0
    //   187: aconst_null
    //   188: invokespecial 135	com/tencent/hippy/qq/update/HippyUpdateManager:notifyJsBundleUpdate	(Landroid/content/Intent;Ljava/lang/String;ILjava/lang/String;)V
    //   191: aload_1
    //   192: ifnull +12 -> 204
    //   195: aload_1
    //   196: ldc_w 386
    //   199: iconst_0
    //   200: invokevirtual 392	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   203: istore_3
    //   204: iload_3
    //   205: ifle +25 -> 230
    //   208: aload_2
    //   209: getfield 227	com/tencent/hippy/qq/update/HippyUpdateManager$BundleInfo:bundleName	Ljava/lang/String;
    //   212: iload_3
    //   213: invokestatic 395	com/tencent/hippy/qq/update/HippyQQFileUtil:cleanHistoryVersion	(Ljava/lang/String;I)V
    //   216: goto +14 -> 230
    //   219: aload_0
    //   220: aload_1
    //   221: aload_2
    //   222: getfield 227	com/tencent/hippy/qq/update/HippyUpdateManager$BundleInfo:bundleName	Ljava/lang/String;
    //   225: iconst_m1
    //   226: aconst_null
    //   227: invokespecial 135	com/tencent/hippy/qq/update/HippyUpdateManager:notifyJsBundleUpdate	(Landroid/content/Intent;Ljava/lang/String;ILjava/lang/String;)V
    //   230: aload 4
    //   232: invokevirtual 398	java/io/File:delete	()Z
    //   235: pop
    //   236: return
    //   237: astore_2
    //   238: getstatic 104	com/tencent/hippy/qq/update/HippyUpdateManager:TAG	Ljava/lang/String;
    //   241: astore 4
    //   243: new 86	java/lang/StringBuilder
    //   246: dup
    //   247: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   250: astore_1
    //   251: aload_1
    //   252: ldc_w 400
    //   255: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: aload_1
    //   260: aload_2
    //   261: invokevirtual 401	java/lang/Exception:toString	()Ljava/lang/String;
    //   264: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload 4
    //   270: iconst_1
    //   271: aload_1
    //   272: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokestatic 224	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   278: return
    //   279: astore_1
    //   280: goto +72 -> 352
    //   283: astore 5
    //   285: aload_2
    //   286: getfield 227	com/tencent/hippy/qq/update/HippyUpdateManager$BundleInfo:bundleName	Ljava/lang/String;
    //   289: astore_2
    //   290: new 86	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   297: astore 6
    //   299: aload 6
    //   301: ldc_w 403
    //   304: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload 6
    //   310: aload 5
    //   312: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload_0
    //   317: aload_1
    //   318: aload_2
    //   319: iconst_m1
    //   320: aload 6
    //   322: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokespecial 135	com/tencent/hippy/qq/update/HippyUpdateManager:notifyJsBundleUpdate	(Landroid/content/Intent;Ljava/lang/String;ILjava/lang/String;)V
    //   328: aload 4
    //   330: invokevirtual 398	java/io/File:delete	()Z
    //   333: pop
    //   334: return
    //   335: astore_2
    //   336: getstatic 104	com/tencent/hippy/qq/update/HippyUpdateManager:TAG	Ljava/lang/String;
    //   339: astore 4
    //   341: new 86	java/lang/StringBuilder
    //   344: dup
    //   345: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   348: astore_1
    //   349: goto -98 -> 251
    //   352: aload 4
    //   354: invokevirtual 398	java/io/File:delete	()Z
    //   357: pop
    //   358: goto +48 -> 406
    //   361: astore_2
    //   362: getstatic 104	com/tencent/hippy/qq/update/HippyUpdateManager:TAG	Ljava/lang/String;
    //   365: astore 4
    //   367: new 86	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   374: astore 5
    //   376: aload 5
    //   378: ldc_w 400
    //   381: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: pop
    //   385: aload 5
    //   387: aload_2
    //   388: invokevirtual 401	java/lang/Exception:toString	()Ljava/lang/String;
    //   391: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: pop
    //   395: aload 4
    //   397: iconst_1
    //   398: aload 5
    //   400: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 224	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: aload_1
    //   407: athrow
    //   408: aload_0
    //   409: aload_1
    //   410: aload_2
    //   411: getfield 227	com/tencent/hippy/qq/update/HippyUpdateManager$BundleInfo:bundleName	Ljava/lang/String;
    //   414: bipush 252
    //   416: aconst_null
    //   417: invokespecial 135	com/tencent/hippy/qq/update/HippyUpdateManager:notifyJsBundleUpdate	(Landroid/content/Intent;Ljava/lang/String;ILjava/lang/String;)V
    //   420: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	421	0	this	HippyUpdateManager
    //   0	421	1	paramIntent	Intent
    //   0	421	2	paramBundleInfo	HippyUpdateManager.BundleInfo
    //   181	32	3	i	int
    //   11	385	4	localObject1	Object
    //   26	159	5	localObject2	Object
    //   283	28	5	localThrowable	Throwable
    //   374	25	5	localStringBuilder1	StringBuilder
    //   297	24	6	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   230	236	237	java/lang/Exception
    //   144	180	279	finally
    //   182	191	279	finally
    //   195	204	279	finally
    //   208	216	279	finally
    //   219	230	279	finally
    //   285	328	279	finally
    //   144	180	283	java/lang/Throwable
    //   182	191	283	java/lang/Throwable
    //   195	204	283	java/lang/Throwable
    //   208	216	283	java/lang/Throwable
    //   219	230	283	java/lang/Throwable
    //   328	334	335	java/lang/Exception
    //   352	358	361	java/lang/Exception
  }
  
  private String getCurrentUin()
  {
    AppInterface localAppInterface = ((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface();
    if (localAppInterface != null) {
      return localAppInterface.getCurrentAccountUin();
    }
    return "";
  }
  
  public static HippyUpdateManager getInstance()
  {
    if (sHippyUpdateManager == null) {
      try
      {
        if (sHippyUpdateManager == null) {
          sHippyUpdateManager = new HippyUpdateManager();
        }
      }
      finally {}
    }
    return sHippyUpdateManager;
  }
  
  public static SharedPreferences getSharedPreferences()
  {
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    return MobileQQ.getContext().getSharedPreferences("game_center_sp", 4);
  }
  
  private void handleHippyConfig(Intent paramIntent, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp, String paramString)
  {
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[handleHippyConfig] retCode:");
      ((StringBuilder)localObject2).append(paramLong);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    int i = -1;
    if (paramIntent != null) {
      i = paramIntent.getIntExtra("source", -1);
    }
    if ((paramLong == 0L) && (paramTrpcInovkeRsp != null)) {}
    for (;;)
    {
      try
      {
        if (paramTrpcInovkeRsp.data.has())
        {
          paramIntent = new CommonMobileConfQueryRsp();
          paramIntent.mergeFrom(paramTrpcInovkeRsp.data.get().toByteArray());
          if (!paramIntent.updatePreDownloadGap.has()) {
            break label543;
          }
          paramLong = paramIntent.updatePreDownloadGap.get();
          savePreloadHippyInterval(paramLong);
          if (paramIntent.confList.has())
          {
            if (QLog.isColorLevel())
            {
              paramTrpcInovkeRsp = TAG;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("[handleHippyConfig] config size:");
              ((StringBuilder)localObject1).append(paramIntent.confList.size());
              QLog.d(paramTrpcInovkeRsp, 2, ((StringBuilder)localObject1).toString());
            }
            paramIntent = paramIntent.confList.get().iterator();
            if (paramIntent.hasNext())
            {
              paramTrpcInovkeRsp = (MobileConfRsp)paramIntent.next();
              int j = paramTrpcInovkeRsp.ret.get();
              localObject1 = paramTrpcInovkeRsp.conf.get();
              if (QLog.isColorLevel())
              {
                localObject2 = TAG;
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("[handleHippyConfig] config:");
                localStringBuilder.append((String)localObject1);
                QLog.d((String)localObject2, 2, localStringBuilder.toString());
              }
              if (j == 1)
              {
                if (TextUtils.isEmpty((CharSequence)localObject1)) {
                  continue;
                }
                int k = paramTrpcInovkeRsp.configType.get();
                if (k != 1)
                {
                  if (k != 2)
                  {
                    if (k != 3)
                    {
                      if (k != 5) {
                        continue;
                      }
                      getTabPreloadConfigManager().handleTabPreloadResponse(j, (String)localObject1, paramString);
                      continue;
                    }
                    handleTabConfigResponse(j, (String)localObject1, paramString);
                    continue;
                  }
                  handlePreloadJsBundleResponse(j, (String)localObject1, i);
                  continue;
                }
                handleHippyConfigResponse(j, (String)localObject1, paramString);
                continue;
              }
              localObject1 = TAG;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("[handleHippyConfig] no need update. ret = ");
              ((StringBuilder)localObject2).append(j);
              ((StringBuilder)localObject2).append(", type = ");
              ((StringBuilder)localObject2).append(paramTrpcInovkeRsp.configType.get());
              QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
              continue;
            }
          }
          else
          {
            QLog.i(TAG, 2, "[handleHippyConfig] confList is null. return");
          }
        }
        else
        {
          QLog.e(TAG, 1, "[handleHippyConfig] server ret error. return.");
          notifyUpdateStatus(mCurRequestId, -2, "", i);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        QLog.e(TAG, 1, paramIntent.toString());
        notifyUpdateStatus(mCurRequestId, -2, "", i);
      }
      return;
      label543:
      paramLong = 600L;
    }
  }
  
  private void handleHippyConfigResponse(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 1)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      try
      {
        localObject = parseHippyConfigJson(paramString1);
        if (localObject != null)
        {
          SharedPreferences.Editor localEditor = getSharedPreferences().edit();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(paramString2);
          localStringBuilder.append("key_hippy_config");
          localEditor.putString(localStringBuilder.toString(), paramString1).commit();
          this.mHippyConfig = ((HippyConfig)localObject);
          return;
        }
      }
      catch (Throwable paramString1)
      {
        paramString2 = TAG;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleHippyConfigResponse e:");
        ((StringBuilder)localObject).append(paramString1);
        QLog.e(paramString2, 1, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  private void handlePreloadJsBundleResponse(int paramInt1, String paramString, int paramInt2)
  {
    if (paramInt1 == 1) {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
    }
    for (;;)
    {
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("bundleList");
        if (paramString != null)
        {
          this.mBundleInfos.clear();
          paramInt1 = 0;
          if (paramInt1 < paramString.length())
          {
            localObject1 = paramString.getJSONObject(paramInt1);
            if (localObject1 == null) {
              break label219;
            }
            localObject2 = new HippyUpdateManager.BundleInfo();
            ((HippyUpdateManager.BundleInfo)localObject2).bundleName = ((JSONObject)localObject1).optString("bundleName");
            ((HippyUpdateManager.BundleInfo)localObject2).bundleVersion = ((JSONObject)localObject1).optInt("bundleVersion");
            ((HippyUpdateManager.BundleInfo)localObject2).bundleMd5 = ((JSONObject)localObject1).optString("bundleMd5");
            ((HippyUpdateManager.BundleInfo)localObject2).downloadUrl = ((JSONObject)localObject1).optString("downloadUrl");
            ((HippyUpdateManager.BundleInfo)localObject2).maxFailedCnt = ((JSONObject)localObject1).optInt("maxFailedCnt", 2);
            this.mBundleInfos.put(((HippyUpdateManager.BundleInfo)localObject2).bundleName, localObject2);
            doDownloadBundle((HippyUpdateManager.BundleInfo)localObject2, paramInt2);
            break label219;
          }
        }
        else
        {
          QLog.i(TAG, 2, "[doHandleHippyBundle] array is null.");
          return;
        }
      }
      catch (Throwable paramString)
      {
        Object localObject1 = TAG;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("handlePreloadJsBundleResponse e:");
        ((StringBuilder)localObject2).append(paramString);
        QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      return;
      label219:
      paramInt1 += 1;
    }
  }
  
  private void handleTabConfigResponse(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt == 1)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      try
      {
        paramString1 = parseTabJson(paramString1);
        if (this.mTabFiles == null) {
          this.mTabFiles = new HashMap();
        }
        if (paramString1 != null)
        {
          localObject1 = paramString1.keySet().iterator();
          Object localObject2;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            if (this.mTabFiles.containsKey(localObject2))
            {
              if (!TextUtils.equals(((TabFile)this.mTabFiles.get(localObject2)).tabFileMd5, ((TabFile)paramString1.get(localObject2)).tabFileMd5)) {
                this.mTabFiles.put(localObject2, paramString1.get(localObject2));
              }
            }
            else {
              this.mTabFiles.put(localObject2, paramString1.get(localObject2));
            }
          }
          if ((this.mTabFiles != null) && (this.mTabFiles.size() > 0))
          {
            paramString1 = new JSONObject();
            localObject1 = new JSONObject();
            localObject2 = this.mTabFiles.keySet().iterator();
            while (((Iterator)localObject2).hasNext())
            {
              String str = (String)((Iterator)localObject2).next();
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("tabFileMd5", ((TabFile)this.mTabFiles.get(str)).tabFileMd5);
              localJSONObject.put("tabFileJson", ((TabFile)this.mTabFiles.get(str)).tabFileJson);
              ((JSONObject)localObject1).put(str, localJSONObject);
            }
            paramString1.put("tabFileList", localObject1);
            localObject1 = getSharedPreferences().edit();
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append(paramString2);
            ((StringBuilder)localObject2).append("key_tab_files");
            ((SharedPreferences.Editor)localObject1).putString(((StringBuilder)localObject2).toString(), paramString1.toString()).commit();
            if (QLog.isColorLevel())
            {
              paramString2 = TAG;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("[handleHippyConfig] tab json : ");
              ((StringBuilder)localObject1).append(paramString1.toString());
              QLog.d(paramString2, 2, ((StringBuilder)localObject1).toString());
              return;
            }
          }
        }
      }
      catch (Throwable paramString1)
      {
        paramString2 = TAG;
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("handleTabConfigResponse e:");
        ((StringBuilder)localObject1).append(paramString1);
        QLog.e(paramString2, 1, ((StringBuilder)localObject1).toString());
      }
    }
  }
  
  private void handleUpdateConfigResponse(Intent paramIntent, String paramString1, int paramInt, String paramString2)
  {
    if ((paramInt != 1) && (paramInt != 2))
    {
      paramString2 = new StringBuilder();
      paramString2.append("ret ");
      paramString2.append(paramInt);
      notifyJsBundleUpdate(paramIntent, paramString1, -5, paramString2.toString());
      return;
    }
    paramString2 = parseBundleInfo(paramString2);
    if (paramString2 != null)
    {
      Iterator localIterator = paramString2.iterator();
      paramString2 = null;
      for (;;)
      {
        localObject = paramString2;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (HippyUpdateManager.BundleInfo)localIterator.next();
        if (paramString1.equals(((HippyUpdateManager.BundleInfo)localObject).bundleName)) {
          paramString2 = (String)localObject;
        }
      }
    }
    Object localObject = null;
    if (localObject == null)
    {
      notifyJsBundleUpdate(paramIntent, paramString1, 1, null);
      return;
    }
    if (UpdateSetting.getInstance().isModuleVersionFileExists(((HippyUpdateManager.BundleInfo)localObject).bundleName, ((HippyUpdateManager.BundleInfo)localObject).bundleVersion))
    {
      UpdateSetting.getInstance().setModuleVersion(((HippyUpdateManager.BundleInfo)localObject).bundleName, ((HippyUpdateManager.BundleInfo)localObject).bundleVersion);
      notifyJsBundleUpdate(paramIntent, ((HippyUpdateManager.BundleInfo)localObject).bundleName, 101, "js bundle exists");
      return;
    }
    if (TextUtils.isEmpty(((HippyUpdateManager.BundleInfo)localObject).downloadUrl))
    {
      notifyJsBundleUpdate(paramIntent, paramString1, -5, "download url is empty");
      return;
    }
    ThreadManager.post(new HippyUpdateManager.3(this, (HippyUpdateManager.BundleInfo)localObject, paramIntent), 8, null, true);
  }
  
  private void handleUpdateJsBundle(Intent paramIntent, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp, String paramString)
  {
    if (paramIntent == null)
    {
      QLog.e(TAG, 1, "handleUpdateJsBundle request is null");
      return;
    }
    String str = paramIntent.getStringExtra("jsBundleName");
    if (TextUtils.isEmpty(str))
    {
      QLog.e(TAG, 1, "handleUpdateJsBundle bundleName is empty");
      return;
    }
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleUpdateJsBundle retCode:");
    localStringBuilder.append(paramLong);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    if ((paramLong == 0L) && (paramTrpcInovkeRsp != null) && (paramTrpcInovkeRsp.data.has())) {}
    for (;;)
    {
      try
      {
        localObject = new CommonMobileConfQueryRsp();
        ((CommonMobileConfQueryRsp)localObject).mergeFrom(paramTrpcInovkeRsp.data.get().toByteArray());
        if (!((CommonMobileConfQueryRsp)localObject).confList.has())
        {
          notifyJsBundleUpdate(paramIntent, str, -5, "configRsp is empty");
          return;
        }
        i = 0;
        boolean bool = isCheckPreloadSuccess(paramIntent, ((CommonMobileConfQueryRsp)localObject).confList.get());
        Iterator localIterator = ((CommonMobileConfQueryRsp)localObject).confList.get().iterator();
        if (localIterator.hasNext())
        {
          MobileConfRsp localMobileConfRsp = (MobileConfRsp)localIterator.next();
          if ((!localMobileConfRsp.ret.has()) || (!localMobileConfRsp.configType.has())) {
            continue;
          }
          int j = localMobileConfRsp.configType.get();
          localObject = null;
          localStringBuilder = null;
          paramTrpcInovkeRsp = null;
          if (j != 1)
          {
            if (j != 2)
            {
              if (j != 3) {
                continue;
              }
              if (localMobileConfRsp.conf.has()) {
                paramTrpcInovkeRsp = localMobileConfRsp.conf.get();
              }
              handleTabConfigResponse(localMobileConfRsp.ret.get(), paramTrpcInovkeRsp, paramString);
              continue;
            }
            if (bool)
            {
              paramTrpcInovkeRsp = (TrpcProxy.TrpcInovkeRsp)localObject;
              if (localMobileConfRsp.conf.has()) {
                paramTrpcInovkeRsp = localMobileConfRsp.conf.get();
              }
              handleUpdateConfigResponse(paramIntent, str, localMobileConfRsp.ret.get(), paramTrpcInovkeRsp);
              break label528;
            }
            notifyJsBundleUpdate(paramIntent, str, 2, "preload not allowed");
            break label528;
          }
          paramTrpcInovkeRsp = localStringBuilder;
          if (localMobileConfRsp.conf.has()) {
            paramTrpcInovkeRsp = localMobileConfRsp.conf.get();
          }
          handleHippyConfigResponse(localMobileConfRsp.ret.get(), paramTrpcInovkeRsp, paramString);
          continue;
        }
        if (i == 0)
        {
          notifyJsBundleUpdate(paramIntent, str, -5, "no update config");
          return;
        }
      }
      catch (Throwable paramTrpcInovkeRsp)
      {
        paramString = new StringBuilder();
        paramString.append("handleUpdateJsBundle e:");
        paramString.append(paramTrpcInovkeRsp);
        notifyJsBundleUpdate(paramIntent, str, -5, paramString.toString());
      }
      return;
      paramTrpcInovkeRsp = new StringBuilder();
      paramTrpcInovkeRsp.append("net error code:");
      paramTrpcInovkeRsp.append(paramLong);
      notifyJsBundleUpdate(paramIntent, str, -5, paramTrpcInovkeRsp.toString());
      return;
      label528:
      int i = 1;
    }
  }
  
  private void initData()
  {
    QLog.i(TAG, 1, "=====initData=====");
    this.mCurrentUin = getCurrentUin();
    this.mHippyConfig = getHippyConfig();
    this.mPreloadInterval = getPreloadHippyInterval();
    this.mLastPreloadTimeStamp = getLastPreloadDownTimeStamp();
    this.mDownFailedUrls = getBundleFailedCnt();
    this.mUnzipFailedUrls = getBundleUnzipFailedUrls();
    this.mTabPreloadConfigManager = new TabPreloadConfigManager(this.mCurrentUin);
  }
  
  private boolean isCheckPreloadSuccess(Intent paramIntent, List<MobileConfRsp> paramList)
  {
    boolean bool1 = false;
    if (!paramIntent.getBooleanExtra("isCheckPreload", false)) {
      return true;
    }
    Object localObject = paramList.iterator();
    MobileConfRsp localMobileConfRsp;
    do
    {
      boolean bool2 = ((Iterator)localObject).hasNext();
      paramList = null;
      paramIntent = paramList;
      if (!bool2) {
        break;
      }
      localMobileConfRsp = (MobileConfRsp)((Iterator)localObject).next();
    } while ((!localMobileConfRsp.configType.has()) || (localMobileConfRsp.configType.get() != 6));
    paramIntent = paramList;
    if (localMobileConfRsp.conf.has()) {
      paramIntent = localMobileConfRsp.conf.get();
    }
    if (!TextUtils.isEmpty(paramIntent)) {
      try
      {
        int i = new JSONObject(paramIntent).optInt("needPreload");
        if (QLog.isColorLevel())
        {
          paramIntent = TAG;
          paramList = new StringBuilder();
          paramList.append("isCheckPreloadSuccess needPreload:");
          paramList.append(i);
          QLog.i(paramIntent, 2, paramList.toString());
        }
        if (i == 1) {
          bool1 = true;
        }
        return bool1;
      }
      catch (Throwable paramIntent)
      {
        paramList = TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("isCheckPreloadSuccess e:");
        ((StringBuilder)localObject).append(paramIntent);
        QLog.e(paramList, 1, ((StringBuilder)localObject).toString());
      }
    }
    return true;
  }
  
  private boolean isToolProcess()
  {
    boolean bool;
    if (MobileQQ.sProcessId == 7) {
      bool = true;
    } else {
      bool = false;
    }
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[checkToolProcess] isToolProcess: ");
    localStringBuilder.append(bool);
    QLog.i(str, 2, localStringBuilder.toString());
    return bool;
  }
  
  private void notifyJsBundleUpdate(Intent paramIntent, String paramString1, int paramInt, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramIntent != null))
    {
      long l = NetConnInfoCenter.getServerTimeMillis() - paramIntent.getLongExtra("requestStartTime", 0L);
      Object localObject2;
      if ((QLog.isColorLevel()) || (paramInt != 0))
      {
        ??? = TAG;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("notifyJsBundleUpdate bundleName:");
        ((StringBuilder)localObject2).append(paramString1);
        ((StringBuilder)localObject2).append(" retCode:");
        ((StringBuilder)localObject2).append(paramInt);
        ((StringBuilder)localObject2).append(" retMsg:");
        ((StringBuilder)localObject2).append(paramString2);
        ((StringBuilder)localObject2).append(" cost:");
        ((StringBuilder)localObject2).append(l);
        QLog.i((String)???, 2, ((StringBuilder)localObject2).toString());
      }
      synchronized (this.mJsBundleUpdateListeners)
      {
        localObject2 = (ArrayList)this.mJsBundleUpdateListeners.get(paramString1);
        if (localObject2 != null)
        {
          Iterator localIterator = ((ArrayList)localObject2).iterator();
          while (localIterator.hasNext())
          {
            IUpdateListener localIUpdateListener = (IUpdateListener)localIterator.next();
            if (paramInt == 0) {
              localIUpdateListener.onUpdateSuccess(0, paramString1);
            } else {
              localIUpdateListener.onUpdateFailed(0, paramInt, paramString2, paramString1);
            }
          }
          ((ArrayList)localObject2).clear();
        }
        int i;
        if (paramIntent.getBooleanExtra("isUseHttpRequest", false)) {
          i = 5;
        } else {
          i = 11;
        }
        HippyReporter.getInstance().reportCheckUpdate(paramString1, i, paramInt, paramString2, l);
        return;
      }
    }
    QLog.i(TAG, 1, "notifyJsBundleUpdate bundleName or request is null");
  }
  
  private ArrayList<HippyUpdateManager.BundleInfo> parseBundleInfo(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i(TAG, 2, "[parseBundleInfo] json is empty.");
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONArray("bundleList");
      if (paramString == null)
      {
        QLog.i(TAG, 2, "[parseBundleInfo] array is null.");
        return null;
      }
      localObject1 = new ArrayList();
      int i = 0;
      while (i < paramString.length())
      {
        localObject2 = paramString.getJSONObject(i);
        if (localObject2 != null)
        {
          HippyUpdateManager.BundleInfo localBundleInfo = new HippyUpdateManager.BundleInfo();
          localBundleInfo.bundleName = ((JSONObject)localObject2).optString("bundleName");
          localBundleInfo.bundleVersion = ((JSONObject)localObject2).optInt("bundleVersion");
          localBundleInfo.bundleMd5 = ((JSONObject)localObject2).optString("bundleMd5");
          localBundleInfo.downloadUrl = ((JSONObject)localObject2).optString("downloadUrl");
          ((ArrayList)localObject1).add(localBundleInfo);
        }
        i += 1;
      }
      return localObject1;
    }
    catch (Throwable paramString)
    {
      Object localObject1 = TAG;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[parseBundleInfo] e:");
      ((StringBuilder)localObject2).append(paramString);
      QLog.i((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    return null;
  }
  
  private void saveLastPreDownloadTime(long paramLong)
  {
    String str = getCurrentUin();
    SharedPreferences.Editor localEditor = getSharedPreferences().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("key_last_preload_hippy_timestamp");
    localEditor.putLong(localStringBuilder.toString(), paramLong).commit();
  }
  
  private void savePreloadHippyInterval(long paramLong)
  {
    String str = getCurrentUin();
    SharedPreferences.Editor localEditor = getSharedPreferences().edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("key_preload_hippy_interval");
    localEditor.putLong(localStringBuilder.toString(), paramLong);
    this.mPreloadInterval = paramLong;
  }
  
  private void updateJsBundleByHttp(String paramString, int paramInt, Bundle paramBundle, IUpdateListener paramIUpdateListener)
  {
    new HippyQQUpdateManager().checkUpdate(paramString, new HippyUpdateManager.1(this, paramBundle, paramString));
  }
  
  private void updateJsBundleBySSO(String paramString, int paramInt1, Bundle paramBundle, int paramInt2, IUpdateListener paramIUpdateListener)
  {
    long l;
    if (this.mJsBundleLastUpdateTimes.containsKey(paramString)) {
      l = ((Long)this.mJsBundleLastUpdateTimes.get(paramString)).longValue();
    } else {
      l = 0L;
    }
    HippyUnissoHandler localHippyUnissoHandler = HippyUnissoHandler.getInstance();
    if (localHippyUnissoHandler != null)
    {
      localHippyUnissoHandler.requestHippyConfig(paramInt2, paramString, paramInt1, l, paramBundle);
      paramInt1 = 1;
    }
    else
    {
      paramInt1 = 0;
    }
    if (paramInt1 == 0)
    {
      if (paramIUpdateListener != null)
      {
        removeJsBundleUpdateListener(paramString, paramIUpdateListener);
        paramIUpdateListener.onUpdateFailed(0, -5, "gcHandler is null", paramString);
      }
      QLog.e(TAG, 1, "updateJsBundle gcHandler is null.");
    }
  }
  
  public void addBundleFailedCnt(String paramString, int paramInt)
  {
    if (this.mDownFailedUrls == null) {
      this.mDownFailedUrls = new HashMap();
    }
    int i;
    if (this.mDownFailedUrls.containsKey(paramString)) {
      i = ((Integer)this.mDownFailedUrls.get(paramString)).intValue();
    } else {
      i = 0;
    }
    this.mDownFailedUrls.put(paramString, Integer.valueOf(paramInt + i));
    paramString = new StringBuilder();
    Iterator localIterator = this.mDownFailedUrls.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(">>>");
      localStringBuilder.append(this.mDownFailedUrls.get(str));
      localStringBuilder.append("<<<");
      paramString.append(localStringBuilder.toString());
    }
    getSharedPreferences().edit().putString("key_download_failed_urls", paramString.toString()).commit();
  }
  
  public void addBundleUnzipFailedUrl(String paramString)
  {
    if (this.mUnzipFailedUrls == null) {
      this.mUnzipFailedUrls = new ArrayList();
    }
    if (this.mUnzipFailedUrls.contains(paramString)) {
      return;
    }
    this.mUnzipFailedUrls.add(paramString);
    paramString = new StringBuilder();
    Iterator localIterator = this.mUnzipFailedUrls.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("<<<");
      paramString.append(localStringBuilder.toString());
    }
    getSharedPreferences().edit().putString("key_unzip_failed_urls", paramString.toString()).commit();
  }
  
  public void addListener(IUpdateListener paramIUpdateListener)
  {
    try
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext())
      {
        IUpdateListener localIUpdateListener = (IUpdateListener)((WeakReference)localIterator.next()).get();
        if (localIUpdateListener == null) {
          localIterator.remove();
        } else if (localIUpdateListener == paramIUpdateListener) {
          return;
        }
      }
      this.mListeners.add(new WeakReference(paramIUpdateListener));
      return;
    }
    finally {}
    for (;;)
    {
      throw paramIUpdateListener;
    }
  }
  
  public void cancelDownloadTask(String paramString, int paramInt)
  {
    Object localObject = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[stopDownloadTask] stop download task:");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", version: ");
    localStringBuilder.append(paramInt);
    QLog.i((String)localObject, 1, localStringBuilder.toString());
    if (isToolProcess())
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("bundle_name", paramString);
      ((Bundle)localObject).putInt("bundle_version", paramInt);
      QIPCClientHelper.getInstance().callServer("module_hippy", "action_cancle_download_task", (Bundle)localObject, null);
      return;
    }
    localObject = this.mDownloader;
    if (localObject != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(paramInt);
      if (((DownloaderInterface)localObject).getTask(localStringBuilder.toString()) != null)
      {
        localObject = this.mDownloader;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(paramInt);
        ((DownloaderInterface)localObject).cancelTask(true, localStringBuilder.toString());
        return;
      }
    }
    QLog.i(TAG, 1, "[stopDownloadTask] mDownloader is null.");
  }
  
  public boolean checkUpdateJsBundleInterval(String paramString)
  {
    if (!this.mJsBundleLastUpdateTimes.containsKey(paramString)) {
      return true;
    }
    long l1 = ((Long)this.mJsBundleLastUpdateTimes.get(paramString)).longValue();
    long l2 = NetConnInfoCenter.getServerTime();
    return (l2 > l1) && (l2 - l1 > getHippyConfig().checkUpdateGap);
  }
  
  public Map<String, Integer> getBundleFailedCnt()
  {
    HashMap localHashMap = new HashMap();
    Object localObject1 = getSharedPreferences().getString("key_download_failed_urls", "");
    Object localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = ((String)localObject1).split("<<<");
      int i = 0;
      while (i < localObject1.length)
      {
        localObject2 = localObject1[i].split(">>>");
        if (localObject2.length == 2) {
          localHashMap.put(localObject2[0], Integer.valueOf(Integer.parseInt(localObject2[1])));
        }
        i += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("[getBundleFailedCnt] size:");
      ((StringBuilder)localObject2).append(localHashMap.size());
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
    return localHashMap;
  }
  
  public List<String> getBundleUnzipFailedUrls()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = getSharedPreferences().getString("key_unzip_failed_urls", "");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("<<<");
      int i = 0;
      while (i < localObject.length)
      {
        localArrayList.add(localObject[i]);
        i += 1;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getBundleUnzipFailedUrls] size:");
      localStringBuilder.append(localArrayList.size());
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    return localArrayList;
  }
  
  public HippyConfig getHippyConfig()
  {
    String str = getCurrentUin();
    if (!TextUtils.equals(str, this.mCurrentUin))
    {
      initData();
    }
    else if (this.mHippyConfig == null)
    {
      SharedPreferences localSharedPreferences = getSharedPreferences();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("key_hippy_config");
      str = localSharedPreferences.getString(localStringBuilder.toString(), "");
      try
      {
        this.mHippyConfig = parseHippyConfigJson(str);
      }
      catch (Exception localException)
      {
        QLog.e(TAG, 1, localException.toString());
      }
    }
    if (this.mHippyConfig == null) {
      this.mHippyConfig = new HippyConfig();
    }
    return this.mHippyConfig;
  }
  
  public long getLastPreloadDownTimeStamp()
  {
    String str = getCurrentUin();
    if (!TextUtils.equals(str, this.mCurrentUin))
    {
      initData();
    }
    else
    {
      SharedPreferences localSharedPreferences = getSharedPreferences();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("key_last_preload_hippy_timestamp");
      this.mLastPreloadTimeStamp = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    }
    return this.mLastPreloadTimeStamp;
  }
  
  public long getPreloadHippyInterval()
  {
    String str = getCurrentUin();
    SharedPreferences localSharedPreferences = getSharedPreferences();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("key_preload_hippy_interval");
    return localSharedPreferences.getLong(localStringBuilder.toString(), 600L);
  }
  
  public Map<String, TabFile> getTabFilesConfig()
  {
    Object localObject = getCurrentUin();
    if (!TextUtils.equals((CharSequence)localObject, this.mCurrentUin)) {
      initData();
    } else if (this.mTabFiles == null) {
      try
      {
        SharedPreferences localSharedPreferences = getSharedPreferences();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("key_tab_files");
        localObject = parseTabJson(localSharedPreferences.getString(localStringBuilder.toString(), ""));
        if ((localObject != null) && (((Map)localObject).size() > 0)) {
          this.mTabFiles = ((Map)localObject);
        }
      }
      catch (Exception localException)
      {
        QLog.e(TAG, 1, localException.toString());
      }
    }
    if (this.mTabFiles == null) {
      this.mTabFiles = new HashMap();
    }
    return this.mTabFiles;
  }
  
  public TabPreloadConfigManager getTabPreloadConfigManager()
  {
    if (!TextUtils.equals(getCurrentUin(), this.mCurrentUin)) {
      initData();
    }
    if (this.mTabPreloadConfigManager == null) {
      this.mTabPreloadConfigManager = new TabPreloadConfigManager(this.mCurrentUin);
    }
    this.mTabPreloadConfigManager.initData();
    return this.mTabPreloadConfigManager;
  }
  
  public void handleResponse(Intent paramIntent, long paramLong, TrpcProxy.TrpcInovkeRsp paramTrpcInovkeRsp)
  {
    int i = 0;
    String str;
    if (paramIntent != null)
    {
      i = paramIntent.getIntExtra("source", 0);
      str = paramIntent.getStringExtra("uin");
    }
    else
    {
      str = "";
    }
    if (!TextUtils.equals(str, getCurrentUin()))
    {
      QLog.e(TAG, 1, "[handleResponse] current uin change. return.");
      return;
    }
    if ((i != 1) && (i != 2))
    {
      if ((i != 3) && (i != 4)) {
        return;
      }
      handleUpdateJsBundle(paramIntent, paramLong, paramTrpcInovkeRsp, str);
      return;
    }
    handleHippyConfig(paramIntent, paramLong, paramTrpcInovkeRsp, str);
  }
  
  public void notifyUpdateStatus(int paramInt1, int paramInt2, String paramString, int paramInt3)
  {
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (QLog.isColorLevel())
    {
      localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[notifyUpdateStatus] requestId = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", ret = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", source = ");
      localStringBuilder.append(paramInt3);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    paramString = (HippyUpdateManager.BundleInfo)this.mBundleInfos.get(paramString);
    Object localObject = new JSONObject();
    if (paramString != null) {
      try
      {
        if (this.mDownFailedUrls != null) {
          ((JSONObject)localObject).put("maxFailedCnt", this.mDownFailedUrls.get(paramString.downloadUrl));
        }
      }
      catch (Exception localException)
      {
        QLog.e(TAG, 1, localException.toString());
        break label208;
      }
    }
    switch (paramInt2)
    {
    }
    label208:
    if ((1 != paramInt2) && (paramString != null))
    {
      paramInt1 = paramInt2;
      if (paramInt2 == 0) {
        paramInt1 = (int)(l - this.mLastPreloadTimeStamp);
      }
      HippyReporter.getInstance().reportPreDownloadOper(paramString.bundleName, paramString.bundleVersion, 12, paramInt1, (JSONObject)localObject, "");
    }
  }
  
  public void onDestroy() {}
  
  /* Error */
  public void onDone(DownloadTask paramDownloadTask)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 967	com/tencent/mobileqq/vip/DownloadListener:onDone	(Lcom/tencent/mobileqq/vip/DownloadTask;)V
    //   5: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   8: ifeq +47 -> 55
    //   11: getstatic 104	com/tencent/hippy/qq/update/HippyUpdateManager:TAG	Ljava/lang/String;
    //   14: astore 6
    //   16: new 86	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   23: astore 7
    //   25: aload 7
    //   27: ldc_w 969
    //   30: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload 7
    //   36: aload_1
    //   37: invokevirtual 970	com/tencent/mobileqq/vip/DownloadTask:toString	()Ljava/lang/String;
    //   40: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: pop
    //   44: aload 6
    //   46: iconst_2
    //   47: aload 7
    //   49: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   52: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   55: aload_1
    //   56: invokevirtual 973	com/tencent/mobileqq/vip/DownloadTask:a	()Landroid/os/Bundle;
    //   59: astore 7
    //   61: aload 7
    //   63: ldc_w 300
    //   66: invokevirtual 975	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   69: astore 6
    //   71: aload 7
    //   73: ldc_w 305
    //   76: invokevirtual 978	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   79: istore_2
    //   80: aload 7
    //   82: ldc_w 311
    //   85: invokevirtual 975	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   88: astore 8
    //   90: aload 7
    //   92: ldc_w 315
    //   95: invokevirtual 978	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   98: istore_3
    //   99: iconst_3
    //   100: aload_1
    //   101: invokevirtual 980	com/tencent/mobileqq/vip/DownloadTask:a	()I
    //   104: if_icmpne +596 -> 700
    //   107: aload_1
    //   108: getfield 982	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   111: aload_1
    //   112: getfield 985	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   115: invokeinterface 205 2 0
    //   120: checkcast 357	java/io/File
    //   123: astore 7
    //   125: aload 7
    //   127: ifnull +541 -> 668
    //   130: aload 7
    //   132: invokevirtual 360	java/io/File:exists	()Z
    //   135: ifeq +533 -> 668
    //   138: aload 7
    //   140: invokevirtual 366	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   143: invokestatic 372	com/tencent/hippy/qq/update/sign/MD5:getFileMd5	(Ljava/lang/String;)Ljava/lang/String;
    //   146: astore 9
    //   148: aload 9
    //   150: aload 8
    //   152: invokestatic 644	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   155: ifne +84 -> 239
    //   158: getstatic 104	com/tencent/hippy/qq/update/HippyUpdateManager:TAG	Ljava/lang/String;
    //   161: astore 7
    //   163: new 86	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   170: astore 10
    //   172: aload 10
    //   174: ldc_w 987
    //   177: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: aload 10
    //   183: aload 8
    //   185: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 10
    //   191: ldc_w 989
    //   194: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload 10
    //   200: aload 9
    //   202: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: aload 7
    //   208: iconst_1
    //   209: aload 10
    //   211: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   214: invokestatic 224	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   217: aload_0
    //   218: getstatic 106	com/tencent/hippy/qq/update/HippyUpdateManager:mCurRequestId	I
    //   221: bipush 253
    //   223: aload 6
    //   225: iload_3
    //   226: invokevirtual 231	com/tencent/hippy/qq/update/HippyUpdateManager:notifyUpdateStatus	(IILjava/lang/String;I)V
    //   229: aload_0
    //   230: aload_1
    //   231: getfield 985	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   234: iconst_1
    //   235: invokevirtual 991	com/tencent/hippy/qq/update/HippyUpdateManager:addBundleFailedCnt	(Ljava/lang/String;I)V
    //   238: return
    //   239: invokestatic 246	com/tencent/hippy/qq/update/UpdateSetting:getInstance	()Lcom/tencent/hippy/qq/update/UpdateSetting;
    //   242: aload 6
    //   244: iload_2
    //   245: invokevirtual 253	com/tencent/hippy/qq/update/UpdateSetting:isModuleVersionFileExists	(Ljava/lang/String;I)Z
    //   248: ifeq +125 -> 373
    //   251: getstatic 104	com/tencent/hippy/qq/update/HippyUpdateManager:TAG	Ljava/lang/String;
    //   254: astore 8
    //   256: new 86	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   263: astore 9
    //   265: aload 9
    //   267: ldc_w 993
    //   270: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: pop
    //   274: aload 9
    //   276: aload 6
    //   278: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload 9
    //   284: ldc_w 257
    //   287: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload 9
    //   293: iload_2
    //   294: invokevirtual 260	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   297: pop
    //   298: aload 8
    //   300: iconst_2
    //   301: aload 9
    //   303: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 263	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   309: aload_0
    //   310: getstatic 106	com/tencent/hippy/qq/update/HippyUpdateManager:mCurRequestId	I
    //   313: iconst_1
    //   314: aload 6
    //   316: iload_3
    //   317: invokevirtual 231	com/tencent/hippy/qq/update/HippyUpdateManager:notifyUpdateStatus	(IILjava/lang/String;I)V
    //   320: aload 7
    //   322: invokevirtual 398	java/io/File:delete	()Z
    //   325: pop
    //   326: return
    //   327: astore_1
    //   328: getstatic 104	com/tencent/hippy/qq/update/HippyUpdateManager:TAG	Ljava/lang/String;
    //   331: astore 6
    //   333: new 86	java/lang/StringBuilder
    //   336: dup
    //   337: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   340: astore 7
    //   342: aload 7
    //   344: ldc_w 400
    //   347: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload 7
    //   353: aload_1
    //   354: invokevirtual 401	java/lang/Exception:toString	()Ljava/lang/String;
    //   357: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: aload 6
    //   363: iconst_1
    //   364: aload 7
    //   366: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 224	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   372: return
    //   373: aload 7
    //   375: aload 6
    //   377: iload_2
    //   378: invokestatic 381	com/tencent/hippy/qq/update/HippyQQFileUtil:unzipModulePackage	(Ljava/io/File;Ljava/lang/String;I)Z
    //   381: istore 5
    //   383: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   386: ifeq +45 -> 431
    //   389: getstatic 104	com/tencent/hippy/qq/update/HippyUpdateManager:TAG	Ljava/lang/String;
    //   392: astore 8
    //   394: new 86	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   401: astore 9
    //   403: aload 9
    //   405: ldc_w 995
    //   408: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: aload 9
    //   414: iload 5
    //   416: invokevirtual 164	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   419: pop
    //   420: aload 8
    //   422: iconst_2
    //   423: aload 9
    //   425: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   431: getstatic 106	com/tencent/hippy/qq/update/HippyUpdateManager:mCurRequestId	I
    //   434: istore 4
    //   436: iload 5
    //   438: ifeq +294 -> 732
    //   441: iconst_0
    //   442: istore_2
    //   443: goto +3 -> 446
    //   446: aload_0
    //   447: iload 4
    //   449: iload_2
    //   450: aload 6
    //   452: iload_3
    //   453: invokevirtual 231	com/tencent/hippy/qq/update/HippyUpdateManager:notifyUpdateStatus	(IILjava/lang/String;I)V
    //   456: aload 7
    //   458: invokevirtual 398	java/io/File:delete	()Z
    //   461: pop
    //   462: return
    //   463: astore 7
    //   465: getstatic 104	com/tencent/hippy/qq/update/HippyUpdateManager:TAG	Ljava/lang/String;
    //   468: astore_1
    //   469: new 86	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   476: astore 6
    //   478: goto +101 -> 579
    //   481: astore_1
    //   482: goto +128 -> 610
    //   485: astore 8
    //   487: invokestatic 159	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   490: ifeq +48 -> 538
    //   493: getstatic 104	com/tencent/hippy/qq/update/HippyUpdateManager:TAG	Ljava/lang/String;
    //   496: astore 9
    //   498: new 86	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   505: astore 10
    //   507: aload 10
    //   509: ldc_w 997
    //   512: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload 10
    //   518: aload 8
    //   520: invokevirtual 1000	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   523: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: aload 9
    //   529: iconst_2
    //   530: aload 10
    //   532: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   535: invokestatic 175	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   538: aload_0
    //   539: aload_1
    //   540: getfield 985	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   543: invokevirtual 1002	com/tencent/hippy/qq/update/HippyUpdateManager:addBundleUnzipFailedUrl	(Ljava/lang/String;)V
    //   546: aload_0
    //   547: getstatic 106	com/tencent/hippy/qq/update/HippyUpdateManager:mCurRequestId	I
    //   550: iconst_m1
    //   551: aload 6
    //   553: iload_3
    //   554: invokevirtual 231	com/tencent/hippy/qq/update/HippyUpdateManager:notifyUpdateStatus	(IILjava/lang/String;I)V
    //   557: aload 7
    //   559: invokevirtual 398	java/io/File:delete	()Z
    //   562: pop
    //   563: return
    //   564: astore 7
    //   566: getstatic 104	com/tencent/hippy/qq/update/HippyUpdateManager:TAG	Ljava/lang/String;
    //   569: astore_1
    //   570: new 86	java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   577: astore 6
    //   579: aload 6
    //   581: ldc_w 400
    //   584: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: pop
    //   588: aload 6
    //   590: aload 7
    //   592: invokevirtual 401	java/lang/Exception:toString	()Ljava/lang/String;
    //   595: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: aload_1
    //   600: iconst_1
    //   601: aload 6
    //   603: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokestatic 224	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   609: return
    //   610: aload 7
    //   612: invokevirtual 398	java/io/File:delete	()Z
    //   615: pop
    //   616: goto +50 -> 666
    //   619: astore 6
    //   621: getstatic 104	com/tencent/hippy/qq/update/HippyUpdateManager:TAG	Ljava/lang/String;
    //   624: astore 7
    //   626: new 86	java/lang/StringBuilder
    //   629: dup
    //   630: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   633: astore 8
    //   635: aload 8
    //   637: ldc_w 400
    //   640: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: pop
    //   644: aload 8
    //   646: aload 6
    //   648: invokevirtual 401	java/lang/Exception:toString	()Ljava/lang/String;
    //   651: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: pop
    //   655: aload 7
    //   657: iconst_1
    //   658: aload 8
    //   660: invokevirtual 102	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: invokestatic 224	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   666: aload_1
    //   667: athrow
    //   668: aload_0
    //   669: aload_1
    //   670: getfield 985	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   673: iconst_1
    //   674: invokevirtual 991	com/tencent/hippy/qq/update/HippyUpdateManager:addBundleFailedCnt	(Ljava/lang/String;I)V
    //   677: aload_0
    //   678: getstatic 106	com/tencent/hippy/qq/update/HippyUpdateManager:mCurRequestId	I
    //   681: bipush 249
    //   683: aload 6
    //   685: iload_3
    //   686: invokevirtual 231	com/tencent/hippy/qq/update/HippyUpdateManager:notifyUpdateStatus	(IILjava/lang/String;I)V
    //   689: getstatic 104	com/tencent/hippy/qq/update/HippyUpdateManager:TAG	Ljava/lang/String;
    //   692: iconst_1
    //   693: ldc_w 1004
    //   696: invokestatic 224	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   699: return
    //   700: getstatic 104	com/tencent/hippy/qq/update/HippyUpdateManager:TAG	Ljava/lang/String;
    //   703: iconst_1
    //   704: ldc_w 1006
    //   707: invokestatic 224	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   710: aload_0
    //   711: aload_1
    //   712: getfield 985	com/tencent/mobileqq/vip/DownloadTask:c	Ljava/lang/String;
    //   715: iconst_1
    //   716: invokevirtual 991	com/tencent/hippy/qq/update/HippyUpdateManager:addBundleFailedCnt	(Ljava/lang/String;I)V
    //   719: aload_0
    //   720: getstatic 106	com/tencent/hippy/qq/update/HippyUpdateManager:mCurRequestId	I
    //   723: bipush 252
    //   725: aload 6
    //   727: iload_3
    //   728: invokevirtual 231	com/tencent/hippy/qq/update/HippyUpdateManager:notifyUpdateStatus	(IILjava/lang/String;I)V
    //   731: return
    //   732: iconst_m1
    //   733: istore_2
    //   734: goto -288 -> 446
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	737	0	this	HippyUpdateManager
    //   0	737	1	paramDownloadTask	DownloadTask
    //   79	655	2	i	int
    //   98	630	3	j	int
    //   434	14	4	k	int
    //   381	56	5	bool	boolean
    //   14	588	6	localObject1	Object
    //   619	107	6	localException1	Exception
    //   23	434	7	localObject2	Object
    //   463	95	7	localException2	Exception
    //   564	47	7	localException3	Exception
    //   624	32	7	str1	String
    //   88	333	8	str2	String
    //   485	34	8	localThrowable	Throwable
    //   633	26	8	localStringBuilder1	StringBuilder
    //   146	382	9	localObject3	Object
    //   170	361	10	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   320	326	327	java/lang/Exception
    //   456	462	463	java/lang/Exception
    //   239	320	481	finally
    //   373	431	481	finally
    //   431	436	481	finally
    //   446	456	481	finally
    //   487	538	481	finally
    //   538	557	481	finally
    //   239	320	485	java/lang/Throwable
    //   373	431	485	java/lang/Throwable
    //   431	436	485	java/lang/Throwable
    //   446	456	485	java/lang/Throwable
    //   557	563	564	java/lang/Exception
    //   610	616	619	java/lang/Exception
  }
  
  public HippyConfig parseHippyConfigJson(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i(TAG, 2, "[parseHippyConfigJson] str is empty");
      return null;
    }
    try
    {
      paramString = new JSONObject(paramString);
      HippyConfig localHippyConfig = new HippyConfig();
      localHippyConfig.isGameCenterPredrawHippy = paramString.optInt("isPredrawHippy", 0);
      localHippyConfig.isGameCenterLoadHippyInToolProcess = paramString.optInt("isLoadHippyInToolProcess", 0);
      localHippyConfig.isGameCenterPreloadHippy = paramString.optInt("isPreloadHippy", 0);
      localHippyConfig.checkUpdateGap = paramString.optLong("checkUpdateGap", 120L);
      return localHippyConfig;
    }
    catch (Exception paramString)
    {
      QLog.e(TAG, 1, paramString.toString());
      throw paramString;
    }
  }
  
  public Map<String, TabFile> parseTabJson(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    HashMap localHashMap = null;
    if (bool)
    {
      QLog.i(TAG, 2, "[parseTabJson] jsonStr is empty.");
      return null;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString).optJSONObject("tabFileList");
      if (localJSONObject1 != null)
      {
        localHashMap = new HashMap();
        Iterator localIterator = localJSONObject1.keys();
        for (;;)
        {
          paramString = localHashMap;
          if (!localIterator.hasNext()) {
            break;
          }
          paramString = (String)localIterator.next();
          if (!TextUtils.isEmpty(paramString))
          {
            JSONObject localJSONObject2 = localJSONObject1.optJSONObject(paramString);
            if (localJSONObject2 != null)
            {
              TabFile localTabFile = new TabFile();
              localTabFile.tabFileMd5 = localJSONObject2.optString("tabFileMd5");
              localTabFile.tabFileJson = localJSONObject2.optString("tabFileJson");
              localHashMap.put(paramString, localTabFile);
            }
            else
            {
              QLog.i(TAG, 2, "[getTabFilesConfig] fileObj is empty");
            }
          }
          else
          {
            QLog.i(TAG, 2, "[getTabFilesConfig] key is empty");
          }
        }
      }
      QLog.i(TAG, 2, "[getTabFilesConfig] filesObj is null.");
      paramString = localHashMap;
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e(TAG, 2, paramString.toString());
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void preDownloadHippyByController(int paramInt)
  {
    Object localObject2 = ((ICmGameHelper)QRoute.api(ICmGameHelper.class)).getAppInterface();
    if (!(localObject2 instanceof BaseQQAppInterface))
    {
      QLog.e(TAG, 1, "[preDownloadHippyByController] cur process is not QQProcess, return.");
      return;
    }
    Object localObject1 = new RunnableTask((BaseQQAppInterface)localObject2, "preDownloadHippyKey", new HippyUpdateManager.2(this, paramInt), 0L);
    localObject2 = (IPreDownloadController)((AppInterface)localObject2).getRuntimeService(IPreDownloadController.class, "");
    Object localObject3 = new StringBuilder();
    MobileQQ localMobileQQ = MobileQQ.sMobileQQ;
    ((StringBuilder)localObject3).append(MobileQQ.getContext().getFilesDir().getAbsolutePath());
    ((StringBuilder)localObject3).append("/pddate/edu/gamecenter/");
    localObject3 = ((StringBuilder)localObject3).toString();
    boolean bool = ((IPreDownloadController)localObject2).requestPreDownload(((IHippyUtils)QRoute.api(IHippyUtils.class)).getHippyPreloadBusinessID(), "sed", "preDownloadHippyKey", 2, "https://gamecenter.fake.url", (String)localObject3, 3, 0, true, (AbsPreDownloadTask)localObject1);
    localObject1 = TAG;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[preDownloadHippyByController] ret = ");
    ((StringBuilder)localObject2).append(bool);
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
  }
  
  public void predownloadHippy(int paramInt)
  {
    Object localObject1 = TAG;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[predownloadHippy] source:");
    ((StringBuilder)localObject2).append(paramInt);
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    if ((paramInt == 1) && (((IHippyUtils)QRoute.api(IHippyUtils.class)).getHippySoDownload())) {
      HippyQQLibraryManager.getInstance().preDownload();
    }
    if ((!checkPreDownloadInterval()) && (paramInt != 2))
    {
      QLog.i(TAG, 1, "[preloadHippy] check preloadInterval failed, stop action.");
      return;
    }
    localObject1 = UpdateSetting.getInstance().getAllModuleVersion();
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("source", paramInt);
    ((Bundle)localObject2).putInt("requestId", mCurRequestId);
    ((Bundle)localObject2).putString("uin", this.mCurrentUin);
    HippyUnissoHandler localHippyUnissoHandler = HippyUnissoHandler.getInstance();
    if (localHippyUnissoHandler != null)
    {
      localHippyUnissoHandler.requestPreDownloadConfig(paramInt, (Map)localObject1, this.mLastPreloadTimeStamp, (Bundle)localObject2);
      this.mLastPreloadTimeStamp = NetConnInfoCenter.getServerTimeMillis();
      saveLastPreDownloadTime(this.mLastPreloadTimeStamp);
      return;
    }
    QLog.i(TAG, 1, "[preloadHippy] hippyHandler is null.");
  }
  
  public void removeJsBundleUpdateListener(String paramString, IUpdateListener paramIUpdateListener)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramIUpdateListener == null) {
        return;
      }
      synchronized (this.mJsBundleUpdateListeners)
      {
        paramString = (ArrayList)this.mJsBundleUpdateListeners.get(paramString);
        if (paramString != null) {
          paramString.remove(paramIUpdateListener);
        }
        return;
      }
    }
  }
  
  public void removeListener(IUpdateListener paramIUpdateListener)
  {
    if (paramIUpdateListener == null) {
      return;
    }
    try
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext())
      {
        IUpdateListener localIUpdateListener = (IUpdateListener)((WeakReference)localIterator.next()).get();
        if (localIUpdateListener == null)
        {
          localIterator.remove();
        }
        else if (localIUpdateListener == paramIUpdateListener)
        {
          localIterator.remove();
          return;
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramIUpdateListener;
    }
  }
  
  public void updateJsBundle(String paramString, boolean paramBoolean, int paramInt, Bundle paramBundle, IUpdateListener paramIUpdateListener)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (!AppNetConnInfo.isNetSupport())
    {
      if (paramIUpdateListener != null) {
        paramIUpdateListener.onUpdateFailed(0, -5, "Net unavailable", paramString);
      }
      return;
    }
    int i = UpdateSetting.getInstance().getModuleVersion(paramString);
    if (i < 0) {
      i = 0;
    }
    boolean bool;
    int j;
    if (paramBundle != null)
    {
      bool = paramBundle.getBoolean("isCheckPreload");
      j = paramBundle.getInt("preloadSceneType");
    }
    else
    {
      j = 0;
      bool = false;
    }
    if ((!checkUpdateJsBundleInterval(paramString)) && (i > 0) && (!bool))
    {
      if (paramIUpdateListener != null) {
        paramIUpdateListener.onUpdateFailed(0, -5, "Check update interval", paramString);
      }
      return;
    }
    if (paramIUpdateListener != null) {
      synchronized (this.mJsBundleUpdateListeners)
      {
        ArrayList localArrayList = (ArrayList)this.mJsBundleUpdateListeners.get(paramString);
        paramBundle = localArrayList;
        if (localArrayList == null)
        {
          paramBundle = new ArrayList();
          this.mJsBundleUpdateListeners.put(paramString, paramBundle);
        }
        if (!paramBundle.contains(paramIUpdateListener)) {
          paramBundle.add(paramIUpdateListener);
        }
      }
    }
    paramBundle = new Bundle();
    paramBundle.putInt("source", 4);
    paramBundle.putBoolean("isUseHttpRequest", paramBoolean);
    paramBundle.putBoolean("isCheckPreload", bool);
    paramBundle.putInt("preloadSceneType", j);
    paramBundle.putString("jsBundleName", paramString);
    paramBundle.putLong("requestStartTime", NetConnInfoCenter.getServerTimeMillis());
    paramBundle.putInt("curVersion", i);
    paramBundle.putString("uin", this.mCurrentUin);
    if (paramBoolean) {
      updateJsBundleByHttp(paramString, i, paramBundle, paramIUpdateListener);
    } else {
      updateJsBundleBySSO(paramString, i, paramBundle, paramInt, paramIUpdateListener);
    }
    this.mJsBundleLastUpdateTimes.put(paramString, Long.valueOf(NetConnInfoCenter.getServerTime()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyUpdateManager
 * JD-Core Version:    0.7.0.1
 */