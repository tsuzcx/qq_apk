package com.tencent.biz.qqcircle.widgets;

import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;

class QCircleFollowUserListItemView$1
  implements QCircleFollowView.FollowReportListener
{
  QCircleFollowUserListItemView$1(QCircleFollowUserListItemView paramQCircleFollowUserListItemView) {}
  
  public void a()
  {
    if (QCircleFollowUserListItemView.a(this.a) == 1)
    {
      QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(QCircleFollowUserListItemView.b(this.a)).setActionType(11).setSubActionType(29).setThrActionType(4));
      return;
    }
    QCircleLpReportDc05504.DataBuilder localDataBuilder = new QCircleLpReportDc05504.DataBuilder().setToUin(QCircleFollowUserListItemView.b(this.a)).setActionType(11);
    int i;
    if (QCircleFollowUserListItemView.c(this.a) == 0) {
      i = 28;
    } else {
      i = 30;
    }
    QCircleLpReportDc05504.report(localDataBuilder.setSubActionType(i).setThrActionType(4));
  }
  
  public void a(int paramInt) {}
  
  public void b(int paramInt)
  {
    if (paramInt == 0)
    {
      if (QCircleFollowUserListItemView.a(this.a) == 1)
      {
        QCircleLpReportDc05504.report(new QCircleLpReportDc05504.DataBuilder().setToUin(QCircleFollowUserListItemView.b(this.a)).setActionType(11).setSubActionType(29).setThrActionType(3));
        return;
      }
      QCircleLpReportDc05504.DataBuilder localDataBuilder = new QCircleLpReportDc05504.DataBuilder().setToUin(QCircleFollowUserListItemView.b(this.a)).setActionType(11);
      if (QCircleFollowUserListItemView.c(this.a) == 0) {
        paramInt = 28;
      } else {
        paramInt = 30;
      }
      QCircleLpReportDc05504.report(localDataBuilder.setSubActionType(paramInt).setThrActionType(3));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFollowUserListItemView.1
 * JD-Core Version:    0.7.0.1
 */