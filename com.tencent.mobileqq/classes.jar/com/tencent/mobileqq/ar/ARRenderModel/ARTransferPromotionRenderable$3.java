package com.tencent.mobileqq.ar.ARRenderModel;

import apcg;
import apem;
import apeo;
import com.tencent.qphone.base.util.QLog;

public class ARTransferPromotionRenderable$3
  implements Runnable
{
  public ARTransferPromotionRenderable$3(apem paramapem) {}
  
  public void run()
  {
    apem.a(this.this$0, apcg.a(apem.a(this.this$0).c));
    if (apem.a(this.this$0) != null)
    {
      QLog.d("ARTransferPromotionRenderable", 2, "ARTransferPromotionRenderable finish parse ARTransferDoorVideoInfo " + apem.a(this.this$0));
      return;
    }
    QLog.d("ARTransferPromotionRenderable", 1, "ARTransferPromotionRenderable finish parse ARTransferDoorVideoInfo value null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.3
 * JD-Core Version:    0.7.0.1
 */