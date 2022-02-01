package com.tencent.biz.pubaccount.accountdetail.view;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.troopbar.ShareActionSheet;
import com.tencent.biz.troopbar.ShareActionSheet.Detail;
import java.lang.ref.WeakReference;

class AccountDetailGroupListContainer$6
  implements View.OnClickListener
{
  AccountDetailGroupListContainer$6(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo) {}
  
  public void onClick(View paramView)
  {
    ShareActionSheet.b((Activity)this.b.a.get(), new ShareActionSheet.Detail(this.b.g, this.b.f.name, this.b.f.summary), 1, AccountDetailGroupListContainer.b(this.b));
    AccountDetailGroupListContainer.a(this.b, this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.6
 * JD-Core Version:    0.7.0.1
 */