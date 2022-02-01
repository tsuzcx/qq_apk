package com.tencent.biz.pubaccount.weishi_new.event;

import UserGrowth.stSimpleMetaFeed;

public class WSItemExposeEvent
  extends WSSimpleBaseEvent
{
  public stSimpleMetaFeed video;
  
  public WSItemExposeEvent() {}
  
  public WSItemExposeEvent(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    this.video = paramstSimpleMetaFeed;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.event.WSItemExposeEvent
 * JD-Core Version:    0.7.0.1
 */