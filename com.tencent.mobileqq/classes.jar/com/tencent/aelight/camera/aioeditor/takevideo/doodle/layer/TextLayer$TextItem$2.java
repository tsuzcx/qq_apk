package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class TextLayer$TextItem$2
  implements ValueAnimator.AnimatorUpdateListener
{
  TextLayer$TextItem$2(TextLayer.TextItem paramTextItem) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.a.a.b == null) {
      return;
    }
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.a;
    float f2 = paramValueAnimator.d;
    float f3 = this.a.f;
    float f4 = 1.0F - f1;
    paramValueAnimator.l = (f2 + f3 * f4);
    paramValueAnimator = this.a;
    paramValueAnimator.m = (paramValueAnimator.e + this.a.g * f4);
    paramValueAnimator = this.a;
    paramValueAnimator.j = (paramValueAnimator.b + this.a.h * f4);
    paramValueAnimator = this.a;
    paramValueAnimator.k = (paramValueAnimator.c + this.a.i * f4);
    if (f1 == 1.0F)
    {
      this.a.a.b = null;
      this.a.a.a(4);
    }
    TextLayer.b(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.TextItem.2
 * JD-Core Version:    0.7.0.1
 */