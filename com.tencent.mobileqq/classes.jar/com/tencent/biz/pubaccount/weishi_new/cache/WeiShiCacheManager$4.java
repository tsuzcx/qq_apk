package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stGetFollowedDramasRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WeiShiCacheManager$4
  implements Runnable
{
  WeiShiCacheManager$4(WeiShiCacheManager paramWeiShiCacheManager, IWeiShiCacheCallback paramIWeiShiCacheCallback) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getCacheDataForFollowDrama startTime = ");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(", thread = ");
    ((StringBuilder)localObject).append(Thread.currentThread());
    WSLog.b("CacheResponseLog", ((StringBuilder)localObject).toString());
    if (!this.this$0.c()) {
      return;
    }
    localObject = (stGetFollowedDramasRsp)WeiShiCacheManager.a(this.this$0, new stGetFollowedDramasRsp(), 7);
    WeishiBusinessLooper.a().a(new WeiShiCacheManager.4.1(this, (stGetFollowedDramasRsp)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.4
 * JD-Core Version:    0.7.0.1
 */