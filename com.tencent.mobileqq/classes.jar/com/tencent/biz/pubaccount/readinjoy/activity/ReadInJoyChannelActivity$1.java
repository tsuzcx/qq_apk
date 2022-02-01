package com.tencent.biz.pubaccount.readinjoy.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyChannelActivity$1
  implements View.OnClickListener
{
  ReadInJoyChannelActivity$1(ReadInJoyChannelActivity paramReadInJoyChannelActivity) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyChannelActivity.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.1
 * JD-Core Version:    0.7.0.1
 */