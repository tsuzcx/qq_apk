package com.tencent.gathererga.core.internal.provider.impl;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.telephony.ServiceState;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.gathererga.core.ProviderMethodPriority;
import com.tencent.gathererga.core.ProviderResult;
import com.tencent.gathererga.core.UserInfoProvider;
import com.tencent.gathererga.core.internal.provider.InfoID;
import com.tencent.gathererga.core.internal.provider.ProviderResultImpl;
import com.tencent.gathererga.core.internal.util.GLog;
import com.tencent.gathererga.core.internal.util.LocationInfoUtil;
import com.tencent.gathererga.core.internal.util.PermissionUtil;
import com.tencent.gathererga.core.internal.util.TelephonyManagerUtil;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import java.io.File;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;

public class UserInfoImpl
  implements UserInfoProvider
{
  private static final Map<String, Integer> b = new UserInfoImpl.1();
  private Context a = null;
  
  private String a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 8 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 16 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 24 & 0xFF);
    return localStringBuilder.toString();
  }
  
  public static boolean a()
  {
    if (!TextUtils.isEmpty("HUAWEI"))
    {
      String[] arrayOfString = "HUAWEI".split(",");
      if (arrayOfString.length > 0)
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if ((!TextUtils.isEmpty(str)) && (str.equalsIgnoreCase(Build.MANUFACTURER))) {
            return true;
          }
          i += 1;
        }
      }
    }
    return false;
  }
  
  private boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (!TextUtils.equals(paramString, "00:00:00:00:00:00")) && (!TextUtils.equals(paramString, "02:00:00:00:00:00"));
  }
  
  private static ProviderResult b(int paramInt)
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
      GLog.b("getDataTypeOnAndroidQ", localThrowable2);
      localInteger1 = localInteger2;
    }
    try
    {
      localObject5 = TelephonyManager.class.getDeclaredMethod("getNetworkClass", new Class[] { Integer.TYPE }).invoke(TelephonyManager.class, new Object[] { Integer.valueOf(paramInt) });
      if (localObject5.equals(localObject1)) {
        return new ProviderResultImpl(0L, Integer.valueOf(2));
      }
      if (localObject5.equals(localObject2)) {
        return new ProviderResultImpl(0L, Integer.valueOf(3));
      }
      if (localObject5.equals(localObject3)) {
        return new ProviderResultImpl(0L, Integer.valueOf(4));
      }
      if (localObject5.equals(localInteger1)) {
        return new ProviderResultImpl(0L, Integer.valueOf(7));
      }
      localObject1 = new ProviderResultImpl(-300L, Integer.valueOf(0));
      return localObject1;
    }
    catch (Throwable localThrowable1)
    {
      GLog.b("getDataTypeOnAndroidQ", localThrowable1);
    }
    return new ProviderResultImpl(-300L, Integer.valueOf(0));
  }
  
  private String b()
  {
    try
    {
      InetAddress localInetAddress;
      do
      {
        localObject1 = NetworkMonitor.getNetworkInterfaces();
        while (!((Enumeration)localObject2).hasMoreElements())
        {
          if ((localObject1 == null) || (!((Enumeration)localObject1).hasMoreElements())) {
            break;
          }
          localObject2 = ((NetworkInterface)((Enumeration)localObject1).nextElement()).getInetAddresses();
        }
        localInetAddress = (InetAddress)((Enumeration)localObject2).nextElement();
      } while ((localInetAddress.isLoopbackAddress()) || ((localInetAddress instanceof Inet6Address)));
      Object localObject1 = localInetAddress.getHostAddress();
      return localObject1;
    }
    catch (SocketException localSocketException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Get mobile ip address encounter error: ");
      ((StringBuilder)localObject2).append(localSocketException.toString());
      GLog.b(((StringBuilder)localObject2).toString());
    }
    return "0.0.0.0";
  }
  
  public static boolean b(Context paramContext)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool = false;
    if ((i >= 29) && (a())) {
      try
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        Method localMethod = TelephonyManager.class.getMethod("getServiceState", new Class[0]);
        localMethod.setAccessible(true);
        paramContext = (ServiceState)localMethod.invoke(paramContext, new Object[0]);
        if (paramContext != null)
        {
          localMethod = ServiceState.class.getMethod("getHwNetworkType", new Class[0]);
          localMethod.setAccessible(true);
          i = ((Integer)localMethod.invoke(paramContext, new Object[0])).intValue();
          paramContext = new StringBuilder();
          paramContext.append("UserInfoProviderImpl isHuawei5G - networkType: ");
          paramContext.append(i);
          GLog.b(paramContext.toString());
          if (i == 20) {
            bool = true;
          }
          return bool;
        }
      }
      catch (Throwable paramContext)
      {
        GLog.a("UserInfoProviderImpl isHuawei5G call failed", paramContext);
      }
    }
    return false;
  }
  
  private static ProviderResult c(int paramInt)
  {
    long l = TelephonyManagerUtil.a(paramInt);
    if ((0x804B & l) != 0L) {
      return new ProviderResultImpl(0L, Integer.valueOf(2));
    }
    if ((0x16BB4 & l) != 0L) {
      return new ProviderResultImpl(0L, Integer.valueOf(3));
    }
    if ((0x61000 & l) != 0L) {
      return new ProviderResultImpl(0L, Integer.valueOf(4));
    }
    if ((l & 0x80000) != 0L) {
      return new ProviderResultImpl(0L, Integer.valueOf(7));
    }
    return new ProviderResultImpl(-300L, Integer.valueOf(0));
  }
  
  private String c()
  {
    try
    {
      Object localObject = (TelephonyManager)this.a.getSystemService("phone");
      if (((TelephonyManager)localObject).getSimState() == 5)
      {
        localObject = ((TelephonyManager)localObject).getSimOperator();
        return localObject;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Get operator encounter exception: ");
      localStringBuilder.append(localThrowable.getMessage());
      GLog.b(localStringBuilder.toString());
    }
    return null;
  }
  
  private WifiManager d()
  {
    Object localObject = this.a;
    if (localObject != null) {
      if (!PermissionUtil.a((Context)localObject, "android.permission.ACCESS_WIFI_STATE"))
      {
        GLog.d("UserInfoProviderImpl getWifiManager checkPermission failed");
      }
      else
      {
        localObject = this.a.getApplicationContext();
        if (localObject == null) {
          GLog.d("UserInfoProviderImpl getWifiManager getApplicationContext null");
        }
      }
    }
    try
    {
      localObject = ((Context)localObject).getSystemService("wifi");
      if (!(localObject instanceof WifiManager)) {
        break label82;
      }
      localObject = (WifiManager)localObject;
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      label76:
      label82:
      break label76;
    }
    GLog.d("UserInfoProviderImpl getWifiManager getSystemService failed");
    return null;
  }
  
  public void a(Context paramContext)
  {
    this.a = paramContext;
  }
  
  @InfoID(id=407)
  public ProviderResult getBootTime(ProviderMethodPriority paramProviderMethodPriority)
  {
    return new ProviderResultImpl(0L, Long.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
  }
  
  @InfoID(id=307, permissions={"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_WIFI_STATE"})
  public ProviderResult getBssid(ProviderMethodPriority paramProviderMethodPriority)
  {
    Object localObject = d();
    String str = null;
    paramProviderMethodPriority = null;
    int j = 0;
    int i = 0;
    ProviderMethodPriority localProviderMethodPriority;
    if (localObject == null)
    {
      GLog.d("UserInfoProviderImpl getBssid failed. getWifiManager null");
      i = j;
    }
    else
    {
      if (Build.VERSION.SDK_INT > 26) {
        if ((Build.VERSION.SDK_INT != 27) && (Build.VERSION.SDK_INT != 28))
        {
          if (!PermissionUtil.a(this.a, "android.permission.ACCESS_FINE_LOCATION"))
          {
            i = j;
            break label184;
          }
        }
        else if ((!PermissionUtil.a(this.a, "android.permission.ACCESS_COARSE_LOCATION")) && (!PermissionUtil.a(this.a, "android.permission.ACCESS_FINE_LOCATION")))
        {
          i = j;
          break label184;
        }
      }
      try
      {
        localObject = NetworkMonitor.getConnectionInfo((WifiManager)localObject);
        if (localObject == null)
        {
          GLog.d("UserInfoProviderImpl getBssid failed. getConnectionInfo null");
          i = j;
          break label184;
        }
        str = ((WifiInfo)localObject).getBSSID();
        paramProviderMethodPriority = str;
      }
      catch (Throwable localThrowable)
      {
        i = -300;
        GLog.b("UserInfoProviderImpl getBSSID failed.", localThrowable);
      }
      localProviderMethodPriority = paramProviderMethodPriority;
      if (!a(paramProviderMethodPriority))
      {
        i = -305;
        GLog.d("UserInfoProviderImpl getBssid invalid.");
        localProviderMethodPriority = paramProviderMethodPriority;
      }
    }
    label184:
    return new ProviderResultImpl(i, localProviderMethodPriority);
  }
  
  @InfoID(id=305)
  public ProviderResult getCarrier(ProviderMethodPriority paramProviderMethodPriority, boolean paramBoolean)
  {
    int i;
    try
    {
      paramProviderMethodPriority = c();
      try
      {
        if (TextUtils.isEmpty(paramProviderMethodPriority)) {
          return new ProviderResultImpl(0, Integer.valueOf(0));
        }
        Object localObject1 = b.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Map.Entry)((Iterator)localObject1).next();
          if (paramProviderMethodPriority.startsWith((String)((Map.Entry)localObject2).getKey()))
          {
            l = 0;
            if (paramBoolean) {
              localObject1 = paramProviderMethodPriority;
            } else {
              localObject1 = (Serializable)((Map.Entry)localObject2).getValue();
            }
            localObject1 = new ProviderResultImpl(l, localObject1);
            return localObject1;
          }
        }
        i = 0;
      }
      catch (Throwable localThrowable1) {}
      i = -300;
    }
    catch (Throwable localThrowable2)
    {
      paramProviderMethodPriority = null;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Get carrier encounter exception: ");
    ((StringBuilder)localObject2).append(localThrowable2.getMessage());
    GLog.b(((StringBuilder)localObject2).toString());
    long l = i;
    if (!paramBoolean) {
      paramProviderMethodPriority = Integer.valueOf(0);
    }
    return new ProviderResultImpl(l, paramProviderMethodPriority);
  }
  
  @InfoID(id=303)
  public ProviderResult getCountry(ProviderMethodPriority paramProviderMethodPriority)
  {
    return new ProviderResultImpl(0L, this.a.getResources().getConfiguration().locale.getCountry());
  }
  
  @InfoID(id=315, permissions={"android.permission.ACCESS_NETWORK_STATE"})
  public ProviderResult getIpAddress(ProviderMethodPriority paramProviderMethodPriority)
  {
    Object localObject2 = "0.0.0.0";
    int j = 0;
    paramProviderMethodPriority = (ProviderMethodPriority)localObject2;
    int i;
    ProviderMethodPriority localProviderMethodPriority;
    try
    {
      Object localObject3 = (ConnectivityManager)this.a.getSystemService("connectivity");
      i = j;
      Object localObject1 = localObject2;
      if (localObject3 != null)
      {
        paramProviderMethodPriority = (ProviderMethodPriority)localObject2;
        i = j;
        localObject1 = localObject2;
        if (PermissionUtil.a(this.a, "android.permission.ACCESS_NETWORK_STATE"))
        {
          paramProviderMethodPriority = (ProviderMethodPriority)localObject2;
          localObject1 = ((ConnectivityManager)localObject3).getNetworkInfo(0);
          paramProviderMethodPriority = (ProviderMethodPriority)localObject2;
          localObject3 = ((ConnectivityManager)localObject3).getNetworkInfo(1);
          if (localObject1 != null)
          {
            paramProviderMethodPriority = (ProviderMethodPriority)localObject2;
            if (((NetworkInfo)localObject1).isConnected())
            {
              paramProviderMethodPriority = (ProviderMethodPriority)localObject2;
              localObject1 = b();
              paramProviderMethodPriority = (ProviderMethodPriority)localObject1;
              localObject2 = new StringBuilder();
              paramProviderMethodPriority = (ProviderMethodPriority)localObject1;
              ((StringBuilder)localObject2).append("移动网络ip地址为：");
              paramProviderMethodPriority = (ProviderMethodPriority)localObject1;
              ((StringBuilder)localObject2).append((String)localObject1);
              paramProviderMethodPriority = (ProviderMethodPriority)localObject1;
              GLog.b(((StringBuilder)localObject2).toString());
              i = j;
              break label347;
            }
          }
          i = j;
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            paramProviderMethodPriority = (ProviderMethodPriority)localObject2;
            i = j;
            localObject1 = localObject2;
            if (((NetworkInfo)localObject3).isConnected())
            {
              paramProviderMethodPriority = (ProviderMethodPriority)localObject2;
              localObject3 = (WifiManager)this.a.getApplicationContext().getSystemService("wifi");
              i = j;
              localObject1 = localObject2;
              if (localObject3 != null)
              {
                paramProviderMethodPriority = (ProviderMethodPriority)localObject2;
                localObject3 = NetworkMonitor.getConnectionInfo((WifiManager)localObject3);
                i = j;
                localObject1 = localObject2;
                if (localObject3 != null)
                {
                  paramProviderMethodPriority = (ProviderMethodPriority)localObject2;
                  localObject1 = a(((WifiInfo)localObject3).getIpAddress());
                  paramProviderMethodPriority = (ProviderMethodPriority)localObject1;
                  localObject2 = new StringBuilder();
                  paramProviderMethodPriority = (ProviderMethodPriority)localObject1;
                  ((StringBuilder)localObject2).append("WiFi网络ip地址为：");
                  paramProviderMethodPriority = (ProviderMethodPriority)localObject1;
                  ((StringBuilder)localObject2).append((String)localObject1);
                  paramProviderMethodPriority = (ProviderMethodPriority)localObject1;
                  GLog.b(((StringBuilder)localObject2).toString());
                  i = j;
                }
              }
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Get ip encounter error: ");
      ((StringBuilder)localObject2).append(localException.getMessage());
      GLog.b(((StringBuilder)localObject2).toString());
      i = -300;
      localProviderMethodPriority = paramProviderMethodPriority;
    }
    label347:
    return new ProviderResultImpl(i, localProviderMethodPriority);
  }
  
  public ProviderResult getLanguage(ProviderMethodPriority paramProviderMethodPriority)
  {
    return new ProviderResultImpl(0L, Locale.getDefault().getLanguage());
  }
  
  @InfoID(id=309, permissions={"android.permission.ACCESS_FINE_LOCATION"})
  public ProviderResult getLatitude(ProviderMethodPriority paramProviderMethodPriority)
  {
    return new ProviderResultImpl(0L, Double.valueOf(LocationInfoUtil.a(this.a).a()));
  }
  
  @InfoID(id=310, permissions={"android.permission.ACCESS_FINE_LOCATION"})
  public ProviderResult getLongitude(ProviderMethodPriority paramProviderMethodPriority)
  {
    return new ProviderResultImpl(0L, Double.valueOf(LocationInfoUtil.a(this.a).b()));
  }
  
  @InfoID(id=313)
  public ProviderResult getMobileNetworkType(ProviderMethodPriority paramProviderMethodPriority)
  {
    try
    {
      if (((ConnectivityManager)this.a.getSystemService("connectivity")).getActiveNetworkInfo() != null)
      {
        paramProviderMethodPriority = (TelephonyManager)this.a.getSystemService("phone");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramProviderMethodPriority.getNetworkType());
        paramProviderMethodPriority = new ProviderResultImpl(0L, localStringBuilder.toString());
        return paramProviderMethodPriority;
      }
      return new ProviderResultImpl(-300L, null);
    }
    catch (Exception paramProviderMethodPriority)
    {
      label84:
      break label84;
    }
    return new ProviderResultImpl(-300L, null);
  }
  
  @InfoID(id=312, permissions={"android.permission.ACCESS_NETWORK_STATE"})
  public ProviderResult getNetworkType(ProviderMethodPriority paramProviderMethodPriority)
  {
    Object localObject = this.a;
    paramProviderMethodPriority = Integer.valueOf(0);
    if (localObject == null) {
      return new ProviderResultImpl(-302L, paramProviderMethodPriority);
    }
    for (;;)
    {
      try
      {
        localObject = (ConnectivityManager)((Context)localObject).getSystemService("connectivity");
        if (localObject == null) {
          return new ProviderResultImpl(-303L, paramProviderMethodPriority);
        }
        localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
        if (localObject == null) {
          return new ProviderResultImpl(-304L, paramProviderMethodPriority);
        }
        if (b(this.a)) {
          return new ProviderResultImpl(0L, Integer.valueOf(7));
        }
        switch (((NetworkInfo)localObject).getType())
        {
        case 1: 
          break;
        case 6: 
          return new ProviderResultImpl(0L, Integer.valueOf(1));
        case 0: 
        case 2: 
        case 3: 
        case 4: 
        case 5: 
          if (Build.VERSION.SDK_INT <= 29) {
            return b(((NetworkInfo)localObject).getSubtype());
          }
          if (!PermissionUtil.a(this.a, "android.permission.READ_PHONE_STATE")) {
            return new ProviderResultImpl(-300L, paramProviderMethodPriority);
          }
          localObject = (TelephonyManager)TelephonyManager.class.cast(this.a.getSystemService("phone"));
          if (localObject == null) {
            return new ProviderResultImpl(-300L, paramProviderMethodPriority);
          }
          return c(((TelephonyManager)localObject).getNetworkType());
          localObject = new ProviderResultImpl(0L, paramProviderMethodPriority);
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        GLog.b("getType", localThrowable);
        return new ProviderResultImpl(-300L, paramProviderMethodPriority);
      }
    }
  }
  
  @InfoID(id=317)
  public ProviderResult getScreenOrientation(ProviderMethodPriority paramProviderMethodPriority)
  {
    return new ProviderResultImpl(0L, Integer.valueOf(this.a.getResources().getConfiguration().orientation));
  }
  
  public ProviderResult getTimeZone(ProviderMethodPriority paramProviderMethodPriority)
  {
    paramProviderMethodPriority = "";
    int i = 0;
    try
    {
      String str = TimeZone.getDefault().getDisplayName(false, 0);
      paramProviderMethodPriority = str;
    }
    catch (AssertionError localAssertionError)
    {
      break label27;
    }
    catch (Exception localException)
    {
      label20:
      break label20;
    }
    i = -300;
    break label31;
    label27:
    i = -301;
    label31:
    return new ProviderResultImpl(i, paramProviderMethodPriority);
  }
  
  @InfoID(id=308)
  public ProviderResult getUserAgent(ProviderMethodPriority paramProviderMethodPriority)
  {
    return new ProviderResultImpl(0L, System.getProperty("http.agent"));
  }
  
  @InfoID(id=316)
  public ProviderResult isRooted(ProviderMethodPriority paramProviderMethodPriority)
  {
    paramProviderMethodPriority = new String[10];
    paramProviderMethodPriority[0] = "/system/app/Superuser.apk";
    paramProviderMethodPriority[1] = "/sbin/su";
    paramProviderMethodPriority[2] = "/system/bin/su";
    paramProviderMethodPriority[3] = "/system/xbin/su";
    paramProviderMethodPriority[4] = "/data/local/xbin/su";
    paramProviderMethodPriority[5] = "/data/local/bin/su";
    paramProviderMethodPriority[6] = "/system/sd/xbin/su";
    paramProviderMethodPriority[7] = "/system/bin/failsafe/su";
    paramProviderMethodPriority[8] = "/data/local/su";
    paramProviderMethodPriority[9] = "/su/bin/su";
    int j = paramProviderMethodPriority.length;
    int i = 0;
    while (i < j)
    {
      if (new File(paramProviderMethodPriority[i]).exists()) {
        return new ProviderResultImpl(0L, Boolean.valueOf(true));
      }
      i += 1;
    }
    return new ProviderResultImpl(0L, Boolean.valueOf(false));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.provider.impl.UserInfoImpl
 * JD-Core Version:    0.7.0.1
 */