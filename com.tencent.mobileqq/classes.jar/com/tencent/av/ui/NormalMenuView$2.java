package com.tencent.av.ui;

import android.animation.Animator;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.qphone.base.util.QLog;

class NormalMenuView$2
  extends D8SafeAnimatorListener
{
  NormalMenuView$2(NormalMenuView paramNormalMenuView, int paramInt, long paramLong) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      i = this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility();
      if (!this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
        if (this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_ComTencentAvUiNormalMenuView$ViewEvent != null) {
          this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_ComTencentAvUiNormalMenuView$ViewEvent.a(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
        }
      }
      this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout.setAlpha(1.0F);
      this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout.setTranslationY(0.0F);
    }
    else
    {
      i = 4;
    }
    String str = this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShowMenuView, onAnimationEnd, isShow[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_Boolean);
    localStringBuilder.append("], visibility[");
    localStringBuilder.append(i);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("], \nlastObjectAnimator[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidAnimationObjectAnimator);
    localStringBuilder.append("], \nanimation[");
    localStringBuilder.append(paramAnimator);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidAnimationObjectAnimator == paramAnimator) {
      this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidAnimationObjectAnimator = null;
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      i = this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility();
      this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    else
    {
      i = 4;
    }
    paramAnimator = this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShowMenuView, onAnimationStart, height[");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("], isShow[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_Boolean);
    localStringBuilder.append("], visibility[");
    localStringBuilder.append(i);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]");
    QLog.w(paramAnimator, 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.NormalMenuView.2
 * JD-Core Version:    0.7.0.1
 */