package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stFollowFeedsRsp;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import mqq.util.WeakReference;

class WeiShiCacheManager$3$1
  implements Runnable
{
  WeiShiCacheManager$3$1(WeiShiCacheManager.3 param3, stFollowFeedsRsp paramstFollowFeedsRsp) {}
  
  public void run()
  {
    IWeiShiCacheCallback localIWeiShiCacheCallback = (IWeiShiCacheCallback)this.b.a.get();
    if (localIWeiShiCacheCallback != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCacheDataForFollow endTime = ");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append(", thread = ");
      localStringBuilder.append(Thread.currentThread());
      WSLog.b("CacheResponseLog", localStringBuilder.toString());
      localIWeiShiCacheCallback.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.3.1
 * JD-Core Version:    0.7.0.1
 */