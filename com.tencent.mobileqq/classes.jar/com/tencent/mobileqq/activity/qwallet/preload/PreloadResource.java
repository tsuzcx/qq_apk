package com.tencent.mobileqq.activity.qwallet.preload;

import Wallet.JudgeDownloadReq;
import Wallet.ResInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonServlet;
import com.tencent.mobileqq.activity.qwallet.QWalletSetting;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.shortvideo.util.storage.StorageManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import xfz;
import xga;
import xgb;
import xgc;

public class PreloadResource
  implements Serializable
{
  public static final int FILE_MAX_RETRY_FINISHED_TIMES = 5;
  public static final int FROM_TYPE_MOBILE_QQ = 0;
  public static final int FROM_TYPE_MOGGY = 1;
  public static final int FROM_TYPE_NONE = 0;
  public static final String PARAM_KEY_MODULE = "module";
  public static final String PARAM_KEY_RES = "resource";
  public static final String PARAM_KEY_SCENE = "scene";
  public static final int PRELOAD_DOWNLOAD_NOTIFY_THRESHOLD = 1048576;
  public static final int TYPE_GIF = 2;
  public static final int TYPE_MP3 = 3;
  public static final int TYPE_PNG = 1;
  public static final int TYPE_VIDEO = 5;
  public static final int TYPE_ZIP = 4;
  private static final long serialVersionUID = 1L;
  private transient long jdField_a_of_type_Long;
  private transient PreloadFlowControlConfig jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig;
  public String mDownloadTime;
  public boolean mFlowControl;
  public int mFromType;
  public boolean mHasUnzip;
  public String mInvalidTime;
  public boolean mIsFromLocal;
  public boolean mIsNeedUnzip;
  public boolean mIsTemp;
  public boolean mIsUnzipInside;
  private xgc mReqTask;
  public String mResId;
  public int mRetryTime;
  public String mUnzipPrefix;
  public String md5;
  public String netType;
  public int size;
  public int type;
  public String url;
  public String urlPath;
  
  public PreloadResource() {}
  
  public PreloadResource(PreloadResource paramPreloadResource)
  {
    this();
    this.url = paramPreloadResource.url;
    this.urlPath = paramPreloadResource.urlPath;
    this.type = paramPreloadResource.type;
    this.md5 = paramPreloadResource.md5;
    this.mDownloadTime = paramPreloadResource.mDownloadTime;
    this.mInvalidTime = paramPreloadResource.mInvalidTime;
    this.netType = paramPreloadResource.netType;
    this.size = paramPreloadResource.size;
    this.mResId = paramPreloadResource.mResId;
    this.mFlowControl = paramPreloadResource.mFlowControl;
    this.mIsFromLocal = paramPreloadResource.mIsFromLocal;
    this.mIsTemp = paramPreloadResource.mIsTemp;
    this.mRetryTime = paramPreloadResource.mRetryTime;
    this.mIsNeedUnzip = paramPreloadResource.mIsNeedUnzip;
    this.mIsUnzipInside = paramPreloadResource.mIsUnzipInside;
    this.mUnzipPrefix = paramPreloadResource.mUnzipPrefix;
    this.mHasUnzip = paramPreloadResource.mHasUnzip;
    this.mFromType = paramPreloadResource.mFromType;
  }
  
  private void a(DownloadListener paramDownloadListener, PreloadModule paramPreloadModule, PreloadManager paramPreloadManager)
  {
    if (paramDownloadListener == null) {
      return;
    }
    String str = getResDownloadUrl(paramPreloadModule);
    paramPreloadManager = new DownloadTask(str, new File(paramPreloadManager.d(str)));
    paramPreloadManager.a = 0;
    paramPreloadManager.a(getDownloadParams(paramPreloadModule));
    paramDownloadListener.onDoneFile(paramPreloadManager);
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 146	com/tencent/mobileqq/activity/qwallet/preload/PreloadResource:getCustomUnzipPath	()Ljava/lang/String;
    //   4: astore 4
    //   6: aload 4
    //   8: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +153 -> 164
    //   14: new 113	java/io/File
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 122	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore_1
    //   23: aload_1
    //   24: invokevirtual 156	java/io/File:exists	()Z
    //   27: ifeq +137 -> 164
    //   30: new 158	com/tencent/commonsdk/zip/QZipFile
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 161	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   38: astore_3
    //   39: aload_3
    //   40: astore_1
    //   41: aload_3
    //   42: invokevirtual 165	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   45: astore 5
    //   47: aload_3
    //   48: astore_1
    //   49: aload 5
    //   51: invokeinterface 170 1 0
    //   56: ifeq +109 -> 165
    //   59: aload_3
    //   60: astore_1
    //   61: new 113	java/io/File
    //   64: dup
    //   65: aload 4
    //   67: aload 5
    //   69: invokeinterface 174 1 0
    //   74: checkcast 176	java/util/zip/ZipEntry
    //   77: invokevirtual 179	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   80: invokespecial 182	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: astore 6
    //   85: aload_3
    //   86: astore_1
    //   87: aload 6
    //   89: invokevirtual 185	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   92: invokestatic 190	com/tencent/mobileqq/utils/FileUtils:d	(Ljava/lang/String;)Z
    //   95: istore_2
    //   96: aload_3
    //   97: astore_1
    //   98: invokestatic 195	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   101: ifeq -54 -> 47
    //   104: aload_3
    //   105: astore_1
    //   106: ldc 197
    //   108: iconst_2
    //   109: new 199	java/lang/StringBuilder
    //   112: dup
    //   113: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   116: ldc 202
    //   118: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: iload_2
    //   122: invokevirtual 209	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   125: ldc 211
    //   127: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload 6
    //   132: invokevirtual 185	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   135: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   141: invokestatic 218	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: goto -97 -> 47
    //   147: astore 4
    //   149: aload_3
    //   150: astore_1
    //   151: aload 4
    //   153: invokevirtual 221	java/lang/Throwable:printStackTrace	()V
    //   156: aload_3
    //   157: ifnull +7 -> 164
    //   160: aload_3
    //   161: invokevirtual 224	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   164: return
    //   165: aload_3
    //   166: ifnull -2 -> 164
    //   169: aload_3
    //   170: invokevirtual 224	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   173: return
    //   174: astore_1
    //   175: aload_1
    //   176: invokevirtual 221	java/lang/Throwable:printStackTrace	()V
    //   179: return
    //   180: astore_1
    //   181: aload_1
    //   182: invokevirtual 221	java/lang/Throwable:printStackTrace	()V
    //   185: return
    //   186: astore_3
    //   187: aconst_null
    //   188: astore_1
    //   189: aload_1
    //   190: ifnull +7 -> 197
    //   193: aload_1
    //   194: invokevirtual 224	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   197: aload_3
    //   198: athrow
    //   199: astore_1
    //   200: aload_1
    //   201: invokevirtual 221	java/lang/Throwable:printStackTrace	()V
    //   204: goto -7 -> 197
    //   207: astore_3
    //   208: goto -19 -> 189
    //   211: astore 4
    //   213: aconst_null
    //   214: astore_3
    //   215: goto -66 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	PreloadResource
    //   0	218	1	paramString	String
    //   95	27	2	bool	boolean
    //   38	132	3	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   186	12	3	localObject1	Object
    //   207	1	3	localObject2	Object
    //   214	1	3	localObject3	Object
    //   4	62	4	str	String
    //   147	5	4	localThrowable1	Throwable
    //   211	1	4	localThrowable2	Throwable
    //   45	23	5	localEnumeration	java.util.Enumeration
    //   83	48	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   41	47	147	java/lang/Throwable
    //   49	59	147	java/lang/Throwable
    //   61	85	147	java/lang/Throwable
    //   87	96	147	java/lang/Throwable
    //   98	104	147	java/lang/Throwable
    //   106	144	147	java/lang/Throwable
    //   169	173	174	java/lang/Throwable
    //   160	164	180	java/lang/Throwable
    //   30	39	186	finally
    //   193	197	199	java/lang/Throwable
    //   41	47	207	finally
    //   49	59	207	finally
    //   61	85	207	finally
    //   87	96	207	finally
    //   98	104	207	finally
    //   106	144	207	finally
    //   151	156	207	finally
    //   30	39	211	java/lang/Throwable
  }
  
  private static boolean a(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    long l1 = 0L;
    if (!TextUtils.isEmpty(paramString))
    {
      long l2 = StorageManager.a(paramString);
      l1 = l2;
      if (l2 > 52428800L)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PreloadResource", 2, "isDiskEnoughToUnzip|true|" + paramString + "|" + l2);
        }
        return true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreloadResource", 2, "isDiskEnoughToUnzip|false|" + paramString + "|" + l1);
    }
    return false;
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if (this.mIsNeedUnzip)
    {
      this.mHasUnzip = hasFullyUnzip(paramString1);
      if (this.mHasUnzip) {}
    }
    else
    {
      while ((isNeedAutoUnzip(paramString2, this.type)) && (!isFolderPathValid(getFolderPath(paramString2, paramString1)))) {
        return true;
      }
    }
    return false;
  }
  
  public static String getFolderPathByMD5AndUrl(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString1 = MD5.toMD5(paramString2 + paramString1);
      return PreloadManager.a() + paramString1;
    }
    return null;
  }
  
  public static boolean isFolderPathValid(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (new File(paramString).exists()) && (FileUtils.b(paramString) > 0L);
  }
  
  public static boolean isNeedAutoUnzip(String paramString, int paramInt)
  {
    return (paramInt == 4) || ((paramString != null) && (paramString.length() > 5) && (paramString.substring(paramString.length() - 4).equals(".zip")));
  }
  
  public static boolean isValidToReport(long paramLong1, long paramLong2)
  {
    return Math.abs(paramLong2 - paramLong1) > 1000L;
  }
  
  public static PreloadResource parsePreloadResource(JSONObject paramJSONObject, PreloadModule paramPreloadModule, boolean paramBoolean, int paramInt)
  {
    boolean bool2 = true;
    PreloadResource localPreloadResource = new PreloadResource();
    for (;;)
    {
      try
      {
        localPreloadResource.url = paramJSONObject.optString("url");
        localPreloadResource.urlPath = paramJSONObject.optString("url_path");
        localPreloadResource.type = paramJSONObject.optInt("type");
        localPreloadResource.md5 = paramJSONObject.optString("md5");
        localPreloadResource.mDownloadTime = paramJSONObject.optString("download_time");
        localPreloadResource.mInvalidTime = paramJSONObject.optString("invalid_time");
        localPreloadResource.netType = paramJSONObject.optString("net_type");
        localPreloadResource.size = paramJSONObject.optInt("size");
        if (paramJSONObject.optInt("flow_control") == 1)
        {
          bool1 = true;
          localPreloadResource.mFlowControl = bool1;
          localPreloadResource.mIsFromLocal = paramBoolean;
          if (paramJSONObject.optInt("is_temp") != 1) {
            break label263;
          }
          paramBoolean = true;
          localPreloadResource.mIsTemp = paramBoolean;
          if (paramJSONObject.optInt("is_need_unzip") != 1) {
            break label268;
          }
          paramBoolean = true;
          localPreloadResource.mIsNeedUnzip = paramBoolean;
          if (paramJSONObject.optInt("is_unzip_inside") != 1) {
            break label273;
          }
          paramBoolean = bool2;
          localPreloadResource.mIsUnzipInside = paramBoolean;
          localPreloadResource.mUnzipPrefix = paramJSONObject.optString("unzip_prefix");
          localPreloadResource.mFromType = paramInt;
          paramJSONObject = paramJSONObject.optString("res_id");
          if (!TextUtils.isEmpty(paramJSONObject))
          {
            localPreloadResource.mResId = paramJSONObject;
            return localPreloadResource;
          }
          localPreloadResource.mResId = localPreloadResource.getResDownloadUrl(paramPreloadModule);
          return localPreloadResource;
        }
      }
      catch (Throwable paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return localPreloadResource;
      }
      boolean bool1 = false;
      continue;
      label263:
      paramBoolean = false;
      continue;
      label268:
      paramBoolean = false;
      continue;
      label273:
      paramBoolean = false;
    }
  }
  
  /* Error */
  public static boolean unzipAtomically(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: iload_3
    //   6: istore_2
    //   7: aload_0
    //   8: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +14 -> 25
    //   14: aload_1
    //   15: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: istore_2
    //   19: iload_2
    //   20: ifeq +10 -> 30
    //   23: iload_3
    //   24: istore_2
    //   25: ldc 2
    //   27: monitorexit
    //   28: iload_2
    //   29: ireturn
    //   30: iload_3
    //   31: istore_2
    //   32: aload_1
    //   33: invokestatic 341	com/tencent/mobileqq/activity/qwallet/preload/PreloadResource:a	(Ljava/lang/String;)Z
    //   36: ifeq -11 -> 25
    //   39: aload_0
    //   40: aload_1
    //   41: invokestatic 344	com/tencent/mobileqq/activity/qwallet/utils/QWalletTools:a	(Ljava/lang/String;Ljava/lang/String;)Z
    //   44: istore_2
    //   45: goto -20 -> 25
    //   48: astore_0
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	paramString1	String
    //   0	54	1	paramString2	String
    //   6	39	2	bool1	boolean
    //   1	30	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   7	19	48	finally
    //   32	45	48	finally
  }
  
  /* Error */
  public static boolean unzipToCustomPath(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 2
    //   4: monitorenter
    //   5: iload_3
    //   6: istore_2
    //   7: aload_0
    //   8: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +14 -> 25
    //   14: aload_1
    //   15: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   18: istore_2
    //   19: iload_2
    //   20: ifeq +10 -> 30
    //   23: iload_3
    //   24: istore_2
    //   25: ldc 2
    //   27: monitorexit
    //   28: iload_2
    //   29: ireturn
    //   30: iload_3
    //   31: istore_2
    //   32: aload_1
    //   33: invokestatic 341	com/tencent/mobileqq/activity/qwallet/preload/PreloadResource:a	(Ljava/lang/String;)Z
    //   36: ifeq -11 -> 25
    //   39: aload_0
    //   40: aload_1
    //   41: iconst_1
    //   42: invokestatic 348	com/tencent/mobileqq/activity/qwallet/utils/QWalletTools:a	(Ljava/lang/String;Ljava/lang/String;Z)Z
    //   45: istore_2
    //   46: goto -21 -> 25
    //   49: astore_0
    //   50: ldc 2
    //   52: monitorexit
    //   53: aload_0
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramString1	String
    //   0	55	1	paramString2	String
    //   6	40	2	bool1	boolean
    //   1	30	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   7	19	49	finally
    //   32	46	49	finally
  }
  
  public void deleteResFile(PreloadModule paramPreloadModule, PreloadManager paramPreloadManager, int paramInt)
  {
    FileUtils.d(PreloadFlowControlConfig.getConfigPath(this.mResId, paramPreloadManager.a));
    paramPreloadModule = getResDownloadUrl(paramPreloadModule);
    paramPreloadManager = paramPreloadManager.d(paramPreloadModule);
    ResDownRecordUtil.a(paramPreloadModule, paramInt);
    if (this.mIsNeedUnzip) {
      a(paramPreloadManager);
    }
    for (;;)
    {
      FileUtils.d(paramPreloadManager);
      ResUtil.b(paramPreloadModule);
      return;
      if (isNeedAutoUnzip(paramPreloadModule, this.type))
      {
        String str = getFolderPath(this.url, paramPreloadManager);
        if (!TextUtils.isEmpty(str)) {
          FileUtils.a(str, false);
        }
      }
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof PreloadResource)))
    {
      paramObject = (PreloadResource)paramObject;
      if (QWalletTools.c(this.mResId, paramObject.mResId)) {
        return true;
      }
    }
    return false;
  }
  
  public String getCustomUnzipPath()
  {
    Object localObject2 = null;
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1 = localObject2;
    if (this.mIsNeedUnzip)
    {
      localObject1 = localObject2;
      if (!TextUtils.isEmpty(this.mUnzipPrefix))
      {
        localObject1 = localObject2;
        if (localAppRuntime != null) {
          localObject1 = PreloadManager.a(localAppRuntime, this.mIsUnzipInside, this.mUnzipPrefix);
        }
      }
    }
    return localObject1;
  }
  
  public Bundle getDownloadParams(PreloadModule paramPreloadModule)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("module", paramPreloadModule);
    localBundle.putSerializable("resource", this);
    return localBundle;
  }
  
  public DownloadListener getFlowControlDownloadListener(long paramLong, DownloadListener paramDownloadListener, PreloadManager paramPreloadManager, int paramInt)
  {
    return new xga(this, paramInt, new WeakReference(paramPreloadManager), paramDownloadListener, paramLong);
  }
  
  public String getFolderPath(String paramString1, String paramString2)
  {
    if (isNeedAutoUnzip(paramString1, this.type)) {
      return getFolderPathByMD5AndUrl(ResUtil.b(paramString1, paramString2), paramString1);
    }
    return null;
  }
  
  public ArrayList getMyResInfos()
  {
    return getMyResInfos(this.size);
  }
  
  public ArrayList getMyResInfos(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    ResInfo localResInfo = new ResInfo();
    try
    {
      localResInfo.sResId = this.mResId;
      localResInfo.iSize = paramInt;
      localArrayList.add(localResInfo);
      return localArrayList;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  public String getResDownloadUrl(PreloadModule paramPreloadModule)
  {
    if (!TextUtils.isEmpty(this.url)) {
      return this.url;
    }
    return paramPreloadModule.mBaseUrl + "/" + this.urlPath;
  }
  
  public ResourceInfo getResInfo(PreloadModule paramPreloadModule, PreloadManager paramPreloadManager)
  {
    paramPreloadModule = getResDownloadUrl(paramPreloadModule);
    if (!this.mIsNeedUnzip) {}
    for (boolean bool = true;; bool = false)
    {
      paramPreloadModule = ResUtil.a(paramPreloadModule, paramPreloadManager, bool, this.type);
      paramPreloadModule.type = this.type;
      paramPreloadModule.resId = this.mResId;
      return paramPreloadModule;
    }
  }
  
  public void handleFlowConfig(PreloadManager paramPreloadManager, PreloadModule paramPreloadModule, DownloadListener paramDownloadListener)
  {
    for (;;)
    {
      long l1;
      try
      {
        if (isResFileExist(paramPreloadModule, paramPreloadManager))
        {
          if (isNeedUnzip(paramPreloadModule, paramPreloadManager)) {
            unzip(paramPreloadManager.d(getResDownloadUrl(paramPreloadModule)), getResDownloadUrl(paramPreloadModule));
          }
          if (paramDownloadListener != null) {
            a(paramDownloadListener, paramPreloadModule, paramPreloadManager);
          }
          paramPreloadManager.d();
          return;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig == null) {
          this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig = PreloadFlowControlConfig.getFlowControlConfig(this.mResId, paramPreloadManager.a);
        }
        if (QLog.isColorLevel()) {
          QLog.d("PreloadResource", 2, this.mResId + "handleFlowConfig:" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig.mDownloadStatus);
        }
        l1 = paramPreloadManager.a.getLongAccountUin();
        switch (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig.mDownloadStatus)
        {
        case -1: 
          paramPreloadManager.d();
          continue;
          startFlowControlReq(JudgeDownloadReq.createReq(getMyResInfos(), l1, 0), paramPreloadManager, paramPreloadModule, paramDownloadListener);
        }
      }
      finally {}
      continue;
      long l2 = NetConnInfoCenter.getServerTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("PreloadResource", 2, this.mResId + "STATUS_NOW_DOWNLOAD|" + l2 + "|" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig.mValidDownloadTime);
      }
      if (l2 < this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig.mValidDownloadTime)
      {
        if (isTimeToDownload(paramPreloadManager, paramPreloadModule))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PreloadResource", 2, this.mResId + "begin download");
          }
          startDownloadRes(paramPreloadModule, paramPreloadManager, getFlowControlDownloadListener(l1, paramDownloadListener, paramPreloadManager, this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig.mRetryDownloadTimes), true);
        }
        else
        {
          paramPreloadManager.d();
          if (paramDownloadListener != null) {
            notifyListenerDownloadFailInFlowControl(paramDownloadListener, paramPreloadModule, paramPreloadManager);
          }
        }
      }
      else
      {
        startFlowControlReq(JudgeDownloadReq.createReq(getMyResInfos(), l1, 0), paramPreloadManager, paramPreloadModule, paramDownloadListener);
        continue;
        l2 = NetConnInfoCenter.getServerTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("PreloadResource", 2, this.mResId + " STATUS_NOT_DOWNLOAD|" + l2 + "|" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig.mNextCanReqTime);
        }
        if (l2 > this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig.mNextCanReqTime)
        {
          startFlowControlReq(JudgeDownloadReq.createReq(getMyResInfos(), l1, 0), paramPreloadManager, paramPreloadModule, paramDownloadListener);
        }
        else
        {
          paramPreloadManager.d();
          if (paramDownloadListener != null)
          {
            notifyListenerDownloadFailInFlowControl(paramDownloadListener, paramPreloadModule, paramPreloadManager);
            continue;
            l2 = NetConnInfoCenter.getServerTimeMillis();
            long l3 = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig.mNextRetryReqTime - l2;
            if (QLog.isColorLevel()) {
              QLog.d("PreloadResource", 2, this.mResId + "STATUS_WAIT_TO_REQ|" + l2 + "|" + this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig.mNextRetryReqTime + "|" + l3);
            }
            if (l3 <= 0L)
            {
              ArrayList localArrayList = getMyResInfos();
              PreloadFlowControlConfig localPreloadFlowControlConfig = this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadFlowControlConfig;
              int i = localPreloadFlowControlConfig.mRetryReqTimes + 1;
              localPreloadFlowControlConfig.mRetryReqTimes = i;
              startFlowControlReq(JudgeDownloadReq.createReq(localArrayList, l1, i), paramPreloadManager, paramPreloadModule, paramDownloadListener);
            }
            else
            {
              if ((this.mReqTask == null) || (this.mReqTask.a()))
              {
                this.mReqTask = new xfz(this, new WeakReference(paramPreloadManager), paramPreloadModule);
                ThreadManager.getTimer().schedule(this.mReqTask, l3);
              }
              paramPreloadManager.d();
              if (paramDownloadListener != null) {
                notifyListenerDownloadFailInFlowControl(paramDownloadListener, paramPreloadModule, paramPreloadManager);
              }
            }
          }
        }
      }
    }
  }
  
  /* Error */
  public boolean hasFullyUnzip(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 146	com/tencent/mobileqq/activity/qwallet/preload/PreloadResource:getCustomUnzipPath	()Ljava/lang/String;
    //   4: astore 4
    //   6: aload 4
    //   8: invokestatic 152	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   11: ifne +180 -> 191
    //   14: new 113	java/io/File
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 122	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore_1
    //   23: aload_1
    //   24: invokevirtual 156	java/io/File:exists	()Z
    //   27: ifeq +164 -> 191
    //   30: new 158	com/tencent/commonsdk/zip/QZipFile
    //   33: dup
    //   34: aload_1
    //   35: invokespecial 161	com/tencent/commonsdk/zip/QZipFile:<init>	(Ljava/io/File;)V
    //   38: astore_2
    //   39: aload_2
    //   40: astore_1
    //   41: aload_2
    //   42: invokevirtual 165	com/tencent/commonsdk/zip/QZipFile:entries	()Ljava/util/Enumeration;
    //   45: astore_3
    //   46: aload_2
    //   47: astore_1
    //   48: aload_3
    //   49: invokeinterface 170 1 0
    //   54: ifeq +129 -> 183
    //   57: aload_2
    //   58: astore_1
    //   59: aload_3
    //   60: invokeinterface 174 1 0
    //   65: checkcast 176	java/util/zip/ZipEntry
    //   68: astore 5
    //   70: aload_2
    //   71: astore_1
    //   72: new 113	java/io/File
    //   75: dup
    //   76: aload 4
    //   78: aload 5
    //   80: invokevirtual 179	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   83: invokespecial 182	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: astore 6
    //   88: aload_2
    //   89: astore_1
    //   90: aload 6
    //   92: invokevirtual 156	java/io/File:exists	()Z
    //   95: ifeq +31 -> 126
    //   98: aload_2
    //   99: astore_1
    //   100: aload 6
    //   102: invokevirtual 562	java/io/File:length	()J
    //   105: lconst_0
    //   106: lcmp
    //   107: ifeq -61 -> 46
    //   110: aload_2
    //   111: astore_1
    //   112: aload 5
    //   114: invokevirtual 565	java/util/zip/ZipEntry:getSize	()J
    //   117: aload 6
    //   119: invokevirtual 562	java/io/File:length	()J
    //   122: lcmp
    //   123: ifeq -77 -> 46
    //   126: aload_2
    //   127: astore_1
    //   128: invokestatic 195	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +35 -> 166
    //   134: aload_2
    //   135: astore_1
    //   136: ldc 197
    //   138: iconst_2
    //   139: new 199	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   146: ldc_w 567
    //   149: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload 6
    //   154: invokevirtual 185	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   157: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 241	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: aload_2
    //   167: ifnull +7 -> 174
    //   170: aload_2
    //   171: invokevirtual 224	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   174: iconst_0
    //   175: ireturn
    //   176: astore_1
    //   177: aload_1
    //   178: invokevirtual 221	java/lang/Throwable:printStackTrace	()V
    //   181: iconst_0
    //   182: ireturn
    //   183: aload_2
    //   184: ifnull +7 -> 191
    //   187: aload_2
    //   188: invokevirtual 224	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   191: invokestatic 195	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   194: ifeq +30 -> 224
    //   197: ldc 197
    //   199: iconst_2
    //   200: new 199	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   207: ldc_w 569
    //   210: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload 4
    //   215: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 214	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 218	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   224: iconst_1
    //   225: ireturn
    //   226: astore_1
    //   227: aload_1
    //   228: invokevirtual 221	java/lang/Throwable:printStackTrace	()V
    //   231: goto -40 -> 191
    //   234: astore_3
    //   235: aconst_null
    //   236: astore_2
    //   237: aload_2
    //   238: astore_1
    //   239: aload_3
    //   240: invokevirtual 221	java/lang/Throwable:printStackTrace	()V
    //   243: aload_2
    //   244: ifnull -53 -> 191
    //   247: aload_2
    //   248: invokevirtual 224	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   251: goto -60 -> 191
    //   254: astore_1
    //   255: aload_1
    //   256: invokevirtual 221	java/lang/Throwable:printStackTrace	()V
    //   259: goto -68 -> 191
    //   262: astore_2
    //   263: aconst_null
    //   264: astore_1
    //   265: aload_1
    //   266: ifnull +7 -> 273
    //   269: aload_1
    //   270: invokevirtual 224	com/tencent/commonsdk/zip/QZipFile:close	()V
    //   273: aload_2
    //   274: athrow
    //   275: astore_1
    //   276: aload_1
    //   277: invokevirtual 221	java/lang/Throwable:printStackTrace	()V
    //   280: goto -7 -> 273
    //   283: astore_2
    //   284: goto -19 -> 265
    //   287: astore_3
    //   288: goto -51 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	this	PreloadResource
    //   0	291	1	paramString	String
    //   38	210	2	localQZipFile	com.tencent.commonsdk.zip.QZipFile
    //   262	12	2	localObject1	Object
    //   283	1	2	localObject2	Object
    //   45	15	3	localEnumeration	java.util.Enumeration
    //   234	6	3	localThrowable1	Throwable
    //   287	1	3	localThrowable2	Throwable
    //   4	210	4	str	String
    //   68	45	5	localZipEntry	java.util.zip.ZipEntry
    //   86	67	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   170	174	176	java/lang/Throwable
    //   187	191	226	java/lang/Throwable
    //   30	39	234	java/lang/Throwable
    //   247	251	254	java/lang/Throwable
    //   30	39	262	finally
    //   269	273	275	java/lang/Throwable
    //   41	46	283	finally
    //   48	57	283	finally
    //   59	70	283	finally
    //   72	88	283	finally
    //   90	98	283	finally
    //   100	110	283	finally
    //   112	126	283	finally
    //   128	134	283	finally
    //   136	166	283	finally
    //   239	243	283	finally
    //   41	46	287	java/lang/Throwable
    //   48	57	287	java/lang/Throwable
    //   59	70	287	java/lang/Throwable
    //   72	88	287	java/lang/Throwable
    //   90	98	287	java/lang/Throwable
    //   100	110	287	java/lang/Throwable
    //   112	126	287	java/lang/Throwable
    //   128	134	287	java/lang/Throwable
    //   136	166	287	java/lang/Throwable
  }
  
  public boolean isChosenToReport()
  {
    int i = 10000;
    QQAppInterface localQQAppInterface = QWalletTools.a();
    if (localQQAppInterface == null) {
      return false;
    }
    QWalletConfigManager localQWalletConfigManager = (QWalletConfigManager)localQQAppInterface.getManager(244);
    if (localQWalletConfigManager == null) {}
    while (i == 0)
    {
      return false;
      i = localQWalletConfigManager.a("report", 10000, new String[] { "preDownSampleBase" });
    }
    int k = QWalletSetting.a(localQQAppInterface.c(), "download_report_random", 0);
    int j = k;
    if (k == 0)
    {
      j = new Random(localQQAppInterface.getLongAccountUin()).nextInt();
      QWalletSetting.a(localQQAppInterface.c(), "download_report_random", j);
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreloadResource", 2, "isChosenToReport|" + j + "|" + i);
    }
    return j % i == 0;
  }
  
  public boolean isInValidTime()
  {
    long l1 = QWalletTools.a(this.mInvalidTime);
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    if ((l1 != -1L) && (l1 < l2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadResource", 2, this.mResId + " out of date");
      }
      return false;
    }
    return true;
  }
  
  public boolean isNeedDeleteOldFileWhenUpdate(PreloadModule paramPreloadModule, PreloadResource paramPreloadResource, PreloadManager paramPreloadManager)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!this.md5.equalsIgnoreCase(paramPreloadResource.md5))
    {
      paramPreloadModule = getResDownloadUrl(paramPreloadModule);
      paramPreloadManager = paramPreloadManager.d(paramPreloadModule);
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramPreloadResource.md5))
      {
        bool1 = bool2;
        if (!paramPreloadResource.md5.equalsIgnoreCase(ResUtil.b(paramPreloadModule, paramPreloadManager))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean isNeedForceDeleteConfig(PreloadModule paramPreloadModule)
  {
    int i = ResUtil.a(getResDownloadUrl(paramPreloadModule));
    if (QLog.isColorLevel()) {
      QLog.d("PreloadResource", 2, "abRTimes:" + this.mResId + "|" + i);
    }
    return i > 5;
  }
  
  public boolean isNeedReport(String paramString)
  {
    if (!isChosenToReport()) {
      return false;
    }
    if (!this.mIsFromLocal) {
      return true;
    }
    Object localObject1 = QWalletTools.a();
    if (localObject1 != null)
    {
      Object localObject2 = (QWalletConfigManager)((QQAppInterface)localObject1).getManager(244);
      if (localObject2 != null)
      {
        localObject2 = ((QWalletConfigManager)localObject2).a("preload");
        if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).contains(paramString))) {
          return true;
        }
      }
      localObject1 = PreloadManager.a(((QQAppInterface)localObject1).c());
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).contains(paramString))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean isNeedUnzip(PreloadModule paramPreloadModule, PreloadManager paramPreloadManager)
  {
    if ((paramPreloadManager != null) && (paramPreloadModule != null)) {
      return a(paramPreloadManager.d(getResDownloadUrl(paramPreloadModule)), getResDownloadUrl(paramPreloadModule));
    }
    return false;
  }
  
  public boolean isResChange(PreloadResource paramPreloadResource)
  {
    if (!QWalletTools.c(this.url, paramPreloadResource.url)) {}
    while ((!QWalletTools.c(this.urlPath, paramPreloadResource.urlPath)) || (this.type != paramPreloadResource.type) || (!QWalletTools.c(this.md5, paramPreloadResource.md5)) || (!QWalletTools.c(this.mDownloadTime, paramPreloadResource.mDownloadTime)) || (!QWalletTools.c(this.mInvalidTime, paramPreloadResource.mInvalidTime)) || (!QWalletTools.c(this.netType, paramPreloadResource.netType)) || (this.size != paramPreloadResource.size) || (this.mFlowControl != paramPreloadResource.mFlowControl) || (!QWalletTools.c(this.mResId, paramPreloadResource.mResId)) || (this.mIsFromLocal != paramPreloadResource.mIsFromLocal) || (this.mIsTemp != paramPreloadResource.mIsTemp) || (this.mRetryTime != paramPreloadResource.mRetryTime) || (this.mIsNeedUnzip != paramPreloadResource.mIsNeedUnzip) || (this.mIsUnzipInside != paramPreloadResource.mIsUnzipInside) || (!QWalletTools.c(this.mUnzipPrefix, paramPreloadResource.mUnzipPrefix)) || (this.mHasUnzip != paramPreloadResource.mHasUnzip) || (this.mFromType != paramPreloadResource.mFromType)) {
      return true;
    }
    return false;
  }
  
  public boolean isResFileExist(PreloadModule paramPreloadModule, PreloadManager paramPreloadManager)
  {
    paramPreloadModule = getResDownloadUrl(paramPreloadModule);
    if (new File(paramPreloadManager.d(paramPreloadModule)).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("PreloadResource", 2, "ResFileExist|" + this.mResId + "|" + paramPreloadModule);
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PreloadResource", 2, "ResFileNotExist|" + this.mResId + "|" + paramPreloadModule);
    }
    return false;
  }
  
  public boolean isTimeToDownload(PreloadManager paramPreloadManager, PreloadModule paramPreloadModule)
  {
    long l1 = NetConnInfoCenter.getServerTimeMillis();
    long l2 = QWalletTools.a(this.mDownloadTime);
    return ((l2 == -1L) || (l2 < l1)) && (paramPreloadManager.a(this.netType));
  }
  
  public void notifyListenerDownloadFailInFlowControl(DownloadListener paramDownloadListener, PreloadModule paramPreloadModule, PreloadManager paramPreloadManager)
  {
    if (paramDownloadListener == null) {
      return;
    }
    String str = getResDownloadUrl(paramPreloadModule);
    paramPreloadManager = new DownloadTask(str, new File(paramPreloadManager.d(str)));
    paramPreloadManager.a = -5;
    paramPreloadManager.a(getDownloadParams(paramPreloadModule));
    paramDownloadListener.onDoneFile(paramPreloadManager);
  }
  
  public void reportDownload(String paramString, int paramInt, PreloadModule paramPreloadModule)
  {
    if (isValidToReport(this.jdField_a_of_type_Long, System.currentTimeMillis()))
    {
      this.jdField_a_of_type_Long = System.currentTimeMillis();
      if (paramInt != 0) {
        break label99;
      }
      paramInt = 0;
      if (paramPreloadModule != null) {
        break label104;
      }
    }
    label99:
    label104:
    for (paramPreloadModule = "";; paramPreloadModule = paramPreloadModule.mid)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt).append("|").append(paramPreloadModule).append("|").append(this.mResId).append("|").append(paramString);
      VACDReportUtil.a(localStringBuilder.toString(), "QWalletStat", "downloadReport", null, null, 0, null);
      return;
      paramInt = 1;
      break;
    }
  }
  
  public void startDownload(PreloadManager paramPreloadManager, PreloadModule paramPreloadModule, DownloadListener paramDownloadListener, boolean paramBoolean)
  {
    if (this.mFlowControl)
    {
      paramPreloadManager.a(this, paramPreloadModule, paramDownloadListener);
      return;
    }
    startDownloadRes(paramPreloadModule, paramPreloadManager, paramDownloadListener, paramBoolean);
  }
  
  public void startDownloadRes(PreloadModule paramPreloadModule, PreloadManager paramPreloadManager, DownloadListener paramDownloadListener, boolean paramBoolean)
  {
    String str1 = getResDownloadUrl(paramPreloadModule);
    String str2 = paramPreloadManager.d(str1);
    Bundle localBundle = getDownloadParams(paramPreloadModule);
    if (isResFileExist(paramPreloadModule, paramPreloadManager))
    {
      if (isNeedUnzip(paramPreloadModule, paramPreloadManager)) {
        unzip(str2, str1);
      }
      a(paramDownloadListener, paramPreloadModule, paramPreloadManager);
    }
    while (TextUtils.isEmpty(str1)) {
      return;
    }
    PreloadComDownloader.a().a(str1, str2, localBundle, new PreloadResource.DefaultDownloadListener(this, paramDownloadListener), paramBoolean);
  }
  
  public void startFlowControlReq(JudgeDownloadReq paramJudgeDownloadReq, PreloadManager paramPreloadManager, PreloadModule paramPreloadModule, DownloadListener paramDownloadListener)
  {
    QWalletCommonServlet.a(paramJudgeDownloadReq, new xgb(this, new WeakReference(paramPreloadManager), paramDownloadListener, paramPreloadModule), 1);
  }
  
  public String toString()
  {
    return "Res [" + this.mResId + "|" + this.mFlowControl + "|" + this.mIsFromLocal + "|" + this.mIsNeedUnzip + "|" + this.mIsUnzipInside + "|" + this.mUnzipPrefix + "|" + this.mHasUnzip + "|" + this.mFromType + "]";
  }
  
  public void unzip(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    boolean bool;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!this.mIsNeedUnzip) {
              break;
            }
            paramString2 = getCustomUnzipPath();
          } while ((TextUtils.isEmpty(paramString2)) || (!new File(paramString1).exists()) || (!a(paramString2)));
          unzipToCustomPath(paramString1, paramString2);
          this.mHasUnzip = true;
        } while (!QLog.isColorLevel());
        QLog.d("PreloadResource", 2, "preload unzip" + paramString2);
        return;
        paramString2 = getFolderPath(paramString2, paramString1);
      } while (TextUtils.isEmpty(paramString2));
      bool = unzipAtomically(paramString1, paramString2);
    } while (!QLog.isColorLevel());
    QLog.d("PreloadResource", 2, "default unzip" + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadResource
 * JD-Core Version:    0.7.0.1
 */