package com.tencent.biz.subscribe.fragments;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetMainPageRsp;
import NS_COMM.COMM.StCommonExt;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.subscribe.bizdapters.RelativeFeedsAdapter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

class SubscribePersonalBottomOpusFragment$2$1
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetMainPageRsp>
{
  SubscribePersonalBottomOpusFragment$2$1(SubscribePersonalBottomOpusFragment.2 param2, RelativeFeedsAdapter paramRelativeFeedsAdapter) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetMainPageRsp paramStGetMainPageRsp)
  {
    if ((paramBoolean) && (paramStGetMainPageRsp != null))
    {
      paramBaseRequest = this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersRelativeFeedsAdapter;
      paramString = paramStGetMainPageRsp.vecFeed.get();
      COMM.StCommonExt localStCommonExt = paramStGetMainPageRsp.extInfo;
      int i = paramStGetMainPageRsp.isFinish.get();
      paramBoolean = true;
      if (i != 1) {
        paramBoolean = false;
      }
      paramBaseRequest.b(paramString, localStCommonExt, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.fragments.SubscribePersonalBottomOpusFragment.2.1
 * JD-Core Version:    0.7.0.1
 */