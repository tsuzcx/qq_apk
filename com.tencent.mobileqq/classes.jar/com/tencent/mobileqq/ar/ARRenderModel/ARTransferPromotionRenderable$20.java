package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;

class ARTransferPromotionRenderable$20
  implements Runnable
{
  ARTransferPromotionRenderable$20(ARTransferPromotionRenderable paramARTransferPromotionRenderable, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3) {}
  
  public void run()
  {
    ARTransferPromotionRenderable.b(this.this$0, ARTransferPromotionRenderable.f(this.this$0) + this.a.length);
    QLog.i("ARTransferPromotionRenderable", 1, "insertWorldCupSpark. mInsertedSparkTotalCnt = " + ARTransferPromotionRenderable.f(this.this$0) + ", new cnt = " + this.a.length + ", px[0] = " + this.a[0] + ", py[0] = " + this.b[0] + ", degree[0] = " + this.c[0] + ", hasDrawedFrame = " + ARTransferPromotionRenderable.e(this.this$0));
    if ((ARTransferPromotionRenderable.a(this.this$0) != null) && (ARTransferPromotionRenderable.e(this.this$0))) {
      ARTransferPromotionRenderable.a(this.this$0).native_insertWorldCupSpark(this.a, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.20
 * JD-Core Version:    0.7.0.1
 */