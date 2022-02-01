package com.tencent.common.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.format.Time;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qmethodmonitor.monitor.PhoneInfoMonitor;
import com.tencent.mobileqq.utils.BaseDeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppSetting
{
  private static final String A;
  private static String B;
  private static String C;
  private static String D;
  private static boolean E = false;
  private static boolean F = false;
  private static boolean G = false;
  private static volatile boolean H = false;
  private static String I;
  public static boolean a = true;
  public static final String b = y;
  public static boolean c = false;
  public static boolean d = false;
  public static boolean e = false;
  public static boolean f = false;
  public static boolean g = false;
  public static boolean h = false;
  public static boolean i = false;
  public static int j = 0;
  public static int k = 0;
  public static int l = 0;
  public static boolean m = false;
  public static String n;
  public static boolean o = false;
  public static boolean p = false;
  public static boolean q = false;
  public static boolean r = false;
  public static int s = 0;
  public static int t = 0;
  public static String u;
  private static int v = 537084869;
  private static String w = "C6A8D61A92218E56";
  private static AtomicBoolean x;
  private static String y = "V 8.8.17.5770";
  private static String z = "8.8.17.5770.2021-08-04.846a9bfd.YingYongBao";
  
  static
  {
    c = true;
    A = Build.VERSION.RELEASE;
    B = "0";
    C = "";
    d = false;
    e = false;
    f = false;
    g = false;
    h = false;
    i = false;
    H = false;
    l = 1048576;
    m = true;
    n = "use_msg_reflesh_delay";
    o = true;
    p = true;
    q = false;
    r = false;
    s = 1000;
    t = s + 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append("-");
    localStringBuilder.append(Build.MODEL);
    u = localStringBuilder.toString();
  }
  
  public static String a(Context paramContext)
  {
    int i1 = 0;
    try
    {
      int i2 = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      i1 = i2;
    }
    catch (Exception paramContext)
    {
      label20:
      break label20;
    }
    paramContext = new StringBuilder();
    paramContext.append("8.8.17.");
    paramContext.append(i1);
    return paramContext.toString();
  }
  
  public static String a(Context paramContext, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    Object localObject1 = new Time();
    ((Time)localObject1).setToNow();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((Time)localObject1).format("%Y-%m-%d %H:%M:%S"));
    ((StringBuilder)localObject2).append("/");
    localStringBuffer.append(((StringBuilder)localObject2).toString());
    localStringBuffer.append("mobileQQ/");
    long l1 = BaseDeviceInfoUtil.a() / 1048576L;
    try
    {
      localObject1 = (ConnectivityManager)paramContext.getSystemService("connectivity");
      localObject2 = (TelephonyManager)paramContext.getSystemService("phone");
      paramContext = PhoneInfoMonitor.getDeviceId((TelephonyManager)localObject2);
      try
      {
        localObject1 = a((TelephonyManager)localObject2, (ConnectivityManager)localObject1);
      }
      catch (Exception localException1) {}
      localException2.printStackTrace();
    }
    catch (Exception localException2)
    {
      paramContext = "";
    }
    String str = "//";
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramContext);
    ((StringBuilder)localObject2).append("/");
    localStringBuffer.append(((StringBuilder)localObject2).toString());
    paramContext = new StringBuilder();
    paramContext.append(e());
    paramContext.append("/");
    localStringBuffer.append(paramContext.toString());
    localStringBuffer.append("/");
    localStringBuffer.append("/");
    localStringBuffer.append("/");
    localStringBuffer.append("/");
    paramContext = paramString;
    if (paramString == null) {
      paramContext = "";
    }
    paramString = new StringBuilder();
    paramString.append(paramContext);
    paramString.append("/");
    localStringBuffer.append(paramString.toString());
    paramContext = new StringBuilder();
    paramContext.append(d());
    paramContext.append("/");
    localStringBuffer.append(paramContext.toString());
    localStringBuffer.append("N/");
    paramContext = new StringBuilder();
    paramContext.append(c(Build.MODEL));
    paramContext.append("/");
    localStringBuffer.append(paramContext.toString());
    paramContext = new StringBuilder();
    paramContext.append(c(Build.BRAND));
    paramContext.append("/");
    localStringBuffer.append(paramContext.toString());
    paramContext = new StringBuilder();
    paramContext.append(l1);
    paramContext.append("/");
    localStringBuffer.append(paramContext.toString());
    paramContext = new StringBuilder();
    paramContext.append(str);
    paramContext.append("/");
    localStringBuffer.append(paramContext.toString());
    paramContext = new StringBuilder();
    paramContext.append(0);
    paramContext.append("/");
    localStringBuffer.append(paramContext.toString());
    return localStringBuffer.toString();
  }
  
  private static String a(TelephonyManager paramTelephonyManager, ConnectivityManager paramConnectivityManager)
  {
    if ((paramTelephonyManager != null) && (paramConnectivityManager != null))
    {
      Object localObject = AppNetConnInfo.getRecentNetworkInfo();
      String str = "";
      paramConnectivityManager = "3G";
      if ((localObject != null) && (((NetworkInfo)localObject).isAvailable()))
      {
        int i1 = ((NetworkInfo)localObject).getType();
        if (i1 != 9) {
          switch (i1)
          {
          default: 
            paramTelephonyManager = "unknown";
            break;
          }
        } else {
          for (paramTelephonyManager = "WIFI";; paramTelephonyManager = "cable")
          {
            localObject = "";
            paramConnectivityManager = paramTelephonyManager;
            paramTelephonyManager = (TelephonyManager)localObject;
            break;
            str = c(paramTelephonyManager.getNetworkOperatorName());
            switch (paramTelephonyManager.getNetworkType())
            {
            case 0: 
            default: 
              paramTelephonyManager = "unknown";
            }
            for (;;)
            {
              paramConnectivityManager = "2G";
              break;
              paramTelephonyManager = "HSPAP";
              break;
              paramTelephonyManager = "EHRPD";
              break;
              paramConnectivityManager = "4G";
              paramTelephonyManager = "LTE";
              break;
              paramTelephonyManager = "EVDO_B";
              break;
              paramTelephonyManager = "IDEN";
              continue;
              paramTelephonyManager = "HSPA";
              break;
              paramTelephonyManager = "HSUPA";
              break;
              paramTelephonyManager = "SDPA";
              break;
              paramTelephonyManager = "1xRTT";
              continue;
              paramTelephonyManager = "EVDO_A";
              break;
              paramTelephonyManager = "EVDO_0";
              break;
              paramTelephonyManager = "CDMA";
              continue;
              paramTelephonyManager = "UMTS";
              break;
              paramTelephonyManager = "EDGE";
              continue;
              paramTelephonyManager = "GPRS";
            }
          }
        }
      }
      else
      {
        paramTelephonyManager = "";
      }
      paramConnectivityManager = paramTelephonyManager;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramConnectivityManager);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(paramTelephonyManager);
      return ((StringBuilder)localObject).toString();
    }
    return "//";
  }
  
  public static void a(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.split("#");
      v = Integer.valueOf(paramString[0]).intValue();
      w = paramString[1];
      B = paramString[2];
      C = paramString[3];
    }
    if (!"".equals(C)) {
      z = "8.8.17.5770.2021-08-04.846a9bfd.YingYongBao";
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    F = paramBoolean;
  }
  
  public static boolean a()
  {
    if (x == null) {
      x = new AtomicBoolean(BaseApplication.getContext().getSharedPreferences("sso_list", 4).getBoolean("sso_list_enable_ipv6", false));
    }
    return x.get();
  }
  
  public static int b(String paramString)
  {
    String[] arrayOfString = "8.8.17".split("\\.");
    paramString = paramString.split("\\.");
    int i2 = Math.min(arrayOfString.length, paramString.length);
    int i1 = 0;
    while (i1 < i2)
    {
      int i3 = Integer.parseInt(arrayOfString[i1]);
      int i4 = Integer.parseInt(paramString[i1]);
      if (i3 > i4) {
        return 1;
      }
      if (i3 < i4) {
        return -1;
      }
      i1 += 1;
    }
    return 0;
  }
  
  public static String b()
  {
    q();
    return y;
  }
  
  public static void b(boolean paramBoolean)
  {
    E = paramBoolean;
  }
  
  public static String c()
  {
    q();
    return z;
  }
  
  private static String c(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    String str = paramString;
    if (paramString.contains("/")) {
      str = paramString.replace("/", "_");
    }
    paramString = str;
    if (str.length() > 20) {
      paramString = str.substring(20);
    }
    return paramString;
  }
  
  public static void c(boolean paramBoolean)
  {
    G = paramBoolean;
  }
  
  public static int d()
  {
    q();
    return v;
  }
  
  public static String e()
  {
    q();
    return B;
  }
  
  public static String f()
  {
    q();
    return w;
  }
  
  public static String g()
  {
    Object localObject1 = D;
    if (localObject1 != null) {
      return localObject1;
    }
    try
    {
      localObject1 = Build.class.getDeclaredMethod("getString", new Class[] { String.class });
      ((Method)localObject1).setAccessible(true);
      localObject1 = (String)((Method)localObject1).invoke(null, new Object[] { "ro.product.manufacturer" });
    }
    catch (SecurityException|Exception localSecurityException)
    {
      label56:
      Object localObject2;
      char[] arrayOfChar;
      int i1;
      break label56;
    }
    localObject1 = "";
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(Build.MODEL);
    localObject1 = ((StringBuilder)localObject2).toString();
    if (localObject1 != null)
    {
      arrayOfChar = ((String)localObject1).toCharArray();
      localObject2 = new StringBuffer(32);
      i1 = 0;
      while (i1 < arrayOfChar.length)
      {
        if ((arrayOfChar[i1] > ' ') && (arrayOfChar[i1] != '/') && (arrayOfChar[i1] != '_') && (arrayOfChar[i1] != '&') && (arrayOfChar[i1] != '|') && (arrayOfChar[i1] != '-')) {
          ((StringBuffer)localObject2).append(arrayOfChar[i1]);
        }
        i1 += 1;
      }
      if (((StringBuffer)localObject2).length() > 0) {
        localObject1 = ((StringBuffer)localObject2).toString();
      }
    }
    else
    {
      localObject1 = "ALL";
    }
    localObject2 = localObject1;
    if (((String)localObject1).length() > 20) {
      localObject2 = ((String)localObject1).substring(0, 20);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("AQQ_2013 4.6/2013 8.8.175770&NA_0/000000&ADR&");
    ((StringBuilder)localObject1).append(I);
    ((StringBuilder)localObject1).append("18");
    ((StringBuilder)localObject1).append("&");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("&");
    ((StringBuilder)localObject1).append(e());
    ((StringBuilder)localObject1).append("&");
    ((StringBuilder)localObject1).append(f());
    ((StringBuilder)localObject1).append("&");
    ((StringBuilder)localObject1).append(A);
    ((StringBuilder)localObject1).append("&");
    ((StringBuilder)localObject1).append("V3");
    D = ((StringBuilder)localObject1).toString();
    return D;
  }
  
  public static final String h()
  {
    return "android 8.8.17";
  }
  
  public static String i()
  {
    return "846a9bfd";
  }
  
  public static boolean j()
  {
    return E;
  }
  
  public static boolean k()
  {
    return F;
  }
  
  public static boolean l()
  {
    return G;
  }
  
  public static boolean m()
  {
    return false;
  }
  
  public static boolean n()
  {
    return false;
  }
  
  public static String o()
  {
    return "application/vnd.android.package-archive";
  }
  
  private static void p()
  {
    try
    {
      ApplicationInfo localApplicationInfo = BaseApplication.getContext().getPackageManager().getApplicationInfo(BaseApplication.getContext().getPackageName(), 128);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      localNameNotFoundException.printStackTrace();
    }
    String str = null;
    if ((str != null) && (str.metaData != null))
    {
      str = str.metaData.getString("AppSetting_params");
      if (str != null) {
        a(str);
      }
    }
  }
  
  private static void q()
  {
    if ((a) && (!H)) {
      try
      {
        if (!H)
        {
          p();
          H = true;
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.config.AppSetting
 * JD-Core Version:    0.7.0.1
 */