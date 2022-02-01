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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getCacheDataForFollow startTime = ");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(", thread = ");
    ((StringBuilder)localObject).append(Thread.currentThread());
    WSLog.b("CacheResponseLog", ((StringBuilder)localObject).toString());
    if (!this.this$0.a()) {
      return;
    }
    localObject = (stFollowFeedsRsp)WeiShiCacheManager.a(this.this$0, new stFollowFeedsRsp(), 3);
    WeishiBusinessLooper.a().a(new WeiShiCacheManager.3.1(this, (stFollowFeedsRsp)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.3
 * JD-Core Version:    0.7.0.1
 */