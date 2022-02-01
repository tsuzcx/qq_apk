package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AssociatedAccountManageActivity$AccountDelOnButtonClickListener
  implements ActionSheet.OnButtonClickListener
{
  SimpleAccount jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount;
  
  AssociatedAccountManageActivity$AccountDelOnButtonClickListener(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.menuDialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.menuDialog.dismiss();
    }
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.deleteAccount(this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount, true);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAssociatedAccountManageActivity.deleteAccount(this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount, false);
  }
  
  public void a(SimpleAccount paramSimpleAccount)
  {
    this.jdField_a_of_type_ComTencentQphoneBaseRemoteSimpleAccount = paramSimpleAccount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity.AccountDelOnButtonClickListener
 * JD-Core Version:    0.7.0.1
 */