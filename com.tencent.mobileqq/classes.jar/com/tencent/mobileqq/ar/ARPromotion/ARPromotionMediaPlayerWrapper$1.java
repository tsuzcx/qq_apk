package com.tencent.mobileqq.ar.ARPromotion;

import akjn;
import akjo;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class ARPromotionMediaPlayerWrapper$1
  implements Runnable
{
  public ARPromotionMediaPlayerWrapper$1(akjn paramakjn) {}
  
  public void run()
  {
    try
    {
      if (akjn.a(this.this$0)) {
        return;
      }
      if (akjn.a(this.this$0) != null)
      {
        akjn.a(this.this$0).updateTexImage();
        akjn.a(this.this$0).getTransformMatrix(akjn.a(this.this$0));
        akjn.a(this.this$0);
        akjn.a(this.this$0);
        Matrix.setIdentityM(akjn.b(this.this$0), 0);
        akjn.a(this.this$0).bind();
        akjn.a(this.this$0).drawTexture(36197, akjn.a(this.this$0), akjn.a(this.this$0), akjn.b(this.this$0));
        akjn.a(this.this$0).unbind();
        if ((akjn.b(this.this$0) == 2L) && (akjn.a(this.this$0) != null))
        {
          akjn.a(this.this$0).a(akjn.b(this.this$0), 0, akjn.a(this.this$0).getTexId());
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