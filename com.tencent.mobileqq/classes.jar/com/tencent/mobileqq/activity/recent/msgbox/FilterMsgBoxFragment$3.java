package com.tencent.mobileqq.activity.recent.msgbox;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FilterMsgBoxFragment$3
  implements View.OnClickListener
{
  FilterMsgBoxFragment$3(FilterMsgBoxFragment paramFilterMsgBoxFragment) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.getBaseActivity().isFinishing())
    {
      ReportController.b(FilterMsgBoxFragment.b(this.a), "dc00898", "", "", "0X800B6B8", "0X800B6B8", 0, 0, "", "", "", "");
      FilterMsgBoxFragment.c(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxFragment.3
 * JD-Core Version:    0.7.0.1
 */