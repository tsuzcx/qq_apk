package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;

public abstract class SafePrintException
{
  private static boolean c(String paramString)
  {
    String[] arrayOfString = new String[10];
    arrayOfString[0] = "java.io.FileNotFoundException";
    arrayOfString[1] = "java.util.jar.JarException";
    arrayOfString[2] = "java.util.MissingResourceException";
    arrayOfString[3] = "java.security.acl.NotOwnerException";
    arrayOfString[4] = "java.util.ConcurrentModificationException";
    arrayOfString[5] = "javax.naming.InsufficientResourcesException";
    arrayOfString[6] = "java.net.BindException";
    arrayOfString[7] = "java.lang.OutOfMemoryError";
    arrayOfString[8] = "java.lang.StackOverflowError";
    arrayOfString[9] = "java.sql.SQLException";
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.contains(arrayOfString[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static String getStackTrace(String paramString, Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(paramString)) {
      localStringBuilder.append(paramString).append(" ");
    }
    localStringBuilder.append("Exception: ").append(paramThrowable.getClass().getName()).append('\n');
    if (!c(paramThrowable.getClass().getCanonicalName()))
    {
      paramString = paramThrowable.getStackTrace();
      if (paramString != null) {
        break label92;
      }
      localStringBuilder.append("Stack trace is NULL!").append('\n');
    }
    for (;;)
    {
      return localStringBuilder.toString();
      label92:
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        localStringBuilder.append(paramString[i].toString()).append('\n');
        i += 1;
      }
    }
  }
  
  public static void print(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return;
    }
    Log.w(paramString1, getStackTrace(paramString2, paramThrowable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.util.SafePrintException
 * JD-Core Version:    0.7.0.1
 */