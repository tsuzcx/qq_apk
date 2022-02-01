package com.tencent.biz.pubaccount.weishi_new.event;

import UserGrowth.stDrama;

public class WSDramaVideoPlayEvent
  extends WSSimpleBaseEvent
{
  private String dramaId;
  private stDrama dramaInfo;
  private String episodeId;
  private int episodeNum;
  private boolean isDramaPreviewPage;
  
  public String getDramaId()
  {
    return this.dramaId;
  }
  
  public stDrama getDramaInfo()
  {
    return this.dramaInfo;
  }
  
  public String getEpisodeId()
  {
    return this.episodeId;
  }
  
  public int getEpisodeNum()
  {
    return this.episodeNum;
  }
  
  public boolean isDramaPreviewPage()
  {
    return this.isDramaPreviewPage;
  }
  
  public void setDramaId(String paramString)
  {
    this.dramaId = paramString;
  }
  
  public void setDramaInfo(stDrama paramstDrama)
  {
    this.dramaInfo = paramstDrama;
  }
  
  public void setDramaPreviewPage(boolean paramBoolean)
  {
    this.isDramaPreviewPage = paramBoolean;
  }
  
  public void setEpisodeId(String paramString)
  {
    this.episodeId = paramString;
  }
  
  public void setEpisodeNum(int paramInt)
  {
    this.episodeNum = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WSDramaVideoPlayEvent{episodeNum=");
    localStringBuilder.append(this.episodeNum);
    localStringBuilder.append(", dramaId='");
    localStringBuilder.append(this.dramaId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", episodeId='");
    localStringBuilder.append(this.episodeId);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.event.WSDramaVideoPlayEvent
 * JD-Core Version:    0.7.0.1
 */