package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper;
import com.tencent.qphone.base.util.QLog;

class ARTransferPromotionRenderable$1$1
  implements Runnable
{
  ARTransferPromotionRenderable$1$1(ARTransferPromotionRenderable.1 param1) {}
  
  public void run()
  {
    if ((ARTransferPromotionRenderable.a(this.a.this$0) != null) && (ARTransferPromotionRenderable.a(this.a.this$0).c()))
    {
      ARTransferPromotionRenderable.a(this.a.this$0).a();
      QLog.d("ARTransferPromotionRenderable", 2, "mRepeatCheckRunnable run ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.1.1
 * JD-Core Version:    0.7.0.1
 */