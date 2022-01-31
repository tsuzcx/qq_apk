package com.tencent.mobileqq.ar.ARPromotion;

import akxy;
import akxz;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class ARPromotionMediaPlayerWrapper$1
  implements Runnable
{
  public ARPromotionMediaPlayerWrapper$1(akxy paramakxy) {}
  
  public void run()
  {
    try
    {
      if (akxy.a(this.this$0)) {
        return;
      }
      if (akxy.a(this.this$0) != null)
      {
        akxy.a(this.this$0).updateTexImage();
        akxy.a(this.this$0).getTransformMatrix(akxy.a(this.this$0));
        akxy.a(this.this$0);
        akxy.a(this.this$0);
        Matrix.setIdentityM(akxy.b(this.this$0), 0);
        akxy.a(this.this$0).bind();
        akxy.a(this.this$0).drawTexture(36197, akxy.a(this.this$0), akxy.a(this.this$0), akxy.b(this.this$0));
        akxy.a(this.this$0).unbind();
        if ((akxy.b(this.this$0) == 2L) && (akxy.a(this.this$0) != null))
        {
          akxy.a(this.this$0).a(akxy.b(this.this$0), 0, akxy.a(this.this$0).getTexId());
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