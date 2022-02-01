package com.tencent.biz.pubaccount.accountdetail.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.biz.troopbar.ShareActionSheet;
import com.tencent.biz.troopbar.ShareActionSheet.Detail;
import com.tencent.mobileqq.app.BaseActivity;
import java.lang.ref.WeakReference;

class AccountDetailGroupListContainer$8
  implements View.OnClickListener
{
  AccountDetailGroupListContainer$8(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, int paramInt, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo) {}
  
  public void onClick(View paramView)
  {
    ShareActionSheet.a((BaseActivity)this.c.a.get(), new ShareActionSheet.Detail(this.c.g, this.c.f.name, this.c.f.summary), 1, AccountDetailGroupListContainer.b(this.c), this.a);
    AccountDetailGroupListContainer.a(this.c, this.b.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.8
 * JD-Core Version:    0.7.0.1
 */