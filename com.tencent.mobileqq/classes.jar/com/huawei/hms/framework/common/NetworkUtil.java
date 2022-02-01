package com.huawei.hms.framework.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.UserManager;
import android.telephony.SignalStrength;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.huawei.android.os.BuildEx.VERSION;
import com.huawei.android.telephony.ServiceStateEx;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.security.AccessController;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class NetworkUtil
{
  private static final int INVALID_RSSI = -127;
  private static final String TAG = "NetworkUtil";
  private static final int TYPE_WIFI_P2P = 13;
  
  public static String getDnsServerIps(Context paramContext)
  {
    return Arrays.toString(getDnsServerIpsFromConnectionManager(paramContext));
  }
  
  @SuppressLint({"MissingPermission"})
  private static String[] getDnsServerIpsFromConnectionManager(Context paramContext)
  {
    LinkedList localLinkedList = new LinkedList();
    Object localObject2;
    int j;
    int i;
    Network localNetwork;
    if ((Build.VERSION.SDK_INT >= 21) && (paramContext != null))
    {
      paramContext = (ConnectivityManager)ContextCompat.getSystemService(paramContext, "connectivity");
      if (paramContext != null)
      {
        try
        {
          localObject1 = paramContext.getActiveNetworkInfo();
          if (localObject1 == null) {
            break label244;
          }
          localObject2 = paramContext.getAllNetworks();
          j = localObject2.length;
          i = 0;
        }
        catch (RuntimeException paramContext)
        {
          Object localObject3;
          localObject1 = TAG;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getActiveNetworkInfo failed, exception:");
          ((StringBuilder)localObject2).append(paramContext.getClass().getSimpleName());
          Logger.i((String)localObject1, ((StringBuilder)localObject2).toString());
          break label244;
        }
        catch (SecurityException paramContext)
        {
          Object localObject1 = TAG;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("getActiveNetworkInfo failed, exception:");
          ((StringBuilder)localObject2).append(paramContext.getClass().getSimpleName());
          Logger.i((String)localObject1, ((StringBuilder)localObject2).toString());
        }
        localObject3 = paramContext.getNetworkInfo(localNetwork);
        if ((localObject3 != null) && (((NetworkInfo)localObject3).getType() == ((NetworkInfo)localObject1).getType()))
        {
          localObject3 = paramContext.getLinkProperties(localNetwork);
          if (localObject3 != null)
          {
            localObject3 = ((LinkProperties)localObject3).getDnsServers().iterator();
            while (((Iterator)localObject3).hasNext()) {
              localLinkedList.add(((InetAddress)((Iterator)localObject3).next()).getHostAddress());
            }
          }
        }
      }
    }
    for (;;)
    {
      i += 1;
      label244:
      while (i >= j)
      {
        if (localLinkedList.isEmpty()) {
          return new String[0];
        }
        return (String[])localLinkedList.toArray(new String[localLinkedList.size()]);
      }
      localNetwork = localObject2[i];
      if (localNetwork != null) {
        break;
      }
    }
  }
  
  public static String getHost(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      paramString = new URI(paramString);
      if (paramString.getPort() == -1) {
        return paramString.getHost();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.getHost());
      localStringBuilder.append(":");
      localStringBuilder.append(paramString.getPort());
      return localStringBuilder.toString();
    }
    catch (URISyntaxException paramString)
    {
      Logger.w(TAG, paramString.getClass().getSimpleName());
    }
    return "";
  }
  
  @SuppressLint({"MissingPermission", "NewApi"})
  private static int getHwNetworkType(Context paramContext)
  {
    if (!ReflectionUtils.checkCompatible("com.huawei.android.os.BuildEx$VERSION")) {
      return 0;
    }
    if (paramContext != null)
    {
      paramContext = (TelephonyManager)ContextCompat.getSystemService(paramContext, "phone");
      if (paramContext == null) {}
    }
    try
    {
      if (BuildEx.VERSION.EMUI_SDK_INT < 21) {
        break label80;
      }
      paramContext = paramContext.getServiceState();
      if (paramContext == null) {
        break label80;
      }
      int i = ServiceStateEx.getConfigRadioTechnology(paramContext);
      return i;
    }
    catch (SecurityException paramContext)
    {
      break label72;
    }
    catch (NoSuchMethodError paramContext)
    {
      break label62;
    }
    catch (NoClassDefFoundError paramContext)
    {
      label52:
      break label52;
    }
    Logger.w(TAG, "NoClassDefFoundError occur in method getHwNetworkType.");
    return 0;
    label62:
    Logger.w(TAG, "NoSuchMethodError occur in method getHwNetworkType.");
    return 0;
    label72:
    Logger.w(TAG, "requires permission maybe missing.");
    label80:
    return 0;
  }
  
  public static String getMNC(Context paramContext)
  {
    if (paramContext == null) {
      return "unknown";
    }
    if (!isSimReady(paramContext)) {
      return "unknown";
    }
    Object localObject1 = null;
    Object localObject2 = ContextCompat.getSystemService(paramContext, "phone");
    paramContext = localObject1;
    if ((localObject2 instanceof TelephonyManager)) {
      paramContext = (TelephonyManager)localObject2;
    }
    if (paramContext == null)
    {
      Logger.e(TAG, "getSubscriptionOperatorType: other error!");
      return "unknown";
    }
    paramContext = paramContext.getNetworkOperator();
    if ((!"46001".equals(paramContext)) && (!"46006".equals(paramContext)) && (!"46009".equals(paramContext)))
    {
      if ((!"46000".equals(paramContext)) && (!"46002".equals(paramContext)) && (!"46004".equals(paramContext)) && (!"46007".equals(paramContext)))
      {
        if ((!"46003".equals(paramContext)) && (!"46005".equals(paramContext)) && (!"46011".equals(paramContext))) {
          return "other";
        }
        return "China_Telecom";
      }
      return "China_Mobile";
    }
    return "China_Unicom";
  }
  
  public static int getMobileRsrp(Context paramContext)
  {
    paramContext = getSignalStrength(paramContext);
    if (paramContext == null) {
      return 0;
    }
    try
    {
      Method localMethod = SignalStrength.class.getDeclaredMethod("getDbm", new Class[0]);
      AccessController.doPrivileged(new NetworkUtil.1(localMethod));
      int i = ((Integer)localMethod.invoke(paramContext, new Object[0])).intValue();
      return i;
    }
    catch (NoSuchMethodException paramContext)
    {
      break label77;
    }
    catch (IllegalAccessException paramContext)
    {
      break label66;
    }
    catch (InvocationTargetException paramContext)
    {
      label55:
      break label55;
    }
    Logger.i(TAG, "getDbm: InvocationTargetException");
    return 0;
    label66:
    Logger.i(TAG, "getDbm: cannot access");
    return 0;
    label77:
    Logger.i(TAG, "getDbm: function not found");
    return 0;
  }
  
  public static int getMobileRsrpLevel(Context paramContext)
  {
    paramContext = getSignalStrength(paramContext);
    if (paramContext != null) {}
    try
    {
      Method localMethod = SignalStrength.class.getDeclaredMethod("getLteLevel", new Class[0]);
      AccessController.doPrivileged(new NetworkUtil.2(localMethod));
      int i = ((Integer)localMethod.invoke(paramContext, new Object[0])).intValue();
      return i;
    }
    catch (NoSuchMethodException paramContext)
    {
      break label75;
    }
    catch (IllegalAccessException paramContext)
    {
      break label64;
    }
    catch (InvocationTargetException paramContext)
    {
      label53:
      break label53;
    }
    Logger.i(TAG, "getLteLevel: InvocationTargetException");
    return 0;
    label64:
    Logger.i(TAG, "getLteLevel: cannot access");
    return 0;
    label75:
    Logger.i(TAG, "getLteLevel: function not found");
    return 0;
  }
  
  @SuppressLint({"MissingPermission"})
  public static NetworkInfo getNetworkInfo(Context paramContext)
  {
    if (ContextCompat.checkSelfPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE"))
    {
      paramContext = (ConnectivityManager)ContextCompat.getSystemService(paramContext, "connectivity");
      if (paramContext != null) {
        try
        {
          paramContext = paramContext.getActiveNetworkInfo();
          return paramContext;
        }
        catch (RuntimeException paramContext)
        {
          String str = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getActiveNetworkInfo failed, exception:");
          localStringBuilder.append(paramContext.getClass().getSimpleName());
          localStringBuilder.append(paramContext.getMessage());
          Logger.i(str, localStringBuilder.toString());
        }
      }
    }
    return null;
  }
  
  @SuppressLint({"MissingPermission"})
  public static NetworkInfo.DetailedState getNetworkStatus(Context paramContext)
  {
    NetworkInfo.DetailedState localDetailedState = NetworkInfo.DetailedState.IDLE;
    if (paramContext != null)
    {
      paramContext = ContextCompat.getSystemService(paramContext, "connectivity");
      if ((paramContext instanceof ConnectivityManager)) {
        try
        {
          paramContext = ((ConnectivityManager)paramContext).getActiveNetworkInfo();
          if (paramContext != null) {
            return paramContext.getDetailedState();
          }
          Logger.i(TAG, "getNetworkStatus networkIsConnected netInfo is null!");
          return localDetailedState;
        }
        catch (RuntimeException paramContext)
        {
          String str = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getNetworkStatus exception");
          localStringBuilder.append(paramContext.getClass().getSimpleName());
          localStringBuilder.append(paramContext.getMessage());
          Logger.i(str, localStringBuilder.toString());
          return localDetailedState;
        }
      }
      Logger.i(TAG, "getNetworkStatus ConnectivityManager is null!");
    }
    return localDetailedState;
  }
  
  public static int getNetworkType(Context paramContext)
  {
    if (paramContext != null) {
      return getNetworkType(getNetworkInfo(paramContext), paramContext);
    }
    return 0;
  }
  
  public static int getNetworkType(NetworkInfo paramNetworkInfo)
  {
    return getNetworkType(paramNetworkInfo, null);
  }
  
  public static int getNetworkType(NetworkInfo paramNetworkInfo, Context paramContext)
  {
    int i = 1;
    if ((paramNetworkInfo != null) && (paramNetworkInfo.isConnected()))
    {
      int j = paramNetworkInfo.getType();
      if (1 != j)
      {
        if (13 == j) {
          return 1;
        }
        if (j == 0)
        {
          i = getHwNetworkType(paramContext);
          paramContext = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getHwNetworkType return is: ");
          localStringBuilder.append(i);
          Logger.v(paramContext, localStringBuilder.toString());
          j = i;
          if (i == 0) {
            j = paramNetworkInfo.getSubtype();
          }
          int k = 3;
          if (j != 20) {
            switch (j)
            {
            default: 
              i = 0;
              break;
            case 13: 
              i = 4;
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
              i = 3;
              break;
            case 1: 
            case 2: 
            case 4: 
            case 7: 
            case 11: 
              i = 2;
              break;
            }
          } else {
            i = 5;
          }
          if ((i == 0) && (Build.VERSION.SDK_INT >= 25))
          {
            if (j != 16)
            {
              i = k;
              if (j == 17) {
                return i;
              }
            }
            else
            {
              return 2;
            }
          }
          else {
            return i;
          }
        }
        return 0;
      }
    }
    else
    {
      i = -1;
    }
    return i;
  }
  
  private static SignalStrength getSignalStrength(Context paramContext)
  {
    if ((paramContext != null) && (Build.VERSION.SDK_INT >= 28))
    {
      paramContext = ContextCompat.getSystemService(paramContext, "phone");
      if ((paramContext instanceof TelephonyManager)) {
        return ((TelephonyManager)paramContext).createForSubscriptionId(SubscriptionManager.getDefaultDataSubscriptionId()).getSignalStrength();
      }
    }
    return null;
  }
  
  public static String getWifiGatewayIp(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ContextCompat.getSystemService(paramContext.getApplicationContext(), "wifi");
      if ((paramContext instanceof WifiManager))
      {
        paramContext = (WifiManager)paramContext;
        try
        {
          int i = paramContext.getDhcpInfo().gateway;
          paramContext = InetAddress.getByAddress(new byte[] { (byte)(i & 0xFF), (byte)(i >> 8 & 0xFF), (byte)(i >> 16 & 0xFF), (byte)(i >> 24 & 0xFF) }).getHostAddress();
          return paramContext;
        }
        catch (UnknownHostException paramContext) {}catch (RuntimeException paramContext) {}
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getWifiGatewayIp error!");
        localStringBuilder.append(paramContext.getClass().getSimpleName());
        localStringBuilder.append(paramContext.getMessage());
        Logger.i(str, localStringBuilder.toString());
      }
    }
    return " ";
  }
  
  public static int getWifiRssi(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = ContextCompat.getSystemService(paramContext.getApplicationContext(), "wifi");
      if ((paramContext instanceof WifiManager))
      {
        paramContext = (WifiManager)paramContext;
        try
        {
          paramContext = NetworkMonitor.getConnectionInfo(paramContext);
          if ((paramContext != null) && (paramContext.getBSSID() != null))
          {
            int i = paramContext.getRssi();
            return i;
          }
        }
        catch (RuntimeException paramContext)
        {
          String str = TAG;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getWifiRssiLevel did not has permission!");
          localStringBuilder.append(paramContext.getClass().getSimpleName());
          localStringBuilder.append(paramContext.getMessage());
          Logger.i(str, localStringBuilder.toString());
        }
      }
    }
    return -127;
  }
  
  public static int getWifiRssiLevel(Context paramContext)
  {
    return WifiManager.calculateSignalLevel(getWifiRssi(paramContext), 5);
  }
  
  @Deprecated
  public static boolean isForeground(Context paramContext)
  {
    return ActivityUtil.isForeground(paramContext);
  }
  
  public static boolean isNetworkAvailable(Context paramContext)
  {
    boolean bool2 = ContextCompat.checkSelfPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE");
    boolean bool1 = true;
    if (bool2)
    {
      paramContext = getNetworkInfo(paramContext);
      if ((paramContext != null) && (paramContext.isConnected())) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  public static boolean isSimReady(Context paramContext)
  {
    paramContext = ContextCompat.getSystemService(paramContext, "phone");
    if ((paramContext instanceof TelephonyManager)) {
      paramContext = (TelephonyManager)paramContext;
    } else {
      paramContext = null;
    }
    return (paramContext != null) && (paramContext.getSimState() == 5);
  }
  
  public static boolean isUserUnlocked(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 24)
    {
      paramContext = (UserManager)ContextCompat.getSystemService(paramContext, "user");
      if (paramContext != null) {
        try
        {
          boolean bool = paramContext.isUserUnlocked();
          return bool;
        }
        catch (RuntimeException paramContext)
        {
          Logger.e(TAG, "dealType rethrowFromSystemServer:", paramContext);
        }
      }
    }
    return true;
  }
  
  @Deprecated
  public static NetworkInfo.DetailedState networkStatus(Context paramContext)
  {
    return getNetworkStatus(paramContext);
  }
  
  @SuppressLint({"MissingPermission"})
  public static int readDataSaverMode(Context paramContext)
  {
    if ((paramContext != null) && (Build.VERSION.SDK_INT >= 24) && (ContextCompat.checkSelfPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE")))
    {
      paramContext = ContextCompat.getSystemService(paramContext, "connectivity");
      if ((paramContext instanceof ConnectivityManager))
      {
        paramContext = (ConnectivityManager)paramContext;
        try
        {
          if (paramContext.isActiveNetworkMetered()) {
            return paramContext.getRestrictBackgroundStatus();
          }
          Logger.v(TAG, "ConnectType is not Mobile Network!");
          return 0;
        }
        catch (RuntimeException paramContext)
        {
          Logger.e(TAG, "SystemServer error:", paramContext);
        }
      }
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.framework.common.NetworkUtil
 * JD-Core Version:    0.7.0.1
 */