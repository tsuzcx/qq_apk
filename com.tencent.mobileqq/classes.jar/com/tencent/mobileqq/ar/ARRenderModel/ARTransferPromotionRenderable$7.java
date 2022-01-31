package com.tencent.mobileqq.ar.ARRenderModel;

import amtd;
import amtj;
import amvj;
import amvq;
import amvs;
import anag;
import anta;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ARTransferPromotionRenderable$7
  implements Runnable
{
  public ARTransferPromotionRenderable$7(amvq paramamvq) {}
  
  public void run()
  {
    if (amvq.a(this.this$0) == 6)
    {
      if ((amvq.a(this.this$0) != null) && (amvq.a(this.this$0)))
      {
        amvq.a(this.this$0).b(1, 0);
        amvq.a(this.this$0, false);
      }
      if ((amvq.a(this.this$0) != null) && (amvq.b(this.this$0))) {
        amvq.a(this.this$0).a();
      }
      if (amvq.a(this.this$0) != null) {
        amvq.a(this.this$0).a(amvq.a(this.this$0).a);
      }
      if (amvq.a(this.this$0) == 6) {
        amvq.a(this.this$0, 7);
      }
      amvq.a(this.this$0).a();
      if (amvq.a(this.this$0) != null) {
        ThreadManager.getUIHandler().post(new ARTransferPromotionRenderable.7.1(this));
      }
    }
    synchronized (amvq.a(this.this$0))
    {
      amvq.a(this.this$0).clear();
      amvq.a(this.this$0).c();
      amvq.a(this.this$0);
      if (amvq.a(this.this$0) != null)
      {
        amvq.a(this.this$0).b();
        amvq.a(this.this$0).a();
        amvq.a(this.this$0, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.7
 * JD-Core Version:    0.7.0.1
 */