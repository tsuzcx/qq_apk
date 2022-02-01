package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import qjt;
import qjv;
import qkd;
import rgf;
import rha;

public class ReadInJoySocializeRecommendFollowView$10$1
  implements Runnable
{
  public ReadInJoySocializeRecommendFollowView$10$1(qjv paramqjv, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, "onUpdateAfterAccountFollow uin = " + this.jdField_a_of_type_Long + " isFollow = " + this.jdField_a_of_type_Boolean);
    }
    if ((qjt.a(this.jdField_a_of_type_Qjv.a) != null) && (this.jdField_a_of_type_Long == qjt.a(this.jdField_a_of_type_Qjv.a).mSocialFeedInfo.a.jdField_a_of_type_Long) && (!this.jdField_a_of_type_Boolean) && (qjt.a(this.jdField_a_of_type_Qjv.a).isShowRecommendList))
    {
      qjt.a(this.jdField_a_of_type_Qjv.a, false);
      qjt.a(this.jdField_a_of_type_Qjv.a).isShowRecommendList = false;
    }
    if ((qjt.a(this.jdField_a_of_type_Qjv.a) != null) && (qjt.a(this.jdField_a_of_type_Qjv.a).mRecommendFollowInfos != null) && (qjt.a(this.jdField_a_of_type_Qjv.a).mRecommendFollowInfos.a != null))
    {
      Iterator localIterator = qjt.a(this.jdField_a_of_type_Qjv.a).mRecommendFollowInfos.a.iterator();
      while (localIterator.hasNext())
      {
        RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)localIterator.next();
        if (this.jdField_a_of_type_Long == localRecommendFollowInfo.uin)
        {
          localRecommendFollowInfo.isFollowed = this.jdField_a_of_type_Boolean;
          qjt.a(this.jdField_a_of_type_Qjv.a, localRecommendFollowInfo);
        }
      }
      qjt.a(this.jdField_a_of_type_Qjv.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.10.1
 * JD-Core Version:    0.7.0.1
 */