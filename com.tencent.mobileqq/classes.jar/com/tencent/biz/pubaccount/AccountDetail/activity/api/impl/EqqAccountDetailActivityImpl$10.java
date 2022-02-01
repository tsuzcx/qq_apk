package com.tencent.biz.pubaccount.AccountDetail.activity.api.impl;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EqqAccountDetailActivityImpl$10
  implements View.OnClickListener
{
  EqqAccountDetailActivityImpl$10(EqqAccountDetailActivityImpl paramEqqAccountDetailActivityImpl) {}
  
  public void onClick(View paramView)
  {
    if (this.a.eqqDetail != null)
    {
      Intent localIntent = new Intent(this.a, ChatHistory.class);
      localIntent.putExtra("uin", this.a.uin);
      localIntent.putExtra("uintype", 1024);
      this.a.startActivity(localIntent);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(this.a.app, "P_CliOper", "Pb_account_lifeservice", this.a.uin, "0X8005A29", "0X8005A29", 0, 0, "", "", "", "", false);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.AccountDetail.activity.api.impl.EqqAccountDetailActivityImpl.10
 * JD-Core Version:    0.7.0.1
 */