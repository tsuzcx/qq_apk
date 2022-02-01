package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiBusinessLooper;

class WeiShiCacheManager$10
  implements Runnable
{
  WeiShiCacheManager$10(WeiShiCacheManager paramWeiShiCacheManager, IWeiShiCacheCallback paramIWeiShiCacheCallback) {}
  
  public void run()
  {
    if (!this.this$0.a()) {
      return;
    }
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = WeiShiCacheManager.a(this.this$0, 4);
    WeishiBusinessLooper.a().a(new WeiShiCacheManager.10.1(this, localstSimpleGetFeedListRsp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.10
 * JD-Core Version:    0.7.0.1
 */