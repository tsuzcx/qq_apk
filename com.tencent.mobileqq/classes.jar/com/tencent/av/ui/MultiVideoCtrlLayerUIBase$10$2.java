package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MultiVideoCtrlLayerUIBase$10$2
  implements View.OnClickListener
{
  MultiVideoCtrlLayerUIBase$10$2(MultiVideoCtrlLayerUIBase.10 param10) {}
  
  public void onClick(View paramView)
  {
    if (this.a.a.a != null) {
      this.a.a.a.j();
    }
    ReportController.b(null, "CliOper", "", "", "0X8005DF3", "0X8005DF3", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.10.2
 * JD-Core Version:    0.7.0.1
 */