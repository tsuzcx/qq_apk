package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Locale;

public final class dz
{
  private static String a = "0123456789ABCDEF";
  private static String b = "0123456789ABCDEF";
  private static String c = "0123456789ABCDEF";
  
  public static String a()
  {
    return a(dp.a());
  }
  
  @Deprecated
  @SuppressLint({"MissingPermission"})
  private static String a(Context paramContext)
  {
    if ((TextUtils.isEmpty(a)) || ("0123456789ABCDEF".equals(a))) {}
    for (;;)
    {
      try
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (!i()) {
          continue;
        }
        paramContext = c(dp.a());
        a = dx.a(paramContext, dx.a).toUpperCase(Locale.ENGLISH);
      }
      catch (Throwable paramContext)
      {
        continue;
      }
      return a(a);
      if (Build.VERSION.SDK_INT >= 26) {
        paramContext = paramContext.getImei();
      } else {
        paramContext = paramContext.getDeviceId();
      }
    }
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0123456789ABCDEF";
    }
    return str;
  }
  
  public static String b()
  {
    return b(dp.a());
  }
  
  @Deprecated
  @SuppressLint({"MissingPermission"})
  private static String b(Context paramContext)
  {
    if (TextUtils.isEmpty(b))
    {
      if (!i()) {
        break label27;
      }
      b = "0123456789ABCDEF";
    }
    for (;;)
    {
      return a(b);
      label27:
      if ("0123456789ABCDEF".equals(b)) {
        try
        {
          b = dx.a(((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId(), dx.b);
        }
        catch (Throwable paramContext) {}
      }
    }
  }
  
  public static String c()
  {
    return c(dp.a());
  }
  
  @Deprecated
  private static String c(Context paramContext)
  {
    try
    {
      paramContext = Settings.System.getString(paramContext.getContentResolver(), "android_id");
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "0123456789ABCDEF";
  }
  
  @SuppressLint({"MissingPermission"})
  public static String d()
  {
    try
    {
      if (i()) {
        return c(dp.a());
      }
      if (Build.VERSION.SDK_INT >= 26) {
        return Build.getSerial();
      }
      String str = Build.SERIAL;
      return str;
    }
    catch (Throwable localThrowable) {}
    return "0123456789ABCDEF";
  }
  
  @Deprecated
  private static String d(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageName();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "UNKNOWN";
  }
  
  public static String e()
  {
    if ((TextUtils.isEmpty(c)) || ("0123456789ABCDEF".equals(c))) {
      try
      {
        Enumeration localEnumeration = NetworkInterface.getNetworkInterfaces();
        while (localEnumeration.hasMoreElements())
        {
          Object localObject = (NetworkInterface)localEnumeration.nextElement();
          if ((localObject != null) && (((NetworkInterface)localObject).getName().equalsIgnoreCase("wlan0")))
          {
            localObject = ((NetworkInterface)localObject).getHardwareAddress();
            if ((localObject != null) && (localObject.length != 0))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              int j = localObject.length;
              int i = 0;
              while (i < j)
              {
                localStringBuilder.append(String.format("%02X:", new Object[] { Byte.valueOf(localObject[i]) }));
                i += 1;
              }
              if (localStringBuilder.length() > 0) {
                localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
              }
              c = localStringBuilder.toString();
            }
          }
        }
        return a(c);
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  public static String f()
  {
    return d(dp.a());
  }
  
  public static String g()
  {
    Object localObject = dp.a();
    localObject = ((Context)localObject).getApplicationInfo().loadLabel(((Context)localObject).getPackageManager());
    if (localObject == null) {
      return "UNKNOWN";
    }
    return ((CharSequence)localObject).toString();
  }
  
  public static String h()
  {
    Object localObject = dp.a();
    try
    {
      String str = ((Context)localObject).getPackageName();
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(str, 16384).versionName;
      return localObject;
    }
    catch (Throwable localThrowable) {}
    return "unknown";
  }
  
  private static boolean i()
  {
    return (dp.a) && (Build.VERSION.SDK_INT > 28);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.dz
 * JD-Core Version:    0.7.0.1
 */