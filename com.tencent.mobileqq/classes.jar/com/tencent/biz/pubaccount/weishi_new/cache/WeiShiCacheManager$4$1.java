package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import sjr;
import snb;

class WeiShiCacheManager$4$1
  implements Runnable
{
  WeiShiCacheManager$4$1(WeiShiCacheManager.4 param4, stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCacheWeiShiCacheManager$4.a != null)
    {
      snb.b("CacheResponseLog", "getCachedRecommendData endTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCacheWeiShiCacheManager$4.a.a(this.jdField_a_of_type_UserGrowthStSimpleGetFeedListRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.4.1
 * JD-Core Version:    0.7.0.1
 */