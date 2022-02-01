package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfos;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class ComponentContentRecommendFollowGroup$4$1
  implements Runnable
{
  ComponentContentRecommendFollowGroup$4$1(ComponentContentRecommendFollowGroup.4 param4, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentContentRecommendFollowGroup", 2, "onUpdateAfterAccountFollow uin = " + this.jdField_a_of_type_Long + " isFollow = " + this.jdField_a_of_type_Boolean);
    }
    Iterator localIterator = ComponentContentRecommendFollowGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowGroup$4.a).mRecommendFollowInfos.a.iterator();
    while (localIterator.hasNext())
    {
      RecommendFollowInfo localRecommendFollowInfo = (RecommendFollowInfo)localIterator.next();
      if (this.jdField_a_of_type_Long == localRecommendFollowInfo.uin)
      {
        localRecommendFollowInfo.isFollowed = this.jdField_a_of_type_Boolean;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowGroup$4.a.b(localRecommendFollowInfo);
      }
    }
    ComponentContentRecommendFollowGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommendFollowGroup$4.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommendFollowGroup.4.1
 * JD-Core Version:    0.7.0.1
 */