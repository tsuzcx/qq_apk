package com.tencent.biz.pubaccount.weishi_new.event;

public class WSDramaWatchRecordEvent
  extends WSSimpleBaseEvent
{
  private String dramaId;
  private int episodeNum;
  private String feedId;
  
  public WSDramaWatchRecordEvent(String paramString1, String paramString2, int paramInt)
  {
    this.dramaId = paramString1;
    this.feedId = paramString2;
    this.episodeNum = paramInt;
  }
  
  public String getDramaId()
  {
    return this.dramaId;
  }
  
  public int getEpisodeNum()
  {
    return this.episodeNum;
  }
  
  public String getFeedId()
  {
    return this.feedId;
  }
  
  public void setDramaId(String paramString)
  {
    this.dramaId = paramString;
  }
  
  public void setEpisodeNum(int paramInt)
  {
    this.episodeNum = paramInt;
  }
  
  public void setFeedId(String paramString)
  {
    this.feedId = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.event.WSDramaWatchRecordEvent
 * JD-Core Version:    0.7.0.1
 */