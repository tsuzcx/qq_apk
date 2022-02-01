package com.tencent.ilivesdk.avplayerservice.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AVPlayerNetworkReceiver
  extends BroadcastReceiver
{
  static final String TAG = "AVPlayerNetworkReceiver";
  static int lastType = 65535;
  private Set<AVPlayerNetworkReceiver.OnNetworkCallback> onNetworkCallbackSet = new HashSet();
  
  public AVPlayerNetworkReceiver(Context paramContext)
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
    if (paramContext == null) {}
    for (int j = -1;; j = paramContext.getType())
    {
      Log.i("AVPlayerNetworkReceiver", "cur type: " + j + " last type: " + lastType + " cur hash code" + hashCode());
      if (lastType != j) {
        break;
      }
      Log.e("AVPlayerNetworkReceiver", "same type, ignore!");
      lastType = j;
      Log.e("AVPlayerNetworkReceiver", "Last Type: " + lastType);
      return;
    }
    int i;
    switch (j)
    {
    default: 
      i = 100;
    }
    for (;;)
    {
      paramContext = this.onNetworkCallbackSet.iterator();
      while (paramContext.hasNext())
      {
        paramIntent = (AVPlayerNetworkReceiver.OnNetworkCallback)paramContext.next();
        if (paramIntent != null) {
          paramIntent.handleNetwork(i);
        }
      }
      Log.e("AVPlayerNetworkReceiver", "network not avaiable!");
      i = 100;
      continue;
      Log.e("AVPlayerNetworkReceiver", "3G/4G avaiable!");
      i = 102;
      continue;
      Log.e("AVPlayerNetworkReceiver", "wifi avaiable!");
      i = 101;
    }
  }
  
  public void removeNetworkCallback(AVPlayerNetworkReceiver.OnNetworkCallback paramOnNetworkCallback)
  {
    this.onNetworkCallbackSet.remove(paramOnNetworkCallback);
  }
  
  public void setNetworkCallback(AVPlayerNetworkReceiver.OnNetworkCallback paramOnNetworkCallback)
  {
    this.onNetworkCallbackSet.add(paramOnNetworkCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.network.AVPlayerNetworkReceiver
 * JD-Core Version:    0.7.0.1
 */