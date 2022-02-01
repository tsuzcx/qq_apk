package com.tencent.livesdk.livesdkplayer.network;

import android.content.Context;
import android.content.IntentFilter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class NetWorkManager
  implements NetWorkReceiver.OnNetworkCallback
{
  private static NetWorkManager sInstance = null;
  private boolean isInit = false;
  private NetWorkReceiver netWorkReceiver;
  private Set<NetWorkReceiver.OnNetworkCallback> networkCallbacks = new HashSet();
  
  public static NetWorkManager getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new NetWorkManager();
      }
      return sInstance;
    }
    finally {}
  }
  
  private void initNetwork(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    this.netWorkReceiver = new NetWorkReceiver(paramContext);
    paramContext.registerReceiver(this.netWorkReceiver, localIntentFilter);
    this.netWorkReceiver.setNetworkCallback(this);
  }
  
  public void addNetWorkChangeCallback(NetWorkReceiver.OnNetworkCallback paramOnNetworkCallback)
  {
    this.networkCallbacks.add(paramOnNetworkCallback);
  }
  
  public void handleNetwork(int paramInt)
  {
    Iterator localIterator = this.networkCallbacks.iterator();
    while (localIterator.hasNext()) {
      ((NetWorkReceiver.OnNetworkCallback)localIterator.next()).handleNetwork(paramInt);
    }
  }
  
  public void init(Context paramContext)
  {
    if (this.isInit) {
      return;
    }
    initNetwork(paramContext);
    this.isInit = true;
  }
  
  public void removeNetWorkChangeCallback(NetWorkReceiver.OnNetworkCallback paramOnNetworkCallback)
  {
    this.networkCallbacks.remove(paramOnNetworkCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.network.NetWorkManager
 * JD-Core Version:    0.7.0.1
 */