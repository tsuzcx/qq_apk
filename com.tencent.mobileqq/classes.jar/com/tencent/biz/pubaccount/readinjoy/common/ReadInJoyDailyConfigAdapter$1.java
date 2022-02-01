package com.tencent.biz.pubaccount.readinjoy.common;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDailySettingPopupWindow.Callback;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyDailyConfigAdapter$1
  implements View.OnClickListener
{
  ReadInJoyDailyConfigAdapter$1(ReadInJoyDailyConfigAdapter paramReadInJoyDailyConfigAdapter, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyDailyConfigAdapter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyDailyConfigAdapter).a(this.jdField_a_of_type_JavaLangString, this.b);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDailyConfigAdapter.1
 * JD-Core Version:    0.7.0.1
 */