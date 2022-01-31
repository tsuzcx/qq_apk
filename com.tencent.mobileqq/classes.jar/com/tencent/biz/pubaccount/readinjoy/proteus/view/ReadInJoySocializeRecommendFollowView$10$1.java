package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import prr;
import prt;
import psb;
import qlt;
import qme;

public class ReadInJoySocializeRecommendFollowView$10$1
  implements Runnable
{
  public ReadInJoySocializeRecommendFollowView$10$1(prt paramprt, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, "onUpdateAfterAccountFollow uin = " + this.jdField_a_of_type_Long + " isFollow = " + this.jdField_a_of_type_Boolean);
    }
    if ((prr.a(this.jdField_a_of_type_Prt.a) != null) && (this.jdField_a_of_type_Long == prr.a(this.jdField_a_of_type_Prt.a).mSocialFeedInfo.a.jdField_a_of_type_Long) && (!this.jdField_a_of_type_Boolean) && (prr.a(this.jdField_a_of_type_Prt.a).isShowRecommendList))
    {
      prr.a(this.jdField_a_of_type_Prt.a, false);
      prr.a(this.jdField_a_of_type_Prt.a).isShowRecommendList = false;
    }
    if ((prr.a(this.jdField_a_of_type_Prt.a) != null) && (prr.a(this.jdField_a_of_type_Prt.a).mRecommendFollowInfos != null) && (prr.a(this.jdField_a_of_type_Prt.a).mRecommendFollowInfos.a != null))
    {
      Iterator localIterator = prr.a(this.jdField_a_of_type_Prt.a).mRecommendFollowInfos.a.iterator();
      while (localIterator.hasNext())
      {
        RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)localIterator.next();
        if (this.jdField_a_of_type_Long == localRecommendFollowInfo.uin)
        {
          localRecommendFollowInfo.isFollowed = this.jdField_a_of_type_Boolean;
          prr.a(this.jdField_a_of_type_Prt.a, localRecommendFollowInfo);
        }
      }
      prr.a(this.jdField_a_of_type_Prt.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.10.1
 * JD-Core Version:    0.7.0.1
 */