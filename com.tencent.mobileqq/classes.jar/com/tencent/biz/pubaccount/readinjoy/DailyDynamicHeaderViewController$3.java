package com.tencent.biz.pubaccount.readinjoy;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DailyDynamicHeaderViewController$3
  implements View.OnClickListener
{
  DailyDynamicHeaderViewController$3(DailyDynamicHeaderViewController paramDailyDynamicHeaderViewController) {}
  
  public void onClick(View paramView)
  {
    QLog.i("DailyHeaderViewController", 1, "[onClick] clickToRefresh");
    DailyDynamicHeaderViewController.a(this.a, 5);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.DailyDynamicHeaderViewController.3
 * JD-Core Version:    0.7.0.1
 */