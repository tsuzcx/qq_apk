package com.tencent.biz.pubaccount.accountdetail.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.pubaccount.api.impl.PublicAccountHandlerImpl;

class AccountDetailGroupListContainer$3
  implements View.OnClickListener
{
  AccountDetailGroupListContainer$3(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, String paramString, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo) {}
  
  public void onClick(View paramView)
  {
    AccountDetailGroupListContainer.c(this.c, this.a);
    PublicAccountHandlerImpl.reportClickPublicAccountEventInner(this.c.b, this.c.g, "Grp_tribe", "interest_data", "Clk_msg");
    AccountDetailGroupListContainer.a(this.c, this.b.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.3
 * JD-Core Version:    0.7.0.1
 */