package com.tencent.mobileqq.activity.aio.tips;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DiscActiveTipsBar$1
  implements View.OnClickListener
{
  DiscActiveTipsBar$1(DiscActiveTipsBar paramDiscActiveTipsBar) {}
  
  public void onClick(View paramView)
  {
    DiscActiveTipsBar.a(this.a).c();
    ChatActivityUtils.a(DiscActiveTipsBar.b(this.a), DiscActiveTipsBar.c(this.a), DiscActiveTipsBar.d(this.a).a, DiscActiveTipsBar.d(this.a).b, true, true, null, null);
    ReportController.b(DiscActiveTipsBar.b(this.a), "CliOper", "", "", "0X8003F00", "0X8003F00", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.DiscActiveTipsBar.1
 * JD-Core Version:    0.7.0.1
 */