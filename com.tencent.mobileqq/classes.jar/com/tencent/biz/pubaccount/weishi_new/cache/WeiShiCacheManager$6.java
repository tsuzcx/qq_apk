package com.tencent.biz.pubaccount.weishi_new.cache;

import bbdx;
import cooperation.qzone.LocalMultiProcConfig;
import sjv;

public class WeiShiCacheManager$6
  implements Runnable
{
  public WeiShiCacheManager$6(sjv paramsjv) {}
  
  public void run()
  {
    LocalMultiProcConfig.putLong("weishi_usergrowth", "key_red_msg_valid_timestamp", System.currentTimeMillis());
    LocalMultiProcConfig.putInt("weishi_usergrowth", "key_red_msg_valid_count", 0);
    bbdx.a(sjv.b(this.this$0), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.6
 * JD-Core Version:    0.7.0.1
 */