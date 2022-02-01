package com.tencent.biz.pubaccount.accountdetail.view;

import android.view.View;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.NewPublicAccountObserver;
import com.tencent.mobileqq.applets.PublicAccountStateReporter;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AccountDetailGroupListContainer$16
  implements ActionSheet.OnButtonClickListener
{
  AccountDetailGroupListContainer$16(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (this.b.y) {
      return;
    }
    paramView = this.b;
    paramView.y = true;
    if (paramInt == 0) {
      paramView.j = 0;
    } else if (paramInt == 1) {
      paramView.j = 2;
    } else if (paramInt == 2) {
      paramView.j = 1;
    }
    this.b.b.removeObserver(this.b.u);
    this.b.u = new NewPublicAccountObserver(new AccountDetailGroupListContainer.16.1(this));
    this.b.b.addObserver(this.b.u);
    PublicAccountStateReporter.a(this.b.b, this.b.f.uin, this.b.f.name, this.b.j);
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.16
 * JD-Core Version:    0.7.0.1
 */