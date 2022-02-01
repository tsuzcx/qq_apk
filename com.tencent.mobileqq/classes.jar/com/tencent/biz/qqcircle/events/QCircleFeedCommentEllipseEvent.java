package com.tencent.biz.qqcircle.events;

import com.tencent.biz.qqcircle.beans.QCircleFeedCommentInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleFeedCommentEllipseEvent
  extends SimpleBaseEvent
{
  public QCircleFeedCommentInfo mInfo;
  
  public QCircleFeedCommentEllipseEvent(QCircleFeedCommentInfo paramQCircleFeedCommentInfo)
  {
    this.mInfo = paramQCircleFeedCommentInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleFeedCommentEllipseEvent
 * JD-Core Version:    0.7.0.1
 */