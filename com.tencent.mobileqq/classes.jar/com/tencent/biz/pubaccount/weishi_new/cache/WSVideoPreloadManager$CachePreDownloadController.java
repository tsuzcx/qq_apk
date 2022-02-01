package com.tencent.biz.pubaccount.weishi_new.cache;

import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager.PreDownloadController;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager.VideoPreDownloadParam;
import java.util.ArrayList;
import java.util.List;

class WSVideoPreloadManager$CachePreDownloadController
  implements WSVideoPreDownloadManager.PreDownloadController
{
  stSimpleMetaFeed a;
  
  WSVideoPreloadManager$CachePreDownloadController(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    this.a = paramstSimpleMetaFeed;
  }
  
  public List<WSVideoPreDownloadManager.VideoPreDownloadParam> a(int paramInt, boolean paramBoolean)
  {
    WSVideoPreDownloadManager.VideoPreDownloadParam localVideoPreDownloadParam = new WSVideoPreDownloadManager.VideoPreDownloadParam(this.a.video_url, this.a.video.duration);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localVideoPreDownloadParam);
    return localArrayList;
  }
  
  public boolean a()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WSVideoPreloadManager.CachePreDownloadController
 * JD-Core Version:    0.7.0.1
 */