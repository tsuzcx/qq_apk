package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WeiShiCacheManager$8
  implements Runnable
{
  public void run()
  {
    WSLog.b("CacheResponseLog", "getCachedRecommendData startTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
    if (!this.this$0.a()) {
      return;
    }
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = WeiShiCacheManager.a(this.this$0, 1);
    WeishiBusinessLooper.a().a(new WeiShiCacheManager.8.1(this, localstSimpleGetFeedListRsp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.8
 * JD-Core Version:    0.7.0.1
 */