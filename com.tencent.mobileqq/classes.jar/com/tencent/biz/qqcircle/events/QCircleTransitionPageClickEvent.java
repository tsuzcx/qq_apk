package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StUser;

public class QCircleTransitionPageClickEvent
  extends SimpleBaseEvent
{
  public FeedCloudMeta.StFeed mFeed = new FeedCloudMeta.StFeed();
  public FeedCloudMeta.StUser mUser = new FeedCloudMeta.StUser();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.events.QCircleTransitionPageClickEvent
 * JD-Core Version:    0.7.0.1
 */