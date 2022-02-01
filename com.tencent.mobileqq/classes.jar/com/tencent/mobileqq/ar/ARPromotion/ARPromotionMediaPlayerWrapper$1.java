package com.tencent.mobileqq.ar.ARPromotion;

import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import aoru;
import aorv;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tencent.ttpic.openapi.filter.TextureRender;

public class ARPromotionMediaPlayerWrapper$1
  implements Runnable
{
  public ARPromotionMediaPlayerWrapper$1(aoru paramaoru) {}
  
  public void run()
  {
    try
    {
      if (aoru.a(this.this$0)) {
        return;
      }
      if (aoru.a(this.this$0) != null)
      {
        aoru.a(this.this$0).updateTexImage();
        aoru.a(this.this$0).getTransformMatrix(aoru.a(this.this$0));
        aoru.a(this.this$0);
        aoru.a(this.this$0);
        Matrix.setIdentityM(aoru.b(this.this$0), 0);
        aoru.a(this.this$0).bind();
        aoru.a(this.this$0).drawTexture(36197, aoru.a(this.this$0), aoru.a(this.this$0), aoru.b(this.this$0));
        aoru.a(this.this$0).unbind();
        if ((aoru.b(this.this$0) == 2L) && (aoru.a(this.this$0) != null))
        {
          aoru.a(this.this$0).a(aoru.b(this.this$0), 0, aoru.a(this.this$0).getTexId());
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