package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorVideoInfo;
import com.tencent.qphone.base.util.QLog;

class ARTransferPromotionRenderable$3
  implements Runnable
{
  ARTransferPromotionRenderable$3(ARTransferPromotionRenderable paramARTransferPromotionRenderable) {}
  
  public void run()
  {
    ARTransferPromotionRenderable.a(this.this$0, ARTransferDoorVideoInfo.a(ARTransferPromotionRenderable.a(this.this$0).c));
    if (ARTransferPromotionRenderable.a(this.this$0) != null)
    {
      QLog.d("ARTransferPromotionRenderable", 2, "ARTransferPromotionRenderable finish parse ARTransferDoorVideoInfo " + ARTransferPromotionRenderable.a(this.this$0));
      return;
    }
    QLog.d("ARTransferPromotionRenderable", 1, "ARTransferPromotionRenderable finish parse ARTransferDoorVideoInfo value null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.3
 * JD-Core Version:    0.7.0.1
 */