package com.tencent.mobileqq.ar.ARRenderModel;

import apfk;
import apfq;
import aphq;
import aphx;
import aphz;
import apmn;
import aqgv;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ARTransferPromotionRenderable$7
  implements Runnable
{
  public ARTransferPromotionRenderable$7(aphx paramaphx) {}
  
  public void run()
  {
    if (aphx.a(this.this$0) == 6)
    {
      if ((aphx.a(this.this$0) != null) && (aphx.a(this.this$0)))
      {
        aphx.a(this.this$0).b(1, 0);
        aphx.a(this.this$0, false);
      }
      if ((aphx.a(this.this$0) != null) && (aphx.b(this.this$0))) {
        aphx.a(this.this$0).a();
      }
      if ((aphx.b(this.this$0) != -1) && (aphx.a(this.this$0) != null))
      {
        aphx.a(this.this$0).stopPreDownload(aphx.b(this.this$0));
        aphx.a(this.this$0, -1);
      }
      if (aphx.a(this.this$0) != null) {
        aphx.a(this.this$0).destory();
      }
      if (aphx.a(this.this$0) != null) {
        aphx.a(this.this$0).a(aphx.a(this.this$0).a);
      }
      if (aphx.a(this.this$0) == 6) {
        aphx.a(this.this$0, 7);
      }
      aphx.a(this.this$0).a();
      if (aphx.a(this.this$0) != null) {
        ThreadManager.getUIHandler().post(new ARTransferPromotionRenderable.7.1(this));
      }
    }
    synchronized (aphx.a(this.this$0))
    {
      aphx.a(this.this$0).clear();
      aphx.a(this.this$0).c();
      aphx.a(this.this$0);
      if (aphx.a(this.this$0) != null)
      {
        aphx.a(this.this$0).b();
        aphx.a(this.this$0).a();
        aphx.a(this.this$0, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.7
 * JD-Core Version:    0.7.0.1
 */