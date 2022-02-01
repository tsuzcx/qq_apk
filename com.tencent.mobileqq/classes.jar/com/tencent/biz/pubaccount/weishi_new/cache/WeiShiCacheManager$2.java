package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stFollowFeedsRsp;
import mqq.util.WeakReference;
import uep;
import ukh;
import uqf;

public class WeiShiCacheManager$2
  implements Runnable
{
  public WeiShiCacheManager$2(uep paramuep, WeakReference paramWeakReference) {}
  
  public void run()
  {
    uqf.b("CacheResponseLog", "getCacheDataForFollow startTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
    if (!this.this$0.b()) {
      return;
    }
    stFollowFeedsRsp localstFollowFeedsRsp = (stFollowFeedsRsp)uep.a(this.this$0, new stFollowFeedsRsp(), 3);
    ukh.a().a(new WeiShiCacheManager.2.1(this, localstFollowFeedsRsp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.2
 * JD-Core Version:    0.7.0.1
 */