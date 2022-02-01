package com.tencent.biz.pubaccount.weishi_new.drama.cache;

import UserGrowth.stDrama;
import UserGrowth.stDramaFeed;
import java.util.List;

public abstract interface IWSDramaFeedTransfer<TO>
{
  public abstract List<TO> a(stDrama paramstDrama, List<stDramaFeed> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.cache.IWSDramaFeedTransfer
 * JD-Core Version:    0.7.0.1
 */