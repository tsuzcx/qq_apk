package com.tencent.beacon.base.util;

import android.util.Log;
import java.util.Locale;

public class c
{
  public static boolean a = true;
  private static BeaconLogger b;
  private static boolean c = false;
  
  private static int a(StackTraceElement[] paramArrayOfStackTraceElement, Class paramClass)
  {
    int i = 5;
    while (i < paramArrayOfStackTraceElement.length)
    {
      String str = paramArrayOfStackTraceElement[i].getClassName();
      if (((!paramClass.equals(Log.class)) || (i >= paramArrayOfStackTraceElement.length - 1) || (!paramArrayOfStackTraceElement[(i + 1)].getClassName().equals(Log.class.getName()))) && (str.equals(paramClass.getName()))) {
        return i + 1;
      }
      i += 1;
    }
    return -1;
  }
  
  public static void a(BeaconLogger paramBeaconLogger)
  {
    b = paramBeaconLogger;
  }
  
  public static void a(String paramString1, int paramInt, String paramString2, Object... paramVarArgs)
  {
    if (c())
    {
      Object localObject = b;
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(" step: ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(". ");
        ((StringBuilder)localObject).append(paramString2);
        Log.d("beacon", c(((StringBuilder)localObject).toString(), paramVarArgs));
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" step: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(". ");
      localStringBuilder.append(paramString2);
      ((BeaconLogger)localObject).d("beacon", c(localStringBuilder.toString(), paramVarArgs));
    }
  }
  
  public static void a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    if (c())
    {
      Object localObject = b;
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString1);
        ((StringBuilder)localObject).append(" ");
        ((StringBuilder)localObject).append(paramString2);
        Log.d("beacon", c(((StringBuilder)localObject).toString(), paramVarArgs));
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString2);
      ((BeaconLogger)localObject).d("beacon", c(localStringBuilder.toString(), paramVarArgs));
    }
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (c())
    {
      BeaconLogger localBeaconLogger = b;
      if (localBeaconLogger == null)
      {
        Log.d("beacon", c(paramString, paramVarArgs));
        return;
      }
      localBeaconLogger.d("beacon", c(paramString, paramVarArgs));
    }
  }
  
  public static void a(Throwable paramThrowable)
  {
    if ((paramThrowable != null) && (c()))
    {
      BeaconLogger localBeaconLogger = b;
      if (localBeaconLogger == null)
      {
        paramThrowable.printStackTrace();
        return;
      }
      localBeaconLogger.printStackTrace(paramThrowable);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("beacon logAble: ");
      localStringBuilder.append(paramBoolean);
      Log.i("beacon", localStringBuilder.toString());
      c = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean a()
  {
    try
    {
      boolean bool = c;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    if (c())
    {
      BeaconLogger localBeaconLogger = b;
      if (localBeaconLogger == null)
      {
        Log.e("beacon", c(paramString, paramVarArgs));
        return;
      }
      localBeaconLogger.e("beacon", c(paramString, paramVarArgs));
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    try
    {
      a = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean b()
  {
    try
    {
      boolean bool = a;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String c(String paramString, Object... paramVarArgs)
  {
    String str = e();
    if (paramString == null)
    {
      paramString = new StringBuilder();
      paramString.append(str);
      paramString.append("msg is null");
      return paramString.toString();
    }
    if ((paramVarArgs != null) && (paramVarArgs.length != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(String.format(Locale.US, paramString, paramVarArgs));
      return localStringBuilder.toString();
    }
    paramVarArgs = new StringBuilder();
    paramVarArgs.append(str);
    paramVarArgs.append(paramString);
    return paramVarArgs.toString();
  }
  
  private static boolean c()
  {
    return a();
  }
  
  private static StackTraceElement d()
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    int j = a(arrayOfStackTraceElement, c.class);
    int i = j;
    if (j == -1)
    {
      j = a(arrayOfStackTraceElement, Log.class);
      i = j;
      if (j == -1) {
        return null;
      }
    }
    return arrayOfStackTraceElement[i];
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    if (c())
    {
      BeaconLogger localBeaconLogger = b;
      if (localBeaconLogger == null)
      {
        Log.i("beacon", c(paramString, paramVarArgs));
        return;
      }
      localBeaconLogger.i("beacon", c(paramString, paramVarArgs));
    }
  }
  
  private static String e()
  {
    boolean bool = b();
    Object localObject1 = "";
    if (bool)
    {
      StackTraceElement localStackTraceElement = d();
      if (localStackTraceElement != null)
      {
        Object localObject2 = localStackTraceElement.getFileName();
        if (localObject2 != null) {
          localObject1 = localObject2;
        }
        Object localObject3 = localStackTraceElement.getMethodName();
        localObject2 = localObject3;
        if (((String)localObject3).contains("$")) {
          localObject2 = ((String)localObject3).substring(((String)localObject3).indexOf("$") + 1, ((String)localObject3).lastIndexOf("$") - 2);
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("(");
        ((StringBuilder)localObject3).append((String)localObject1);
        ((StringBuilder)localObject3).append(":");
        ((StringBuilder)localObject3).append(localStackTraceElement.getLineNumber());
        ((StringBuilder)localObject3).append(")");
        ((StringBuilder)localObject3).append((String)localObject2);
        ((StringBuilder)localObject3).append(" ");
        return ((StringBuilder)localObject3).toString();
      }
    }
    return "";
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    if (c())
    {
      BeaconLogger localBeaconLogger = b;
      if (localBeaconLogger == null)
      {
        Log.w("beacon", c(paramString, paramVarArgs));
        return;
      }
      localBeaconLogger.w("beacon", c(paramString, paramVarArgs));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.base.util.c
 * JD-Core Version:    0.7.0.1
 */