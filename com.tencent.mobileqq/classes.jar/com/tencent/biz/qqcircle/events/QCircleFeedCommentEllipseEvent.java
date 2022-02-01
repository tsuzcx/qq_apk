package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import vba;

public class QCircleFeedCommentEllipseEvent
  extends SimpleBaseEvent
{
  public vba mInfo;
  
  public QCircleFeedCommentEllipseEvent(vba paramvba)
  {
    this.mInfo = paramvba;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleFeedCommentEllipseEvent
 * JD-Core Version:    0.7.0.1
 */