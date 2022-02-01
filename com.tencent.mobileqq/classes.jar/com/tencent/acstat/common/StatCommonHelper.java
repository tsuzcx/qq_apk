package com.tencent.acstat.common;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.KeyguardManager;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.acstat.StatConfig;
import com.tencent.acstat.StatReportStrategy;
import com.tencent.acstat.StatSpecifyReportedInfo;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public class StatCommonHelper
{
  private static String a;
  private static String b;
  private static String c;
  private static String d;
  private static Random e;
  private static DisplayMetrics f;
  private static String g;
  private static String h = "";
  private static String i = "";
  private static volatile int j = -1;
  private static StatLogger k;
  private static String l;
  private static String m;
  private static volatile int n = -1;
  private static String o;
  private static String p;
  private static long q = -1L;
  private static String r = "";
  private static k s;
  private static String t = "__MTA_FIRST_ACTIVATE__";
  private static int u = -1;
  private static long v = -1L;
  private static int w = 0;
  private static String x = "";
  private static volatile String y;
  
  static String a(Context paramContext)
  {
    try
    {
      if (m != null) {
        return m;
      }
      int i1 = Process.myPid();
      paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        if (localRunningAppProcessInfo.pid == i1) {
          m = localRunningAppProcessInfo.processName;
        }
      }
    }
    catch (Throwable paramContext)
    {
      label66:
      break label66;
    }
    return m;
  }
  
  private static long b(Context paramContext)
  {
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    paramContext.getMemoryInfo(localMemoryInfo);
    return localMemoryInfo.availMem;
  }
  
  private static Random b()
  {
    try
    {
      if (e == null) {
        e = new Random();
      }
      Random localRandom = e;
      return localRandom;
    }
    finally {}
  }
  
  private static long c()
  {
    l1 = q;
    if (l1 > 0L) {
      return l1;
    }
    long l3 = 1L;
    l2 = l3;
    try
    {
      BufferedReader localBufferedReader = new BufferedReader(new FileReader("/proc/meminfo"), 8192);
      l2 = l3;
      String str = localBufferedReader.readLine();
      l1 = l3;
      l2 = l3;
      if (!TextUtils.isEmpty(str))
      {
        l2 = l3;
        l1 = Integer.valueOf(str.split("\\s+")[1]).intValue() << 10;
      }
      l2 = l1;
      localBufferedReader.close();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l1 = l2;
      }
    }
    q = l1;
    return l1;
  }
  
  public static int checkBluetooth()
  {
    BluetoothAdapter localBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if (localBluetoothAdapter == null) {
      return -1;
    }
    if (localBluetoothAdapter.isEnabled()) {
      return 1;
    }
    return 0;
  }
  
  public static void checkFirstTimeActivate(Context paramContext)
  {
    int i1 = StatPreferences.getInt(paramContext, t, 1);
    u = i1;
    if (i1 == 1) {
      StatPreferences.putInt(paramContext, t, 0);
    }
  }
  
  public static boolean checkPhoneState(Context paramContext)
  {
    return paramContext.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", paramContext.getPackageName()) == 0;
  }
  
  public static Long convertStringToLong(String paramString1, String paramString2, int paramInt1, int paramInt2, Long paramLong)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return paramLong;
      }
      Object localObject;
      if (!paramString2.equalsIgnoreCase("."))
      {
        localObject = paramString2;
        if (!paramString2.equalsIgnoreCase("|")) {}
      }
      else
      {
        localObject = new StringBuilder("\\");
        ((StringBuilder)localObject).append(paramString2);
        localObject = ((StringBuilder)localObject).toString();
      }
      paramString2 = paramString1.split((String)localObject);
      if (paramString2.length != paramInt2) {}
    }
    try
    {
      paramString1 = Long.valueOf(0L);
      paramInt2 = 0;
      while (paramInt2 < paramString2.length)
      {
        paramString1 = Long.valueOf(paramInt1 * (paramString1.longValue() + Long.valueOf(paramString2[paramInt2]).longValue()));
        paramInt2 += 1;
      }
      return paramString1;
    }
    catch (NumberFormatException paramString1) {}
    return paramLong;
    return paramLong;
  }
  
  public static byte[] deocdeGZipContent(byte[] paramArrayOfByte)
  {
    ByteArrayInputStream localByteArrayInputStream = new ByteArrayInputStream(paramArrayOfByte);
    GZIPInputStream localGZIPInputStream = new GZIPInputStream(localByteArrayInputStream);
    byte[] arrayOfByte = new byte[4096];
    paramArrayOfByte = new ByteArrayOutputStream(paramArrayOfByte.length << 1);
    for (;;)
    {
      int i1 = localGZIPInputStream.read(arrayOfByte);
      if (i1 == -1) {
        break;
      }
      paramArrayOfByte.write(arrayOfByte, 0, i1);
    }
    arrayOfByte = paramArrayOfByte.toByteArray();
    localByteArrayInputStream.close();
    localGZIPInputStream.close();
    paramArrayOfByte.close();
    return arrayOfByte;
  }
  
  public static String getActivityName(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    return paramContext.getClass().getName();
  }
  
  public static String getAllSensors(Context paramContext)
  {
    if (isStringValid(r)) {
      return r;
    }
    for (;;)
    {
      int i1;
      try
      {
        paramContext = (SensorManager)paramContext.getSystemService("sensor");
        if (paramContext != null)
        {
          paramContext = paramContext.getSensorList(-1);
          if (paramContext != null)
          {
            StringBuilder localStringBuilder = new StringBuilder(paramContext.size() * 10);
            i1 = 0;
            if (i1 < paramContext.size())
            {
              localStringBuilder.append(((Sensor)paramContext.get(i1)).getType());
              if (i1 == paramContext.size() - 1) {
                break label130;
              }
              localStringBuilder.append(",");
              break label130;
            }
            r = localStringBuilder.toString();
          }
        }
      }
      catch (Throwable paramContext)
      {
        k.e(paramContext);
      }
      return r;
      label130:
      i1 += 1;
    }
  }
  
  public static int getAndroidOsBuildVersion()
  {
    return Build.VERSION.SDK_INT;
  }
  
  public static String getAppKey(Context paramContext)
  {
    String str = b;
    if (str != null) {
      return str;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext == null) {
        break label71;
      }
      paramContext = paramContext.metaData.getString("TA_APPKEY");
      if (paramContext != null)
      {
        b = paramContext;
        return paramContext;
      }
      k.i("Could not read APPKEY meta-data from AndroidManifest.xml");
    }
    catch (Throwable paramContext)
    {
      label62:
      label71:
      break label62;
    }
    k.i("Could not read APPKEY meta-data from AndroidManifest.xml");
    return null;
  }
  
  public static String getAppSHA1(Context paramContext)
  {
    if (!TextUtils.isEmpty(y)) {
      return y;
    }
    for (;;)
    {
      int i1;
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 64).signatures;
        i1 = 0;
        paramContext = paramContext[0].toByteArray();
        paramContext = MessageDigest.getInstance("SHA1").digest(paramContext);
        StringBuffer localStringBuffer = new StringBuffer();
        int i2 = paramContext.length;
        if (i1 < i2)
        {
          String str = Integer.toHexString(paramContext[i1] & 0xFF).toUpperCase();
          if (str.length() == 1) {
            localStringBuffer.append("0");
          }
          localStringBuffer.append(str);
          if (i1 == i2 - 1) {
            break label150;
          }
          localStringBuffer.append(":");
          break label150;
        }
        y = localStringBuffer.toString();
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        paramContext.printStackTrace();
      }
      return y;
      label150:
      i1 += 1;
    }
  }
  
  public static String getAppVersion(Context paramContext)
  {
    if (isStringValid(i)) {
      return i;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      i = paramContext;
      if ((paramContext == null) || (i.length() == 0)) {
        return "unknown";
      }
    }
    catch (Throwable paramContext)
    {
      k.e(paramContext);
    }
    return i;
  }
  
  public static String getCameras(Context paramContext)
  {
    if (isStringValid(x)) {
      return x;
    }
    return x;
  }
  
  public static k getCamerasHelper(Context paramContext)
  {
    try
    {
      if (s == null) {
        s = new k();
      }
      paramContext = s;
      return paramContext;
    }
    finally {}
  }
  
  public static JSONObject getCpuInfo(Context paramContext)
  {
    paramContext = new JSONObject();
    try
    {
      paramContext.put("n", i.a());
      String str = i.d();
      if ((str != null) && (str.length() > 0)) {
        paramContext.put("na", str);
      }
      int i1 = i.b();
      if (i1 > 0) {
        paramContext.put("fx", i1 / 1000000);
      }
      i1 = i.c();
      if (i1 > 0)
      {
        paramContext.put("fn", i1 / 1000000);
        return paramContext;
      }
    }
    catch (Throwable localThrowable)
    {
      Log.w("MtaSDK", "get cpu error", localThrowable);
    }
    return paramContext;
  }
  
  public static String getCpuString()
  {
    if (isStringValid(o)) {
      return o;
    }
    if (Build.CPU_ABI.equalsIgnoreCase("x86")) {
      o = "Intel";
    } else {
      try
      {
        Object localObject = new byte[1024];
        RandomAccessFile localRandomAccessFile = new RandomAccessFile("/proc/cpuinfo", "r");
        localRandomAccessFile.read((byte[])localObject);
        localRandomAccessFile.close();
        localObject = new String((byte[])localObject);
        int i1 = ((String)localObject).indexOf(0);
        if (i1 != -1) {
          o = ((String)localObject).substring(0, i1);
        } else {
          o = (String)localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        k.e(localThrowable);
      }
    }
    return o;
  }
  
  public static String getCpuType()
  {
    Object localObject2 = getCpuString();
    Object localObject1;
    if (((String)localObject2).contains("ARMv5"))
    {
      localObject1 = "armv5";
    }
    else if (((String)localObject2).contains("ARMv6"))
    {
      localObject1 = "armv6";
    }
    else if (((String)localObject2).contains("ARMv7"))
    {
      localObject1 = "armv7";
    }
    else
    {
      if (!((String)localObject2).contains("Intel")) {
        break label205;
      }
      localObject1 = "x86";
    }
    Object localObject3;
    if (((String)localObject2).contains("neon"))
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      localObject2 = "_neon";
      localObject1 = localObject3;
    }
    for (;;)
    {
      ((StringBuilder)localObject1).append((String)localObject2);
      return ((StringBuilder)localObject1).toString();
      if (((String)localObject2).contains("vfpv3"))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject3 = "_vfpv3";
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      else if (((String)localObject2).contains(" vfp"))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject3 = "_vfp";
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject3 = "_none";
        localObject1 = localObject2;
        localObject2 = localObject3;
      }
    }
    label205:
    return "unknown";
  }
  
  public static String getCurAppVersion(Context paramContext)
  {
    if (isStringValid(h)) {
      return h;
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      h = paramContext;
      if (paramContext == null) {
        return "";
      }
    }
    catch (Throwable paramContext)
    {
      k.e(paramContext);
    }
    return h;
  }
  
  public static String getDatabaseName(Context paramContext)
  {
    return getTagForConcurrentProcess(paramContext, StatConstants.DATABASE_NAME);
  }
  
  public static String getDateFormat(long paramLong)
  {
    return new SimpleDateFormat("yyyyMMdd").format(new Date(paramLong));
  }
  
  public static String getDateString(int paramInt)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.roll(6, paramInt);
    return new SimpleDateFormat("yyyyMMdd").format(localCalendar.getTime());
  }
  
  public static String getDeviceModel(Context paramContext)
  {
    if (d == null) {
      d = Build.MODEL;
    }
    return d;
  }
  
  public static int getDiffTime(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {
      w = readDiffTimeFromServer(paramContext);
    }
    return w;
  }
  
  public static DisplayMetrics getDisplayMetrics(Context paramContext)
  {
    if (f == null)
    {
      f = new DisplayMetrics();
      ((WindowManager)paramContext.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(f);
    }
    return f;
  }
  
  public static String getExternalStorageInfo(Context paramContext)
  {
    if (isStringValid(l)) {
      return l;
    }
    try
    {
      if (Util.checkPermission(paramContext, "android.permission.WRITE_EXTERNAL_STORAGE"))
      {
        paramContext = Environment.getExternalStorageState();
        if ((paramContext != null) && (paramContext.equals("mounted")))
        {
          paramContext = Environment.getExternalStorageDirectory().getPath();
          if (paramContext != null)
          {
            paramContext = new StatFs(paramContext);
            long l1 = paramContext.getBlockCount() * paramContext.getBlockSize() / 1000000L;
            long l2 = paramContext.getAvailableBlocks() * paramContext.getBlockSize() / 1000000L;
            paramContext = new StringBuilder();
            paramContext.append(String.valueOf(l2));
            paramContext.append("/");
            paramContext.append(String.valueOf(l1));
            paramContext = paramContext.toString();
            l = paramContext;
            return paramContext;
          }
        }
      }
      else
      {
        k.warn("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
        return null;
      }
    }
    catch (Throwable paramContext)
    {
      k.e(paramContext);
    }
    return null;
  }
  
  public static Location getGPSLocation(Context paramContext)
  {
    Object localObject3 = null;
    StringBuilder localStringBuilder = null;
    Object localObject1 = localStringBuilder;
    Object localObject2 = localObject3;
    try
    {
      if (Util.checkPermission(paramContext, "android.permission.ACCESS_FINE_LOCATION"))
      {
        localObject1 = localStringBuilder;
        k.e("getGPSLocation");
        localObject1 = localStringBuilder;
        paramContext = (LocationManager)paramContext.getSystemService("location");
        localObject1 = localStringBuilder;
        localObject2 = localObject3;
        if (paramContext.isProviderEnabled("gps"))
        {
          localObject1 = localStringBuilder;
          paramContext = paramContext.getLastKnownLocation("gps");
          localObject1 = paramContext;
          localObject2 = k;
          localObject1 = paramContext;
          localStringBuilder = new StringBuilder("getGPSLocation location:");
          localObject1 = paramContext;
          localStringBuilder.append(paramContext);
          localObject1 = paramContext;
          ((StatLogger)localObject2).e(localStringBuilder.toString());
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      k.e(paramContext);
      localObject2 = localObject1;
    }
    return localObject2;
  }
  
  public static HttpHost getHttpProxy(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      if (paramContext.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", paramContext.getPackageName()) != 0) {
        return null;
      }
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null) {
        return null;
      }
      if ((paramContext.getTypeName() != null) && (paramContext.getTypeName().equalsIgnoreCase("WIFI"))) {
        return null;
      }
      paramContext = paramContext.getExtraInfo();
      if (paramContext == null) {
        return null;
      }
      if ((!paramContext.equals("cmwap")) && (!paramContext.equals("3gwap")) && (!paramContext.equals("uniwap")))
      {
        if (paramContext.equals("ctwap")) {
          return new HttpHost("10.0.0.200", 80);
        }
        paramContext = Proxy.getDefaultHost();
        if ((paramContext != null) && (paramContext.trim().length() > 0)) {
          return new HttpHost(paramContext, Proxy.getDefaultPort());
        }
      }
      else
      {
        paramContext = new HttpHost("10.0.0.172", 80);
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      k.e(paramContext);
    }
    return null;
  }
  
  public static String getInstallChannel(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext == null) {
        break label60;
      }
      paramContext = paramContext.metaData.get("InstallChannel");
      if (paramContext != null) {
        return paramContext.toString();
      }
      k.w("Could not read InstallChannel meta-data from AndroidManifest.xml");
    }
    catch (Throwable paramContext)
    {
      label51:
      label60:
      break label51;
    }
    k.e("Could not read InstallChannel meta-data from AndroidManifest.xml");
    return null;
  }
  
  public static String getLauncherPackageName(Context paramContext)
  {
    if (paramContext == null) {
      return null;
    }
    Intent localIntent = new Intent("android.intent.action.MAIN");
    localIntent.addCategory("android.intent.category.HOME");
    paramContext = paramContext.getPackageManager().resolveActivity(localIntent, 0);
    if (paramContext.activityInfo == null) {
      return null;
    }
    if (paramContext.activityInfo.packageName.equals("android")) {
      return null;
    }
    return paramContext.activityInfo.packageName;
  }
  
  public static String getLinkedWay(Context paramContext)
  {
    Object localObject;
    try
    {
      boolean bool = Util.checkPermission(paramContext, "android.permission.INTERNET");
      if ((bool) && (Util.checkPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE")))
      {
        localObject = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((localObject != null) && (((NetworkInfo)localObject).isConnected()))
        {
          paramContext = ((NetworkInfo)localObject).getTypeName();
          localObject = ((NetworkInfo)localObject).getExtraInfo();
          if (paramContext != null)
          {
            if (paramContext.equalsIgnoreCase("WIFI")) {
              return "WIFI";
            }
            if (paramContext.equalsIgnoreCase("MOBILE"))
            {
              if ((localObject == null) || (((String)localObject).trim().length() <= 0)) {
                break label142;
              }
              break label146;
            }
            if ((localObject == null) || (((String)localObject).trim().length() <= 0)) {
              return paramContext;
            }
            break label146;
          }
        }
      }
      else
      {
        k.e("can not get the permission of android.permission.ACCESS_WIFI_STATE");
        return "";
      }
    }
    catch (Throwable paramContext)
    {
      k.e(paramContext);
    }
    return "";
    label142:
    return "MOBILE";
    label146:
    return localObject;
    return paramContext;
  }
  
  public static StatLogger getLogger()
  {
    try
    {
      if (k == null)
      {
        localStatLogger = new StatLogger("MtaSDK");
        k = localStatLogger;
        localStatLogger.setDebugEnable(false);
      }
      StatLogger localStatLogger = k;
      return localStatLogger;
    }
    finally {}
  }
  
  public static String getMacId(Context paramContext)
  {
    try
    {
      if ((c == null) || (c.trim().length() == 0)) {
        c = Util.getWifiMacAddress(paramContext);
      }
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
  
  public static Location getNetworkLocation(Context paramContext)
  {
    StringBuilder localStringBuilder = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject1 = localStringBuilder;
    try
    {
      if (!Util.checkPermission(paramContext, "android.permission.ACCESS_COARSE_LOCATION"))
      {
        localObject1 = localStringBuilder;
        if (!Util.checkPermission(paramContext, "android.permission.ACCESS_FINE_LOCATION")) {}
      }
      else
      {
        localObject1 = localStringBuilder;
        k.e("getNetworkLocation");
        localObject1 = localStringBuilder;
        localObject2 = (LocationManager)paramContext.getSystemService("location");
        paramContext = localObject3;
        localObject1 = localStringBuilder;
        if (((LocationManager)localObject2).isProviderEnabled("network"))
        {
          localObject1 = localStringBuilder;
          paramContext = ((LocationManager)localObject2).getLastKnownLocation("network");
        }
        localObject1 = paramContext;
        localObject2 = k;
        localObject1 = paramContext;
        localStringBuilder = new StringBuilder("getNetworkLocation location:");
        localObject1 = paramContext;
        localStringBuilder.append(paramContext);
        localObject1 = paramContext;
        ((StatLogger)localObject2).e(localStringBuilder.toString());
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      k.e(paramContext);
      localObject2 = localObject1;
    }
    return localObject2;
  }
  
  public static Integer getNextEventIndexNo(Context paramContext)
  {
    try
    {
      if (n > 0)
      {
        i1 = n;
        if (i1 % 1000 == 0) {
          try
          {
            i1 = n + 1000;
            if (n >= 2147383647) {
              i1 = 0;
            }
            StatPreferences.putInt(paramContext, "MTA_EVENT_INDEX", i1);
          }
          catch (Throwable paramContext)
          {
            k.w(paramContext);
          }
        }
      }
      else
      {
        n = StatPreferences.getInt(paramContext, "MTA_EVENT_INDEX", 0);
        StatPreferences.putInt(paramContext, "MTA_EVENT_INDEX", n + 1000);
      }
      int i1 = n + 1;
      n = i1;
      return Integer.valueOf(i1);
    }
    finally {}
  }
  
  public static int getNextSessionID()
  {
    return b().nextInt(2147483647);
  }
  
  public static String getPackageName(Context paramContext)
  {
    if (Util.checkPermission(paramContext, "android.permission.GET_TASKS")) {
      return ((ActivityManager.RunningTaskInfo)((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getPackageName();
    }
    k.e("Could not get permission of android.permission.GET_TASKS");
    return null;
  }
  
  public static String getProperty(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext != null)
      {
        paramContext = paramContext.metaData.getString(paramString);
        if (paramContext != null) {
          return paramContext;
        }
      }
    }
    catch (Throwable paramContext)
    {
      k.e(paramContext);
    }
    return "";
  }
  
  public static String getRomMemory()
  {
    if (isStringValid(p)) {
      return p;
    }
    long l1 = getTotalInternalMemorySize() / 1000000L;
    Object localObject = new StatFs(Environment.getDataDirectory().getPath());
    long l2 = ((StatFs)localObject).getBlockSize() * ((StatFs)localObject).getAvailableBlocks() / 1000000L;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.valueOf(l2));
    ((StringBuilder)localObject).append("/");
    ((StringBuilder)localObject).append(String.valueOf(l1));
    localObject = ((StringBuilder)localObject).toString();
    p = (String)localObject;
    return localObject;
  }
  
  public static long getSDKLongVersion(String paramString)
  {
    return convertStringToLong(paramString, ".", 100, 3, Long.valueOf(0L)).longValue();
  }
  
  public static String getSimOperator(Context paramContext)
  {
    String str = g;
    if (str != null) {
      return str;
    }
    try
    {
      if (Util.checkPermission(paramContext, "android.permission.READ_PHONE_STATE"))
      {
        if (checkPhoneState(paramContext))
        {
          paramContext = (TelephonyManager)paramContext.getSystemService("phone");
          if (paramContext != null) {
            g = paramContext.getSimOperator();
          }
        }
      }
      else {
        k.e("Could not get permission of android.permission.READ_PHONE_STATE");
      }
    }
    catch (Throwable paramContext)
    {
      k.e(paramContext);
    }
    return g;
  }
  
  public static StatReportStrategy getStatSendStrategy(Context paramContext)
  {
    return StatConfig.getStatSendStrategy();
  }
  
  public static String getSystemMemory(Context paramContext)
  {
    try
    {
      long l1 = b(paramContext) / 1000000L;
      long l2 = c() / 1000000L;
      paramContext = new StringBuilder();
      paramContext.append(String.valueOf(l1));
      paramContext.append("/");
      paramContext.append(String.valueOf(l2));
      paramContext = paramContext.toString();
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static String getTagForConcurrentProcess(Context paramContext, String paramString)
  {
    if (StatConfig.isEnableConcurrentProcess() == true)
    {
      if (m == null) {
        m = a(paramContext);
      }
      if (m != null)
      {
        paramContext = new StringBuilder();
        paramContext.append(paramString);
        paramContext.append("_");
        paramContext.append(m);
        return paramContext.toString();
      }
    }
    return paramString;
  }
  
  public static Integer getTelephonyNetworkType(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext != null)
      {
        int i1 = paramContext.getNetworkType();
        return Integer.valueOf(i1);
      }
    }
    catch (Throwable paramContext)
    {
      label25:
      break label25;
    }
    return null;
  }
  
  public static long getTomorrowStartMilliseconds()
  {
    try
    {
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.set(11, 0);
      localCalendar.set(12, 0);
      localCalendar.set(13, 0);
      localCalendar.set(14, 0);
      long l1 = localCalendar.getTimeInMillis();
      return l1 + 86400000L;
    }
    catch (Throwable localThrowable)
    {
      k.e(localThrowable);
    }
    return System.currentTimeMillis() + 86400000L;
  }
  
  public static long getTotalInternalMemorySize()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    long l1 = localStatFs.getBlockSize();
    return localStatFs.getBlockCount() * l1;
  }
  
  public static String getUserID(Context paramContext)
  {
    try
    {
      if ((a != null) && (a.trim().length() != 0))
      {
        paramContext = a;
        return paramContext;
      }
      a = Util.getDeviceID(paramContext);
      if ((a == null) || (a.trim().length() == 0)) {
        a = Integer.toString(b().nextInt(2147483647));
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  public static int hasRootAccess(Context paramContext)
  {
    // Byte code:
    //   0: getstatic 917	com/tencent/acstat/common/StatCommonHelper:j	I
    //   3: iflt +7 -> 10
    //   6: getstatic 917	com/tencent/acstat/common/StatCommonHelper:j	I
    //   9: ireturn
    //   10: iconst_0
    //   11: putstatic 917	com/tencent/acstat/common/StatCommonHelper:j	I
    //   14: ldc 2
    //   16: monitorenter
    //   17: invokestatic 921	com/tencent/acstat/common/l:a	()Z
    //   20: ifeq +22 -> 42
    //   23: iconst_1
    //   24: putstatic 917	com/tencent/acstat/common/StatCommonHelper:j	I
    //   27: goto +15 -> 42
    //   30: astore_0
    //   31: goto +18 -> 49
    //   34: astore_0
    //   35: getstatic 53	com/tencent/acstat/common/StatCommonHelper:k	Lcom/tencent/acstat/common/StatLogger;
    //   38: aload_0
    //   39: invokevirtual 323	com/tencent/acstat/common/StatLogger:e	(Ljava/lang/Throwable;)V
    //   42: ldc 2
    //   44: monitorexit
    //   45: getstatic 917	com/tencent/acstat/common/StatCommonHelper:j	I
    //   48: ireturn
    //   49: ldc 2
    //   51: monitorexit
    //   52: aload_0
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	paramContext	Context
    // Exception table:
    //   from	to	target	type
    //   17	27	30	finally
    //   35	42	30	finally
    //   42	45	30	finally
    //   49	52	30	finally
    //   17	27	34	java/lang/Throwable
  }
  
  public static boolean haveGravity(Context paramContext)
  {
    return (SensorManager)paramContext.getSystemService("sensor") != null;
  }
  
  public static boolean isApplicationBroughtToBackground(Context paramContext)
  {
    if (!Util.checkPermission(paramContext, "android.permission.GET_TASKS")) {
      return false;
    }
    List localList = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    return (!localList.isEmpty()) && (!((ActivityManager.RunningTaskInfo)localList.get(0)).topActivity.getPackageName().equals(paramContext.getPackageName()));
  }
  
  public static boolean isBackground(Context paramContext)
  {
    Object localObject = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses().iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (localRunningAppProcessInfo.processName.equalsIgnoreCase(paramContext.getPackageName()))
      {
        localObject = k;
        StringBuilder localStringBuilder = new StringBuilder("isBackground processName:");
        localStringBuilder.append(localRunningAppProcessInfo.processName);
        localStringBuilder.append(", importance:");
        localStringBuilder.append(localRunningAppProcessInfo.importance);
        ((StatLogger)localObject).i(localStringBuilder.toString());
        if ((localRunningAppProcessInfo.importance != 400) && (localRunningAppProcessInfo.importance != 130))
        {
          if ((localRunningAppProcessInfo.importance != 100) && (localRunningAppProcessInfo.importance != 200)) {
            return false;
          }
          return isLockScreenOn(paramContext);
        }
        return true;
      }
    }
    return false;
  }
  
  public static boolean isBackgroundRunning(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    if (localObject == null) {
      return false;
    }
    paramContext = paramContext.getPackageName();
    localObject = ((ActivityManager)localObject).getRunningAppProcesses().iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      if (localRunningAppProcessInfo.processName.startsWith(paramContext)) {
        if (localRunningAppProcessInfo.importance == 400) {
          return true;
        }
      }
    }
    return false;
  }
  
  public static boolean isLockScreenOn(Context paramContext)
  {
    return ((KeyguardManager)paramContext.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
  }
  
  public static boolean isSpecifyReportedValid(StatSpecifyReportedInfo paramStatSpecifyReportedInfo)
  {
    if (paramStatSpecifyReportedInfo == null) {
      return false;
    }
    return isStringValid(paramStatSpecifyReportedInfo.getAppKey());
  }
  
  public static boolean isStringValid(String paramString)
  {
    return (paramString != null) && (paramString.trim().length() != 0);
  }
  
  public static int isTheFirstTimeActivate(Context paramContext)
  {
    try
    {
      if (u != -1)
      {
        i1 = u;
        return i1;
      }
      checkFirstTimeActivate(paramContext);
      int i1 = u;
      return i1;
    }
    finally {}
  }
  
  public static boolean isWiFiActive(Context paramContext)
  {
    for (;;)
    {
      int i1;
      try
      {
        if (Util.checkPermission(paramContext, "android.permission.ACCESS_WIFI_STATE"))
        {
          paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
          if (paramContext == null) {
            break;
          }
          paramContext = paramContext.getAllNetworkInfo();
          if (paramContext == null) {
            break;
          }
          i1 = 0;
          if (i1 >= paramContext.length) {
            break;
          }
          if ((paramContext[i1].getTypeName().equalsIgnoreCase("WIFI")) && (paramContext[i1].isConnected())) {
            return true;
          }
        }
        else
        {
          k.warn("can not get the permission of android.permission.ACCESS_WIFI_STATE");
          return false;
        }
      }
      catch (Throwable paramContext)
      {
        k.e(paramContext);
        return false;
      }
      i1 += 1;
    }
    return false;
  }
  
  public static String md5sum(String paramString)
  {
    if (paramString == null) {
      return "0";
    }
    try
    {
      Object localObject = MessageDigest.getInstance("MD5");
      ((MessageDigest)localObject).update(paramString.getBytes());
      paramString = ((MessageDigest)localObject).digest();
      localObject = new StringBuffer();
      int i1 = 0;
      while (i1 < paramString.length)
      {
        int i2 = paramString[i1] & 0xFF;
        if (i2 < 16) {
          ((StringBuffer)localObject).append("0");
        }
        ((StringBuffer)localObject).append(Integer.toHexString(i2));
        i1 += 1;
      }
      paramString = ((StringBuffer)localObject).toString();
      return paramString;
    }
    catch (Throwable paramString) {}
    return "0";
  }
  
  public static boolean needCheckTime(Context paramContext)
  {
    if (v < 0L) {
      v = StatPreferences.getLong(paramContext, "mta.qq.com.checktime", 0L);
    }
    return Math.abs(System.currentTimeMillis() - v) > 86400000L;
  }
  
  public static int readDiffTimeFromServer(Context paramContext)
  {
    return StatPreferences.getInt(paramContext, "mta.qq.com.difftime", 0);
  }
  
  public static void updateCheckTime(Context paramContext)
  {
    v = System.currentTimeMillis();
    StatPreferences.putLong(paramContext, "mta.qq.com.checktime", v);
  }
  
  public static void writeDiffTimeFromServer(Context paramContext, int paramInt)
  {
    w = paramInt;
    StatPreferences.putInt(paramContext, "mta.qq.com.difftime", paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.acstat.common.StatCommonHelper
 * JD-Core Version:    0.7.0.1
 */