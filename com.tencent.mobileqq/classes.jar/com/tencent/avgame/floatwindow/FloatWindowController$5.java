package com.tencent.avgame.floatwindow;

import android.animation.Animator;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;

class FloatWindowController$5
  extends D8SafeAnimatorListener
{
  FloatWindowController$5(FloatWindowController paramFloatWindowController, int paramInt1, int paramInt2) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    FloatWindowController.a(this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowController).a(this.jdField_a_of_type_Int, this.b);
    FloatWindowController.a(this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowController).d();
    FloatWindowController.a(this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowController, null);
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    FloatWindowController.a(this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowController).a(this.jdField_a_of_type_Int, this.b);
    FloatWindowController.a(this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowController).d();
    FloatWindowController.a(this.jdField_a_of_type_ComTencentAvgameFloatwindowFloatWindowController, null);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.floatwindow.FloatWindowController.5
 * JD-Core Version:    0.7.0.1
 */