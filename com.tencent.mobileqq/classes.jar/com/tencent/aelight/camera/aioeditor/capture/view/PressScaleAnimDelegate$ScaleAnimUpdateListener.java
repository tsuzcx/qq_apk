package com.tencent.aelight.camera.aioeditor.capture.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

final class PressScaleAnimDelegate$ScaleAnimUpdateListener
  implements ValueAnimator.AnimatorUpdateListener
{
  final View a;
  float b = 1.0F;
  
  PressScaleAnimDelegate$ScaleAnimUpdateListener(View paramView)
  {
    this.a = paramView;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    this.b = f;
    this.a.invalidate();
    if (QLog.isColorLevel())
    {
      paramValueAnimator = new StringBuilder();
      paramValueAnimator.append("do scale animtion, scale=");
      paramValueAnimator.append(f);
      QLog.d("PressScaleAnimDelegate ", 2, paramValueAnimator.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.PressScaleAnimDelegate.ScaleAnimUpdateListener
 * JD-Core Version:    0.7.0.1
 */