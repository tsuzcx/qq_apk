package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StMessageStatus;
import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowFeedsRsp;
import android.text.TextUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQToast;

class FolderFollowTabFragment$7
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetFollowFeedsRsp>
{
  FolderFollowTabFragment$7(FolderFollowTabFragment paramFolderFollowTabFragment) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFollowFeedsRsp paramStGetFollowFeedsRsp)
  {
    boolean bool = VSNetworkHelper.isProtocolCache(paramString);
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetFollowFeedsRsp != null))
    {
      if ((FolderFollowTabFragment.a(this.a) != null) && (!bool) && (paramStGetFollowFeedsRsp.messStatus.get() != null))
      {
        FolderFollowTabFragment.a(this.a).a(paramStGetFollowFeedsRsp.messStatus.noticeCount.get());
        FolderFollowTabFragment.a(this.a).setJumpWebMessageListUrl(paramStGetFollowFeedsRsp.messStatus.jumpURL.get());
      }
      return;
    }
    if (!TextUtils.isEmpty(paramString)) {
      QQToast.a(FolderFollowTabFragment.a(this.a), 1, paramString, 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderFollowTabFragment.7
 * JD-Core Version:    0.7.0.1
 */