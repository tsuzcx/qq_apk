package com.tencent.mobileqq.ar.ARPromotion;

import akxz;
import akya;
import alav;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

public class ARPromotionMediaPlayerWrapper$2
  implements Runnable
{
  public ARPromotionMediaPlayerWrapper$2(akxz paramakxz, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (akxz.a(this.this$0)) {}
    for (;;)
    {
      return;
      try
      {
        akxz.a(this.this$0);
        akxz.a(this.this$0);
        if ((akxz.a(this.this$0) != null) && (akxz.a(this.this$0) != null))
        {
          akxz.a(this.this$0).bind();
          akxz.a(this.this$0, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.c);
          if (!akxz.a(this.this$0).a())
          {
            akxz.a(this.this$0).a();
            alav localalav = akxz.a(this.this$0);
            akxz.a(this.this$0);
            localalav.a(alav.f);
          }
          akxz.a(this.this$0).a(akxz.a(this.this$0)[0], akxz.a(this.this$0)[1], akxz.a(this.this$0)[2], this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          akxz.a(this.this$0).b();
          akxz.a(this.this$0).unbind();
          QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupGlobalSceneRenderable ARWorldCupMediaPlayerWrapper.drawFrame softWare");
          if ((akxz.b(this.this$0) == 2L) && (akxz.a(this.this$0) != null))
          {
            akxz.a(this.this$0).a(akxz.b(this.this$0), 0, akxz.a(this.this$0).getTexId());
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