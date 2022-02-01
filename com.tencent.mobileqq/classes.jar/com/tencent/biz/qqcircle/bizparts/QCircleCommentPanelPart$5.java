package com.tencent.biz.qqcircle.bizparts;

import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeFrameLayout;
import com.tencent.biz.qqcircle.polylike.QCirclePolyLikeFrameLayout.OnClickHookListener;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleFeedBase.StPolyLike;

class QCircleCommentPanelPart$5
  implements QCirclePolyLikeFrameLayout.OnClickHookListener
{
  QCircleCommentPanelPart$5(QCircleCommentPanelPart paramQCircleCommentPanelPart) {}
  
  public void a()
  {
    if (QCircleCommentPanelPart.d(this.a).b())
    {
      QCircleCommentPanelPart.a(this.a, 64);
      return;
    }
    QCircleCommentPanelPart.a(this.a, 54);
  }
  
  public void a(QQCircleFeedBase.StPolyLike paramStPolyLike)
  {
    if (QCircleCommentPanelPart.e(this.a) != null)
    {
      if (QCircleCommentPanelPart.e(this.a).mFeed == null) {
        return;
      }
      if (QCircleCommentPanelPart.b(this.a))
      {
        paramStPolyLike = this.a;
        QCircleCommentPanelPart.a(paramStPolyLike, 55, 3, QCircleCommentPanelPart.e(paramStPolyLike));
        return;
      }
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(QCircleCommentPanelPart.e(this.a).mFeed).setActionType(55).setSubActionType(3).setToUin(QCircleCommentPanelPart.e(this.a).mFeed.poster.id.get()).setIndex(QCircleCommentPanelPart.e(this.a).mDataPosition).setPageId(this.a.f())));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleCommentPanelPart.5
 * JD-Core Version:    0.7.0.1
 */