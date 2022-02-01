package com.tencent.aekit.api.standard;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.filter.AEFaceBeauty;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.AEProfiler;
import com.tencent.camerasdk.avreport.AVReportCenter;
import com.tencent.ttpic.AEBaseConfig;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.filter.aifilter.NetworkRequest;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.initializer.MaskImagesInitializer;
import com.tencent.ttpic.openapi.initializer.YTCommonInitializer;
import com.tencent.ttpic.openapi.manager.FaceBeautyManager;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.manager.FeatureManager.Features;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.CfConfig;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.ttpic.util.DecryptListener;
import com.tencent.ttpic.util.MustRunOnGLThread;
import java.io.File;
import java.util.concurrent.Executor;

public class AEModule
{
  private static final String[] AEKIT_FORMER_VERSION = { "1.0.0", "1.1.0", "1.2.0", "1.3.0", "1.4.0", "1.5.0", "1.6.0", "1.7.0", "1.7.1", "1.7.2", "1.7.3", "1.7.4", "1.7.5", "1.7.6", "1.7.7", "1.7.8", "1.7.9", "1.8.0", "1.8.1", "1.8.2", "1.8.4", "1.8.5", "1.8.7", "2.0.0" };
  private static final String AEKIT_VERSION = "2.0.0";
  private static final String AEKIT_VERSION_FILE = "aekit_meta.txt";
  public static final String DEFAULT_LICENSE_NAME = "com_tencent_2118.lic";
  private static final String DEFAULT_RESOURCE_DIR;
  private static final String TAG = "AEKitModule";
  private static String aekitVersion;
  private static boolean debugMode;
  private static boolean enableDefaultBasic3;
  private static boolean enableReducedMeidaLibrary;
  private static DecryptListener mDecryptListener = new AEModule.1();
  private static String mLicense;
  private static int mLicenseInitType;
  private static String mLutDirPath;
  private static String mModelPath;
  private static String mSoPath;
  private static NetworkRequest networkRequest;
  private static Context sContext;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tencent");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("aekit");
    DEFAULT_RESOURCE_DIR = localStringBuilder.toString();
    aekitVersion = null;
    debugMode = false;
    mModelPath = null;
    mSoPath = null;
    mLutDirPath = null;
    enableDefaultBasic3 = false;
    enableReducedMeidaLibrary = false;
    networkRequest = null;
  }
  
  @MustRunOnGLThread
  public static void clear()
  {
    ShaderManager.getInstance().clear();
    VideoMemoryManager.getInstance().clearBeautyCache();
  }
  
  public static Context getContext()
  {
    return sContext;
  }
  
  public static String[] getFormerVersions()
  {
    return AEKIT_FORMER_VERSION;
  }
  
  public static String getLicense()
  {
    return mLicense;
  }
  
  public static int getLicenseInitType()
  {
    return mLicenseInitType;
  }
  
  public static String getLutDirPath()
  {
    return mLutDirPath;
  }
  
  public static NetworkRequest getNetworkRequest()
  {
    return networkRequest;
  }
  
  public static String getResouceRoot()
  {
    if (getContext() == null) {
      return null;
    }
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getContext().getExternalFilesDir(null).getAbsolutePath());
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(DEFAULT_RESOURCE_DIR);
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  @Deprecated
  public static String getVersion()
  {
    if (!TextUtils.isEmpty(aekitVersion)) {
      return aekitVersion;
    }
    Object localObject = sContext;
    if (localObject == null)
    {
      aekitVersion = "2.0.0";
    }
    else
    {
      localObject = FileUtils.loadAssetsString((Context)localObject, "aekit_meta.txt");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        aekitVersion = "2.0.0";
      } else {
        aekitVersion = localObject.split("\n")[0];
      }
    }
    return aekitVersion;
  }
  
  @Deprecated
  public static String getVersion(Context paramContext)
  {
    if (aekitVersion == null)
    {
      paramContext = FileUtils.loadAssetsString(paramContext, "aekit_meta.txt");
      if (TextUtils.isEmpty(paramContext)) {
        aekitVersion = "2.0.0";
      } else {
        aekitVersion = paramContext.split("\n")[0];
      }
    }
    return aekitVersion;
  }
  
  private static boolean initImpl(Context paramContext, AEModuleConfig paramAEModuleConfig, boolean paramBoolean)
  {
    mLutDirPath = paramAEModuleConfig.getLutDir();
    mModelPath = paramAEModuleConfig.getModelDir();
    enableDefaultBasic3 = paramAEModuleConfig.isEnableDefaultBasic3();
    mSoPath = paramAEModuleConfig.getSoDir();
    mLicense = paramAEModuleConfig.getLicense();
    mLicenseInitType = paramAEModuleConfig.getLicenseInitType();
    enableReducedMeidaLibrary = paramAEModuleConfig.isEnableReducedMeidaLibrary();
    networkRequest = paramAEModuleConfig.getNetworkRequest();
    SharedPreferences localSharedPreferences = paramAEModuleConfig.getPreferences();
    boolean bool1 = paramAEModuleConfig.isFramebufferFetchEnable();
    boolean bool2 = paramAEModuleConfig.isEnableResourceCheck();
    boolean bool3 = paramAEModuleConfig.isEnableDataReport();
    boolean bool4 = paramAEModuleConfig.isEnableProfiler();
    boolean bool5 = paramAEModuleConfig.isEnableSoLoadCheck();
    boolean bool6 = paramAEModuleConfig.isCacheBeautyBitmaps();
    setContext(paramContext);
    AEBaseConfig.setContext(paramContext);
    debugMode = paramAEModuleConfig.isDebugMode();
    AEOpenRenderConfig.setEnableLog(debugMode);
    LogUtils.setEnable(debugMode);
    AEOpenRenderConfig.setEnableStrictMode(paramAEModuleConfig.isStrictMode());
    if ((!TextUtils.isEmpty(mLutDirPath)) && (!FileUtils.isDirectoryWritable(mLutDirPath))) {
      mLutDirPath = null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ModelDir config.modelDir = ");
    localStringBuilder.append(mModelPath);
    LogUtils.d("AEModule", localStringBuilder.toString());
    if ((!TextUtils.isEmpty(mModelPath)) && (!FileUtils.isDirectoryWritable(mModelPath)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ModelDir mModelPath = ");
      localStringBuilder.append(mModelPath);
      localStringBuilder.append(" and Directory is not Writable. reset");
      LogUtils.d("AEModule", localStringBuilder.toString());
      mModelPath = null;
    }
    if ((!TextUtils.isEmpty(mSoPath)) && (!FileUtils.isDirectoryWritable(mSoPath)))
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("ModelDir mSoPath = ");
      localStringBuilder.append(mSoPath);
      localStringBuilder.append(" and Directory is not Writable. reset");
      LogUtils.d("AEModule", localStringBuilder.toString());
      mSoPath = null;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("ModelDir soAndModelDir = ");
    localStringBuilder.append(mModelPath);
    LogUtils.d("AEModule", localStringBuilder.toString());
    FeatureManager.setModelDir(mModelPath);
    FeatureManager.setSoDir(mSoPath);
    FeatureManager.enableResourceCheck(bool2);
    FeatureManager.createNoMedia();
    FeatureManager.enableSoLoadCheck(bool5);
    FeatureManager.Features.MASK_IMAGES.setLoadBitmapsWhenInit(bool6);
    FaceBeautyManager.registerFaceBeauty(AEFaceBeauty.class.getName(), AEFaceBeauty.class);
    VideoPrefsUtil.init(paramContext, localSharedPreferences);
    GLCapabilities.init(bool1);
    AVReportCenter.getInstance().init(getContext());
    AVReportCenter.getInstance().setEnable(bool3);
    VideoFilterBase.setDumpFilterParams(paramAEModuleConfig.isEnableDumpFilterParams());
    AEProfiler.getInstance().setEnable(bool4);
    FeatureManager.Features.YT_COMMON.setAuthMode(paramAEModuleConfig.getAuthMode());
    if (paramAEModuleConfig.getIsLoadSo()) {
      if (FeatureManager.loadBasicFeatures(paramBoolean)) {
        updateDeviceAttr(false);
      } else {
        return false;
      }
    }
    return true;
  }
  
  public static boolean initialize(Context paramContext, AEModuleConfig paramAEModuleConfig)
  {
    return initImpl(paramContext, paramAEModuleConfig, true);
  }
  
  public static boolean initialize(Context paramContext, AEModuleConfig paramAEModuleConfig, boolean paramBoolean)
  {
    return initImpl(paramContext, paramAEModuleConfig, paramBoolean);
  }
  
  public static boolean isAeKitSupportVersion()
  {
    return Build.VERSION.SDK_INT >= 17;
  }
  
  public static boolean isDebug()
  {
    return debugMode;
  }
  
  public static boolean isEnableDefaultBasic3()
  {
    return enableDefaultBasic3;
  }
  
  public static boolean isEnableReducedMeidaLibrary()
  {
    return enableReducedMeidaLibrary;
  }
  
  public static boolean isStrictMode()
  {
    return AEOpenRenderConfig.isStrictMode();
  }
  
  public static void setContext(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    sContext = paramContext;
  }
  
  public static void updateDeviceAttr(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateDeviceAttr foceUpdate = ");
    localStringBuilder.append(paramBoolean);
    LogUtils.d("AEKitModule", localStringBuilder.toString());
    CfConfig.setDecryptListener(mDecryptListener);
    AsyncTask.THREAD_POOL_EXECUTOR.execute(new AEModule.2(paramBoolean));
  }
  
  public static void updatePhoneAttrs(String paramString)
  {
    Context localContext = getContext();
    GpuScopeAttrs.getInstance().init(localContext.getApplicationContext(), DeviceInstance.getInstance().getDeviceName(), GLCapabilities.getGPUInfo(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.api.standard.AEModule
 * JD-Core Version:    0.7.0.1
 */