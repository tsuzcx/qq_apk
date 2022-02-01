package com.tencent.mobileqq.ar.ARPromotion;

import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import apby;
import apbz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class ARPromotionMediaPlayerWrapper$1
  implements Runnable
{
  public ARPromotionMediaPlayerWrapper$1(apby paramapby) {}
  
  public void run()
  {
    try
    {
      if (apby.a(this.this$0)) {
        return;
      }
      if (apby.a(this.this$0) != null)
      {
        apby.a(this.this$0).updateTexImage();
        apby.a(this.this$0).getTransformMatrix(apby.a(this.this$0));
        apby.a(this.this$0);
        apby.a(this.this$0);
        Matrix.setIdentityM(apby.b(this.this$0), 0);
        apby.a(this.this$0).bind();
        apby.a(this.this$0).drawTexture(36197, apby.a(this.this$0), apby.a(this.this$0), apby.b(this.this$0));
        apby.a(this.this$0).unbind();
        if ((apby.b(this.this$0) == 2L) && (apby.a(this.this$0) != null))
        {
          apby.a(this.this$0).a(apby.b(this.this$0), 0, apby.a(this.this$0).getTexId());
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