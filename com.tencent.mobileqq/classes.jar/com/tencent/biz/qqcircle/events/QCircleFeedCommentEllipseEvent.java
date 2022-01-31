package com.tencent.biz.qqcircle.events;

import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import trx;

public class QCircleFeedCommentEllipseEvent
  extends SimpleBaseEvent
{
  public trx mInfo;
  
  public QCircleFeedCommentEllipseEvent(trx paramtrx)
  {
    this.mInfo = paramtrx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleFeedCommentEllipseEvent
 * JD-Core Version:    0.7.0.1
 */