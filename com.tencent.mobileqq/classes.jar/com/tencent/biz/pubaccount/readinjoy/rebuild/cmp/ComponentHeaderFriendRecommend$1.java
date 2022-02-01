package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class ComponentHeaderFriendRecommend$1
  implements View.OnClickListener
{
  ComponentHeaderFriendRecommend$1(ComponentHeaderFriendRecommend paramComponentHeaderFriendRecommend, List paramList, int paramInt) {}
  
  public void onClick(View paramView)
  {
    ComponentHeaderFriendRecommend.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentHeaderFriendRecommend, ((Long)this.jdField_a_of_type_JavaUtilList.get(this.jdField_a_of_type_Int)).longValue());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderFriendRecommend.1
 * JD-Core Version:    0.7.0.1
 */