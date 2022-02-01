package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;

class ARTransferPromotionRenderable$21
  implements Runnable
{
  ARTransferPromotionRenderable$21(ARTransferPromotionRenderable paramARTransferPromotionRenderable) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("zoomOutWorldCupSparks. hasDrawedFrame = ");
    localStringBuilder.append(ARTransferPromotionRenderable.C(this.this$0));
    QLog.i("ARTransferPromotionRenderable", 1, localStringBuilder.toString());
    if ((ARTransferPromotionRenderable.c(this.this$0) != null) && (ARTransferPromotionRenderable.C(this.this$0))) {
      ARTransferPromotionRenderable.c(this.this$0).native_zoomOutWorldCupSparks();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.21
 * JD-Core Version:    0.7.0.1
 */