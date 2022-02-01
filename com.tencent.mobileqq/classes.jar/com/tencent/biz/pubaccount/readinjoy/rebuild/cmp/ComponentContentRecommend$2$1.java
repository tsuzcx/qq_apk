package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.RecommendFollowInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ComponentContentRecommend$2$1
  implements View.OnClickListener
{
  ComponentContentRecommend$2$1(ComponentContentRecommend.2 param2, RecommendFollowInfo paramRecommendFollowInfo) {}
  
  public void onClick(View paramView)
  {
    ComponentContentRecommend.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommend$2.a, "0X80094DA", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentContentRecommend$2.a.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructRecommendFollowInfo);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentRecommend.2.1
 * JD-Core Version:    0.7.0.1
 */