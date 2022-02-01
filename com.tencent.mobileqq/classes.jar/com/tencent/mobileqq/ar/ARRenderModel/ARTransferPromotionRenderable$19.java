package com.tencent.mobileqq.ar.ARRenderModel;

import aouh;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;

public class ARTransferPromotionRenderable$19
  implements Runnable
{
  public ARTransferPromotionRenderable$19(aouh paramaouh, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    aouh.b(this.this$0, 0);
    QLog.i("ARTransferPromotionRenderable", 1, "setRecogRes. mInsertedSparkTotalCnt = 0, sparkShaderVertFileName = , circleR = " + this.a + ", circleX = " + this.b + ", circleY = " + this.c + ", clockwise = " + this.d + ", hasDrawedFrame = " + aouh.e(this.this$0));
    if ((aouh.a(this.this$0) != null) && (aouh.e(this.this$0))) {
      aouh.a(this.this$0).native_setRecogRes("", "", "", "", "", this.a, this.b, this.c, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.19
 * JD-Core Version:    0.7.0.1
 */