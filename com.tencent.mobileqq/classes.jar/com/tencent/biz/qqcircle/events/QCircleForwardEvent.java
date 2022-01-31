package com.tencent.biz.qqcircle.events;

import com.tencent.biz.subscribe.event.SimpleBaseEvent;
import feedcloud.FeedCloudMeta.StFeed;
import tra;

public class QCircleForwardEvent
  extends SimpleBaseEvent
{
  public FeedCloudMeta.StFeed feed;
  public boolean isSynchronizeComment;
  
  public QCircleForwardEvent(FeedCloudMeta.StFeed paramStFeed, boolean paramBoolean)
  {
    this.feed = tra.b(paramStFeed);
    this.isSynchronizeComment = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleForwardEvent
 * JD-Core Version:    0.7.0.1
 */