package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stFollowFeedsRsp;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.List;
import tcq;
import tlv;

public class WeiShiCacheManager$4
  implements Runnable
{
  public WeiShiCacheManager$4(tcq paramtcq, List paramList) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.a.size() > tcq.a(this.this$0))
    {
      int i = 0;
      while (i < tcq.a(this.this$0))
      {
        localArrayList.add(this.a.get(i));
        i += 1;
      }
    }
    for (;;)
    {
      stFollowFeedsRsp localstFollowFeedsRsp = new stFollowFeedsRsp();
      localstFollowFeedsRsp.feeds = localArrayList;
      if (tcq.a(this.this$0, localstFollowFeedsRsp, tcq.a(this.this$0), localArrayList.size())) {
        LocalMultiProcConfig.putString("weishi_usergrowth", "key_ws_cache_v", tlv.c());
      }
      return;
      localArrayList = new ArrayList(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.4
 * JD-Core Version:    0.7.0.1
 */