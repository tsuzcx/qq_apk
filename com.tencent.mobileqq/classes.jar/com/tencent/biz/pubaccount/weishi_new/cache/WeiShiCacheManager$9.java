package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WeiShiCacheManager$9
  implements Runnable
{
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getCachedRecommendData startTime = ");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(", thread = ");
    ((StringBuilder)localObject).append(Thread.currentThread());
    WSLog.b("CacheResponseLog", ((StringBuilder)localObject).toString());
    if (!this.this$0.a()) {
      return;
    }
    localObject = WeiShiCacheManager.a(this.this$0, 1);
    WeishiBusinessLooper.a().a(new WeiShiCacheManager.9.1(this, (stSimpleGetFeedListRsp)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.9
 * JD-Core Version:    0.7.0.1
 */