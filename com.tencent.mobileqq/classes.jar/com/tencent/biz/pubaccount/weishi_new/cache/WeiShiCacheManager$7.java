package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import uzf;
import vfk;
import vmp;

public class WeiShiCacheManager$7
  implements Runnable
{
  public void run()
  {
    vmp.b("CacheResponseLog", "getCachedRecommendData startTime = " + System.currentTimeMillis() + ", thread = " + Thread.currentThread());
    if (!this.this$0.b()) {
      return;
    }
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = uzf.a(this.this$0, 1);
    vfk.a().a(new WeiShiCacheManager.7.1(this, localstSimpleGetFeedListRsp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.7
 * JD-Core Version:    0.7.0.1
 */