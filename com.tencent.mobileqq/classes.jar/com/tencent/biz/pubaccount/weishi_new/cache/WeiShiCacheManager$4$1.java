package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stGetFollowedDramasRsp;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WeiShiCacheManager$4$1
  implements Runnable
{
  WeiShiCacheManager$4$1(WeiShiCacheManager.4 param4, stGetFollowedDramasRsp paramstGetFollowedDramasRsp) {}
  
  public void run()
  {
    if (this.b.a != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCacheDataForFollowDrama endTime = ");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append(", thread = ");
      localStringBuilder.append(Thread.currentThread());
      WSLog.b("CacheResponseLog", localStringBuilder.toString());
      this.b.a.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.4.1
 * JD-Core Version:    0.7.0.1
 */