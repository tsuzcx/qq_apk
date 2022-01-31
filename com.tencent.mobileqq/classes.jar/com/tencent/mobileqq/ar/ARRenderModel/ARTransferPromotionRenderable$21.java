package com.tencent.mobileqq.ar.ARRenderModel;

import akma;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;

public class ARTransferPromotionRenderable$21
  implements Runnable
{
  public ARTransferPromotionRenderable$21(akma paramakma) {}
  
  public void run()
  {
    QLog.i("ARTransferPromotionRenderable", 1, "zoomOutWorldCupSparks. hasDrawedFrame = " + akma.e(this.this$0));
    if ((akma.a(this.this$0) != null) && (akma.e(this.this$0))) {
      akma.a(this.this$0).native_zoomOutWorldCupSparks();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.21
 * JD-Core Version:    0.7.0.1
 */