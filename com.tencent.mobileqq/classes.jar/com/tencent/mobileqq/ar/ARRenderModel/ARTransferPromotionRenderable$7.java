package com.tencent.mobileqq.ar.ARRenderModel;

import akxy;
import akye;
import alae;
import alal;
import alan;
import alfd;
import alxs;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ARTransferPromotionRenderable$7
  implements Runnable
{
  public ARTransferPromotionRenderable$7(alal paramalal) {}
  
  public void run()
  {
    if (alal.a(this.this$0) == 6)
    {
      if ((alal.a(this.this$0) != null) && (alal.a(this.this$0)))
      {
        alal.a(this.this$0).b(1, 0);
        alal.a(this.this$0, false);
      }
      if ((alal.a(this.this$0) != null) && (alal.b(this.this$0))) {
        alal.a(this.this$0).a();
      }
      if (alal.a(this.this$0) != null) {
        alal.a(this.this$0).a(alal.a(this.this$0).a);
      }
      if (alal.a(this.this$0) == 6) {
        alal.a(this.this$0, 7);
      }
      alal.a(this.this$0).a();
      if (alal.a(this.this$0) != null) {
        ThreadManager.getUIHandler().post(new ARTransferPromotionRenderable.7.1(this));
      }
    }
    synchronized (alal.a(this.this$0))
    {
      alal.a(this.this$0).clear();
      alal.a(this.this$0).d();
      alal.a(this.this$0);
      if (alal.a(this.this$0) != null)
      {
        alal.a(this.this$0).b();
        alal.a(this.this$0).a();
        alal.a(this.this$0, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.7
 * JD-Core Version:    0.7.0.1
 */