package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;

class WeiShiCacheManager$1
  implements Runnable
{
  WeiShiCacheManager$1(WeiShiCacheManager paramWeiShiCacheManager, IWeiShiCacheCallback paramIWeiShiCacheCallback) {}
  
  public void run()
  {
    WSLog.b("CacheResponseLog", "getCachedRecommendData startTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
    if (!this.this$0.a()) {
      return;
    }
    if (WeishiUtils.a(8)) {}
    for (stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = WeiShiCacheManager.a(this.this$0);; localstSimpleGetFeedListRsp = WeiShiCacheManager.b(this.this$0))
    {
      this.this$0.a(8);
      WeishiBusinessLooper.a().a(new WeiShiCacheManager.1.1(this, localstSimpleGetFeedListRsp));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.1
 * JD-Core Version:    0.7.0.1
 */