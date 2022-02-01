package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.widgets.QCircleFollowView.FollowReportListener;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

class QCircleFeedItemHeadPresenter$1
  implements QCircleFollowView.FollowReportListener
{
  QCircleFeedItemHeadPresenter$1(QCircleFeedItemHeadPresenter paramQCircleFeedItemHeadPresenter) {}
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void b(int paramInt)
  {
    if ((this.a.mData instanceof FeedBlockData))
    {
      FeedCloudMeta.StFeed localStFeed = ((FeedBlockData)this.a.mData).b();
      QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(localStFeed).setToUin(localStFeed.poster.id.get())).setActionType(17).setSubActionType(2).setIndex(this.a.mPos).setPageId(this.a.getPageId()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemHeadPresenter.1
 * JD-Core Version:    0.7.0.1
 */