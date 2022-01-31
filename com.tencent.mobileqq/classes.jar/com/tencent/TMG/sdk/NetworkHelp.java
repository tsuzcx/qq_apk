package com.tencent.TMG.sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import com.tencent.TMG.utils.QLog;

public class NetworkHelp
{
  public static final String TAG = "NetworkHelp";
  
  protected static NetworkHelp.APInfo getAPInfo(Context paramContext)
  {
    NetworkHelp.APInfo localAPInfo = new NetworkHelp.APInfo();
    if (paramContext == null)
    {
      QLog.e("NetworkHelp", 0, "getAPInfo initial context is null");
      return localAPInfo;
    }
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localNetworkInfo != null) && (localNetworkInfo.isConnected())) {}
    switch (localNetworkInfo.getType())
    {
    default: 
      paramContext = localAPInfo;
    }
    for (;;)
    {
      return paramContext;
      localAPInfo.apType = NetworkHelp.APType.AP_WIFI.value();
      localAPInfo.apName = "AP_WIFI";
      paramContext = localAPInfo;
      continue;
      paramContext = getMobileAPInfo(paramContext, localNetworkInfo.getSubtype());
    }
  }
  
  private static NetworkHelp.APInfo getMobileAPInfo(Context paramContext, int paramInt)
  {
    Object localObject = NetworkHelp.MobileCarrier.UNKNOWN;
    try
    {
      paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
      if (paramContext == null)
      {
        QLog.e("NetworkHelp", 0, "getAPInfo IMSI is null");
        paramContext = (Context)localObject;
        localObject = new NetworkHelp.APInfo();
        switch (paramInt)
        {
        default: 
          return localObject;
        }
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        paramContext = null;
        continue;
        if ((paramContext.startsWith("46000")) || (paramContext.startsWith("46002")) || (paramContext.startsWith("46007")))
        {
          paramContext = NetworkHelp.MobileCarrier.CHINA_MOBILE;
        }
        else if ((paramContext.startsWith("46001")) || (paramContext.startsWith("46006")))
        {
          paramContext = NetworkHelp.MobileCarrier.CHINA_UNICOM;
        }
        else if ((paramContext.startsWith("46003")) || (paramContext.startsWith("46005")))
        {
          paramContext = NetworkHelp.MobileCarrier.CHINA_TELECOM;
          continue;
          ((NetworkHelp.APInfo)localObject).apType = NetworkHelp.APType.AP_2G.value();
          if (NetworkHelp.MobileCarrier.CHINA_MOBILE == paramContext)
          {
            ((NetworkHelp.APInfo)localObject).apName = "AP_CMNET";
            return localObject;
          }
          if (NetworkHelp.MobileCarrier.CHINA_UNICOM == paramContext)
          {
            ((NetworkHelp.APInfo)localObject).apName = "AP_UNINET";
            return localObject;
          }
          if (NetworkHelp.MobileCarrier.CHINA_TELECOM == paramContext)
          {
            ((NetworkHelp.APInfo)localObject).apName = "AP_CTNET";
            return localObject;
            ((NetworkHelp.APInfo)localObject).apType = NetworkHelp.APType.AP_3G.value();
            if (NetworkHelp.MobileCarrier.CHINA_MOBILE == paramContext)
            {
              ((NetworkHelp.APInfo)localObject).apName = "AP_CM3G";
              return localObject;
            }
            if (NetworkHelp.MobileCarrier.CHINA_UNICOM == paramContext)
            {
              ((NetworkHelp.APInfo)localObject).apName = "AP_3GNET";
              return localObject;
            }
            if (NetworkHelp.MobileCarrier.CHINA_TELECOM == paramContext)
            {
              ((NetworkHelp.APInfo)localObject).apName = "AP_CTNET";
              return localObject;
              ((NetworkHelp.APInfo)localObject).apType = NetworkHelp.APType.AP_4G.value();
              if (NetworkHelp.MobileCarrier.CHINA_MOBILE == paramContext)
              {
                ((NetworkHelp.APInfo)localObject).apName = "AP_CMLTE";
                return localObject;
              }
              if (NetworkHelp.MobileCarrier.CHINA_UNICOM == paramContext)
              {
                ((NetworkHelp.APInfo)localObject).apName = "AP_UNLTE";
                return localObject;
              }
              if (NetworkHelp.MobileCarrier.CHINA_TELECOM == paramContext)
              {
                ((NetworkHelp.APInfo)localObject).apName = "AP_CTLTE";
                return localObject;
              }
            }
          }
        }
        else
        {
          paramContext = (Context)localObject;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.sdk.NetworkHelp
 * JD-Core Version:    0.7.0.1
 */