package com.tencent.biz.pubaccount.weishi_new.event;

import UserGrowth.stSimpleMetaFeed;

public class WSFriendFeedExposureEvent
  extends WSSimpleBaseEvent
{
  public int currentPosition;
  public stSimpleMetaFeed video;
  
  public WSFriendFeedExposureEvent() {}
  
  public WSFriendFeedExposureEvent(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    this.video = paramstSimpleMetaFeed;
    this.currentPosition = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.event.WSFriendFeedExposureEvent
 * JD-Core Version:    0.7.0.1
 */