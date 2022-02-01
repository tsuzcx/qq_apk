package com.tencent.biz.qqcircle.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCirclePublishAssociateTagEvent
  extends SimpleBaseEvent
{
  public String tag;
  
  public QCirclePublishAssociateTagEvent(String paramString)
  {
    this.tag = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.event.QCirclePublishAssociateTagEvent
 * JD-Core Version:    0.7.0.1
 */