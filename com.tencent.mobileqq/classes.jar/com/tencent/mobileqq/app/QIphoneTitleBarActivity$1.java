package com.tencent.mobileqq.app;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QIphoneTitleBarActivity$1
  implements View.OnClickListener
{
  QIphoneTitleBarActivity$1(QIphoneTitleBarActivity paramQIphoneTitleBarActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QIphoneTitleBarActivity.1
 * JD-Core Version:    0.7.0.1
 */