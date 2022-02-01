package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta.StFeed;

public class QFSCommentSendEvent
  extends SimpleBaseEvent
{
  public FeedCloudMeta.StFeed mFeed;
  
  public QFSCommentSendEvent(FeedCloudMeta.StFeed paramStFeed)
  {
    this.mFeed = paramStFeed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QFSCommentSendEvent
 * JD-Core Version:    0.7.0.1
 */