package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.List;
import uep;
import uqt;

public class WeiShiCacheManager$8
  implements Runnable
{
  public WeiShiCacheManager$8(uep paramuep, List paramList) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList(this.a);
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = new stSimpleGetFeedListRsp();
    localstSimpleGetFeedListRsp.feeds = localArrayList;
    if (uep.a(this.this$0, localstSimpleGetFeedListRsp, uep.c(this.this$0), this.a.size())) {
      LocalMultiProcConfig.putString("weishi_usergrowth", "key_ws_cache_v", uqt.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.8
 * JD-Core Version:    0.7.0.1
 */