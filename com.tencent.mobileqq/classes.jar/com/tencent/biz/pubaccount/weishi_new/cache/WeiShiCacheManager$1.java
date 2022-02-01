package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import java.util.ArrayList;
import plv;
import ulb;
import ulf;
import urc;
import uya;
import uyo;

public class WeiShiCacheManager$1
  implements Runnable
{
  public WeiShiCacheManager$1(ulf paramulf, ulb paramulb) {}
  
  public void run()
  {
    uya.b("CacheResponseLog", "getCachedRecommendData startTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
    if (!this.this$0.b()) {
      return;
    }
    boolean bool = false;
    Object localObject = uyo.a();
    if (localObject != null) {
      bool = uyo.a((plv)localObject);
    }
    uya.b("WeiShiCacheManager", "isRedDotMsg = " + bool);
    if (bool) {
      if ((this.this$0.a()) && (this.this$0.a() >= 8))
      {
        uya.b("WeiShiCacheManager", "仅读取红点缓存");
        localObject = ulf.a(this.this$0, 2);
      }
    }
    for (;;)
    {
      urc.a().a(new WeiShiCacheManager.1.1(this, (stSimpleGetFeedListRsp)localObject));
      return;
      uya.b("WeiShiCacheManager", "读取红点缓存和瀑布流缓存");
      localObject = ulf.a(this.this$0, 2);
      stSimpleGetFeedListRsp localstSimpleGetFeedListRsp2 = ulf.a(this.this$0, 1);
      stSimpleGetFeedListRsp localstSimpleGetFeedListRsp1 = new stSimpleGetFeedListRsp();
      localstSimpleGetFeedListRsp1.feeds = new ArrayList();
      if (localObject != null)
      {
        uya.b("WeiShiCacheManager", "红点缓存数量 = " + ((stSimpleGetFeedListRsp)localObject).feeds.size());
        localstSimpleGetFeedListRsp1.feeds.addAll(((stSimpleGetFeedListRsp)localObject).feeds);
      }
      localObject = localstSimpleGetFeedListRsp1;
      if (localstSimpleGetFeedListRsp2 != null)
      {
        uya.b("WeiShiCacheManager", "瀑布流缓存数量 = " + localstSimpleGetFeedListRsp2.feeds.size());
        localstSimpleGetFeedListRsp1.feeds.addAll(localstSimpleGetFeedListRsp2.feeds);
        localObject = localstSimpleGetFeedListRsp1;
        continue;
        uya.b("WeiShiCacheManager", "读取瀑布流缓存数据");
        localObject = ulf.a(this.this$0, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.1
 * JD-Core Version:    0.7.0.1
 */