package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WeiShiCacheManager$10$1
  implements Runnable
{
  WeiShiCacheManager$10$1(WeiShiCacheManager.10 param10, stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCacheWeiShiCacheManager$10.a != null)
    {
      WSLog.b("CacheResponseLog", "getRecommendVerticalData endTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCacheWeiShiCacheManager$10.a.a(this.jdField_a_of_type_UserGrowthStSimpleGetFeedListRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.10.1
 * JD-Core Version:    0.7.0.1
 */