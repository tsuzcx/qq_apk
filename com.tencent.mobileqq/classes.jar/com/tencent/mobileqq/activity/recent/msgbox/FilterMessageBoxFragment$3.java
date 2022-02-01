package com.tencent.mobileqq.activity.recent.msgbox;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class FilterMessageBoxFragment$3
  implements View.OnClickListener
{
  FilterMessageBoxFragment$3(FilterMessageBoxFragment paramFilterMessageBoxFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.a.getActivity().isFinishing()) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ReportController.b(FilterMessageBoxFragment.a(this.a), "dc00898", "", "", "0X800B6B8", "0X800B6B8", 0, 0, "", "", "", "");
      FilterMessageBoxFragment.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msgbox.FilterMessageBoxFragment.3
 * JD-Core Version:    0.7.0.1
 */