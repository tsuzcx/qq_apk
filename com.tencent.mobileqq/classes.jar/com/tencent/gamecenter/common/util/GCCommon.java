package com.tencent.gamecenter.common.util;

import android.content.Context;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.tencent.open.appcommon.Common;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.UUID;

public class GCCommon
  extends Common
{
  private static final String b = ;
  
  public static String a()
  {
    return b + File.separator + ".GameCenterWebBuffer" + File.separator + "Images/games";
  }
  
  public static String a(Context paramContext)
  {
    Object localObject = (TelephonyManager)paramContext.getSystemService("phone");
    String str = "" + ((TelephonyManager)localObject).getDeviceId();
    localObject = "" + ((TelephonyManager)localObject).getSimSerialNumber();
    long l1 = ("" + Settings.Secure.getString(paramContext.getContentResolver(), "android_id")).hashCode();
    long l2 = str.hashCode();
    return new UUID(l1, ((String)localObject).hashCode() | l2 << 32).toString();
  }
  
  public static String b()
  {
    try
    {
      InetAddress localInetAddress;
      do
      {
        localObject = NetworkInterface.getNetworkInterfaces();
        Enumeration localEnumeration;
        while (!localEnumeration.hasMoreElements())
        {
          if (!((Enumeration)localObject).hasMoreElements()) {
            break;
          }
          localEnumeration = ((NetworkInterface)((Enumeration)localObject).nextElement()).getInetAddresses();
        }
        localInetAddress = (InetAddress)localEnumeration.nextElement();
      } while (localInetAddress.isLoopbackAddress());
      Object localObject = localInetAddress.getHostAddress().toString();
      return localObject;
    }
    catch (SocketException localSocketException) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.GCCommon
 * JD-Core Version:    0.7.0.1
 */