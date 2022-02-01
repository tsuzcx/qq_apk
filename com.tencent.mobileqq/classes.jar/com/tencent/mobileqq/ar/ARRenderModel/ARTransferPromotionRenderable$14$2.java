package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;

class ARTransferPromotionRenderable$14$2
  implements Runnable
{
  ARTransferPromotionRenderable$14$2(ARTransferPromotionRenderable.14 param14) {}
  
  public void run()
  {
    if ((this.a.this$0.c != null) && (ARTransferPromotionRenderable.a(this.a.this$0) != null) && (ARTransferPromotionRenderable.a(this.a.this$0).c()))
    {
      long l = ARTransferPromotionRenderable.a(this.a.this$0).e();
      if (ARTransferPromotionRenderable.q(this.a.this$0) != null) {
        this.a.this$0.c.postDelayed(ARTransferPromotionRenderable.x(this.a.this$0), 4600L - l);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start Post  mRepeatCheckRunnable ");
      localStringBuilder.append(l);
      QLog.d("ARTransferPromotionRenderable", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.14.2
 * JD-Core Version:    0.7.0.1
 */