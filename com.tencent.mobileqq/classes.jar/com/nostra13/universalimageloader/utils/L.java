package com.nostra13.universalimageloader.utils;

import android.util.Log;
import com.nostra13.universalimageloader.core.ImageLoader;

public final class L
{
  private static final String LOG_FORMAT = "%1$s\n%2$s";
  private static volatile boolean writeDebugLogs = false;
  private static volatile boolean writeLogs = true;
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    if (writeDebugLogs) {
      log(3, null, paramString, paramVarArgs);
    }
  }
  
  @Deprecated
  public static void disableLogging()
  {
    writeLogs(false);
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    log(6, null, paramString, paramVarArgs);
  }
  
  public static void e(Throwable paramThrowable)
  {
    log(6, paramThrowable, null, new Object[0]);
  }
  
  public static void e(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    log(6, paramThrowable, paramString, paramVarArgs);
  }
  
  @Deprecated
  public static void enableLogging()
  {
    writeLogs(true);
  }
  
  public static void i(String paramString, Object... paramVarArgs)
  {
    log(4, null, paramString, paramVarArgs);
  }
  
  private static void log(int paramInt, Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    if (!writeLogs) {
      return;
    }
    if (paramVarArgs.length > 0) {
      paramString = String.format(paramString, paramVarArgs);
    }
    for (;;)
    {
      if (paramThrowable == null) {}
      for (;;)
      {
        Log.println(paramInt, ImageLoader.TAG, paramString);
        return;
        paramVarArgs = paramString;
        if (paramString == null) {
          paramVarArgs = paramThrowable.getMessage();
        }
        paramString = String.format("%1$s\n%2$s", new Object[] { paramVarArgs, Log.getStackTraceString(paramThrowable) });
      }
    }
  }
  
  public static void w(String paramString, Object... paramVarArgs)
  {
    log(5, null, paramString, paramVarArgs);
  }
  
  public static void writeDebugLogs(boolean paramBoolean)
  {
    writeDebugLogs = paramBoolean;
  }
  
  public static void writeLogs(boolean paramBoolean)
  {
    writeLogs = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.utils.L
 * JD-Core Version:    0.7.0.1
 */