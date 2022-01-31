package com.tencent.mobileqq.ar.ARRenderModel;

import alaf;
import alam;
import alao;
import com.tencent.mobileqq.ar.ARNativeBridge;
import com.tencent.qphone.base.util.QLog;

public class ARTransferPromotionRenderable$13
  implements Runnable
{
  public ARTransferPromotionRenderable$13(alam paramalam, int paramInt) {}
  
  public void run()
  {
    QLog.d("ARTransferPromotionRenderable", 2, "switchGameStatus run status " + this.a);
    switch (this.a)
    {
    }
    for (;;)
    {
      alam.d(this.this$0);
      return;
      if ((this.a == 1) && (alam.a(this.this$0) != null) && (alam.a(this.this$0).a.booleanValue())) {
        alam.a(this.this$0).b(0, 1);
      }
      if (alam.a(this.this$0) != null)
      {
        alam.a(this.this$0).native_switchGameStatusWithNoParams(this.a);
        continue;
        if (this.this$0.b == 3)
        {
          if (alam.a(this.this$0) != null) {
            alam.a(this.this$0).native_switchGameStatusWithNoParams(this.a);
          }
        }
        else {
          alam.a(this.this$0, 4, alam.a(this.this$0).c + "360Video.mp4", false, alam.a(this.this$0).d, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.13
 * JD-Core Version:    0.7.0.1
 */