package com.tencent.biz.qqcircle.scrollers;

import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

class QCircleFeedPlayerScroller$4
  implements Runnable
{
  QCircleFeedPlayerScroller$4(QCircleFeedPlayerScroller paramQCircleFeedPlayerScroller, String paramString) {}
  
  public void run()
  {
    QCircleExtraTypeInfo localQCircleExtraTypeInfo = QCircleFeedPlayerScroller.b(this.this$0, this.a);
    if (localQCircleExtraTypeInfo != null) {
      localObject = localQCircleExtraTypeInfo.mFeed;
    } else {
      localObject = null;
    }
    QCircleLpReportDc05501.DataBuilder localDataBuilder = QCirclePluginReportUtil.b((FeedCloudMeta.StFeed)localObject).setActionType(8).setSubActionType(4);
    if ((localQCircleExtraTypeInfo != null) && (localQCircleExtraTypeInfo.mFeed != null)) {
      localObject = localQCircleExtraTypeInfo.mFeed.poster.id.get();
    } else {
      localObject = "";
    }
    Object localObject = localDataBuilder.setToUin((String)localObject);
    int i;
    if (localQCircleExtraTypeInfo != null) {
      i = localQCircleExtraTypeInfo.mDataPosition;
    } else {
      i = -1;
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(((QCircleLpReportDc05501.DataBuilder)localObject).setIndex(i).setPageId(QCircleFeedPlayerScroller.f(this.this$0))));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.scrollers.QCircleFeedPlayerScroller.4
 * JD-Core Version:    0.7.0.1
 */