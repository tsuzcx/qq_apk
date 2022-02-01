package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager;
import com.tencent.mobileqq.ar.arcore.IARCoreBridge;
import com.tencent.mobileqq.armap.sensor.ARSensorManager;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import java.util.ArrayList;
import mqq.os.MqqHandler;

class ARTransferPromotionRenderable$7
  implements Runnable
{
  ARTransferPromotionRenderable$7(ARTransferPromotionRenderable paramARTransferPromotionRenderable) {}
  
  public void run()
  {
    if (ARTransferPromotionRenderable.b(this.this$0) == 6)
    {
      if ((ARTransferPromotionRenderable.d(this.this$0) != null) && (ARTransferPromotionRenderable.h(this.this$0)))
      {
        ARTransferPromotionRenderable.d(this.this$0).b(1, 0);
        ARTransferPromotionRenderable.a(this.this$0, false);
      }
      if ((ARTransferPromotionRenderable.i(this.this$0) != null) && (ARTransferPromotionRenderable.j(this.this$0))) {
        ARTransferPromotionRenderable.i(this.this$0).b();
      }
      if ((ARTransferPromotionRenderable.k(this.this$0) != -1) && (ARTransferPromotionRenderable.l(this.this$0) != null))
      {
        ARTransferPromotionRenderable.l(this.this$0).stopPreDownload(ARTransferPromotionRenderable.k(this.this$0));
        ARTransferPromotionRenderable.a(this.this$0, -1);
      }
      if (ARTransferPromotionRenderable.l(this.this$0) != null) {
        ARTransferPromotionRenderable.l(this.this$0).destory();
      }
      if (ARTransferPromotionRenderable.d(this.this$0) != null) {
        ARTransferPromotionRenderable.d(this.this$0).a(ARTransferPromotionRenderable.e(this.this$0).a);
      }
      if (ARTransferPromotionRenderable.b(this.this$0) == 6) {
        ARTransferPromotionRenderable.b(this.this$0, 7);
      }
      ARTransferPromotionRenderable.m(this.this$0).b();
      if (ARTransferPromotionRenderable.n(this.this$0) != null) {
        ThreadManager.getUIHandler().post(new ARTransferPromotionRenderable.7.1(this));
      }
      synchronized (ARTransferPromotionRenderable.o(this.this$0))
      {
        ARTransferPromotionRenderable.o(this.this$0).clear();
        ARTransferPromotionRenderable.a(this.this$0).d();
        ARTransferPromotionRenderable.p(this.this$0);
        if (ARTransferPromotionRenderable.q(this.this$0) != null)
        {
          ARTransferPromotionRenderable.q(this.this$0).d();
          ARTransferPromotionRenderable.q(this.this$0).c();
          ARTransferPromotionRenderable.a(this.this$0, null);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.7
 * JD-Core Version:    0.7.0.1
 */