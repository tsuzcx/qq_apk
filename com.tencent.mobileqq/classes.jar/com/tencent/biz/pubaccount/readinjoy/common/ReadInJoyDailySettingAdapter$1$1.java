package com.tencent.biz.pubaccount.readinjoy.common;

import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDailySettingPopupWindow;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyDailySettingPopupWindow.Callback;
import java.util.List;

class ReadInJoyDailySettingAdapter$1$1
  implements ReadInJoyDailySettingPopupWindow.Callback
{
  ReadInJoyDailySettingAdapter$1$1(ReadInJoyDailySettingAdapter.1 param1) {}
  
  public void a(String paramString1, String paramString2)
  {
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyDailySettingAdapter$DailySettingViewHolder.b.setText(paramString2);
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDailySettingModel.d = paramString2;
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDailySettingModel.c = paramString1;
    if (this.a.jdField_a_of_type_Int < ReadInJoyDailySettingAdapter.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyDailySettingAdapter).size()) {
      ReadInJoyDailySettingAdapter.a(this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyDailySettingAdapter, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelReadInJoyDailySettingModel);
    }
    this.a.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommonReadInJoyDailySettingAdapter.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyDailySettingAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */