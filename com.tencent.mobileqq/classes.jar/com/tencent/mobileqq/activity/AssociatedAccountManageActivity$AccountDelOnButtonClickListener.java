package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AssociatedAccountManageActivity$AccountDelOnButtonClickListener
  implements ActionSheet.OnButtonClickListener
{
  SimpleAccount a;
  
  AssociatedAccountManageActivity$AccountDelOnButtonClickListener(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  public void a(SimpleAccount paramSimpleAccount)
  {
    this.a = paramSimpleAccount;
  }
  
  public void onClick(View paramView, int paramInt)
  {
    if (this.b.menuDialog != null) {
      this.b.menuDialog.dismiss();
    }
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      this.b.deleteAccount(this.a, true);
      return;
    }
    this.b.deleteAccount(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity.AccountDelOnButtonClickListener
 * JD-Core Version:    0.7.0.1
 */