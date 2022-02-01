package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stGetTabsRsp;
import com.tencent.biz.pubaccount.weishi_new.util.WSFileUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSSharePreferencesUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;

class WeiShiCacheManager$13
  implements Runnable
{
  WeiShiCacheManager$13(WeiShiCacheManager paramWeiShiCacheManager, stGetTabsRsp paramstGetTabsRsp) {}
  
  public void run()
  {
    if (WSFileUtils.a(this.a, WeiShiCacheManager.d(this.this$0))) {
      WSSharePreferencesUtil.a("key_ws_cache_v", WeishiUtils.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.13
 * JD-Core Version:    0.7.0.1
 */