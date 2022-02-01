package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;

class ARTransferPromotionRenderable$13
  implements Runnable
{
  ARTransferPromotionRenderable$13(ARTransferPromotionRenderable paramARTransferPromotionRenderable, int paramInt) {}
  
  public void run()
  {
    QLog.d("ARTransferPromotionRenderable", 2, "switchGameStatus run status " + this.a);
    switch (this.a)
    {
    }
    for (;;)
    {
      ARTransferPromotionRenderable.e(this.this$0);
      return;
      if ((this.a == 1) && (ARTransferPromotionRenderable.a(this.this$0) != null) && (ARTransferPromotionRenderable.a(this.this$0).a.booleanValue())) {
        ARTransferPromotionRenderable.a(this.this$0).b(0, 1);
      }
      if (ARTransferPromotionRenderable.a(this.this$0) != null)
      {
        ARTransferPromotionRenderable.a(this.this$0).native_switchGameStatusWithNoParams(this.a);
        continue;
        if (this.this$0.b == 3)
        {
          if (ARTransferPromotionRenderable.a(this.this$0) != null) {
            ARTransferPromotionRenderable.a(this.this$0).native_switchGameStatusWithNoParams(this.a);
          }
        }
        else {
          ARTransferPromotionRenderable.a(this.this$0, 4, ARTransferPromotionRenderable.a(this.this$0).c + "360Video.mp4", false, ARTransferPromotionRenderable.a(this.this$0).d, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.13
 * JD-Core Version:    0.7.0.1
 */