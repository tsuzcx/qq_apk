package com.tencent.avgame.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.avgame.util.AVGameNodeReportUtil;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.avgame.util.AvGameEntranceUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AvGameLoadingActivity$3
  implements View.OnClickListener
{
  AvGameLoadingActivity$3(AvGameLoadingActivity paramAvGameLoadingActivity) {}
  
  public void onClick(View paramView)
  {
    QLog.e("AvGameManagerAvGameLoadingActivity", 2, "mExitBtn " + AvGameLoadingActivity.a(this.a) + " bExitEnable " + AvGameLoadingActivity.f(this.a) + "mExit" + AvGameLoadingActivity.b(this.a));
    if (AvGameLoadingActivity.b(this.a) != null)
    {
      long l = AvGameEntranceUtil.a(AvGameLoadingActivity.b(this.a));
      AvGameLoadingActivity.a(this.a, l);
    }
    ReportController.b(null, "dc00898", "", "", "0X800B042", "0X800B042", 0, 0, "", "", "", "");
    if ((AvGameLoadingActivity.a(this.a) == 9) || (AvGameLoadingActivity.a(this.a) == 11) || (AvGameLoadingActivity.a(this.a) == 13)) {
      ReportController.b(null, "dc00898", "", "", "0X800B4A0", "0X800B4A0", AVGameUtils.e(), 0, "", "", "", "");
    }
    if (AvGameLoadingActivity.f(this.a))
    {
      AVGameNodeReportUtil.b(1);
      this.a.a();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      QLog.e("AvGameManagerAvGameLoadingActivity", 1, "mExitBtn click but not enabled");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AvGameLoadingActivity.3
 * JD-Core Version:    0.7.0.1
 */