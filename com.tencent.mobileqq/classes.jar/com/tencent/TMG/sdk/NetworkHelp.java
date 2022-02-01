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
    NetworkHelp.APInfo localAPInfo2 = new NetworkHelp.APInfo();
    if (paramContext == null)
    {
      QLog.e("NetworkHelp", 0, "getAPInfo initial context is null");
      return localAPInfo2;
    }
    NetworkInfo localNetworkInfo = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    NetworkHelp.APInfo localAPInfo1 = localAPInfo2;
    if (localNetworkInfo != null)
    {
      localAPInfo1 = localAPInfo2;
      if (localNetworkInfo.isConnected())
      {
        int i = localNetworkInfo.getType();
        if (i != 0)
        {
          if (i != 1) {
            return localAPInfo2;
          }
          localAPInfo2.apType = NetworkHelp.APType.AP_WIFI.value();
          localAPInfo2.apName = "AP_WIFI";
          return localAPInfo2;
        }
        localAPInfo1 = getMobileAPInfo(paramContext, localNetworkInfo.getSubtype());
      }
    }
    return localAPInfo1;
  }
  
  private static NetworkHelp.APInfo getMobileAPInfo(Context paramContext, int paramInt)
  {
    NetworkHelp.MobileCarrier localMobileCarrier = NetworkHelp.MobileCarrier.UNKNOWN;
    try
    {
      localObject = ((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId();
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      localObject = null;
    }
    if (localObject == null)
    {
      QLog.e("NetworkHelp", 0, "getAPInfo IMSI is null");
      paramContext = localMobileCarrier;
    }
    else if ((!((String)localObject).startsWith("46000")) && (!((String)localObject).startsWith("46002")) && (!((String)localObject).startsWith("46007")))
    {
      if ((!((String)localObject).startsWith("46001")) && (!((String)localObject).startsWith("46006")))
      {
        if (!((String)localObject).startsWith("46003"))
        {
          paramContext = localMobileCarrier;
          if (!((String)localObject).startsWith("46005")) {}
        }
        else
        {
          paramContext = NetworkHelp.MobileCarrier.CHINA_TELECOM;
        }
      }
      else {
        paramContext = NetworkHelp.MobileCarrier.CHINA_UNICOM;
      }
    }
    else
    {
      paramContext = NetworkHelp.MobileCarrier.CHINA_MOBILE;
    }
    Object localObject = new NetworkHelp.APInfo();
    switch (paramInt)
    {
    default: 
      return localObject;
    case 13: 
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
      break;
    case 3: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
    case 10: 
    case 12: 
    case 14: 
    case 15: 
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
      }
      break;
    case 1: 
    case 2: 
    case 4: 
    case 7: 
    case 11: 
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
      if (NetworkHelp.MobileCarrier.CHINA_TELECOM == paramContext) {
        ((NetworkHelp.APInfo)localObject).apName = "AP_CTNET";
      }
      break;
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.sdk.NetworkHelp
 * JD-Core Version:    0.7.0.1
 */