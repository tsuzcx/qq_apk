package com.tencent.mobileqq.ar.ARRenderModel;

import anyw;
import anzc;
import aobd;
import aobk;
import aobm;
import aoga;
import apag;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ARTransferPromotionRenderable$7
  implements Runnable
{
  public ARTransferPromotionRenderable$7(aobk paramaobk) {}
  
  public void run()
  {
    if (aobk.a(this.this$0) == 6)
    {
      if ((aobk.a(this.this$0) != null) && (aobk.a(this.this$0)))
      {
        aobk.a(this.this$0).b(1, 0);
        aobk.a(this.this$0, false);
      }
      if ((aobk.a(this.this$0) != null) && (aobk.b(this.this$0))) {
        aobk.a(this.this$0).a();
      }
      if ((aobk.b(this.this$0) != -1) && (aobk.a(this.this$0) != null))
      {
        aobk.a(this.this$0).stopPreDownload(aobk.b(this.this$0));
        aobk.a(this.this$0, -1);
      }
      if (aobk.a(this.this$0) != null) {
        aobk.a(this.this$0).destory();
      }
      if (aobk.a(this.this$0) != null) {
        aobk.a(this.this$0).a(aobk.a(this.this$0).a);
      }
      if (aobk.a(this.this$0) == 6) {
        aobk.a(this.this$0, 7);
      }
      aobk.a(this.this$0).a();
      if (aobk.a(this.this$0) != null) {
        ThreadManager.getUIHandler().post(new ARTransferPromotionRenderable.7.1(this));
      }
    }
    synchronized (aobk.a(this.this$0))
    {
      aobk.a(this.this$0).clear();
      aobk.a(this.this$0).c();
      aobk.a(this.this$0);
      if (aobk.a(this.this$0) != null)
      {
        aobk.a(this.this$0).b();
        aobk.a(this.this$0).a();
        aobk.a(this.this$0, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.7
 * JD-Core Version:    0.7.0.1
 */