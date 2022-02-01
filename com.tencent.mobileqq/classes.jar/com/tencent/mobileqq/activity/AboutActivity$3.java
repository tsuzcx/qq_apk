package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.managers.TimUpgradeHongdianManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.upgrade.UpgradeTIMManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AboutActivity$3
  implements View.OnClickListener
{
  AboutActivity$3(AboutActivity paramAboutActivity, TimUpgradeHongdianManager paramTimUpgradeHongdianManager) {}
  
  public void onClick(View paramView)
  {
    if (!TextUtils.isEmpty(this.a.e))
    {
      ((UpgradeTIMManager)this.b.app.getManager(QQManagerFactory.TIM_UPGRADE_DOWNLOAD_MANAGER)).a(this.b, this.a.e);
      ReportController.b(this.b.app, "CliOper", "", "", "0X800865C", "0X800865C", 0, 0, "", "", "", "");
    }
    this.a.b();
    AboutActivity.a(this.b, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AboutActivity.3
 * JD-Core Version:    0.7.0.1
 */