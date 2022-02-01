package com.tencent.mobileqq.app;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class IphoneTitleBarActivity$1
  implements View.OnClickListener
{
  IphoneTitleBarActivity$1(IphoneTitleBarActivity paramIphoneTitleBarActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.IphoneTitleBarActivity.1
 * JD-Core Version:    0.7.0.1
 */