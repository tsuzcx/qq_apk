package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.Arrays;
import java.util.IllegalFormatException;
import org.json.JSONException;

public class Logger
{
  private static final boolean DEBUG = false;
  private static final int MAX_STACK_DEEP_LENGTH = 20;
  private static final int MAX_STACK_DEEP_LENGTH_NORMAL = 8;
  private static final String SPLIT = "|";
  private static final String TAG = "NetworkKit_Logger";
  private static final String TAG_NETWORKKIT_PRE = "NetworkKit_";
  
  private static String complexMsg(String paramString, int paramInt)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return getCallMethodInfo(paramInt) + "|" + paramString;
    }
    return getCallMethodInfo(paramInt);
  }
  
  private static String complexTag(String paramString)
  {
    return "NetworkKit_" + paramString;
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
    Log.e(complexTag(paramString1), complexMsg(paramString2, 5), getNewThrowable(paramThrowable));
  }
  
  public static void e(String paramString1, String paramString2, Object... paramVarArgs)
  {
    println(6, paramString1, paramString2, paramVarArgs);
  }
  
  private static String getCallMethodInfo(int paramInt)
  {
    Object localObject = Thread.currentThread().getStackTrace();
    if (localObject.length > paramInt)
    {
      localObject = localObject[paramInt];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Process.myPid()).append("-").append(Process.myTid()).append("|").append(((StackTraceElement)localObject).getFileName()).append("|").append(((StackTraceElement)localObject).getClassName()).append("|").append(((StackTraceElement)localObject).getMethodName()).append("|").append(((StackTraceElement)localObject).getLineNumber());
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
    int i = 20;
    if (((paramThrowable instanceof IOException)) || ((paramThrowable instanceof JSONException))) {
      i = 8;
    }
    Logger.ThrowableWrapper localThrowableWrapper1 = new Logger.ThrowableWrapper(paramThrowable, null);
    Object localObject = localThrowableWrapper1.getStackTrace();
    if (localObject.length > i) {
      localThrowableWrapper1.setStackTrace((StackTraceElement[])Arrays.copyOf((Object[])localObject, i));
    }
    for (;;)
    {
      localThrowableWrapper1.setMessage(StringUtils.anonymizeMessage(paramThrowable.getMessage()));
      paramThrowable = paramThrowable.getCause();
      Logger.ThrowableWrapper localThrowableWrapper2;
      for (localObject = localThrowableWrapper1; paramThrowable != null; localObject = localThrowableWrapper2)
      {
        localThrowableWrapper2 = new Logger.ThrowableWrapper(paramThrowable, null);
        localThrowableWrapper2.setMessage(StringUtils.anonymizeMessage(paramThrowable.getMessage()));
        Logger.ThrowableWrapper.access$100((Logger.ThrowableWrapper)localObject, localThrowableWrapper2);
        paramThrowable = paramThrowable.getCause();
      }
      localThrowableWrapper1.setStackTrace((StackTraceElement[])localObject);
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
  
  public static boolean isLoggable(int paramInt)
  {
    return Log.isLoggable("NetworkKit_", paramInt);
  }
  
  private static int logPrintln(int paramInt, String paramString1, String paramString2)
  {
    return Log.println(paramInt, complexTag(paramString1), complexMsg(paramString2, 7));
  }
  
  public static void println(int paramInt, String paramString, Object paramObject)
  {
    if (paramInt < 3) {}
    while (!isLoggable(paramInt)) {
      return;
    }
    if (paramObject == null) {}
    for (paramObject = "null";; paramObject = paramObject.toString())
    {
      logPrintln(paramInt, paramString, paramObject);
      return;
    }
  }
  
  public static void println(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (paramInt < 3) {}
    for (;;)
    {
      return;
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
        w("NetworkKit_Logger", "log format error" + paramString2, paramString1);
      }
    }
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
    Log.w(complexTag(paramString1), complexMsg(paramString2, 5), getNewThrowable(paramThrowable));
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