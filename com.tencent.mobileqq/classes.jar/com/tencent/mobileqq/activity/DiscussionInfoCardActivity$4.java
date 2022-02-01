package com.tencent.mobileqq.activity;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DiscussionInfoCardActivity$4
  implements CompoundButton.OnCheckedChangeListener
{
  DiscussionInfoCardActivity$4(DiscussionInfoCardActivity paramDiscussionInfoCardActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    String str;
    if (AppSetting.d)
    {
      str = this.a.getString(2131693069);
      DiscussionInfoCardActivity.b(this.a).setContentDescription(str);
    }
    boolean bool = DiscussionInfoCardActivity.a(this.a).a(this.a.a);
    DiscussionInfoCardActivity.a(this.a).a(this.a.a, bool ^ true);
    ReportTask localReportTask = new ReportTask(this.a.app).a("dc00899").b("Grp_Dis_set").c("Dis_info");
    if (bool) {
      str = "Clk_unstick";
    } else {
      str = "Clk_stick";
    }
    localReportTask.d(str).a();
    EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.4
 * JD-Core Version:    0.7.0.1
 */