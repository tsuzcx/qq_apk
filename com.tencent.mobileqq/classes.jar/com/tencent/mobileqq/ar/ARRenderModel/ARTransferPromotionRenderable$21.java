package com.tencent.mobileqq.ar.ARRenderModel;

import aouh;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;

public class ARTransferPromotionRenderable$21
  implements Runnable
{
  public ARTransferPromotionRenderable$21(aouh paramaouh) {}
  
  public void run()
  {
    QLog.i("ARTransferPromotionRenderable", 1, "zoomOutWorldCupSparks. hasDrawedFrame = " + aouh.e(this.this$0));
    if ((aouh.a(this.this$0) != null) && (aouh.e(this.this$0))) {
      aouh.a(this.this$0).native_zoomOutWorldCupSparks();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.21
 * JD-Core Version:    0.7.0.1
 */