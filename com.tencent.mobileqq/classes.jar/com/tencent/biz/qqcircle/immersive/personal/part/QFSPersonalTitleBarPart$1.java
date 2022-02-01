package com.tencent.biz.qqcircle.immersive.personal.part;

import com.tencent.biz.qqcircle.widgets.QCircleFollowView.FollowReportListener;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

class QFSPersonalTitleBarPart$1
  implements QCircleFollowView.FollowReportListener
{
  final QCircleLpReportDc05504.DataBuilder a = new QCircleLpReportDc05504.DataBuilder().setActionType(11).setSubActionType(3).setExt2("1").setPageId(this.b.i());
  
  QFSPersonalTitleBarPart$1(QFSPersonalTitleBarPart paramQFSPersonalTitleBarPart) {}
  
  private void a(int paramInt1, int paramInt2)
  {
    this.a.setToUin(QFSPersonalTitleBarPart.c(this.b)).setThrActionType(paramInt2).setExt1(String.valueOf(paramInt1)).setExt9(QFSPersonalTitleBarPart.b(this.b)).setFeedReportInfo(QFSPersonalTitleBarPart.a(this.b));
    QCircleLpReportDc05504.report(this.a);
  }
  
  public void a()
  {
    a(1, 3);
  }
  
  public void a(int paramInt) {}
  
  public void b(int paramInt)
  {
    a(paramInt, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalTitleBarPart.1
 * JD-Core Version:    0.7.0.1
 */