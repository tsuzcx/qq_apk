package com.tencent.mobileqq.ar.ARPromotion;

import com.tencent.mobileqq.ar.ARRenderModel.GreetingYUVProgram;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

class ARPromotionMediaPlayerWrapper$2
  implements Runnable
{
  public void run()
  {
    if (ARPromotionMediaPlayerWrapper.a(this.this$0)) {
      return;
    }
    try
    {
      ARPromotionMediaPlayerWrapper.e(this.this$0);
      ARPromotionMediaPlayerWrapper.d(this.this$0);
      if (ARPromotionMediaPlayerWrapper.g(this.this$0) != null)
      {
        if (ARPromotionMediaPlayerWrapper.m(this.this$0) == null) {
          return;
        }
        ARPromotionMediaPlayerWrapper.g(this.this$0).bind();
        ARPromotionMediaPlayerWrapper.a(this.this$0, this.a, this.b, this.c);
        if (!ARPromotionMediaPlayerWrapper.m(this.this$0).a())
        {
          ARPromotionMediaPlayerWrapper.m(this.this$0).b();
          ARPromotionMediaPlayerWrapper.m(this.this$0).a(GreetingYUVProgram.h);
        }
        ARPromotionMediaPlayerWrapper.m(this.this$0).a(ARPromotionMediaPlayerWrapper.n(this.this$0)[0], ARPromotionMediaPlayerWrapper.n(this.this$0)[1], ARPromotionMediaPlayerWrapper.n(this.this$0)[2], this.d, this.e);
        ARPromotionMediaPlayerWrapper.m(this.this$0).c();
        ARPromotionMediaPlayerWrapper.g(this.this$0).unbind();
        if ((ARPromotionMediaPlayerWrapper.j(this.this$0) == 2L) && (ARPromotionMediaPlayerWrapper.k(this.this$0) != null))
        {
          ARPromotionMediaPlayerWrapper.k(this.this$0).a(ARPromotionMediaPlayerWrapper.l(this.this$0), 0, ARPromotionMediaPlayerWrapper.g(this.this$0).getTexId());
          QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupGlobalSceneRenderable ARWorldCupMediaPlayerWrapper.drawFrame softWare");
        }
      }
      else {}
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.i("ARWorldCupMediaPlayerWrapper", 1, "drawSoftFrame render error happen");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.2
 * JD-Core Version:    0.7.0.1
 */