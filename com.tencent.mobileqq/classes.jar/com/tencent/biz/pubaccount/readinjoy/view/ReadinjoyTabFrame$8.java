package com.tencent.biz.pubaccount.readinjoy.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadinjoyTabFrame$8
  implements View.OnClickListener
{
  ReadinjoyTabFrame$8(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void onClick(View paramView)
  {
    PublicTransFragmentActivity.a(this.a.a(), ReadInJoyChannelPanelFragment.class);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.8
 * JD-Core Version:    0.7.0.1
 */