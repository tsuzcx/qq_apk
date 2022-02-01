package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stGetTabsRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WeiShiCacheManager$14
  implements Runnable
{
  WeiShiCacheManager$14(WeiShiCacheManager paramWeiShiCacheManager, IWeiShiCacheCallback paramIWeiShiCacheCallback) {}
  
  public void run()
  {
    WSLog.b("CacheResponseLog", "getCacheDataForTabsInfo startTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
    stGetTabsRsp localstGetTabsRsp = (stGetTabsRsp)WeiShiCacheManager.a(this.this$0, new stGetTabsRsp(), 6);
    WeishiBusinessLooper.a().a(new WeiShiCacheManager.14.1(this, localstGetTabsRsp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.14
 * JD-Core Version:    0.7.0.1
 */