package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddRequestActivity$7
  implements View.OnClickListener
{
  AddRequestActivity$7(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.c();
    ReportController.b(this.a.app, "CliOper", "", "", "0X800AA44", "0X800AA44", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.7
 * JD-Core Version:    0.7.0.1
 */