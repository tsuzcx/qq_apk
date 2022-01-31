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
import bbct;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

public class AppSetting
{
  public static int a;
  public static final String a;
  private static AtomicBoolean a;
  public static boolean a;
  public static int b;
  public static String b;
  public static boolean b;
  public static int c;
  public static String c;
  public static boolean c;
  public static int d;
  private static String d;
  public static boolean d;
  public static int e;
  private static String e;
  public static boolean e;
  private static int jdField_f_of_type_Int = 537063339;
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
  private static boolean l;
  private static volatile boolean m;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_d_of_type_JavaLangString = "CFF538A644DABF88";
    jdField_e_of_type_JavaLangString = "V 8.2.8.4440";
    jdField_a_of_type_JavaLangString = jdField_e_of_type_JavaLangString;
    jdField_f_of_type_JavaLangString = "8.2.8.4440.2020-02-27.a15c4095.YingYongBao";
    jdField_c_of_type_Boolean = true;
    g = Build.VERSION.RELEASE;
    h = "0";
    jdField_i_of_type_JavaLangString = "";
    jdField_c_of_type_Int = 1048576;
    jdField_i_of_type_Boolean = true;
    b = "use_msg_reflesh_delay";
    jdField_j_of_type_Boolean = true;
    jdField_k_of_type_Boolean = true;
    jdField_d_of_type_Int = 1000;
    jdField_e_of_type_Int = jdField_d_of_type_Int + 1;
    jdField_c_of_type_JavaLangString = Build.MANUFACTURER + "-" + Build.MODEL;
  }
  
  public static final int a()
  {
    b();
    return jdField_f_of_type_Int;
  }
  
  public static int a(String paramString)
  {
    String[] arrayOfString = "8.2.8".split("\\.");
    paramString = paramString.split("\\.");
    int n;
    int i1;
    if (arrayOfString.length < paramString.length)
    {
      n = arrayOfString.length;
      i1 = 0;
    }
    for (;;)
    {
      if (i1 >= n) {
        break label80;
      }
      int i2 = Integer.parseInt(arrayOfString[i1]);
      int i3 = Integer.parseInt(paramString[i1]);
      if (i2 > i3)
      {
        return 1;
        n = paramString.length;
        break;
      }
      if (i2 < i3) {
        return -1;
      }
      i1 += 1;
    }
    label80:
    return 0;
  }
  
  public static String a()
  {
    b();
    return jdField_e_of_type_JavaLangString;
  }
  
  public static String a(Context paramContext)
  {
    int n = 0;
    try
    {
      int i1 = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      n = i1;
    }
    catch (Exception paramContext)
    {
      label20:
      break label20;
    }
    return "8.2.8." + n;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    localObject1 = new Time();
    ((Time)localObject1).setToNow();
    localStringBuffer.append(((Time)localObject1).format("%Y-%m-%d %H:%M:%S") + "/");
    localStringBuffer.append("mobileQQ/");
    localObject2 = "";
    long l1 = bbct.d() / 1048576L;
    localObject1 = localObject2;
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      localObject1 = localObject2;
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      localObject1 = localObject2;
      paramContext = localTelephonyManager.getDeviceId();
      localObject1 = paramContext;
      localObject2 = a(localTelephonyManager, localConnectivityManager);
      localObject1 = localObject2;
      localObject2 = paramContext;
      paramContext = (Context)localObject1;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = "//";
        localObject2 = localObject1;
      }
    }
    localStringBuffer.append((String)localObject2 + "/");
    localStringBuffer.append(c() + "/");
    localStringBuffer.append("/");
    localStringBuffer.append("/");
    localStringBuffer.append("/");
    localStringBuffer.append("/");
    localObject1 = paramString;
    if (paramString == null) {
      localObject1 = "";
    }
    localStringBuffer.append((String)localObject1 + "/");
    localStringBuffer.append(a() + "/");
    localStringBuffer.append("N/");
    localStringBuffer.append(a(Build.MODEL) + "/");
    localStringBuffer.append(a(Build.BRAND) + "/");
    localStringBuffer.append(l1 + "/");
    localStringBuffer.append(paramContext + "/");
    localStringBuffer.append(0 + "/");
    return localStringBuffer.toString();
  }
  
  private static String a(TelephonyManager paramTelephonyManager, ConnectivityManager paramConnectivityManager)
  {
    if ((paramTelephonyManager == null) || (paramConnectivityManager == null)) {
      return "//";
    }
    String str3 = "";
    String str5 = "";
    String str4 = "";
    NetworkInfo localNetworkInfo = AppNetConnInfo.getRecentNetworkInfo();
    String str1 = str4;
    paramConnectivityManager = str5;
    String str2 = str3;
    if (localNetworkInfo != null)
    {
      str1 = str4;
      paramConnectivityManager = str5;
      str2 = str3;
      if (localNetworkInfo.isAvailable()) {
        switch (localNetworkInfo.getType())
        {
        case 7: 
        case 8: 
        default: 
          paramConnectivityManager = "unknown";
          str1 = "unknown";
          str2 = str3;
        }
      }
    }
    for (;;)
    {
      return paramConnectivityManager + "/" + str2 + "/" + str1;
      paramConnectivityManager = "cable";
      str1 = str4;
      str2 = str3;
      continue;
      paramConnectivityManager = "WIFI";
      str1 = str4;
      str2 = str3;
      continue;
      str2 = a(paramTelephonyManager.getNetworkOperatorName());
      switch (paramTelephonyManager.getNetworkType())
      {
      default: 
        paramConnectivityManager = "2G";
        str1 = "unknown";
        break;
      case 13: 
        paramConnectivityManager = "4G";
        str1 = "LTE";
        break;
      case 3: 
        paramConnectivityManager = "3G";
        str1 = "UMTS";
        break;
      case 5: 
        paramConnectivityManager = "3G";
        str1 = "EVDO_0";
        break;
      case 6: 
        paramConnectivityManager = "3G";
        str1 = "EVDO_A";
        break;
      case 8: 
        paramConnectivityManager = "3G";
        str1 = "SDPA";
        break;
      case 9: 
        paramConnectivityManager = "3G";
        str1 = "HSUPA";
        break;
      case 10: 
        paramConnectivityManager = "3G";
        str1 = "HSPA";
        break;
      case 12: 
        paramConnectivityManager = "3G";
        str1 = "EVDO_B";
        break;
      case 14: 
        paramConnectivityManager = "3G";
        str1 = "EHRPD";
        break;
      case 15: 
        paramConnectivityManager = "3G";
        str1 = "HSPAP";
        break;
      case 1: 
        paramConnectivityManager = "2G";
        str1 = "GPRS";
        break;
      case 2: 
        paramConnectivityManager = "2G";
        str1 = "EDGE";
        break;
      case 4: 
        paramConnectivityManager = "2G";
        str1 = "CDMA";
        break;
      case 7: 
        paramConnectivityManager = "2G";
        str1 = "1xRTT";
        break;
      case 11: 
        paramConnectivityManager = "2G";
        str1 = "IDEN";
        break;
      case 0: 
        paramConnectivityManager = "2G";
        str1 = "unknown";
      }
    }
  }
  
  private static String a(String paramString)
  {
    if (paramString == null) {
      paramString = "";
    }
    String str;
    do
    {
      return paramString;
      str = paramString;
      if (paramString.contains("/")) {
        str = paramString.replace("/", "_");
      }
      paramString = str;
    } while (str.length() <= 20);
    return str.substring(20);
  }
  
  private static void a()
  {
    try
    {
      Object localObject1 = BaseApplicationImpl.getContext().getPackageManager().getApplicationInfo(BaseApplicationImpl.getContext().getPackageName(), 128);
      if ((localObject1 != null) && (((ApplicationInfo)localObject1).metaData != null))
      {
        localObject1 = ((ApplicationInfo)localObject1).metaData.getString("AppSetting_params");
        if (localObject1 != null) {
          a((String)localObject1);
        }
      }
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        localNameNotFoundException.printStackTrace();
        Object localObject2 = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        Object localObject3 = null;
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
      h = paramString[2];
      jdField_i_of_type_JavaLangString = paramString[3];
    }
    if (!"".equals(jdField_i_of_type_JavaLangString)) {
      jdField_f_of_type_JavaLangString = "8.2.8.4440.2020-02-27.a15c4095.YingYongBao";
    }
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
    if ((jdField_a_of_type_Boolean) && (!m)) {
      try
      {
        if (!m)
        {
          a();
          m = true;
        }
        return;
      }
      finally {}
    }
  }
  
  public static boolean b()
  {
    return l;
  }
  
  public static final String c()
  {
    b();
    return h;
  }
  
  public static final String d()
  {
    b();
    return jdField_d_of_type_JavaLangString;
  }
  
  public static final String e()
  {
    if (jdField_j_of_type_JavaLangString != null) {
      return jdField_j_of_type_JavaLangString;
    }
    Object localObject2;
    StringBuffer localStringBuffer;
    String str2;
    try
    {
      Object localObject1 = Build.class.getDeclaredMethod("getString", new Class[] { String.class });
      ((Method)localObject1).setAccessible(true);
      localObject1 = (String)((Method)localObject1).invoke(null, new Object[] { "ro.product.manufacturer" });
      localObject1 = (String)localObject1 + Build.MODEL;
      if (localObject1 == null) {
        break label301;
      }
      localObject2 = ((String)localObject1).toCharArray();
      localStringBuffer = new StringBuffer(32);
      int n = 0;
      while (n < localObject2.length)
      {
        if ((localObject2[n] > ' ') && (localObject2[n] != '/') && (localObject2[n] != '_') && (localObject2[n] != '&') && (localObject2[n] != '|') && (localObject2[n] != '-')) {
          localStringBuffer.append(localObject2[n]);
        }
        n += 1;
      }
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        String str1 = "";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        str2 = "";
      }
    }
    if (localStringBuffer.length() > 0) {
      str2 = localStringBuffer.toString();
    }
    for (;;)
    {
      localObject2 = str2;
      if (str2.length() > 20) {
        localObject2 = str2.substring(0, 20);
      }
      jdField_j_of_type_JavaLangString = "AQQ_2013 4.6/2013 8.2.84440&NA_0/000000&ADR&" + jdField_k_of_type_JavaLangString + "18" + "&" + (String)localObject2 + "&" + c() + "&" + d() + "&" + g + "&" + "V3";
      return jdField_j_of_type_JavaLangString;
      label301:
      str2 = "ALL";
    }
  }
  
  public static final String f()
  {
    return "android 8.2.8";
  }
  
  public static String g()
  {
    return "a15c4095";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.config.AppSetting
 * JD-Core Version:    0.7.0.1
 */