package com.tencent.mobileqq.ar.ARRenderModel;

import akxz;
import akyf;
import alaf;
import alam;
import alao;
import alfe;
import alxt;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ARTransferPromotionRenderable$7
  implements Runnable
{
  public ARTransferPromotionRenderable$7(alam paramalam) {}
  
  public void run()
  {
    if (alam.a(this.this$0) == 6)
    {
      if ((alam.a(this.this$0) != null) && (alam.a(this.this$0)))
      {
        alam.a(this.this$0).b(1, 0);
        alam.a(this.this$0, false);
      }
      if ((alam.a(this.this$0) != null) && (alam.b(this.this$0))) {
        alam.a(this.this$0).a();
      }
      if (alam.a(this.this$0) != null) {
        alam.a(this.this$0).a(alam.a(this.this$0).a);
      }
      if (alam.a(this.this$0) == 6) {
        alam.a(this.this$0, 7);
      }
      alam.a(this.this$0).a();
      if (alam.a(this.this$0) != null) {
        ThreadManager.getUIHandler().post(new ARTransferPromotionRenderable.7.1(this));
      }
    }
    synchronized (alam.a(this.this$0))
    {
      alam.a(this.this$0).clear();
      alam.a(this.this$0).d();
      alam.a(this.this$0);
      if (alam.a(this.this$0) != null)
      {
        alam.a(this.this$0).b();
        alam.a(this.this$0).a();
        alam.a(this.this$0, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.7
 * JD-Core Version:    0.7.0.1
 */