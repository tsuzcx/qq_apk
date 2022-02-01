package com.huawei.hms.stats;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.text.TextUtils;

public abstract class k
{
  /* Error */
  private static Object a(Class paramClass, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +13 -> 14
    //   4: new 16	com/huawei/hms/stats/k$a
    //   7: dup
    //   8: ldc 18
    //   10: invokespecial 22	com/huawei/hms/stats/k$a:<init>	(Ljava/lang/String;)V
    //   13: athrow
    //   14: aload_2
    //   15: ifnonnull +17 -> 32
    //   18: aload_3
    //   19: ifnull +72 -> 91
    //   22: new 16	com/huawei/hms/stats/k$a
    //   25: dup
    //   26: ldc 24
    //   28: invokespecial 22	com/huawei/hms/stats/k$a:<init>	(Ljava/lang/String;)V
    //   31: athrow
    //   32: aload_3
    //   33: ifnonnull +13 -> 46
    //   36: new 16	com/huawei/hms/stats/k$a
    //   39: dup
    //   40: ldc 26
    //   42: invokespecial 22	com/huawei/hms/stats/k$a:<init>	(Ljava/lang/String;)V
    //   45: athrow
    //   46: aload_2
    //   47: arraylength
    //   48: aload_3
    //   49: arraylength
    //   50: if_icmpeq +41 -> 91
    //   53: new 16	com/huawei/hms/stats/k$a
    //   56: dup
    //   57: new 28	java/lang/StringBuilder
    //   60: dup
    //   61: invokespecial 31	java/lang/StringBuilder:<init>	()V
    //   64: ldc 33
    //   66: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_2
    //   70: arraylength
    //   71: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   74: ldc 42
    //   76: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_3
    //   80: arraylength
    //   81: invokevirtual 40	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   84: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokespecial 22	com/huawei/hms/stats/k$a:<init>	(Ljava/lang/String;)V
    //   90: athrow
    //   91: aload_0
    //   92: aload_1
    //   93: aload_2
    //   94: invokevirtual 52	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   97: astore_0
    //   98: aload_0
    //   99: aconst_null
    //   100: aload_3
    //   101: invokevirtual 58	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   104: astore_0
    //   105: aload_0
    //   106: areturn
    //   107: astore_0
    //   108: ldc 60
    //   110: ldc 62
    //   112: invokestatic 68	com/huawei/hms/stats/af:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: aconst_null
    //   116: areturn
    //   117: astore_0
    //   118: ldc 60
    //   120: ldc 70
    //   122: invokestatic 68	com/huawei/hms/stats/af:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: aconst_null
    //   126: areturn
    //   127: astore_0
    //   128: ldc 60
    //   130: ldc 72
    //   132: invokestatic 68	com/huawei/hms/stats/af:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aconst_null
    //   136: areturn
    //   137: astore_0
    //   138: ldc 60
    //   140: ldc 74
    //   142: invokestatic 68	com/huawei/hms/stats/af:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aconst_null
    //   146: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	paramClass	Class
    //   0	147	1	paramString	String
    //   0	147	2	paramArrayOfClass	Class[]
    //   0	147	3	paramArrayOfObject	Object[]
    // Exception table:
    //   from	to	target	type
    //   98	105	107	java/lang/IllegalAccessException
    //   91	98	117	java/lang/NoSuchMethodException
    //   98	105	117	java/lang/NoSuchMethodException
    //   108	115	117	java/lang/NoSuchMethodException
    //   128	135	117	java/lang/NoSuchMethodException
    //   138	145	117	java/lang/NoSuchMethodException
    //   98	105	127	java/lang/IllegalArgumentException
    //   98	105	137	java/lang/reflect/InvocationTargetException
  }
  
  private static Object a(String paramString1, String paramString2, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramString1 = a(Class.forName(paramString1), paramString2, paramArrayOfClass, paramArrayOfObject);
      return paramString1;
    }
    catch (ClassNotFoundException paramString1)
    {
      af.c("hmsSdk", "invokeStaticFun() Not found class!");
      return null;
    }
    catch (k.a paramString1)
    {
      for (;;)
      {
        af.c("hmsSdk", "invokeStaticFun(): Static function call Exception ");
      }
    }
  }
  
  public static String a()
  {
    return bi.a("ro.build.version.emui", "");
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    return paramContext.getPackageName();
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    String str2 = a("android.os.SystemProperties", paramString1, paramString2);
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = a("com.huawei.android.os.SystemPropertiesEx", paramString1, paramString2);
    }
    return str1;
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = a(paramString1, "get", new Class[] { String.class, String.class }, new Object[] { paramString2, paramString3 });
    if (paramString1 != null) {
      return (String)paramString1;
    }
    return paramString3;
  }
  
  public static String b()
  {
    String str2 = a("com.huawei.android.os.SystemPropertiesEx", "ro.huawei.build.display.id", "");
    af.b("hmsSdk", "SystemPropertiesEx: get rom_ver: " + str2);
    String str1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      str1 = Build.DISPLAY;
      af.b("hmsSdk", "SystemProperties: get rom_ver: " + str1);
    }
    return str1;
  }
  
  public static String b(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(a(paramContext), 0).versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      af.c("hmsSdk", "getVersion(): The package name is not correct!");
    }
    return "";
  }
  
  @SuppressLint({"HardwareIds"})
  public static String c(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
  
  public static String d(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if ((paramContext != null) && (paramContext.metaData != null))
      {
        paramContext = paramContext.metaData.get("CHANNEL");
        if (paramContext != null)
        {
          String str = paramContext.toString();
          paramContext = str;
          if (str.length() > 256) {
            paramContext = "Unknown";
          }
          return paramContext;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      af.c("hmsSdk", "getChannel(): The packageName is not correct!");
    }
    return "Unknown";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.k
 * JD-Core Version:    0.7.0.1
 */