package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import ulb;
import ulf;
import urc;

public class WeiShiCacheManager$9
  implements Runnable
{
  public WeiShiCacheManager$9(ulf paramulf, ulb paramulb) {}
  
  public void run()
  {
    if (!this.this$0.b()) {
      return;
    }
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = ulf.a(this.this$0, 4);
    urc.a().a(new WeiShiCacheManager.9.1(this, localstSimpleGetFeedListRsp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.9
 * JD-Core Version:    0.7.0.1
 */