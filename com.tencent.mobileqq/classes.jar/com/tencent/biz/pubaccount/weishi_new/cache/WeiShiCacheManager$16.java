package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stGetFollowedDramasRsp;
import com.tencent.biz.pubaccount.weishi_new.util.WSFileUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSSharePreferencesUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;

class WeiShiCacheManager$16
  implements Runnable
{
  WeiShiCacheManager$16(WeiShiCacheManager paramWeiShiCacheManager, stGetFollowedDramasRsp paramstGetFollowedDramasRsp) {}
  
  public void run()
  {
    if (WSFileUtils.a(this.a, WeiShiCacheManager.e(this.this$0))) {
      WSSharePreferencesUtil.a("key_ws_cache_v", WeishiUtils.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.16
 * JD-Core Version:    0.7.0.1
 */