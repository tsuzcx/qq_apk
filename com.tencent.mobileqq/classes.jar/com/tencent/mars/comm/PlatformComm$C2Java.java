package com.tencent.mars.comm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.PrintWriter;
import java.io.StringWriter;

public class PlatformComm$C2Java
{
  private static String exception2String(Exception paramException)
  {
    StringWriter localStringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  public static PlatformComm.APNInfo getAPNInfo()
  {
    try
    {
      Object localObject = ((ConnectivityManager)PlatformComm.access$000().getSystemService("connectivity")).getActiveNetworkInfo();
      PlatformComm.APNInfo localAPNInfo = new PlatformComm.APNInfo();
      if (localObject != null)
      {
        localAPNInfo.netType = ((NetworkInfo)localObject).getType();
        localAPNInfo.subNetType = ((NetworkInfo)localObject).getSubtype();
        if (1 != ((NetworkInfo)localObject).getType())
        {
          if (((NetworkInfo)localObject).getExtraInfo() == null) {
            localObject = "";
          } else {
            localObject = ((NetworkInfo)localObject).getExtraInfo();
          }
          localAPNInfo.extraInfo = ((String)localObject);
          return localAPNInfo;
        }
        localAPNInfo.extraInfo = getCurWifiInfo().ssid;
        return localAPNInfo;
      }
    }
    catch (Exception localException)
    {
      label88:
      break label88;
    }
    return null;
  }
  
  public static int getCurRadioAccessNetworkInfo()
  {
    return 0;
  }
  
  public static PlatformComm.SIMInfo getCurSIMInfo()
  {
    return null;
  }
  
  public static PlatformComm.WifiInfo getCurWifiInfo()
  {
    return null;
  }
  
  public static int getNetInfo()
  {
    try
    {
      localObject = (ConnectivityManager)PlatformComm.access$000().getSystemService("connectivity");
      if (localObject == null) {
        return -1;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          Object localObject;
          int i = ((NetworkInfo)localObject).getType();
          if (i != 0) {
            if (i != 1)
            {
              if ((i != 2) && (i != 3) && (i != 4) && (i != 5)) {
                return 3;
              }
            }
            else {
              return 1;
            }
          }
          return 2;
        }
        catch (Exception localException2) {}
        localException1 = localException1;
      }
    }
    localObject = null;
    if (localObject == null) {
      return -1;
    }
    return 3;
  }
  
  public static int getProxyInfo(StringBuffer paramStringBuffer)
  {
    return -1;
  }
  
  public static long getSignal(boolean paramBoolean)
  {
    return 0L;
  }
  
  public static int getStatisticsNetType()
  {
    return -1;
  }
  
  public static boolean isNetworkConnected()
  {
    return false;
  }
  
  public static void restartProcess() {}
  
  public static boolean startAlarm(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public static boolean startAlarm(int paramInt1, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  public static boolean stopAlarm(int paramInt)
  {
    return false;
  }
  
  public static WakerLock wakeupLock_new()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.comm.PlatformComm.C2Java
 * JD-Core Version:    0.7.0.1
 */