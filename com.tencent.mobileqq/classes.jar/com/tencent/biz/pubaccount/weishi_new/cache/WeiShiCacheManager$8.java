package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stSimpleGetFeedListRsp;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.List;
import uzf;
import vnd;

public class WeiShiCacheManager$8
  implements Runnable
{
  public WeiShiCacheManager$8(uzf paramuzf, List paramList) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList(this.a);
    stSimpleGetFeedListRsp localstSimpleGetFeedListRsp = new stSimpleGetFeedListRsp();
    localstSimpleGetFeedListRsp.feeds = localArrayList;
    if (uzf.a(this.this$0, localstSimpleGetFeedListRsp, uzf.c(this.this$0), this.a.size())) {
      LocalMultiProcConfig.putString("weishi_usergrowth", "key_ws_cache_v", vnd.c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.8
 * JD-Core Version:    0.7.0.1
 */