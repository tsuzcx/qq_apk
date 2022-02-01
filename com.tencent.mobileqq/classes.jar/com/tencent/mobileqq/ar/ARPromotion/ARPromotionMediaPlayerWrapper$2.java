package com.tencent.mobileqq.ar.ARPromotion;

import apfk;
import apfl;
import apig;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

public class ARPromotionMediaPlayerWrapper$2
  implements Runnable
{
  public void run()
  {
    if (apfk.a(this.this$0)) {}
    for (;;)
    {
      return;
      try
      {
        apfk.a(this.this$0);
        apfk.a(this.this$0);
        if ((apfk.a(this.this$0) != null) && (apfk.a(this.this$0) != null))
        {
          apfk.a(this.this$0).bind();
          apfk.a(this.this$0, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.c);
          if (!apfk.a(this.this$0).a())
          {
            apfk.a(this.this$0).a();
            apig localapig = apfk.a(this.this$0);
            apfk.a(this.this$0);
            localapig.a(apig.g);
          }
          apfk.a(this.this$0).a(apfk.a(this.this$0)[0], apfk.a(this.this$0)[1], apfk.a(this.this$0)[2], this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          apfk.a(this.this$0).b();
          apfk.a(this.this$0).unbind();
          if ((apfk.b(this.this$0) == 2L) && (apfk.a(this.this$0) != null))
          {
            apfk.a(this.this$0).a(apfk.b(this.this$0), 0, apfk.a(this.this$0).getTexId());
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