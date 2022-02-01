package com.tencent.mobileqq.activity;

import android.app.Dialog;
import android.view.View;
import android.widget.LinearLayout;

class AccountManageActivity$22$1
  implements Runnable
{
  AccountManageActivity$22$1(AccountManageActivity.22 param22) {}
  
  public void run()
  {
    int i = 0;
    try
    {
      this.a.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.removeViewAt(this.a.a);
      label22:
      if (!this.a.this$0.jdField_a_of_type_Boolean) {
        this.a.this$0.a(false);
      }
      AccountManageActivity.a(this.a.this$0, null);
      int j = this.a.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount();
      while (i < j)
      {
        View localView = this.a.this$0.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i);
        if (localView.getTag() != null) {
          localView.setTag(Integer.valueOf(i));
        }
        i += 1;
      }
      this.a.this$0.jdField_a_of_type_AndroidAppDialog.dismiss();
      return;
    }
    catch (Exception localException)
    {
      break label22;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.22.1
 * JD-Core Version:    0.7.0.1
 */