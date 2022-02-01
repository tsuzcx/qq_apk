package com.tencent.biz.subscribe.widget.relativevideo;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeed;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.activity.aio.item.PAWeatherItemBuilder;
import com.tencent.mobileqq.activity.recent.RecentPubAccHelper;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.applets.PublicAccountEventReport;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ServiceFolderFollowPBHeadView$ServiceAccountViewHolder$1
  implements View.OnClickListener
{
  ServiceFolderFollowPBHeadView$ServiceAccountViewHolder$1(ServiceFolderFollowPBHeadView.ServiceAccountViewHolder paramServiceAccountViewHolder, ServiceAccountFolderFeed paramServiceAccountFolderFeed, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    ServiceFolderFollowPBHeadView.ServiceAccountViewHolder.a(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView$ServiceAccountViewHolder, paramView, this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed);
    QQAppInterface localQQAppInterface = ((BaseActivity)paramView.getContext()).app;
    if (QLog.isColorLevel()) {
      QLog.d(ServiceFolderFollowPBHeadView.a(), 2, "onClickFeedItem->uin:" + this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_JavaLangString + ", name:" + this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.c);
    }
    String str1 = "0X80067F1";
    int i = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_Int;
    String str2;
    int j;
    if (i == 1)
    {
      str1 = "0X80067EF";
      long l = ServiceAccountFolderManager.a().a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed);
      ReportController.b(localQQAppInterface, "dc01160", "Pb_account_lifeservice", "" + this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, str1, str1, 0, 0, "" + i, "" + l, "" + (this.jdField_a_of_type_Int + 1), "" + this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.b);
      RecentPubAccHelper.a(localQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.b, 2, this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.c);
      str2 = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_JavaLangString;
      i = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_Int;
      j = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.b;
      if (this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
        break label484;
      }
    }
    label484:
    for (str1 = "";; str1 = this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.msg)
    {
      PublicAccountEventReport.b(localQQAppInterface, str2, i, j, str1, this.jdField_a_of_type_JavaLangString, this.b, this.jdField_a_of_type_Int + "");
      if (PAWeatherItemBuilder.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_JavaLangString)) {
        ReportController.b(localQQAppInterface, "P_CliOper", "weather_public_account", "", "weather_public_account", "brief_weather_click", 0, 0, "", "", "8.5.5", "");
      }
      VSReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_JavaLangString, "auth_follow", "new_s_clk", 0, 0, new String[] { "", "", this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.c, this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderServiceAccountFolderFeed.jdField_a_of_type_JavaLangCharSequence + "" });
      PublicTracker.a(null, "SUBSCRIPT_AIO_COST");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (i != 2) {
        break;
      }
      str1 = "0X80067F0";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView.ServiceAccountViewHolder.1
 * JD-Core Version:    0.7.0.1
 */