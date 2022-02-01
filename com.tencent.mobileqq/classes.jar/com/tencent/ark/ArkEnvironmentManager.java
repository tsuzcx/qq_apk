package com.tencent.ark;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.ark.open.ArkUtil;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import java.io.File;
import java.util.Map;
import org.json.JSONObject;

public class ArkEnvironmentManager
{
  private static final String PREF_APP_CACHE_CONFIG = "ArkAppCacheConfig";
  private static final String PREF_APP_CACHE_CONFIG_DEBUG = "ArkAppCacheConfigDebug";
  private static final String PREF_APP_SERVER_CONFIG = "ArkAppServerConfig";
  private static final String PREF_APP_SERVER_CONFIG_DEBUG = "ArkAppServerConfigDebug";
  public static final String TAG = "ArkApp";
  private static final String TAG_INNER = "ArkApp.Environment";
  private String mCurUin;
  private ArkEnvironmentManager.IDataReport mDataReport;
  private boolean mEnableAndroid9EmojiSupport = false;
  boolean mIsAccelerationChecked = false;
  boolean mIsDebug = false;
  boolean mIsHardwareAcceleration = false;
  private boolean mIsTestEnv = false;
  private ArkEnvironmentManager.LibraryLoader mLoader;
  private String mQQVersion;
  private String mRootDirectory;
  boolean mShowFps = false;
  boolean mShowProfilingLog = false;
  boolean mShowVsyncLog = false;
  private ArkEnvironmentManager.ThreadCreater mThreadCreater;
  boolean mUseSingleThread = true;
  
  public static String GetMinSdkVersion()
  {
    return StringUtil.format("%d", new Object[] { Integer.valueOf(ark.arkGetMinPlatformVersion()) });
  }
  
  public static String GetPlatformBuildNumber()
  {
    return StringUtil.format("%d", new Object[] { Integer.valueOf(ark.arkGetPlatformBuildNumber()) });
  }
  
  public static String GetSdkVersion()
  {
    return StringUtil.format("%d", new Object[] { Integer.valueOf(ark.arkGetPlatformVersion()) });
  }
  
  public static SharedPreferences getAppConfigSharedPreferences()
  {
    if (getInstance().isTestEnv()) {
      return getSharedPreferences("ArkAppServerConfigDebug");
    }
    return getSharedPreferences("ArkAppServerConfig");
  }
  
  public static ArkEnvironmentManager getInstance()
  {
    return ArkEnvironmentManager.LazyHolder.gInstance;
  }
  
