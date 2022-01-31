package com.tencent.mobileqq.ar.ARRenderModel;

import amqu;
import amrb;
import amrd;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;

public class ARTransferPromotionRenderable$13
  implements Runnable
{
  public ARTransferPromotionRenderable$13(amrb paramamrb, int paramInt) {}
  
  public void run()
  {
    QLog.d("ARTransferPromotionRenderable", 2, "switchGameStatus run status " + this.a);
    switch (this.a)
    {
    }
    for (;;)
    {
      amrb.d(this.this$0);
      return;
      if ((this.a == 1) && (amrb.a(this.this$0) != null) && (amrb.a(this.this$0).a.booleanValue())) {
        amrb.a(this.this$0).b(0, 1);
      }
      if (amrb.a(this.this$0) != null)
      {
        amrb.a(this.this$0).native_switchGameStatusWithNoParams(this.a);
        continue;
        if (this.this$0.b == 3)
        {
          if (amrb.a(this.this$0) != null) {
            amrb.a(this.this$0).native_switchGameStatusWithNoParams(this.a);
          }
        }
        else {
          amrb.a(this.this$0, 4, amrb.a(this.this$0).c + "360Video.mp4", false, amrb.a(this.this$0).d, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.13
 * JD-Core Version:    0.7.0.1
 */