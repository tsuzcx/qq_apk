package com.tencent.mobileqq.ar.ARPromotion;

import akxy;
import akxz;
import alau;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

public class ARPromotionMediaPlayerWrapper$2
  implements Runnable
{
  public ARPromotionMediaPlayerWrapper$2(akxy paramakxy, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (akxy.a(this.this$0)) {}
    for (;;)
    {
      return;
      try
      {
        akxy.a(this.this$0);
        akxy.a(this.this$0);
        if ((akxy.a(this.this$0) != null) && (akxy.a(this.this$0) != null))
        {
          akxy.a(this.this$0).bind();
          akxy.a(this.this$0, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.c);
          if (!akxy.a(this.this$0).a())
          {
            akxy.a(this.this$0).a();
            alau localalau = akxy.a(this.this$0);
            akxy.a(this.this$0);
            localalau.a(alau.f);
          }
          akxy.a(this.this$0).a(akxy.a(this.this$0)[0], akxy.a(this.this$0)[1], akxy.a(this.this$0)[2], this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          akxy.a(this.this$0).b();
          akxy.a(this.this$0).unbind();
          QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupGlobalSceneRenderable ARWorldCupMediaPlayerWrapper.drawFrame softWare");
          if ((akxy.b(this.this$0) == 2L) && (akxy.a(this.this$0) != null))
          {
            akxy.a(this.this$0).a(akxy.b(this.this$0), 0, akxy.a(this.this$0).getTexId());
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