  public static SharedPreferences getSharedPreferences(String paramString)
  {
    Context localContext = ArkDelegateManager.getInstance().getApplicationContext();
    if ((localContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(ArkDelegateManager.getInstance().getProcessName());
      return localContext.getSharedPreferences(localStringBuilder.toString(), 0);
    }
    return null;
  }
  
  public HandlerThread createHandlerThread(String paramString)
  {
    ArkEnvironmentManager.ThreadCreater localThreadCreater = this.mThreadCreater;
    if (localThreadCreater != null) {
      return localThreadCreater.createHandlerThread(paramString);
    }
    return null;
  }
  
  public boolean disableHardwareRendering()
  {
    if ((this.mIsAccelerationChecked) && (this.mIsHardwareAcceleration)) {
      return false;
    }
    this.mIsAccelerationChecked = true;
    this.mIsHardwareAcceleration = false;
    return true;
  }
  
  public void doDataReport(String paramString1, String paramString2, boolean paramBoolean, int paramInt, Map<String, String> paramMap)
  {
    ArkEnvironmentManager.IDataReport localIDataReport = this.mDataReport;
    if (localIDataReport != null) {
      localIDataReport.report(paramString1, paramString2, paramBoolean, paramInt, paramMap);
    }
  }
  
  public SharedPreferences getAppConfigCacheSharedPreferences()
  {
    if (getInstance().isTestEnv()) {
      return getSharedPreferences("ArkAppCacheConfigDebug");
    }
    return getSharedPreferences("ArkAppCacheConfig");
  }
  
  public String getAppIconDirectory()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mRootDirectory);
    localStringBuilder.append("/Icon");
    return localStringBuilder.toString();
  }
  
  public String getAppInstallDirectory()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mRootDirectory);
    localStringBuilder.append("/Install");
    return localStringBuilder.toString();
  }
  
  public String getAppResPath(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(getResDirectory());
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(paramString);
    paramString = ((StringBuilder)localObject).toString();
    localObject = new File(paramString);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return paramString;
  }
  
  public String getCGIDomain()
  {
    if (this.mIsDebug) {
      return "test.ark.qq.com";
    }
    return "cgi.ark.qq.com";
  }
  
  public String getCacheDirectory()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mRootDirectory);
    localStringBuilder.append("/Cache");
    return localStringBuilder.toString();
  }
  
  public String getCurrentUin()
  {
    if ((!TextUtils.isEmpty(this.mCurUin)) && (!"0".equals(this.mCurUin))) {
      return this.mCurUin;
    }
    return "";
  }
  
  public boolean getDebugFlag()
  {
    return this.mIsDebug;
  }
  
  public String getProxyHost()
  {
    return System.getProperty("http.proxyHost");
  }
  
  public int getProxyPort()
  {
    String str = System.getProperty("http.proxyPort");
    if (!TextUtils.isEmpty(str)) {
      try
      {
        int i = Integer.parseInt(str);
        return i;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        localNumberFormatException.printStackTrace();
      }
    }
    return 0;
  }
  
  public String getQQVersion()
  {
    if (!TextUtils.isEmpty(this.mQQVersion)) {
      return this.mQQVersion;
    }
    return "";
  }
  
  public String getResDirectory()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mRootDirectory);
    localStringBuilder.append("/Res");
    return localStringBuilder.toString();
  }
  
  public String getRootDirectory()
  {
    return this.mRootDirectory;
  }
  
  public String getStorageDirectory()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mRootDirectory);
    localStringBuilder.append("/Storage");
    return localStringBuilder.toString();
  }
  
  public boolean isHardwareAcceleration()
  {
    if (!this.mIsAccelerationChecked) {
      try
      {
        if (!this.mIsAccelerationChecked)
        {
          long l1 = System.currentTimeMillis();
          this.mIsHardwareAcceleration = EGLContextHolder.isDeviceSupported();
          long l2 = System.currentTimeMillis();
          Logger.logI("ArkApp.Environment", String.format("isHardwareAcceleration, %s, time=%d", new Object[] { Boolean.valueOf(this.mIsHardwareAcceleration), Long.valueOf(l2 - l1) }));
          this.mIsAccelerationChecked = true;
        }
      }
      finally {}
    }
    return this.mIsHardwareAcceleration;
  }
  
  public boolean isLibraryLoad()
  {
    ArkEnvironmentManager.LibraryLoader localLibraryLoader = this.mLoader;
    if (localLibraryLoader != null) {
      return localLibraryLoader.isLibraryLoad();
    }
    return false;
  }
  
  public boolean isSingleThreadMode()
  {
    return this.mUseSingleThread;
  }
  
  public boolean isTestEnv()
  {
    return this.mIsTestEnv;
  }
  
  public boolean loadLibrary()
  {
    if (!isLibraryLoad()) {
      loadLibraryImpl();
    }
    return isLibraryLoad();
  }
  
  protected boolean loadLibraryImpl()
  {
    ArkEnvironmentManager.LibraryLoader localLibraryLoader = this.mLoader;
    if (localLibraryLoader == null) {
      return false;
    }
    if (localLibraryLoader.Load())
    {
      ark.arkSetAndroid9EmojiFeatureSupport(this.mEnableAndroid9EmojiSupport);
      ArkViewModel.precreateOfflineContext();
      ark.SetEnvironmentManager(this);
      return true;
    }
    return false;
  }
  
  public void setCurrentUin(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.mCurUin = paramString;
    }
  }
  
  public void setDataReport(ArkEnvironmentManager.IDataReport paramIDataReport)
  {
    this.mDataReport = paramIDataReport;
  }
  
  public void setDebugFlag(boolean paramBoolean)
  {
    this.mIsDebug = paramBoolean;
    ArkUtil.checkVersion(paramBoolean);
  }
  
  public void setEnableAndroid9EmojiSupport(boolean paramBoolean)
  {
    this.mEnableAndroid9EmojiSupport = paramBoolean;
  }
  
  public void setEnableShowFps(boolean paramBoolean)
  {
    this.mShowFps = paramBoolean;
  }
  
  public void setEnv(boolean paramBoolean)
  {
    this.mIsTestEnv = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ArkEnvironmentManager setEnv Type isTestEnv =");
    localStringBuilder.append(paramBoolean);
    Logger.logI("ArkApp", localStringBuilder.toString());
  }
  
  public void setHardwareDisableList(JSONObject paramJSONObject)
  {
    EGLContextHolder.setDeviceMatcher(paramJSONObject);
  }
  
  public void setLibraryLoader(ArkEnvironmentManager.LibraryLoader paramLibraryLoader)
  {
    this.mLoader = paramLibraryLoader;
  }
  
  public void setLogCallback(ArkEnvironmentManager.ILog paramILog)
  {
    Logger.setLogCallback(paramILog);
  }
  
  public void setProfilingLogFlag(boolean paramBoolean)
  {
    this.mShowProfilingLog = paramBoolean;
  }
  
  public void setQQVersion(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.mQQVersion = paramString;
    }
  }
  
  public void setRootDirecotry(String paramString)
  {
    this.mRootDirectory = paramString;
  }
  
  public void setSingleThreadMode(boolean paramBoolean)
  {
    this.mUseSingleThread = paramBoolean;
  }
  
  public void setThreadCreator(ArkEnvironmentManager.ThreadCreater paramThreadCreater)
  {
    this.mThreadCreater = paramThreadCreater;
  }
  
  public void setThreadMode()
  {
    if (isLibraryLoad())
    {
      if (isSingleThreadMode())
      {
        ArkDispatchQueue.setDefaultAttribute(1);
        Logger.logI("ArkApp.Environment", "setThreadMode, single thread mode");
        return;
      }
      ArkDispatchQueue.setDefaultAttribute(4);
      Logger.logI("ArkApp.Environment", "setThreadMode, multiple thread mode");
      return;
    }
    Logger.logI("ArkApp.Environment", "setThreadMode, library not load");
  }
  
  public void setUseVirtualContext(boolean paramBoolean)
  {
    EGLContextHolder.setVirtualContext(paramBoolean);
  }
  
  public void setVsyncLogFlag(boolean paramBoolean)
  {
    this.mShowVsyncLog = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.ArkEnvironmentManager
 * JD-Core Version:    0.7.0.1
 */