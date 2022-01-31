package com.tencent.mobileqq.ar.ARRenderModel;

import akjv;
import akma;
import akmc;
import com.tencent.qphone.base.util.QLog;

public class ARTransferPromotionRenderable$4
  implements Runnable
{
  public ARTransferPromotionRenderable$4(akma paramakma) {}
  
  public void run()
  {
    akma.a(this.this$0, akjv.a(akma.a(this.this$0).c));
    if (akma.a(this.this$0) != null)
    {
      QLog.d("ARTransferPromotionRenderable", 2, "ARTransferPromotionRenderable finish parse ARTransferDoorVideoInfo " + akma.a(this.this$0));
      return;
    }
    QLog.d("ARTransferPromotionRenderable", 1, "ARTransferPromotionRenderable finish parse ARTransferDoorVideoInfo value null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.4
 * JD-Core Version:    0.7.0.1
 */