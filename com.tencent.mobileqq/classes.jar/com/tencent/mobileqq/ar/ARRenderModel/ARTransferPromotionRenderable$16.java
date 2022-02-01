package com.tencent.mobileqq.ar.ARRenderModel;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorConfigInfo.FragmentInfo;
import com.tencent.mobileqq.ar.ARPromotion.ARTransferDoorLogicManager;
import com.tencent.mobileqq.ar.arcore.IARCoreBridge;
import com.tencent.mobileqq.armap.sensor.ARSensorManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import com.tencent.util.MqqWeakReferenceHandler;
import mqq.os.MqqHandler;

class ARTransferPromotionRenderable$16
  implements Runnable
{
  ARTransferPromotionRenderable$16(ARTransferPromotionRenderable paramARTransferPromotionRenderable, int paramInt) {}
  
  public void run()
  {
    int i = this.a;
    Object localObject;
    if (i != 2)
    {
      if (i != 3)
      {
        if (i != 4)
        {
          if (i != 5)
          {
            if (i != 6)
            {
              if (i != 8)
              {
                if (i != 1000) {
                  return;
                }
                ARTransferPromotionRenderable.a(this.this$0).a(false);
                ThreadManager.getSubThreadHandler().post(new ARTransferPromotionRenderable.16.1(this));
                ARTransferPromotionRenderable.c(this.this$0, true);
                return;
              }
              ARTransferPromotionRenderable.a(this.this$0).b();
              if (ARTransferPromotionRenderable.d(this.this$0) != null) {
                ARTransferPromotionRenderable.d(this.this$0).b(2, 0);
              }
              QLog.d("ARTransferPromotionRenderable", 2, "ad play end here");
              return;
            }
            ARTransferPromotionRenderable.a(this.this$0).b();
            if (ARTransferPromotionRenderable.j(this.this$0)) {
              ARTransferPromotionRenderable.i(this.this$0).b();
            }
            if (ARTransferPromotionRenderable.q(this.this$0) != null) {
              ARTransferPromotionRenderable.q(this.this$0).d();
            }
            if (ARTransferPromotionRenderable.k(this.this$0) != -1)
            {
              ARTransferPromotionRenderable.l(this.this$0).stopPreDownload(ARTransferPromotionRenderable.k(this.this$0));
              ARTransferPromotionRenderable.a(this.this$0, -1);
            }
            localObject = this.this$0;
            ARTransferPromotionRenderable.a((ARTransferPromotionRenderable)localObject, 7, ARTransferPromotionRenderable.y((ARTransferPromotionRenderable)localObject).c, false, ARTransferPromotionRenderable.y(this.this$0).d, true);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("start play 360 over video ");
            ((StringBuilder)localObject).append(ARTransferPromotionRenderable.y(this.this$0));
            QLog.d("ARTransferPromotionRenderable", 2, ((StringBuilder)localObject).toString());
            return;
          }
          ARTransferPromotionRenderable.a(this.this$0).a(true);
          ARTransferPromotionRenderable.a(this.this$0).b(false);
          ARTransferPromotionRenderable.p(this.this$0);
          QLog.d("ARTransferPromotionRenderable", 2, "GameStatus_OUTSIDE_WORLD_360 ready");
          return;
        }
        if (this.this$0.c != null) {
          this.this$0.c.removeCallbacks(ARTransferPromotionRenderable.x(this.this$0));
        }
        if ((ARTransferPromotionRenderable.q(this.this$0) != null) && (!ARTransferPromotionRenderable.B(this.this$0)))
        {
          ARTransferPromotionRenderable.a(this.this$0).a(false);
          ARTransferPromotionRenderable.a(this.this$0).b(true);
          if (ARTransferPromotionRenderable.c(this.this$0) != null)
          {
            if (ARTransferPromotionRenderable.e(this.this$0).j.booleanValue())
            {
              ARTransferPromotionRenderable.a(this.this$0).a();
              QLog.d("ARTransferPromotionRenderable", 2, "nativeCallBack status GameStatus_TRAVERSING_DOOR: config jumpTo firstFrame");
            }
            ARTransferPromotionRenderable.A(this.this$0);
          }
          if ((ARTransferPromotionRenderable.e(this.this$0).l != 0) && (ARTransferPromotionRenderable.e(this.this$0).l == 1)) {
            ARTransferPromotionRenderable.m(this.this$0).b(true);
          }
        }
        ARTransferPromotionRenderable.c(this.this$0, false);
        return;
      }
      if (this.this$0.c != null) {
        this.this$0.c.removeCallbacks(ARTransferPromotionRenderable.x(this.this$0));
      }
      if (ARTransferPromotionRenderable.c(this.this$0) != null)
      {
        if (ARTransferPromotionRenderable.e(this.this$0).j.booleanValue())
        {
          ARTransferPromotionRenderable.a(this.this$0).a();
          QLog.d("ARTransferPromotionRenderable", 2, "nativeCallBack status GameStatus_TRAVERSING_DOOR: config jumpTo firstFrame");
        }
        ARTransferPromotionRenderable.A(this.this$0);
        this.this$0.a(4);
      }
      if ((ARTransferPromotionRenderable.e(this.this$0).l != 0) && (ARTransferPromotionRenderable.e(this.this$0).l == 1)) {
        ARTransferPromotionRenderable.m(this.this$0).b(true);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("nativeCallBack status GameStatus_TRAVERSING_DOOR: m360VideoConnectType ");
      ((StringBuilder)localObject).append(ARTransferPromotionRenderable.e(this.this$0).l);
      QLog.d("ARTransferPromotionRenderable", 2, ((StringBuilder)localObject).toString());
      return;
    }
    ARTransferPromotionRenderable.w(this.this$0);
    if ((this.this$0.a == 0) && (this.this$0.b == 2))
    {
      localObject = this.this$0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ARTransferPromotionRenderable.e(this.this$0).o);
      localStringBuilder.append("360Video.mp4");
      ARTransferPromotionRenderable.a((ARTransferPromotionRenderable)localObject, 3, localStringBuilder.toString(), false, ARTransferPromotionRenderable.e(this.this$0).k, false);
      ARTransferPromotionRenderable.a(this.this$0).a(true);
      ARTransferPromotionRenderable.u(this.this$0);
      ARTransferPromotionRenderable.v(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.16
 * JD-Core Version:    0.7.0.1
 */