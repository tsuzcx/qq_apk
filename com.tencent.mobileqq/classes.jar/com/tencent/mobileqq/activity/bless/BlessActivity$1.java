package com.tencent.mobileqq.activity.bless;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.RelativeLayout;

class BlessActivity$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  BlessActivity$1(BlessActivity paramBlessActivity, RelativeLayout paramRelativeLayout) {}
  
  public void onGlobalLayout()
  {
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    BlessActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight());
    BlessActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity, this.jdField_a_of_type_AndroidWidgetRelativeLayout.getWidth());
    BlessActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityBlessBlessActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessActivity.1
 * JD-Core Version:    0.7.0.1
 */