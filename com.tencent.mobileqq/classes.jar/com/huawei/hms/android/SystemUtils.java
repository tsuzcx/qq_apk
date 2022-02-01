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
  private static String a()
  {
    return getSystemProperties("ro.product.locale.region", "");
  }
  
  private static String b()
  {
    return getSystemProperties("ro.product.locale", "");
  }
  
  public static String getLocalCountry()
  {
    String str = "";
    Locale localLocale = Locale.getDefault();
    if (localLocale != null) {
      str = localLocale.getCountry();
    }
    return str;
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
      Object localObject = Class.forName("android.os.SystemProperties");
      localObject = (String)((Class)localObject).getDeclaredMethod("get", new Class[] { String.class, String.class }).invoke(localObject, new Object[] { paramString1, paramString2 });
      return localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      HMSLog.e("SystemUtils", "An exception occurred while reading: getSystemProperties:" + paramString1);
      return paramString2;
    }
    catch (ClassCastException localClassCastException)
    {
      break label49;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label49;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label49;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      break label49;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label49:
      break label49;
    }
  }
  
  public static boolean isChinaROM()
  {
    String str = a();
    if (!TextUtils.isEmpty(str)) {
      return "cn".equalsIgnoreCase(str);
    }
    str = b();
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
    HMSLog.i("SystemUtils", "is Emui :" + HwBuildEx.VERSION.EMUI_SDK_INT);
    return HwBuildEx.VERSION.EMUI_SDK_INT > 0;
  }
  
  public static boolean isSystemApp(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 16384);
      if ((paramContext != null) && ((paramContext.applicationInfo.flags & 0x1) > 0)) {
        return true;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;)
      {
        HMSLog.e("SystemUtils", "isSystemApp Exception: " + paramContext);
        paramContext = null;
      }
    }
    return false;
  }
  
  public static boolean isTVDevice()
  {
    return getSystemProperties("ro.build.characteristics", "default").equalsIgnoreCase("tv");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.android.SystemUtils
 * JD-Core Version:    0.7.0.1
 */