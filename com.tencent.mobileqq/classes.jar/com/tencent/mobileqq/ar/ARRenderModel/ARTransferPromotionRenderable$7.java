package com.tencent.mobileqq.ar.ARRenderModel;

import akjn;
import akjt;
import aklt;
import akma;
import akmc;
import akqs;
import aljf;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ARTransferPromotionRenderable$7
  implements Runnable
{
  public ARTransferPromotionRenderable$7(akma paramakma) {}
  
  public void run()
  {
    if (akma.a(this.this$0) == 6)
    {
      if ((akma.a(this.this$0) != null) && (akma.a(this.this$0)))
      {
        akma.a(this.this$0).b(1, 0);
        akma.a(this.this$0, false);
      }
      if ((akma.a(this.this$0) != null) && (akma.b(this.this$0))) {
        akma.a(this.this$0).a();
      }
      if (akma.a(this.this$0) != null) {
        akma.a(this.this$0).a(akma.a(this.this$0).a);
      }
      if (akma.a(this.this$0) == 6) {
        akma.a(this.this$0, 7);
      }
      akma.a(this.this$0).a();
      if (akma.a(this.this$0) != null) {
        ThreadManager.getUIHandler().post(new ARTransferPromotionRenderable.7.1(this));
      }
    }
    synchronized (akma.a(this.this$0))
    {
      akma.a(this.this$0).clear();
      akma.a(this.this$0).d();
      akma.a(this.this$0);
      if (akma.a(this.this$0) != null)
      {
        akma.a(this.this$0).b();
        akma.a(this.this$0).a();
        akma.a(this.this$0, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.7
 * JD-Core Version:    0.7.0.1
 */