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
    if (ARTransferPromotionRenderable.a(this.this$0) == 6)
    {
      if ((ARTransferPromotionRenderable.a(this.this$0) != null) && (ARTransferPromotionRenderable.a(this.this$0)))
      {
        ARTransferPromotionRenderable.a(this.this$0).b(1, 0);
        ARTransferPromotionRenderable.a(this.this$0, false);
      }
      if ((ARTransferPromotionRenderable.a(this.this$0) != null) && (ARTransferPromotionRenderable.b(this.this$0))) {
        ARTransferPromotionRenderable.a(this.this$0).a();
      }
      if ((ARTransferPromotionRenderable.b(this.this$0) != -1) && (ARTransferPromotionRenderable.a(this.this$0) != null))
      {
        ARTransferPromotionRenderable.a(this.this$0).stopPreDownload(ARTransferPromotionRenderable.b(this.this$0));
        ARTransferPromotionRenderable.a(this.this$0, -1);
      }
      if (ARTransferPromotionRenderable.a(this.this$0) != null) {
        ARTransferPromotionRenderable.a(this.this$0).destory();
      }
      if (ARTransferPromotionRenderable.a(this.this$0) != null) {
        ARTransferPromotionRenderable.a(this.this$0).a(ARTransferPromotionRenderable.a(this.this$0).a);
      }
      if (ARTransferPromotionRenderable.a(this.this$0) == 6) {
        ARTransferPromotionRenderable.a(this.this$0, 7);
      }
      ARTransferPromotionRenderable.a(this.this$0).a();
      if (ARTransferPromotionRenderable.a(this.this$0) != null) {
        ThreadManager.getUIHandler().post(new ARTransferPromotionRenderable.7.1(this));
      }
    }
    synchronized (ARTransferPromotionRenderable.a(this.this$0))
    {
      ARTransferPromotionRenderable.a(this.this$0).clear();
      ARTransferPromotionRenderable.a(this.this$0).c();
      ARTransferPromotionRenderable.a(this.this$0);
      if (ARTransferPromotionRenderable.a(this.this$0) != null)
      {
        ARTransferPromotionRenderable.a(this.this$0).b();
        ARTransferPromotionRenderable.a(this.this$0).a();
        ARTransferPromotionRenderable.a(this.this$0, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.7
 * JD-Core Version:    0.7.0.1
 */