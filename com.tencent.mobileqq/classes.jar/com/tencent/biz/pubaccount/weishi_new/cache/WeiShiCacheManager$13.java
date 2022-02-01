package com.tencent.biz.pubaccount.weishi_new.cache;

import com.tencent.biz.pubaccount.weishi_new.util.WSSharePreferencesUtil;
import com.tencent.mobileqq.utils.FileUtils;

class WeiShiCacheManager$13
  implements Runnable
{
  WeiShiCacheManager$13(WeiShiCacheManager paramWeiShiCacheManager, int paramInt) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_red_msg_valid_timestamp");
    localStringBuilder.append(this.a);
    WSSharePreferencesUtil.a(localStringBuilder.toString(), System.currentTimeMillis());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_red_msg_valid_feed_id");
    localStringBuilder.append(this.a);
    WSSharePreferencesUtil.a(localStringBuilder.toString(), "");
    WSSharePreferencesUtil.a("key_red_msg_valid_count", 0);
    FileUtils.delete(WeiShiCacheManager.a(this.this$0, this.a), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.13
 * JD-Core Version:    0.7.0.1
 */