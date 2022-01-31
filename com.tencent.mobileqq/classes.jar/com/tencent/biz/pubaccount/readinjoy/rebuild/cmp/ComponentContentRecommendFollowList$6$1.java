package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import qdi;
import qdj;
import qlt;

public class ComponentContentRecommendFollowList$6$1
  implements Runnable
{
  public ComponentContentRecommendFollowList$6$1(qdi paramqdi, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentContentRecommendFollowList", 2, "onUpdateAfterAccountFollow uin = " + this.jdField_a_of_type_Long + " isFollow = " + this.jdField_a_of_type_Boolean);
    }
    Iterator localIterator = ComponentContentRecommendFollowList.a(this.jdField_a_of_type_Qdi.a).mRecommendFollowInfos.a.iterator();
    while (localIterator.hasNext())
    {
      RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)localIterator.next();
      if (this.jdField_a_of_type_Long == localRecommendFollowInfo.uin)
      {
        localRecommendFollowInfo.isFollowed = this.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_Qdi.a.a(localRecommendFollowInfo);
      }
    }
    ComponentContentRecommendFollowList.a(this.jdField_a_of_type_Qdi.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowList.6.1
 * JD-Core Version:    0.7.0.1
 */