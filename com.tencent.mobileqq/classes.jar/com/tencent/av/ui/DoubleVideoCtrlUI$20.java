package com.tencent.av.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.screenshare.ScreenShareReportHelper;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class DoubleVideoCtrlUI$20
  implements View.OnClickListener
{
  DoubleVideoCtrlUI$20(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView)
  {
    ScreenShareReportHelper.a("0X800B8AC");
    this.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.20
 * JD-Core Version:    0.7.0.1
 */