package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.util.WSSharePreferencesUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.ArrayList;

class WeiShiCacheManager$8
  implements Runnable
{
  WeiShiCacheManager$8(WeiShiCacheManager paramWeiShiCacheManager, ArrayList paramArrayList, int paramInt) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.a.size() >= WeiShiCacheManager.e(this.this$0))
    {
      int i = this.a.size();
      if (this.a.size() - this.b > WeiShiCacheManager.e(this.this$0)) {
        i = this.a.size() - this.b;
      } else if (this.a.size() - this.b > 0) {
        i = WeiShiCacheManager.e(this.this$0);
      }
      int j = i - WeiShiCacheManager.e(this.this$0);
      while (j < i)
      {
        localArrayList.add(this.a.get(j));
        j += 1;
      }
    }
    localArrayList.addAll(this.a);
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = new stSimpleGetFeedListRsp();
    localstSimpleGetFeedListRsp.feeds = localArrayList;
    WeiShiCacheManager localWeiShiCacheManager = this.this$0;
    if (WeiShiCacheManager.a(localWeiShiCacheManager, localstSimpleGetFeedListRsp, WeiShiCacheManager.d(localWeiShiCacheManager), localArrayList.size())) {
      WSSharePreferencesUtil.a("key_ws_cache_v", WeishiUtils.l());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.8
 * JD-Core Version:    0.7.0.1
 */