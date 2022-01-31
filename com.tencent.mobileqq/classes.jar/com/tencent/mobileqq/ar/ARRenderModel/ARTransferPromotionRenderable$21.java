package com.tencent.mobileqq.ar.ARRenderModel;

import amrb;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;

public class ARTransferPromotionRenderable$21
  implements Runnable
{
  public ARTransferPromotionRenderable$21(amrb paramamrb) {}
  
  public void run()
  {
    QLog.i("ARTransferPromotionRenderable", 1, "zoomOutWorldCupSparks. hasDrawedFrame = " + amrb.e(this.this$0));
    if ((amrb.a(this.this$0) != null) && (amrb.e(this.this$0))) {
      amrb.a(this.this$0).native_zoomOutWorldCupSparks();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.21
 * JD-Core Version:    0.7.0.1
 */