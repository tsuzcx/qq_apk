package com.tencent.ark;

import android.os.HandlerThread;
import android.text.TextUtils;

public class ArkEnvironmentManager
{
  boolean mIsAccelerationChecked = false;
  boolean mIsDebug = false;
  boolean mIsHardwareAcceleration = false;
  private LibraryLoader mLoader;
  private Log mLogCallback;
  boolean mShowProfilingLog = false;
  boolean mShowVsyncLog = false;
  private ThreadCreater mThreadCreater;
  
  public static ArkEnvironmentManager getInstance()
  {
    return LazyHolder.gInstance;
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
  
  public boolean isHardwareAcceleration()
  {
    if (!this.mIsAccelerationChecked)
    {
      this.mIsHardwareAcceleration = EGLContextHolder.isDeviceSupported();
      this.mIsAccelerationChecked = true;
    }
    return this.mIsHardwareAcceleration;
  }
  
  public boolean isLibraryLoad()
  {
    if (this.mLoader != null) {
      return this.mLoader.isLibraryLoad();
    }
    return false;
  }
  
  public boolean loadLibrary()
  {
    if (!isLibraryLoad()) {
      ArkDispatchTask.getInstance().send(new LoadLibraryTask(null));
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
    if (this.mLogCallback != null) {
      this.mLogCallback.d(paramString1, paramString2);
    }
  }
  
  public void logE(String paramString1, String paramString2)
  {
    if (this.mLogCallback != null) {
      this.mLogCallback.e(paramString1, paramString2);
    }
  }
  
  public void logI(String paramString1, String paramString2)
  {
    if (this.mLogCallback != null) {
      this.mLogCallback.i(paramString1, paramString2);
    }
  }
  
  public void logW(String paramString1, String paramString2)
  {
    if (this.mLogCallback != null) {
      this.mLogCallback.w(paramString1, paramString2);
    }
  }
  
  public void setDebugFlag(boolean paramBoolean)
  {
    this.mIsDebug = paramBoolean;
  }
  
  public void setLibraryLoader(LibraryLoader paramLibraryLoader)
  {
    this.mLoader = paramLibraryLoader;
  }
  
  public void setLogCallback(Log paramLog)
  {
    this.mLogCallback = paramLog;
  }
  
  public void setProfilingLogFlag(boolean paramBoolean)
  {
    this.mShowProfilingLog = paramBoolean;
  }
  
  public void setThreadCreator(ThreadCreater paramThreadCreater)
  {
    this.mThreadCreater = paramThreadCreater;
  }
  
  public void setVsyncLogFlag(boolean paramBoolean)
  {
    this.mShowVsyncLog = paramBoolean;
  }
  
  private static class LazyHolder
  {
    static final ArkEnvironmentManager gInstance = new ArkEnvironmentManager(null);
  }
  
  public static abstract interface LibraryLoader
  {
    public abstract boolean Load();
    
    public abstract boolean isLibraryLoad();
  }
  
  private static final class LoadLibraryTask
    implements Runnable
  {
    public void run()
    {
      ArkEnvironmentManager.getInstance().loadLibraryImpl();
    }
  }
  
  public static abstract interface Log
  {
    public abstract void d(String paramString1, String paramString2);
    
    public abstract void e(String paramString1, String paramString2);
    
    public abstract void i(String paramString1, String paramString2);
    
    public abstract void w(String paramString1, String paramString2);
  }
  
  public static abstract interface ThreadCreater
  {
    public abstract HandlerThread createHanderThread(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ark.ArkEnvironmentManager
 * JD-Core Version:    0.7.0.1
 */