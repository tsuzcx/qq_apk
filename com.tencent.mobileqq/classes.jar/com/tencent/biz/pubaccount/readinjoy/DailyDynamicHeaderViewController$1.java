package com.tencent.biz.pubaccount.readinjoy;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DailyDynamicHeaderViewController$1
  implements View.OnClickListener
{
  DailyDynamicHeaderViewController$1(DailyDynamicHeaderViewController paramDailyDynamicHeaderViewController) {}
  
  public void onClick(View paramView)
  {
    ((Activity)paramView.getContext()).onBackPressed();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.DailyDynamicHeaderViewController.1
 * JD-Core Version:    0.7.0.1
 */