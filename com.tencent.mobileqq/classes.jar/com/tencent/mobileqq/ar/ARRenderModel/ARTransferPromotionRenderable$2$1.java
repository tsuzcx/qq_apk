package com.tencent.mobileqq.ar.ARRenderModel;

import amtd;
import amvq;
import com.tencent.qphone.base.util.QLog;

class ARTransferPromotionRenderable$2$1
  implements Runnable
{
  ARTransferPromotionRenderable$2$1(ARTransferPromotionRenderable.2 param2) {}
  
  public void run()
  {
    if ((amvq.a(this.a.this$0) != null) && (amvq.a(this.a.this$0).a()))
    {
      amvq.a(this.a.this$0).a();
      QLog.d("ARTransferPromotionRenderable", 2, "mRepeatCheckRunnable run ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.2.1
 * JD-Core Version:    0.7.0.1
 */