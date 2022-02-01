package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.List;

public class WSVideoPreloadManager
{
  public static void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed == null) {
      return;
    }
    WSVideoPreDownloadManager localWSVideoPreDownloadManager = new WSVideoPreDownloadManager(BaseApplicationImpl.sApplication);
    boolean bool = localWSVideoPreDownloadManager.a(paramstSimpleMetaFeed.video_url);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sec itemInfo : ");
    localStringBuilder.append(paramstSimpleMetaFeed);
    localStringBuilder.append("; isCached = ");
    localStringBuilder.append(bool);
    WSLog.a("WSVideoPreloadManager", localStringBuilder.toString());
    if (!bool)
    {
      localWSVideoPreDownloadManager.a(new WSVideoPreloadManager.CachePreDownloadController(paramstSimpleMetaFeed));
      localWSVideoPreDownloadManager.a(new WSVideoPreloadManager.CachePreloadCallback(localWSVideoPreDownloadManager, paramstSimpleMetaFeed.video_url));
      localWSVideoPreDownloadManager.a(0);
    }
  }
  
  public static void a(stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean)
  {
    WSLog.e("WSVideoPreloadManager", "[prepareRecommendFloatPageData] download cache video");
    if (paramBoolean) {
      a(paramstSimpleMetaFeed);
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramstSimpleMetaFeed);
    WSPicLoader.a(localArrayList, false);
    WeiShiCacheManager.a().b(localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WSVideoPreloadManager
 * JD-Core Version:    0.7.0.1
 */