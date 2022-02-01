package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.ModeChoiceViewContainer;
import com.tencent.mobileqq.theme.DarkModeManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.mobilereport.MobileReportManager;

class SimpleUIChoiceView$ColorListAdapter$3
  implements View.OnClickListener
{
  SimpleUIChoiceView$ColorListAdapter$3(SimpleUIChoiceView.ColorListAdapter paramColorListAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if (SimpleUIChoiceView.b(this.b.b))
    {
      Object localObject = this.b.a(this.a);
      if (localObject != null)
      {
        localObject = SimpleUIUtil.a(((SimpleUIChoiceView.ColorItemInfo)localObject).f);
        if (!DarkModeManager.b(SimpleUIChoiceView.a(this.b.b), (String)localObject, new SimpleUIChoiceView.ColorListAdapter.3.1(this))) {
          SimpleUIChoiceView.ColorListAdapter.a(this.b, this.a);
        }
        MobileReportManager.getInstance().reportAction((String)localObject, "4", "platform898", "4", "1", 102, 1, System.currentTimeMillis());
        int i;
        if (ModeChoiceViewContainer.a(SimpleUIChoiceView.d(this.b.b))) {
          i = 1;
        } else {
          i = 2;
        }
        int j = SimpleUIUtil.b((String)localObject);
        ReportController.b(SimpleUIChoiceView.d(this.b.b), "dc00898", "", "", "0X800B15C", "0X800B15C", j + 1, 0, String.valueOf(i), "", "", "");
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SimpleUIChoiceView.ColorListAdapter.3
 * JD-Core Version:    0.7.0.1
 */