package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stFollowFeedsRsp;
import mqq.util.WeakReference;
import uyy;
import vmp;

class WeiShiCacheManager$2$1
  implements Runnable
{
  WeiShiCacheManager$2$1(WeiShiCacheManager.2 param2, stFollowFeedsRsp paramstFollowFeedsRsp) {}
  
  public void run()
  {
    uyy localuyy = (uyy)this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newCacheWeiShiCacheManager$2.a.get();
    if (localuyy != null)
    {
      vmp.b("CacheResponseLog", "getCacheDataForFollow endTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
      localuyy.a(this.jdField_a_of_type_UserGrowthStFollowFeedsRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.2.1
 * JD-Core Version:    0.7.0.1
 */