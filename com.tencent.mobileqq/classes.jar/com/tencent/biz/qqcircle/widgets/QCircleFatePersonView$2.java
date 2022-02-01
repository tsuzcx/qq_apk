package com.tencent.biz.qqcircle.widgets;

import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StUser;

class QCircleFatePersonView$2
  implements QCircleFollowView.FollowChangeListener
{
  QCircleFatePersonView$2(QCircleFatePersonView paramQCircleFatePersonView) {}
  
  public void onFollowStateChange(boolean paramBoolean, FeedCloudMeta.StUser paramStUser)
  {
    if (paramBoolean)
    {
      if ((QCircleFatePersonView.a(this.a) != null) && (QCircleFatePersonView.b(this.a) != null)) {
        QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(QCircleFatePersonView.a(this.a)).setToUin(QCircleFatePersonView.b(this.a).id.get()).setActionType(101).setSubActionType(2).setIndex(0).setPageId(this.a.getPageId())));
      }
      if (QCircleFatePersonView.c(this.a) != null) {
        QCircleFatePersonView.c(this.a).setVisibility(8);
      }
      QCircleFatePersonView.d(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFatePersonView.2
 * JD-Core Version:    0.7.0.1
 */