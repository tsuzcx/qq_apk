package com.tencent.biz.subscribe.bizdapters;

import NS_CERTIFIED_ACCOUNT_READ.CertifiedAccountRead.StGetFollowRcmdRsp;
import android.text.TextUtils;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;

class BlankRecommendFeedsAdapter$1
  implements VSDispatchObserver.onVSRspCallBack<CertifiedAccountRead.StGetFollowRcmdRsp>
{
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, CertifiedAccountRead.StGetFollowRcmdRsp paramStGetFollowRcmdRsp)
  {
    boolean bool = VSNetworkHelper.isProtocolCache(paramString);
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetFollowRcmdRsp != null))
    {
      paramBaseRequest = paramStGetFollowRcmdRsp.rcmdList.get();
      if ((!bool) || (BlankRecommendFeedsAdapter.c(this.b)))
      {
        if ((paramBaseRequest != null) && (paramBaseRequest.size() > 0))
        {
          if (BlankRecommendFeedsAdapter.c(this.b)) {
            BlankRecommendFeedsAdapter.a(this.b, false);
          }
          BlankRecommendFeedsAdapter.a(this.b, paramBaseRequest, paramStGetFollowRcmdRsp.extInfo, true);
          VSReporter.b("auth_follow", "blank_exp", 0, 0, new String[0]);
          return;
        }
        if ((!bool) && (this.b.getItemCount() == 0))
        {
          BlankRecommendFeedsAdapter.b(this.b, true);
          this.b.notifyDataSetChanged();
        }
      }
      return;
    }
    if ((!TextUtils.isEmpty(paramString)) && (BlankRecommendFeedsAdapter.a(this.b) != null)) {
      QQToast.makeText(BlankRecommendFeedsAdapter.b(this.b), 1, paramString, 0).show();
    }
    if (!bool)
    {
      BaseRequest.reMoveCache(paramBaseRequest);
      if (this.b.getItemCount() == 0)
      {
        paramBaseRequest = this.a;
        if (paramBaseRequest != null) {
          paramBaseRequest.a();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.BlankRecommendFeedsAdapter.1
 * JD-Core Version:    0.7.0.1
 */