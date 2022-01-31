package com.tencent.mobileqq.ar.ARRenderModel;

import amoo;
import amou;
import amqu;
import amrb;
import amrd;
import amvt;
import anor;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ARTransferPromotionRenderable$7
  implements Runnable
{
  public ARTransferPromotionRenderable$7(amrb paramamrb) {}
  
  public void run()
  {
    if (amrb.a(this.this$0) == 6)
    {
      if ((amrb.a(this.this$0) != null) && (amrb.a(this.this$0)))
      {
        amrb.a(this.this$0).b(1, 0);
        amrb.a(this.this$0, false);
      }
      if ((amrb.a(this.this$0) != null) && (amrb.b(this.this$0))) {
        amrb.a(this.this$0).a();
      }
      if (amrb.a(this.this$0) != null) {
        amrb.a(this.this$0).a(amrb.a(this.this$0).a);
      }
      if (amrb.a(this.this$0) == 6) {
        amrb.a(this.this$0, 7);
      }
      amrb.a(this.this$0).a();
      if (amrb.a(this.this$0) != null) {
        ThreadManager.getUIHandler().post(new ARTransferPromotionRenderable.7.1(this));
      }
    }
    synchronized (amrb.a(this.this$0))
    {
      amrb.a(this.this$0).clear();
      amrb.a(this.this$0).d();
      amrb.a(this.this$0);
      if (amrb.a(this.this$0) != null)
      {
        amrb.a(this.this$0).b();
        amrb.a(this.this$0).a();
        amrb.a(this.this$0, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.7
 * JD-Core Version:    0.7.0.1
 */