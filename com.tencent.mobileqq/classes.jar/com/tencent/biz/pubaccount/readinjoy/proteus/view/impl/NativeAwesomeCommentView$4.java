package com.tencent.biz.pubaccount.readinjoy.proteus.view.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AwesomeCommentInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NativeAwesomeCommentView$4
  implements View.OnClickListener
{
  NativeAwesomeCommentView$4(NativeAwesomeCommentView paramNativeAwesomeCommentView, AwesomeCommentInfo paramAwesomeCommentInfo) {}
  
  public void onClick(View paramView)
  {
    if (NativeAwesomeCommentView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAwesomeCommentView)) {
      NativeAwesomeCommentView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAwesomeCommentView, false);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAwesomeCommentInfo != null)
      {
        RIJJumpUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAwesomeCommentView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAwesomeCommentInfo.a, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAwesomeCommentInfo.c);
        AwesomeCommentInfo.a(NativeAwesomeCommentView.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyProteusViewImplNativeAwesomeCommentView).a, "0X8009B77");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.proteus.view.impl.NativeAwesomeCommentView.4
 * JD-Core Version:    0.7.0.1
 */