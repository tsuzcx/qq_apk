package com.tencent.gamecenter.common.util;

import android.content.Context;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import com.tencent.mobileqq.qmethodmonitor.monitor.PhoneInfoMonitor;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(b);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(".GameCenterWebBuffer");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("Images/games");
    return localStringBuilder.toString();
  }
  
  public static String a(Context paramContext)
  {
    Object localObject2 = (TelephonyManager)paramContext.getSystemService("phone");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("");
    ((StringBuilder)localObject1).append(PhoneInfoMonitor.getDeviceId((TelephonyManager)localObject2));
    localObject1 = ((StringBuilder)localObject1).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(PhoneInfoMonitor.getSimSerialNumber((TelephonyManager)localObject2));
    localObject2 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(Settings.Secure.getString(paramContext.getContentResolver(), "android_id"));
    long l1 = localStringBuilder.toString().hashCode();
    long l2 = ((String)localObject1).hashCode();
    return new UUID(l1, ((String)localObject2).hashCode() | l2 << 32).toString();
  }
  
  public static String b()
  {
    try
    {
      InetAddress localInetAddress;
      do
      {
        localObject = NetworkMonitor.getNetworkInterfaces();
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
    catch (SocketException localSocketException)
    {
      label62:
      break label62;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.common.util.GCCommon
 * JD-Core Version:    0.7.0.1
 */