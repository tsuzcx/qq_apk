package com.tencent.biz.pubaccount.weishi_new.cache;

import bgmg;
import cooperation.qzone.LocalMultiProcConfig;
import uen;

public class WeiShiCacheManager$11
  implements Runnable
{
  public WeiShiCacheManager$11(uen paramuen) {}
  
  public void run()
  {
    LocalMultiProcConfig.putLong("weishi_usergrowth", "key_red_msg_valid_timestamp", System.currentTimeMillis());
    LocalMultiProcConfig.putInt("weishi_usergrowth", "key_red_msg_valid_count", 0);
    bgmg.a(uen.d(this.this$0), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.11
 * JD-Core Version:    0.7.0.1
 */