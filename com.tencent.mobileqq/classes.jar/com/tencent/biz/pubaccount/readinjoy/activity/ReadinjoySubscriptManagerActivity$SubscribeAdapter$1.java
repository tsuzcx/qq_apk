package com.tencent.biz.pubaccount.readinjoy.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SwipListView;

class ReadinjoySubscriptManagerActivity$SubscribeAdapter$1
  implements View.OnClickListener
{
  ReadinjoySubscriptManagerActivity$SubscribeAdapter$1(ReadinjoySubscriptManagerActivity.SubscribeAdapter paramSubscribeAdapter, View paramView) {}
  
  public void onClick(View paramView)
  {
    ReadinjoySubscriptManagerActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadinjoySubscriptManagerActivity$SubscribeAdapter.a).showSpecificRightView(this.jdField_a_of_type_AndroidViewView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadinjoySubscriptManagerActivity.SubscribeAdapter.1
 * JD-Core Version:    0.7.0.1
 */