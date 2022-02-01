package com.tencent.biz.pubaccount.weishi_new;

import UserGrowth.stFollowFeedsRsp;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.pubaccount.weishi_new.cache.IWeiShiCacheCallback;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import java.util.ArrayList;

class WSFollowFragment$1
  implements IWeiShiCacheCallback
{
  WSFollowFragment$1(WSFollowFragment paramWSFollowFragment) {}
  
  public void a(JceStruct paramJceStruct)
  {
    if (!(paramJceStruct instanceof stFollowFeedsRsp)) {}
    do
    {
      return;
      paramJceStruct = (stFollowFeedsRsp)paramJceStruct;
    } while (WSFeedUtils.a(paramJceStruct.feeds));
    WSLog.b("WSFollowFragment", "load cache data for follow page, size: " + paramJceStruct.feeds.size());
    this.a.a(paramJceStruct.feeds);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFollowFragment.1
 * JD-Core Version:    0.7.0.1
 */