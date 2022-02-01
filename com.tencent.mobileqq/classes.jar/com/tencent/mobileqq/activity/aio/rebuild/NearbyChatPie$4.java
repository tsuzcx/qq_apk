package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NearbyChatPie$4
  implements View.OnClickListener
{
  NearbyChatPie$4(NearbyChatPie paramNearbyChatPie) {}
  
  public void onClick(View paramView)
  {
    com.tencent.mobileqq.activity.aio.AIOUtils.q = true;
    if ((this.a.ah.a != 1001) && (this.a.ah.a != 10002))
    {
      if (this.a.ah.a == 1010) {
        ReportController.b(this.a.d, "CliOper", "", "", "0X80049C6", "0X80049C6", 0, 0, "", "", "", "");
      }
    }
    else {
      ReportController.b(this.a.d, "CliOper", "", "", "0X800514F", "0X800514F", 0, 0, "", "", "", "");
    }
    ReportController.b(this.a.d, "CliOper", "", "", "Two_call", "Clk_aio_right", 0, 0, String.valueOf(0), "", "", "");
    PlusPanelUtils.a(this.a.d, this.a.f, this.a.ah, true, null, this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.4
 * JD-Core Version:    0.7.0.1
 */