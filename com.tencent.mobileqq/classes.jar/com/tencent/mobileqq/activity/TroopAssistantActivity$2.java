package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopAssistantActivity$2
  implements View.OnClickListener
{
  TroopAssistantActivity$2(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onClick(View paramView)
  {
    TroopAssistantActivity.a(this.a);
    ReportController.b(this.a.app, "dc00899", "Grp_msg", "", "helper-guide", "Clk_close", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.2
 * JD-Core Version:    0.7.0.1
 */