package com.tencent.ilivesdk.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkReceiver
  extends BroadcastReceiver
{
  static final String TAG = "NetworkReceiver";
  static int lastType = 65535;
  private NetworkReceiver.OnNetworkCallback onNetworkCallback;
  
  public NetworkReceiver(NetworkReceiver.OnNetworkCallback paramOnNetworkCallback)
  {
    this.onNetworkCallback = paramOnNetworkCallback;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null) {}
    while (!paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
      return;
    }
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    int j;
    if (paramContext == null)
    {
      j = -1;
      Log.i("NetworkReceiver", "cur type: " + j + " last type: " + lastType + " cur hash code" + hashCode());
      if (lastType != j) {
        break label144;
      }
      Log.e("NetworkReceiver", "same type, ignore!");
    }
    label144:
    label233:
    for (;;)
    {
      lastType = j;
      Log.e("NetworkReceiver", "Last Type: " + lastType);
      return;
      j = paramContext.getType();
      break;
      int i = 100;
      switch (j)
      {
      }
      for (;;)
      {
        if (this.onNetworkCallback == null) {
          break label233;
        }
        this.onNetworkCallback.handleNetwork(i);
        break;
        Log.e("NetworkReceiver", "network not avaiable!");
        continue;
        Log.e("NetworkReceiver", "3G/4G avaiable!");
        i = 102;
        continue;
        Log.e("NetworkReceiver", "wifi avaiable!");
        i = 101;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.network.NetworkReceiver
 * JD-Core Version:    0.7.0.1
 */