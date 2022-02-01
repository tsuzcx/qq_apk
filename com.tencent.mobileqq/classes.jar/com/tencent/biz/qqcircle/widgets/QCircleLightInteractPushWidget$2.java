package com.tencent.biz.qqcircle.widgets;

import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

class QCircleLightInteractPushWidget$2
  implements QCircleFollowView.FollowChangeListener
{
  QCircleLightInteractPushWidget$2(QCircleLightInteractPushWidget paramQCircleLightInteractPushWidget) {}
  
  public void onFollowStateChange(boolean paramBoolean, FeedCloudMeta.StUser paramStUser)
  {
    if (this.a.d != null) {
      paramStUser = this.a.d.mFeed;
    } else {
      paramStUser = null;
    }
    paramStUser = QCirclePluginReportUtil.b(paramStUser).setActionType(87);
    int i;
    if (paramBoolean) {
      i = 4;
    } else {
      i = 5;
    }
    QCircleLpReportDc05501.DataBuilder localDataBuilder = paramStUser.setSubActionType(i);
    if ((this.a.d != null) && (this.a.d.mFeed != null)) {
      paramStUser = this.a.d.mFeed.poster.id.get();
    } else {
      paramStUser = "";
    }
    paramStUser = localDataBuilder.setToUin(paramStUser);
    if (this.a.d != null) {
      i = this.a.d.mDataPosition;
    } else {
      i = -1;
    }
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(paramStUser.setIndex(i).setPageId(this.a.getPageId())));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleLightInteractPushWidget.2
 * JD-Core Version:    0.7.0.1
 */