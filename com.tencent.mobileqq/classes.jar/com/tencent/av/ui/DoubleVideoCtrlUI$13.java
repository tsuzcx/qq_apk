package com.tencent.av.ui;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.qphone.base.util.QLog;

class DoubleVideoCtrlUI$13
  implements Animation.AnimationListener
{
  DoubleVideoCtrlUI$13(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, long paramLong) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    QLog.w(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.d, 1, "showNoAnswerAnimation, onAnimationEnd, seq[" + this.jdField_a_of_type_Long + "]");
    if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a != null)
    {
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.c = true;
      this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a.j();
    }
    paramAnimation = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a();
    if (paramAnimation != null) {
      paramAnimation.g(this.jdField_a_of_type_Long);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    QLog.w(this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.d, 1, "showNoAnswerAnimation, onAnimationStart, seq[" + this.jdField_a_of_type_Long + "]");
    paramAnimation = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a();
    if (paramAnimation != null) {
      paramAnimation.g(this.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.13
 * JD-Core Version:    0.7.0.1
 */