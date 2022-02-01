package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StUser;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.SubscribePersonalDetailRequest;
import com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter;
import com.tencent.biz.subscribe.part.block.MultiViewBlock.onLoadDataDelegate;
import com.tencent.biz.subscribe.part.block.base.LoadInfo;
import com.tencent.mobileqq.pb.PBStringField;

class SubscribePersonalBottomOpusFragment$2
  implements MultiViewBlock.onLoadDataDelegate<RelativeFeedsAdapter>
{
  SubscribePersonalBottomOpusFragment$2(SubscribePersonalBottomOpusFragment paramSubscribePersonalBottomOpusFragment) {}
  
  public void a(LoadInfo paramLoadInfo, RelativeFeedsAdapter paramRelativeFeedsAdapter)
  {
    if ((paramLoadInfo.e()) && (this.a.a != null) && (this.a.a.a != null))
    {
      paramLoadInfo = new SubscribePersonalDetailRequest(this.a.a.a.poster.id.get(), paramLoadInfo.b());
      VSNetworkHelper.getInstance().sendRequest(paramLoadInfo, new SubscribePersonalBottomOpusFragment.2.1(this, paramRelativeFeedsAdapter));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment.2
 * JD-Core Version:    0.7.0.1
 */