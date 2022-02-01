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
    float f1 = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    int i = (int)(this.jdField_a_of_type_Int + (this.b - this.jdField_a_of_type_Int) * f1 + 0.5F);
    float f2 = this.c;
    int j = (int)(f1 * (this.d - this.c) + f2 + 0.5F);
    FloatWindowController.a(this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowController).a(i, j);
    FloatWindowController.a(this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowController).d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.floatwindow.FloatWindowController.4
 * JD-Core Version:    0.7.0.1
 */