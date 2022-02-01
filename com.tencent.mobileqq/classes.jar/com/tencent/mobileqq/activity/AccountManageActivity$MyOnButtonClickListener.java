package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AccountManageActivity$MyOnButtonClickListener
  implements ActionSheet.OnButtonClickListener
{
  int jdField_a_of_type_Int = -1;
  
  AccountManageActivity$MyOnButtonClickListener(AccountManageActivity paramAccountManageActivity) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.isFinishing()) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_ComTencentWidgetActionSheet != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
    StringBuilder localStringBuilder;
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidAppDialog.show();
      }
      catch (Throwable paramView)
      {
        paramView.printStackTrace();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("MyOnButtonClickListener 1 error");
        localStringBuilder.append(paramView.getMessage());
        QLog.i("AccountManageActivity", 1, localStringBuilder.toString());
      }
      paramInt = this.jdField_a_of_type_Int;
      if (paramInt >= 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a(paramInt, true);
      }
    }
    else
    {
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.jdField_a_of_type_AndroidAppDialog.show();
      }
      catch (Throwable paramView)
      {
        paramView.printStackTrace();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("MyOnButtonClickListener 0 error");
        localStringBuilder.append(paramView.getMessage());
        QLog.i("AccountManageActivity", 1, localStringBuilder.toString());
      }
      paramInt = this.jdField_a_of_type_Int;
      if (paramInt >= 0) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity.a(paramInt, false);
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.MyOnButtonClickListener
 * JD-Core Version:    0.7.0.1
 */