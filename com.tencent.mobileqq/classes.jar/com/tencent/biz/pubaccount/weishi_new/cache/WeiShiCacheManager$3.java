package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stFollowFeedsRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import mqq.util.WeakReference;

class WeiShiCacheManager$3
  implements Runnable
{
  WeiShiCacheManager$3(WeiShiCacheManager paramWeiShiCacheManager, WeakReference paramWeakReference) {}
  
  public void run()
  {
    WSLog.b("CacheResponseLog", "getCacheDataForFollow startTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
    if (!this.this$0.a()) {
      return;
    }
    stFollowFeedsRsp localstFollowFeedsRsp = (stFollowFeedsRsp)WeiShiCacheManager.a(this.this$0, new stFollowFeedsRsp(), 3);
    WeishiBusinessLooper.a().a(new WeiShiCacheManager.3.1(this, localstFollowFeedsRsp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.3
 * JD-Core Version:    0.7.0.1
 */