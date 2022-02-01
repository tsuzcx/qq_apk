package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.List;
import ulf;
import uyo;

public class WeiShiCacheManager$8
  implements Runnable
{
  public WeiShiCacheManager$8(ulf paramulf, List paramList) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList(this.a);
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = new stSimpleGetFeedListRsp();
    localstSimpleGetFeedListRsp.feeds = localArrayList;
    if (ulf.a(this.this$0, localstSimpleGetFeedListRsp, ulf.c(this.this$0), this.a.size())) {
      LocalMultiProcConfig.putString("weishi_usergrowth", "key_ws_cache_v", uyo.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.8
 * JD-Core Version:    0.7.0.1
 */