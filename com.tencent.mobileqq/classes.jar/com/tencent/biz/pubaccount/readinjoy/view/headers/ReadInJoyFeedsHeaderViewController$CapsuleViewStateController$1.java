package com.tencent.biz.pubaccount.readinjoy.view.headers;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.readinjoy.ReadInJoyHelper;

class ReadInJoyFeedsHeaderViewController$CapsuleViewStateController$1
  implements View.OnClickListener
{
  ReadInJoyFeedsHeaderViewController$CapsuleViewStateController$1(ReadInJoyFeedsHeaderViewController.CapsuleViewStateController paramCapsuleViewStateController, View.OnClickListener paramOnClickListener) {}
  
  public void onClick(View paramView)
  {
    QLog.d("ReadInJoyFeedsHeaderVie", 2, "onClick: " + ReadInJoyFeedsHeaderViewController.CapsuleViewStateController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyFeedsHeaderViewController$CapsuleViewStateController).mChannelCoverName);
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener != null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener.onClick(paramView);
    }
    ReadInJoyHelper.a(ReadInJoyFeedsHeaderViewController.CapsuleViewStateController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyFeedsHeaderViewController$CapsuleViewStateController).mChannelCoverId, true);
    ReadInJoyFeedsHeaderViewController.CapsuleViewStateController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersReadInJoyFeedsHeaderViewController$CapsuleViewStateController);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyFeedsHeaderViewController.CapsuleViewStateController.1
 * JD-Core Version:    0.7.0.1
 */