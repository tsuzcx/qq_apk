package com.tencent.mobileqq.activity.aio;

import android.text.TextUtils;
import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class IntimateInfoView$5
  implements ActionSheet.OnButtonClickListener
{
  IntimateInfoView$5(IntimateInfoView paramIntimateInfoView, String paramString) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    IntimateInfoView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView).dismiss();
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        if (IntimateInfoView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView))
        {
          IntimateInfoView.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView);
          return;
        }
        IntimateInfoView.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView);
      }
    }
    else
    {
      if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
      {
        IntimateInfoView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView, this.jdField_a_of_type_JavaLangString);
        return;
      }
      if (IntimateInfoView.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView))
      {
        IntimateInfoView.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView);
        return;
      }
      IntimateInfoView.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioIntimateInfoView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoView.5
 * JD-Core Version:    0.7.0.1
 */