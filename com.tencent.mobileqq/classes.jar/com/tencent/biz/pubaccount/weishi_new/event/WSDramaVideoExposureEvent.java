package com.tencent.biz.pubaccount.weishi_new.event;

import UserGrowth.stSimpleMetaFeed;

public class WSDramaVideoExposureEvent
  extends WSSimpleBaseEvent
{
  private int currentEpisodeNum;
  private stSimpleMetaFeed feedInfo;
  
  public int getCurrentEpisodeNum()
  {
    return this.currentEpisodeNum;
  }
  
  public stSimpleMetaFeed getFeedInfo()
  {
    return this.feedInfo;
  }
  
  public void setCurrentEpisodeNum(int paramInt)
  {
    this.currentEpisodeNum = paramInt;
  }
  
  public void setFeedInfo(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    this.feedInfo = paramstSimpleMetaFeed;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WSDramaVideoExposureEvent{currentEpisodeNum=");
    localStringBuilder.append(this.currentEpisodeNum);
    localStringBuilder.append(", feedInfo=");
    localStringBuilder.append(this.feedInfo);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.event.WSDramaVideoExposureEvent
 * JD-Core Version:    0.7.0.1
 */