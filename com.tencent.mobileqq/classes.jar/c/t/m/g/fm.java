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
  private static fm a;
  private int b = -1;
  private int c = -1;
  private int d = 1;
  
  @SuppressLint({"NewApi"})
  public static int a(Context paramContext)
  {
    if (paramContext == null) {
      return -1;
    }
    boolean bool5 = b(paramContext);
    bool3 = false;
    try
    {
      localWifiManager = (WifiManager)paramContext.getSystemService("wifi");
      if (localWifiManager != null) {
        bool1 = localWifiManager.isWifiEnabled();
      }
    }
    catch (Exception|Error localException1)
    {
      WifiManager localWifiManager;
      boolean bool1;
      int i;
      label79:
      label82:
      break label79;
    }
    try
    {
      if (Build.VERSION.SDK_INT > 17)
      {
        bool2 = localWifiManager.isScanAlwaysAvailable();
        if (bool2)
        {
          i = 1;
          bool1 = true;
          break label84;
        }
      }
      i = 1;
    }
    catch (Exception|Error localException2)
    {
      break label82;
    }
    i = 0;
    bool1 = false;
    break label84;
    bool1 = false;
    i = 0;
    try
    {
      label84:
      paramContext = (LocationManager)paramContext.getSystemService("location");
      bool2 = bool3;
      if (paramContext != null)
      {
        bool2 = paramContext.isProviderEnabled("gps");
        paramContext = paramContext.getAllProviders();
        if (paramContext != null)
        {
          boolean bool4 = paramContext.contains("gps");
          bool3 = bool4;
        }
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        int k;
        int j;
        bool2 = bool3;
      }
    }
    bool3 = false;
    k = bool5 ^ true;
    j = k;
    if (!bool1) {
      j = k | 0x2;
    }
    k = j;
    if (!bool2) {
      k = j | 0x4;
    }
    j = k;
    if (i == 0) {
      j = k | 0x8;
    }
    i = j;
    if (!bool3) {
      i = j | 0x10;
    }
    return i;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.fm
 * JD-Core Version:    0.7.0.1
 */