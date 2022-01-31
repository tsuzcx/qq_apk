package com.tencent.mobileqq.app;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
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
  
  private static void b(Context paramContext)
  {
    boolean bool1 = false;
    Object localObject1 = BluetoothAdapter.getDefaultAdapter();
    int i;
    if ((localObject1 != null) && (((BluetoothAdapter)localObject1).isEnabled())) {
      if (((BluetoothAdapter)localObject1).getScanMode() == 23)
      {
        i = 1;
        i += 2;
      }
    }
    for (;;)
    {
      int j;
      if (paramContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
        if (Build.VERSION.SDK_INT >= 21)
        {
          j = 1;
          label59:
          j += 2;
        }
      }
      for (;;)
      {
        localObject1 = (WifiManager)paramContext.getSystemService("wifi");
        Object localObject2;
        int k;
        if ((localObject1 != null) && (((WifiManager)localObject1).isWifiEnabled()))
        {
          localObject2 = ((WifiManager)localObject1).getConnectionInfo();
          if ((localObject2 != null) && (((WifiInfo)localObject2).getIpAddress() != 0))
          {
            k = 1;
            label109:
            k += 2;
          }
        }
        for (;;)
        {
          try
          {
            localObject2 = localObject1.getClass().getDeclaredMethod("isWifiApEnabled", new Class[0]);
            ((Method)localObject2).setAccessible(true);
            boolean bool2 = ((Boolean)((Method)localObject2).invoke(localObject1, new Object[0])).booleanValue();
            bool1 = bool2;
          }
          catch (Throwable localThrowable)
          {
            continue;
          }
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder(30);
            ((StringBuilder)localObject1).append("report:").append(i);
            ((StringBuilder)localObject1).append(", ").append(j);
            ((StringBuilder)localObject1).append(", ").append(k);
            ((StringBuilder)localObject1).append(", ").append(bool1);
            QLog.d("DeviceAbilityCollector", 2, ((StringBuilder)localObject1).toString());
          }
          localObject2 = new HashMap(10);
          ((HashMap)localObject2).put("btStatus", i + "");
          ((HashMap)localObject2).put("btAbility", j + "");
          ((HashMap)localObject2).put("wifiStatus", k + "");
          if (bool1)
          {
            localObject1 = "1";
            ((HashMap)localObject2).put("hsEnabled", localObject1);
            ((HashMap)localObject2).put("osVersion", Build.VERSION.SDK_INT + "");
            StatisticCollector.a(paramContext).a("", "actDeviceAbility", true, 0L, 0L, (HashMap)localObject2, "");
            return;
            i = 0;
            break;
            j = 0;
            break label59;
            k = 0;
            break label109;
          }
          localObject1 = "0";
          continue;
          k = 0;
        }
        j = 0;
      }
      i = 0;
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
        break label368;
      }
      localObject = FileUtils.a(paramContext);
      n = ((List)localObject).size();
      localObject = ((List)localObject).iterator();
      i = -1;
      while (((Iterator)localObject).hasNext())
      {
        if (!((FileUtils.StorageInfo)((Iterator)localObject).next()).a) {
          break label365;
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
      label365:
      break;
      label368:
      i = k;
      m = i1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.DeviceAbilityCollector
 * JD-Core Version:    0.7.0.1
 */