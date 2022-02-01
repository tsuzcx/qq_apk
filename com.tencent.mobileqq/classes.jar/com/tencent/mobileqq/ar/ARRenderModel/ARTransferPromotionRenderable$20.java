package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;

class ARTransferPromotionRenderable$20
  implements Runnable
{
  ARTransferPromotionRenderable$20(ARTransferPromotionRenderable paramARTransferPromotionRenderable, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    ARTransferPromotionRenderable.b((ARTransferPromotionRenderable)localObject, ARTransferPromotionRenderable.f((ARTransferPromotionRenderable)localObject) + this.a.length);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("insertWorldCupSpark. mInsertedSparkTotalCnt = ");
    ((StringBuilder)localObject).append(ARTransferPromotionRenderable.f(this.this$0));
    ((StringBuilder)localObject).append(", new cnt = ");
    ((StringBuilder)localObject).append(this.a.length);
    ((StringBuilder)localObject).append(", px[0] = ");
    ((StringBuilder)localObject).append(this.a[0]);
    ((StringBuilder)localObject).append(", py[0] = ");
    ((StringBuilder)localObject).append(this.b[0]);
    ((StringBuilder)localObject).append(", degree[0] = ");
    ((StringBuilder)localObject).append(this.c[0]);
    ((StringBuilder)localObject).append(", hasDrawedFrame = ");
    ((StringBuilder)localObject).append(ARTransferPromotionRenderable.e(this.this$0));
    QLog.i("ARTransferPromotionRenderable", 1, ((StringBuilder)localObject).toString());
    if ((ARTransferPromotionRenderable.a(this.this$0) != null) && (ARTransferPromotionRenderable.e(this.this$0))) {
      ARTransferPromotionRenderable.a(this.this$0).native_insertWorldCupSpark(this.a, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.20
 * JD-Core Version:    0.7.0.1
 */