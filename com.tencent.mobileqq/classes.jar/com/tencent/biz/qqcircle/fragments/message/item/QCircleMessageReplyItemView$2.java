package com.tencent.biz.qqcircle.fragments.message.item;

import com.tencent.biz.qqcircle.beans.QCircleFeedCommentInfo;
import com.tencent.biz.qqcircle.report.QCirclePluginReportUtil;
import com.tencent.biz.qqcircle.widgets.QCircleAsyncTextView.OnClickBoldTextListener;
import cooperation.qqcircle.report.QCircleLpReportDc05501;
import cooperation.qqcircle.report.QCircleLpReportDc05501.DataBuilder;

class QCircleMessageReplyItemView$2
  implements QCircleAsyncTextView.OnClickBoldTextListener
{
  QCircleMessageReplyItemView$2(QCircleMessageReplyItemView paramQCircleMessageReplyItemView, String paramString) {}
  
  public void a()
  {
    QCircleLpReportDc05501.report(new QCircleLpReportDc05501.DataBuilder(QCirclePluginReportUtil.b(QCircleMessageReplyItemView.c(this.b).a).setToUin(this.a).setActionType(44).setSubActionType(2).setIndex(QCircleMessageReplyItemView.b(this.b)).setPageId(QCircleMessageReplyItemView.d(this.b))));
    QCircleMessageReplyItemView.a(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.message.item.QCircleMessageReplyItemView.2
 * JD-Core Version:    0.7.0.1
 */