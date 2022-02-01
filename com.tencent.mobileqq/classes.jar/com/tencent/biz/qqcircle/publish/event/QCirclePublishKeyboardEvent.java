package com.tencent.biz.qqcircle.publish.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCirclePublishKeyboardEvent
  extends SimpleBaseEvent
{
  public boolean showKeyboard;
  
  public QCirclePublishKeyboardEvent(boolean paramBoolean)
  {
    this.showKeyboard = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.event.QCirclePublishKeyboardEvent
 * JD-Core Version:    0.7.0.1
 */