package com.tencent.avgame.floatwindow;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class FloatWindowController$4
  implements ValueAnimator.AnimatorUpdateListener
{
  FloatWindowController$4(FloatWindowController paramFloatWindowController, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (!FloatWindowController.b(this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowController))
    {
      paramValueAnimator.cancel();
      FloatWindowController.a(this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowController, null);
      return;
    }
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = this.jdField_a_of_type_Int;
    i = (int)(i + (this.b - i) * f + 0.5F);
    int j = this.c;
    j = (int)(j + (this.d - j) * f + 0.5F);
    FloatWindowController.a(this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowController).a(i, j);
    FloatWindowController.a(this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowController).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.floatwindow.FloatWindowController.4
 * JD-Core Version:    0.7.0.1
 */