package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stGetTabsRsp;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;

class WeiShiCacheManager$14$1
  implements Runnable
{
  WeiShiCacheManager$14$1(WeiShiCacheManager.14 param14, stGetTabsRsp paramstGetTabsRsp) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCacheWeiShiCacheManager$14.a != null)
    {
      WSLog.b("CacheResponseLog", "getCacheDataForTabsInfo endTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
      this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCacheWeiShiCacheManager$14.a.a(this.jdField_a_of_type_UserGrowthStGetTabsRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.14.1
 * JD-Core Version:    0.7.0.1
 */