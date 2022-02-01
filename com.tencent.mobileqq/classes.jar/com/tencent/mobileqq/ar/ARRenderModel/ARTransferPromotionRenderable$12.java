package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper;

class ARTransferPromotionRenderable$12
  implements Runnable
{
  ARTransferPromotionRenderable$12(ARTransferPromotionRenderable paramARTransferPromotionRenderable) {}
  
  public void run()
  {
    if (!ARTransferPromotionRenderable.e(this.this$0).i.booleanValue())
    {
      ARTransferPromotionRenderable localARTransferPromotionRenderable = this.this$0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ARTransferPromotionRenderable.e(this.this$0).o);
      localStringBuilder.append("360Video.mp4");
      ARTransferPromotionRenderable.a(localARTransferPromotionRenderable, 3, localStringBuilder.toString(), false, ARTransferPromotionRenderable.e(this.this$0).k, false);
      ARTransferPromotionRenderable.a(this.this$0).a(true);
      ARTransferPromotionRenderable.u(this.this$0);
      ARTransferPromotionRenderable.v(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.12
 * JD-Core Version:    0.7.0.1
 */