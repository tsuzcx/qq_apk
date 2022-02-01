package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import qcf;
import qch;
import qcp;
import qwy;
import qxt;

public class ReadInJoySocializeRecommendFollowView$10$1
  implements Runnable
{
  public ReadInJoySocializeRecommendFollowView$10$1(qch paramqch, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, "onUpdateAfterAccountFollow uin = " + this.jdField_a_of_type_Long + " isFollow = " + this.jdField_a_of_type_Boolean);
    }
    if ((qcf.a(this.jdField_a_of_type_Qch.a) != null) && (this.jdField_a_of_type_Long == qcf.a(this.jdField_a_of_type_Qch.a).mSocialFeedInfo.a.jdField_a_of_type_Long) && (!this.jdField_a_of_type_Boolean) && (qcf.a(this.jdField_a_of_type_Qch.a).isShowRecommendList))
    {
      qcf.a(this.jdField_a_of_type_Qch.a, false);
      qcf.a(this.jdField_a_of_type_Qch.a).isShowRecommendList = false;
    }
    if ((qcf.a(this.jdField_a_of_type_Qch.a) != null) && (qcf.a(this.jdField_a_of_type_Qch.a).mRecommendFollowInfos != null) && (qcf.a(this.jdField_a_of_type_Qch.a).mRecommendFollowInfos.a != null))
    {
      Iterator localIterator = qcf.a(this.jdField_a_of_type_Qch.a).mRecommendFollowInfos.a.iterator();
      while (localIterator.hasNext())
      {
        RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)localIterator.next();
        if (this.jdField_a_of_type_Long == localRecommendFollowInfo.uin)
        {
          localRecommendFollowInfo.isFollowed = this.jdField_a_of_type_Boolean;
          qcf.a(this.jdField_a_of_type_Qch.a, localRecommendFollowInfo);
        }
      }
      qcf.a(this.jdField_a_of_type_Qch.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.10.1
 * JD-Core Version:    0.7.0.1
 */