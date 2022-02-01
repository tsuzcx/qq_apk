package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.util.WSSharePreferencesUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.ArrayList;
import java.util.List;

class WeiShiCacheManager$10
  implements Runnable
{
  WeiShiCacheManager$10(WeiShiCacheManager paramWeiShiCacheManager, List paramList) {}
  
  public void run()
  {
    Object localObject = new ArrayList(this.a);
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = new stSimpleGetFeedListRsp();
    localstSimpleGetFeedListRsp.feeds = ((ArrayList)localObject);
    localObject = this.this$0;
    if (WeiShiCacheManager.a((WeiShiCacheManager)localObject, localstSimpleGetFeedListRsp, WeiShiCacheManager.c((WeiShiCacheManager)localObject), this.a.size())) {
      WSSharePreferencesUtil.a("key_ws_cache_v", WeishiUtils.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.10
 * JD-Core Version:    0.7.0.1
 */