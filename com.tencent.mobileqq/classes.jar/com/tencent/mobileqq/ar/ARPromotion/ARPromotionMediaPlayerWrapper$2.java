package com.tencent.mobileqq.ar.ARPromotion;

import com.tencent.mobileqq.ar.ARRenderModel.GreetingYUVProgram;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

class ARPromotionMediaPlayerWrapper$2
  implements Runnable
{
  public void run()
  {
    if (ARPromotionMediaPlayerWrapper.a(this.this$0)) {
      return;
    }
    try
    {
      ARPromotionMediaPlayerWrapper.a(this.this$0);
      ARPromotionMediaPlayerWrapper.a(this.this$0);
      if (ARPromotionMediaPlayerWrapper.a(this.this$0) != null)
      {
        if (ARPromotionMediaPlayerWrapper.a(this.this$0) == null) {
          return;
        }
        ARPromotionMediaPlayerWrapper.a(this.this$0).bind();
        ARPromotionMediaPlayerWrapper.a(this.this$0, this.jdField_a_of_type_ArrayOfByte, this.jdField_b_of_type_ArrayOfByte, this.c);
        if (!ARPromotionMediaPlayerWrapper.a(this.this$0).a())
        {
          ARPromotionMediaPlayerWrapper.a(this.this$0).a();
          ARPromotionMediaPlayerWrapper.a(this.this$0).a(GreetingYUVProgram.g);
        }
        ARPromotionMediaPlayerWrapper.a(this.this$0).a(ARPromotionMediaPlayerWrapper.a(this.this$0)[0], ARPromotionMediaPlayerWrapper.a(this.this$0)[1], ARPromotionMediaPlayerWrapper.a(this.this$0)[2], this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        ARPromotionMediaPlayerWrapper.a(this.this$0).b();
        ARPromotionMediaPlayerWrapper.a(this.this$0).unbind();
        if ((ARPromotionMediaPlayerWrapper.b(this.this$0) == 2L) && (ARPromotionMediaPlayerWrapper.a(this.this$0) != null))
        {
          ARPromotionMediaPlayerWrapper.a(this.this$0).a(ARPromotionMediaPlayerWrapper.b(this.this$0), 0, ARPromotionMediaPlayerWrapper.a(this.this$0).getTexId());
          QLog.d("ARWorldCupMediaPlayerWrapper", 2, "ARWorldCupGlobalSceneRenderable ARWorldCupMediaPlayerWrapper.drawFrame softWare");
        }
      }
      else {}
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.i("ARWorldCupMediaPlayerWrapper", 1, "drawSoftFrame render error happen");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotion.ARPromotionMediaPlayerWrapper.2
 * JD-Core Version:    0.7.0.1
 */