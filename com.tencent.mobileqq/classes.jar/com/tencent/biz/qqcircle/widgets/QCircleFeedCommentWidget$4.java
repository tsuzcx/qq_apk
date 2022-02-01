package com.tencent.biz.qqcircle.widgets;

import com.tencent.biz.qqcircle.aspectj.QCircleAspectClickProcessor;
import com.tencent.biz.qqcircle.aspectj.QCircleFeedClick;
import feedcloud.FeedCloudMeta.StReply;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.runtime.reflect.Factory;

class QCircleFeedCommentWidget$4
  implements QCircleAsyncTextView.OnClickBoldTextListener
{
  static {}
  
  QCircleFeedCommentWidget$4(QCircleFeedCommentWidget paramQCircleFeedCommentWidget, FeedCloudMeta.StReply paramStReply) {}
  
  @QCircleFeedClick
  public void a()
  {
    JoinPoint localJoinPoint = Factory.makeJP(c, this, this);
    a(this, localJoinPoint, QCircleAspectClickProcessor.a(), (ProceedingJoinPoint)localJoinPoint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleFeedCommentWidget.4
 * JD-Core Version:    0.7.0.1
 */