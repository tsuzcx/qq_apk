package com.tencent.mobileqq.apollo.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class CmShowAESurfaceView$3
  implements ValueAnimator.AnimatorUpdateListener
{
  int jdField_a_of_type_Int = 0;
  
  CmShowAESurfaceView$3(CmShowAESurfaceView paramCmShowAESurfaceView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (this.jdField_a_of_type_Int > i)
    {
      CmShowAESurfaceView.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView, CmShowAESurfaceView.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView) + CmShowAESurfaceView.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView));
      this.jdField_a_of_type_ComTencentMobileqqApolloViewCmShowAESurfaceView.requestRender();
    }
    this.jdField_a_of_type_Int = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.CmShowAESurfaceView.3
 * JD-Core Version:    0.7.0.1
 */