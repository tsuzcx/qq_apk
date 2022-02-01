package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.ARPromotion.ARPromotionSoundPlayer;

class ARTransferPromotionRenderable$9
  implements Runnable
{
  ARTransferPromotionRenderable$9(ARTransferPromotionRenderable paramARTransferPromotionRenderable) {}
  
  public void run()
  {
    if ((ARTransferPromotionRenderable.g(this.this$0) != null) && (ARTransferPromotionRenderable.b(this.this$0) == 6))
    {
      ARPromotionSoundPlayer localARPromotionSoundPlayer = ARTransferPromotionRenderable.g(this.this$0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ARTransferPromotionRenderable.e(this.this$0).o);
      localStringBuilder.append("doorOpen.mp3");
      localARPromotionSoundPlayer.a(localStringBuilder.toString(), false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.9
 * JD-Core Version:    0.7.0.1
 */