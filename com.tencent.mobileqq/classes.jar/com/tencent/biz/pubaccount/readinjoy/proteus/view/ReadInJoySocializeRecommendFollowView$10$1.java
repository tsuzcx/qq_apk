package com.tencent.biz.pubaccount.readinjoy.proteus.view;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import plp;
import plr;
import plz;
import qca;
import qcl;

public class ReadInJoySocializeRecommendFollowView$10$1
  implements Runnable
{
  public ReadInJoySocializeRecommendFollowView$10$1(plr paramplr, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoySocializeRecommendFollowView", 2, "onUpdateAfterAccountFollow uin = " + this.jdField_a_of_type_Long + " isFollow = " + this.jdField_a_of_type_Boolean);
    }
    if ((plp.a(this.jdField_a_of_type_Plr.a) != null) && (this.jdField_a_of_type_Long == plp.a(this.jdField_a_of_type_Plr.a).mSocialFeedInfo.a.jdField_a_of_type_Long) && (!this.jdField_a_of_type_Boolean) && (plp.a(this.jdField_a_of_type_Plr.a).isShowRecommendList))
    {
      plp.a(this.jdField_a_of_type_Plr.a, false);
      plp.a(this.jdField_a_of_type_Plr.a).isShowRecommendList = false;
    }
    if ((plp.a(this.jdField_a_of_type_Plr.a) != null) && (plp.a(this.jdField_a_of_type_Plr.a).mRecommendFollowInfos != null) && (plp.a(this.jdField_a_of_type_Plr.a).mRecommendFollowInfos.a != null))
    {
      Iterator localIterator = plp.a(this.jdField_a_of_type_Plr.a).mRecommendFollowInfos.a.iterator();
      while (localIterator.hasNext())
      {
        RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)localIterator.next();
        if (this.jdField_a_of_type_Long == localRecommendFollowInfo.uin)
        {
          localRecommendFollowInfo.isFollowed = this.jdField_a_of_type_Boolean;
          plp.a(this.jdField_a_of_type_Plr.a, localRecommendFollowInfo);
        }
      }
      plp.a(this.jdField_a_of_type_Plr.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.ReadInJoySocializeRecommendFollowView.10.1
 * JD-Core Version:    0.7.0.1
 */