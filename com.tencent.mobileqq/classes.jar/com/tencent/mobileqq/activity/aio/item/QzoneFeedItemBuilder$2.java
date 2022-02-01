package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneClickReport;
import cooperation.qzone.QZoneClickReport.ReportInfo;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

class QzoneFeedItemBuilder$2
  implements View.OnClickListener
{
  QzoneFeedItemBuilder$2(QzoneFeedItemBuilder paramQzoneFeedItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (((this.a.c instanceof Activity)) && (this.a.d != null) && (this.a.a != null))
    {
      Object localObject = new QZoneClickReport.ReportInfo();
      ((QZoneClickReport.ReportInfo)localObject).actionType = "330";
      ((QZoneClickReport.ReportInfo)localObject).subactionType = "3";
      ((QZoneClickReport.ReportInfo)localObject).reserves = "2";
      QZoneClickReport.startReportImediately(this.a.a.getAccount(), (QZoneClickReport.ReportInfo)localObject);
      localObject = QZoneHelper.UserInfo.getInstance();
      QZoneHelper.forwardToUserHome((Activity)this.a.c, (QZoneHelper.UserInfo)localObject, this.a.d.b, 0, 0, 0);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.QzoneFeedItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */