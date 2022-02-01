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
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      if (!this.b.isNetConnToast()) {
        return;
      }
      this.b.showJuhua(2131916903);
      paramView = this.b;
      paramView.mBindClick = true;
      paramView = (SubAccountProtocServiceImpl)paramView.app.getRuntimeService(ISubAccountProtocService.class, "");
      if (paramView != null) {
        paramView.unBindAccount(this.b.subUin);
      }
    }
    this.a.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SubAccountUgActivity.5
 * JD-Core Version:    0.7.0.1
 */