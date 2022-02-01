package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stFollowFeedsRsp;
import com.tencent.biz.pubaccount.weishi_new.util.WSSharePreferencesUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.ArrayList;
import java.util.List;

class WeiShiCacheManager$5
  implements Runnable
{
  WeiShiCacheManager$5(WeiShiCacheManager paramWeiShiCacheManager, List paramList) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.a.size() > WeiShiCacheManager.a(this.this$0))
    {
      int i = 0;
      while (i < WeiShiCacheManager.a(this.this$0))
      {
        localArrayList.add(this.a.get(i));
        i += 1;
      }
    }
    for (;;)
    {
      stFollowFeedsRsp localstFollowFeedsRsp = new stFollowFeedsRsp();
      localstFollowFeedsRsp.feeds = localArrayList;
      if (WeiShiCacheManager.a(this.this$0, localstFollowFeedsRsp, WeiShiCacheManager.a(this.this$0), localArrayList.size())) {
        WSSharePreferencesUtil.a("key_ws_cache_v", WeishiUtils.c());
      }
      return;
      localArrayList = new ArrayList(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.5
 * JD-Core Version:    0.7.0.1
 */