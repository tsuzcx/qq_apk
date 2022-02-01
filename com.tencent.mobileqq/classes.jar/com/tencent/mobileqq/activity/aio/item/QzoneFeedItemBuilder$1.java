package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQzoneFeed;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.URLUtil;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class QzoneFeedItemBuilder$1
  implements View.OnClickListener
{
  QzoneFeedItemBuilder$1(QzoneFeedItemBuilder paramQzoneFeedItemBuilder, MessageForQzoneFeed paramMessageForQzoneFeed) {}
  
  public void onClick(View paramView)
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed;
    ((MessageForQzoneFeed)localObject1).actionUrl = QzoneFeedItemBuilder.a(((MessageForQzoneFeed)localObject1).actionUrl);
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl))
    {
      Map localMap = URLUtil.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl);
      Object localObject2 = null;
      if (localMap != null) {
        localObject1 = (String)localMap.get("g");
      } else {
        localObject1 = null;
      }
      if ((!"110".equals(localObject1)) && (!"279".equals(localObject1)) && (!"318".equals(localObject1)))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl);
      }
      else
      {
        localObject1 = paramView.getContext();
        QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.getInstance();
        localUserInfo.qzone_uin = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder.a.getCurrentAccountUin();
        localUserInfo.nickname = this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder.a.getCurrentNickname();
        QZoneHelper.forwardFromAIOToFeedDetail((Activity)localObject1, localUserInfo, this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl, "mqqChat.QzoneCard", this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.appId, -1);
        localObject1 = new QZoneClickReport.ReportInfo();
        ((QZoneClickReport.ReportInfo)localObject1).actionType = "1";
        ((QZoneClickReport.ReportInfo)localObject1).subactionType = "0";
        ((QZoneClickReport.ReportInfo)localObject1).tabletype = 4;
        ((QZoneClickReport.ReportInfo)localObject1).sourceType = "3";
        ((QZoneClickReport.ReportInfo)localObject1).sourceFrom = "AIO";
        ((QZoneClickReport.ReportInfo)localObject1).sourceTo = "detailPage";
        QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder.a.getAccount(), (QZoneClickReport.ReportInfo)localObject1);
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("source_type", "3");
        ((HashMap)localObject1).put("source_from", "AIO");
        ((HashMap)localObject1).put("source_to", "detailPage");
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder.a.getAccount(), "actQZSourceDataReport", true, 0L, 0L, (HashMap)localObject1, null);
      }
      if (localMap != null) {
        localObject2 = (String)localMap.get("a");
      }
      if (localObject2 != null)
      {
        localObject1 = "4";
        if (((String)localObject2).equals("4")) {
          localObject1 = "1";
        } else if (((String)localObject2).equals("311")) {
          localObject1 = "2";
        } else if (((String)localObject2).equals("2")) {
          localObject1 = "3";
        }
        localObject2 = new QZoneClickReport.ReportInfo();
        ((QZoneClickReport.ReportInfo)localObject2).actionType = "330";
        ((QZoneClickReport.ReportInfo)localObject2).subactionType = "2";
        ((QZoneClickReport.ReportInfo)localObject2).reserves = ((String)localObject1);
        if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.isFirstMsgWithNewFriend) {
          ((QZoneClickReport.ReportInfo)localObject2).reserves10 = "1";
        }
        ((QZoneClickReport.ReportInfo)localObject2).reservesExt = new ArrayList();
        ((QZoneClickReport.ReportInfo)localObject2).reservesExt.add(this.jdField_a_of_type_ComTencentMobileqqDataMessageForQzoneFeed.actionUrl);
        QZoneClickReport.startReportImediately(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder.a.getAccount(), (QZoneClickReport.ReportInfo)localObject2);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder.a, "dc00898", "", "", "0x8009434", "0x8009434", 0, 0, "", "2", "", "");
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemQzoneFeedItemBuilder.a, "CliOper", "", "", "0X8006000", "0X8006000", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QzoneFeedItemBuilder.1
 * JD-Core Version:    0.7.0.1
 */