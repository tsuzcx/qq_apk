package com.tencent.component.network.module.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.component.network.utils.thread.PriorityThreadPool;

class NetworkStatus$1
  extends BroadcastReceiver
{
  NetworkStatus$1(NetworkStatus paramNetworkStatus) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent.getAction())) {
      PriorityThreadPool.getDefault().submit(new NetworkStatus.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.module.common.NetworkStatus.1
 * JD-Core Version:    0.7.0.1
 */