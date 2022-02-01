package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;

class DefaultConnectivityMonitor$1
  extends BroadcastReceiver
{
  DefaultConnectivityMonitor$1(DefaultConnectivityMonitor paramDefaultConnectivityMonitor) {}
  
  public void onReceive(@NonNull Context paramContext, Intent paramIntent)
  {
    boolean bool = this.a.b;
    paramIntent = this.a;
    paramIntent.b = paramIntent.a(paramContext);
    if (bool != this.a.b)
    {
      if (Log.isLoggable("ConnectivityMonitor", 3))
      {
        paramContext = new StringBuilder();
        paramContext.append("connectivity changed, isConnected: ");
        paramContext.append(this.a.b);
        Log.d("ConnectivityMonitor", paramContext.toString());
      }
      this.a.a.a(this.a.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.manager.DefaultConnectivityMonitor.1
 * JD-Core Version:    0.7.0.1
 */