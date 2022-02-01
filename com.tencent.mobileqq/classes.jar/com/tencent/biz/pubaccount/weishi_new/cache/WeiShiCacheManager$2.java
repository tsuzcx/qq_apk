package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WeiShiCacheManager$2
  implements Runnable
{
  WeiShiCacheManager$2(WeiShiCacheManager paramWeiShiCacheManager, IWeiShiCacheCallback paramIWeiShiCacheCallback) {}
  
  public void run()
  {
    WSLog.b("CacheResponseLog", "getPushPreloadCacheData startTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
    if (!this.this$0.a())
    {
      if (this.a == null) {
        return;
      }
      this.a.a(null);
      return;
    }
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = WeiShiCacheManager.a(this.this$0, 5);
    this.this$0.a(13);
    WeishiBusinessLooper.a().a(new WeiShiCacheManager.2.1(this, localstSimpleGetFeedListRsp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.2
 * JD-Core Version:    0.7.0.1
 */