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
    int i = 1;
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    int n = paramString.length();
    if (1 == n) {
      return String.valueOf('*');
    }
    StringBuilder localStringBuilder = new StringBuilder(n);
    int j = 0;
    char c;
    if (j < n)
    {
      c = paramString.charAt(j);
      if (!k.matcher(String.valueOf(c)).matches()) {
        break label103;
      }
      if (i % 2 == 0) {
        c = '*';
      }
      i += 1;
    }
    label103:
    for (;;)
    {
      localStringBuilder.append(c);
      j += 1;
      break;
      return localStringBuilder.toString();
    }
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
    if (!TextUtils.isEmpty(paramString))
    {
      if (!paramBoolean) {
        break label36;
      }
      localStringBuilder.append(a(paramString));
    }
    for (;;)
    {
      return localStringBuilder.toString();
      label36:
      localStringBuilder.append(paramString);
    }
  }
  
  private static Throwable a(Throwable paramThrowable)
  {
    Object localObject2;
    if (paramThrowable == null)
    {
      localObject2 = null;
      return localObject2;
    }
    LogsUtil.a locala = new LogsUtil.a(paramThrowable);
    locala.setStackTrace(paramThrowable.getStackTrace());
    locala.setMessage(b(paramThrowable.getMessage()));
    paramThrowable = paramThrowable.getCause();
    for (Object localObject1 = locala;; localObject1 = localObject2)
    {
      localObject2 = locala;
      if (paramThrowable == null) {
        break;
      }
      localObject2 = new LogsUtil.a(paramThrowable);
      ((LogsUtil.a)localObject2).setStackTrace(paramThrowable.getStackTrace());
      ((LogsUtil.a)localObject2).setMessage(b(paramThrowable.getMessage()));
      ((LogsUtil.a)localObject1).b((Throwable)localObject2);
      paramThrowable = paramThrowable.getCause();
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.util.LogsUtil
 * JD-Core Version:    0.7.0.1
 */