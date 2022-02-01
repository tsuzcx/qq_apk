package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

public class i
{
  private static final String a = "aegis";
  private static SharedPreferences b;
  
  public static int a(String paramString, int paramInt, Context paramContext)
  {
    return b(paramContext).getInt(paramString, paramInt);
  }
  
  public static long a(String paramString, long paramLong, Context paramContext)
  {
    return b(paramContext).getLong(paramString, paramLong);
  }
  
  public static String a(String paramString1, String paramString2, Context paramContext)
  {
    return b(paramContext).getString(paramString1, paramString2);
  }
  
  public static void a(Context paramContext)
  {
    b(paramContext).edit().clear().apply();
  }
  
  public static void a(String paramString, Context paramContext)
  {
    b(paramContext).edit().remove(paramString).apply();
  }
  
  public static SharedPreferences b(Context paramContext)
  {
    try
    {
      if (b == null) {
        if (Build.VERSION.SDK_INT >= 24) {
          b = paramContext.createDeviceProtectedStorageContext().getSharedPreferences("aegis", 0);
        } else {
          b = paramContext.getApplicationContext().getSharedPreferences("aegis", 0);
        }
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
  
  public static void b(String paramString, int paramInt, Context paramContext)
  {
    b(paramContext).edit().putInt(paramString, paramInt).apply();
  }
  
  public static void b(String paramString, long paramLong, Context paramContext)
  {
    b(paramContext).edit().putLong(paramString, paramLong).apply();
  }
  
  public static void b(String paramString1, String paramString2, Context paramContext)
  {
    b(paramContext).edit().putString(paramString1, paramString2).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.util.i
 * JD-Core Version:    0.7.0.1
 */