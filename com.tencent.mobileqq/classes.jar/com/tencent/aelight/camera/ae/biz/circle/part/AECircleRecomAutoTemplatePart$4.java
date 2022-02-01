package com.tencent.aelight.camera.ae.biz.circle.part;

import android.widget.FrameLayout;
import com.tencent.aelight.camera.aeeditor.view.AEEditorLoadingView;

class AECircleRecomAutoTemplatePart$4
  implements Runnable
{
  AECircleRecomAutoTemplatePart$4(AECircleRecomAutoTemplatePart paramAECircleRecomAutoTemplatePart) {}
  
  public void run()
  {
    if (this.this$0.b == null)
    {
      AECircleRecomAutoTemplatePart localAECircleRecomAutoTemplatePart = this.this$0;
      localAECircleRecomAutoTemplatePart.b = new AEEditorLoadingView(localAECircleRecomAutoTemplatePart.g());
      this.this$0.b.a(2);
      this.this$0.a.addView(this.this$0.b);
      this.this$0.b.setLoadingListener(new AECircleRecomAutoTemplatePart.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.biz.circle.part.AECircleRecomAutoTemplatePart.4
 * JD-Core Version:    0.7.0.1
 */