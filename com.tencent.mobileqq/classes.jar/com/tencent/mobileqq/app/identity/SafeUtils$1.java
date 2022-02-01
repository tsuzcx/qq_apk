package com.tencent.mobileqq.app.identity;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;

final class SafeUtils$1
  implements View.OnClickListener
{
  SafeUtils$1(Context paramContext, AppRuntime paramAppRuntime) {}
  
  public void onClick(View paramView)
  {
    QRoute.startUri(this.a, "/base/phoneUnityBindInfo");
    ReportController.b(this.b, "dc00898", "", "", "0X800B3EA", "0X800B3EA", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.SafeUtils.1
 * JD-Core Version:    0.7.0.1
 */