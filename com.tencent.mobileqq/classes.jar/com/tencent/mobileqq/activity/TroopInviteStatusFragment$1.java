package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

class TroopInviteStatusFragment$1
  implements Runnable
{
  TroopInviteStatusFragment$1(TroopInviteStatusFragment paramTroopInviteStatusFragment) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (!this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing()) && (this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null))
    {
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing()) {
        return;
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.c(2131718170);
      this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInviteStatusFragment.1
 * JD-Core Version:    0.7.0.1
 */