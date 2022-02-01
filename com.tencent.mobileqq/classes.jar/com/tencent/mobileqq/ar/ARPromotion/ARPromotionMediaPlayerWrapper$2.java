package com.tencent.mobileqq.ar.ARPromotion;

import apby;
import apbz;
import apev;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

public class ARPromotionMediaPlayerWrapper$2
  implements Runnable
{
  public void run()
  {
    if (apby.a(this.this$0)) {}
    for (;;)
    {
      return;
      try
      {
        apby.a(this.this$0);
        apby.a(this.this$0);
        if ((apby.a(this.this$0) != null) && (apby.a(this.this$0) != null))
        {
          apby.a(this.this$0).bind();
          apby.a(this.this$0, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.c);
          if (!apby.a(this.this$0).a())
          {
            apby.a(this.this$0).a();
            apby.a(this.this$0).a(apev.g);
          }
          apby.a(this.this$0).a(apby.a(this.this$0)[0], apby.a(this.this$0)[1], apby.a(this.this$0)[2], this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          apby.a(this.this$0).b();
          apby.a(this.this$0).unbind();
          if ((apby.b(this.this$0) == 2L) && (apby.a(this.this$0) != null))
          {
            apby.a(this.this$0).a(apby.b(this.this$0), 0, apby.a(this.this$0).getTexId());
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