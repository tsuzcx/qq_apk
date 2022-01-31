package com.tencent.mobileqq.ar.ARPromotion;

import amoo;
import amop;
import amrk;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

public class ARPromotionMediaPlayerWrapper$2
  implements Runnable
{
  public ARPromotionMediaPlayerWrapper$2(amoo paramamoo, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (amoo.a(this.this$0)) {}
    for (;;)
    {
      return;
      try
      {
        amoo.a(this.this$0);
        amoo.a(this.this$0);
        if ((amoo.a(this.this$0) != null) && (amoo.a(this.this$0) != null))
        {
          amoo.a(this.this$0).bind();
          amoo.a(this.this$0, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.c);
          if (!amoo.a(this.this$0).a())
          {
            amoo.a(this.this$0).a();
            amrk localamrk = amoo.a(this.this$0);
            amoo.a(this.this$0);
            localamrk.a(amrk.f);
          }
          amoo.a(this.this$0).a(amoo.a(this.this$0)[0], amoo.a(this.this$0)[1], amoo.a(this.this$0)[2], this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          amoo.a(this.this$0).b();
          amoo.a(this.this$0).unbind();
          QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupGlobalSceneRenderable ARWorldCupMediaPlayerWrapper.drawFrame softWare");
          if ((amoo.b(this.this$0) == 2L) && (amoo.a(this.this$0) != null))
          {
            amoo.a(this.this$0).a(amoo.b(this.this$0), 0, amoo.a(this.this$0).getTexId());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.2
 * JD-Core Version:    0.7.0.1
 */