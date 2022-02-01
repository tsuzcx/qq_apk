package com.tencent.mars.ilink.comm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import com.tencent.mars.ilink.xlog.Log;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import java.lang.reflect.Method;
import java.util.List;

public class NetStatusUtil
{
  public static final int CMNET = 6;
  public static final int CMWAP = 5;
  public static final int CTNET = 8;
  public static final int CTWAP = 7;
  public static final int LTE = 10;
  public static final int MOBILE = 9;
  public static final int NETTYPE_NOT_WIFI = 0;
  public static final int NETTYPE_WIFI = 1;
  public static final int NET_3G = 4;
  public static final int NON_NETWORK = -1;
  public static final int NO_SIM_OPERATOR = 0;
  public static final int POLICY_NONE = 0;
  public static final int POLICY_REJECT_METERED_BACKGROUND = 1;
  private static final String TAG = "MicroMsg.NetStatusUtil";
  public static final int TBACKGROUND_DATA_LIMITED = 2;
  public static final int TBACKGROUND_NOT_LIMITED = 0;
  public static final int TBACKGROUND_PROCESS_LIMITED = 1;
  public static final int TBACKGROUND_WIFI_LIMITED = 3;
  public static final int UNINET = 1;
  public static final int UNIWAP = 2;
  public static final int UNKNOW_TYPE = 999;
  public static final int WAP_3G = 3;
  public static final int WIFI = 0;
  private static int nowStrength;
  
  public static void dumpNetStatus(Context paramContext)
  {
    try
    {
      Log.i("MicroMsg.NetStatusUtil", ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo().toString());
      return;
    }
    catch (Exception paramContext)
    {
      Log.e("MicroMsg.NetStatusUtil", "", new Object[] { paramContext });
    }
  }
  
