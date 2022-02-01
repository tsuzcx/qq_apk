package com.tencent.ark;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.ark.open.ArkUtil;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

public class ArkEnvironmentManager
{
  private static final String PREF_APP_CACHE_CONFIG = "ArkAppCacheConfig";
  private static final String PREF_APP_CACHE_CONFIG_DEBUG = "ArkAppCacheConfigDebug";
  private static final String PREF_APP_SERVER_CONFIG = "ArkAppServerConfig";
  private static final String PREF_APP_SERVER_CONFIG_DEBUG = "ArkAppServerConfigDebug";
  public static final String TAG = "ArkApp";
  private static final String TAG_INNER = "ArkApp.Environment";
  private HashMap<String, Long> _logTimestamp = new HashMap();
  private String mCurUin;
  private ArkEnvironmentManager.IDataReport mDataReport;
  boolean mIsAccelerationChecked = false;
  boolean mIsDebug = false;
  boolean mIsHardwareAcceleration = false;
  private boolean mIsTestEnv = false;
  private ArkEnvironmentManager.LibraryLoader mLoader;
  private ArkEnvironmentManager.Log mLogCallback;
  private String mQQVersion;
  private String mRootDirectory;
  boolean mShowFps = false;
  boolean mShowProfilingLog = false;
  boolean mShowVsyncLog = false;
  private ArkEnvironmentManager.ThreadCreater mThreadCreater;
  boolean mUseSingleThread = true;
  
  public static String GetMinSdkVersion()
  {
    return String.format(Locale.CHINA, "%d", new Object[] { Integer.valueOf(ark.arkGetMinPlatformVersion()) });
  }
  
  public static String GetPlatformBuildNumber()
  {
    return String.format(Locale.CHINA, "%d", new Object[] { Integer.valueOf(ark.arkGetPlatformBuildNumber()) });
  }
  
  public static String GetSdkVersion()
  {
    return String.format(Locale.CHINA, "%d", new Object[] { Integer.valueOf(ark.arkGetPlatformVersion()) });
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
  
  private String getLogQueueKey()
  {
    Object localObject = null;
    try
    {
      String str = ArkDispatchQueue.getCurrentQueueKey();
      localObject = str;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        exlogE("ArkApp.Environment", String.format("getLogQueueKey=%s", new Object[] { localUnsatisfiedLinkError.getMessage() }));
      }
    }
    if (TextUtils.isEmpty(localObject)) {
      return "";
    }
    return " QueueKey:" + localObject;
  }
  
  public static SharedPreferences getSharedPreferences(String paramString)
  {
    Context localContext = ArkDelegateManager.getInstance().getApplicationContext();
    if ((localContext != null) && (!TextUtils.isEmpty(paramString))) {
      return localContext.getSharedPreferences(paramString + ArkDelegateManager.getInstance().getPorcessName(), 0);
    }
    return null;
  }
  
