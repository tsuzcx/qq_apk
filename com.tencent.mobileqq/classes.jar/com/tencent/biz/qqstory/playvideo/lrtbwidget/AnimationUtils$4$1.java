package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.os.Build.VERSION;
import android.widget.ImageView;

class AnimationUtils$4$1
  implements ValueAnimator.AnimatorUpdateListener
{
  AnimationUtils$4$1(AnimationUtils.4 param4) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      this.a.c.setImageAlpha(((Integer)paramValueAnimator.getAnimatedValue()).intValue());
      return;
    }
    this.a.c.setImageResource(2130853309);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationUtils.4.1
 * JD-Core Version:    0.7.0.1
 */