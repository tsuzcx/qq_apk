package com.tencent.mobileqq.ar.ARPromotion;

import amoo;
import amop;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class ARPromotionMediaPlayerWrapper$1
  implements Runnable
{
  public ARPromotionMediaPlayerWrapper$1(amoo paramamoo) {}
  
  public void run()
  {
    try
    {
      if (amoo.a(this.this$0)) {
        return;
      }
      if (amoo.a(this.this$0) != null)
      {
        amoo.a(this.this$0).updateTexImage();
        amoo.a(this.this$0).getTransformMatrix(amoo.a(this.this$0));
        amoo.a(this.this$0);
        amoo.a(this.this$0);
        Matrix.setIdentityM(amoo.b(this.this$0), 0);
        amoo.a(this.this$0).bind();
        amoo.a(this.this$0).drawTexture(36197, amoo.a(this.this$0), amoo.a(this.this$0), amoo.b(this.this$0));
        amoo.a(this.this$0).unbind();
        if ((amoo.b(this.this$0) == 2L) && (amoo.a(this.this$0) != null))
        {
          amoo.a(this.this$0).a(amoo.b(this.this$0), 0, amoo.a(this.this$0).getTexId());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.1
 * JD-Core Version:    0.7.0.1
 */