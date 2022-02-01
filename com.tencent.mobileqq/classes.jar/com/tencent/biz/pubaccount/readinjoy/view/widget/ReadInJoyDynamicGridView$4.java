package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

class ReadInJoyDynamicGridView$4
  extends AnimatorListenerAdapter
{
  ReadInJoyDynamicGridView$4(ReadInJoyDynamicGridView paramReadInJoyDynamicGridView, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView, false);
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView);
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView, this.jdField_a_of_type_AndroidViewView);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView, true);
    ReadInJoyDynamicGridView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetReadInJoyDynamicGridView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDynamicGridView.4
 * JD-Core Version:    0.7.0.1
 */