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
  ServiceFolderFollowPBHeadView$ServiceAccountViewHolder$1(ServiceFolderFollowPBHeadView.ServiceAccountViewHolder paramServiceAccountViewHolder, ServiceAccountFolderFeed paramServiceAccountFolderFeed, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    ServiceFolderFollowPBHeadView.ServiceAccountViewHolder.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView$ServiceAccountViewHolder, paramView, this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed);
    Object localObject1 = ((BaseActivity)paramView.getContext()).app;
    if (QLog.isColorLevel())
    {
      str = ServiceFolderFollowPBHeadView.a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onClickFeedItem->uin:");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject2).append(", name:");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.c);
      QLog.d(str, 2, ((StringBuilder)localObject2).toString());
    }
    int i = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_Int;
    if (i == 1) {
      str = "0X80067EF";
    } else if (i == 2) {
      str = "0X80067F0";
    } else {
      str = "0X80067F1";
    }
    long l = ServiceAccountFolderManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_JavaLangString);
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
    ((StringBuilder)localObject5).append(this.jdField_a_of_type_Int + 1);
    localObject5 = ((StringBuilder)localObject5).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.b);
    ReportController.b((AppRuntime)localObject1, "dc01160", "Pb_account_lifeservice", (String)localObject2, str, str, 0, 0, (String)localObject3, (String)localObject4, (String)localObject5, localStringBuilder.toString());
    RecentPubAccHelper.a((QQAppInterface)localObject1, this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.b, 2, this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.c);
    localObject2 = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_JavaLangString;
    i = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_Int;
    int j = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.b;
    if (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {
      str = "";
    } else {
      str = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msg;
    }
    localObject3 = this.jdField_a_of_type_JavaLangString;
    localObject4 = this.b;
    localObject5 = new StringBuilder();
    ((StringBuilder)localObject5).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject5).append("");
    PublicAccountEventReport.b((QQAppInterface)localObject1, (String)localObject2, i, j, str, (String)localObject3, (String)localObject4, ((StringBuilder)localObject5).toString());
    if (((IWeatherCommApi)QRoute.api(IWeatherCommApi.class)).isWeatherPA(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_JavaLangString)) {
      ReportController.b((AppRuntime)localObject1, "P_CliOper", "weather_public_account", "", "weather_public_account", "brief_weather_click", 0, 0, "", "", "8.7.0", "");
    }
    String str = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_JavaLangString;
    localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.c;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence);
    ((StringBuilder)localObject2).append("");
    VSReporter.a(str, "auth_follow", "new_s_clk", 0, 0, new String[] { "", "", localObject1, ((StringBuilder)localObject2).toString() });
    PublicTracker.a(null, "SUBSCRIPT_AIO_COST");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView.ServiceAccountViewHolder.1
 * JD-Core Version:    0.7.0.1
 */