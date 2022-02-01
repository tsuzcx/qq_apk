package com.tencent.biz.qqcircle.widgets;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StUser;

class QCircleFatePersonView$1
  implements View.OnClickListener
{
  QCircleFatePersonView$1(QCircleFatePersonView paramQCircleFatePersonView) {}
  
  public void onClick(View paramView)
  {
    QCircleFatePersonView.a(this.a, true);
    if ((QCircleFatePersonView.a(this.a) != null) && (QCircleFatePersonView.b(this.a) != null)) {
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(QCircleFatePersonView.a(this.a)).setToUin(QCircleFatePersonView.b(this.a).id.get()).setActionType(101).setSubActionType(3).setIndex(0).setPageId(this.a.getPageId())));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFatePersonView.1
 * JD-Core Version:    0.7.0.1
 */