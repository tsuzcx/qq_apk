package com.tencent.mobileqq.activity.aio.rebuild;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class StrangerChatPie$2
  implements View.OnClickListener
{
  StrangerChatPie$2(StrangerChatPie paramStrangerChatPie) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    com.tencent.mobileqq.activity.aio.AIOUtils.q = true;
    int j = this.a.ah.a;
    if (j != 1000) {
      if (j != 1004)
      {
        if (j != 1006) {
          i = 0;
        } else {
          i = 3;
        }
      }
      else {
        i = 2;
      }
    }
    ReportController.b(this.a.d, "CliOper", "", "", "Two_call", "Clk_aio_right", 0, 0, String.valueOf(i), "", "", "");
    PlusPanelUtils.a(this.a.d, this.a.f, this.a.ah, true, null, this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.StrangerChatPie.2
 * JD-Core Version:    0.7.0.1
 */