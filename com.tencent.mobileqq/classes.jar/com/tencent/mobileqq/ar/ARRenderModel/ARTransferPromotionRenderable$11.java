package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.ARPromotion.ARPromotionSoundPlayer;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager;

class ARTransferPromotionRenderable$11
  implements Runnable
{
  ARTransferPromotionRenderable$11(ARTransferPromotionRenderable paramARTransferPromotionRenderable) {}
  
  public void run()
  {
    if (ARTransferPromotionRenderable.b(this.this$0) == 6)
    {
      if ((ARTransferPromotionRenderable.d(this.this$0) != null) && (!ARTransferPromotionRenderable.e(this.this$0).i.booleanValue())) {
        ARTransferPromotionRenderable.d(this.this$0).b(0, 1);
      }
      if (((ARTransferPromotionRenderable.m(this.this$0).i() == 0) || (!ARTransferPromotionRenderable.t(this.this$0))) && (!ARTransferPromotionRenderable.e(this.this$0).i.booleanValue())) {
        this.this$0.f();
      } else if (!ARTransferPromotionRenderable.e(this.this$0).i.booleanValue()) {
        ARTransferPromotionRenderable.m(this.this$0).c(1);
      }
      if (ARTransferPromotionRenderable.g(this.this$0) == null) {
        ARTransferPromotionRenderable.a(this.this$0, new ARPromotionSoundPlayer());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.11
 * JD-Core Version:    0.7.0.1
 */