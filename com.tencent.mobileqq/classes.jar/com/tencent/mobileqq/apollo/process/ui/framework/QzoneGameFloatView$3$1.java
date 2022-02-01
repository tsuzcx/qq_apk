package com.tencent.mobileqq.apollo.process.ui.framework;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout.LayoutParams;

class QzoneGameFloatView$3$1
  implements Animation.AnimationListener
{
  QzoneGameFloatView$3$1(QzoneGameFloatView.3 param3, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    paramAnimation = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    paramAnimation.leftMargin = this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView$3.e;
    paramAnimation.topMargin = this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView$3.f;
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(paramAnimation);
    this.jdField_a_of_type_AndroidViewView.clearAnimation();
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqApolloProcessUiFrameworkQzoneGameFloatView$3.a = false;
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.framework.QzoneGameFloatView.3.1
 * JD-Core Version:    0.7.0.1
 */