package com.tencent.mobileqq.ar.ARRenderModel;

import apby;
import apce;
import apef;
import apem;
import apeo;
import apjc;
import aqdk;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ARTransferPromotionRenderable$7
  implements Runnable
{
  public ARTransferPromotionRenderable$7(apem paramapem) {}
  
  public void run()
  {
    if (apem.a(this.this$0) == 6)
    {
      if ((apem.a(this.this$0) != null) && (apem.a(this.this$0)))
      {
        apem.a(this.this$0).b(1, 0);
        apem.a(this.this$0, false);
      }
      if ((apem.a(this.this$0) != null) && (apem.b(this.this$0))) {
        apem.a(this.this$0).a();
      }
      if ((apem.b(this.this$0) != -1) && (apem.a(this.this$0) != null))
      {
        apem.a(this.this$0).stopPreDownload(apem.b(this.this$0));
        apem.a(this.this$0, -1);
      }
      if (apem.a(this.this$0) != null) {
        apem.a(this.this$0).destory();
      }
      if (apem.a(this.this$0) != null) {
        apem.a(this.this$0).a(apem.a(this.this$0).a);
      }
      if (apem.a(this.this$0) == 6) {
        apem.a(this.this$0, 7);
      }
      apem.a(this.this$0).a();
      if (apem.a(this.this$0) != null) {
        ThreadManager.getUIHandler().post(new ARTransferPromotionRenderable.7.1(this));
      }
    }
    synchronized (apem.a(this.this$0))
    {
      apem.a(this.this$0).clear();
      apem.a(this.this$0).c();
      apem.a(this.this$0);
      if (apem.a(this.this$0) != null)
      {
        apem.a(this.this$0).b();
        apem.a(this.this$0).a();
        apem.a(this.this$0, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.7
 * JD-Core Version:    0.7.0.1
 */