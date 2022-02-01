package com.tencent.av.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class NormalMenuView$1
  implements Animator.AnimatorListener
{
  NormalMenuView$1(NormalMenuView paramNormalMenuView, int paramInt, long paramLong, QavPanel.OnDismissAnimationEndListener paramOnDismissAnimationEndListener) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    int i = 4;
    this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      i = this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility();
      if (this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_Boolean) {
        break label196;
      }
      this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout.setAlpha(1.0F);
      this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout.setTranslationY(0.0F);
      QLog.w(this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_JavaLangString, 1, "HiddenMenuView, onAnimationEnd, isShow[" + this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_Boolean + "], visibility[" + i + "], seq[" + this.jdField_a_of_type_Long + "], \nlastObjectAnimator[" + this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidAnimationObjectAnimator + "], \nanimation[" + paramAnimator + "]");
      if (this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidAnimationObjectAnimator == paramAnimator)
      {
        ThreadManager.getUIHandler().post(new NormalMenuView.1.1(this));
        this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidAnimationObjectAnimator = null;
      }
      return;
      label196:
      if (this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_ComTencentAvUiNormalMenuView$ViewEvent != null) {
        this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_ComTencentAvUiNormalMenuView$ViewEvent.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      }
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    int i = 4;
    if (this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      i = this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility();
    }
    QLog.w(this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_JavaLangString, 1, "HiddenMenuView, onAnimationStart, isShow[" + this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_Boolean + "], height[" + this.jdField_a_of_type_Int + "], visibility[" + i + "], seq[" + this.jdField_a_of_type_Long + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.NormalMenuView.1
 * JD-Core Version:    0.7.0.1
 */