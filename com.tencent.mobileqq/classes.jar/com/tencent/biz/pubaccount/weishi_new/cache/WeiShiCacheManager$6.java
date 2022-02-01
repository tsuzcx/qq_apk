package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stFollowFeedsRsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.util.WSSharePreferencesUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.ArrayList;
import java.util.List;

class WeiShiCacheManager$6
  implements Runnable
{
  WeiShiCacheManager$6(WeiShiCacheManager paramWeiShiCacheManager, List paramList) {}
  
  public void run()
  {
    Object localObject2 = new ArrayList();
    if (this.a.size() > WeiShiCacheManager.a(this.this$0))
    {
      int i = 0;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= WeiShiCacheManager.a(this.this$0)) {
          break;
        }
        ((ArrayList)localObject2).add(this.a.get(i));
        i += 1;
      }
    }
    Object localObject1 = new ArrayList(this.a);
    localObject2 = new stFollowFeedsRsp();
    ((stFollowFeedsRsp)localObject2).feeds = ((ArrayList)localObject1);
    WeiShiCacheManager localWeiShiCacheManager = this.this$0;
    if (WeiShiCacheManager.a(localWeiShiCacheManager, (JceStruct)localObject2, WeiShiCacheManager.a(localWeiShiCacheManager), ((ArrayList)localObject1).size())) {
      WSSharePreferencesUtil.a("key_ws_cache_v", WeishiUtils.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.6
 * JD-Core Version:    0.7.0.1
 */