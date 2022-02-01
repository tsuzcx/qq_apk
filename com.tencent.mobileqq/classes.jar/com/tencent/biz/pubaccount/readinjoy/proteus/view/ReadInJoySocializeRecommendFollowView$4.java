package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.Ox978RespCallBack;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class ReadInJoySocializeRecommendFollowView$4
  implements UserOperationModule.Ox978RespCallBack
{
  ReadInJoySocializeRecommendFollowView$4(ReadInJoySocializeRecommendFollowView paramReadInJoySocializeRecommendFollowView, RecommendFollowInfo paramRecommendFollowInfo) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, "followPubAccount() onFollowPublicAccount uin=" + paramString + ", isSuccess=" + paramBoolean);
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo.isFollowed = true;
      ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoySocializeRecommendFollowView, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo);
      ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoySocializeRecommendFollowView).notifyDataSetChanged();
      return;
    }
    QQToast.a(ReadInJoySocializeRecommendFollowView.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoySocializeRecommendFollowView).getContext(), 1, 2131718305, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.4
 * JD-Core Version:    0.7.0.1
 */