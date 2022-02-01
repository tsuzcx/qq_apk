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
    if ((this.a.this$0.a != null) && (ARTransferPromotionRenderable.a(this.a.this$0) != null) && (ARTransferPromotionRenderable.a(this.a.this$0).a()))
    {
      long l = ARTransferPromotionRenderable.a(this.a.this$0).a();
      if (ARTransferPromotionRenderable.a(this.a.this$0) != null) {
        this.a.this$0.a.postDelayed(ARTransferPromotionRenderable.a(this.a.this$0), 4600L - l);
      }
      QLog.d("ARTransferPromotionRenderable", 2, "start Post  mRepeatCheckRunnable " + l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.14.2
 * JD-Core Version:    0.7.0.1
 */