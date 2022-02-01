package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorVideoInfo;
import com.tencent.qphone.base.util.QLog;

class ARTransferPromotionRenderable$3
  implements Runnable
{
  ARTransferPromotionRenderable$3(ARTransferPromotionRenderable paramARTransferPromotionRenderable) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    ARTransferPromotionRenderable.a((ARTransferPromotionRenderable)localObject, ARTransferDoorVideoInfo.a(ARTransferPromotionRenderable.e((ARTransferPromotionRenderable)localObject).o));
    if (ARTransferPromotionRenderable.f(this.this$0) != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ARTransferPromotionRenderable finish parse ARTransferDoorVideoInfo ");
      ((StringBuilder)localObject).append(ARTransferPromotionRenderable.f(this.this$0));
      QLog.d("ARTransferPromotionRenderable", 2, ((StringBuilder)localObject).toString());
      return;
    }
    QLog.d("ARTransferPromotionRenderable", 1, "ARTransferPromotionRenderable finish parse ARTransferDoorVideoInfo value null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.3
 * JD-Core Version:    0.7.0.1
 */