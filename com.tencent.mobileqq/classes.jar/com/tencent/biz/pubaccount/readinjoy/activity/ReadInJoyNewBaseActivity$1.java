package com.tencent.biz.pubaccount.readinjoy.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ReadInJoyNewBaseActivity$1
  implements View.OnClickListener
{
  ReadInJoyNewBaseActivity$1(ReadInJoyNewBaseActivity paramReadInJoyNewBaseActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewBaseActivity.1
 * JD-Core Version:    0.7.0.1
 */