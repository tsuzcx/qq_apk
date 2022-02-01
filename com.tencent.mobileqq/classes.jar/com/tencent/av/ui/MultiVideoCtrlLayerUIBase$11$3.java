package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MultiVideoCtrlLayerUIBase$11$3
  implements View.OnClickListener
{
  MultiVideoCtrlLayerUIBase$11$3(MultiVideoCtrlLayerUIBase.11 param11) {}
  
  public void onClick(View paramView)
  {
    if (this.a.b.am != null) {
      this.a.b.am.M();
    }
    ReportController.b(null, "CliOper", "", "", "0X8005DF3", "0X8005DF3", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.11.3
 * JD-Core Version:    0.7.0.1
 */