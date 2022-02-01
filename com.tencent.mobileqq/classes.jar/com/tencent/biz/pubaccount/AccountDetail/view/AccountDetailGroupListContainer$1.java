package com.tencent.biz.pubaccount.accountdetail.view;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr.PaConfigInfo;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import java.lang.ref.WeakReference;

class AccountDetailGroupListContainer$1
  implements View.OnClickListener
{
  AccountDetailGroupListContainer$1(AccountDetailGroupListContainer paramAccountDetailGroupListContainer, IPublicAccountConfigAttr.PaConfigInfo paramPaConfigInfo, String paramString) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent((Context)this.c.a.get(), QQMapActivity.class);
    paramView.putExtra("lat", this.a.m);
    paramView.putExtra("lon", this.a.l);
    if (!TextUtils.isEmpty(this.b)) {
      paramView.putExtra("loc", this.b);
    }
    ((BaseActivity)this.c.a.get()).startActivity(paramView);
    ReportController.b(this.c.b, "CliOper", "", "", "Biz_card", "Biz_card_map", 0, 0, this.c.g, "", "", "");
    AccountDetailGroupListContainer.a(this.c, this.a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailGroupListContainer.1
 * JD-Core Version:    0.7.0.1
 */