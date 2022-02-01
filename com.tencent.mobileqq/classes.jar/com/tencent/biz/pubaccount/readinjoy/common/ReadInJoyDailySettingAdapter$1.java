package com.tencent.biz.pubaccount.readinjoy.common;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDailySettingModel;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDailySettingPopupWindow;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyDailySettingAdapter$1
  implements View.OnClickListener
{
  ReadInJoyDailySettingAdapter$1(ReadInJoyDailySettingAdapter paramReadInJoyDailySettingAdapter, ReadInJoyDailySettingAdapter.DailySettingViewHolder paramDailySettingViewHolder, ReadInJoyDailySettingModel paramReadInJoyDailySettingModel, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyDailySettingAdapter.a = new ReadInJoyDailySettingPopupWindow((Activity)ReadInJoyDailySettingAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyDailySettingAdapter), new ReadInJoyDailySettingAdapter.1.1(this), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDailySettingModel.b, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDailySettingModel.a);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyDailySettingAdapter.a.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyDailySettingAdapter$DailySettingViewHolder.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDailySettingAdapter.1
 * JD-Core Version:    0.7.0.1
 */