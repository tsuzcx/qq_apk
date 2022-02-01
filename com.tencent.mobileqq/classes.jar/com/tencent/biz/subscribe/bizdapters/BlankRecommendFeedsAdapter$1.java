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
    if ((!paramBoolean) || (paramLong != 0L) || (paramStGetFollowRcmdRsp == null))
    {
      if ((!TextUtils.isEmpty(paramString)) && (BlankRecommendFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersBlankRecommendFeedsAdapter) != null)) {
        QQToast.a(BlankRecommendFeedsAdapter.b(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersBlankRecommendFeedsAdapter), 1, paramString, 0).a();
      }
      if (!bool)
      {
        BaseRequest.reMoveCache(paramBaseRequest);
        if ((this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersBlankRecommendFeedsAdapter.getItemCount() == 0) && (this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersBlankRecommendFeedsAdapter$IGetFollowRspListener != null)) {
          this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersBlankRecommendFeedsAdapter$IGetFollowRspListener.a();
        }
      }
    }
    do
    {
      do
      {
        return;
        paramBaseRequest = paramStGetFollowRcmdRsp.rcmdList.get();
      } while ((bool) && (!BlankRecommendFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersBlankRecommendFeedsAdapter)));
      if ((paramBaseRequest != null) && (paramBaseRequest.size() > 0))
      {
        if (BlankRecommendFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersBlankRecommendFeedsAdapter)) {
          BlankRecommendFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersBlankRecommendFeedsAdapter, false);
        }
        BlankRecommendFeedsAdapter.a(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersBlankRecommendFeedsAdapter, paramBaseRequest, paramStGetFollowRcmdRsp.extInfo, true);
        VSReporter.b("auth_follow", "blank_exp", 0, 0, new String[0]);
        return;
      }
    } while ((bool) || (this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersBlankRecommendFeedsAdapter.getItemCount() != 0));
    BlankRecommendFeedsAdapter.b(this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersBlankRecommendFeedsAdapter, true);
    this.jdField_a_of_type_ComTencentBizSubscribeBizdaptersBlankRecommendFeedsAdapter.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.BlankRecommendFeedsAdapter.1
 * JD-Core Version:    0.7.0.1
 */