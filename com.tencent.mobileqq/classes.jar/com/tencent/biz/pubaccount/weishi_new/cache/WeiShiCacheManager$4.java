package com.tencent.biz.pubaccount.weishi_new.cache;

import UserGrowth.stFollowFeedsRsp;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.List;
import uep;
import uqt;

public class WeiShiCacheManager$4
  implements Runnable
{
  public WeiShiCacheManager$4(uep paramuep, List paramList) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.a.size() > uep.a(this.this$0))
    {
      int i = 0;
      while (i < uep.a(this.this$0))
      {
        localArrayList.add(this.a.get(i));
        i += 1;
      }
    }
    for (;;)
    {
      stFollowFeedsRsp localstFollowFeedsRsp = new stFollowFeedsRsp();
      localstFollowFeedsRsp.feeds = localArrayList;
      if (uep.a(this.this$0, localstFollowFeedsRsp, uep.a(this.this$0), localArrayList.size())) {
        LocalMultiProcConfig.putString("weishi_usergrowth", "key_ws_cache_v", uqt.c());
      }
      return;
      localArrayList = new ArrayList(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.cache.WeiShiCacheManager.4
 * JD-Core Version:    0.7.0.1
 */