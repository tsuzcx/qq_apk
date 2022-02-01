package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.tips.TipsUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class DoubleVideoCtrlUI$29$1
  implements View.OnClickListener
{
  DoubleVideoCtrlUI$29$1(DoubleVideoCtrlUI.29 param29) {}
  
  public void onClick(View paramView)
  {
    int i;
    if (this.a.b) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X800BCDE", "0X800BCDE", i, 0, "", "", "", "");
    this.a.this$0.az_();
    TipsUtil.a(this.a.this$0.al, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.29.1
 * JD-Core Version:    0.7.0.1
 */