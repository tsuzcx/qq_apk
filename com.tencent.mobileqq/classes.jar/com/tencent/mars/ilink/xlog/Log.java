package com.tencent.mars.ilink.xlog;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Process;

public class Log
{
  public static final int LEVEL_DEBUG = 1;
  public static final int LEVEL_ERROR = 4;
  public static final int LEVEL_FATAL = 5;
  public static final int LEVEL_INFO = 2;
  public static final int LEVEL_NONE = 6;
  public static final int LEVEL_VERBOSE = 0;
  public static final int LEVEL_WARNING = 3;
  private static final String SYS_INFO;
  private static final String TAG = "mars.xlog.log";
  private static Log.LogImp debugLog = new Log.1();
  private static int level = 6;
  private static Log.LogImp logImp = debugLog;
  public static Context toastSupportContext;
  
  static
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    try
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("VERSION.RELEASE:[");
      localStringBuilder2.append(Build.VERSION.RELEASE);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] VERSION.CODENAME:[");
      localStringBuilder2.append(Build.VERSION.CODENAME);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] VERSION.INCREMENTAL:[");
      localStringBuilder2.append(Build.VERSION.INCREMENTAL);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] BOARD:[");
      localStringBuilder2.append(Build.BOARD);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] DEVICE:[");
      localStringBuilder2.append(Build.DEVICE);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] DISPLAY:[");
      localStringBuilder2.append(Build.DISPLAY);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] FINGERPRINT:[");
      localStringBuilder2.append(Build.FINGERPRINT);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] HOST:[");
      localStringBuilder2.append(Build.HOST);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] MANUFACTURER:[");
      localStringBuilder2.append(Build.MANUFACTURER);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] MODEL:[");
      localStringBuilder2.append(Build.MODEL);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] PRODUCT:[");
      localStringBuilder2.append(Build.PRODUCT);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] TAGS:[");
      localStringBuilder2.append(Build.TAGS);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] TYPE:[");
      localStringBuilder2.append(Build.TYPE);
      localStringBuilder1.append(localStringBuilder2.toString());
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("] USER:[");
      localStringBuilder2.append(Build.USER);
      localStringBuilder2.append("]");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    SYS_INFO = localStringBuilder1.toString();
  }
  
  public static void appenderClose()
  {
    Log.LogImp localLogImp = logImp;
    if (localLogImp != null) {
      localLogImp.appenderClose();
    }
  }
  
  public static void appenderFlush(boolean paramBoolean)
  {
    Log.LogImp localLogImp = logImp;
    if (localLogImp != null) {
      localLogImp.appenderFlush(paramBoolean);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    d(paramString1, paramString2, (Object[])null);
  }
  
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (logImp != null)
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      logImp.logD(paramString1, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    e(paramString1, paramString2, (Object[])null);
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (logImp != null)
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      logImp.logE(paramString1, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
    }
  }
  
  public static void f(String paramString1, String paramString2)
  {
    f(paramString1, paramString2, (Object[])null);
  }
  
  public static void f(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (logImp != null)
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      logImp.logF(paramString1, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramString2);
    }
  }
  
  public static Log.LogImp getImpl()
  {
    return logImp;
  }
  
  public static int getLogLevel()
  {
    Log.LogImp localLogImp = logImp;
    if (localLogImp != null) {
      return localLogImp.getLogLevel();
    }
    return 6;
  }
  
  public static String getSysInfo()
  {
    return SYS_INFO;
  }
  
  public static void i(String paramString1, String paramString2)
  {
    i(paramString1, paramString2, (Object[])null);
  }
  
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (logImp != null)
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      logImp.logI(paramString1, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
    }
  }
  
  public static void printErrStackTrace(String paramString1, Throwable paramThrowable, String paramString2, Object... paramVarArgs)
  {
    if (logImp != null)
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      paramString2 = new StringBuilder();
      paramString2.append(paramVarArgs);
      paramString2.append("  ");
      paramString2.append(android.util.Log.getStackTraceString(paramThrowable));
      paramThrowable = paramString2.toString();
      logImp.logE(paramString1, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramThrowable);
    }
  }
  
  public static void setLevel(int paramInt, boolean paramBoolean)
  {
    level = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("new log level: ");
    localStringBuilder.append(paramInt);
    android.util.Log.w("mars.xlog.log", localStringBuilder.toString());
    if (paramBoolean) {
      Xlog.setLogLevel(paramInt);
    }
  }
  
  public static void setLogImp(Log.LogImp paramLogImp)
  {
    logImp = paramLogImp;
  }
  
  public static void v(String paramString1, String paramString2)
  {
    v(paramString1, paramString2, (Object[])null);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (logImp != null)
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      logImp.logV(paramString1, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
    }
  }
  
  public static void w(String paramString1, String paramString2)
  {
    w(paramString1, paramString2, (Object[])null);
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (logImp != null)
    {
      if (paramVarArgs != null) {
        paramString2 = String.format(paramString2, paramVarArgs);
      }
      paramVarArgs = paramString2;
      if (paramString2 == null) {
        paramVarArgs = "";
      }
      logImp.logW(paramString1, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.ilink.xlog.Log
 * JD-Core Version:    0.7.0.1
 */