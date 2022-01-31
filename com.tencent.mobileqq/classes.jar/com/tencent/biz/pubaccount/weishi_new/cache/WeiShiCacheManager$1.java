package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import java.util.ArrayList;
import oye;
import tcm;
import tcq;
import tgx;
import tlo;
import tlv;

public class WeiShiCacheManager$1
  implements Runnable
{
  public WeiShiCacheManager$1(tcq paramtcq, tcm paramtcm) {}
  
  public void run()
  {
    tlo.b("CacheResponseLog", "getCachedRecommendData startTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
    if (!this.this$0.b()) {
      return;
    }
    boolean bool = false;
    Object localObject = tlv.a();
    if (localObject != null) {
      bool = tlv.a((oye)localObject);
    }
    tlo.b("WeiShiCacheManager", "isRedDotMsg = " + bool);
    if (bool) {
      if ((this.this$0.a()) && (this.this$0.a() >= 8))
      {
        tlo.b("WeiShiCacheManager", "仅读取红点缓存");
        localObject = tcq.a(this.this$0, 2);
      }
    }
    for (;;)
    {
      tgx.a().a(new WeiShiCacheManager.1.1(this, (stSimpleGetFeedListRsp)localObject));
      return;
      tlo.b("WeiShiCacheManager", "读取红点缓存和瀑布流缓存");
      localObject = tcq.a(this.this$0, 2);
      stSimpleGetFeedListRsp localstSimpleGetFeedListRsp2 = tcq.a(this.this$0, 1);
      stSimpleGetFeedListRsp localstSimpleGetFeedListRsp1 = new stSimpleGetFeedListRsp();
      localstSimpleGetFeedListRsp1.feeds = new ArrayList();
      if (localObject != null)
      {
        tlo.b("WeiShiCacheManager", "红点缓存数量 = " + ((stSimpleGetFeedListRsp)localObject).feeds.size());
        localstSimpleGetFeedListRsp1.feeds.addAll(((stSimpleGetFeedListRsp)localObject).feeds);
      }
      localObject = localstSimpleGetFeedListRsp1;
      if (localstSimpleGetFeedListRsp2 != null)
      {
        tlo.b("WeiShiCacheManager", "瀑布流缓存数量 = " + localstSimpleGetFeedListRsp2.feeds.size());
        localstSimpleGetFeedListRsp1.feeds.addAll(localstSimpleGetFeedListRsp2.feeds);
        localObject = localstSimpleGetFeedListRsp1;
        continue;
        tlo.b("WeiShiCacheManager", "读取瀑布流缓存数据");
        localObject = tcq.a(this.this$0, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.1
 * JD-Core Version:    0.7.0.1
 */