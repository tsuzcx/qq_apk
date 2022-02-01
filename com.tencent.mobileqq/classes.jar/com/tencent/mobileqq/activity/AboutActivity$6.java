package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.config.AboutConfig;
import com.tencent.mobileqq.data.ResourcePluginInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AboutActivity$6
  implements View.OnClickListener
{
  AboutActivity$6(AboutActivity paramAboutActivity, ResourcePluginInfo paramResourcePluginInfo, FormSimpleItem paramFormSimpleItem) {}
  
  public void onClick(View paramView)
  {
    AboutConfig.a(this.c.app, this.c, this.a);
    if (this.a.strPkgName.equals("com.tencent.Feedback_5_8")) {
      ReportController.b(this.c.app, "CliOper", "", "", "0X8005742", "0X8005742", 0, 0, "", "", "", "");
    } else if (this.a.strPkgName.equals("com.tencent.help_5_8")) {
      ReportController.b(this.c.app, "CliOper", "", "", "0X8005741", "0X8005741", 0, 0, "", "", "", "");
    } else if (this.a.strPkgName.equals("com.tx.aboutfunction_8_0_3")) {
      ReportController.b(this.c.app, "CliOper", "", "", "0X8005744", "0X8005744", 0, 0, "", "", "", "");
    } else if (this.a.strPkgName.equals("com.tx.aboutimage")) {
      ReportController.b(this.c.app, "CliOper", "", "", "0X8005743", "0X8005743", 0, 0, "", "", "", "");
    }
    this.b.setRightIcon(null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AboutActivity.6
 * JD-Core Version:    0.7.0.1
 */