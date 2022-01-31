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
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.io.File;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

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
    if (jdField_a_of_type_AndroidContentContext == null) {}
    for (;;)
    {
      return null;
      try
      {
        Object localObject = jdField_a_of_type_AndroidContentContext.getPackageManager().getPackageInfo(jdField_a_of_type_AndroidContentContext.getPackageName(), 0);
        if (localObject != null)
        {
          localObject = ((PackageInfo)localObject).versionName;
          boolean bool = TextUtils.isEmpty((CharSequence)localObject);
          if (!bool) {
            return localObject;
          }
        }
      }
      catch (Exception localException) {}
    }
    return null;
  }
  
  private static String a(CellInfo paramCellInfo)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((paramCellInfo instanceof CellInfoCdma))
    {
      paramCellInfo = ((CellInfoCdma)paramCellInfo).getCellIdentity();
      localObject1 = localObject2;
      if (paramCellInfo != null)
      {
        i = paramCellInfo.getBasestationId();
        localObject1 = String.format("{\"cellType\":\"%s\", \"param\":{\"lat\":%d, \"lon\":%d, \"bid\":%d, \"nid\":%d, \"sid\":%d}}", new Object[] { "CDMA", Integer.valueOf(paramCellInfo.getLatitude()), Integer.valueOf(paramCellInfo.getLongitude()), Integer.valueOf(i), Integer.valueOf(paramCellInfo.getNetworkId()), Integer.valueOf(paramCellInfo.getSystemId()) });
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return localObject1;
            if ((Build.VERSION.SDK_INT < 18) || (!(paramCellInfo instanceof CellInfoWcdma))) {
              break;
            }
            paramCellInfo = ((CellInfoWcdma)paramCellInfo).getCellIdentity();
            localObject1 = localObject2;
          } while (paramCellInfo == null);
          i = paramCellInfo.getCid();
          return String.format("{\"cellType\":\"%s\", \"param\":{\"lac\":%d, \"cid\":%d, \"mnc\":%d, \"mcc\":%d}}", new Object[] { "WCDMA", Integer.valueOf(paramCellInfo.getLac()), Integer.valueOf(i), Integer.valueOf(paramCellInfo.getMnc()), Integer.valueOf(paramCellInfo.getMcc()) });
          if (!(paramCellInfo instanceof CellInfoGsm)) {
            break;
          }
          paramCellInfo = ((CellInfoGsm)paramCellInfo).getCellIdentity();
          localObject1 = localObject2;
        } while (paramCellInfo == null);
        i = paramCellInfo.getCid();
        return String.format("{\"cellType\":\"%s\", \"param\":{\"lac\":%d, \"cid\":%d, \"mnc\":%d, \"mcc\":%d}}", new Object[] { "GSM", Integer.valueOf(paramCellInfo.getLac()), Integer.valueOf(i), Integer.valueOf(paramCellInfo.getMnc()), Integer.valueOf(paramCellInfo.getMcc()) });
        localObject1 = localObject2;
      } while (!(paramCellInfo instanceof CellInfoLte));
      paramCellInfo = ((CellInfoLte)paramCellInfo).getCellIdentity();
      localObject1 = localObject2;
    } while (paramCellInfo == null);
    int i = paramCellInfo.getCi();
    return String.format("{\"cellType\":\"%s\", \"param\":{\"tac\":%d, \"cid\":%d, \"mnc\":%d, \"mcc\":%d}}", new Object[] { "LTE", Integer.valueOf(paramCellInfo.getTac()), Integer.valueOf(i), Integer.valueOf(paramCellInfo.getMnc()), Integer.valueOf(paramCellInfo.getMcc()) });
  }
  
  private static String a(String paramString)
  {
    String str = null;
    if (paramString != null)
    {
      paramString = paramString.trim();
      if (paramString.length() == 0) {
        break label77;
      }
    }
    for (;;)
    {
      if (paramString.charAt(0) == '"') {}
      while ((paramString.charAt(0) == '[') || (paramString.charAt(0) == '{')) {
        return paramString;
      }
      str = "\"" + paramString + "\"";
      return str;
      label77:
      paramString = null;
    }
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
    if (jdField_a_of_type_AndroidContentContext != null)
    {
      SharedPreferences.Editor localEditor = jdField_a_of_type_AndroidContentContext.getSharedPreferences("SHARED_PREFERENCE_KINGKONG_PATCH", 0).edit();
      localEditor.putString("QQUni", paramString);
      localEditor.commit();
    }
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static boolean a()
  {
    Object localObject1 = null;
    boolean bool3 = true;
    boolean bool2 = false;
    try
    {
      Object localObject2 = Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class }).invoke(null, new Object[] { "ro.secure" });
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      label46:
      boolean bool1;
      break label46;
    }
    if ((localObject1 != null) && ("1".equals(localObject1)))
    {
      if ((!new File("/system/bin/su").exists()) && (!new File("/system/xbin/su").exists())) {
        return false;
      }
    }
    else
    {
      bool1 = bool2;
      if (localObject1 != null)
      {
        bool1 = bool2;
        if ("0".equals(localObject1)) {
          bool1 = true;
        }
      }
      if (bool1) {
        bool2 = bool1;
      }
      for (;;)
      {
        return bool2;
        bool2 = bool3;
        if (!new File("/system/bin/su").exists())
        {
          bool2 = bool3;
          if (!new File("/system/xbin/su").exists()) {
            bool2 = bool1;
          }
        }
      }
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
    if (jdField_a_of_type_AndroidContentContext == null) {}
    for (;;)
    {
      return null;
      try
      {
        String str = jdField_a_of_type_AndroidContentContext.getPackageName();
        boolean bool = TextUtils.isEmpty(str);
        if (!bool) {
          return str;
        }
      }
      catch (Exception localException) {}
    }
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
    }
    catch (Exception localException)
    {
      return false;
    }
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
      int i;
      if (localTelephonyManager != null) {
        i = localTelephonyManager.getNetworkType();
      }
      switch (i)
      {
      default: 
        return "unknown";
      }
    }
    catch (Exception localException)
    {
      return null;
    }
    return "2G";
    return "3G";
    return "4G";
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
    }
    catch (Exception localException)
    {
      return null;
    }
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
    for (;;)
    {
      int i;
      try
      {
        TelephonyManager localTelephonyManager = a();
        if (localTelephonyManager != null)
        {
          if (Build.VERSION.SDK_INT >= 17)
          {
            Object localObject = localTelephonyManager.getAllCellInfo();
            if ((localObject != null) && (((List)localObject).size() != 0))
            {
              int j = ((List)localObject).size();
              i = 0;
              if (i < j)
              {
                CellInfo localCellInfo = (CellInfo)((List)localObject).get(i);
                if (!localCellInfo.isRegistered()) {
                  break label248;
                }
                localObject = a(a(localCellInfo));
                if (localObject != null) {
                  break label246;
                }
                localObject = localTelephonyManager.getCellLocation();
                if (localObject == null) {
                  return null;
                }
                if ((localObject instanceof GsmCellLocation))
                {
                  localObject = String.format("{\"cellType\":\"GSM\", \"param\":{\"lac\":%d, \"cid\":%d}}", new Object[] { Integer.valueOf(((GsmCellLocation)localObject).getLac()), Integer.valueOf(((GsmCellLocation)localObject).getCid()) });
                  return a((String)localObject);
                }
                if ((localObject instanceof CdmaCellLocation))
                {
                  localObject = String.format("{\"cellType\":\"CDMA\", \"param\":{\"lat\":%d, \"lon\":%d, \"bid\":%d, \"nid\":%d, \"sid\":%d}}", new Object[] { Integer.valueOf(((CdmaCellLocation)localObject).getBaseStationLatitude()), Integer.valueOf(((CdmaCellLocation)localObject).getBaseStationLongitude()), Integer.valueOf(((CdmaCellLocation)localObject).getBaseStationId()), Integer.valueOf(((CdmaCellLocation)localObject).getNetworkId()), Integer.valueOf(((CdmaCellLocation)localObject).getSystemId()) });
                  continue;
                }
                localObject = null;
                continue;
              }
            }
          }
        }
        else {
          return null;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
      String str = null;
      continue;
      label246:
      return str;
      label248:
      i += 1;
    }
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
      }
      while (!TextUtils.isEmpty(str))
      {
        return true;
        if (jdField_a_of_type_AndroidContentContext != null) {
          str = Proxy.getHost(jdField_a_of_type_AndroidContentContext);
        }
      }
      return false;
    }
    catch (Exception localException) {}
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
    }
    catch (Exception localException)
    {
      return null;
    }
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
              return (i & 0xFF) + "." + (i >> 8 & 0xFF) + "." + (i >> 16 & 0xFF) + "." + (i >> 24 & 0xFF);
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
    }
    catch (Exception localException)
    {
      return null;
    }
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
      if (Build.VERSION.SDK_INT >= 17)
      {
        ((Display)localObject1).getRealMetrics((DisplayMetrics)localObject2);
        return ((DisplayMetrics)localObject2).heightPixels + "*" + ((DisplayMetrics)localObject2).widthPixels;
      }
      localObject2 = Display.class.getMethod("getRawWidth", new Class[0]);
      Method localMethod = Display.class.getMethod("getRawHeight", new Class[0]);
      localObject1 = localMethod.invoke(localObject1, new Object[0]) + "*" + ((Method)localObject2).invoke(localObject1, new Object[0]);
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
    try
    {
      Object localObject = Environment.getDataDirectory();
      if ((localObject == null) || (((File)localObject).getAbsolutePath().length() == 0)) {
        break label116;
      }
      localObject = new StatFs(((File)localObject).getPath());
      if (Build.VERSION.SDK_INT < 18)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        long l = ((StatFs)localObject).getBlockCount();
        return ((StatFs)localObject).getBlockSize() * l + "";
      }
      localObject = localObject.getClass().getDeclaredMethod("getTotalBytes", new Class[0]).invoke(localObject, new Object[0]);
      if (localObject != null)
      {
        localObject = ((Long)localObject).toString();
        return localObject;
      }
    }
    catch (Exception localException) {}
    return null;
    label116:
    return null;
  }
  
  public static String n()
  {
    try
    {
      if (!"mounted".equals(Environment.getExternalStorageState())) {
        return null;
      }
      Object localObject = Environment.getExternalStorageDirectory();
      if ((localObject == null) || (((File)localObject).getAbsolutePath().length() == 0)) {
        break label130;
      }
      localObject = new StatFs(((File)localObject).getPath());
      if (Build.VERSION.SDK_INT < 18)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        long l = ((StatFs)localObject).getBlockCount();
        return ((StatFs)localObject).getBlockSize() * l + "";
      }
      localObject = localObject.getClass().getDeclaredMethod("getTotalBytes", new Class[0]).invoke(localObject, new Object[0]);
      if (localObject != null)
      {
        localObject = ((Long)localObject).toString();
        return localObject;
      }
    }
    catch (Exception localException) {}
    return null;
    label130:
    return null;
  }
  
  public static String o()
  {
    if (!jdField_a_of_type_JavaLangString.equals("0")) {
      return jdField_a_of_type_JavaLangString;
    }
    if (jdField_a_of_type_AndroidContentContext != null) {
      return jdField_a_of_type_AndroidContentContext.getSharedPreferences("SHARED_PREFERENCE_KINGKONG_PATCH", 0).getString("QQUni", "0");
    }
    return jdField_a_of_type_JavaLangString;
  }
  
  public static String p()
  {
    if (jdField_a_of_type_AndroidContentContext == null) {
      return null;
    }
    try
    {
      String str = Settings.Secure.getString(jdField_a_of_type_AndroidContentContext.getContentResolver(), "android_id");
      return str;
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
      Object localObject = a();
      if (localObject != null)
      {
        localObject = ((TelephonyManager)localObject).getDeviceId();
        boolean bool = TextUtils.isEmpty((CharSequence)localObject);
        if (!bool) {
          return localObject;
        }
      }
    }
    catch (Exception localException)
    {
      return null;
    }
    return null;
  }
  
  public static String s()
  {
    try
    {
      localObject = a();
      if (localObject == null) {
        break label67;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if ((localObject == null) || (!((NetworkInfo)localObject).isConnected())) {
        break label67;
      }
      switch (((NetworkInfo)localObject).getType())
      {
      case 1: 
        return ((NetworkInfo)localObject).getTypeName();
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      return null;
    }
    localObject = ((NetworkInfo)localObject).getSubtypeName();
    return localObject;
    label67:
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.tencent.kingkong.DataReport
 * JD-Core Version:    0.7.0.1
 */