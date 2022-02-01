package com.tencent.mobileqq.ar.ARRenderModel;

import aosc;
import aouh;
import aouj;
import com.tencent.qphone.base.util.QLog;

public class ARTransferPromotionRenderable$3
  implements Runnable
{
  public ARTransferPromotionRenderable$3(aouh paramaouh) {}
  
  public void run()
  {
    aouh.a(this.this$0, aosc.a(aouh.a(this.this$0).c));
    if (aouh.a(this.this$0) != null)
    {
      QLog.d("ARTransferPromotionRenderable", 2, "ARTransferPromotionRenderable finish parse ARTransferDoorVideoInfo " + aouh.a(this.this$0));
      return;
    }
    QLog.d("ARTransferPromotionRenderable", 1, "ARTransferPromotionRenderable finish parse ARTransferDoorVideoInfo value null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.3
 * JD-Core Version:    0.7.0.1
 */