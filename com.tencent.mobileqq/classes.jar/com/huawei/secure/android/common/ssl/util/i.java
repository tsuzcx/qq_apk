package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class i
{
  private static final String FILE_NAME = "aegis";
  private static SharedPreferences am = null;
  
  public static void a(String paramString, int paramInt, Context paramContext)
  {
    f(paramContext).edit().putInt(paramString, paramInt).apply();
  }
  
  public static void a(String paramString, long paramLong, Context paramContext)
  {
    f(paramContext).edit().putLong(paramString, paramLong).apply();
  }
  
  public static void a(String paramString, Context paramContext)
  {
    f(paramContext).edit().remove(paramString).apply();
  }
  
  public static void a(String paramString1, String paramString2, Context paramContext)
  {
    f(paramContext).edit().putString(paramString1, paramString2).apply();
  }
  
  public static int b(String paramString, int paramInt, Context paramContext)
  {
    return f(paramContext).getInt(paramString, paramInt);
  }
  
  public static long b(String paramString, long paramLong, Context paramContext)
  {
    return f(paramContext).getLong(paramString, paramLong);
  }
  
  public static String b(String paramString1, String paramString2, Context paramContext)
  {
    return f(paramContext).getString(paramString1, paramString2);
  }
  
  /* Error */
  public static SharedPreferences f(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 14	com/huawei/secure/android/common/ssl/util/i:am	Landroid/content/SharedPreferences;
    //   6: ifnonnull +24 -> 30
    //   9: getstatic 76	android/os/Build$VERSION:SDK_INT	I
    //   12: bipush 24
    //   14: if_icmplt +25 -> 39
    //   17: aload_0
    //   18: invokevirtual 82	android/content/Context:createDeviceProtectedStorageContext	()Landroid/content/Context;
    //   21: ldc 8
    //   23: iconst_0
    //   24: invokevirtual 86	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   27: putstatic 14	com/huawei/secure/android/common/ssl/util/i:am	Landroid/content/SharedPreferences;
    //   30: getstatic 14	com/huawei/secure/android/common/ssl/util/i:am	Landroid/content/SharedPreferences;
    //   33: astore_0
    //   34: ldc 2
    //   36: monitorexit
    //   37: aload_0
    //   38: areturn
    //   39: aload_0
    //   40: invokevirtual 89	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   43: ldc 8
    //   45: iconst_0
    //   46: invokevirtual 86	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   49: putstatic 14	com/huawei/secure/android/common/ssl/util/i:am	Landroid/content/SharedPreferences;
    //   52: goto -22 -> 30
    //   55: astore_0
    //   56: ldc 2
    //   58: monitorexit
    //   59: aload_0
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   3	30	55	finally
    //   30	34	55	finally
    //   39	52	55	finally
  }
  
  public static void g(Context paramContext)
  {
    f(paramContext).edit().clear().apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.util.i
 * JD-Core Version:    0.7.0.1
 */