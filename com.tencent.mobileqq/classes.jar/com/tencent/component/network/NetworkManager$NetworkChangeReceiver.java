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
    for (;;)
    {
      try
      {
        Object localObject1 = (ConnectivityManager)this.mContext.getSystemService("connectivity");
        if (localObject1 != null)
        {
          localObject1 = ((ConnectivityManager)localObject1).getActiveNetworkInfo();
          if ((localObject1 == null) || (!((NetworkInfo)localObject1).isConnected())) {
            break;
          }
          if (1 == ((NetworkInfo)localObject1).getType()) {
            return "wifi";
          }
          if (((NetworkInfo)localObject1).getExtraInfo() != null) {
            return ((NetworkInfo)localObject1).getExtraInfo().toLowerCase();
          }
          return "unknown";
        }
      }
      catch (Throwable localThrowable)
      {
        return "unknown";
      }
      Object localObject2 = null;
    }
    return "none";
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.network.NetworkManager.NetworkChangeReceiver
 * JD-Core Version:    0.7.0.1
 */