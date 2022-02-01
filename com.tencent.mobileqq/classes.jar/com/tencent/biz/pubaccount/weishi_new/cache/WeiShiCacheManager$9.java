package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import uel;
import uep;
import ukh;

public class WeiShiCacheManager$9
  implements Runnable
{
  public WeiShiCacheManager$9(uep paramuep, uel paramuel) {}
  
  public void run()
  {
    if (!this.this$0.b()) {
      return;
    }
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = uep.a(this.this$0, 4);
    ukh.a().a(new WeiShiCacheManager.9.1(this, localstSimpleGetFeedListRsp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.9
 * JD-Core Version:    0.7.0.1
 */