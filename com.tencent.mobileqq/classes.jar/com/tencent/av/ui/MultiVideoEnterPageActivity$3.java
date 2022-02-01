package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MultiVideoEnterPageActivity$3
  implements View.OnClickListener
{
  MultiVideoEnterPageActivity$3(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void onClick(View paramView)
  {
    QAVGroupConfig.Report.c();
    ReportController.b(null, "P_CliOper", "Grp_qiqiqun", "", "show_middle", "Clk_call", 0, 0, this.a.b, "", "", "");
    this.a.d(10);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity.3
 * JD-Core Version:    0.7.0.1
 */