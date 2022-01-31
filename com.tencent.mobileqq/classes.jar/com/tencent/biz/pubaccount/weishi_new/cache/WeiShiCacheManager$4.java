package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import sjv;
import sll;
import snb;

public class WeiShiCacheManager$4
  implements Runnable
{
  public void run()
  {
    snb.b("CacheResponseLog", "getCachedRecommendData startTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
    if (!this.this$0.b()) {
      return;
    }
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = sjv.a(this.this$0, 1);
    sll.a().a(new WeiShiCacheManager.4.1(this, localstSimpleGetFeedListRsp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.4
 * JD-Core Version:    0.7.0.1
 */