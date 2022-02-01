package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class TextLayer$TextItem$1
  implements ValueAnimator.AnimatorUpdateListener
{
  TextLayer$TextItem$1(TextLayer.TextItem paramTextItem) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.a.a.b == null) {
      return;
    }
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.a;
    paramValueAnimator.l = (paramValueAnimator.d + this.a.f * f);
    paramValueAnimator = this.a;
    paramValueAnimator.m = (paramValueAnimator.e + this.a.g * f);
    paramValueAnimator = this.a;
    paramValueAnimator.j = (paramValueAnimator.b + this.a.h * f);
    paramValueAnimator = this.a;
    paramValueAnimator.k = (paramValueAnimator.c + this.a.i * f);
    if (this.a.a.a != null) {
      this.a.a.a.a(f);
    }
    if (f == 1.0F) {
      this.a.a.a(5);
    }
    TextLayer.a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.TextItem.1
 * JD-Core Version:    0.7.0.1
 */