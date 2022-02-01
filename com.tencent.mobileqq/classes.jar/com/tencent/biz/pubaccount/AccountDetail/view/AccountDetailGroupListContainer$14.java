package com.tencent.biz.pubaccount.accountdetail.view;

import android.view.View;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.NewPublicAccountObserver;
import com.tencent.mobileqq.applets.PublicAccountStateReporter;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AccountDetailGroupListContainer$14
  implements ActionSheet.OnButtonClickListener
{
  AccountDetailGroupListContainer$14(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (this.c.y) {
      return;
    }
    paramView = this.c;
    int j = 1;
    paramView.y = true;
    int i;
    if (paramInt + 1 == 1)
    {
      i = j;
      if (AppConstants.KANDIAN_DAILY_UIN.equals(this.c.g))
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009947", "0X8009947", 0, 0, "", "", "", "", false);
        i = j;
      }
    }
    else
    {
      j = 3;
      i = j;
      if (AppConstants.KANDIAN_DAILY_UIN.equals(this.c.g))
      {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X8009943", "0X8009943", 0, 0, "", "", "", "", false);
        i = j;
      }
    }
    this.c.b.removeObserver(this.c.u);
    this.c.u = new NewPublicAccountObserver(new AccountDetailGroupListContainer.14.1(this, i));
    this.c.b.addObserver(this.c.u);
    PublicAccountStateReporter.a(this.c.b, this.c.f.uin, this.c.f.name, paramInt);
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.14
 * JD-Core Version:    0.7.0.1
 */