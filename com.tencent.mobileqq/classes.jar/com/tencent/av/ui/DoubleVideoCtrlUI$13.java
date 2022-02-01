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
    paramAnimation = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showNoAnswerAnimation, onAnimationEnd, seq[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]");
    QLog.w(paramAnimation, 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a != null)
    {
      paramAnimation = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI;
      paramAnimation.c = true;
      paramAnimation.a.j();
    }
    paramAnimation = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a();
    if (paramAnimation != null) {
      paramAnimation.g(this.jdField_a_of_type_Long);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation)
  {
    paramAnimation = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("showNoAnswerAnimation, onAnimationStart, seq[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]");
    QLog.w(paramAnimation, 1, localStringBuilder.toString());
    paramAnimation = this.jdField_a_of_type_ComTencentAvUiDoubleVideoCtrlUI.a();
    if (paramAnimation != null) {
      paramAnimation.g(this.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.13
 * JD-Core Version:    0.7.0.1
 */