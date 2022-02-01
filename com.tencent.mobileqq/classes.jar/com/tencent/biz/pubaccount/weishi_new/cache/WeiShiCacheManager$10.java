package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.List;
import uen;
import upe;
import ups;

public class WeiShiCacheManager$10
  implements Runnable
{
  public WeiShiCacheManager$10(uen paramuen, stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp, ArrayList paramArrayList, long paramLong, List paramList) {}
  
  public void run()
  {
    boolean bool = uen.a(this.this$0, this.jdField_a_of_type_UserGrowthStSimpleGetFeedListRsp, uen.d(this.this$0), this.jdField_a_of_type_JavaUtilArrayList.size());
    if (bool)
    {
      LocalMultiProcConfig.putLong("weishi_usergrowth", "key_red_msg_valid_timestamp", System.currentTimeMillis() + this.jdField_a_of_type_Long);
      LocalMultiProcConfig.putInt("weishi_usergrowth", "key_red_msg_valid_count", this.jdField_a_of_type_JavaUtilList.size());
      LocalMultiProcConfig.putString("weishi_usergrowth", "key_ws_cache_v", ups.c());
      ups.a(this.jdField_a_of_type_JavaUtilArrayList, true);
    }
    upe.d("WeiShiCacheManager", "cacheRedDotData isSuccess: " + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.10
 * JD-Core Version:    0.7.0.1
 */