  public static int getBackgroundLimitType(Context paramContext)
  {
    int i;
    if (Build.VERSION.SDK_INT >= 14) {
      try
      {
        Object localObject = Class.forName("android.app.ActivityManagerNative");
        localObject = ((Class)localObject).getMethod("getDefault", new Class[0]).invoke(localObject, new Object[0]);
        i = ((Integer)localObject.getClass().getMethod("getProcessLimit", new Class[0]).invoke(localObject, new Object[0])).intValue();
        if (i == 0) {
          return 1;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    try
    {
      i = getWifiSleeepPolicy(paramContext);
      if (i != 2)
      {
        int j = getNetType(paramContext);
        if (j != 0) {
          return 0;
        }
        if ((i == 1) || (i == 0)) {
          return 3;
        }
      }
      else
      {
        return 0;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static int getISPCode(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null) {
      return 0;
    }
    paramContext = paramContext.getSimOperator();
    StringBuilder localStringBuilder;
    if (paramContext != null)
    {
      if (paramContext.length() < 5) {
        return 0;
      }
      localStringBuilder = new StringBuilder();
    }
    for (;;)
    {
      try
      {
        j = paramContext.length();
        i = j;
        if (j <= 6) {
          break label121;
        }
        i = 6;
      }
      catch (Exception paramContext)
      {
        int i;
        paramContext.printStackTrace();
      }
      if (j < i) {
        if (!Character.isDigit(paramContext.charAt(j)))
        {
          if (localStringBuilder.length() <= 0) {
            break label126;
          }
        }
        else
        {
          localStringBuilder.append(paramContext.charAt(j));
          break label126;
        }
      }
      i = Integer.valueOf(localStringBuilder.toString()).intValue();
      return i;
      return 0;
      label121:
      int j = 0;
      continue;
      label126:
      j += 1;
    }
  }
  
  public static String getISPName(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null) {
      return "";
    }
    if (paramContext.getSimOperatorName().length() <= 100) {
      return paramContext.getSimOperatorName();
    }
    return paramContext.getSimOperatorName().substring(0, 100);
  }
  
  public static int getNetType(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return -1;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null) {
      return -1;
    }
    if (paramContext.getType() == 1) {
      return 0;
    }
    if (paramContext.getExtraInfo() != null)
    {
      if (paramContext.getExtraInfo().equalsIgnoreCase("uninet")) {
        return 1;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("uniwap")) {
        return 2;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("3gwap")) {
        return 3;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("3gnet")) {
        return 4;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("cmwap")) {
        return 5;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("cmnet")) {
        return 6;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("ctwap")) {
        return 7;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("ctnet")) {
        return 8;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("LTE")) {
        return 10;
      }
    }
    return 9;
  }
  
  public static int getNetTypeForStat(Context paramContext)
  {
    if (paramContext == null) {
      return 999;
    }
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return 999;
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null) {
        return 999;
      }
      if (paramContext.getType() == 1) {
        return 1;
      }
      int i = paramContext.getSubtype();
      if (i == 0) {
        return 999;
      }
      return i * 1000;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 999;
  }
  
  public static String getNetTypeString(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return "NON_NETWORK";
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null) {
      return "NON_NETWORK";
    }
    if (paramContext.getType() == 1) {
      return "WIFI";
    }
    if (paramContext.getExtraInfo() != null) {
      return paramContext.getExtraInfo();
    }
    return "MOBILE";
  }
  
  public static int getNetWorkType(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext != null)
      {
        int i = paramContext.getType();
        return i;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return -1;
  }
  
  public static int getProxyInfo(Context paramContext, StringBuffer paramStringBuffer)
  {
    try
    {
      paramContext = Proxy.getDefaultHost();
      int i = Proxy.getDefaultPort();
      if ((paramContext != null) && (paramContext.length() > 0) && (i > 0))
      {
        paramStringBuffer.append(paramContext);
        return i;
      }
      paramContext = System.getProperty("http.proxyHost");
      String str = System.getProperty("http.proxyPort");
      int j = 80;
      i = j;
      if (str != null)
      {
        i = j;
        if (str.length() > 0) {
          i = Integer.parseInt(str);
        }
      }
      if ((paramContext != null) && (paramContext.length() > 0))
      {
        paramStringBuffer.append(paramContext);
        return i;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static int getStrength(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    try
    {
      if (getNetTypeForStat(paramContext) == 1) {
        return Math.abs(NetworkMonitor.getConnectionInfo((WifiManager)paramContext.getSystemService("wifi")).getRssi());
      }
      ((TelephonyManager)paramContext.getSystemService("phone")).listen(new NetStatusUtil.StrengthListener(), 256);
      int i = Math.abs(nowStrength);
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 0;
  }
  
  public static WifiInfo getWifiInfo(Context paramContext)
  {
    try
    {
      Object localObject = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localObject == null) {
        return null;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject != null)
      {
        if (1 != ((NetworkInfo)localObject).getType()) {
          return null;
        }
        paramContext = (WifiManager)paramContext.getSystemService("wifi");
        if (paramContext == null) {
          return null;
        }
        paramContext = NetworkMonitor.getConnectionInfo(paramContext);
        return paramContext;
      }
      return null;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static int getWifiSleeepPolicy(Context paramContext)
  {
    return Settings.System.getInt(paramContext.getContentResolver(), "wifi_sleep_policy", 2);
  }
  
  public static int guessNetSpeed(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext.getType() == 1) {
        return 102400;
      }
      int i = paramContext.getSubtype();
      switch (i)
      {
      default: 
        return 102400;
      case 3: 
      case 4: 
      case 5: 
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
        return 102400;
      case 2: 
        return 8192;
      }
      return 4096;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return 102400;
  }
  
  public static boolean is2G(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext.getType() == 1) {
        return false;
      }
      if ((paramContext.getSubtype() != 2) && (paramContext.getSubtype() != 1))
      {
        int i = paramContext.getSubtype();
        if (i != 4) {}
      }
      else
      {
        return true;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean is3G(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext.getType() == 1) {
        return false;
      }
      if (paramContext.getSubtype() >= 5)
      {
        int i = paramContext.getSubtype();
        if (i < 13) {
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean is4G(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext.getType() == 1) {
        return false;
      }
      int i = paramContext.getSubtype();
      if (i >= 13) {
        return true;
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean isConnected(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    try
    {
      boolean bool = paramContext.isConnected();
      return bool;
    }
    catch (Exception paramContext)
    {
      label20:
      break label20;
    }
    return false;
  }
  
  public static boolean isImmediatelyDestroyActivities(Context paramContext)
  {
    paramContext = paramContext.getContentResolver();
    boolean bool = false;
    if (Settings.System.getInt(paramContext, "always_finish_activities", 0) != 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isKnownDirectNet(Context paramContext)
  {
    int i = getNetType(paramContext);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (6 != i)
    {
      bool1 = bool2;
      if (1 != i)
      {
        bool1 = bool2;
        if (4 != i)
        {
          bool1 = bool2;
          if (8 != i)
          {
            bool1 = bool2;
            if (10 != i)
            {
              if (i == 0) {
                return true;
              }
              bool1 = false;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean isLimited(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (paramInt != 2)
    {
      bool1 = bool2;
      if (paramInt != 1)
      {
        if (paramInt == 3) {
          return true;
        }
        bool1 = false;
      }
    }
    return bool1;
  }
  
  public static boolean isMobile(Context paramContext)
  {
    boolean bool = false;
    try
    {
      int i = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo().getType();
      if (i != 1) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  public static boolean isNetworkConnected(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    boolean bool = false;
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null) {
      return false;
    }
    if (paramContext.getState() == NetworkInfo.State.CONNECTED) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean isWap(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 5) || (paramInt == 7) || (paramInt == 3);
  }
  
  public static boolean isWap(Context paramContext)
  {
    return isWap(getNetType(paramContext));
  }
  
  public static boolean isWifi(int paramInt)
  {
    return paramInt == 0;
  }
  
  public static boolean isWifi(Context paramContext)
  {
    return isWifi(getNetType(paramContext));
  }
  
  private static Intent searchIntentByClass(Context paramContext, String paramString)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      List localList = localPackageManager.getInstalledPackages(0);
      if ((localList != null) && (localList.size() > 0))
      {
        int i = 0;
        for (;;)
        {
          int j = localList.size();
          if (i >= j) {
            break;
          }
          try
          {
            Object localObject1 = new Intent();
            ((Intent)localObject1).setPackage(((PackageInfo)localList.get(i)).packageName);
            Object localObject2 = localPackageManager.queryIntentActivities((Intent)localObject1, 0);
            if (localObject2 != null) {
              j = ((List)localObject2).size();
            } else {
              j = 0;
            }
            if (j > 0)
            {
              int k = 0;
              for (;;)
              {
                if (k < j) {
                  try
                  {
                    localObject1 = ((ResolveInfo)((List)localObject2).get(k)).activityInfo;
                    if (((ActivityInfo)localObject1).name.contains(paramString))
                    {
                      localObject2 = new Intent("/");
                      ((Intent)localObject2).setComponent(new ComponentName(((ActivityInfo)localObject1).packageName, ((ActivityInfo)localObject1).name));
                      ((Intent)localObject2).setAction("android.intent.action.VIEW");
                      paramContext.startActivity((Intent)localObject2);
                      return localObject2;
                    }
                    k += 1;
                  }
                  catch (Exception localException1)
                  {
                    localException1.printStackTrace();
                  }
                }
              }
            }
            i += 1;
          }
          catch (Exception localException2)
          {
            localException2.printStackTrace();
          }
        }
      }
      return null;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static void startSettingItent(Context paramContext, int paramInt)
  {
    if (paramInt != 0) {
      if (paramInt != 1) {
        if (paramInt != 2) {
          if (paramInt != 3) {
            return;
          }
        }
      }
    }
    try
    {
      localIntent = new Intent();
      localIntent.setAction("android.settings.WIFI_IP_SETTINGS");
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException1)
    {
      Intent localIntent;
      label42:
      break label42;
    }
    searchIntentByClass(paramContext, "AdvancedSettings");
    return;
    label137:
    label189:
    try
    {
      localIntent = new Intent("/");
      localIntent.setComponent(new ComponentName("com.android.providers.subscribedfeeds", "com.android.settings.ManageAccountsSettings"));
      localIntent.setAction("android.intent.action.VIEW");
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException2)
    {
      label94:
      break label94;
    }
    try
    {
      localIntent = new Intent("/");
      localIntent.setComponent(new ComponentName("com.htc.settings.accountsync", "com.htc.settings.accountsync.ManageAccountsSettings"));
      localIntent.setAction("android.intent.action.VIEW");
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException3)
    {
      break label137;
    }
    searchIntentByClass(paramContext, "ManageAccountsSettings");
    return;
    try
    {
      localIntent = new Intent("/");
      localIntent.setComponent(new ComponentName("com.android.settings", "com.android.settings.DevelopmentSettings"));
      localIntent.setAction("android.intent.action.VIEW");
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception localException4)
    {
      break label189;
    }
    searchIntentByClass(paramContext, "DevelopmentSettings");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mars.ilink.comm.NetStatusUtil
 * JD-Core Version:    0.7.0.1
 */