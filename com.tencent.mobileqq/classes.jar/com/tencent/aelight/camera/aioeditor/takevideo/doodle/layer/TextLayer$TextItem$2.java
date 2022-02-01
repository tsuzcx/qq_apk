package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class TextLayer$TextItem$2
  implements ValueAnimator.AnimatorUpdateListener
{
  TextLayer$TextItem$2(TextLayer.TextItem paramTextItem) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.a.m.w == null) {
      return;
    }
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.a;
    float f2 = paramValueAnimator.f;
    float f3 = this.a.h;
    float f4 = 1.0F - f1;
    paramValueAnimator.D = (f2 + f3 * f4);
    paramValueAnimator = this.a;
    paramValueAnimator.E = (paramValueAnimator.g + this.a.i * f4);
    paramValueAnimator = this.a;
    paramValueAnimator.B = (paramValueAnimator.d + this.a.j * f4);
    paramValueAnimator = this.a;
    paramValueAnimator.C = (paramValueAnimator.e + this.a.k * f4);
    if (f1 == 1.0F)
    {
      this.a.m.w = null;
      this.a.m.a(4);
    }
    TextLayer.e(this.a.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.TextItem.2
 * JD-Core Version:    0.7.0.1
 */