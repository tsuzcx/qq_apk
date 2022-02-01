package com.tencent.biz.qqcircle.widgets;

import com.tencent.biz.qqcircle.beans.QCircleFeedCommentInfo;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StComment;
import feedcloud.FeedCloudMeta.StUser;

class QCircleFeedCommentWidget$2
  implements QCircleAsyncTextView.OnClickBoldTextListener
{
  QCircleFeedCommentWidget$2(QCircleFeedCommentWidget paramQCircleFeedCommentWidget, FeedCloudMeta.StComment paramStComment) {}
  
  public void a()
  {
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(QCircleFeedCommentWidget.a(this.b).a).setToUin(this.a.postUser.id.get()).setActionType(44).setSubActionType(2).setIndex(QCircleFeedCommentWidget.b(this.b)).setPageId(this.b.getPageId())));
    QCircleFeedCommentWidget.a(this.b, this.a.postUser.id.get(), QCircleFeedCommentWidget.a(this.b).a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFeedCommentWidget.2
 * JD-Core Version:    0.7.0.1
 */