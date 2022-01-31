package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import plm;
import plo;
import plw;
import qbx;
import qci;

public class ReadInJoySocializeRecommendFollowView$10$1
  implements Runnable
{
  public ReadInJoySocializeRecommendFollowView$10$1(plo paramplo, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, "onUpdateAfterAccountFollow uin = " + this.jdField_a_of_type_Long + " isFollow = " + this.jdField_a_of_type_Boolean);
    }
    if ((plm.a(this.jdField_a_of_type_Plo.a) != null) && (this.jdField_a_of_type_Long == plm.a(this.jdField_a_of_type_Plo.a).mSocialFeedInfo.a.jdField_a_of_type_Long) && (!this.jdField_a_of_type_Boolean) && (plm.a(this.jdField_a_of_type_Plo.a).isShowRecommendList))
    {
      plm.a(this.jdField_a_of_type_Plo.a, false);
      plm.a(this.jdField_a_of_type_Plo.a).isShowRecommendList = false;
    }
    if ((plm.a(this.jdField_a_of_type_Plo.a) != null) && (plm.a(this.jdField_a_of_type_Plo.a).mRecommendFollowInfos != null) && (plm.a(this.jdField_a_of_type_Plo.a).mRecommendFollowInfos.a != null))
    {
      Iterator localIterator = plm.a(this.jdField_a_of_type_Plo.a).mRecommendFollowInfos.a.iterator();
      while (localIterator.hasNext())
      {
        RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)localIterator.next();
        if (this.jdField_a_of_type_Long == localRecommendFollowInfo.uin)
        {
          localRecommendFollowInfo.isFollowed = this.jdField_a_of_type_Boolean;
          plm.a(this.jdField_a_of_type_Plo.a, localRecommendFollowInfo);
        }
      }
      plm.a(this.jdField_a_of_type_Plo.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.10.1
 * JD-Core Version:    0.7.0.1
 */