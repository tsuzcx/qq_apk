package com.tencent.mobileqq.ar.ARRenderModel;

import amvq;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;

public class ARTransferPromotionRenderable$21
  implements Runnable
{
  public ARTransferPromotionRenderable$21(amvq paramamvq) {}
  
  public void run()
  {
    QLog.i("ARTransferPromotionRenderable", 1, "zoomOutWorldCupSparks. hasDrawedFrame = " + amvq.e(this.this$0));
    if ((amvq.a(this.this$0) != null) && (amvq.e(this.this$0))) {
      amvq.a(this.this$0).native_zoomOutWorldCupSparks();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.21
 * JD-Core Version:    0.7.0.1
 */