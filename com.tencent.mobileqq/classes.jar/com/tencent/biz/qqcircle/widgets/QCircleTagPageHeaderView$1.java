package com.tencent.biz.qqcircle.widgets;

import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

class QCircleTagPageHeaderView$1
  implements QCircleFollowTagView.FollowReportListener
{
  QCircleTagPageHeaderView$1(QCircleTagPageHeaderView paramQCircleTagPageHeaderView) {}
  
  public void a()
  {
    QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setActionType(6).setSubActionType(2).setThrActionType(3).setPageId(this.a.getPageId()));
  }
  
  public void a(int paramInt)
  {
    QCircleLpReportDc05504.DataBuilder localDataBuilder = new QCircleLpReportDc05504.DataBuilder().setActionType(6);
    int i = 2;
    localDataBuilder = localDataBuilder.setSubActionType(2);
    if (paramInt > 0) {
      paramInt = i;
    } else {
      paramInt = 1;
    }
    QCircleLpReportDc05504.report(localDataBuilder.setThrActionType(paramInt).setPageId(this.a.getPageId()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleTagPageHeaderView.1
 * JD-Core Version:    0.7.0.1
 */