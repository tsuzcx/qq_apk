package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComponentContentRecommend$2$2
  implements View.OnClickListener
{
  ComponentContentRecommend$2$2(ComponentContentRecommend.2 param2, RecommendFollowInfo paramRecommendFollowInfo) {}
  
  public void onClick(View paramView)
  {
    ComponentContentRecommend localComponentContentRecommend = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommend$2.a;
    RecommendFollowInfo localRecommendFollowInfo = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo;
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo.isFollowed) {}
    for (boolean bool = true;; bool = false)
    {
      localComponentContentRecommend.a(localRecommendFollowInfo, bool);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommend.2.2
 * JD-Core Version:    0.7.0.1
 */