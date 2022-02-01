package com.tencent.biz.pubaccount.weishi_new.cache;

import com.tencent.biz.pubaccount.weishi_new.util.WSSharePreferencesUtil;
import com.tencent.mobileqq.utils.FileUtils;

class WeiShiCacheManager$12
  implements Runnable
{
  WeiShiCacheManager$12(WeiShiCacheManager paramWeiShiCacheManager, int paramInt) {}
  
  public void run()
  {
    WSSharePreferencesUtil.a("key_red_msg_valid_timestamp" + this.a, System.currentTimeMillis());
    WSSharePreferencesUtil.a("key_red_msg_valid_feed_id" + this.a, "");
    WSSharePreferencesUtil.a("key_red_msg_valid_count", 0);
    FileUtils.a(WeiShiCacheManager.a(this.this$0, this.a), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.12
 * JD-Core Version:    0.7.0.1
 */