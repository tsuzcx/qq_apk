package com.tencent.ad.tangram.preorder;

import com.tencent.ad.tangram.util.AdScreenStatusManager.a;

class AdAppPreOrderManager$8
  implements AdScreenStatusManager.a
{
  AdAppPreOrderManager$8(AdAppPreOrderManager paramAdAppPreOrderManager) {}
  
  public void onScreenStatusChanged(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.this$0.runTasks();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.preorder.AdAppPreOrderManager.8
 * JD-Core Version:    0.7.0.1
 */