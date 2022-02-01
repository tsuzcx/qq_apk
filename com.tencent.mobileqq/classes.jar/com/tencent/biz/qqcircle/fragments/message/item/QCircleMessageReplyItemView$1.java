package com.tencent.biz.qqcircle.fragments.message.item;

import com.tencent.biz.qqcircle.beans.QCircleFeedCommentInfo;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.OnClickBoldTextListener;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;
import feedcloud.FeedCloudMeta.StReply;
import feedcloud.FeedCloudMeta.StUser;

class QCircleMessageReplyItemView$1
  implements QCircleAsyncTextView.OnClickBoldTextListener
{
  QCircleMessageReplyItemView$1(QCircleMessageReplyItemView paramQCircleMessageReplyItemView, FeedCloudMeta.StReply paramStReply) {}
  
  public void a()
  {
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(QCircleMessageReplyItemView.c(this.b).a).setToUin(this.a.postUser.id.get()).setActionType(44).setSubActionType(2).setIndex(QCircleMessageReplyItemView.b(this.b)).setPageId(QCircleMessageReplyItemView.a(this.b))));
    QCircleMessageReplyItemView.a(this.b, this.a.postUser.id.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.item.QCircleMessageReplyItemView.1
 * JD-Core Version:    0.7.0.1
 */