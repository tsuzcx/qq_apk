package com.tencent.mobileqq.ar.ARPromotion;

import aoru;
import aorv;
import aouq;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

public class ARPromotionMediaPlayerWrapper$2
  implements Runnable
{
  public void run()
  {
    if (aoru.a(this.this$0)) {}
    for (;;)
    {
      return;
      try
      {
        aoru.a(this.this$0);
        aoru.a(this.this$0);
        if ((aoru.a(this.this$0) != null) && (aoru.a(this.this$0) != null))
        {
          aoru.a(this.this$0).bind();
          aoru.a(this.this$0, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.c);
          if (!aoru.a(this.this$0).a())
          {
            aoru.a(this.this$0).a();
            aouq localaouq = aoru.a(this.this$0);
            aoru.a(this.this$0);
            localaouq.a(aouq.g);
          }
          aoru.a(this.this$0).a(aoru.a(this.this$0)[0], aoru.a(this.this$0)[1], aoru.a(this.this$0)[2], this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          aoru.a(this.this$0).b();
          aoru.a(this.this$0).unbind();
          if ((aoru.b(this.this$0) == 2L) && (aoru.a(this.this$0) != null))
          {
            aoru.a(this.this$0).a(aoru.b(this.this$0), 0, aoru.a(this.this$0).getTexId());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.2
 * JD-Core Version:    0.7.0.1
 */