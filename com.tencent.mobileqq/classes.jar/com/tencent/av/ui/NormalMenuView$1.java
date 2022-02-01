package com.tencent.av.ui;

import android.animation.Animator;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.D8SafeAnimatorListener;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class NormalMenuView$1
  extends D8SafeAnimatorListener
{
  NormalMenuView$1(NormalMenuView paramNormalMenuView, int paramInt, long paramLong, QavPanel.OnDismissAnimationEndListener paramOnDismissAnimationEndListener) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvUiNormalMenuView;
    ((NormalMenuView)localObject).jdField_a_of_type_Boolean = false;
    int i;
    if (((NormalMenuView)localObject).jdField_a_of_type_AndroidWidgetRelativeLayout != null)
    {
      i = this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility();
      if (!this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      } else if (this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_ComTencentAvUiNormalMenuView$ViewEvent != null) {
        this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_ComTencentAvUiNormalMenuView$ViewEvent.b(this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout, false);
      }
      this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout.setAlpha(1.0F);
      this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout.setTranslationY(0.0F);
    }
    else
    {
      i = 4;
    }
    localObject = this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HiddenMenuView, onAnimationEnd, isShow[");
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
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidAnimationObjectAnimator == paramAnimator)
    {
      ThreadManager.getUIHandler().post(new NormalMenuView.1.1(this));
      this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidAnimationObjectAnimator = null;
    }
  }
  
  public void onAnimationEnd(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationEnd(paramAnimator);
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    int i;
    if (this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout != null) {
      i = this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility();
    } else {
      i = 4;
    }
    paramAnimator = this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HiddenMenuView, onAnimationStart, isShow[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvUiNormalMenuView.jdField_a_of_type_Boolean);
    localStringBuilder.append("], height[");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append("], visibility[");
    localStringBuilder.append(i);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]");
    QLog.w(paramAnimator, 1, localStringBuilder.toString());
  }
  
  public void onAnimationStart(Animator paramAnimator, boolean paramBoolean)
  {
    onAnimationStart(paramAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.NormalMenuView.1
 * JD-Core Version:    0.7.0.1
 */