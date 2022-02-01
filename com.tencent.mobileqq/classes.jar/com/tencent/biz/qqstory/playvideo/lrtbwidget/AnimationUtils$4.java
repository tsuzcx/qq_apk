package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.qqstory.support.logging.SLog;

final class AnimationUtils$4
  extends AnimatorListenerAdapter
{
  AnimationUtils$4(Animator.AnimatorListener paramAnimatorListener, ViewGroup paramViewGroup, ImageView paramImageView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    super.onAnimationCancel(paramAnimator);
    this.a.onAnimationCancel(paramAnimator);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    SLog.b("Q.qqstory.playernew.AnimationUtils", "doEnterAnimation, onAnimationEnd");
    this.b.removeView(this.c);
    this.a.onAnimationEnd(paramAnimator);
    paramAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
    paramAnimator.setStartDelay(400L);
    paramAnimator.setDuration(400L);
    paramAnimator.addUpdateListener(new AnimationUtils.4.1(this));
    paramAnimator.addListener(new AnimationUtils.4.2(this));
    paramAnimator.start();
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    super.onAnimationStart(paramAnimator);
    this.a.onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.AnimationUtils.4
 * JD-Core Version:    0.7.0.1
 */