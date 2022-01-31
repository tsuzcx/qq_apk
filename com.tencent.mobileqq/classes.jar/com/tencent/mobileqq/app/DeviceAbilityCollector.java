package com.tencent.mobileqq.app;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.PowerManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.FileUtils.StorageInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DeviceAbilityCollector
{
  public static void a(Context paramContext)
  {
    SharedPreferences localSharedPreferences = paramContext.getSharedPreferences("sp_device_ability", 0);
    if (Math.abs(System.currentTimeMillis() - localSharedPreferences.getLong("device_ability_report_time", 0L)) < 86400000L) {}
    do
    {
      return;
      localSharedPreferences.edit().putLong("device_ability_report_time", System.currentTimeMillis()).commit();
      try
      {
        b(paramContext);
        c(paramContext);
        return;
      }
      catch (Throwable paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.d("TAG", 2, "", paramContext);
  }
  
  @SuppressLint({"WrongConstant"})
  private static void b(Context paramContext)
  {
    int j = 0;
    Object localObject1 = BluetoothAdapter.getDefaultAdapter();
    int i;
    if ((localObject1 != null) && (((BluetoothAdapter)localObject1).isEnabled())) {
      if (((BluetoothAdapter)localObject1).getScanMode() == 23) {
        i = 1;
      }
    }
    for (int k = i + 2;; k = 0)
    {
      if (paramContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
        if (Build.VERSION.SDK_INT >= 21) {
          i = 1;
        }
      }
      label58:
      for (int m = i + 2;; m = 0)
      {
        localObject1 = (WifiManager)paramContext.getSystemService("wifi");
        Object localObject2;
        if ((localObject1 != null) && (((WifiManager)localObject1).isWifiEnabled()))
        {
          localObject2 = ((WifiManager)localObject1).getConnectionInfo();
          if ((localObject2 != null) && (((WifiInfo)localObject2).getIpAddress() != 0)) {
            i = 1;
          }
        }
        label109:
        for (int n = i + 2;; n = 0) {
          try
          {
            localObject2 = localObject1.getClass().getDeclaredMethod("isWifiApEnabled", new Class[0]);
            ((Method)localObject2).setAccessible(true);
            bool1 = ((Boolean)((Method)localObject2).invoke(localObject1, new Object[0])).booleanValue();
          }
          catch (Throwable localThrowable2)
          {
            try
            {
              if (Build.VERSION.SDK_INT >= 23)
              {
                boolean bool2 = ((PowerManager)BaseApplicationImpl.getApplication().getSystemService("power")).isIgnoringBatteryOptimizations("com.tencent.mobileqq");
                i = j;
                if (bool2) {
                  i = 1;
                }
              }
            }
            catch (Throwable localThrowable2)
            {
              for (;;)
              {
                try
                {
                  boolean bool1;
                  if (Build.VERSION.SDK_INT >= 24)
                  {
                    j = ((ConnectivityManager)BaseApplicationImpl.getApplication().getSystemService("connectivity")).getRestrictBackgroundStatus();
                    if (QLog.isColorLevel())
                    {
                      localObject1 = new StringBuilder(30);
                      ((StringBuilder)localObject1).append("report:").append(k);
                      ((StringBuilder)localObject1).append(", ").append(m);
                      ((StringBuilder)localObject1).append(", ").append(n);
                      ((StringBuilder)localObject1).append(", ").append(bool1);
                      ((StringBuilder)localObject1).append(", ").append(i);
                      ((StringBuilder)localObject1).append(", ").append(Build.MODEL);
                      ((StringBuilder)localObject1).append(", ").append(Build.MANUFACTURER);
                      ((StringBuilder)localObject1).append(", ").append(j);
                      QLog.d("DeviceAbilityCollector", 2, ((StringBuilder)localObject1).toString());
                    }
                    localObject2 = new HashMap(10);
                    ((HashMap)localObject2).put("btStatus", k + "");
                    ((HashMap)localObject2).put("btAbility", m + "");
                    ((HashMap)localObject2).put("wifiStatus", n + "");
                    if (bool1)
                    {
                      localObject1 = "1";
                      ((HashMap)localObject2).put("hsEnabled", localObject1);
                      ((HashMap)localObject2).put("osVersion", Build.VERSION.SDK_INT + "");
                      ((HashMap)localObject2).put("ignoreBat", String.valueOf(i));
                      ((HashMap)localObject2).put("model", Build.MODEL);
                      ((HashMap)localObject2).put("manufacture", Build.MANUFACTURER);
                      ((HashMap)localObject2).put("restrictBgStatus", String.valueOf(j));
                      StatisticCollector.a(paramContext).a("", "actDeviceAbility", true, 0L, 0L, (HashMap)localObject2, "");
                      return;
                      i = 0;
                      break;
                      i = 0;
                      break label58;
                      i = 0;
                      break label109;
                      localThrowable1 = localThrowable1;
                      bool1 = false;
                      continue;
                      localThrowable2 = localThrowable2;
                      i = -1;
                      j = -1;
                      continue;
                    }
                    String str = "0";
                    continue;
                  }
                }
                catch (Throwable localThrowable3)
                {
                  continue;
                  j = -1;
                  continue;
                }
                i = -1;
              }
            }
          }
        }
      }
    }
  }
  
  private static void c(Context paramContext)
  {
    int i2 = (int)(FileUtils.b() / 1024.0F / 1024.0F);
    int j = (int)(FileUtils.a() / 1024.0F / 1024.0F);
    int i = -1000;
    int n = -1;
    int i1 = -1;
    int m = i1;
    int k = n;
    Object localObject;
    if (FileUtils.a())
    {
      k = (int)(FileUtils.b() / 1024.0F / 1024.0F);
      j = (int)(FileUtils.a() / 1024.0F / 1024.0F);
      if (Build.VERSION.SDK_INT < 9) {
        break label376;
      }
      localObject = FileUtils.a(paramContext);
      n = ((List)localObject).size();
      localObject = ((List)localObject).iterator();
      i = -1;
      while (((Iterator)localObject).hasNext())
      {
        if (!((FileUtils.StorageInfo)((Iterator)localObject).next()).a) {
          break label373;
        }
        i += 1;
      }
      m = i;
      i = k;
    }
    for (k = n;; k = n)
    {
      n = ProcessStats.a();
      i1 = (int)(DeviceInfoUtil.b() / 1024L);
      int i3 = (int)(DeviceInfoUtil.e() / 1024L / 1024L);
      localObject = new HashMap(16);
      ((HashMap)localObject).put("totalRom", String.valueOf(i2));
      ((HashMap)localObject).put("avaiRom", String.valueOf(j));
      ((HashMap)localObject).put("totalSD", String.valueOf(i));
      ((HashMap)localObject).put("avaiSD", String.valueOf(-1000));
      ((HashMap)localObject).put("extCount", String.valueOf(k));
      ((HashMap)localObject).put("remoableExtCount", String.valueOf(m));
      ((HashMap)localObject).put("osVersion", String.valueOf(Build.VERSION.SDK_INT));
      ((HashMap)localObject).put("cpuCoreNum", String.valueOf(n));
      ((HashMap)localObject).put("maxFrequency", String.valueOf(i1));
      ((HashMap)localObject).put("cpu_abi", Build.CPU_ABI);
      ((HashMap)localObject).put("cpu_abi2", Build.CPU_ABI2);
      ((HashMap)localObject).put("ramSize", String.valueOf(i3));
      StatisticCollector.a(paramContext).a("", "actStorageStats", true, 0L, 0L, (HashMap)localObject, "");
      return;
      label373:
      break;
      label376:
      i = k;
      m = i1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.DeviceAbilityCollector
 * JD-Core Version:    0.7.0.1
 */