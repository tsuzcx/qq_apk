package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build.VERSION;
import android.widget.ImageView;

class AnimationUtils$4$2
  extends AnimatorListenerAdapter
{
  AnimationUtils$4$2(AnimationUtils.4 param4) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (Build.VERSION.SDK_INT >= 16) {
      this.a.c.setImageAlpha(255);
    } else {
      this.a.c.setImageResource(2130853309);
    }
    this.a.c.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationUtils.4.2
 * JD-Core Version:    0.7.0.1
 */