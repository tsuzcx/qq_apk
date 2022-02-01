package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import uyy;
import uzf;
import vfk;

public class WeiShiCacheManager$9
  implements Runnable
{
  public WeiShiCacheManager$9(uzf paramuzf, uyy paramuyy) {}
  
  public void run()
  {
    if (!this.this$0.b()) {
      return;
    }
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = uzf.a(this.this$0, 4);
    vfk.a().a(new WeiShiCacheManager.9.1(this, localstSimpleGetFeedListRsp));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.9
 * JD-Core Version:    0.7.0.1
 */