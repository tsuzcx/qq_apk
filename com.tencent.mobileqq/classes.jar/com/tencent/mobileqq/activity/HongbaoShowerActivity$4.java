package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class HongbaoShowerActivity$4
  implements View.OnClickListener
{
  HongbaoShowerActivity$4(HongbaoShowerActivity paramHongbaoShowerActivity) {}
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.a.a < 2000L)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    this.a.finish();
    this.a.overridePendingTransition(0, 0);
    QQAppInterface localQQAppInterface = this.a.app;
    if (HongbaoShowerActivity.a(this.a) == 0) {}
    for (String str = "1";; str = "2")
    {
      ReportController.b(localQQAppInterface, "dc01440", "", "", "0X80077EA", "0X80077EA", 0, 0, str, "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.HongbaoShowerActivity.4
 * JD-Core Version:    0.7.0.1
 */