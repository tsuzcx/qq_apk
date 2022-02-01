package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class TextLayer$TextItem$1
  implements ValueAnimator.AnimatorUpdateListener
{
  TextLayer$TextItem$1(TextLayer.TextItem paramTextItem) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.a.m.w == null) {
      return;
    }
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.a;
    paramValueAnimator.D = (paramValueAnimator.f + this.a.h * f);
    paramValueAnimator = this.a;
    paramValueAnimator.E = (paramValueAnimator.g + this.a.i * f);
    paramValueAnimator = this.a;
    paramValueAnimator.B = (paramValueAnimator.d + this.a.j * f);
    paramValueAnimator = this.a;
    paramValueAnimator.C = (paramValueAnimator.e + this.a.k * f);
    if (this.a.m.r != null) {
      this.a.m.r.a(f);
    }
    if (f == 1.0F) {
      this.a.m.a(5);
    }
    TextLayer.d(this.a.m);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.TextLayer.TextItem.1
 * JD-Core Version:    0.7.0.1
 */