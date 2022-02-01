package com.tencent.biz.pubaccount.weishi_new.cache;

import com.tencent.mobileqq.utils.FileUtils;
import cooperation.qzone.LocalMultiProcConfig;
import uzf;

public class WeiShiCacheManager$11
  implements Runnable
{
  public WeiShiCacheManager$11(uzf paramuzf) {}
  
  public void run()
  {
    LocalMultiProcConfig.putLong("weishi_usergrowth", "key_red_msg_valid_timestamp", System.currentTimeMillis());
    LocalMultiProcConfig.putInt("weishi_usergrowth", "key_red_msg_valid_count", 0);
    FileUtils.delete(uzf.d(this.this$0), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.11
 * JD-Core Version:    0.7.0.1
 */