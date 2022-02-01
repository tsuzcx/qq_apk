package com.tencent.livesdk.livesdkplayer.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetWorkReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "OpenSdk|NetWorkReceiver";
  private static int lastType = 65535;
  private NetWorkReceiver.OnNetworkCallback onNetworkCallback;
  
  public NetWorkReceiver(Context paramContext)
  {
    paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
    if (paramContext == null) {}
    for (int i = -1;; i = paramContext.getType())
    {
      lastType = i;
      return;
    }
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
      Log.i("OpenSdk|NetWorkReceiver", "cur type: " + j + " last type: " + lastType + " cur hash code" + hashCode());
      if (lastType != j) {
        break label144;
      }
      Log.e("OpenSdk|NetWorkReceiver", "same type, ignore!");
    }
    label144:
    label233:
    for (;;)
    {
      lastType = j;
      Log.e("OpenSdk|NetWorkReceiver", "Last Type: " + lastType);
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
        Log.e("OpenSdk|NetWorkReceiver", "network not avaiable!");
        continue;
        Log.e("OpenSdk|NetWorkReceiver", "3G/4G avaiable!");
        i = 102;
        continue;
        Log.e("OpenSdk|NetWorkReceiver", "wifi avaiable!");
        i = 101;
      }
    }
  }
  
  public void removeNetworkCallback()
  {
    this.onNetworkCallback = null;
  }
  
  public void setNetworkCallback(NetWorkReceiver.OnNetworkCallback paramOnNetworkCallback)
  {
    this.onNetworkCallback = paramOnNetworkCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.network.NetWorkReceiver
 * JD-Core Version:    0.7.0.1
 */