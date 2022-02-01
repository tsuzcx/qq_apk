package com.tencent.biz.pubaccount.readinjoy.popup;

import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.Ox978RespCallBack;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "isSuccess", "", "distUin", "", "kotlin.jvm.PlatformType", "dataResp", "", "handleResp"}, k=3, mv={1, 1, 16})
final class RIJFollowPackUtils$requestFollow$1
  implements UserOperationModule.Ox978RespCallBack
{
  RIJFollowPackUtils$requestFollow$1(RecommendFollowInfo paramRecommendFollowInfo, RIJFollowPackUtils.RIJFollowPackData paramRIJFollowPackData) {}
  
  public final void a(boolean paramBoolean, String paramString, int paramInt)
  {
    QLog.d(RIJFollowPackUtils.a.a(), 1, "requestFollow, isSuccess=" + paramBoolean + ", distUin=" + paramString + ", dataResp=" + paramInt);
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo.isFollowed = true;
      RIJFollowPackUtils.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPopupRIJFollowPackUtils$RIJFollowPackData);
      return;
    }
    QQToast.a((Context)BaseApplicationImpl.getContext(), 1, 2131718305, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.popup.RIJFollowPackUtils.requestFollow.1
 * JD-Core Version:    0.7.0.1
 */