package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.data.SubAccountInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AssociatedAccountManageActivity$SubAccountUnbindOnButtonClickListener
  implements ActionSheet.OnButtonClickListener
{
  SubAccountInfo a;
  
  AssociatedAccountManageActivity$SubAccountUnbindOnButtonClickListener(AssociatedAccountManageActivity paramAssociatedAccountManageActivity) {}
  
  public void a(SubAccountInfo paramSubAccountInfo)
  {
    this.a = paramSubAccountInfo;
  }
  
  public void onClick(View paramView, int paramInt)
  {
    if (this.b.menuUnbindDialog != null) {
      this.b.menuUnbindDialog.dismiss();
    }
    if (paramInt != 0) {
      return;
    }
    this.b.unbindAccount(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AssociatedAccountManageActivity.SubAccountUnbindOnButtonClickListener
 * JD-Core Version:    0.7.0.1
 */