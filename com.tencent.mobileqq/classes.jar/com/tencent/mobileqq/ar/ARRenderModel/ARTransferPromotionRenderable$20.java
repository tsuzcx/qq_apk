package com.tencent.mobileqq.ar.ARRenderModel;

import alal;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;

public class ARTransferPromotionRenderable$20
  implements Runnable
{
  public ARTransferPromotionRenderable$20(alal paramalal, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3) {}
  
  public void run()
  {
    alal.a(this.this$0, alal.e(this.this$0) + this.a.length);
    QLog.i("ARTransferPromotionRenderable", 1, "insertWorldCupSpark. mInsertedSparkTotalCnt = " + alal.e(this.this$0) + ", new cnt = " + this.a.length + ", px[0] = " + this.a[0] + ", py[0] = " + this.b[0] + ", degree[0] = " + this.c[0] + ", hasDrawedFrame = " + alal.e(this.this$0));
    if ((alal.a(this.this$0) != null) && (alal.e(this.this$0))) {
      alal.a(this.this$0).native_insertWorldCupSpark(this.a, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.20
 * JD-Core Version:    0.7.0.1
 */