package com.tencent.biz.qqstory.takevideo.doodle.layer;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class TextLayer$TextItem$1
  implements ValueAnimator.AnimatorUpdateListener
{
  TextLayer$TextItem$1(TextLayer.TextItem paramTextItem) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (TextLayer.a(this.a.a) == null) {
      return;
    }
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.l = (this.a.d + this.a.f * f);
    this.a.m = (this.a.e + this.a.g * f);
    this.a.j = (this.a.b + this.a.h * f);
    this.a.k = (this.a.c + this.a.i * f);
    if (this.a.a.a != null) {
      this.a.a.a.a(f);
    }
    if (f == 1.0F) {
      TextLayer.a(this.a.a, null);
    }
    TextLayer.a(this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem.1
 * JD-Core Version:    0.7.0.1
 */