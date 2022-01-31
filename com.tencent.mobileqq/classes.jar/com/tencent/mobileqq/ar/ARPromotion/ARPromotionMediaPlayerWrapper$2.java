package com.tencent.mobileqq.ar.ARPromotion;

import amtd;
import amte;
import amvz;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

public class ARPromotionMediaPlayerWrapper$2
  implements Runnable
{
  public ARPromotionMediaPlayerWrapper$2(amtd paramamtd, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (amtd.a(this.this$0)) {}
    for (;;)
    {
      return;
      try
      {
        amtd.a(this.this$0);
        amtd.a(this.this$0);
        if ((amtd.a(this.this$0) != null) && (amtd.a(this.this$0) != null))
        {
          amtd.a(this.this$0).bind();
          amtd.a(this.this$0, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.c);
          if (!amtd.a(this.this$0).a())
          {
            amtd.a(this.this$0).a();
            amvz localamvz = amtd.a(this.this$0);
            amtd.a(this.this$0);
            localamvz.a(amvz.f);
          }
          amtd.a(this.this$0).a(amtd.a(this.this$0)[0], amtd.a(this.this$0)[1], amtd.a(this.this$0)[2], this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          amtd.a(this.this$0).b();
          amtd.a(this.this$0).unbind();
          if ((amtd.b(this.this$0) == 2L) && (amtd.a(this.this$0) != null))
          {
            amtd.a(this.this$0).a(amtd.b(this.this$0), 0, amtd.a(this.this$0).getTexId());
            QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupGlobalSceneRenderable ARWorldCupMediaPlayerWrapper.drawFrame softWare");
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