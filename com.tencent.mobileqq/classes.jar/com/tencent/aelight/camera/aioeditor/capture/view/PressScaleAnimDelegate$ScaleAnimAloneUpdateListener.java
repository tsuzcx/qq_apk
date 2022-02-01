package com.tencent.aelight.camera.aioeditor.capture.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

final class PressScaleAnimDelegate$ScaleAnimAloneUpdateListener
  extends D8SafeAnimatorListener
  implements ValueAnimator.AnimatorUpdateListener
{
  final View a;
  final View.OnClickListener b;
  
  PressScaleAnimDelegate$ScaleAnimAloneUpdateListener(View paramView, View.OnClickListener paramOnClickListener)
  {
    this.a = paramView;
    this.b = paramOnClickListener;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.b;
    if (paramAnimator != null) {
      paramAnimator.onClick(this.a);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.a.setScaleX(f);
    this.a.setScaleY(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.PressScaleAnimDelegate.ScaleAnimAloneUpdateListener
 * JD-Core Version:    0.7.0.1
 */