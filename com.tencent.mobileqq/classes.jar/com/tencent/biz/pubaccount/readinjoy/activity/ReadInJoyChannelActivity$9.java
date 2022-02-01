package com.tencent.biz.pubaccount.readinjoy.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyChannelActivity$9
  implements View.OnClickListener
{
  ReadInJoyChannelActivity$9(ReadInJoyChannelActivity paramReadInJoyChannelActivity) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a instanceof ReadInJoyChannelViewController)) {
      ((ReadInJoyChannelViewController)this.a.a).o();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.9
 * JD-Core Version:    0.7.0.1
 */