package com.tencent.mobileqq.ar.ARPromotion;

import anyw;
import anyx;
import aobt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

public class ARPromotionMediaPlayerWrapper$2
  implements Runnable
{
  public void run()
  {
    if (anyw.a(this.this$0)) {}
    for (;;)
    {
      return;
      try
      {
        anyw.a(this.this$0);
        anyw.a(this.this$0);
        if ((anyw.a(this.this$0) != null) && (anyw.a(this.this$0) != null))
        {
          anyw.a(this.this$0).bind();
          anyw.a(this.this$0, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.c);
          if (!anyw.a(this.this$0).a())
          {
            anyw.a(this.this$0).a();
            anyw.a(this.this$0).a(aobt.g);
          }
          anyw.a(this.this$0).a(anyw.a(this.this$0)[0], anyw.a(this.this$0)[1], anyw.a(this.this$0)[2], this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          anyw.a(this.this$0).b();
          anyw.a(this.this$0).unbind();
          if ((anyw.b(this.this$0) == 2L) && (anyw.a(this.this$0) != null))
          {
            anyw.a(this.this$0).a(anyw.b(this.this$0), 0, anyw.a(this.this$0).getTexId());
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