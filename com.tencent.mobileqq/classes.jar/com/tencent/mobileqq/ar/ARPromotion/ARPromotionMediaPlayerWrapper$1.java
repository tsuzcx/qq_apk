package com.tencent.mobileqq.ar.ARPromotion;

import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

class ARPromotionMediaPlayerWrapper$1
  implements Runnable
{
  ARPromotionMediaPlayerWrapper$1(ARPromotionMediaPlayerWrapper paramARPromotionMediaPlayerWrapper) {}
  
  public void run()
  {
    try
    {
      if (ARPromotionMediaPlayerWrapper.a(this.this$0)) {
        return;
      }
      if (ARPromotionMediaPlayerWrapper.b(this.this$0) != null)
      {
        ARPromotionMediaPlayerWrapper.b(this.this$0).updateTexImage();
        ARPromotionMediaPlayerWrapper.b(this.this$0).getTransformMatrix(ARPromotionMediaPlayerWrapper.c(this.this$0));
        ARPromotionMediaPlayerWrapper.d(this.this$0);
        ARPromotionMediaPlayerWrapper.e(this.this$0);
        Matrix.setIdentityM(ARPromotionMediaPlayerWrapper.f(this.this$0), 0);
        ARPromotionMediaPlayerWrapper.g(this.this$0).bind();
        ARPromotionMediaPlayerWrapper.i(this.this$0).drawTexture(36197, ARPromotionMediaPlayerWrapper.h(this.this$0), ARPromotionMediaPlayerWrapper.c(this.this$0), ARPromotionMediaPlayerWrapper.f(this.this$0));
        ARPromotionMediaPlayerWrapper.g(this.this$0).unbind();
        if ((ARPromotionMediaPlayerWrapper.j(this.this$0) == 2L) && (ARPromotionMediaPlayerWrapper.k(this.this$0) != null))
        {
          ARPromotionMediaPlayerWrapper.k(this.this$0).a(ARPromotionMediaPlayerWrapper.l(this.this$0), 0, ARPromotionMediaPlayerWrapper.g(this.this$0).getTexId());
          QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupMediaPlayerWrapper.drawFrame hardWare");
          return;
        }
      }
    }
    catch (Exception localException)
    {
      QLog.e("ARWorldCupMediaPlayerWrapper", 1, "mUpdateHardTextureRunnable fail.", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.1
 * JD-Core Version:    0.7.0.1
 */