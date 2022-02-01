package com.tencent.kingkong;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.util.QQDeviceInfo;
import java.io.File;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

@SuppressLint({"NewApi"})
public class DataReport
{
  private static Context jdField_a_of_type_AndroidContentContext;
  private static PackageManager jdField_a_of_type_AndroidContentPmPackageManager;
  private static SensorManager jdField_a_of_type_AndroidHardwareSensorManager;
  private static ConnectivityManager jdField_a_of_type_AndroidNetConnectivityManager;
  private static WifiManager jdField_a_of_type_AndroidNetWifiWifiManager;
  private static TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager;
  private static String jdField_a_of_type_JavaLangString = "0";
  
  public static int a()
  {
    int j = -1;
    int i = j;
    try
    {
      if (jdField_a_of_type_AndroidContentContext != null)
      {
        Intent localIntent = jdField_a_of_type_AndroidContentContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        i = j;
        if (localIntent != null) {
          i = localIntent.getIntExtra("level", -1);
        }
      }
      return i;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  private static PackageManager a()
  {
    try
    {
      if ((jdField_a_of_type_AndroidContentContext != null) && (jdField_a_of_type_AndroidContentPmPackageManager == null)) {
        jdField_a_of_type_AndroidContentPmPackageManager = jdField_a_of_type_AndroidContentContext.getPackageManager();
      }
      PackageManager localPackageManager = jdField_a_of_type_AndroidContentPmPackageManager;
      return localPackageManager;
    }
    finally {}
  }
  
  private static SensorManager a()
  {
    try
    {
      if ((jdField_a_of_type_AndroidContentContext != null) && (jdField_a_of_type_AndroidHardwareSensorManager == null)) {
        jdField_a_of_type_AndroidHardwareSensorManager = (SensorManager)jdField_a_of_type_AndroidContentContext.getSystemService("sensor");
      }
      SensorManager localSensorManager = jdField_a_of_type_AndroidHardwareSensorManager;
      return localSensorManager;
    }
    finally {}
  }
  
  private static ConnectivityManager a()
  {
    try
    {
      if ((jdField_a_of_type_AndroidContentContext != null) && (jdField_a_of_type_AndroidNetConnectivityManager == null)) {
        jdField_a_of_type_AndroidNetConnectivityManager = (ConnectivityManager)jdField_a_of_type_AndroidContentContext.getSystemService("connectivity");
      }
      ConnectivityManager localConnectivityManager = jdField_a_of_type_AndroidNetConnectivityManager;
      return localConnectivityManager;
    }
    finally {}
  }
  
  private static WifiManager a()
  {
    try
    {
      if ((jdField_a_of_type_AndroidContentContext != null) && (jdField_a_of_type_AndroidNetWifiWifiManager == null)) {
        jdField_a_of_type_AndroidNetWifiWifiManager = (WifiManager)jdField_a_of_type_AndroidContentContext.getSystemService("wifi");
      }
      WifiManager localWifiManager = jdField_a_of_type_AndroidNetWifiWifiManager;
      return localWifiManager;
    }
    finally {}
  }
  
  private static TelephonyManager a()
  {
    try
    {
      if ((jdField_a_of_type_AndroidContentContext != null) && (jdField_a_of_type_AndroidTelephonyTelephonyManager == null)) {
        jdField_a_of_type_AndroidTelephonyTelephonyManager = (TelephonyManager)jdField_a_of_type_AndroidContentContext.getSystemService("phone");
      }
      TelephonyManager localTelephonyManager = jdField_a_of_type_AndroidTelephonyTelephonyManager;
      return localTelephonyManager;
    }
    finally {}
  }
  
  public static String a()
  {
    Object localObject = jdField_a_of_type_AndroidContentContext;
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = ((Context)localObject).getPackageManager().getPackageInfo(jdField_a_of_type_AndroidContentContext.getPackageName(), 0);
      if (localObject != null)
      {
        localObject = ((PackageInfo)localObject).versionName;
        boolean bool = TextUtils.isEmpty((CharSequence)localObject);
        if (!bool) {
          return localObject;
        }
      }
      return null;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static void a(Context paramContext)
  {
    jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Object localObject = jdField_a_of_type_AndroidContentContext;
    if (localObject != null)
    {
      localObject = ((Context)localObject).getSharedPreferences("SHARED_PREFERENCE_KINGKONG_PATCH", 0).edit();
      ((SharedPreferences.Editor)localObject).putString("QQUni", paramString);
      ((SharedPreferences.Editor)localObject).commit();
    }
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static boolean a()
  {
    Object localObject1 = null;
    boolean bool2 = false;
    try
    {
      Object localObject2 = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class }).invoke(null, new Object[] { "ro.secure" });
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      label39:
      boolean bool1;
      break label39;
    }
    if ((localObject1 != null) && ("1".equals(localObject1))) {
      return (new File("/system/bin/su").exists()) || (new File("/system/xbin/su").exists());
    }
    bool1 = bool2;
    if (localObject1 != null)
    {
      bool1 = bool2;
      if ("0".equals(localObject1)) {
        bool1 = true;
      }
    }
    if (bool1) {
      return bool1;
    }
    if ((!new File("/system/bin/su").exists()) && (!new File("/system/xbin/su").exists())) {
      return bool1;
    }
    return true;
  }
  
  public static int b()
  {
    int j = -1;
    int i = j;
    try
    {
      if (jdField_a_of_type_AndroidContentContext != null)
      {
        Intent localIntent = jdField_a_of_type_AndroidContentContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        i = j;
        if (localIntent != null) {
          i = localIntent.getIntExtra("temperature", -1);
        }
      }
      return i;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public static String b()
  {
    Object localObject = jdField_a_of_type_AndroidContentContext;
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = ((Context)localObject).getPackageName();
      boolean bool = TextUtils.isEmpty((CharSequence)localObject);
      if (!bool) {
        return localObject;
      }
      return null;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static boolean b()
  {
    try
    {
      Object localObject = a();
      if (localObject != null)
      {
        localObject = ((SensorManager)localObject).getDefaultSensor(1);
        if (localObject != null) {
          return true;
        }
      }
      return false;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static int c()
  {
    int j = -1;
    int i = j;
    try
    {
      if (jdField_a_of_type_AndroidContentContext != null)
      {
        Intent localIntent = jdField_a_of_type_AndroidContentContext.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        i = j;
        if (localIntent != null) {
          i = localIntent.getIntExtra("voltage", -1);
        }
      }
      return i;
    }
    catch (Exception localException) {}
    return -1;
  }
  
  public static String c()
  {
    Object localObject2 = null;
    try
    {
      Object localObject3 = a();
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((SensorManager)localObject3).getDefaultSensor(1);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((Sensor)localObject3).getName();
        }
      }
      return localObject1;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static boolean c()
  {
    boolean bool = false;
    try
    {
      PackageManager localPackageManager = a();
      if (localPackageManager != null) {
        bool = localPackageManager.hasSystemFeature("android.hardware.bluetooth_le");
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static String d()
  {
    Object localObject2 = null;
    try
    {
      Object localObject3 = a();
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((SensorManager)localObject3).getDefaultSensor(1);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((Sensor)localObject3).getVendor();
        }
      }
      return localObject1;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static boolean d()
  {
    boolean bool = false;
    try
    {
      PackageManager localPackageManager = a();
      if (localPackageManager != null) {
        bool = localPackageManager.hasSystemFeature("android.hardware.bluetooth");
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static String e()
  {
    try
    {
      TelephonyManager localTelephonyManager = a();
      if (localTelephonyManager != null) {
        switch (localTelephonyManager.getNetworkType())
        {
        case 1: 
        case 2: 
        case 4: 
        case 7: 
        case 11: 
          return "2G";
        }
      }
    }
    catch (Exception localException)
    {
      for (;;) {}
      return "4G";
    }
    return "unknown";
    return null;
    return "3G";
  }
  
  public static boolean e()
  {
    boolean bool = false;
    try
    {
      PackageManager localPackageManager = a();
      if (localPackageManager != null) {
        bool = localPackageManager.hasSystemFeature("android.hardware.location.gps");
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static String f()
  {
    try
    {
      Object localObject = a();
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getNetworkOperatorName();
        boolean bool = TextUtils.isEmpty((CharSequence)localObject);
        if (!bool) {
          return localObject;
        }
      }
      return null;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static boolean f()
  {
    boolean bool2 = false;
    try
    {
      Object localObject = a();
      boolean bool1 = bool2;
      if (localObject != null)
      {
        localObject = ((SensorManager)localObject).getDefaultSensor(9);
        bool1 = bool2;
        if (localObject != null) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static String g()
  {
    return null;
  }
  
  public static boolean g()
  {
    boolean bool2 = false;
    try
    {
      Object localObject = a();
      boolean bool1 = bool2;
      if (localObject != null)
      {
        localObject = ((SensorManager)localObject).getDefaultSensor(4);
        bool1 = bool2;
        if (localObject != null) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static String h()
  {
    Object localObject2 = null;
    try
    {
      Object localObject3 = a();
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((SensorManager)localObject3).getDefaultSensor(9);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((Sensor)localObject3).getName();
        }
      }
      return localObject1;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static boolean h()
  {
    boolean bool = false;
    try
    {
      PackageManager localPackageManager = a();
      if (localPackageManager != null) {
        bool = localPackageManager.hasSystemFeature("android.hardware.nfc");
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static String i()
  {
    Object localObject2 = null;
    try
    {
      Object localObject3 = a();
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((SensorManager)localObject3).getDefaultSensor(9);
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((Sensor)localObject3).getVendor();
        }
      }
      return localObject1;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static boolean i()
  {
    String str = null;
    try
    {
      if (Build.VERSION.SDK_INT > 14) {
        str = System.getProperty("http.proxyHost");
      } else if (jdField_a_of_type_AndroidContentContext != null) {
        str = Proxy.getHost(jdField_a_of_type_AndroidContentContext);
      }
      boolean bool = TextUtils.isEmpty(str);
      return !bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static String j()
  {
    try
    {
      Object localObject = a();
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getSubscriberId();
        boolean bool = TextUtils.isEmpty((CharSequence)localObject);
        if (!bool) {
          return localObject;
        }
      }
      return null;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static boolean j()
  {
    boolean bool = false;
    try
    {
      PackageManager localPackageManager = a();
      if (localPackageManager != null) {
        bool = localPackageManager.hasSystemFeature("android.hardware.telephony");
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static String k()
  {
    try
    {
      Object localObject1 = a();
      if (localObject1 != null)
      {
        Object localObject2 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
        if ((localObject2 != null) && (((NetworkInfo)localObject2).isAvailable()))
        {
          localObject2 = ((ConnectivityManager)localObject1).getNetworkInfo(1);
          if ((localObject2 != null) && (((NetworkInfo)localObject2).isAvailable()))
          {
            localObject2 = a();
            if ((localObject2 != null) && (((WifiManager)localObject2).isWifiEnabled()))
            {
              int i = ((WifiManager)localObject2).getConnectionInfo().getIpAddress();
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(i & 0xFF);
              ((StringBuilder)localObject1).append(".");
              ((StringBuilder)localObject1).append(i >> 8 & 0xFF);
              ((StringBuilder)localObject1).append(".");
              ((StringBuilder)localObject1).append(i >> 16 & 0xFF);
              ((StringBuilder)localObject1).append(".");
              ((StringBuilder)localObject1).append(i >> 24 & 0xFF);
              return ((StringBuilder)localObject1).toString();
            }
          }
          localObject1 = ((ConnectivityManager)localObject1).getNetworkInfo(0);
          if ((localObject1 != null) && (((NetworkInfo)localObject1).isAvailable()))
          {
            InetAddress localInetAddress;
            do
            {
              localObject1 = NetworkInterface.getNetworkInterfaces();
              while (!((Enumeration)localObject2).hasMoreElements())
              {
                if (!((Enumeration)localObject1).hasMoreElements()) {
                  break;
                }
                localObject2 = ((NetworkInterface)((Enumeration)localObject1).nextElement()).getInetAddresses();
              }
              localInetAddress = (InetAddress)((Enumeration)localObject2).nextElement();
            } while (localInetAddress.isLoopbackAddress());
            localObject1 = localInetAddress.getHostAddress().toString();
            return localObject1;
          }
        }
      }
      return null;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static boolean k()
  {
    boolean bool = false;
    try
    {
      PackageManager localPackageManager = a();
      if (localPackageManager != null) {
        bool = localPackageManager.hasSystemFeature("android.hardware.usb.accessory");
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static String l()
  {
    try
    {
      if (jdField_a_of_type_AndroidContentContext == null) {
        return null;
      }
      Object localObject1 = (WindowManager)jdField_a_of_type_AndroidContentContext.getSystemService("window");
      Object localObject2 = new DisplayMetrics();
      localObject1 = ((WindowManager)localObject1).getDefaultDisplay();
      int i = Build.VERSION.SDK_INT;
      if (i >= 17)
      {
        ((Display)localObject1).getRealMetrics((DisplayMetrics)localObject2);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(((DisplayMetrics)localObject2).heightPixels);
        ((StringBuilder)localObject1).append("*");
        ((StringBuilder)localObject1).append(((DisplayMetrics)localObject2).widthPixels);
        return ((StringBuilder)localObject1).toString();
      }
      localObject2 = Display.class.getMethod("getRawWidth", new Class[0]);
      Method localMethod = Display.class.getMethod("getRawHeight", new Class[0]);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localMethod.invoke(localObject1, new Object[0]));
      localStringBuilder.append("*");
      localStringBuilder.append(((Method)localObject2).invoke(localObject1, new Object[0]));
      localObject1 = localStringBuilder.toString();
      return localObject1;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static boolean l()
  {
    boolean bool = false;
    try
    {
      PackageManager localPackageManager = a();
      if (localPackageManager != null) {
        bool = localPackageManager.hasSystemFeature("android.hardware.wifi");
      }
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static String m()
  {
    StringBuilder localStringBuilder = null;
    try
    {
      Object localObject2 = Environment.getDataDirectory();
      Object localObject1 = localStringBuilder;
      if (localObject2 != null)
      {
        if (((File)localObject2).getAbsolutePath().length() == 0) {
          return null;
        }
        localObject1 = new StatFs(((File)localObject2).getPath());
        if (Build.VERSION.SDK_INT < 18)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(((StatFs)localObject1).getBlockCount() * ((StatFs)localObject1).getBlockSize());
          localStringBuilder.append("");
          return localStringBuilder.toString();
        }
        localObject2 = localObject1.getClass().getDeclaredMethod("getTotalBytes", new Class[0]).invoke(localObject1, new Object[0]);
        localObject1 = localStringBuilder;
        if (localObject2 != null) {
          localObject1 = ((Long)localObject2).toString();
        }
      }
      return localObject1;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String n()
  {
    StringBuilder localStringBuilder = null;
    try
    {
      if (!"mounted".equals(Environment.getExternalStorageState())) {
        return null;
      }
      Object localObject2 = Environment.getExternalStorageDirectory();
      Object localObject1 = localStringBuilder;
      if (localObject2 != null)
      {
        if (((File)localObject2).getAbsolutePath().length() == 0) {
          return null;
        }
        localObject1 = new StatFs(((File)localObject2).getPath());
        if (Build.VERSION.SDK_INT < 18)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(((StatFs)localObject1).getBlockCount() * ((StatFs)localObject1).getBlockSize());
          localStringBuilder.append("");
          return localStringBuilder.toString();
        }
        localObject2 = localObject1.getClass().getDeclaredMethod("getTotalBytes", new Class[0]).invoke(localObject1, new Object[0]);
        localObject1 = localStringBuilder;
        if (localObject2 != null) {
          localObject1 = ((Long)localObject2).toString();
        }
      }
      return localObject1;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String o()
  {
    if (!jdField_a_of_type_JavaLangString.equals("0")) {
      return jdField_a_of_type_JavaLangString;
    }
    Context localContext = jdField_a_of_type_AndroidContentContext;
    if (localContext != null) {
      return localContext.getSharedPreferences("SHARED_PREFERENCE_KINGKONG_PATCH", 0).getString("QQUni", "0");
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public static String p()
  {
    Object localObject = jdField_a_of_type_AndroidContentContext;
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = Settings.Secure.getString(((Context)localObject).getContentResolver(), "android_id");
      return localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String q()
  {
    Object localObject2 = null;
    try
    {
      Object localObject3 = a();
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((WifiManager)localObject3).getConnectionInfo();
        localObject1 = localObject2;
        if (localObject3 != null) {
          localObject1 = ((WifiInfo)localObject3).getMacAddress();
        }
      }
      return localObject1;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String r()
  {
    try
    {
      if (a() != null)
      {
        String str = QQDeviceInfo.getIMEI("641d5d");
        boolean bool = TextUtils.isEmpty(str);
        if (!bool) {
          return str;
        }
      }
      return null;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String s()
  {
    Object localObject2 = null;
    try
    {
      Object localObject3 = a();
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((ConnectivityManager)localObject3).getActiveNetworkInfo();
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          if (((NetworkInfo)localObject3).isConnected())
          {
            int i = ((NetworkInfo)localObject3).getType();
            if (i != 0)
            {
              if (i != 1) {
                return null;
              }
              return ((NetworkInfo)localObject3).getTypeName();
            }
            localObject1 = ((NetworkInfo)localObject3).getSubtypeName();
          }
        }
      }
      return localObject1;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.kingkong.DataReport
 * JD-Core Version:    0.7.0.1
 */