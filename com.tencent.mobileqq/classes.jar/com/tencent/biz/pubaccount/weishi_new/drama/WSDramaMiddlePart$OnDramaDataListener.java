package com.tencent.biz.pubaccount.weishi_new.drama;

import UserGrowth.stDramaFeed;
import com.tencent.biz.pubaccount.weishi_new.drama.data.WSDramaItemData;
import com.tencent.biz.pubaccount.weishi_new.drama.episode.WSEpisodeItemData;

public abstract interface WSDramaMiddlePart$OnDramaDataListener
{
  public abstract void a(stDramaFeed paramstDramaFeed);
  
  public abstract void a(WSDramaItemData paramWSDramaItemData, int paramInt);
  
  public abstract void a(WSEpisodeItemData paramWSEpisodeItemData, int paramInt);
  
  public abstract void b(stDramaFeed paramstDramaFeed);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.WSDramaMiddlePart.OnDramaDataListener
 * JD-Core Version:    0.7.0.1
 */