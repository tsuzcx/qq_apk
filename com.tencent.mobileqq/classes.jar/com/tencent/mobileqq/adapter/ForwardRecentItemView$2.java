package com.tencent.mobileqq.adapter;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;

class ForwardRecentItemView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  ForwardRecentItemView$2(ForwardRecentItemView paramForwardRecentItemView, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.leftMargin = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.jdField_a_of_type_AndroidWidgetRelativeLayout.setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
    this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
    this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView.b);
    if (AppSetting.d)
    {
      paramValueAnimator = this.jdField_a_of_type_ComTencentMobileqqAdapterForwardRecentItemView;
      paramValueAnimator.setContentDescription(paramValueAnimator.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ForwardRecentItemView.2
 * JD-Core Version:    0.7.0.1
 */