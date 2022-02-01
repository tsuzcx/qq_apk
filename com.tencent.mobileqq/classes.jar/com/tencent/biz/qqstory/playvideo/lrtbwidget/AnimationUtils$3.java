package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.widget.ImageView;

final class AnimationUtils$3
  implements ValueAnimator.AnimatorUpdateListener
{
  AnimationUtils$3(ViewGroup paramViewGroup, ImageView paramImageView1, ImageView paramImageView2) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f1 = ((Float)paramValueAnimator.getAnimatedValue("scaleX")).floatValue();
    float f2 = ((Float)paramValueAnimator.getAnimatedValue("scaleY")).floatValue();
    this.a.setPivotX(0.5F);
    this.a.setScaleX(f1);
    this.a.setPivotY(0.5F);
    this.a.setScaleY(f2);
    this.a.setTranslationX(((Float)paramValueAnimator.getAnimatedValue("translateX")).floatValue());
    this.a.setTranslationY(((Float)paramValueAnimator.getAnimatedValue("translateY")).floatValue());
    int i = this.a.getWidth();
    int j = this.a.getHeight();
    if (f1 < f2)
    {
      f1 = f2 / f1;
      f2 = i;
      this.b.setPivotX(0.5F);
      this.b.setScaleX(f1);
      this.b.setTranslationX((f2 - f2 * f1) * 0.5F);
      this.b.setPivotY(0.5F);
      this.b.setScaleY(1.0F);
      this.b.setTranslationY(0.0F);
    }
    else if (f2 < f1)
    {
      this.b.setPivotX(0.5F);
      this.b.setScaleX(1.0F);
      this.b.setTranslationX(0.0F);
      f1 /= f2;
      f2 = j;
      this.b.setPivotY(0.5F);
      this.b.setScaleY(f1);
      this.b.setTranslationY((f2 - f2 * f1) * 0.5F);
    }
    this.c.setAlpha(((Float)paramValueAnimator.getAnimatedValue("backgroundAlpha")).floatValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationUtils.3
 * JD-Core Version:    0.7.0.1
 */