  public HandlerThread createHandlerThread(String paramString)
  {
    if (this.mThreadCreater != null) {
      return this.mThreadCreater.createHanderThread(paramString);
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
  
  public void doDataReport(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    doDataReport(paramString1, paramString2, paramString3, paramInt1, paramInt2, paramInt3, 0L, 0L, "");
  }
  
  public void doDataReport(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2, String paramString4)
  {
    if (this.mDataReport != null) {
      this.mDataReport.report(paramString1, paramString3, paramInt1, paramInt2, paramInt3, paramLong1, paramLong2, paramString2, paramString4);
    }
  }
  
  public void exlogD(String paramString1, String paramString2)
  {
    if (this.mLogCallback != null) {
      this.mLogCallback.d(paramString1, paramString2);
    }
  }
  
  public void exlogE(String paramString1, String paramString2)
  {
    if (this.mLogCallback != null) {
      this.mLogCallback.e(paramString1, paramString2);
    }
  }
  
  public void exlogI(String paramString1, String paramString2)
  {
    if (this.mLogCallback != null) {
      this.mLogCallback.i(paramString1, paramString2);
    }
  }
  
  public void exlogW(String paramString1, String paramString2)
  {
    if (this.mLogCallback != null) {
      this.mLogCallback.w(paramString1, paramString2);
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
    return this.mRootDirectory + "/Icon";
  }
  
  public String getAppInstallDirectory()
  {
    return this.mRootDirectory + "/Install";
  }
  
  public String getAppResPath(String paramString)
  {
    paramString = getResDirectory() + "/" + paramString;
    File localFile = new File(paramString);
    if (!localFile.exists()) {
      localFile.mkdirs();
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
    return this.mRootDirectory + "/Cache";
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
    int i = 0;
    String str = System.getProperty("http.proxyPort");
    if (!TextUtils.isEmpty(str)) {}
    try
    {
      i = Integer.parseInt(str);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      localNumberFormatException.printStackTrace();
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
    return this.mRootDirectory + "/Res";
  }
  
  public String getRootDirectory()
  {
    return this.mRootDirectory;
  }
  
  public String getStorageDirectory()
  {
    return this.mRootDirectory + "/Storage";
  }
  
  public boolean isHardwareAcceleration()
  {
    if (!this.mIsAccelerationChecked) {}
    try
    {
      if (!this.mIsAccelerationChecked)
      {
        long l1 = System.currentTimeMillis();
        this.mIsHardwareAcceleration = EGLContextHolder.isDeviceSupported();
        long l2 = System.currentTimeMillis();
        logI("ArkApp.Environment", String.format("isHardwareAcceleration, %s, time=%d", new Object[] { Boolean.valueOf(this.mIsHardwareAcceleration), Long.valueOf(l2 - l1) }));
        this.mIsAccelerationChecked = true;
      }
      return this.mIsHardwareAcceleration;
    }
    finally {}
  }
  
  public boolean isLibraryLoad()
  {
    if (this.mLoader != null) {
      return this.mLoader.isLibraryLoad();
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
    if (this.mLoader == null) {}
    while (!this.mLoader.Load()) {
      return false;
    }
    ArkViewModel.precreateOfflineContext();
    ark.SetEnvironmentManager(this);
    return true;
  }
  
  public void logD(String paramString1, String paramString2)
  {
    exlogD(paramString1, paramString2 + getLogQueueKey());
  }
  
  public void logD(String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 30);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      Object localObject = paramVarArgs[i];
      if (localObject != null) {
        localStringBuilder.append(localObject.toString());
      }
      i += 1;
    }
    localStringBuilder.append(getLogQueueKey());
    exlogD(paramString, localStringBuilder.toString());
  }
  
  public void logE(String paramString1, String paramString2)
  {
    exlogE(paramString1, paramString2 + getLogQueueKey());
  }
  
  public void logE(String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 30);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      Object localObject = paramVarArgs[i];
      if (localObject != null) {
        localStringBuilder.append(localObject.toString());
      }
      i += 1;
    }
    localStringBuilder.append(getLogQueueKey());
    exlogE(paramString, localStringBuilder.toString());
  }
  
  public void logI(String paramString1, String paramString2)
  {
    exlogI(paramString1, paramString2 + getLogQueueKey());
  }
  
  public void logI(String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 30);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      Object localObject = paramVarArgs[i];
      if (localObject != null) {
        localStringBuilder.append(localObject.toString());
      }
      i += 1;
    }
    localStringBuilder.append(getLogQueueKey());
    exlogI(paramString, localStringBuilder.toString());
  }
  
  public void logW(String paramString1, String paramString2)
  {
    exlogW(paramString1, paramString2 + getLogQueueKey());
  }
  
  public void logW(String paramString, Object... paramVarArgs)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramVarArgs.length * 30);
    int i = 0;
    while (i < paramVarArgs.length)
    {
      Object localObject = paramVarArgs[i];
      if (localObject != null) {
        localStringBuilder.append(localObject.toString());
      }
      i += 1;
    }
    localStringBuilder.append(getLogQueueKey());
    exlogW(paramString, localStringBuilder.toString());
  }
  
  public void logWithLimit(String paramString1, String paramString2, String paramString3)
  {
    Long localLong = (Long)this._logTimestamp.get(paramString1);
    if ((localLong == null) || (System.currentTimeMillis() - localLong.longValue() >= 1000L))
    {
      this._logTimestamp.put(paramString1, new Long(System.currentTimeMillis()));
      exlogI(paramString2, paramString3 + getLogQueueKey());
    }
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
  
  public void setEnableShowFps(boolean paramBoolean)
  {
    this.mShowFps = paramBoolean;
  }
  
  public void setEnv(boolean paramBoolean)
  {
    this.mIsTestEnv = paramBoolean;
    logI("ArkApp", "ArkEnvironmentManager setEnv Type isTestEnv =" + paramBoolean);
  }
  
  public void setHardwareDisableList(JSONObject paramJSONObject)
  {
    EGLContextHolder.setDeviceMatcher(paramJSONObject);
  }
  
  public void setLibraryLoader(ArkEnvironmentManager.LibraryLoader paramLibraryLoader)
  {
    this.mLoader = paramLibraryLoader;
  }
  
  public void setLogCallback(ArkEnvironmentManager.Log paramLog)
  {
    this.mLogCallback = paramLog;
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
        logI("ArkApp.Environment", "setThreadMode, single thread mode");
        return;
      }
      ArkDispatchQueue.setDefaultAttribute(4);
      logI("ArkApp.Environment", "setThreadMode, multiple thread mode");
      return;
    }
    logI("ArkApp.Environment", "setThreadMode, library not load");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkEnvironmentManager
 * JD-Core Version:    0.7.0.1
 */