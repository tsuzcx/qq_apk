package com.tencent.imsdk.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.LinkAddress;
import android.net.LinkProperties;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import java.lang.ref.WeakReference;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.List;

public class NetworkInfoCenter
  extends BroadcastReceiver
{
  private static final int NETWORK_1xRTT = 107;
  private static final int NETWORK_2G3G = 2;
  private static final int NETWORK_CDMA = 104;
  private static final int NETWORK_CDMA1X = 98;
  private static final int NETWORK_DISCONNECT = 0;
  private static final int NETWORK_EDGE = 102;
  private static final int NETWORK_EHRPD = 114;
  private static final int NETWORK_EVDO_0 = 105;
  private static final int NETWORK_EVDO_A = 106;
  private static final int NETWORK_EVDO_B = 112;
  private static final int NETWORK_GPRS = 101;
  private static final int NETWORK_HSDPA = 108;
  private static final int NETWORK_HSPA = 110;
  private static final int NETWORK_HSPAP = 115;
  private static final int NETWORK_HSUPA = 109;
  private static final int NETWORK_IDEN = 111;
  private static final int NETWORK_LTE = 113;
  private static final int NETWORK_UMTS = 103;
  private static final int NETWORK_WCDMA = 99;
  private static final int NETWORK_WIFI = 1;
  private static final String TAG = "NetworkInfoCenter";
  final int IP_TYPE_IPV4_ONLY = 1;
  final int IP_TYPE_IPV6_DUAL = 3;
  final int IP_TYPE_IPV6_ONLY = 2;
  final int IP_TYPE_UNKNOWN = 0;
  private boolean isRegisterReceiver = false;
  private ConnectivityManager mConnectivityManager;
  private Context mContext;
  private int mIPType = 0;
  private WeakReference<NetworkInfoCenter.INetworkChangeListener> mListener;
  private boolean mNetworkConnected = false;
  private String mNetworkSSID;
  private int mNetworkType = 0;
  private String mServiceProvider;
  private TelephonyManager mTelephonyManager;
  private WifiManager mWifiManager;
  
  public static NetworkInfoCenter getInstance()
  {
    return NetworkInfoCenter.Holder.instance;
  }
  
  private String getProviderName()
  {
    return this.mServiceProvider;
  }
  
  private void onNetworkChanged(Context paramContext, Intent paramIntent)
  {
    paramContext = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("network changed, action: ");
    localStringBuilder.append(paramIntent.getAction());
    IMLog.i(paramContext, localStringBuilder.toString());
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction()))
    {
      if (this.mConnectivityManager == null) {
        this.mConnectivityManager = ((ConnectivityManager)this.mContext.getSystemService("connectivity"));
      }
      paramIntent = this.mConnectivityManager;
      if (paramIntent == null)
      {
        IMLog.e(TAG, "network changed, mConnectivityManager is null");
        return;
      }
      paramContext = null;
      try
      {
        paramIntent = paramIntent.getActiveNetworkInfo();
        paramContext = paramIntent;
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
      }
      if (paramContext != null)
      {
        if (paramContext.isConnected())
        {
          paramIntent = TAG;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("network connected type = ");
          localStringBuilder.append(paramContext.getType());
          localStringBuilder.append(", name = ");
          localStringBuilder.append(paramContext.getTypeName());
          IMLog.i(paramIntent, localStringBuilder.toString());
          this.mNetworkConnected = true;
        }
        else
        {
          IMLog.e(TAG, "network disconnected");
          this.mNetworkConnected = false;
        }
        updateNetworkType(paramContext);
        updateNetworkSSID();
        updateProviderName();
        paramIntent = TAG;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("current network: ");
        localStringBuilder.append(paramContext.toString());
        IMLog.i(paramIntent, localStringBuilder.toString());
      }
      else
      {
        this.mNetworkConnected = false;
        this.mNetworkType = 0;
        IMLog.e(TAG, "no network connection found");
      }
      updateIPType();
      paramContext = (NetworkInfoCenter.INetworkChangeListener)this.mListener.get();
      if (paramContext != null) {
        paramContext.onNetworkChange(this.mNetworkConnected, getNetworkType(), getIPType(), getNetworkID());
      }
    }
  }
  
  private void updateIPType()
  {
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    this.mIPType = 0;
    if (this.mConnectivityManager == null) {
      this.mConnectivityManager = ((ConnectivityManager)this.mContext.getSystemService("connectivity"));
    }
    Object localObject1 = this.mConnectivityManager;
    if (localObject1 == null)
    {
      IMLog.e(TAG, "updateIPType, mConnectivityManager is null");
      return;
    }
    try
    {
      localObject1 = ((ConnectivityManager)localObject1).getLinkProperties(((ConnectivityManager)localObject1).getActiveNetwork());
      if (localObject1 == null)
      {
        IMLog.i(TAG, "updateIPType, no linkProperties");
        return;
      }
      localObject1 = ((LinkProperties)localObject1).getLinkAddresses();
      Object localObject2 = TAG;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("linkAddresses:");
      ((StringBuilder)localObject3).append(((List)localObject1).size());
      IMLog.d((String)localObject2, ((StringBuilder)localObject3).toString());
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (LinkAddress)((Iterator)localObject1).next();
        localObject3 = ((LinkAddress)localObject2).getAddress();
        if (((localObject3 instanceof Inet4Address)) && (!((InetAddress)localObject3).isLinkLocalAddress()))
        {
          this.mIPType |= 0x1;
        }
        else
        {
          if ((!(localObject3 instanceof Inet6Address)) || (((InetAddress)localObject3).isLinkLocalAddress())) {
            continue;
          }
          this.mIPType |= 0x2;
        }
        localObject3 = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("linkAddresses|address:");
        localStringBuilder.append(((LinkAddress)localObject2).getAddress());
        IMLog.i((String)localObject3, localStringBuilder.toString());
      }
      String str;
      return;
    }
    catch (Exception localException)
    {
      localObject2 = TAG;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("updateIPType, e: ");
      ((StringBuilder)localObject3).append(localException.getLocalizedMessage());
      IMLog.w((String)localObject2, ((StringBuilder)localObject3).toString());
      localException.printStackTrace();
      str = TAG;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("updateIPType|type:");
      ((StringBuilder)localObject2).append(this.mIPType);
      IMLog.i(str, ((StringBuilder)localObject2).toString());
    }
  }
  
  private void updateNetworkSSID()
  {
    if (this.mWifiManager == null) {
      this.mWifiManager = ((WifiManager)this.mContext.getSystemService("wifi"));
    }
    Object localObject = this.mWifiManager;
    if (localObject != null)
    {
      localObject = NetworkMonitor.getConnectionInfo((WifiManager)localObject);
      if (localObject != null) {
        this.mNetworkSSID = ((WifiInfo)localObject).getSSID();
      }
    }
  }
  
  private void updateNetworkType(NetworkInfo paramNetworkInfo)
  {
    if ((paramNetworkInfo != null) && (paramNetworkInfo.isAvailable()))
    {
      if (this.mConnectivityManager == null) {
        this.mConnectivityManager = ((ConnectivityManager)this.mContext.getSystemService("connectivity"));
      }
      paramNetworkInfo = this.mConnectivityManager;
      if (paramNetworkInfo == null)
      {
        this.mNetworkType = 0;
        return;
      }
      paramNetworkInfo = paramNetworkInfo.getNetworkInfo(1);
      if (paramNetworkInfo != null)
      {
        paramNetworkInfo = paramNetworkInfo.getState();
        if ((paramNetworkInfo != null) && ((paramNetworkInfo == NetworkInfo.State.CONNECTED) || (paramNetworkInfo == NetworkInfo.State.CONNECTING)))
        {
          this.mNetworkType = 1;
          return;
        }
      }
      paramNetworkInfo = (TelephonyManager)this.mContext.getSystemService("phone");
      if (paramNetworkInfo == null)
      {
        this.mNetworkType = 0;
        return;
      }
      int i;
      try
      {
        i = paramNetworkInfo.getNetworkType();
      }
      catch (Exception paramNetworkInfo)
      {
        paramNetworkInfo.printStackTrace();
        String str = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getNetworkType:");
        localStringBuilder.append(paramNetworkInfo.getLocalizedMessage());
        IMLog.w(str, localStringBuilder.toString());
        i = 0;
      }
      switch (i)
      {
      default: 
        this.mNetworkType = 0;
        return;
      case 15: 
        this.mNetworkType = 115;
        return;
      case 14: 
        this.mNetworkType = 114;
        return;
      case 13: 
        this.mNetworkType = 113;
        return;
      case 12: 
        this.mNetworkType = 112;
        return;
      case 11: 
        this.mNetworkType = 111;
        return;
      case 10: 
        this.mNetworkType = 110;
        return;
      case 9: 
        this.mNetworkType = 109;
        return;
      case 8: 
        this.mNetworkType = 108;
        return;
      case 7: 
        this.mNetworkType = 107;
        return;
      case 6: 
        this.mNetworkType = 106;
        return;
      case 5: 
        this.mNetworkType = 105;
        return;
      case 4: 
        this.mNetworkType = 104;
        return;
      case 3: 
        this.mNetworkType = 103;
        return;
      case 2: 
        this.mNetworkType = 102;
        return;
      }
      this.mNetworkType = 101;
      return;
    }
    this.mNetworkType = 0;
  }
  
  private void updateProviderName()
  {
    if (this.mTelephonyManager == null) {
      this.mTelephonyManager = ((TelephonyManager)this.mContext.getSystemService("phone"));
    }
    TelephonyManager localTelephonyManager = this.mTelephonyManager;
    if (localTelephonyManager != null) {
      this.mServiceProvider = localTelephonyManager.getSimOperatorName();
    }
  }
  
  public int getIPType()
  {
    return this.mIPType;
  }
  
  public String getNetworkID()
  {
    int i = getNetworkType();
    if (1 == i)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(i);
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("_");
      localObject = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(getNetworkSSID());
      localObject = localStringBuilder.toString();
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(i);
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("_");
      localObject = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append(getProviderName());
      localObject = localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("_");
    Object localObject = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(getIPType());
    return localStringBuilder.toString();
  }
  
  public String getNetworkSSID()
  {
    return this.mNetworkSSID;
  }
  
  public int getNetworkType()
  {
    return this.mNetworkType;
  }
  
  public void init(Context paramContext, NetworkInfoCenter.INetworkChangeListener paramINetworkChangeListener)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mListener = new WeakReference(paramINetworkChangeListener);
    this.mConnectivityManager = ((ConnectivityManager)paramContext.getSystemService("connectivity"));
    paramINetworkChangeListener = this.mConnectivityManager;
    if (paramINetworkChangeListener != null)
    {
      paramContext = null;
      try
      {
        paramINetworkChangeListener = paramINetworkChangeListener.getActiveNetworkInfo();
        paramContext = paramINetworkChangeListener;
      }
      catch (Exception paramINetworkChangeListener)
      {
        paramINetworkChangeListener.printStackTrace();
      }
      updateNetworkType(paramContext);
    }
    updateNetworkSSID();
    updateProviderName();
    updateIPType();
  }
  
  public boolean isNetworkConnected()
  {
    if (this.mConnectivityManager == null)
    {
      localObject1 = this.mContext;
      if (localObject1 == null) {
        return false;
      }
      this.mConnectivityManager = ((ConnectivityManager)((Context)localObject1).getSystemService("connectivity"));
    }
    Object localObject2 = this.mConnectivityManager;
    if (localObject2 == null)
    {
      IMLog.e(TAG, "mNetworkConnected, mConnectivityManager is null");
      return false;
    }
    Object localObject1 = null;
    try
    {
      localObject2 = ((ConnectivityManager)localObject2).getActiveNetworkInfo();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (localObject1 != null) {
      return ((NetworkInfo)localObject1).isConnected();
    }
    IMLog.e(TAG, "mNetworkConnected, activeNetwork is null");
    return false;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      IMLog.e(TAG, "receive broadcast intent == null");
      return;
    }
    String str = paramIntent.getAction();
    if (str == null)
    {
      IMLog.e(TAG, "receive broadcast intent.getAction == null");
      return;
    }
    if ((str.equals("android.net.conn.CONNECTIVITY_CHANGE")) || (str.equals("android.net.wifi.STATE_CHANGE")) || (str.equals("android.net.wifi.WIFI_STATE_CHANGED"))) {
      onNetworkChanged(paramContext, paramIntent);
    }
  }
  
  public void registerNetworkReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    localIntentFilter.addAction("android.net.wifi.STATE_CHANGE");
    localIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    Context localContext = this.mContext;
    if (localContext != null)
    {
      localContext.getApplicationContext().registerReceiver(this, localIntentFilter);
      this.isRegisterReceiver = true;
    }
  }
  
  public void uninit()
  {
    if (this.isRegisterReceiver)
    {
      Context localContext = this.mContext;
      if (localContext != null)
      {
        localContext.getApplicationContext().unregisterReceiver(this);
        this.isRegisterReceiver = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.common.NetworkInfoCenter
 * JD-Core Version:    0.7.0.1
 */