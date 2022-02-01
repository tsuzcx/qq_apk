package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WSSharePreferencesUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.ArrayList;
import java.util.List;

class WeiShiCacheManager$12
  implements Runnable
{
  WeiShiCacheManager$12(WeiShiCacheManager paramWeiShiCacheManager, stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp, int paramInt, ArrayList paramArrayList, List paramList, long paramLong) {}
  
  public void run()
  {
    Object localObject = this.this$0;
    boolean bool = WeiShiCacheManager.a((WeiShiCacheManager)localObject, this.jdField_a_of_type_UserGrowthStSimpleGetFeedListRsp, WeiShiCacheManager.a((WeiShiCacheManager)localObject, this.jdField_a_of_type_Int), this.jdField_a_of_type_JavaUtilArrayList.size());
    if (bool)
    {
      localObject = ((stSimpleMetaFeed)this.jdField_a_of_type_JavaUtilList.get(0)).id;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WSRedDot preload feedId:");
      localStringBuilder.append((String)localObject);
      WSLog.a("WSFeedsPreloadStrategy", localStringBuilder.toString());
      long l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_Long;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_red_msg_valid_timestamp");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      WSSharePreferencesUtil.a(localStringBuilder.toString(), l1 + l2);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("key_red_msg_valid_feed_id");
      localStringBuilder.append(this.jdField_a_of_type_Int);
      WSSharePreferencesUtil.a(localStringBuilder.toString(), (String)localObject);
      WSSharePreferencesUtil.a("key_red_msg_valid_count", this.jdField_a_of_type_JavaUtilList.size());
      WSSharePreferencesUtil.a("key_ws_cache_v", WeishiUtils.c());
      WSPicLoader.a(this.jdField_a_of_type_JavaUtilArrayList, true);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("cacheRedDotData isSuccess: ");
    ((StringBuilder)localObject).append(bool);
    WSLog.d("WeiShiCacheManager", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.12
 * JD-Core Version:    0.7.0.1
 */