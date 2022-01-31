package com.tencent.mobileqq.ar.ARRenderModel;

import amow;
import amrb;
import amrd;
import com.tencent.qphone.base.util.QLog;

public class ARTransferPromotionRenderable$4
  implements Runnable
{
  public ARTransferPromotionRenderable$4(amrb paramamrb) {}
  
  public void run()
  {
    amrb.a(this.this$0, amow.a(amrb.a(this.this$0).c));
    if (amrb.a(this.this$0) != null)
    {
      QLog.d("ARTransferPromotionRenderable", 2, "ARTransferPromotionRenderable finish parse ARTransferDoorVideoInfo " + amrb.a(this.this$0));
      return;
    }
    QLog.d("ARTransferPromotionRenderable", 1, "ARTransferPromotionRenderable finish parse ARTransferDoorVideoInfo value null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.4
 * JD-Core Version:    0.7.0.1
 */