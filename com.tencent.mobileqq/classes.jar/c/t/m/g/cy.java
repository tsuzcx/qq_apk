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
    catch (Throwable paramContext)
    {
      label15:
      break label15;
    }
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
        if ((str != null) && (!str.equals("000000000000")) && (!str.equals("00-00-00-00-00-00")))
        {
          if (str.equals("00:00:00:00:00:00")) {
            return "{}";
          }
          int i = ((WifiInfo)localObject).getRssi();
          if (i >= -100)
          {
            if (i > -20) {
              return "{}";
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
      }
      return "{}";
    }
    catch (Throwable localThrowable) {}
    return "{}";
  }
  
  public static boolean a(List<ScanResult> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() <= 1) {
        return true;
      }
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
    return true;
  }
  
  public static boolean a(List<ScanResult> paramList1, List<ScanResult> paramList2)
  {
    if (paramList1 == paramList2) {
      return true;
    }
    int i;
    if (paramList1 == null) {
      i = 0;
    } else {
      try
      {
        i = paramList1.size();
      }
      finally {}
    }
    for (int j = paramList2.size();; j = 0)
    {
      if (i != j) {
        return false;
      }
      if (i == 0) {
        return true;
      }
      try
      {
        HashMap localHashMap = a;
        localHashMap.clear();
        paramList1 = paramList1.iterator();
        while (paramList1.hasNext())
        {
          ScanResult localScanResult = (ScanResult)paramList1.next();
          localHashMap.put(localScanResult.BSSID, Integer.valueOf(localScanResult.level));
        }
        paramList1 = paramList2.iterator();
        while (paramList1.hasNext())
        {
          paramList2 = (ScanResult)paramList1.next();
          if (localHashMap.containsKey(paramList2.BSSID))
          {
            i = paramList2.level;
            j = ((Integer)localHashMap.get(paramList2.BSSID)).intValue();
            if (i == j) {
              break;
            }
          }
          else
          {
            return false;
          }
        }
      }
      catch (Throwable paramList1)
      {
        co.a("", paramList1);
        return true;
      }
      for (;;)
      {
        throw paramList1;
      }
      if (paramList2 != null) {
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.cy
 * JD-Core Version:    0.7.0.1
 */