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
    Object localObject = this.mAdapter;
    if ((localObject != null) && (((NetworkStateAdapter)localObject).getLogger() != null))
    {
      localObject = this.mAdapter.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onNetWorkChange--close=");
      localStringBuilder.append(paramBoolean1);
      localStringBuilder.append(";isWifi=");
      localStringBuilder.append(paramBoolean2);
      ((LogInterface)localObject).i("networklog", localStringBuilder.toString(), new Object[0]);
    }
    localObject = this.networkListeners.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((OnNetworkListener)((Iterator)localObject).next()).onNetWorkChange(paramBoolean1, paramBoolean2);
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
    if (paramInt == 100) {
      this.networkConnected = false;
    } else {
      this.networkConnected = true;
    }
    switch (paramInt)
    {
    default: 
      return;
    case 102: 
      onNetWorkChange(false, false);
      return;
    case 101: 
      onNetWorkChange(false, true);
      return;
    }
    onNetWorkChange(true, false);
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
    Context localContext = this.mContext;
    if (localContext != null)
    {
      localContext.unregisterReceiver(this.mNetworkReceiver);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.network.NetworkService
 * JD-Core Version:    0.7.0.1
 */