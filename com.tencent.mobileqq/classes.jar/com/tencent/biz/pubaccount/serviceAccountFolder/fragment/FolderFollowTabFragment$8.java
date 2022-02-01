package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StMessageStatus;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowFeedsRsp;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

class FolderFollowTabFragment$8
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetFollowFeedsRsp>
{
  FolderFollowTabFragment$8(FolderFollowTabFragment paramFolderFollowTabFragment) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFollowFeedsRsp paramStGetFollowFeedsRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetFollowFeedsRsp == null)) {}
    while (paramStGetFollowFeedsRsp.messStatus.get() == null) {
      return;
    }
    this.a.a(paramStGetFollowFeedsRsp.messStatus.noticeCount.get());
    FolderFollowTabFragment.a(this.a, paramStGetFollowFeedsRsp.messStatus.jumpURL.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment.8
 * JD-Core Version:    0.7.0.1
 */