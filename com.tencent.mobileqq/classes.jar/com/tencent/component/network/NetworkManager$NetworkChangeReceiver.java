package com.tencent.component.network;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import com.tencent.component.network.downloader.GlobalHandlerThread;

public class NetworkManager$NetworkChangeReceiver
  extends BroadcastReceiver
{
  private String mApn = "none";
  private Context mContext;
  
  public NetworkManager$NetworkChangeReceiver(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public String getApn()
  {
    return this.mApn;
  }
  
  public String getApnValue()
  {
    NetworkInfo localNetworkInfo = null;
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)this.mContext.getSystemService("connectivity");
      if (localConnectivityManager != null) {
        localNetworkInfo = localConnectivityManager.getActiveNetworkInfo();
      }
      if ((localNetworkInfo != null) && (localNetworkInfo.isConnected()))
      {
        if (1 == localNetworkInfo.getType()) {
          return "wifi";
        }
        if (localNetworkInfo.getExtraInfo() != null) {
          return localNetworkInfo.getExtraInfo().toLowerCase();
        }
      }
      else
      {
        return "none";
      }
    }
    catch (Throwable localThrowable)
    {
      return "unknown";
    }
    return "unknown";
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction())) {
      GlobalHandlerThread.getInstance(paramContext).getHandler().post(new NetworkManager.NetworkChangeReceiver.1(this));
    }
  }
  
  public void setApn(String paramString)
  {
    this.mApn = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.NetworkManager.NetworkChangeReceiver
 * JD-Core Version:    0.7.0.1
 */