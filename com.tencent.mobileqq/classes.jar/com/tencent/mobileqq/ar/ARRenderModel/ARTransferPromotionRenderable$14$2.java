package com.tencent.mobileqq.ar.ARRenderModel;

import akxz;
import alam;
import bfmt;
import com.tencent.qphone.base.util.QLog;

class ARTransferPromotionRenderable$14$2
  implements Runnable
{
  ARTransferPromotionRenderable$14$2(ARTransferPromotionRenderable.14 param14) {}
  
  public void run()
  {
    if ((this.a.this$0.a != null) && (alam.a(this.a.this$0) != null) && (alam.a(this.a.this$0).a()))
    {
      long l = alam.a(this.a.this$0).a();
      if (alam.a(this.a.this$0) != null) {
        this.a.this$0.a.postDelayed(alam.a(this.a.this$0), 4600L - l);
      }
      QLog.d("ARTransferPromotionRenderable", 2, "start Post  mRepeatCheckRunnable " + l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.14.2
 * JD-Core Version:    0.7.0.1
 */