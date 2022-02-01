package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stGetTabsRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WeiShiCacheManager$15
  implements Runnable
{
  WeiShiCacheManager$15(WeiShiCacheManager paramWeiShiCacheManager, IWeiShiCacheCallback paramIWeiShiCacheCallback) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getCacheDataForTabsInfo startTime = ");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(", thread = ");
    ((StringBuilder)localObject).append(Thread.currentThread());
    WSLog.b("CacheResponseLog", ((StringBuilder)localObject).toString());
    localObject = (stGetTabsRsp)WeiShiCacheManager.a(this.this$0, new stGetTabsRsp(), 6);
    WeishiBusinessLooper.a().a(new WeiShiCacheManager.15.1(this, (stGetTabsRsp)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.15
 * JD-Core Version:    0.7.0.1
 */