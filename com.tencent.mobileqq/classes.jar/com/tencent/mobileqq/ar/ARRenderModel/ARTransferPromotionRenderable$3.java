package com.tencent.mobileqq.ar.ARRenderModel;

import anze;
import aobk;
import aobm;
import com.tencent.qphone.base.util.QLog;

public class ARTransferPromotionRenderable$3
  implements Runnable
{
  public ARTransferPromotionRenderable$3(aobk paramaobk) {}
  
  public void run()
  {
    aobk.a(this.this$0, anze.a(aobk.a(this.this$0).c));
    if (aobk.a(this.this$0) != null)
    {
      QLog.d("ARTransferPromotionRenderable", 2, "ARTransferPromotionRenderable finish parse ARTransferDoorVideoInfo " + aobk.a(this.this$0));
      return;
    }
    QLog.d("ARTransferPromotionRenderable", 1, "ARTransferPromotionRenderable finish parse ARTransferDoorVideoInfo value null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.3
 * JD-Core Version:    0.7.0.1
 */