package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import java.util.List;

public final class fm
{
  private static fm a = null;
  private int b = -1;
  private int c = -1;
  private int d = 1;
  
  @SuppressLint({"NewApi"})
  public static int a(Context paramContext)
  {
    if (paramContext == null)
    {
      i = -1;
      return i;
    }
    boolean bool3 = b(paramContext);
    for (;;)
    {
      try
      {
        localWifiManager = (WifiManager)paramContext.getSystemService("wifi");
        if (localWifiManager == null) {
          continue;
        }
        bool1 = localWifiManager.isWifiEnabled();
        if (!bool1) {
          continue;
        }
        i = 1;
      }
      catch (Exception localException2)
      {
        WifiManager localWifiManager;
        boolean bool1;
        boolean bool2;
        int m;
        i = 0;
        k = 0;
        j = i;
        i = k;
        continue;
      }
      catch (Error localError2)
      {
        i = 0;
        int k = 0;
        int j = i;
        i = k;
        continue;
      }
      try
      {
        if (Build.VERSION.SDK_INT <= 17) {
          continue;
        }
        bool1 = localWifiManager.isScanAlwaysAvailable();
        if (!bool1) {
          continue;
        }
        i = 1;
        j = 1;
        try
        {
          paramContext = (LocationManager)paramContext.getSystemService("location");
          if (paramContext != null)
          {
            bool2 = paramContext.isProviderEnabled("gps");
            paramContext = paramContext.getAllProviders();
            if (paramContext == null) {
              bool1 = false;
            } else {
              bool1 = paramContext.contains("gps");
            }
          }
          else
          {
            bool1 = false;
            bool2 = false;
          }
        }
        catch (Exception paramContext)
        {
          bool1 = false;
          bool2 = false;
        }
        m = 0;
      }
      catch (Error localError1) {}catch (Exception localException1)
      {
        continue;
      }
      continue;
      j = 1;
      continue;
      i = 0;
      continue;
      if (!bool3)
      {
        m = 1;
        k = m;
        if (j == 0) {
          k = m | 0x2;
        }
        j = k;
        if (!bool2) {
          j = k | 0x4;
        }
        k = j;
        if (i == 0) {
          k = j | 0x8;
        }
        i = k;
        if (bool1) {
          break;
        }
        return k | 0x10;
        j = 0;
        i = 0;
        k = i;
        i = j;
        j = k;
      }
    }
  }
  
  public static fm a()
  {
    if (a == null) {
      a = new fm();
    }
    return a;
  }
  
  private static boolean b(Context paramContext)
  {
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        return false;
      }
      int i = paramContext.getSimState();
      return i == 5;
    }
    catch (Exception paramContext) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     c.t.m.g.fm
 * JD-Core Version:    0.7.0.1
 */