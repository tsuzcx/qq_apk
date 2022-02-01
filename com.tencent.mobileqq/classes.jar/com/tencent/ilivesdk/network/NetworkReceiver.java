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
    if (paramIntent == null) {
      return;
    }
    if (paramIntent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE"))
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      int j;
      if (paramContext == null) {
        j = -1;
      } else {
        j = paramContext.getType();
      }
      paramContext = new StringBuilder();
      paramContext.append("cur type: ");
      paramContext.append(j);
      paramContext.append(" last type: ");
      paramContext.append(lastType);
      paramContext.append(" cur hash code");
      paramContext.append(hashCode());
      Log.i("NetworkReceiver", paramContext.toString());
      if (lastType == j)
      {
        Log.e("NetworkReceiver", "same type, ignore!");
      }
      else
      {
        int i = 100;
        if (j != -1)
        {
          if (j != 0)
          {
            if (j == 1)
            {
              Log.e("NetworkReceiver", "wifi avaiable!");
              i = 101;
            }
          }
          else
          {
            Log.e("NetworkReceiver", "3G/4G avaiable!");
            i = 102;
          }
        }
        else {
          Log.e("NetworkReceiver", "network not avaiable!");
        }
        paramContext = this.onNetworkCallback;
        if (paramContext != null) {
          paramContext.handleNetwork(i);
        }
      }
      lastType = j;
      paramContext = new StringBuilder();
      paramContext.append("Last Type: ");
      paramContext.append(lastType);
      Log.e("NetworkReceiver", paramContext.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.network.NetworkReceiver
 * JD-Core Version:    0.7.0.1
 */