package com.tencent.mobileqq.ar.ARRenderModel;

import apfs;
import aphx;
import aphz;
import com.tencent.qphone.base.util.QLog;

public class ARTransferPromotionRenderable$3
  implements Runnable
{
  public ARTransferPromotionRenderable$3(aphx paramaphx) {}
  
  public void run()
  {
    aphx.a(this.this$0, apfs.a(aphx.a(this.this$0).c));
    if (aphx.a(this.this$0) != null)
    {
      QLog.d("ARTransferPromotionRenderable", 2, "ARTransferPromotionRenderable finish parse ARTransferDoorVideoInfo " + aphx.a(this.this$0));
      return;
    }
    QLog.d("ARTransferPromotionRenderable", 1, "ARTransferPromotionRenderable finish parse ARTransferDoorVideoInfo value null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.3
 * JD-Core Version:    0.7.0.1
 */