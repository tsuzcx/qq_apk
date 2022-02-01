package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AboutActivity$1
  implements View.OnClickListener
{
  AboutActivity$1(AboutActivity paramAboutActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
    localIntent.putExtra("uin", this.a.app.getCurrentAccountUin());
    AboutActivity localAboutActivity = this.a;
    localAboutActivity.startActivity(localIntent.putExtra("url", AboutActivity.a(localAboutActivity)));
    ReportController.b(this.a.app, "CliOper", "", "", "0X8005745", "0X8005745", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AboutActivity.1
 * JD-Core Version:    0.7.0.1
 */