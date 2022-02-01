package com.tencent.ad.tangram.preorder;

import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.util.AdLifecycleManager.a;

class AdAppPreOrderManager$10
  implements AdLifecycleManager.a
{
  AdAppPreOrderManager$10(AdAppPreOrderManager paramAdAppPreOrderManager) {}
  
  public void onBackground()
  {
    AdThreadManager.INSTANCE.post(new AdAppPreOrderManager.10.2(this), 5);
  }
  
  public void onForeground()
  {
    AdThreadManager.INSTANCE.post(new AdAppPreOrderManager.10.1(this), 5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdAppPreOrderManager.10
 * JD-Core Version:    0.7.0.1
 */