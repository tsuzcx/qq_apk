package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;
import plp;
import plr;
import qcl;

public class ReadInJoySocializeRecommendFollowView$10$2
  implements Runnable
{
  public ReadInJoySocializeRecommendFollowView$10$2(plr paramplr, ArticleInfo paramArticleInfo, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, "onUpdateAfterAccountFollow articleInfo = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo + " isFollow = " + this.jdField_a_of_type_Boolean);
    }
    long l = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mSocialFeedInfo.a.a;
    if ((plp.a(this.jdField_a_of_type_Plr.a) == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo) && (this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID == 70L)) {
      plp.a(this.jdField_a_of_type_Plr.a, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.10.2
 * JD-Core Version:    0.7.0.1
 */