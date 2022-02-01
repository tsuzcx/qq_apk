package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class cy
{
  private static HashMap a = new HashMap();
  
  public static int a(Context paramContext)
  {
    try
    {
      int i = a((WifiManager)paramContext.getSystemService("wifi"));
      return i;
    }
    catch (Throwable paramContext) {}
    return 4;
  }
  
  @SuppressLint({"MissingPermission"})
  private static int a(WifiManager paramWifiManager)
  {
    if (paramWifiManager == null) {
      return 4;
    }
    try
    {
      int i = paramWifiManager.getWifiState();
      return i;
    }
    catch (Throwable paramWifiManager) {}
    return 4;
  }
  
  @SuppressLint({"MissingPermission"})
  public static String a()
  {
    try
    {
      Object localObject = co.a(dp.a());
      if (localObject != null)
      {
        String str = ((WifiInfo)localObject).getBSSID();
        if ((str != null) && (!str.equals("000000000000")) && (!str.equals("00-00-00-00-00-00")) && (!str.equals("00:00:00:00:00:00")))
        {
          int i = ((WifiInfo)localObject).getRssi();
          if ((i < -100) || (i > -20)) {
            break label167;
          }
          localObject = ((WifiInfo)localObject).getSSID().replace("\"", "").replace("|", "");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("{");
          localStringBuilder.append("\"mac\":\"");
          localStringBuilder.append(str);
          localStringBuilder.append("\",\"rssi\":");
          localStringBuilder.append(i);
          localStringBuilder.append(",\"ssid\":\"");
          localStringBuilder.append((String)localObject);
          localStringBuilder.append("\"}");
          str = localStringBuilder.toString();
          return str;
        }
      }
      else
      {
        return "{}";
      }
    }
    catch (Throwable localThrowable)
    {
      return "{}";
    }
    return "{}";
    label167:
    return "{}";
  }
  
  public static boolean a(List<ScanResult> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 1)) {}
    for (;;)
    {
      return true;
      String str = ((ScanResult)paramList.get(0)).BSSID;
      int i = 1;
      while (i < paramList.size())
      {
        if (!str.equals(((ScanResult)paramList.get(i)).BSSID)) {
          return false;
        }
        i += 1;
      }
    }
  }
  
  public static boolean a(List<ScanResult> paramList1, List<ScanResult> paramList2)
  {
    boolean bool;
    if (paramList1 == paramList2) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      int i;
      if (paramList1 == null)
      {
        i = 0;
        label23:
        if (paramList2 != null) {
          break label50;
        }
      }
      for (int j = 0;; j = paramList2.size()) {
        for (;;)
        {
          if (i == j) {
            break label60;
          }
          bool = false;
          break;
          label50:
          try
          {
            i = paramList1.size();
            break label23;
          }
          finally {}
        }
      }
      label60:
      if (i == 0)
      {
        bool = true;
      }
      else
      {
        label87:
        do
        {
          HashMap localHashMap;
          while (!paramList1.hasNext())
          {
            try
            {
              localHashMap = a;
              localHashMap.clear();
              paramList1 = paramList1.iterator();
              if (paramList1.hasNext())
              {
                ScanResult localScanResult = (ScanResult)paramList1.next();
                localHashMap.put(localScanResult.BSSID, Integer.valueOf(localScanResult.level));
                break label87;
              }
            }
            catch (Throwable paramList1)
            {
              co.a("", paramList1);
              bool = true;
            }
            paramList1 = paramList2.iterator();
          }
          paramList2 = (ScanResult)paramList1.next();
          if (!localHashMap.containsKey(paramList2.BSSID)) {
            break label206;
          }
          i = paramList2.level;
          j = ((Integer)localHashMap.get(paramList2.BSSID)).intValue();
        } while (i == j);
        label206:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     c.t.m.g.cy
 * JD-Core Version:    0.7.0.1
 */