package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import qdb;
import qdc;
import qlt;

public class ComponentContentRecommendFollowGroup$4$1
  implements Runnable
{
  public ComponentContentRecommendFollowGroup$4$1(qdb paramqdb, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentContentRecommendFollowGroup", 2, "onUpdateAfterAccountFollow uin = " + this.jdField_a_of_type_Long + " isFollow = " + this.jdField_a_of_type_Boolean);
    }
    Iterator localIterator = ComponentContentRecommendFollowGroup.a(this.jdField_a_of_type_Qdb.a).mRecommendFollowInfos.a.iterator();
    while (localIterator.hasNext())
    {
      RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)localIterator.next();
      if (this.jdField_a_of_type_Long == localRecommendFollowInfo.uin)
      {
        localRecommendFollowInfo.isFollowed = this.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_Qdb.a.b(localRecommendFollowInfo);
      }
    }
    ComponentContentRecommendFollowGroup.a(this.jdField_a_of_type_Qdb.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowGroup.4.1
 * JD-Core Version:    0.7.0.1
 */