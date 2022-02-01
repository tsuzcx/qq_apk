package com.tencent.biz.qqcircle.widgets.pymk;

import com.tencent.biz.qqcircle.widgets.QCircleFollowView.FollowReportListener;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import qqcircle.QQCircleDitto.StItemInfo;

class QCirclePYMKRecommendItemViewHolder$4
  implements QCircleFollowView.FollowReportListener
{
  QCirclePYMKRecommendItemViewHolder$4(QCirclePYMKRecommendItemViewHolder paramQCirclePYMKRecommendItemViewHolder) {}
  
  private String b()
  {
    if ((QCirclePYMKRecommendItemViewHolder.b(this.a) instanceof QQCircleDitto.StItemInfo)) {
      return ((QQCircleDitto.StItemInfo)QCirclePYMKRecommendItemViewHolder.c(this.a)).id.get();
    }
    return "";
  }
  
  public void a()
  {
    QCirclePYMKRecommendItemViewHolder localQCirclePYMKRecommendItemViewHolder = this.a;
    QCirclePYMKRecommendItemViewHolder.a(localQCirclePYMKRecommendItemViewHolder, QCirclePYMKRecommendItemViewHolder.a(localQCirclePYMKRecommendItemViewHolder, b()).setActionType(19).setSubActionType(2).setFeedType1(3).setFeedType2(1));
  }
  
  public void a(int paramInt) {}
  
  public void b(int paramInt)
  {
    if (paramInt > 0) {
      paramInt = 18;
    } else {
      paramInt = 17;
    }
    QCirclePYMKRecommendItemViewHolder localQCirclePYMKRecommendItemViewHolder = this.a;
    QCirclePYMKRecommendItemViewHolder.a(localQCirclePYMKRecommendItemViewHolder, QCirclePYMKRecommendItemViewHolder.a(localQCirclePYMKRecommendItemViewHolder, b()).setActionType(paramInt).setSubActionType(2).setFeedType1(3).setFeedType2(1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.pymk.QCirclePYMKRecommendItemViewHolder.4
 * JD-Core Version:    0.7.0.1
 */