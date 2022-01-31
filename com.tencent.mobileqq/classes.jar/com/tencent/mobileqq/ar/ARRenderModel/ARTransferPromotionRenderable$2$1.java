package com.tencent.mobileqq.ar.ARRenderModel;

import akjn;
import akma;
import com.tencent.qphone.base.util.QLog;

class ARTransferPromotionRenderable$2$1
  implements Runnable
{
  ARTransferPromotionRenderable$2$1(ARTransferPromotionRenderable.2 param2) {}
  
  public void run()
  {
    if ((akma.a(this.a.this$0) != null) && (akma.a(this.a.this$0).a()))
    {
      akma.a(this.a.this$0).b();
      QLog.d("ARTransferPromotionRenderable", 2, "mRepeatCheckRunnable run ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.2.1
 * JD-Core Version:    0.7.0.1
 */