package com.tencent.mobileqq.armap;

import abjg;
import abjh;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ArNativeSoLoader;
import com.tencent.mobileqq.armap.config.ARMapConfig;
import com.tencent.mobileqq.armap.config.ARMapConfigManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.precover.PrecoverUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class ArMapUtil
{
  static SimpleDateFormat a;
  public static boolean a;
  static SimpleDateFormat b;
  private static SimpleDateFormat c;
  private static SimpleDateFormat d;
  
  public static double a(double paramDouble1, double paramDouble2)
  {
    double d1 = new BigDecimal(Double.toString(paramDouble1)).multiply(new BigDecimal(Double.toString(paramDouble2))).doubleValue();
    if (QLog.isColorLevel()) {
      QLog.d("ArMapUtil", 2, "mulDouble, d1 = " + paramDouble1 + ",d2 = " + paramDouble2 + ",result = " + d1);
    }
    return d1;
  }
  
  public static int a(double paramDouble1, double paramDouble2)
  {
    paramDouble2 = (180.0D + paramDouble2) / 360.0D;
    paramDouble1 = Math.sin(3.1415926D * paramDouble1 / 180.0D);
    paramDouble1 = (180.0D - Math.log((1.0D + paramDouble1) / (1.0D - paramDouble1)) * 180.0D / 6.2831852D) / 360.0D;
    int i = (int)(paramDouble2 * 268435456.0D + 0.5D);
    int j = (int)(paramDouble1 * 268435456.0D + 0.5D);
    return i / 131072 - 1445 + (j / 131072 - 701) * 341;
  }
  
  public static long a(long paramLong)
  {
    l1 = NetConnInfoCenter.getServerTimeMillis();
    l2 = 0L;
    if (c == null)
    {
      c = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
      c.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    try
    {
      l1 = c.parse(c.format(Long.valueOf(l1))).getTime();
      long l3 = a("00:00");
      l1 = l1 + paramLong - l3;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("ArMapUtil", 2, "dayTimeMs2CurMs error:" + localException.getMessage());
          l1 = l2;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArMapUtil", 2, "dayTimeMs2CurMs ,input = " + paramLong + ", result = " + l1);
    }
    return l1;
  }
  
  public static long a(String paramString)
  {
    long l1 = -9223372036854775808L;
    if (d == null)
    {
      d = new SimpleDateFormat("HH:mm", Locale.getDefault());
      d.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    try
    {
      long l2 = d.parse(paramString).getTime();
      l1 = l2;
    }
    catch (Exception localException)
    {
      label49:
      break label49;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArMapUtil", 2, "dayTime2Ms ,dateTime = " + paramString + ",millionSeconds = " + l1);
    }
    return l1;
  }
  
  public static SharedPreferences a(AppRuntime paramAppRuntime)
  {
    return paramAppRuntime.getApplication().getSharedPreferences(paramAppRuntime.getAccount() + "sp_ar_map", 4);
  }
  
  public static ArMapUtil.CurfewResInfo a(ARMapConfig paramARMapConfig)
  {
    ArMapUtil.CurfewResInfo localCurfewResInfo = new ArMapUtil.CurfewResInfo();
    if (paramARMapConfig == null) {}
    for (;;)
    {
      return localCurfewResInfo;
      if (QLog.isColorLevel()) {
        QLog.d("ArMapUtil", 2, "checkAndHandleCurfew curfewBeginTime:" + paramARMapConfig.curfewBeginTime + "  curfewEndTime:" + paramARMapConfig.curfewEndTime);
      }
      if (paramARMapConfig.curfewBeginTime == paramARMapConfig.curfewEndTime)
      {
        localCurfewResInfo.jdField_a_of_type_Boolean = false;
        return localCurfewResInfo;
      }
      long l = MessageCache.a();
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("H:mm", Locale.getDefault());
      localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
      l = d(localSimpleDateFormat.format(Long.valueOf(l * 1000L)));
      if (paramARMapConfig.curfewBeginTime > paramARMapConfig.curfewEndTime) {
        if ((l >= paramARMapConfig.curfewBeginTime) || (l < paramARMapConfig.curfewEndTime))
        {
          localCurfewResInfo.jdField_a_of_type_Boolean = true;
          localCurfewResInfo.jdField_a_of_type_Long = (paramARMapConfig.curfewEndTime - l);
        }
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ArMapUtil", 2, "checkAndHandleCurfew send check DelayTime:" + (localCurfewResInfo.jdField_a_of_type_Long + 100L) + " timeTxt: curTime:" + l);
        return localCurfewResInfo;
        localCurfewResInfo.jdField_a_of_type_Long = (paramARMapConfig.curfewBeginTime - l);
        continue;
        if ((l >= paramARMapConfig.curfewBeginTime) && (l < paramARMapConfig.curfewEndTime))
        {
          localCurfewResInfo.jdField_a_of_type_Boolean = true;
          localCurfewResInfo.jdField_a_of_type_Long = (paramARMapConfig.curfewEndTime - l);
        }
        else
        {
          localCurfewResInfo.jdField_a_of_type_Long = (paramARMapConfig.curfewBeginTime - l);
        }
      }
    }
  }
  
  public static String a(long paramLong, String paramString)
  {
    String str;
    if (paramLong <= 0L) {
      str = "";
    }
    for (;;)
    {
      return str;
      paramString = new SimpleDateFormat(paramString, Locale.getDefault());
      paramString.setTimeZone(TimeZone.getTimeZone("GMT+8"));
      str = null;
      try
      {
        paramString = paramString.format(Long.valueOf(paramLong));
        str = paramString;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ArMapUtil", 2, "millis2Date, milliseconds = " + paramLong + ",result = " + paramString);
        return paramString;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          paramString = str;
          if (QLog.isColorLevel())
          {
            QLog.d("ArMapUtil", 2, "millis2Date, milliseconds = " + paramLong + ",exception = " + localException.getMessage());
            paramString = str;
          }
        }
      }
    }
  }
  
  public static String a(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramString.indexOf("md5=") > 0) {
        localObject1 = paramString.substring(paramString.indexOf("md5=") + 4, paramString.indexOf("md5=") + 36);
      }
      return localObject1;
    }
    catch (Exception paramString)
    {
      do
      {
        localObject1 = localObject2;
      } while (!QLog.isColorLevel());
      QLog.e("ArMapUtil", 2, paramString, new Object[] { "getmd5FromUrl" });
    }
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArMapUtil", 2, new Object[] { "checkNeedReportConfigCover, succ=", Boolean.valueOf(paramBoolean), " ,result=" + paramInt });
    }
    Object localObject1 = new HashMap();
    ((HashMap)localObject1).put("param_FailCode", String.valueOf(paramInt));
    StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramQQAppInterface.getCurrentAccountUin(), "armap_config_success", paramBoolean, 0L, 0L, (HashMap)localObject1, "", false);
    Object localObject2 = (ARMapConfigManager)paramQQAppInterface.getManager(189);
    boolean bool1;
    HashMap localHashMap;
    int i;
    if (((ARMapConfigManager)localObject2).a(true) != null)
    {
      bool1 = true;
      boolean bool2 = PrecoverUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin() + "_armap_config_cover");
      if (QLog.isColorLevel()) {
        QLog.d("ArMapUtil", 2, "checkNeedReportConfigCover, _armap_config_cover, need=" + bool2);
      }
      if (bool2)
      {
        PrecoverUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin() + "_armap_config_cover");
        localHashMap = new HashMap();
        if (!bool1) {
          break label639;
        }
        i = ((ARMapConfigManager)localObject2).a();
        label241:
        localHashMap.put("config_version", String.valueOf(i));
        if (!paramBoolean) {
          break label644;
        }
        localObject1 = "1";
        label263:
        localHashMap.put("succ", localObject1);
        if (!bool1) {
          break label652;
        }
        localObject1 = "1";
        label284:
        localHashMap.put("hasConfig", localObject1);
        localHashMap.put("result", String.valueOf(paramInt));
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramQQAppInterface.getCurrentAccountUin(), "armap_config_cover", bool1, 0L, 0L, localHashMap, "", false);
      }
      if (bool1)
      {
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("config_version", String.valueOf(((ARMapConfigManager)localObject2).a()));
        ((HashMap)localObject1).put("uin", paramQQAppInterface.getCurrentAccountUin());
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramQQAppInterface.getCurrentAccountUin(), "armap_config_cover_no_24", true, 0L, 0L, (HashMap)localObject1, "", false);
      }
      paramBoolean = PrecoverUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin() + "_armap_so_cover");
      if (QLog.isColorLevel()) {
        QLog.d("ArMapUtil", 2, "checkNeedReportConfigCover, _armap_so_cover, need=" + paramBoolean);
      }
      if (paramBoolean) {
        PrecoverUtils.a(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin() + "_armap_so_cover");
      }
    }
    for (;;)
    {
      try
      {
        paramBoolean = ArNativeSoLoader.b("ArMapEngine7652");
        localObject1 = "";
        if (!paramBoolean) {
          break label688;
        }
        localObject1 = BaseApplicationImpl.sApplication.getSharedPreferences("mobileQQ", 0).getString("ar_native_ArMapEngine7652", "");
      }
      catch (Exception paramQQAppInterface)
      {
        label639:
        if (!QLog.isColorLevel()) {
          continue;
        }
        label644:
        label652:
        paramQQAppInterface.printStackTrace();
        return;
      }
      ReportController.b(paramQQAppInterface, "dc01440", "", "", "0X8007A3C", "0X8007A3C", 0, 0, (String)localObject2, "", (String)localObject1, "");
      localHashMap = new HashMap();
      if (paramBoolean)
      {
        localObject2 = "1";
        localHashMap.put("has_so", String.valueOf(localObject2));
        localHashMap.put("md5", localObject1);
        StatisticCollector.a(BaseApplicationImpl.getContext()).a(paramQQAppInterface.getCurrentAccountUin(), "armap_so_cover", paramBoolean, 0L, 0L, localHashMap, "", false);
        return;
        bool1 = false;
        break;
        i = -1;
        break label241;
        localObject1 = "0";
        break label263;
        localObject1 = "0";
        break label284;
        localObject2 = "0";
        continue;
      }
      localObject2 = "0";
      continue;
      label688:
      if (paramBoolean) {
        localObject2 = "1";
      }
    }
  }
  
  public static void a(String paramString)
  {
    if (jdField_a_of_type_Boolean) {
      ThreadManager.getUIHandler().post(new abjg(paramString));
    }
  }
  
  public static void a(String[] paramArrayOfString)
  {
    ThreadManager.postImmediately(new abjh(paramArrayOfString), null, false);
  }
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong1);
    int i = localCalendar.get(6);
    int j = localCalendar.get(1);
    localCalendar.setTimeInMillis(paramLong2);
    int k = localCalendar.get(6);
    int m = localCalendar.get(1);
    return (i == k) && (j == m);
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = (WifiManager)paramContext.getSystemService("wifi");
    return (paramContext != null) && (paramContext.isWifiEnabled());
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramContext.getPackageManager().getApplicationInfo(paramString, 8192);
        return true;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArMapUtil", 2, "isAppInstalled NameNotFoundException ", paramContext);
        }
        return false;
      }
      catch (Exception paramContext)
      {
        QLog.d("ArMapUtil", 1, "isAppInstalled Exception ", paramContext);
      }
    }
    return false;
  }
  
  public static long b(long paramLong)
  {
    int i = 1;
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(paramLong);
    int j = ((Calendar)localObject).get(1);
    int k = ((Calendar)localObject).get(6);
    int m = ((Calendar)localObject).get(11);
    if ((m >= 0) && (m < 7)) {
      i = 0;
    }
    try
    {
      for (;;)
      {
        localObject = new StringBuilder("");
        ((StringBuilder)localObject).append(j);
        if (k >= 100) {
          ((StringBuilder)localObject).append(k);
        }
        for (;;)
        {
          ((StringBuilder)localObject).append(i);
          return Long.valueOf(((StringBuilder)localObject).toString()).longValue();
          if (k >= 10) {
            ((StringBuilder)localObject).append("0").append(k);
          } else {
            ((StringBuilder)localObject).append("00").append(k);
          }
        }
        if ((m < 7) || (m >= 15)) {
          i = 2;
        }
      }
      return -1L;
    }
    catch (Exception localException) {}
  }
  
  public static long b(String paramString)
  {
    if (jdField_a_of_type_JavaTextSimpleDateFormat == null)
    {
      jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
      jdField_a_of_type_JavaTextSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    long l2 = -1L;
    try
    {
      l1 = jdField_a_of_type_JavaTextSimpleDateFormat.parse(paramString).getTime();
      if (QLog.isColorLevel()) {
        QLog.d("ArMapUtil", 2, "data2Millis, date = " + paramString + ",millis = " + l1);
      }
      return l1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("ArMapUtil", 2, "", localException);
          l1 = l2;
        }
      }
    }
  }
  
  public static SharedPreferences b(AppRuntime paramAppRuntime)
  {
    return paramAppRuntime.getApplication().getSharedPreferences("sp_ar_map", 4);
  }
  
  public static boolean b(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = (LocationManager)paramContext.getSystemService("location");
    try
    {
      bool = paramContext.isProviderEnabled("gps");
      return bool;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArMapUtil", 2, "isGPSOn no location permissions: " + paramContext.getMessage());
        }
        boolean bool = false;
      }
    }
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    boolean bool2 = false;
    paramContext = (ActivityManager)paramContext.getSystemService("activity");
    boolean bool1;
    if (Build.VERSION.SDK_INT < 21)
    {
      paramContext = paramContext.getRunningTasks(100);
      if (paramContext == null) {
        break label143;
      }
      paramContext = paramContext.iterator();
      while (paramContext.hasNext())
      {
        ActivityManager.RunningTaskInfo localRunningTaskInfo = (ActivityManager.RunningTaskInfo)paramContext.next();
        if ((localRunningTaskInfo.topActivity.getPackageName().equals(paramString)) || (localRunningTaskInfo.baseActivity.getPackageName().equals(paramString))) {
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      return bool1;
      paramContext = paramContext.getRunningAppProcesses();
      bool1 = bool2;
      if (paramContext != null)
      {
        paramContext = paramContext.iterator();
        do
        {
          bool1 = bool2;
          if (!paramContext.hasNext()) {
            break;
          }
        } while (!((ActivityManager.RunningAppProcessInfo)paramContext.next()).processName.startsWith(paramString));
        return true;
        label143:
        bool1 = false;
      }
    }
  }
  
  public static long c(String paramString)
  {
    if (b == null)
    {
      b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
      b.setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
    long l2 = -1L;
    try
    {
      l1 = b.parse(paramString).getTime();
      if (QLog.isColorLevel()) {
        QLog.d("ArMapUtil", 2, "data2Millis1, date = " + paramString + ",millis = " + l1);
      }
      return l1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        long l1 = l2;
        if (QLog.isColorLevel())
        {
          QLog.d("ArMapUtil", 2, "", localException);
          l1 = l2;
        }
      }
    }
  }
  
  public static boolean c(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = (LocationManager)paramContext.getSystemService("location");
    try
    {
      bool = paramContext.isProviderEnabled("network");
      return bool;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ArMapUtil", 2, "isNetworkOn no location permissions: " + paramContext.getMessage());
        }
        boolean bool = false;
      }
    }
  }
  
  public static long d(String paramString)
  {
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
      localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
      long l1 = localSimpleDateFormat.parse(paramString).getTime();
      long l2 = localSimpleDateFormat.parse("0:00").getTime();
      return l1 - l2;
    }
    catch (Exception paramString) {}
    return -9223372036854775808L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ArMapUtil
 * JD-Core Version:    0.7.0.1
 */