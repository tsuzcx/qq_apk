package com.tencent.ad.tangram.preorder;

import com.tencent.ad.tangram.net.AdConnectivityManager.Listener;
import com.tencent.ad.tangram.thread.AdThreadManager;

class AdAppPreOrderManager$9
  implements AdConnectivityManager.Listener
{
  AdAppPreOrderManager$9(AdAppPreOrderManager paramAdAppPreOrderManager) {}
  
  public void onConnectivityChange(boolean paramBoolean, int paramInt)
  {
    AdThreadManager.INSTANCE.post(new AdAppPreOrderManager.9.1(this), 5);
    if (paramBoolean) {
      this.this$0.runTasks();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdAppPreOrderManager.9
 * JD-Core Version:    0.7.0.1
 */