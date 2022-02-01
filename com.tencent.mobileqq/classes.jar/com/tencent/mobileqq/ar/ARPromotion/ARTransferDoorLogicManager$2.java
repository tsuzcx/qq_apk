package com.tencent.mobileqq.ar.ARPromotion;

import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult;
import com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult.ARCircleResult;

class ARTransferDoorLogicManager$2
  implements Runnable
{
  ARTransferDoorLogicManager$2(ARTransferDoorLogicManager paramARTransferDoorLogicManager) {}
  
  public void run()
  {
    if (ARTransferDoorLogicManager.a(this.this$0).c.a == 0) {
      this.this$0.c(5);
    } else if (ARTransferDoorLogicManager.a(this.this$0).c.e == 0) {
      this.this$0.g();
    }
    ARTransferDoorLogicManager.a(this.this$0, 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager.2
 * JD-Core Version:    0.7.0.1
 */