package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import android.util.Log;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogsUtil
{
  private static final Pattern k = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");
  private static final char l = '*';
  private static final int m = 2;
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    int i1 = paramString.length();
    int j = 1;
    if (1 == i1) {
      return String.valueOf('*');
    }
    StringBuilder localStringBuilder = new StringBuilder(i1);
    int i = 0;
    while (i < i1)
    {
      char c1 = paramString.charAt(i);
      int n = j;
      char c2 = c1;
      if (k.matcher(String.valueOf(c1)).matches())
      {
        if (j % 2 == 0) {
          c1 = '*';
        }
        n = j + 1;
        c2 = c1;
      }
      localStringBuilder.append(c2);
      i += 1;
      j = n;
    }
    return localStringBuilder.toString();
  }
  
  private static String a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(512);
    if (!TextUtils.isEmpty(paramString1)) {
      localStringBuilder.append(paramString1);
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localStringBuilder.append(a(paramString2));
    }
    return localStringBuilder.toString();
  }
  
  private static String a(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder(512);
    if (!TextUtils.isEmpty(paramString)) {
      if (paramBoolean) {
        localStringBuilder.append(a(paramString));
      } else {
        localStringBuilder.append(paramString);
      }
    }
    return localStringBuilder.toString();
  }
  
  private static Throwable a(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return null;
    }
    LogsUtil.a locala1 = new LogsUtil.a(paramThrowable);
    locala1.setStackTrace(paramThrowable.getStackTrace());
    locala1.setMessage(b(paramThrowable.getMessage()));
    Throwable localThrowable = paramThrowable.getCause();
    LogsUtil.a locala2;
    for (paramThrowable = locala1; localThrowable != null; paramThrowable = locala2)
    {
      locala2 = new LogsUtil.a(localThrowable);
      locala2.setStackTrace(localThrowable.getStackTrace());
      locala2.setMessage(b(localThrowable.getMessage()));
      paramThrowable.b(locala2);
      localThrowable = localThrowable.getCause();
    }
    return locala1;
  }
  
  private static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    paramString = paramString.toCharArray();
    int i = 0;
    while (i < paramString.length)
    {
      if (i % 2 == 0) {
        paramString[i] = 42;
      }
      i += 1;
    }
    return new String(paramString);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    Log.d(paramString1, a(paramString2, false));
  }
  
  public static void d(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3))) {
      return;
    }
    Log.d(paramString1, a(paramString2, paramString3));
  }
  
  public static void d(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    if ((TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3))) {
      return;
    }
    Log.d(paramString1, a(paramString2, paramString3), a(paramThrowable));
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((TextUtils.isEmpty(paramString2)) && (paramThrowable == null)) {
      return;
    }
    Log.d(paramString1, a(paramString2, false), a(paramThrowable));
  }
  
  public static void d(String paramString1, String paramString2, Throwable paramThrowable, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    Log.d(paramString1, a(paramString2, paramBoolean), a(paramThrowable));
  }
  
  public static void d(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    Log.d(paramString1, a(paramString2, paramBoolean));
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    Log.e(paramString1, a(paramString2, false));
  }
  
  public static void e(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3))) {
      return;
    }
    Log.e(paramString1, a(paramString2, paramString3));
  }
  
  public static void e(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    if ((TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3))) {
      return;
    }
    Log.e(paramString1, a(paramString2, paramString3), a(paramThrowable));
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((TextUtils.isEmpty(paramString2)) && (paramThrowable == null)) {
      return;
    }
    Log.e(paramString1, a(paramString2, false), a(paramThrowable));
  }
  
  public static void e(String paramString1, String paramString2, Throwable paramThrowable, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString2)) && (paramThrowable == null)) {
      return;
    }
    Log.e(paramString1, a(paramString2, paramBoolean), a(paramThrowable));
  }
  
  public static void e(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    Log.e(paramString1, a(paramString2, paramBoolean));
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    Log.i(paramString1, a(paramString2, false));
  }
  
  public static void i(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3))) {
      return;
    }
    Log.i(paramString1, a(paramString2, paramString3));
  }
  
  public static void i(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    if ((TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3))) {
      return;
    }
    Log.i(paramString1, a(paramString2, paramString3), a(paramThrowable));
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((TextUtils.isEmpty(paramString2)) && (paramThrowable == null)) {
      return;
    }
    Log.i(paramString1, a(paramString2, false), a(paramThrowable));
  }
  
  public static void i(String paramString1, String paramString2, Throwable paramThrowable, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString2)) && (paramThrowable == null)) {
      return;
    }
    Log.i(paramString1, a(paramString2, paramBoolean), a(paramThrowable));
  }
  
  public static void i(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    Log.i(paramString1, a(paramString2, paramBoolean));
  }
  
  public static void w(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    Log.w(paramString1, a(paramString2, false));
  }
  
  public static void w(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3))) {
      return;
    }
    Log.w(paramString1, a(paramString2, paramString3));
  }
  
  public static void w(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    if ((TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString3))) {
      return;
    }
    Log.w(paramString1, a(paramString2, paramString3), a(paramThrowable));
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if ((TextUtils.isEmpty(paramString2)) && (paramThrowable == null)) {
      return;
    }
    Log.w(paramString1, a(paramString2, false), a(paramThrowable));
  }
  
  public static void w(String paramString1, String paramString2, Throwable paramThrowable, boolean paramBoolean)
  {
    if ((TextUtils.isEmpty(paramString2)) && (paramThrowable == null)) {
      return;
    }
    Log.w(paramString1, a(paramString2, paramBoolean), a(paramThrowable));
  }
  
  public static void w(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return;
    }
    Log.w(paramString1, a(paramString2, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.util.LogsUtil
 * JD-Core Version:    0.7.0.1
 */