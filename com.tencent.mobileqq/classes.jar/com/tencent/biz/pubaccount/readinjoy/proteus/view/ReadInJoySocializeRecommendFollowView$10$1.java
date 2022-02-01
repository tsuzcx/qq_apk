package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import quh;
import quj;
import qur;
import rqd;
import rqy;

public class ReadInJoySocializeRecommendFollowView$10$1
  implements Runnable
{
  public ReadInJoySocializeRecommendFollowView$10$1(quj paramquj, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, "onUpdateAfterAccountFollow uin = " + this.jdField_a_of_type_Long + " isFollow = " + this.jdField_a_of_type_Boolean);
    }
    if ((quh.a(this.jdField_a_of_type_Quj.a) != null) && (this.jdField_a_of_type_Long == quh.a(this.jdField_a_of_type_Quj.a).mSocialFeedInfo.a.jdField_a_of_type_Long) && (!this.jdField_a_of_type_Boolean) && (quh.a(this.jdField_a_of_type_Quj.a).isShowRecommendList))
    {
      quh.a(this.jdField_a_of_type_Quj.a, false);
      quh.a(this.jdField_a_of_type_Quj.a).isShowRecommendList = false;
    }
    if ((quh.a(this.jdField_a_of_type_Quj.a) != null) && (quh.a(this.jdField_a_of_type_Quj.a).mRecommendFollowInfos != null) && (quh.a(this.jdField_a_of_type_Quj.a).mRecommendFollowInfos.a != null))
    {
      Iterator localIterator = quh.a(this.jdField_a_of_type_Quj.a).mRecommendFollowInfos.a.iterator();
      while (localIterator.hasNext())
      {
        RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)localIterator.next();
        if (this.jdField_a_of_type_Long == localRecommendFollowInfo.uin)
        {
          localRecommendFollowInfo.isFollowed = this.jdField_a_of_type_Boolean;
          quh.a(this.jdField_a_of_type_Quj.a, localRecommendFollowInfo);
        }
      }
      quh.a(this.jdField_a_of_type_Quj.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.10.1
 * JD-Core Version:    0.7.0.1
 */