package com.tencent.biz.pubaccount.readinjoy.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoySettingActivity$4
  implements View.OnClickListener
{
  ReadInJoySettingActivity$4(ReadInJoySettingActivity paramReadInJoySettingActivity) {}
  
  public void onClick(View paramView)
  {
    RIJJumpUtils.a(paramView.getContext(), "https://kandian.qq.com/mqq/vue/configPush?_wv=3&x5PreFetch=1&_bid=2378", null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoySettingActivity.4
 * JD-Core Version:    0.7.0.1
 */