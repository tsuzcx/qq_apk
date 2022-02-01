package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.qqcircle.widgets.QCircleFollowView.FollowReportListener;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import feedcloud.FeedCloudMeta.StUser;

class QCirclePersonalTitleBarPart$1
  implements QCircleFollowView.FollowReportListener
{
  QCirclePersonalTitleBarPart$1(QCirclePersonalTitleBarPart paramQCirclePersonalTitleBarPart) {}
  
  public void a()
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(QCirclePersonalTitleBarPart.c(this.a).id.get()).setActionType(11).setSubActionType(3).setThrActionType(3).setExt1(String.valueOf(1)).setExt2("1").setExt9(QCirclePersonalTitleBarPart.b(this.a)).setFeedReportInfo(QCirclePersonalTitleBarPart.a(this.a)).setPageId(this.a.f()));
  }
  
  public void a(int paramInt) {}
  
  public void b(int paramInt)
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(QCirclePersonalTitleBarPart.c(this.a).id.get()).setActionType(11).setSubActionType(3).setThrActionType(2).setExt1(String.valueOf(paramInt)).setExt2("1").setExt9(QCirclePersonalTitleBarPart.b(this.a)).setFeedReportInfo(QCirclePersonalTitleBarPart.a(this.a)).setPageId(this.a.f()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePersonalTitleBarPart.1
 * JD-Core Version:    0.7.0.1
 */