package com.tencent.biz.pubaccount.accountdetail.adapter;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailActivityImpl;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

class AccountDetailBaseAdapter$3
  implements View.OnClickListener
{
  AccountDetailBaseAdapter$3(AccountDetailBaseAdapter paramAccountDetailBaseAdapter) {}
  
  public void onClick(View paramView)
  {
    ((PublicAccountDetailActivityImpl)this.a.x).gotoMoreInfoActivity();
    IPublicAccountReportUtils localIPublicAccountReportUtils = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
    String str = this.a.o;
    if (this.a.q.followType == 1) {
      paramView = "02";
    } else {
      paramView = "01";
    }
    localIPublicAccountReportUtils.publicAccountReportClickEvent(null, str, "0X8007CA4", "0X8007CA4", 0, 0, paramView, String.valueOf(AccountDetailBaseAdapter.a(this.a)), "", "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.adapter.AccountDetailBaseAdapter.3
 * JD-Core Version:    0.7.0.1
 */