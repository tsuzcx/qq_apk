package com.tencent.mobileqq.ar.ARPromotion;

import akjn;
import akjo;
import akmj;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

public class ARPromotionMediaPlayerWrapper$2
  implements Runnable
{
  public ARPromotionMediaPlayerWrapper$2(akjn paramakjn, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (akjn.a(this.this$0)) {}
    for (;;)
    {
      return;
      try
      {
        akjn.a(this.this$0);
        akjn.a(this.this$0);
        if ((akjn.a(this.this$0) != null) && (akjn.a(this.this$0) != null))
        {
          akjn.a(this.this$0).bind();
          akjn.a(this.this$0, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.c);
          if (!akjn.a(this.this$0).a())
          {
            akjn.a(this.this$0).a();
            akmj localakmj = akjn.a(this.this$0);
            akjn.a(this.this$0);
            localakmj.a(akmj.f);
          }
          akjn.a(this.this$0).a(akjn.a(this.this$0)[0], akjn.a(this.this$0)[1], akjn.a(this.this$0)[2], this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          akjn.a(this.this$0).b();
          akjn.a(this.this$0).unbind();
          QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupGlobalSceneRenderable ARWorldCupMediaPlayerWrapper.drawFrame softWare");
          if ((akjn.b(this.this$0) == 2L) && (akjn.a(this.this$0) != null))
          {
            akjn.a(this.this$0).a(akjn.b(this.this$0), 0, akjn.a(this.this$0).getTexId());
            return;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.i("ARWorldCupMediaPlayerWrapper", 1, "drawSoftFrame render error happen");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.2
 * JD-Core Version:    0.7.0.1
 */