package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BusinessCmrTmpChatPie$7
  implements View.OnClickListener
{
  BusinessCmrTmpChatPie$7(BusinessCmrTmpChatPie paramBusinessCmrTmpChatPie) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.q = true;
    ReportController.b(this.a.d, "CliOper", "", "", "Two_call", "Clk_aio_right", 0, 0, String.valueOf(0), "", "", "");
    PlusPanelUtils.a(this.a.d, this.a.f, this.a.ah, true, null, this.a);
    ReportController.b(this.a.d, "dc00899", "Qidian", "", "0X8008FEB", "qidianMasterVideo", 1, 1, 0, "2", "0", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.BusinessCmrTmpChatPie.7
 * JD-Core Version:    0.7.0.1
 */