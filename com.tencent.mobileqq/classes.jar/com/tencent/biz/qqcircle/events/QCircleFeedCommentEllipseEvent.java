package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import uzk;

public class QCircleFeedCommentEllipseEvent
  extends SimpleBaseEvent
{
  public uzk mInfo;
  
  public QCircleFeedCommentEllipseEvent(uzk paramuzk)
  {
    this.mInfo = paramuzk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleFeedCommentEllipseEvent
 * JD-Core Version:    0.7.0.1
 */