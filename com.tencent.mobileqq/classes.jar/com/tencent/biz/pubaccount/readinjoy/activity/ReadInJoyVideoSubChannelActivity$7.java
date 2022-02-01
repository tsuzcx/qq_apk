package com.tencent.biz.pubaccount.readinjoy.activity;

import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelInfo;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ReadInJoyVideoSubChannelActivity$7
  implements ActionSheet.OnButtonClickListener
{
  ReadInJoyVideoSubChannelActivity$7(ReadInJoyVideoSubChannelActivity paramReadInJoyVideoSubChannelActivity, ChannelInfo paramChannelInfo) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      ReadInJoyVideoSubChannelActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyVideoSubChannelActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructChannelInfo, false);
      ReadInJoyVideoSubChannelActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyActivityReadInJoyVideoSubChannelActivity).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyVideoSubChannelActivity.7
 * JD-Core Version:    0.7.0.1
 */