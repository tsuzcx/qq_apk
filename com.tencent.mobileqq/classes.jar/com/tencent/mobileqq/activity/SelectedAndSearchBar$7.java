package com.tencent.mobileqq.activity;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;

class SelectedAndSearchBar$7
  implements ValueAnimator.AnimatorUpdateListener
{
  SelectedAndSearchBar$7(SelectedAndSearchBar paramSelectedAndSearchBar, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams.topMargin = i;
    SelectedAndSearchBar.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectedAndSearchBar).setLayoutParams(this.jdField_a_of_type_AndroidWidgetRelativeLayout$LayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SelectedAndSearchBar.7
 * JD-Core Version:    0.7.0.1
 */