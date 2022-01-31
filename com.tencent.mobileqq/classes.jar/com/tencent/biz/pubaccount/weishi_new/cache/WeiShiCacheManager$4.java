package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import rxc;
import rys;
import sai;

public class WeiShiCacheManager$4
  implements Runnable
{
  public void run()
  {
    sai.b("CacheResponseLog", "getCachedRecommendData startTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
    if (!this.this$0.b()) {
      return;
    }
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = rxc.a(this.this$0, 1);
    rys.a().a(new WeiShiCacheManager.4.1(this, localstSimpleGetFeedListRsp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.4
 * JD-Core Version:    0.7.0.1
 */