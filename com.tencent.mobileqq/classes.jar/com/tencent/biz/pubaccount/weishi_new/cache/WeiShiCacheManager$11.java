package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WSSharePreferencesUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.ArrayList;
import java.util.List;

class WeiShiCacheManager$11
  implements Runnable
{
  WeiShiCacheManager$11(WeiShiCacheManager paramWeiShiCacheManager, stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp, int paramInt, ArrayList paramArrayList, List paramList, long paramLong) {}
  
  public void run()
  {
    boolean bool = WeiShiCacheManager.a(this.this$0, this.jdField_a_of_type_UserGrowthStSimpleGetFeedListRsp, WeiShiCacheManager.a(this.this$0, this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaUtilArrayList.size());
    if (bool)
    {
      String str = ((stSimpleMetaFeed)this.jdField_a_of_type_JavaUtilList.get(0)).id;
      WSLog.a("WSFeedsPreloadStrategy", "WSRedDot preload feedId:" + str);
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      WSSharePreferencesUtil.a("key_red_msg_valid_timestamp" + this.jdField_a_of_type_Int, l1 + l2);
      WSSharePreferencesUtil.a("key_red_msg_valid_feed_id" + this.jdField_a_of_type_Int, str);
      WSSharePreferencesUtil.a("key_red_msg_valid_count", this.jdField_a_of_type_JavaUtilList.size());
      WSSharePreferencesUtil.a("key_ws_cache_v", WeishiUtils.c());
      WeishiUtils.a(this.jdField_a_of_type_JavaUtilArrayList, true);
    }
    WSLog.d("WeiShiCacheManager", "cacheRedDotData isSuccess: " + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.11
 * JD-Core Version:    0.7.0.1
 */