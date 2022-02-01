package com.tencent.biz.qqcircle.widgets.childviewpresenter;

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

class QCircleFeedItemBottomPresenter$2
  implements QCirclePolyLikeFrameLayout.OnClickHookListener
{
  QCircleFeedItemBottomPresenter$2(QCircleFeedItemBottomPresenter paramQCircleFeedItemBottomPresenter) {}
  
  public void a()
  {
    if (this.a.mReportInfo != null) {
      localObject = this.a.mReportInfo.mFeed;
    } else {
      localObject = null;
    }
    Object localObject = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject);
    int i;
    if (QCircleFeedItemBottomPresenter.access$000(this.a).b()) {
      i = 39;
    } else {
      i = 36;
    }
    QCircleLpReportDc05501.DataBuilder localDataBuilder = ((QCircleLpReportDc05501.DataBuilder)localObject).setActionType(i).setSubActionType(2);
    if ((this.a.mReportInfo != null) && (this.a.mReportInfo.mFeed != null)) {
      localObject = this.a.mReportInfo.mFeed.poster.id.get();
    } else {
      localObject = "";
    }
    localObject = localDataBuilder.setToUin((String)localObject);
    if (this.a.mReportInfo != null) {
      i = this.a.mReportInfo.mDataPosition;
    } else {
      i = -1;
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(((QCircleLpReportDc05501.DataBuilder)localObject).setIndex(i).setPageId(this.a.getPageId())));
  }
  
  public void a(QQCircleFeedBase.StPolyLike paramStPolyLike) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemBottomPresenter.2
 * JD-Core Version:    0.7.0.1
 */