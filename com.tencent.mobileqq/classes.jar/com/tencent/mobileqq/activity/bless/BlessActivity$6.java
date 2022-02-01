package com.tencent.mobileqq.activity.bless;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BlessActivity$6
  implements View.OnClickListener
{
  BlessActivity$6(BlessActivity paramBlessActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.app, "CliOper", "", "", "0X800632F", "0X800632F", 0, 0, "", "", "", "");
    BlessActivity.a(this.a, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessActivity.6
 * JD-Core Version:    0.7.0.1
 */