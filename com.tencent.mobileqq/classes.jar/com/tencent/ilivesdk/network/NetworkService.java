package com.tencent.ilivesdk.network;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.base.libapi.network.NetworkStateAdapter;
import com.tencent.falco.base.libapi.network.NetworkStateInterface;
import com.tencent.falco.base.libapi.network.OnNetworkListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class NetworkService
  implements NetworkStateInterface, NetworkReceiver.OnNetworkCallback
{
  static final String TAG = "networklog";
  private NetworkStateAdapter mAdapter;
  private Context mContext;
  private NetworkReceiver mNetworkReceiver;
  boolean networkConnected = true;
  private Set<OnNetworkListener> networkListeners = new HashSet();
  
  private void onNetWorkChange(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.mAdapter != null) && (this.mAdapter.getLogger() != null)) {
      this.mAdapter.getLogger().i("networklog", "onNetWorkChange--close=" + paramBoolean1 + ";isWifi=" + paramBoolean2, new Object[0]);
    }
    Iterator localIterator = this.networkListeners.iterator();
    while (localIterator.hasNext()) {
      ((OnNetworkListener)localIterator.next()).onNetWorkChange(paramBoolean1, paramBoolean2);
    }
  }
  
  public void addListener(OnNetworkListener paramOnNetworkListener)
  {
    this.networkListeners.add(paramOnNetworkListener);
  }
  
  public void clearEventOutput()
  {
    this.networkListeners.clear();
  }
  
  public void handleNetwork(int paramInt)
  {
    if (paramInt == 100) {}
    for (this.networkConnected = false;; this.networkConnected = true) {
      switch (paramInt)
      {
      default: 
        return;
      }
    }
    onNetWorkChange(true, false);
    return;
    onNetWorkChange(false, false);
    return;
    onNetWorkChange(false, true);
  }
  
  public void init(NetworkStateAdapter paramNetworkStateAdapter)
  {
    this.mAdapter = paramNetworkStateAdapter;
  }
  
  public void onCreate(Context paramContext)
  {
    this.mContext = paramContext;
    this.networkListeners.clear();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    this.mNetworkReceiver = new NetworkReceiver(this);
    paramContext.registerReceiver(this.mNetworkReceiver, localIntentFilter);
  }
  
  public void onDestroy()
  {
    if (this.mContext != null)
    {
      this.mContext.unregisterReceiver(this.mNetworkReceiver);
      this.mContext = null;
    }
    this.networkListeners.clear();
    this.mNetworkReceiver = null;
  }
  
  public void removeListener(OnNetworkListener paramOnNetworkListener)
  {
    this.networkListeners.remove(paramOnNetworkListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.network.NetworkService
 * JD-Core Version:    0.7.0.1
 */