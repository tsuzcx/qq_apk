package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import java.util.ArrayList;
import pgj;
import uel;
import uep;
import ukh;
import uqf;
import uqt;

public class WeiShiCacheManager$1
  implements Runnable
{
  public WeiShiCacheManager$1(uep paramuep, uel paramuel) {}
  
  public void run()
  {
    uqf.b("CacheResponseLog", "getCachedRecommendData startTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
    if (!this.this$0.b()) {
      return;
    }
    boolean bool = false;
    Object localObject = uqt.a();
    if (localObject != null) {
      bool = uqt.a((pgj)localObject);
    }
    uqf.b("WeiShiCacheManager", "isRedDotMsg = " + bool);
    if (bool) {
      if ((this.this$0.a()) && (this.this$0.a() >= 8))
      {
        uqf.b("WeiShiCacheManager", "仅读取红点缓存");
        localObject = uep.a(this.this$0, 2);
      }
    }
    for (;;)
    {
      ukh.a().a(new WeiShiCacheManager.1.1(this, (stSimpleGetFeedListRsp)localObject));
      return;
      uqf.b("WeiShiCacheManager", "读取红点缓存和瀑布流缓存");
      localObject = uep.a(this.this$0, 2);
      stSimpleGetFeedListRsp localstSimpleGetFeedListRsp2 = uep.a(this.this$0, 1);
      stSimpleGetFeedListRsp localstSimpleGetFeedListRsp1 = new stSimpleGetFeedListRsp();
      localstSimpleGetFeedListRsp1.feeds = new ArrayList();
      if (localObject != null)
      {
        uqf.b("WeiShiCacheManager", "红点缓存数量 = " + ((stSimpleGetFeedListRsp)localObject).feeds.size());
        localstSimpleGetFeedListRsp1.feeds.addAll(((stSimpleGetFeedListRsp)localObject).feeds);
      }
      localObject = localstSimpleGetFeedListRsp1;
      if (localstSimpleGetFeedListRsp2 != null)
      {
        uqf.b("WeiShiCacheManager", "瀑布流缓存数量 = " + localstSimpleGetFeedListRsp2.feeds.size());
        localstSimpleGetFeedListRsp1.feeds.addAll(localstSimpleGetFeedListRsp2.feeds);
        localObject = localstSimpleGetFeedListRsp1;
        continue;
        uqf.b("WeiShiCacheManager", "读取瀑布流缓存数据");
        localObject = uep.a(this.this$0, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.1
 * JD-Core Version:    0.7.0.1
 */