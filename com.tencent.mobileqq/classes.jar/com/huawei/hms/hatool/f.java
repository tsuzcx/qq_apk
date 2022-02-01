package com.huawei.hms.hatool;

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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class f
{
  public static Object a(Class paramClass, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    if (paramClass != null) {
      if (paramArrayOfClass == null)
      {
        if (paramArrayOfObject != null) {
          throw new f.a("paramsType is null, but params is not null");
        }
      }
      else {
        if ((paramArrayOfObject != null) && (paramArrayOfClass.length != paramArrayOfObject.length)) {
          break label78;
        }
      }
    }
    for (;;)
    {
      try
      {
        paramClass = paramClass.getMethod(paramString, paramArrayOfClass);
      }
      catch (NoSuchMethodException paramClass)
      {
        continue;
        paramClass = "invokeStaticFun(): Illegal Argument!";
        continue;
      }
      try
      {
        paramClass = paramClass.invoke(null, paramArrayOfObject);
        return paramClass;
      }
      catch (IllegalAccessException paramClass) {}catch (IllegalArgumentException paramClass) {}catch (InvocationTargetException paramClass) {}
    }
    for (paramClass = "invokeStaticFun(): Invocation Target Exception!";; paramClass = "invokeStaticFun(): method invoke Exception!")
    {
      y.f("hmsSdk", paramClass);
      return null;
    }
    y.f("hmsSdk", "invokeStaticFun(): cls.getMethod(),No Such Method !");
    return null;
    label78:
    paramClass = new StringBuilder();
    paramClass.append("paramsType len:");
    paramClass.append(paramArrayOfClass.length);
    paramClass.append(" should equal params.len:");
    paramClass.append(paramArrayOfObject.length);
    throw new f.a(paramClass.toString());
    throw new f.a("paramsType or params should be same");
    paramClass = new f.a("class is null in invokeStaticFun");
    for (;;)
    {
      throw paramClass;
    }
  }
  
  public static Object a(String paramString1, String paramString2, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    try
    {
      paramString1 = a(Class.forName(paramString1), paramString2, paramArrayOfClass, paramArrayOfObject);
      return paramString1;
    }
    catch (ClassNotFoundException paramString1)
    {
      break label19;
    }
    catch (f.a paramString1)
    {
      label13:
      label19:
      label22:
      break label13;
    }
    paramString1 = "invokeStaticFun(): Static function call Exception ";
    break label22;
    paramString1 = "invokeStaticFun() Not found class!";
    y.f("hmsSdk", paramString1);
    return null;
  }
  
  public static String a()
  {
    return a("ro.build.version.emui", "");
  }
  
  @SuppressLint({"HardwareIds"})
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
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
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = a(paramString1, "get", new Class[] { String.class, String.class }, new Object[] { paramString2, paramString3 });
    if (paramString1 != null) {
      paramString3 = (String)paramString1;
    }
    return paramString3;
  }
  
  public static String b()
  {
    Object localObject2 = a("com.huawei.android.os.SystemPropertiesEx", "ro.huawei.build.display.id", "");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("SystemPropertiesEx: get rom_ver: ");
    ((StringBuilder)localObject1).append((String)localObject2);
    y.c("hmsSdk", ((StringBuilder)localObject1).toString());
    localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = Build.DISPLAY;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("SystemProperties: get rom_ver: ");
      ((StringBuilder)localObject2).append((String)localObject1);
      y.c("hmsSdk", ((StringBuilder)localObject2).toString());
    }
    return localObject1;
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if ((paramContext == null) || (paramContext.metaData == null)) {
        break label69;
      }
      paramContext = paramContext.metaData.get("CHANNEL");
      if (paramContext == null) {
        break label69;
      }
      paramContext = paramContext.toString();
      int i = paramContext.length();
      if (i > 256) {
        return "Unknown";
      }
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label62:
      label69:
      break label62;
    }
    y.f("hmsSdk", "getChannel(): The packageName is not correct!");
    return "Unknown";
  }
  
  public static String c(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    return paramContext.getPackageName();
  }
  
  public static String d(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(c(paramContext), 0).versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label25:
      break label25;
    }
    y.f("hmsSdk", "getVersion(): The package name is not correct!");
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.hatool.f
 * JD-Core Version:    0.7.0.1
 */