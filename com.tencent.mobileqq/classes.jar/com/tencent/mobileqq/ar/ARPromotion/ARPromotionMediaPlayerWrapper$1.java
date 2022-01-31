package com.tencent.mobileqq.ar.ARPromotion;

import akxz;
import akya;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class ARPromotionMediaPlayerWrapper$1
  implements Runnable
{
  public ARPromotionMediaPlayerWrapper$1(akxz paramakxz) {}
  
  public void run()
  {
    try
    {
      if (akxz.a(this.this$0)) {
        return;
      }
      if (akxz.a(this.this$0) != null)
      {
        akxz.a(this.this$0).updateTexImage();
        akxz.a(this.this$0).getTransformMatrix(akxz.a(this.this$0));
        akxz.a(this.this$0);
        akxz.a(this.this$0);
        Matrix.setIdentityM(akxz.b(this.this$0), 0);
        akxz.a(this.this$0).bind();
        akxz.a(this.this$0).drawTexture(36197, akxz.a(this.this$0), akxz.a(this.this$0), akxz.b(this.this$0));
        akxz.a(this.this$0).unbind();
        if ((akxz.b(this.this$0) == 2L) && (akxz.a(this.this$0) != null))
        {
          akxz.a(this.this$0).a(akxz.b(this.this$0), 0, akxz.a(this.this$0).getTexId());
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