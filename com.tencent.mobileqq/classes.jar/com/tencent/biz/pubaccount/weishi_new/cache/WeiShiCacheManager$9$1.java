package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import uel;
import uqf;

class WeiShiCacheManager$9$1
  implements Runnable
{
  WeiShiCacheManager$9$1(WeiShiCacheManager.9 param9, stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCacheWeiShiCacheManager$9.a != null)
    {
      uqf.b("CacheResponseLog", "getRecommendVerticalData endTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCacheWeiShiCacheManager$9.a.a(this.jdField_a_of_type_UserGrowthStSimpleGetFeedListRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.9.1
 * JD-Core Version:    0.7.0.1
 */