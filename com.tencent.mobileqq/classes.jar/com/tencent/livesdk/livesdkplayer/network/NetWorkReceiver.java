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
    int i;
    if (paramContext == null) {
      i = -1;
    } else {
      i = paramContext.getType();
    }
    lastType = i;
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
      Log.i("OpenSdk|NetWorkReceiver", paramContext.toString());
      if (lastType == j)
      {
        Log.e("OpenSdk|NetWorkReceiver", "same type, ignore!");
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
              Log.e("OpenSdk|NetWorkReceiver", "wifi avaiable!");
              i = 101;
            }
          }
          else
          {
            Log.e("OpenSdk|NetWorkReceiver", "3G/4G avaiable!");
            i = 102;
          }
        }
        else {
          Log.e("OpenSdk|NetWorkReceiver", "network not avaiable!");
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
      Log.e("OpenSdk|NetWorkReceiver", paramContext.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.livesdk.livesdkplayer.network.NetWorkReceiver
 * JD-Core Version:    0.7.0.1
 */