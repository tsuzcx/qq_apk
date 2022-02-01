package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.util.Log;
import java.util.IllegalFormatException;

public class Logger
{
  private static final boolean DEBUG = false;
  private static final int MAX_STACK_DEEP_LENGTH = 20;
  private static final int MAX_STACK_DEEP_LENGTH_NORMAL = 8;
  private static final String SPLIT = "|";
  private static final String TAG = "NetworkKit_Logger";
  private static final String TAG_NETWORKKIT_PRE = "NetworkKit_";
  private static final String TAG_NETWORK_SDK_PRE = "NetworkSdk_";
  private static ExtLogger extLogger;
  private static boolean println = true;
  
  private static String complexAppTag(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NetworkSdk_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private static String complexMsg(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(getCallMethodInfo(paramInt));
      localStringBuilder.append("|");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    return getCallMethodInfo(paramInt);
  }
  
  private static String complexTag(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NetworkKit_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  @SuppressLint({"LogTagMismatch"})
  public static void d(String paramString, Object paramObject)
  {
    println(3, paramString, paramObject);
  }
  
  @SuppressLint({"LogTagMismatch"})
  public static void d(String paramString1, String paramString2, Object... paramVarArgs)
  {
    println(3, paramString1, paramString2, paramVarArgs);
  }
  
  public static void e(String paramString, Object paramObject)
  {
    println(6, paramString, paramObject);
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (isAPPLoggable(6)) {
      extLogger.e(complexAppTag(paramString1), complexMsg(paramString2, 5), getNewThrowable(paramThrowable));
    }
    if (println) {
      Log.e(complexTag(paramString1), complexMsg(paramString2, 5), getNewThrowable(paramThrowable));
    }
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    println(6, paramString1, paramString2, paramVarArgs);
  }
  
  private static void extLogPrintln(int paramInt, String paramString1, String paramString2)
  {
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        if (paramInt != 4)
        {
          if (paramInt != 5)
          {
            if (paramInt != 6) {
              return;
            }
            extLogger.e(paramString1, paramString2);
            return;
          }
          extLogger.w(paramString1, paramString2);
          return;
        }
        extLogger.i(paramString1, paramString2);
        return;
      }
      extLogger.d(paramString1, paramString2);
      return;
    }
    extLogger.v(paramString1, paramString2);
  }
  
  private static String getCallMethodInfo(int paramInt)
  {
    Object localObject = Thread.currentThread().getStackTrace();
    if (localObject.length > paramInt)
    {
      localObject = localObject[paramInt];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Thread.currentThread().getName());
      localStringBuilder.append("|");
      localStringBuilder.append(((StackTraceElement)localObject).getFileName());
      localStringBuilder.append("|");
      localStringBuilder.append(((StackTraceElement)localObject).getClassName());
      localStringBuilder.append("|");
      localStringBuilder.append(((StackTraceElement)localObject).getMethodName());
      localStringBuilder.append("|");
      localStringBuilder.append(((StackTraceElement)localObject).getLineNumber());
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private static Throwable getNewThrowable(Throwable paramThrowable)
  {
    if (isLoggable(3)) {
      return paramThrowable;
    }
    if (paramThrowable == null) {
      return null;
    }
    Logger.ThrowableWrapper localThrowableWrapper1 = new Logger.ThrowableWrapper(paramThrowable, null);
    Throwable localThrowable = paramThrowable.getCause();
    Logger.ThrowableWrapper localThrowableWrapper2;
    for (paramThrowable = localThrowableWrapper1; localThrowable != null; paramThrowable = localThrowableWrapper2)
    {
      localThrowableWrapper2 = new Logger.ThrowableWrapper(localThrowable, null);
      Logger.ThrowableWrapper.access$100(paramThrowable, localThrowableWrapper2);
      localThrowable = localThrowable.getCause();
    }
    return localThrowableWrapper1;
  }
  
  @SuppressLint({"LogTagMismatch"})
  public static void i(String paramString, Object paramObject)
  {
    println(4, paramString, paramObject);
  }
  
  @SuppressLint({"LogTagMismatch"})
  public static void i(String paramString1, String paramString2, Object... paramVarArgs)
  {
    println(4, paramString1, paramString2, paramVarArgs);
  }
  
  public static boolean isAPPLoggable(int paramInt)
  {
    if (extLogger != null) {
      return Log.isLoggable("NetworkSdk_", paramInt);
    }
    return false;
  }
  
  public static boolean isLoggable(int paramInt)
  {
    return Log.isLoggable("NetworkKit_", paramInt);
  }
  
  private static int logPrintln(int paramInt, String paramString1, String paramString2)
  {
    if (isAPPLoggable(paramInt)) {
      extLogPrintln(paramInt, complexAppTag(paramString1), complexMsg(paramString2, 7));
    }
    if (println) {
      return Log.println(paramInt, complexTag(paramString1), complexMsg(paramString2, 7));
    }
    return 1;
  }
  
  public static void println(int paramInt, String paramString, Object paramObject)
  {
    if (paramInt < 3) {
      return;
    }
    if (isLoggable(paramInt))
    {
      if (paramObject == null) {
        paramObject = "null";
      } else {
        paramObject = paramObject.toString();
      }
      logPrintln(paramInt, paramString, paramObject);
    }
  }
  
  public static void println(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (paramInt < 3) {
      return;
    }
    if (paramString2 == null)
    {
      Log.w("NetworkKit_Logger", "format is null, not log");
      return;
    }
    try
    {
      if (isLoggable(paramInt))
      {
        logPrintln(paramInt, paramString1, StringUtils.format(paramString2, paramVarArgs));
        return;
      }
    }
    catch (IllegalFormatException paramString1)
    {
      paramVarArgs = new StringBuilder();
      paramVarArgs.append("log format error");
      paramVarArgs.append(paramString2);
      w("NetworkKit_Logger", paramVarArgs.toString(), paramString1);
    }
  }
  
  public static void setExtLogger(ExtLogger paramExtLogger, boolean paramBoolean)
  {
    extLogger = paramExtLogger;
    println = paramBoolean;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("logger = ");
    localStringBuilder.append(paramExtLogger);
    localStringBuilder.append(paramBoolean);
    i("NetworkKit_Logger", localStringBuilder.toString());
  }
  
  public static void v(String paramString, Object paramObject)
  {
    println(2, paramString, paramObject);
  }
  
  public static void v(String paramString1, String paramString2, Object... paramVarArgs)
  {
    println(2, paramString1, paramString2, paramVarArgs);
  }
  
  public static void w(String paramString, Object paramObject)
  {
    println(5, paramString, paramObject);
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (isAPPLoggable(5)) {
      extLogger.w(complexAppTag(paramString1), complexMsg(paramString2, 5), getNewThrowable(paramThrowable));
    }
    if (println) {
      Log.w(complexTag(paramString1), complexMsg(paramString2, 5), getNewThrowable(paramThrowable));
    }
  }
  
  public static void w(String paramString1, String paramString2, Object... paramVarArgs)
  {
    println(5, paramString1, paramString2, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.common.Logger
 * JD-Core Version:    0.7.0.1
 */