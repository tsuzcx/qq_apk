package com.tencent.mobileqq.ar.ARRenderModel;

import alae;
import alal;
import alan;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;

public class ARTransferPromotionRenderable$13
  implements Runnable
{
  public ARTransferPromotionRenderable$13(alal paramalal, int paramInt) {}
  
  public void run()
  {
    QLog.d("ARTransferPromotionRenderable", 2, "switchGameStatus run status " + this.a);
    switch (this.a)
    {
    }
    for (;;)
    {
      alal.d(this.this$0);
      return;
      if ((this.a == 1) && (alal.a(this.this$0) != null) && (alal.a(this.this$0).a.booleanValue())) {
        alal.a(this.this$0).b(0, 1);
      }
      if (alal.a(this.this$0) != null)
      {
        alal.a(this.this$0).native_switchGameStatusWithNoParams(this.a);
        continue;
        if (this.this$0.b == 3)
        {
          if (alal.a(this.this$0) != null) {
            alal.a(this.this$0).native_switchGameStatusWithNoParams(this.a);
          }
        }
        else {
          alal.a(this.this$0, 4, alal.a(this.this$0).c + "360Video.mp4", false, alal.a(this.this$0).d, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.13
 * JD-Core Version:    0.7.0.1
 */