package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import ozx;
import ozz;
import pah;
import pqe;
import pqo;

public class ReadInJoySocializeRecommendFollowView$10$1
  implements Runnable
{
  public ReadInJoySocializeRecommendFollowView$10$1(ozz paramozz, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, "onUpdateAfterAccountFollow uin = " + this.jdField_a_of_type_Long + " isFollow = " + this.jdField_a_of_type_Boolean);
    }
    if ((ozx.a(this.jdField_a_of_type_Ozz.a) != null) && (this.jdField_a_of_type_Long == ozx.a(this.jdField_a_of_type_Ozz.a).mSocialFeedInfo.a.jdField_a_of_type_Long) && (!this.jdField_a_of_type_Boolean) && (ozx.a(this.jdField_a_of_type_Ozz.a).isShowRecommendList))
    {
      ozx.a(this.jdField_a_of_type_Ozz.a, false);
      ozx.a(this.jdField_a_of_type_Ozz.a).isShowRecommendList = false;
    }
    if ((ozx.a(this.jdField_a_of_type_Ozz.a) != null) && (ozx.a(this.jdField_a_of_type_Ozz.a).mRecommendFollowInfos != null) && (ozx.a(this.jdField_a_of_type_Ozz.a).mRecommendFollowInfos.a != null))
    {
      Iterator localIterator = ozx.a(this.jdField_a_of_type_Ozz.a).mRecommendFollowInfos.a.iterator();
      while (localIterator.hasNext())
      {
        RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)localIterator.next();
        if (this.jdField_a_of_type_Long == localRecommendFollowInfo.uin)
        {
          localRecommendFollowInfo.isFollowed = this.jdField_a_of_type_Boolean;
          ozx.a(this.jdField_a_of_type_Ozz.a, localRecommendFollowInfo);
        }
      }
      ozx.a(this.jdField_a_of_type_Ozz.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.10.1
 * JD-Core Version:    0.7.0.1
 */