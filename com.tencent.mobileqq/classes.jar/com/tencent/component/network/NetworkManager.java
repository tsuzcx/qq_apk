package com.tencent.component.network;

import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.tencent.component.network.module.base.Config;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class NetworkManager
{
  private static Object LOCK_NETLSTENER = new Object();
  public static final int Operator_CMCC = 1;
  public static final int Operator_CMCT = 3;
  public static final int Operator_Unicom = 2;
  public static final int Operator_Unknown = 0;
  public static final int Operator_WIFI = 4;
  private static Context mContext;
  private static List<WeakReference<NetworkManager.NetStatusListener>> mNetworkListener = Collections.synchronizedList(new ArrayList());
  private static NetworkManager.NetworkChangeReceiver sNetworkChangeReceiver;
  
  public static String getApnValue()
  {
    NetworkManager.NetworkChangeReceiver localNetworkChangeReceiver = sNetworkChangeReceiver;
    if (localNetworkChangeReceiver == null) {
      return "none";
    }
    return localNetworkChangeReceiver.getApnValue();
  }
  
  public static String getBSSID()
  {
    String str = null;
    try
    {
      WifiInfo localWifiInfo = NetworkMonitor.getConnectionInfo((WifiManager)mContext.getSystemService("wifi"));
      if (localWifiInfo != null) {
        str = localWifiInfo.getBSSID();
      }
      return str;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static int getISPType(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    if ((!paramString.contains("cmnet")) && (!paramString.contains("cmwap")) && (!paramString.contains("cmcc")))
    {
      if ((!paramString.contains("uninet")) && (!paramString.contains("uniwap")) && (!paramString.contains("unicom")) && (!paramString.contains("3gnet")) && (!paramString.contains("3gwap")))
      {
        if ((!paramString.contains("ctwap")) && (!paramString.contains("ctnet")) && (!paramString.contains("cmct")) && (!paramString.contains("#777"))) {
          return getOperator();
        }
        return 3;
      }
      return 2;
    }
    return 1;
  }
  
  public static int getIspType()
  {
    return getISPType(getApnValue());
  }
  
  private static int getOperator()
  {
    return Config.getOperator();
  }
  
  public static void init(Context paramContext)
  {
    if (mContext != null) {
      return;
    }
    mContext = paramContext;
    try
    {
      sNetworkChangeReceiver = new NetworkManager.NetworkChangeReceiver(paramContext);
      IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
      paramContext.registerReceiver(sNetworkChangeReceiver, localIntentFilter);
      return;
    }
    catch (Exception paramContext)
    {
      QDLog.e("NetworkManager", "downloader register NetworkChangeReceiver failed!", paramContext);
    }
  }
  
  public static boolean isMobile()
  {
    NetworkInfo localNetworkInfo = null;
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)mContext.getSystemService("connectivity");
      if (localConnectivityManager != null) {
        localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      }
      if (localNetworkInfo != null)
      {
        if (!localNetworkInfo.isConnected()) {
          return false;
        }
        int i = localNetworkInfo.getType();
        if (i == 0) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static boolean isNetworkAvailable()
  {
    NetworkInfo localNetworkInfo = null;
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)mContext.getSystemService("connectivity");
      if (localConnectivityManager != null) {
        localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      }
      if (localNetworkInfo != null)
      {
        boolean bool = localNetworkInfo.isConnected();
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (Throwable localThrowable) {}
    return true;
  }
  
  public static boolean isWap()
  {
    String str = getApnValue();
    if (TextUtils.isEmpty(str)) {
      return false;
    }
    return (str.contains("cmwap")) || (str.contains("uniwap")) || (str.contains("3gwap")) || (str.contains("ctwap"));
  }
  
  public static boolean isWifi()
  {
    NetworkInfo localNetworkInfo = null;
    boolean bool2 = false;
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)mContext.getSystemService("connectivity");
      if (localConnectivityManager != null) {
        localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      }
      boolean bool1 = bool2;
      if (localNetworkInfo != null)
      {
        if (!localNetworkInfo.isConnected()) {
          return false;
        }
        int i = localNetworkInfo.getType();
        bool1 = bool2;
        if (1 == i) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static void registNetStatusListener(NetworkManager.NetStatusListener arg0)
  {
    WeakReference localWeakReference = new WeakReference(???);
    synchronized (LOCK_NETLSTENER)
    {
      mNetworkListener.add(localWeakReference);
      return;
    }
  }
  
  public static void unregistNetStatusListener(NetworkManager.NetStatusListener paramNetStatusListener)
  {
    synchronized (LOCK_NETLSTENER)
    {
      Iterator localIterator = new ArrayList(mNetworkListener).iterator();
      while (localIterator.hasNext())
      {
        WeakReference localWeakReference = (WeakReference)localIterator.next();
        if ((NetworkManager.NetStatusListener)localWeakReference.get() == paramNetStatusListener) {
          mNetworkListener.remove(localWeakReference);
        }
      }
      return;
    }
    for (;;)
    {
      throw paramNetStatusListener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.NetworkManager
 * JD-Core Version:    0.7.0.1
 */