package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.app.utils.RouteUtils;
import java.lang.ref.WeakReference;

class AccountDetailGroupListContainer$4
  implements View.OnClickListener
{
  AccountDetailGroupListContainer$4(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent();
    paramView.putExtra("from", this.b.a.getClass().getName());
    RouteUtils.a((Context)this.b.a.get(), paramView, "/qrscan/scanner");
    AccountDetailGroupListContainer.a(this.b, this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.4
 * JD-Core Version:    0.7.0.1
 */