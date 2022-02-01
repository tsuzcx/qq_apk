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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getPushPreloadCacheData startTime = ");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(", thread = ");
    ((StringBuilder)localObject).append(Thread.currentThread());
    WSLog.b("CacheResponseLog", ((StringBuilder)localObject).toString());
    if (!this.this$0.c())
    {
      localObject = this.a;
      if (localObject == null) {
        return;
      }
      ((IWeiShiCacheCallback)localObject).a(null);
      return;
    }
    localObject = WeiShiCacheManager.a(this.this$0, 5);
    this.this$0.c(13);
    WeishiBusinessLooper.a().a(new WeiShiCacheManager.2.1(this, (stSimpleGetFeedListRsp)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.2
 * JD-Core Version:    0.7.0.1
 */