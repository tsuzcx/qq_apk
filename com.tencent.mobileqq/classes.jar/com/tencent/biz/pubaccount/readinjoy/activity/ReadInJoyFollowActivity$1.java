package com.tencent.biz.pubaccount.readinjoy.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewController;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyFollowActivity$1
  implements View.OnClickListener
{
  ReadInJoyFollowActivity$1(ReadInJoyFollowActivity paramReadInJoyFollowActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a.a(true);
    ThreadManager.executeOnSubThread(new ReadInJoyFollowActivity.1.1(this));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFollowActivity.1
 * JD-Core Version:    0.7.0.1
 */