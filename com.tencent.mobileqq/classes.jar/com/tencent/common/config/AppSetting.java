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
import com.tencent.mobileqq.utils.BaseDeviceInfoUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppSetting
{
  public static int a = 0;
  public static final String a;
  private static AtomicBoolean a;
  public static boolean a = true;
  public static int b = 0;
  public static String b;
  public static boolean b = false;
  public static int c = 0;
  public static String c;
  public static boolean c = false;
  public static int d = 0;
  private static String d = "08B785FF9DC193D1";
  public static boolean d = false;
  public static int e = 0;
  private static String e = "V 8.7.0.5295";
  public static boolean e = false;
  private static int jdField_f_of_type_Int = 537068060;
  private static String jdField_f_of_type_JavaLangString;
  public static boolean f;
  private static final String g;
  public static boolean g;
  private static String h;
  public static boolean h;
  private static String i;
  public static boolean i;
  private static String j;
  public static boolean j;
  private static String k;
  public static boolean k;
  public static boolean l;
  public static boolean m;
  private static boolean n;
  private static boolean o;
  private static boolean p;
  private static volatile boolean q;
  
  static
  {
    jdField_a_of_type_JavaLangString = jdField_e_of_type_JavaLangString;
    jdField_f_of_type_JavaLangString = "8.7.0.5295.2021-04-27.01328a87.YingYongBao";
    jdField_b_of_type_Boolean = true;
    jdField_g_of_type_JavaLangString = Build.VERSION.RELEASE;
    jdField_h_of_type_JavaLangString = "0";
    jdField_i_of_type_JavaLangString = "";
    jdField_c_of_type_Boolean = false;
    jdField_d_of_type_Boolean = false;
    jdField_e_of_type_Boolean = false;
    jdField_f_of_type_Boolean = false;
    jdField_g_of_type_Boolean = false;
    jdField_h_of_type_Boolean = false;
    q = false;
    jdField_c_of_type_Int = 1048576;
    jdField_i_of_type_Boolean = true;
    jdField_b_of_type_JavaLangString = "use_msg_reflesh_delay";
    jdField_j_of_type_Boolean = true;
    jdField_k_of_type_Boolean = true;
    l = false;
    m = false;
    jdField_d_of_type_Int = 1000;
    jdField_e_of_type_Int = jdField_d_of_type_Int + 1;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append("-");
    localStringBuilder.append(Build.MODEL);
    jdField_c_of_type_JavaLangString = localStringBuilder.toString();
  }
  
  public static int a()
  {
    b();
    return jdField_f_of_type_Int;
  }
  
  public static int a(String paramString)
  {
    String[] arrayOfString = "8.7.0".split("\\.");
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
  
  public static String a()
  {
    b();
    return jdField_e_of_type_JavaLangString;
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
    paramContext.append("8.7.0.");
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
      paramContext = ((TelephonyManager)localObject2).getDeviceId();
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
    paramContext.append(c());
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
    paramContext.append(a());
    paramContext.append("/");
    localStringBuffer.append(paramContext.toString());
    localStringBuffer.append("N/");
    paramContext = new StringBuilder();
    paramContext.append(a(Build.MODEL));
    paramContext.append("/");
    localStringBuffer.append(paramContext.toString());
    paramContext = new StringBuilder();
    paramContext.append(a(Build.BRAND));
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
            str = a(paramTelephonyManager.getNetworkOperatorName());
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
  
  private static String a(String paramString)
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
  
  private static void a()
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
  
  public static void a(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.split("#");
      jdField_f_of_type_Int = Integer.valueOf(paramString[0]).intValue();
      jdField_d_of_type_JavaLangString = paramString[1];
      jdField_h_of_type_JavaLangString = paramString[2];
      jdField_i_of_type_JavaLangString = paramString[3];
    }
    if (!"".equals(jdField_i_of_type_JavaLangString)) {
      jdField_f_of_type_JavaLangString = "8.7.0.5295.2021-04-27.01328a87.YingYongBao";
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    o = paramBoolean;
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean == null) {
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(BaseApplication.getContext().getSharedPreferences("sso_list", 4).getBoolean("sso_list_enable_ipv6", false));
    }
    return jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  public static String b()
  {
    b();
    return jdField_f_of_type_JavaLangString;
  }
  
  private static void b()
  {
    if ((jdField_a_of_type_Boolean) && (!q)) {
      try
      {
        if (!q)
        {
          a();
          q = true;
        }
        return;
      }
      finally {}
    }
  }
  
  public static void b(boolean paramBoolean)
  {
    n = paramBoolean;
  }
  
  public static boolean b()
  {
    return n;
  }
  
  public static String c()
  {
    b();
    return jdField_h_of_type_JavaLangString;
  }
  
  public static void c(boolean paramBoolean)
  {
    p = paramBoolean;
  }
  
  public static boolean c()
  {
    return o;
  }
  
  public static String d()
  {
    b();
    return jdField_d_of_type_JavaLangString;
  }
  
  public static boolean d()
  {
    return p;
  }
  
  public static String e()
  {
    Object localObject1 = jdField_j_of_type_JavaLangString;
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
      label55:
      Object localObject2;
      char[] arrayOfChar;
      int i1;
      break label55;
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
    ((StringBuilder)localObject1).append("AQQ_2013 4.6/2013 8.7.05295&NA_0/000000&ADR&");
    ((StringBuilder)localObject1).append(jdField_k_of_type_JavaLangString);
    ((StringBuilder)localObject1).append("18");
    ((StringBuilder)localObject1).append("&");
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("&");
    ((StringBuilder)localObject1).append(c());
    ((StringBuilder)localObject1).append("&");
    ((StringBuilder)localObject1).append(d());
    ((StringBuilder)localObject1).append("&");
    ((StringBuilder)localObject1).append(jdField_g_of_type_JavaLangString);
    ((StringBuilder)localObject1).append("&");
    ((StringBuilder)localObject1).append("V3");
    jdField_j_of_type_JavaLangString = ((StringBuilder)localObject1).toString();
    return jdField_j_of_type_JavaLangString;
  }
  
  public static boolean e()
  {
    return false;
  }
  
  public static final String f()
  {
    return "android 8.7.0";
  }
  
  public static boolean f()
  {
    return false;
  }
  
  public static String g()
  {
    return "01328a87";
  }
  
  public static String h()
  {
    return "application/vnd.android.package-archive";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.common.config.AppSetting
 * JD-Core Version:    0.7.0.1
 */