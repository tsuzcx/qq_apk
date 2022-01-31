package com.tencent.mobileqq.ar.ARPromotion;

import amtd;
import amte;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class ARPromotionMediaPlayerWrapper$1
  implements Runnable
{
  public ARPromotionMediaPlayerWrapper$1(amtd paramamtd) {}
  
  public void run()
  {
    try
    {
      if (amtd.a(this.this$0)) {
        return;
      }
      if (amtd.a(this.this$0) != null)
      {
        amtd.a(this.this$0).updateTexImage();
        amtd.a(this.this$0).getTransformMatrix(amtd.a(this.this$0));
        amtd.a(this.this$0);
        amtd.a(this.this$0);
        Matrix.setIdentityM(amtd.b(this.this$0), 0);
        amtd.a(this.this$0).bind();
        amtd.a(this.this$0).drawTexture(36197, amtd.a(this.this$0), amtd.a(this.this$0), amtd.b(this.this$0));
        amtd.a(this.this$0).unbind();
        if ((amtd.b(this.this$0) == 2L) && (amtd.a(this.this$0) != null))
        {
          amtd.a(this.this$0).a(amtd.b(this.this$0), 0, amtd.a(this.this$0).getTexId());
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