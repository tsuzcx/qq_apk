package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import qid;
import qif;
import qin;
import rdw;
import rer;

public class ReadInJoySocializeRecommendFollowView$10$1
  implements Runnable
{
  public ReadInJoySocializeRecommendFollowView$10$1(qif paramqif, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, "onUpdateAfterAccountFollow uin = " + this.jdField_a_of_type_Long + " isFollow = " + this.jdField_a_of_type_Boolean);
    }
    if ((qid.a(this.jdField_a_of_type_Qif.a) != null) && (this.jdField_a_of_type_Long == qid.a(this.jdField_a_of_type_Qif.a).mSocialFeedInfo.a.jdField_a_of_type_Long) && (!this.jdField_a_of_type_Boolean) && (qid.a(this.jdField_a_of_type_Qif.a).isShowRecommendList))
    {
      qid.a(this.jdField_a_of_type_Qif.a, false);
      qid.a(this.jdField_a_of_type_Qif.a).isShowRecommendList = false;
    }
    if ((qid.a(this.jdField_a_of_type_Qif.a) != null) && (qid.a(this.jdField_a_of_type_Qif.a).mRecommendFollowInfos != null) && (qid.a(this.jdField_a_of_type_Qif.a).mRecommendFollowInfos.a != null))
    {
      Iterator localIterator = qid.a(this.jdField_a_of_type_Qif.a).mRecommendFollowInfos.a.iterator();
      while (localIterator.hasNext())
      {
        RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)localIterator.next();
        if (this.jdField_a_of_type_Long == localRecommendFollowInfo.uin)
        {
          localRecommendFollowInfo.isFollowed = this.jdField_a_of_type_Boolean;
          qid.a(this.jdField_a_of_type_Qif.a, localRecommendFollowInfo);
        }
      }
      qid.a(this.jdField_a_of_type_Qif.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.10.1
 * JD-Core Version:    0.7.0.1
 */