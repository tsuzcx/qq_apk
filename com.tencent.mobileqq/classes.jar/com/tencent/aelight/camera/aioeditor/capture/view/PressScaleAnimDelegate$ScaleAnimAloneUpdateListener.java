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
  final View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  final View jdField_a_of_type_AndroidViewView;
  
  PressScaleAnimDelegate$ScaleAnimAloneUpdateListener(View paramView, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.jdField_a_of_type_AndroidViewView$OnClickListener;
    if (paramAnimator != null) {
      paramAnimator.onClick(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.jdField_a_of_type_AndroidViewView.setScaleX(f);
    this.jdField_a_of_type_AndroidViewView.setScaleY(f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.PressScaleAnimDelegate.ScaleAnimAloneUpdateListener
 * JD-Core Version:    0.7.0.1
 */