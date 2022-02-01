package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta.StFeed;

public class QCircleFeedBottomInputAndShareEvent
  extends SimpleBaseEvent
{
  public FeedCloudMeta.StFeed mCurrentFeed;
  
  public QCircleFeedBottomInputAndShareEvent(FeedCloudMeta.StFeed paramStFeed)
  {
    this.mCurrentFeed = paramStFeed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleFeedBottomInputAndShareEvent
 * JD-Core Version:    0.7.0.1
 */