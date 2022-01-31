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
    if (sNetworkChangeReceiver == null) {}
    while ("none" != "none") {
      return "none";
    }
    return sNetworkChangeReceiver.getApnValue();
  }
  
  public static String getBSSID()
  {
    try
    {
      Object localObject = ((WifiManager)mContext.getSystemService("wifi")).getConnectionInfo();
      if (localObject != null)
      {
        localObject = ((WifiInfo)localObject).getBSSID();
        return localObject;
      }
      return null;
    }
    catch (Throwable localThrowable) {}
    return null;
  }
  
  public static int getISPType(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    if ((paramString.contains("cmnet")) || (paramString.contains("cmwap")) || (paramString.contains("cmcc"))) {
      return 1;
    }
    if ((paramString.contains("uninet")) || (paramString.contains("uniwap")) || (paramString.contains("unicom")) || (paramString.contains("3gnet")) || (paramString.contains("3gwap"))) {
      return 2;
    }
    if ((paramString.contains("ctwap")) || (paramString.contains("ctnet")) || (paramString.contains("cmct")) || (paramString.contains("#777"))) {
      return 3;
    }
    return getOperator();
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
    for (;;)
    {
      try
      {
        Object localObject1 = (ConnectivityManager)mContext.getSystemService("connectivity");
        if (localObject1 == null) {
          break label49;
        }
        localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
        if ((localObject1 == null) || (!((NetworkInfo)localObject1).isConnected())) {
          break;
        }
        int i = ((NetworkInfo)localObject1).getType();
        if (i == 0) {
          return true;
        }
      }
      catch (Throwable localThrowable) {}
      return false;
      label49:
      Object localObject2 = null;
    }
    return false;
  }
  
  public static boolean isNetworkAvailable()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (ConnectivityManager)mContext.getSystemService("connectivity");
        if (localObject1 != null)
        {
          localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
          boolean bool;
          if (localObject1 != null) {
            bool = ((NetworkInfo)localObject1).isConnected();
          }
          return bool;
        }
      }
      catch (Throwable localThrowable)
      {
        return true;
      }
      Object localObject2 = null;
    }
  }
  
  public static boolean isWap()
  {
    String str = getApnValue();
    if (TextUtils.isEmpty(str)) {}
    while ((!str.contains("cmwap")) && (!str.contains("uniwap")) && (!str.contains("3gwap")) && (!str.contains("ctwap"))) {
      return false;
    }
    return true;
  }
  
  public static boolean isWifi()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = (ConnectivityManager)mContext.getSystemService("connectivity");
        if (localObject1 != null)
        {
          localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
          if (localObject1 == null) {
            break;
          }
          if (!((NetworkInfo)localObject1).isConnected()) {
            return false;
          }
          int i = ((NetworkInfo)localObject1).getType();
          if (1 == i)
          {
            bool = true;
            return bool;
          }
          boolean bool = false;
          continue;
        }
        Object localObject2 = null;
      }
      catch (Throwable localThrowable)
      {
        return false;
      }
    }
    return false;
  }
  
  public static void registNetStatusListener(NetworkManager.NetStatusListener arg0)
  {
    WeakReference localWeakReference = new WeakReference(???);
    if (localWeakReference != null) {
      synchronized (LOCK_NETLSTENER)
      {
        mNetworkListener.add(localWeakReference);
        return;
      }
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.NetworkManager
 * JD-Core Version:    0.7.0.1
 */