package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AIORevokeMsgHelper$1
  implements ActionSheet.OnButtonClickListener
{
  AIORevokeMsgHelper$1(AIORevokeMsgHelper paramAIORevokeMsgHelper, boolean paramBoolean, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        AIORevokeMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIORevokeMsgHelper, "0X800A7F6", this.jdField_a_of_type_Boolean);
      }
    }
    else
    {
      if (AIORevokeMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIORevokeMsgHelper) != null)
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIORevokeMsgHelper;
        AIORevokeMsgHelper.a(paramView, AIORevokeMsgHelper.a(paramView));
      }
      AIORevokeMsgHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAIORevokeMsgHelper, "0X800A7F5", this.jdField_a_of_type_Boolean);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIORevokeMsgHelper.1
 * JD-Core Version:    0.7.0.1
 */