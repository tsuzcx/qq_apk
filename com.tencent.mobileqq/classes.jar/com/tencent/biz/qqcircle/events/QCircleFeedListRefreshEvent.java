package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;

public class QCircleFeedListRefreshEvent
  extends SimpleBaseEvent
{
  public int mPageType;
  
  public QCircleFeedListRefreshEvent(int paramInt)
  {
    this.mPageType = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleFeedListRefreshEvent
 * JD-Core Version:    0.7.0.1
 */