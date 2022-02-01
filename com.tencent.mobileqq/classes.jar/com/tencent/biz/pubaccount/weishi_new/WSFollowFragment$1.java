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
    if (!(paramJceStruct instanceof stFollowFeedsRsp)) {
      return;
    }
    paramJceStruct = (stFollowFeedsRsp)paramJceStruct;
    if (WSFeedUtils.a(paramJceStruct.feeds)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("load cache data for follow page, size: ");
    localStringBuilder.append(paramJceStruct.feeds.size());
    WSLog.b("WSFollowFragment", localStringBuilder.toString());
    this.a.a(paramJceStruct.feeds);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSFollowFragment.1
 * JD-Core Version:    0.7.0.1
 */