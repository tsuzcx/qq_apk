package com.tencent.biz.pubaccount.weishi_new.cache;

import bace;
import cooperation.qzone.LocalMultiProcConfig;
import rxc;

public class WeiShiCacheManager$6
  implements Runnable
{
  public WeiShiCacheManager$6(rxc paramrxc) {}
  
  public void run()
  {
    LocalMultiProcConfig.putLong("weishi_usergrowth", "key_red_msg_valid_timestamp", System.currentTimeMillis());
    LocalMultiProcConfig.putInt("weishi_usergrowth", "key_red_msg_valid_count", 0);
    bace.a(rxc.b(this.this$0), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.6
 * JD-Core Version:    0.7.0.1
 */