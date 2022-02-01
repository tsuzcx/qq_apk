package com.tencent.component.network.module.base;

public class QDLog
{
  public static final String TAG_DOWNLOAD = "downloader";
  public static final String TAG_DOWNLOAD_OKHTTP = "downloader_OKHTTP";
  public static final String TAG_DOWNLOAD_RANGE = "downloader_RANGE";
  public static final String TAG_DOWNLOAD_RESULT = "downloader_result";
  private static com.tencent.component.network.module.base.inter.Log sLog;
  
  public static void d(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, null);
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    com.tencent.component.network.module.base.inter.Log localLog = sLog;
    if (localLog != null)
    {
      localLog.d(paramString1, paramString2, paramThrowable);
      return;
    }
    android.util.Log.d(paramString1, paramString2, paramThrowable);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    e(paramString1, paramString2, null);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    com.tencent.component.network.module.base.inter.Log localLog = sLog;
    if (localLog != null)
    {
      localLog.e(paramString1, paramString2, paramThrowable);
      return;
    }
    android.util.Log.e(paramString1, paramString2, paramThrowable);
  }
  
  public static com.tencent.component.network.module.base.inter.Log getLog()
  {
    return sLog;
  }
  
  private static int getLogLevel()
  {
    com.tencent.component.network.module.base.inter.Log localLog = sLog;
    if (localLog != null) {
      return localLog.getLogLevel();
    }
    return 1;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    com.tencent.component.network.module.base.inter.Log localLog = sLog;
    if (localLog != null)
    {
      localLog.i(paramString1, paramString2);
      return;
    }
    android.util.Log.i(paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    com.tencent.component.network.module.base.inter.Log localLog = sLog;
    if (localLog != null)
    {
      localLog.i(paramString1, paramString2, paramThrowable);
      return;
    }
    android.util.Log.i(paramString1, paramString2, paramThrowable);
  }
  
  public static boolean isDebugEnable()
  {
    return 2 >= getLogLevel();
  }
  
  public static boolean isErrorEnable()
  {
    return 5 >= getLogLevel();
  }
  
  public static boolean isInfoEnable()
  {
    return 3 >= getLogLevel();
  }
  
  public static boolean isWarningEnable()
  {
    return 4 >= getLogLevel();
  }
  
  public static void setLog(com.tencent.component.network.module.base.inter.Log paramLog)
  {
    sLog = paramLog;
  }
  
  public static void w(String paramString1, String paramString2)
  {
    w(paramString1, paramString2, null);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    com.tencent.component.network.module.base.inter.Log localLog = sLog;
    if (localLog != null)
    {
      localLog.w(paramString1, paramString2, paramThrowable);
      return;
    }
    android.util.Log.w(paramString1, paramString2, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.module.base.QDLog
 * JD-Core Version:    0.7.0.1
 */