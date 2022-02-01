package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WeiShiCacheManager$9$1
  implements Runnable
{
  WeiShiCacheManager$9$1(WeiShiCacheManager.9 param9, stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp) {}
  
  public void run()
  {
    if (this.b.a != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCachedRecommendData endTime = ");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append(", thread = ");
      localStringBuilder.append(Thread.currentThread());
      WSLog.b("CacheResponseLog", localStringBuilder.toString());
      this.b.a.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.9.1
 * JD-Core Version:    0.7.0.1
 */