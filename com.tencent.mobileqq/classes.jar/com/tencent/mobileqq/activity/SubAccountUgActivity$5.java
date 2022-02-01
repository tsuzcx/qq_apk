package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.subaccount.SubAccountProtocManager;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class SubAccountUgActivity$5
  implements ActionSheet.OnButtonClickListener
{
  SubAccountUgActivity$5(SubAccountUgActivity paramSubAccountUgActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.cancel();
      do
      {
        return;
      } while (!this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.c());
      this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.a(2131719632);
      this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.b = true;
      paramView = (SubAccountProtocManager)this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.app.getManager(QQManagerFactory.MGR_SUB_ACNT);
      if (paramView != null) {
        paramView.a(this.jdField_a_of_type_ComTencentMobileqqActivitySubAccountUgActivity.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountUgActivity.5
 * JD-Core Version:    0.7.0.1
 */