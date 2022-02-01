package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.onlinestatus.ReportHelperKt;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AgeSelectionActivity$1
  implements View.OnClickListener
{
  AgeSelectionActivity$1(AgeSelectionActivity paramAgeSelectionActivity) {}
  
  public void onClick(View paramView)
  {
    AgeSelectionActivity.a(this.a);
    this.a.finish();
    if ("VAL_FROM_STATUS_MSG_TAB".equals(AgeSelectionActivity.a(this.a))) {
      ReportHelperKt.a("0X800AF47");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AgeSelectionActivity.1
 * JD-Core Version:    0.7.0.1
 */