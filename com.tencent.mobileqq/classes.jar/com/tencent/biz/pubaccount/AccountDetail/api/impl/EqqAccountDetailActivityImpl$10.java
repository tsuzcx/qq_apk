package com.tencent.biz.pubaccount.accountdetail.api.impl;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;

class EqqAccountDetailActivityImpl$10
  implements View.OnClickListener
{
  EqqAccountDetailActivityImpl$10(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl) {}
  
  public void onClick(View paramView)
  {
    if (this.a.eqqDetail != null)
    {
      paramView = new Intent(this.a, ChatHistory.class);
      paramView.putExtra("uin", this.a.uin);
      paramView.putExtra("uintype", 1024);
      this.a.startActivity(paramView);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.a.app, "P_CliOper", "Pb_account_lifeservice", this.a.uin, "0X8005A29", "0X8005A29", 0, 0, "", "", "", "", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.api.impl.EqqAccountDetailActivityImpl.10
 * JD-Core Version:    0.7.0.1
 */