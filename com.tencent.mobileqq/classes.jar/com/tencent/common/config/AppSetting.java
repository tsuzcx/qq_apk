package com.tencent.common.config;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.format.Time;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import java.lang.reflect.Method;

public class AppSetting
{
  public static int a = 0;
  public static String a;
  public static boolean a = false;
  public static int b = 0;
  public static String b = Build.MANUFACTURER + "-" + Build.MODEL;
  public static boolean b = false;
  public static int c = 0;
  private static final String c;
  public static boolean c = false;
  public static final String channelId = "2017";
  public static int d;
  private static String d;
  public static boolean d;
  public static int e;
  private static String e;
  public static boolean e;
  public static int f;
  public static boolean f;
  public static boolean g;
  public static boolean h;
  public static boolean i;
  public static boolean j;
  private static boolean k;
  
  static
  {
    jdField_a_of_type_Int = 537056907;
    jdField_a_of_type_Boolean = true;
    c = Build.VERSION.RELEASE;
    jdField_d_of_type_Int = 1048576;
    g = true;
    jdField_a_of_type_JavaLangString = "use_msg_reflesh_delay";
    h = true;
    i = true;
    jdField_e_of_type_Int = 1000;
    f = jdField_e_of_type_Int + 1;
  }
  
  @TargetApi(10)
  private static int a(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return 0;
      if (Build.VERSION.SDK_INT >= 10) {
        try
        {
          paramContext = NfcAdapter.getDefaultAdapter(paramContext);
          if (paramContext != null) {
            return 1;
          }
        }
        catch (Exception paramContext) {}
      }
    }
    return 0;
  }
  
  public static int a(String paramString)
  {
    String[] arrayOfString = "7.6.3".split("\\.");
    paramString = paramString.split("\\.");
    int m;
    int n;
    if (arrayOfString.length < paramString.length)
    {
      m = arrayOfString.length;
      n = 0;
    }
    for (;;)
    {
      if (n >= m) {
        break label80;
      }
      int i1 = Integer.parseInt(arrayOfString[n]);
      int i2 = Integer.parseInt(paramString[n]);
      if (i1 > i2)
      {
        return 1;
        m = paramString.length;
        break;
      }
      if (i1 < i2) {
        return -1;
      }
      n += 1;
    }
    label80:
    return 0;
  }
  
  public static final String a()
  {
    return "BF266466230731EF";
  }
  
  public static String a(Context paramContext, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    localObject1 = new Time();
    ((Time)localObject1).setToNow();
    localStringBuffer.append(((Time)localObject1).format("%Y-%m-%d %H:%M:%S") + "/");
    localStringBuffer.append("mobileQQ/");
    localObject2 = "";
    long l = DeviceInfoUtil.e() / 1048576L;
    int m = a(paramContext);
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
    localStringBuffer.append("2017/");
    localStringBuffer.append("/");
    localStringBuffer.append("/");
    localStringBuffer.append("/");
    localStringBuffer.append("/");
    localObject1 = paramString;
    if (paramString == null) {
      localObject1 = "";
    }
    localStringBuffer.append((String)localObject1 + "/");
    localStringBuffer.append(jdField_a_of_type_Int + "/");
    localStringBuffer.append("N/");
    localStringBuffer.append(a(Build.MODEL) + "/");
    localStringBuffer.append(a(Build.BRAND) + "/");
    localStringBuffer.append(l + "/");
    localStringBuffer.append(paramContext + "/");
    localStringBuffer.append(m + "/");
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
  
  public static boolean a()
  {
    return k;
  }
  
  public static final String b()
  {
    if (jdField_d_of_type_JavaLangString != null) {
      return jdField_d_of_type_JavaLangString;
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
        break label299;
      }
      localObject2 = ((String)localObject1).toCharArray();
      localStringBuffer = new StringBuffer(32);
      int m = 0;
      while (m < localObject2.length)
      {
        if ((localObject2[m] > ' ') && (localObject2[m] != '/') && (localObject2[m] != '_') && (localObject2[m] != '&') && (localObject2[m] != '|') && (localObject2[m] != '-')) {
          localStringBuffer.append(localObject2[m]);
        }
        m += 1;
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
      jdField_d_of_type_JavaLangString = "AQQ_2013 4.6/2013 7.6.33560&NA_0/000000&ADR&" + jdField_e_of_type_JavaLangString + "18" + "&" + (String)localObject2 + "&" + "2017" + "&" + "BF266466230731EF" + "&" + c + "&" + "V3";
      return jdField_d_of_type_JavaLangString;
      label299:
      str2 = "ALL";
    }
  }
  
  public static final String c()
  {
    return "android 7.6.3";
  }
  
  public static String d()
  {
    return "349884";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.config.AppSetting
 * JD-Core Version:    0.7.0.1
 */