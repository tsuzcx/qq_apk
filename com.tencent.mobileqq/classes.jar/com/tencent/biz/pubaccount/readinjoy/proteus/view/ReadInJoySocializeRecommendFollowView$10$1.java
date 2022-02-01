package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfos;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class ReadInJoySocializeRecommendFollowView$10$1
  implements Runnable
{
  ReadInJoySocializeRecommendFollowView$10$1(ReadInJoySocializeRecommendFollowView.10 param10, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, "onUpdateAfterAccountFollow uin = " + this.jdField_a_of_type_Long + " isFollow = " + this.jdField_a_of_type_Boolean);
    }
    if ((ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoySocializeRecommendFollowView$10.a) != null) && (this.jdField_a_of_type_Long == ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoySocializeRecommendFollowView$10.a).mSocialFeedInfo.a.jdField_a_of_type_Long) && (!this.jdField_a_of_type_Boolean) && (ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoySocializeRecommendFollowView$10.a).isShowRecommendList))
    {
      ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoySocializeRecommendFollowView$10.a, false);
      ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoySocializeRecommendFollowView$10.a).isShowRecommendList = false;
    }
    if ((ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoySocializeRecommendFollowView$10.a) != null) && (ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoySocializeRecommendFollowView$10.a).mRecommendFollowInfos != null) && (ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoySocializeRecommendFollowView$10.a).mRecommendFollowInfos.a != null))
    {
      Iterator localIterator = ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoySocializeRecommendFollowView$10.a).mRecommendFollowInfos.a.iterator();
      while (localIterator.hasNext())
      {
        RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)localIterator.next();
        if (this.jdField_a_of_type_Long == localRecommendFollowInfo.uin)
        {
          localRecommendFollowInfo.isFollowed = this.jdField_a_of_type_Boolean;
          ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoySocializeRecommendFollowView$10.a, localRecommendFollowInfo);
        }
      }
      ReadInJoySocializeRecommendFollowView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewReadInJoySocializeRecommendFollowView$10.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.10.1
 * JD-Core Version:    0.7.0.1
 */