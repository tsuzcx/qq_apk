package com.tencent.ad.tangram.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.system.a;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.e;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.List;

@Keep
public final class AdNet
{
  public static final int IP_FAMILY_UNKNOWN = 0;
  public static final int IP_FAMILY_V4 = 1;
  public static final int IP_FAMILY_V6 = 2;
  private static final String TAG = "AdNet";
  private static String ipV4Address;
  private static long ipV4AddressTimeStamp = -2147483648L;
  private static String userAgent;
  
  public static String getBSSID(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (!e.checkPermission(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
        return null;
      }
      if (Build.VERSION.SDK_INT > 26) {
        if ((Build.VERSION.SDK_INT != 27) && (Build.VERSION.SDK_INT != 28))
        {
          if (!e.checkPermission(paramContext, "android.permission.ACCESS_FINE_LOCATION")) {
            return null;
          }
        }
        else if ((!e.checkPermission(paramContext, "android.permission.ACCESS_COARSE_LOCATION")) && (!e.checkPermission(paramContext, "android.permission.ACCESS_FINE_LOCATION"))) {
          return null;
        }
      }
    }
    if (paramContext == null) {
      return null;
    }
    paramContext = paramContext.getApplicationContext();
    if (paramContext == null) {
      return null;
    }
    paramContext = paramContext.getSystemService("wifi");
    if (!(paramContext instanceof WifiManager)) {
      return null;
    }
    paramContext = (WifiManager)WifiManager.class.cast(paramContext);
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = NetworkMonitor.getConnectionInfo(paramContext);
      if (paramContext == null) {
        return null;
      }
      paramContext = paramContext.getBSSID();
    }
    catch (Throwable paramContext)
    {
      AdLog.e("AdNet", "getBSSID", paramContext);
      paramContext = null;
    }
    if (!isValidBSSID(paramContext))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getBSSID] not valid bssid ");
      localStringBuilder.append(paramContext);
      AdLog.i("AdNet", localStringBuilder.toString());
      return null;
    }
    return paramContext;
  }
  
  private static int getDataTypeOnAndroidQ(int paramInt)
  {
    Object localObject1 = new Integer(1);
    Object localObject5 = new Integer(2);
    Object localObject6 = new Integer(3);
    Integer localInteger2 = new Integer(4);
    Object localObject2 = localObject5;
    Object localObject3 = localObject6;
    Integer localInteger1;
    try
    {
      Object localObject4 = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_2_G").get(TelephonyManager.class);
      localObject1 = localObject4;
      localObject2 = localObject5;
      localObject3 = localObject6;
      localObject5 = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_3_G").get(TelephonyManager.class);
      localObject1 = localObject4;
      localObject2 = localObject5;
      localObject3 = localObject6;
      localObject6 = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_4_G").get(TelephonyManager.class);
      localObject1 = localObject4;
      localObject2 = localObject5;
      localObject3 = localObject6;
      Object localObject7 = TelephonyManager.class.getDeclaredField("NETWORK_CLASS_5_G").get(TelephonyManager.class);
      localObject1 = localObject4;
      localObject2 = localObject5;
      localObject3 = localObject6;
      localObject4 = localObject7;
    }
    catch (Throwable localThrowable2)
    {
      AdLog.i("AdNet", "getDataTypeOnAndroidQ", localThrowable2);
      localInteger1 = localInteger2;
    }
    try
    {
      localObject5 = TelephonyManager.class.getDeclaredMethod("getNetworkClass", new Class[] { Integer.TYPE }).invoke(TelephonyManager.class, new Object[] { Integer.valueOf(paramInt) });
      if (localObject5.equals(localObject1)) {
        return 2;
      }
      if (localObject5.equals(localObject2)) {
        return 3;
      }
      if (localObject5.equals(localObject3)) {
        return 4;
      }
      boolean bool = localObject5.equals(localInteger1);
      if (bool) {
        return 7;
      }
      return 0;
    }
    catch (Throwable localThrowable1)
    {
      AdLog.i("AdNet", "getDataTypeOnAndroidQ", localThrowable1);
    }
    return 0;
  }
  
  private static int getDataTypeOnAndroidR(int paramInt)
  {
    long l = a.getBitMaskForNetworkType(paramInt);
    if ((0x804B & l) != 0L) {
      return 2;
    }
    if ((0x16BB4 & l) != 0L) {
      return 3;
    }
    if ((0x61000 & l) != 0L) {
      return 4;
    }
    if ((l & 0x80000) != 0L) {
      return 7;
    }
    return 0;
  }
  
  public static int getIpFamily(Context paramContext)
  {
    int i = getIpFamilyImpl(paramContext);
    AdLog.i("AdNet", String.format("getIpFamily %d", new Object[] { Integer.valueOf(i) }));
    return i;
  }
  
  private static int getIpFamilyImpl(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    paramContext = paramContext.getApplicationContext();
    if (paramContext == null) {
      return 0;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return 0;
      }
      if (Build.VERSION.SDK_INT < 23) {
        return 0;
      }
      paramContext = paramContext.getLinkProperties(paramContext.getActiveNetwork());
      if (paramContext == null) {
        return 0;
      }
      paramContext = paramContext.getLinkAddresses().iterator();
      int i = 0;
      while (paramContext.hasNext())
      {
        LinkAddress localLinkAddress = (LinkAddress)paramContext.next();
        if (localLinkAddress != null)
        {
          int j = getNetIpFamily(localLinkAddress.getAddress());
          i |= j;
        }
      }
      return i;
    }
    catch (Throwable paramContext)
    {
      AdLog.i("AdNet", "getIpFamily", paramContext);
    }
    return 0;
  }
  
  private static String getIpV4Address()
  {
    Object localObject = new AdHttp.Params();
    ((AdHttp.Params)localObject).setUrl("https://ipv4.gdt.qq.com/get_client_ip");
    ((AdHttp.Params)localObject).method = "GET";
    AdHttp.send((AdHttp.Params)localObject);
    AdLog.i("AdNet", String.format("getIpV4Address responseCode:%d", new Object[] { Integer.valueOf(((AdHttp.Params)localObject).responseCode) }));
    if (((AdHttp.Params)localObject).canSend())
    {
      if (((AdHttp.Params)localObject).responseCode != 200) {
        return null;
      }
      try
      {
        localObject = new String(((AdHttp.Params)localObject).responseData, "UTF-8");
        return localObject;
      }
      catch (Throwable localThrowable)
      {
        AdLog.e("AdNet", "getIpV4Address", localThrowable);
      }
    }
    return null;
  }
  
  public static String getIpV4AddressCache()
  {
    AdLog.i("AdNet", String.format("getIpV4AddressCache address:%s timeStamp:%d", new Object[] { ipV4Address, Long.valueOf(ipV4AddressTimeStamp) }));
    return ipV4Address;
  }
  
  private static int getNetIpFamily(InetAddress paramInetAddress)
  {
    if ((paramInetAddress != null) && (!paramInetAddress.isLoopbackAddress()) && (!paramInetAddress.isLinkLocalAddress()) && (!paramInetAddress.isAnyLocalAddress()))
    {
      if ((paramInetAddress instanceof Inet6Address)) {
        return 2;
      }
      if ((paramInetAddress instanceof Inet4Address)) {
        return 1;
      }
    }
    return 0;
  }
  
  public static int getNetworkType(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = paramContext.getApplicationContext();
      if (paramContext != null) {
        try
        {
          paramContext = (TelephonyManager)paramContext.getSystemService("phone");
          if (paramContext != null)
          {
            int i = paramContext.getNetworkType();
            return i;
          }
        }
        catch (Throwable paramContext)
        {
          AdLog.e("AdNet", "getNetworkType", paramContext);
        }
      }
    }
    AdLog.e("AdNet", "getNetworkType error");
    return -2147483648;
  }
  
  public static int getType(Context paramContext)
  {
    int j = getTypeInternal(paramContext);
    int i = j;
    if (j == 7) {
      i = 0;
    }
    return i;
  }
  
  private static int getTypeInternal(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    Context localContext = paramContext.getApplicationContext();
    if (localContext == null) {
      return 0;
    }
    try
    {
      Object localObject = (ConnectivityManager)ConnectivityManager.class.cast(localContext.getSystemService("connectivity"));
      if (localObject == null) {
        return 0;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject == null) {
        return 0;
      }
      switch (((NetworkInfo)localObject).getType())
      {
      case 0: 
      case 2: 
      case 3: 
      case 4: 
      case 5: 
        if (Build.VERSION.SDK_INT <= 29) {
          return getDataTypeOnAndroidQ(((NetworkInfo)localObject).getSubtype());
        }
        if (!e.checkPermission(paramContext, "android.permission.READ_PHONE_STATE")) {
          return 0;
        }
        paramContext = (TelephonyManager)TelephonyManager.class.cast(localContext.getSystemService("phone"));
        if (paramContext == null) {
          return 0;
        }
        int i = getDataTypeOnAndroidR(paramContext.getNetworkType());
        return i;
      }
    }
    catch (Throwable paramContext)
    {
      AdLog.e("AdNet", "getTypeInternal", paramContext);
      return 0;
    }
    return 0;
    return 1;
  }
  
  public static int getTypeWith5G(Context paramContext)
  {
    return getType(paramContext);
  }
  
  public static String getUserAgent()
  {
    if (!TextUtils.isEmpty(userAgent)) {
      return userAgent;
    }
    userAgent = System.getProperty("http.agent");
    return userAgent;
  }
  
  public static String getUserAgentCache()
  {
    return userAgent;
  }
  
  public static boolean isNetValid(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    paramContext = (ConnectivityManager)paramContext.getApplicationContext().getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext != null) {
      return paramContext.isAvailable();
    }
    return false;
  }
  
  private static boolean isValidBSSID(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!TextUtils.equals(paramString, "00:00:00:00:00:00")) && (!TextUtils.equals(paramString, "02:00:00:00:00:00"));
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    return getType(paramContext) == 1;
  }
  
  private static void updateIpV4Address(long paramLong)
  {
    AdLog.i("AdNet", String.format("updateIpV4Address delayMillis:%d", new Object[] { Long.valueOf(paramLong) }));
    AdThreadManager.INSTANCE.postDelayed(new AdNet.1(), 4, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.net.AdNet
 * JD-Core Version:    0.7.0.1
 */