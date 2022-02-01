package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WeiShiCacheManager$2$1
  implements Runnable
{
  WeiShiCacheManager$2$1(WeiShiCacheManager.2 param2, stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCacheWeiShiCacheManager$2.a != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPushPreloadCacheData endTime = ");
      localStringBuilder.append(System.currentTimeMillis());
      localStringBuilder.append(", thread = ");
      localStringBuilder.append(Thread.currentThread());
      WSLog.b("CacheResponseLog", localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCacheWeiShiCacheManager$2.a.a(this.jdField_a_of_type_UserGrowthStSimpleGetFeedListRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.2.1
 * JD-Core Version:    0.7.0.1
 */