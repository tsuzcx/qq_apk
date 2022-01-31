package com.google.android.filament;

import androidx.annotation.NonNull;

abstract class Platform
{
  private static Platform mCurrentPlatform = null;
  
  @NonNull
  static Platform get()
  {
    if (mCurrentPlatform == null) {}
    try
    {
      if (isAndroid()) {}
      for (mCurrentPlatform = (Platform)Class.forName("com.google.android.filament.AndroidPlatform").newInstance();; mCurrentPlatform = (Platform)Class.forName("com.google.android.filament.DesktopPlatform").newInstance())
      {
        label26:
        if (mCurrentPlatform == null) {
          mCurrentPlatform = new Platform.UnknownPlatform(null);
        }
        return mCurrentPlatform;
      }
    }
    catch (Exception localException)
    {
      break label26;
    }
  }
  
  static boolean isAndroid()
  {
    return "The Android Project".equalsIgnoreCase(System.getProperty("java.vendor"));
  }
  
  static boolean isLinux()
  {
    return (System.getProperty("os.name").contains("Linux")) && (!isAndroid());
  }
  
  static boolean isMacOS()
  {
    return System.getProperty("os.name").contains("Mac OS X");
  }
  
  static boolean isWindows()
  {
    return System.getProperty("os.name").contains("Windows");
  }
  
  abstract long getSharedContextNativeHandle(Object paramObject);
  
  abstract void log(String paramString);
  
  abstract boolean validateSharedContext(Object paramObject);
  
  abstract boolean validateStreamSource(Object paramObject);
  
  abstract boolean validateSurface(Object paramObject);
  
  abstract void warn(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.google.android.filament.Platform
 * JD-Core Version:    0.7.0.1
 */