package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.screenshare.ScreenShareReportHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class DoubleVideoCtrlUI$22
  implements View.OnClickListener
{
  DoubleVideoCtrlUI$22(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    ScreenShareReportHelper.b("0X800B8AC");
    this.a.superDismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.22
 * JD-Core Version:    0.7.0.1
 */