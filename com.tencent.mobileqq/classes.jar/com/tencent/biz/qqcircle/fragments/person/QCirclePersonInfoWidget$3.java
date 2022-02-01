package com.tencent.biz.qqcircle.fragments.person;

import com.tencent.biz.qqcircle.widgets.QCircleFollowView.FollowReportListener;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StUser;

class QCirclePersonInfoWidget$3
  implements QCircleFollowView.FollowReportListener
{
  QCirclePersonInfoWidget$3(QCirclePersonInfoWidget paramQCirclePersonInfoWidget) {}
  
  public void a()
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(QCirclePersonInfoWidget.b(this.a).id.get()).setActionType(11).setSubActionType(3).setThrActionType(3).setExt1(String.valueOf(1)).setExt2("2").setExt9(QCirclePersonInfoWidget.f(this.a)).setFeedReportInfo(QCirclePersonInfoWidget.e(this.a)).setPageId(QCirclePersonInfoWidget.h(this.a)));
  }
  
  public void a(int paramInt)
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(QCirclePersonInfoWidget.b(this.a).id.get()).setActionType(11).setSubActionType(3).setThrActionType(1).setExt1(String.valueOf(paramInt)).setExt2("2").setExt9(QCirclePersonInfoWidget.f(this.a)).setFeedReportInfo(QCirclePersonInfoWidget.e(this.a)).setPageId(QCirclePersonInfoWidget.d(this.a)));
  }
  
  public void b(int paramInt)
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(QCirclePersonInfoWidget.b(this.a).id.get()).setActionType(11).setSubActionType(3).setThrActionType(2).setExt1(String.valueOf(paramInt)).setExt2("2").setExt9(QCirclePersonInfoWidget.f(this.a)).setFeedReportInfo(QCirclePersonInfoWidget.e(this.a)).setPageId(QCirclePersonInfoWidget.g(this.a)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCirclePersonInfoWidget.3
 * JD-Core Version:    0.7.0.1
 */