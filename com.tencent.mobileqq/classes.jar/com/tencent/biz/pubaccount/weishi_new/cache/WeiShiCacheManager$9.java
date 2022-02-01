package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import uej;
import uen;
import ujn;

public class WeiShiCacheManager$9
  implements Runnable
{
  public WeiShiCacheManager$9(uen paramuen, uej paramuej) {}
  
  public void run()
  {
    if (!this.this$0.b()) {
      return;
    }
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = uen.a(this.this$0, 4);
    ujn.a().a(new WeiShiCacheManager.9.1(this, localstSimpleGetFeedListRsp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.9
 * JD-Core Version:    0.7.0.1
 */