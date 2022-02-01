package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;

class ARTransferPromotionRenderable$19
  implements Runnable
{
  ARTransferPromotionRenderable$19(ARTransferPromotionRenderable paramARTransferPromotionRenderable, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    ARTransferPromotionRenderable.b(this.this$0, 0);
    QLog.i("ARTransferPromotionRenderable", 1, "setRecogRes. mInsertedSparkTotalCnt = 0, sparkShaderVertFileName = , circleR = " + this.a + ", circleX = " + this.b + ", circleY = " + this.c + ", clockwise = " + this.d + ", hasDrawedFrame = " + ARTransferPromotionRenderable.e(this.this$0));
    if ((ARTransferPromotionRenderable.a(this.this$0) != null) && (ARTransferPromotionRenderable.e(this.this$0))) {
      ARTransferPromotionRenderable.a(this.this$0).native_setRecogRes("", "", "", "", "", this.a, this.b, this.c, this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.19
 * JD-Core Version:    0.7.0.1
 */