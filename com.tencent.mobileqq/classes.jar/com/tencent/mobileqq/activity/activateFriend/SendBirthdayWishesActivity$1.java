package com.tencent.mobileqq.activity.activateFriend;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SendBirthdayWishesActivity$1
  implements View.OnClickListener
{
  SendBirthdayWishesActivity$1(SendBirthdayWishesActivity paramSendBirthdayWishesActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004E0A", "0X8004E0A", 0, 0, "", "", "", "");
    this.a.setResult(0);
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.activateFriend.SendBirthdayWishesActivity.1
 * JD-Core Version:    0.7.0.1
 */