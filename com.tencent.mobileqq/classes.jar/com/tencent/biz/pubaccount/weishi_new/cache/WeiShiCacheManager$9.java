package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.util.WSSharePreferencesUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.ArrayList;
import java.util.List;

class WeiShiCacheManager$9
  implements Runnable
{
  WeiShiCacheManager$9(WeiShiCacheManager paramWeiShiCacheManager, List paramList) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList(this.a);
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = new stSimpleGetFeedListRsp();
    localstSimpleGetFeedListRsp.feeds = localArrayList;
    if (WeiShiCacheManager.a(this.this$0, localstSimpleGetFeedListRsp, WeiShiCacheManager.c(this.this$0), this.a.size())) {
      WSSharePreferencesUtil.a("key_ws_cache_v", WeishiUtils.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.9
 * JD-Core Version:    0.7.0.1
 */