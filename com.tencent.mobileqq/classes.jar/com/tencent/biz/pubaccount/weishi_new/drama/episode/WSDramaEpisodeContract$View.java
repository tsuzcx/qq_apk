package com.tencent.biz.pubaccount.weishi_new.drama.episode;

import UserGrowth.stDramaFeed;
import UserGrowth.stDramaInfo;
import com.tencent.biz.pubaccount.weishi_new.IWSBaseView;
import java.util.List;

public abstract interface WSDramaEpisodeContract$View
  extends IWSBaseView
{
  public abstract void a(int paramInt, String paramString);
  
  public abstract void a(stDramaFeed paramstDramaFeed);
  
  public abstract void a(List<WSEpisodeItemData> paramList, stDramaInfo paramstDramaInfo);
  
  public abstract String b();
  
  public abstract void b(stDramaFeed paramstDramaFeed);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.drama.episode.WSDramaEpisodeContract.View
 * JD-Core Version:    0.7.0.1
 */