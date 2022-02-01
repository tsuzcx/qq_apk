package com.tencent.aelight.camera.aioeditor.capture.util;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Color;
import android.view.View;

final class QIMAnimationUtils$2
  implements ValueAnimator.AnimatorUpdateListener
{
  final int a = Color.red(this.d);
  final int b = Color.green(this.d);
  final int c = Color.blue(this.d);
  
  QIMAnimationUtils$2(int paramInt, View paramView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.e.setBackgroundColor(Color.argb(i, this.a, this.b, this.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.util.QIMAnimationUtils.2
 * JD-Core Version:    0.7.0.1
 */