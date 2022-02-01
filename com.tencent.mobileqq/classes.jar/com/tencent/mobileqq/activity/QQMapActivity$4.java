package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQMapActivity$4
  implements View.OnClickListener
{
  QQMapActivity$4(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackPressed();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity.4
 * JD-Core Version:    0.7.0.1
 */