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
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.startup.step.HackVm;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class anki
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
    int m = 0;
    Object localObject1 = BluetoothAdapter.getDefaultAdapter();
    int i;
    int k;
    label37:
    label59:
    Object localObject2;
    int n;
    if ((localObject1 != null) && (((BluetoothAdapter)localObject1).isEnabled())) {
      if (((BluetoothAdapter)localObject1).getScanMode() == 23)
      {
        i = 1;
        k = i + 2;
        if (paramContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le"))
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label735;
          }
          i = 1;
          m = i + 2;
        }
        localObject1 = (WifiManager)paramContext.getSystemService("wifi");
        if ((localObject1 == null) || (!((WifiManager)localObject1).isWifiEnabled())) {
          break label787;
        }
        localObject2 = ((WifiManager)localObject1).getConnectionInfo();
        if ((localObject2 == null) || (((WifiInfo)localObject2).getIpAddress() == 0)) {
          break label740;
        }
        i = 1;
        n = i + 2;
      }
    }
    label774:
    label782:
    label787:
    label798:
    for (;;)
    {
      int j;
      try
      {
        localObject2 = localObject1.getClass().getDeclaredMethod("isWifiApEnabled", new Class[0]);
        ((Method)localObject2).setAccessible(true);
        bool = ((Boolean)((Method)localObject2).invoke(localObject1, new Object[0])).booleanValue();
        int i1 = -1;
        i = i1;
        j = i1;
        try
        {
          if (Build.VERSION.SDK_INT >= 23)
          {
            j = i1;
            if (!((PowerManager)BaseApplicationImpl.getApplication().getSystemService("power")).isIgnoringBatteryOptimizations("com.tencent.mobileqq")) {
              continue;
            }
            i = 1;
            break label798;
          }
          j = i;
          if (Build.VERSION.SDK_INT < 24) {
            break label782;
          }
          j = i;
          i1 = ((ConnectivityManager)BaseApplicationImpl.getApplication().getSystemService("connectivity")).getRestrictBackgroundStatus();
          j = i1;
        }
        catch (Throwable localThrowable2)
        {
          int i2;
          HashMap localHashMap;
          i = j;
          j = -1;
          continue;
          String str = "";
          continue;
          localObject2 = "0";
          continue;
          j = -1;
          continue;
        }
        i1 = QQToast.a();
        localObject1 = System.getProperty("java.vm.version");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = ((String)localObject1).substring(0, 1);
          i2 = MsfSdkUtils.getAutoStartMode(BaseApplicationImpl.getApplication());
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder(30);
            ((StringBuilder)localObject2).append("report:").append(k);
            ((StringBuilder)localObject2).append(", ").append(m);
            ((StringBuilder)localObject2).append(", ").append(n);
            ((StringBuilder)localObject2).append(", ").append(bool);
            ((StringBuilder)localObject2).append(", ").append(i);
            ((StringBuilder)localObject2).append(", ").append(Build.MODEL);
            ((StringBuilder)localObject2).append(", ").append(Build.MANUFACTURER);
            ((StringBuilder)localObject2).append(", ").append(j);
            ((StringBuilder)localObject2).append(", notify = ").append(i1);
            ((StringBuilder)localObject2).append(", autoMode = ").append(i2);
            QLog.d("DeviceAbilityCollector", 2, ((StringBuilder)localObject2).toString());
          }
          localHashMap = new HashMap(15);
          localHashMap.put("btStatus", k + "");
          localHashMap.put("btAbility", m + "");
          localHashMap.put("wifiStatus", n + "");
          if (!bool) {
            break label774;
          }
          localObject2 = "1";
          localHashMap.put("hsEnabled", localObject2);
          localHashMap.put("osVersion", Build.VERSION.SDK_INT + "");
          localHashMap.put("ignoreBat", String.valueOf(i));
          localHashMap.put("model", Build.MODEL);
          localHashMap.put("manufacture", Build.MANUFACTURER);
          localHashMap.put("restrictBgStatus", String.valueOf(j));
          localHashMap.put("notifyStatus", String.valueOf(i1));
          localHashMap.put("maxMemory", String.valueOf(Runtime.getRuntime().maxMemory() / 1024L / 1024L));
          localHashMap.put("orgMaxMemory", String.valueOf(HackVm.a / 1024L / 1024L));
          localHashMap.put("vm", localObject1);
          localHashMap.put("autoMode", String.valueOf(i2));
          bctj.a(paramContext).a("", "actDeviceAbility", true, 0L, 0L, localHashMap, "");
          return;
          i = 0;
          break;
          label735:
          i = 0;
          break label59;
          label740:
          i = 0;
        }
      }
      catch (Throwable localThrowable1)
      {
        boolean bool = false;
        continue;
        i = 0;
        break label798;
      }
      n = 0;
      continue;
      k = 0;
      break label37;
    }
  }
  
  private static void c(Context paramContext)
  {
    int i2 = (int)(bgmg.b() / 1024.0F / 1024.0F);
    int j = (int)(bgmg.a() / 1024.0F / 1024.0F);
    int i = -1000;
    int n = -1;
    int i1 = -1;
    int m = i1;
    int k = n;
    Object localObject;
    if (bgmg.a())
    {
      k = (int)(bgmg.b() / 1024.0F / 1024.0F);
      j = (int)(bgmg.a() / 1024.0F / 1024.0F);
      if (Build.VERSION.SDK_INT < 9) {
        break label377;
      }
      localObject = bgmg.a(paramContext);
      n = ((List)localObject).size();
      localObject = ((List)localObject).iterator();
      i = -1;
      while (((Iterator)localObject).hasNext())
      {
        if (!((bgmh)((Iterator)localObject).next()).a) {
          break label374;
        }
        i += 1;
      }
      m = i;
      i = k;
    }
    for (k = n;; k = n)
    {
      n = anro.a();
      i1 = (int)(bgln.b() / 1024L);
      int i3 = (int)(bgln.d() / 1024L / 1024L);
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
      bctj.a(paramContext).a("", "actStorageStats", true, 0L, 0L, (HashMap)localObject, "");
      return;
      label374:
      break;
      label377:
      i = k;
      m = i1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anki
 * JD-Core Version:    0.7.0.1
 */