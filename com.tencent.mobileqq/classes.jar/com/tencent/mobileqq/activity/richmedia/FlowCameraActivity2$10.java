package com.tencent.mobileqq.activity.richmedia;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;

class FlowCameraActivity2$10
  implements ValueAnimator.AnimatorUpdateListener
{
  FlowCameraActivity2$10(FlowCameraActivity2 paramFlowCameraActivity2, int paramInt) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.g.setPadding(0, 0, 0, paramValueAnimator.intValue());
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaFlowCameraActivity2.e.setPadding(0, this.jdField_a_of_type_Int - paramValueAnimator.intValue(), 0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2.10
 * JD-Core Version:    0.7.0.1
 */