package com.tencent.aekit.api.standard;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.ai.AIManager;
import com.tencent.aekit.openrender.AEOpenRenderConfig;
import com.tencent.aekit.openrender.internal.VideoFilterBase;
import com.tencent.aekit.openrender.util.AEProfiler;
import com.tencent.camerasdk.avreport.AVReportCenter;
import com.tencent.ttpic.AEBaseConfig;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.baseutils.device.GpuScopeAttrs;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.cache.VideoMemoryManager;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import com.tencent.ttpic.openapi.shader.ShaderManager;
import com.tencent.ttpic.openapi.util.CfConfig;
import com.tencent.ttpic.openapi.util.VideoPrefsUtil;
import com.tencent.ttpic.util.DecryptListener;
import com.tencent.ttpic.util.MustRunOnGLThread;
import java.util.concurrent.Executor;

public class AEModule
{
  private static final String[] AEKIT_FORMER_VERSION = { "1.0.0", "1.1.0", "1.2.0", "1.3.0", "1.4.0", "1.5.0", "1.6.0", "1.7.0", "1.7.1" };
  private static final String AEKIT_VERSION = "1.7.1";
  private static final String AEKIT_VERSION_FILE = "aekit_meta.txt";
  public static final String DEFAULT_LICENSE_NAME = "com_tencent_2118.lic";
  private static final String TAG = "AEKitModule";
  private static String aekitVersion = null;
  private static boolean debugMode = false;
  private static boolean enableDefaultBasic3 = false;
  private static boolean enableReducedMeidaLibrary = false;
  private static DecryptListener mDecryptListener = new AEModule.1();
  private static String mLicense;
  private static int mLicenseInitType;
  private static String mLutDirPath;
  private static String mModelPath = null;
  private static String mSoPath = null;
  private static Context sContext;
  
  static
  {
    mLutDirPath = null;
  }
  
  @MustRunOnGLThread
  public static void clear()
  {
    ShaderManager.getInstance().clear();
    VideoMemoryManager.getInstance().clearBeautyCache();
    AIManager.destroy();
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
  
  public static String getVersion()
  {
    if (!TextUtils.isEmpty(aekitVersion)) {
      return aekitVersion;
    }
    if (sContext == null) {
      aekitVersion = "1.7.1";
    }
    for (;;)
    {
      return aekitVersion;
      String str = FileUtils.loadAssetsString(sContext, "aekit_meta.txt");
      if (TextUtils.isEmpty(str)) {
        aekitVersion = "1.7.1";
      } else {
        aekitVersion = str.split("\n")[0];
      }
    }
  }
  
  public static String getVersion(Context paramContext)
  {
    if (aekitVersion == null)
    {
      paramContext = FileUtils.loadAssetsString(paramContext, "aekit_meta.txt");
      if (!TextUtils.isEmpty(paramContext)) {
        break label29;
      }
    }
    label29:
    for (aekitVersion = "1.7.1";; aekitVersion = paramContext.split("\n")[0]) {
      return aekitVersion;
    }
  }
  
  private static void initImpl(Context paramContext, AEModuleConfig paramAEModuleConfig, boolean paramBoolean)
  {
    mLutDirPath = paramAEModuleConfig.getLutDir();
    mModelPath = paramAEModuleConfig.getModelDir();
    enableDefaultBasic3 = paramAEModuleConfig.isEnableDefaultBasic3();
    mSoPath = paramAEModuleConfig.getSoDir();
    mLicense = paramAEModuleConfig.getLicense();
    mLicenseInitType = paramAEModuleConfig.getLicenseInitType();
    enableReducedMeidaLibrary = paramAEModuleConfig.isEnableReducedMeidaLibrary();
    SharedPreferences localSharedPreferences = paramAEModuleConfig.getPreferences();
    boolean bool1 = paramAEModuleConfig.isFramebufferFetchEnable();
    boolean bool2 = paramAEModuleConfig.isEnableResourceCheck();
    boolean bool3 = paramAEModuleConfig.isEnableDataReport();
    boolean bool4 = paramAEModuleConfig.isEnableProfiler();
    debugMode = paramAEModuleConfig.isDebugMode();
    AEOpenRenderConfig.setEnableLog(debugMode);
    LogUtils.setEnable(debugMode);
    AEOpenRenderConfig.setEnableStrictMode(paramAEModuleConfig.isStrictMode());
    if ((!TextUtils.isEmpty(mLutDirPath)) && (!FileUtils.isDirectoryWritable(mLutDirPath))) {
      mLutDirPath = null;
    }
    LogUtils.d("AEModule", "ModelDir config.modelDir = " + mModelPath);
    if ((!TextUtils.isEmpty(mModelPath)) && (!FileUtils.isDirectoryWritable(mModelPath)))
    {
      LogUtils.d("AEModule", "ModelDir mModelPath = " + mModelPath + " and Directory is not Writable. reset");
      mModelPath = null;
    }
    if ((!TextUtils.isEmpty(mSoPath)) && (!FileUtils.isDirectoryWritable(mSoPath)))
    {
      LogUtils.d("AEModule", "ModelDir mSoPath = " + mSoPath + " and Directory is not Writable. reset");
      mSoPath = null;
    }
    LogUtils.d("AEModule", "ModelDir soAndModelDir = " + mModelPath);
    FeatureManager.setModelDir(mModelPath);
    FeatureManager.setSoDir(mSoPath);
    FeatureManager.enableResourceCheck(bool2);
    setContext(paramContext);
    AEBaseConfig.setContext(paramContext);
    VideoPrefsUtil.init(paramContext, localSharedPreferences);
    GLCapabilities.init(bool1);
    AVReportCenter.getInstance().init(getContext());
    AVReportCenter.getInstance().setEnable(bool3);
    VideoFilterBase.setDumpFilterParams(paramAEModuleConfig.isEnableDumpFilterParams());
    AEProfiler.getInstance().setEnable(bool4);
    if ((paramAEModuleConfig.getIsLoadSo()) && (FeatureManager.loadBasicFeatures(paramBoolean))) {
      updateDeviceAttr(false);
    }
  }
  
  public static void initialize(Context paramContext, AEModuleConfig paramAEModuleConfig)
  {
    initImpl(paramContext, paramAEModuleConfig, true);
  }
  
  public static void initialize(Context paramContext, AEModuleConfig paramAEModuleConfig, boolean paramBoolean)
  {
    initImpl(paramContext, paramAEModuleConfig, paramBoolean);
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
    LogUtils.d("AEKitModule", "updateDeviceAttr foceUpdate = " + paramBoolean);
    CfConfig.setDecryptListener(mDecryptListener);
    AsyncTask.THREAD_POOL_EXECUTOR.execute(new AEModule.2(paramBoolean));
  }
  
  public static void updatePhoneAttrs(String paramString)
  {
    Context localContext = getContext();
    GpuScopeAttrs.getInstance().init(localContext.getApplicationContext(), DeviceInstance.getInstance().getDeviceName(), GLCapabilities.getGPUInfo(), paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.api.standard.AEModule
 * JD-Core Version:    0.7.0.1
 */