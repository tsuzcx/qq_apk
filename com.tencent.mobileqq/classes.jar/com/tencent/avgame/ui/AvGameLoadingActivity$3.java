package com.tencent.avgame.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.avgame.report.AVGameNodeReportUtil;
import com.tencent.avgame.util.AVGameUtil;
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mExitBtn ");
    localStringBuilder.append(AvGameLoadingActivity.h(this.a));
    localStringBuilder.append(" bExitEnable ");
    localStringBuilder.append(AvGameLoadingActivity.i(this.a));
    localStringBuilder.append("mExit");
    localStringBuilder.append(AvGameLoadingActivity.j(this.a));
    QLog.e("AvGameLoadingActivity", 2, localStringBuilder.toString());
    if (AvGameLoadingActivity.j(this.a) != null)
    {
      long l = AvGameEntranceUtil.a(AvGameLoadingActivity.j(this.a));
      AvGameLoadingActivity.a(this.a, l);
    }
    ReportController.b(null, "dc00898", "", "", "0X800B042", "0X800B042", 0, 0, "", "", "", "");
    if ((AvGameLoadingActivity.d(this.a) == 9) || (AvGameLoadingActivity.d(this.a) == 11) || (AvGameLoadingActivity.d(this.a) == 13)) {
      ReportController.b(null, "dc00898", "", "", "0X800B4A0", "0X800B4A0", AVGameUtil.e(), 0, "", "", "", "");
    }
    if (AvGameLoadingActivity.i(this.a))
    {
      AVGameNodeReportUtil.b(1);
      this.a.a();
    }
    else
    {
      QLog.e("AvGameLoadingActivity", 1, "mExitBtn click but not enabled");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AvGameLoadingActivity.3
 * JD-Core Version:    0.7.0.1
 */