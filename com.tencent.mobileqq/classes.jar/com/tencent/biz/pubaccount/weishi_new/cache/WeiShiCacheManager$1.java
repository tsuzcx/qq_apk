package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;

class WeiShiCacheManager$1
  implements Runnable
{
  WeiShiCacheManager$1(WeiShiCacheManager paramWeiShiCacheManager, boolean paramBoolean, IWeiShiCacheCallback paramIWeiShiCacheCallback) {}
  
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
    if (WeishiUtils.a(8)) {
      localObject = WeiShiCacheManager.a(this.this$0);
    } else {
      localObject = WeiShiCacheManager.a(this.this$0, this.jdField_a_of_type_Boolean);
    }
    this.this$0.a(8);
    WeishiBusinessLooper.a().a(new WeiShiCacheManager.1.1(this, (stSimpleGetFeedListRsp)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.1
 * JD-Core Version:    0.7.0.1
 */