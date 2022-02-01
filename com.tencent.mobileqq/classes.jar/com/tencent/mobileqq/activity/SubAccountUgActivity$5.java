package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.subaccount.api.ISubAccountProtocService;
import com.tencent.mobileqq.subaccount.api.impl.SubAccountProtocServiceImpl;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class SubAccountUgActivity$5
  implements ActionSheet.OnButtonClickListener
{
  SubAccountUgActivity$5(SubAccountUgActivity paramSubAccountUgActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.isNetConnToast()) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.showJuhua(2131719351);
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity;
      paramView.mBindClick = true;
      paramView = (SubAccountProtocServiceImpl)paramView.app.getRuntimeService(ISubAccountProtocService.class, "");
      if (paramView != null) {
        paramView.unBindAccount(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.subUin);
      }
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountUgActivity.5
 * JD-Core Version:    0.7.0.1
 */