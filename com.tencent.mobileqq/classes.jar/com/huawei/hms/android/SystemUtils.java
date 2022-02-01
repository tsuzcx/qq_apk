package com.huawei.hms.android;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public class SystemUtils
{
  public static String a()
  {
    return getSystemProperties("ro.product.locale", "");
  }
  
  public static String b()
  {
    return getSystemProperties("ro.product.locale.region", "");
  }
  
  public static String getLocalCountry()
  {
    Locale localLocale = Locale.getDefault();
    if (localLocale != null) {
      return localLocale.getCountry();
    }
    return "";
  }
  
  public static String getNetType(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext != null)
      {
        paramContext = paramContext.getActiveNetworkInfo();
        if ((paramContext != null) && (paramContext.isAvailable())) {
          return paramContext.getTypeName();
        }
      }
    }
    return "";
  }
  
  public static String getSystemProperties(String paramString1, String paramString2)
  {
    try
    {
      localObject = Class.forName("android.os.SystemProperties");
      localObject = (String)((Class)localObject).getDeclaredMethod("get", new Class[] { String.class, String.class }).invoke(localObject, new Object[] { paramString1, paramString2 });
      return localObject;
    }
    catch (ClassNotFoundException|NoSuchMethodException|IllegalAccessException|IllegalArgumentException|InvocationTargetException|ClassCastException localClassNotFoundException)
    {
      Object localObject;
      label48:
      break label48;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("An exception occurred while reading: getSystemProperties:");
    ((StringBuilder)localObject).append(paramString1);
    HMSLog.e("SystemUtils", ((StringBuilder)localObject).toString());
    return paramString2;
  }
  
  public static boolean isChinaROM()
  {
    String str = b();
    if (!TextUtils.isEmpty(str)) {
      return "cn".equalsIgnoreCase(str);
    }
    str = a();
    if (!TextUtils.isEmpty(str)) {
      return str.toLowerCase(Locale.US).contains("cn");
    }
    str = getLocalCountry();
    if (!TextUtils.isEmpty(str)) {
      return "cn".equalsIgnoreCase(str);
    }
    return false;
  }
  
  public static boolean isEMUI()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("is Emui :");
    localStringBuilder.append(HwBuildEx.VERSION.EMUI_SDK_INT);
    HMSLog.i("SystemUtils", localStringBuilder.toString());
    return HwBuildEx.VERSION.EMUI_SDK_INT > 0;
  }
  
  public static boolean isSystemApp(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 16384);
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("isSystemApp Exception: ");
      paramString.append(paramContext);
      HMSLog.e("SystemUtils", paramString.toString());
      paramContext = null;
    }
    return (paramContext != null) && ((paramContext.applicationInfo.flags & 0x1) > 0);
  }
  
  public static boolean isTVDevice()
  {
    return getSystemProperties("ro.build.characteristics", "default").equalsIgnoreCase("tv");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.android.SystemUtils
 * JD-Core Version:    0.7.0.1
 */