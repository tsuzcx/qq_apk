package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.onlinestatus.OnlineStatusDataReporter;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AccountManageActivity$5
  implements View.OnClickListener
{
  AccountManageActivity$5(AccountManageActivity paramAccountManageActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent();
    ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).startAccountOnlineStateActivity(this.a, localIntent, 0);
    OnlineStatusDataReporter.a(this.a.app);
    ReportController.a(this.a.app, "0X800B839");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.5
 * JD-Core Version:    0.7.0.1
 */