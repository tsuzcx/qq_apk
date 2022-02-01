package com.tencent.ilivesdk.avpreloadservice;

import android.util.Log;
import com.tencent.falco.base.libapi.log.LogInterface;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class AVPreloadLog
{
  private static LogInterface a;
  
  private static String a(Throwable paramThrowable, String paramString)
  {
    Object localObject2 = "generateThrowableString err";
    Object localObject1 = localObject2;
    try
    {
      new ByteArrayOutputStream();
      localObject1 = localObject2;
      paramString = b(paramThrowable, paramString);
      localObject1 = paramString;
      localObject2 = new StringBuilder();
      localObject1 = paramString;
      ((StringBuilder)localObject2).append(paramString);
      localObject1 = paramString;
      ((StringBuilder)localObject2).append(a(paramThrowable.getStackTrace(), ""));
      localObject1 = paramString;
      paramThrowable = ((StringBuilder)localObject2).toString();
      return paramThrowable;
    }
    catch (IOException paramThrowable)
    {
      paramThrowable.printStackTrace();
    }
    return localObject1;
  }
  
  public static String a(StackTraceElement[] paramArrayOfStackTraceElement, String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j = paramArrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        StackTraceElement localStackTraceElement = paramArrayOfStackTraceElement[i];
        localStringBuilder.append(paramString);
        localStringBuilder.append(localStackTraceElement);
        localStringBuilder.append("\n");
        i += 1;
      }
      paramArrayOfStackTraceElement = localStringBuilder.toString();
      return paramArrayOfStackTraceElement;
    }
    catch (Exception paramArrayOfStackTraceElement)
    {
      paramArrayOfStackTraceElement.printStackTrace();
    }
    return "generateStackTraceString err";
  }
  
  public static void a()
  {
    a = null;
  }
  
  public static void a(LogInterface paramLogInterface)
  {
    a = paramLogInterface;
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    LogInterface localLogInterface = a;
    if (localLogInterface != null)
    {
      localLogInterface.d(paramString1, paramString2, paramVarArgs);
      return;
    }
    Log.d(paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static void a(String paramString1, Throwable paramThrowable, String paramString2)
  {
    LogInterface localLogInterface = a;
    if (localLogInterface != null)
    {
      localLogInterface.printStackTrace(paramThrowable);
      return;
    }
    Log.e(paramString1, a(paramThrowable, paramString2));
  }
  
  public static void a(Throwable paramThrowable)
  {
    a("", paramThrowable, "");
  }
  
  private static String b(Throwable paramThrowable, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(": ");
    localStringBuilder.append(paramThrowable.getMessage());
    localStringBuilder.append("\n");
    return localStringBuilder.toString();
  }
  
  public static void b(String paramString1, String paramString2, Object... paramVarArgs)
  {
    LogInterface localLogInterface = a;
    if (localLogInterface != null)
    {
      localLogInterface.i(paramString1, paramString2, paramVarArgs);
      return;
    }
    Log.i(paramString1, String.format(paramString2, paramVarArgs));
  }
  
  public static void c(String paramString1, String paramString2, Object... paramVarArgs)
  {
    LogInterface localLogInterface = a;
    if (localLogInterface != null)
    {
      localLogInterface.e(paramString1, paramString2, paramVarArgs);
      return;
    }
    Log.e(paramString1, String.format(paramString2, paramVarArgs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadLog
 * JD-Core Version:    0.7.0.1
 */