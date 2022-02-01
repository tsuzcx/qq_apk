package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.ArrayList;
import java.util.List;

public class WSVideoPreloadManager
{
  public static void a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    WSLog.e("WSVideoPreloadManager", "[prepareRecommendFloatPageData] download cache video");
    b(paramstSimpleMetaFeed);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramstSimpleMetaFeed);
    WeishiUtils.a(localArrayList, false);
    WeiShiCacheManager.a().b(localArrayList);
  }
  
  public static void b(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed == null) {}
    WSVideoPreDownloadManager localWSVideoPreDownloadManager;
    boolean bool;
    do
    {
      return;
      localWSVideoPreDownloadManager = new WSVideoPreDownloadManager(BaseApplicationImpl.sApplication);
      bool = localWSVideoPreDownloadManager.a(paramstSimpleMetaFeed.video_url);
      WSLog.a("WSVideoPreloadManager", "sec itemInfo : " + paramstSimpleMetaFeed + "; isCached = " + bool);
    } while (bool);
    localWSVideoPreDownloadManager.a(new WSVideoPreloadManager.CachePreDownloadController(paramstSimpleMetaFeed));
    localWSVideoPreDownloadManager.a(new WSVideoPreloadManager.CachePreloadCallback(localWSVideoPreDownloadManager, paramstSimpleMetaFeed.video_url));
    localWSVideoPreDownloadManager.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WSVideoPreloadManager
 * JD-Core Version:    0.7.0.1
 */