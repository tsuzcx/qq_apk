package com.tencent.biz.pubaccount.readinjoy.activity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoySkinGuideView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyNewFeedsActivity$5$1
  implements View.OnClickListener
{
  ReadInJoyNewFeedsActivity$5$1(ReadInJoyNewFeedsActivity.5 param5, FrameLayout paramFrameLayout) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.this$0.a.a();
    this.jdField_a_of_type_AndroidWidgetFrameLayout.removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.this$0.a);
    if (QQManagerFactory.READ_INJOY_SKIN_MANAGER == this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.a) {
      SharedPreUtils.s(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.this$0, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyNewFeedsActivity$5.this$0.app.getCurrentAccountUin(), null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity.5.1
 * JD-Core Version:    0.7.0.1
 */