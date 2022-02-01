package com.tencent.biz.pubaccount.weishi_new.drama.episode;

import UserGrowth.stDramaInfo;
import java.util.List;

public class WSDramaEpisodeEntity
{
  private final List<WSEpisodeItemData> a;
  private final stDramaInfo b;
  
  public WSDramaEpisodeEntity(List<WSEpisodeItemData> paramList, stDramaInfo paramstDramaInfo)
  {
    this.a = paramList;
    this.b = paramstDramaInfo;
  }
  
  public List<WSEpisodeItemData> a()
  {
    return this.a;
  }
  
  public stDramaInfo b()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.episode.WSDramaEpisodeEntity
 * JD-Core Version:    0.7.0.1
 */