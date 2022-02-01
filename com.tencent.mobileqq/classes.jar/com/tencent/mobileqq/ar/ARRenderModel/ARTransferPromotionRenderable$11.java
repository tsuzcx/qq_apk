package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.ARPromotion.ARPromotionSoundPlayer;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager;

class ARTransferPromotionRenderable$11
  implements Runnable
{
  ARTransferPromotionRenderable$11(ARTransferPromotionRenderable paramARTransferPromotionRenderable) {}
  
  public void run()
  {
    if (ARTransferPromotionRenderable.a(this.this$0) == 6)
    {
      if ((ARTransferPromotionRenderable.a(this.this$0) != null) && (!ARTransferPromotionRenderable.a(this.this$0).a.booleanValue())) {
        ARTransferPromotionRenderable.a(this.this$0).b(0, 1);
      }
      if (((ARTransferPromotionRenderable.a(this.this$0).a() == 0) || (!ARTransferPromotionRenderable.c(this.this$0))) && (!ARTransferPromotionRenderable.a(this.this$0).a.booleanValue())) {
        this.this$0.a();
      } else if (!ARTransferPromotionRenderable.a(this.this$0).a.booleanValue()) {
        ARTransferPromotionRenderable.a(this.this$0).c(1);
      }
      if (ARTransferPromotionRenderable.a(this.this$0) == null) {
        ARTransferPromotionRenderable.a(this.this$0, new ARPromotionSoundPlayer());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.11
 * JD-Core Version:    0.7.0.1
 */