package com.tencent.biz.qqcircle.widgets;

import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleLpReportDc05504;
import cooperation.qqcircle.report.QCircleLpReportDc05504.DataBuilder;
import qqcircle.QQCircleDitto.StItemContainer;

class QCirclePushRankItemView$1
  implements QCircleFollowView.ItemPreClickListener
{
  QCirclePushRankItemView$1(QCirclePushRankItemView paramQCirclePushRankItemView) {}
  
  public void a()
  {
    if (this.a.getData() != null)
    {
      QCircleLpReportDc05504.DataBuilder localDataBuilder = new QCircleLpReportDc05504.DataBuilder().setActionType(9).setSubActionType(3).setThrActionType(0);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((QQCircleDitto.StItemContainer)this.a.getData()).containerType.get());
      localStringBuilder.append("");
      QCircleLpReportDc05504.report(localDataBuilder.setExt1(localStringBuilder.toString()).setFeedReportInfo(QCirclePushRankItemView.a(this.a)).setPageId(this.a.getPageId()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCirclePushRankItemView.1
 * JD-Core Version:    0.7.0.1
 */