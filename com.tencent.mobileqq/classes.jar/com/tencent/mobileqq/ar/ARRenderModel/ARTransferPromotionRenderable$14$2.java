package com.tencent.mobileqq.ar.ARRenderModel;

import apfk;
import aphx;
import blha;
import com.tencent.qphone.base.util.QLog;

class ARTransferPromotionRenderable$14$2
  implements Runnable
{
  ARTransferPromotionRenderable$14$2(ARTransferPromotionRenderable.14 param14) {}
  
  public void run()
  {
    if ((this.a.this$0.a != null) && (aphx.a(this.a.this$0) != null) && (aphx.a(this.a.this$0).a()))
    {
      long l = aphx.a(this.a.this$0).a();
      if (aphx.a(this.a.this$0) != null) {
        this.a.this$0.a.postDelayed(aphx.a(this.a.this$0), 4600L - l);
      }
      QLog.d("ARTransferPromotionRenderable", 2, "start Post  mRepeatCheckRunnable " + l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.14.2
 * JD-Core Version:    0.7.0.1
 */