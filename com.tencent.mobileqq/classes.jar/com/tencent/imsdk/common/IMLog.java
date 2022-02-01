package com.tencent.imsdk.common;

import android.text.TextUtils;
import android.util.Log;

public class IMLog
{
  public static final int LOG_LEVEL_DEBUG = 3;
  public static final int LOG_LEVEL_ERROR = 6;
  public static final int LOG_LEVEL_INFO = 4;
  public static final int LOG_LEVEL_OFF = 0;
  public static final int LOG_LEVEL_VERBOSE = 2;
  public static final int LOG_LEVEL_WARN = 5;
  private static final String TAG = "IMLog";
  
  public static void d(String paramString1, String paramString2)
  {
    log(3, paramString1, paramString2);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    log(6, paramString1, paramString2);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    log(4, paramString1, paramString2);
  }
  
  private static void log(int paramInt, String paramString1, String paramString2)
  {
    if (!SystemUtil.loadIMLibrary())
    {
      Log.e(TAG, "libimsdk.so is not loaded");
      return;
    }
    if ((paramInt >= 0) && (paramInt <= 6))
    {
      if (TextUtils.isEmpty(paramString1))
      {
        e(TAG, "empty logTag");
        return;
      }
      if (TextUtils.isEmpty(paramString2))
      {
        e(TAG, "empty logContent");
        return;
      }
      nativeWriteLog(paramInt, paramString1, "", 0, paramString2);
      return;
    }
    paramString1 = TAG;
    paramString2 = new StringBuilder();
    paramString2.append("invalid logLevel： ");
    paramString2.append(paramInt);
    e(paramString1, paramString2.toString());
  }
  
  protected static native void nativeWriteLog(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3);
  
  public static void v(String paramString1, String paramString2)
  {
    log(2, paramString1, paramString2);
  }
  
  public static void w(String paramString1, String paramString2)
  {
    log(5, paramString1, paramString2);
  }
  
  public static void writeException(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (!SystemUtil.loadIMLibrary())
    {
      Log.e(TAG, "libimsdk.so is not loaded");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(" exception : ");
    localStringBuilder.append(Log.getStackTraceString(paramThrowable));
    Log.e(paramString1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.common.IMLog
 * JD-Core Version:    0.7.0.1
 */