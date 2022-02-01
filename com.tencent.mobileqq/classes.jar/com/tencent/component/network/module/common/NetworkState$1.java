package com.tencent.component.network.module.common;

import android.content.Context;

class NetworkState$1
  implements Runnable
{
  NetworkState$1(NetworkState paramNetworkState, Context paramContext) {}
  
  public void run()
  {
    NetworkState.access$000(this.this$0, NetworkState.isNetworkConnected(this.val$context));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.module.common.NetworkState.1
 * JD-Core Version:    0.7.0.1
 */