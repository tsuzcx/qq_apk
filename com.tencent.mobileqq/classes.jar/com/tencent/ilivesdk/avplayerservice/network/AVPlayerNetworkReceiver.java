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
      Log.i("AVPlayerNetworkReceiver", paramContext.toString());
      if (lastType == j)
      {
        Log.e("AVPlayerNetworkReceiver", "same type, ignore!");
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
              Log.e("AVPlayerNetworkReceiver", "wifi avaiable!");
              i = 101;
            }
          }
          else
          {
            Log.e("AVPlayerNetworkReceiver", "3G/4G avaiable!");
            i = 102;
          }
        }
        else {
          Log.e("AVPlayerNetworkReceiver", "network not avaiable!");
        }
        paramContext = this.onNetworkCallbackSet.iterator();
        while (paramContext.hasNext())
        {
          paramIntent = (AVPlayerNetworkReceiver.OnNetworkCallback)paramContext.next();
          if (paramIntent != null) {
            paramIntent.handleNetwork(i);
          }
        }
      }
      lastType = j;
      paramContext = new StringBuilder();
      paramContext.append("Last Type: ");
      paramContext.append(lastType);
      Log.e("AVPlayerNetworkReceiver", paramContext.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.network.AVPlayerNetworkReceiver
 * JD-Core Version:    0.7.0.1
 */