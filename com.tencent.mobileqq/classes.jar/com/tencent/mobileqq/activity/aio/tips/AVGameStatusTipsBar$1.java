package com.tencent.mobileqq.activity.aio.tips;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AVGameStatusTipsBar$1
  implements View.OnClickListener
{
  AVGameStatusTipsBar$1(AVGameStatusTipsBar paramAVGameStatusTipsBar) {}
  
  public void onClick(View paramView)
  {
    AVGameStatusTipsBar.a(this.a);
    ReportController.b(null, "dc00898", "", "", "0X800B034", "0X800B034", 0, 0, "", "", AVGameStatusTipsBar.a(this.a).a, "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.AVGameStatusTipsBar.1
 * JD-Core Version:    0.7.0.1
 */