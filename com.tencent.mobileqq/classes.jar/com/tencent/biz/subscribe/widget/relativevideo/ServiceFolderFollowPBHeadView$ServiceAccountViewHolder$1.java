package com.tencent.biz.subscribe.widget.relativevideo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeed;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.activity.recent.RecentPubAccHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

class ServiceFolderFollowPBHeadView$ServiceAccountViewHolder$1
  implements View.OnClickListener
{
  ServiceFolderFollowPBHeadView$ServiceAccountViewHolder$1(ServiceFolderFollowPBHeadView.ServiceAccountViewHolder paramServiceAccountViewHolder, ServiceAccountFolderFeed paramServiceAccountFolderFeed, int paramInt, MessageRecord paramMessageRecord, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    ServiceFolderFollowPBHeadView.ServiceAccountViewHolder.a(this.f, paramView, this.a);
    Object localObject1 = ((BaseActivity)paramView.getContext()).app;
    if (QLog.isColorLevel())
    {
      str = ServiceFolderFollowPBHeadView.b();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onClickFeedItem->uin:");
      ((StringBuilder)localObject2).append(this.a.b);
      ((StringBuilder)localObject2).append(", name:");
      ((StringBuilder)localObject2).append(this.a.h);
      QLog.d(str, 2, ((StringBuilder)localObject2).toString());
    }
    int i = this.a.c;
    if (i == 1) {
      str = "0X80067EF";
    } else if (i == 2) {
      str = "0X80067F0";
    } else {
      str = "0X80067F1";
    }
    long l = ServiceAccountFolderManager.a().a(this.a);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.a.b);
    localObject2 = ((StringBuilder)localObject2).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("");
    ((StringBuilder)localObject3).append(i);
    localObject3 = ((StringBuilder)localObject3).toString();
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("");
    ((StringBuilder)localObject4).append(l);
    localObject4 = ((StringBuilder)localObject4).toString();
    Object localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append("");
    ((StringBuilder)localObject5).append(this.b + 1);
    localObject5 = ((StringBuilder)localObject5).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.a.d);
    ReportController.b((AppRuntime)localObject1, "dc01160", "Pb_account_lifeservice", (String)localObject2, str, str, 0, 0, (String)localObject3, (String)localObject4, (String)localObject5, localStringBuilder.toString());
    RecentPubAccHelper.a((QQAppInterface)localObject1, this.a.b, this.a.c, this.a.d, 2, this.a.h);
    localObject2 = this.c;
    localObject3 = this.a.b;
    i = this.a.c;
    int j = this.a.d;
    if (this.a.j == null) {
      str = "";
    } else {
      str = this.a.j.msg;
    }
    localObject4 = this.d;
    localObject5 = this.e;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.b);
    localStringBuilder.append("");
    PublicAccountEventReport.b((QQAppInterface)localObject1, (MessageRecord)localObject2, (String)localObject3, i, j, str, (String)localObject4, (String)localObject5, localStringBuilder.toString());
    if (((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA(this.a.b)) {
      ReportController.b((AppRuntime)localObject1, "P_CliOper", "weather_public_account", "", "weather_public_account", "brief_weather_click", 0, 0, "", "", "8.8.17", "");
    }
    String str = this.a.b;
    localObject1 = this.a.h;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.a.i);
    ((StringBuilder)localObject2).append("");
    VSReporter.a(str, "auth_follow", "new_s_clk", 0, 0, new String[] { "", "", localObject1, ((StringBuilder)localObject2).toString() });
    PublicTracker.a(null, "SUBSCRIPT_AIO_COST");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView.ServiceAccountViewHolder.1
 * JD-Core Version:    0.7.0.1
 */