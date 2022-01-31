package com.tencent.biz.pubaccount.weishi_new.cache;

import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.List;
import rxc;
import sai;
import sam;

public class WeiShiCacheManager$5
  implements Runnable
{
  public WeiShiCacheManager$5(rxc paramrxc, ArrayList paramArrayList, long paramLong, List paramList) {}
  
  public void run()
  {
    boolean bool = rxc.a(this.this$0, this.jdField_a_of_type_JavaUtilArrayList, rxc.b(this.this$0));
    if (bool)
    {
      LocalMultiProcConfig.putLong("weishi_usergrowth", "key_red_msg_valid_timestamp", System.currentTimeMillis() + this.jdField_a_of_type_Long);
      LocalMultiProcConfig.putInt("weishi_usergrowth", "key_red_msg_valid_count", this.jdField_a_of_type_JavaUtilList.size());
      LocalMultiProcConfig.putString("weishi_usergrowth", "key_ws_cache_v", sam.b());
      sam.a(this.jdField_a_of_type_JavaUtilArrayList);
    }
    sai.d("WeiShiCacheManager", "cacheRedDotData isSuccess: " + bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.5
 * JD-Core Version:    0.7.0.1
 */