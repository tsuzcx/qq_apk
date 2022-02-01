package com.tencent.mobileqq.ar.ARPromotion;

import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import apfk;
import apfl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class ARPromotionMediaPlayerWrapper$1
  implements Runnable
{
  public ARPromotionMediaPlayerWrapper$1(apfk paramapfk) {}
  
  public void run()
  {
    try
    {
      if (apfk.a(this.this$0)) {
        return;
      }
      if (apfk.a(this.this$0) != null)
      {
        apfk.a(this.this$0).updateTexImage();
        apfk.a(this.this$0).getTransformMatrix(apfk.a(this.this$0));
        apfk.a(this.this$0);
        apfk.a(this.this$0);
        Matrix.setIdentityM(apfk.b(this.this$0), 0);
        apfk.a(this.this$0).bind();
        apfk.a(this.this$0).drawTexture(36197, apfk.a(this.this$0), apfk.a(this.this$0), apfk.b(this.this$0));
        apfk.a(this.this$0).unbind();
        if ((apfk.b(this.this$0) == 2L) && (apfk.a(this.this$0) != null))
        {
          apfk.a(this.this$0).a(apfk.b(this.this$0), 0, apfk.a(this.this$0).getTexId());
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