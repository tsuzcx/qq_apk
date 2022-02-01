package com.tencent.mobileqq.ar.ARPromotion;

import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import anyw;
import anyx;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class ARPromotionMediaPlayerWrapper$1
  implements Runnable
{
  public ARPromotionMediaPlayerWrapper$1(anyw paramanyw) {}
  
  public void run()
  {
    try
    {
      if (anyw.a(this.this$0)) {
        return;
      }
      if (anyw.a(this.this$0) != null)
      {
        anyw.a(this.this$0).updateTexImage();
        anyw.a(this.this$0).getTransformMatrix(anyw.a(this.this$0));
        anyw.a(this.this$0);
        anyw.a(this.this$0);
        Matrix.setIdentityM(anyw.b(this.this$0), 0);
        anyw.a(this.this$0).bind();
        anyw.a(this.this$0).drawTexture(36197, anyw.a(this.this$0), anyw.a(this.this$0), anyw.b(this.this$0));
        anyw.a(this.this$0).unbind();
        if ((anyw.b(this.this$0) == 2L) && (anyw.a(this.this$0) != null))
        {
          anyw.a(this.this$0).a(anyw.b(this.this$0), 0, anyw.a(this.this$0).getTexId());
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