package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MultiVideoEnterPageActivity$2
  implements View.OnClickListener
{
  MultiVideoEnterPageActivity$2(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(null, "P_CliOper", "Grp_qiqiqun", "", "show_middle", "Clk_video", 0, 0, this.a.i, "", "", "");
    this.a.d(2);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity.2
 * JD-Core Version:    0.7.0.1
 */