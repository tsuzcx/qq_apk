package com.tencent.biz.pubaccount.readinjoy;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.view.DailyTitleBarSwitcher;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DailyDynamicHeaderViewController$10
  implements View.OnClickListener
{
  DailyDynamicHeaderViewController$10(DailyDynamicHeaderViewController paramDailyDynamicHeaderViewController, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((DailyDynamicHeaderViewController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDailyDynamicHeaderViewController) != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      ReadInJoyUtils.a(DailyDynamicHeaderViewController.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyDailyDynamicHeaderViewController).getContext(), this.jdField_a_of_type_JavaLangString);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.DailyDynamicHeaderViewController.10
 * JD-Core Version:    0.7.0.1
 */