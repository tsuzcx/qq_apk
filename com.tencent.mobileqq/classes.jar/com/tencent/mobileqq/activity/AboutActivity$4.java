package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.upgrade.UpgradeController;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper.NewApkInfo;
import com.tencent.mobileqq.upgrade.activity.UpgradeActivity;
import com.tencent.mobileqq.upgrade.activity.UpgradeDetailActivity;
import com.tencent.mobileqq.utils.SPSettings;
import com.tencent.open.downloadnew.MyAppApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import protocol.KQQConfig.UpgradeInfo;

class AboutActivity$4
  implements View.OnClickListener
{
  AboutActivity$4(AboutActivity paramAboutActivity) {}
  
  public void onClick(View paramView)
  {
    MyAppApi.l();
    int i;
    Intent localIntent;
    if (MyAppApi.m())
    {
      if (SPSettings.a()) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X8008FFB", "0X8008FFB", i, 0, "", "", "", "");
      localIntent = new Intent(BaseApplication.getContext(), UpgradeActivity.class);
      localIntent.putExtra("StrTitle", AboutActivity.b(this.a).b.strTitle);
      localIntent.putExtra("StrUpgradeDesc", AboutActivity.b(this.a).b.strUpgradeDesc);
      localIntent.putExtra("iUpgradeType", AboutActivity.b(this.a).b.iUpgradeType);
      localIntent.putExtra("activity_type", 4096);
      if (BaseActivity.sTopActivity != null) {
        BaseActivity.sTopActivity.startActivity(localIntent);
      }
    }
    else if ((AboutActivity.b(this.a).e != null) && (SPSettings.d(AboutActivity.b(this.a).e.d)))
    {
      if (SPSettings.a()) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X8008FFB", "0X8008FFB", i, 0, "", "", "", "");
      localIntent = new Intent(BaseApplication.getContext(), UpgradeActivity.class);
      localIntent.putExtra("StrTitle", AboutActivity.b(this.a).b.strTitle);
      localIntent.putExtra("StrUpgradeDesc", AboutActivity.b(this.a).b.strUpgradeDesc);
      localIntent.putExtra("iUpgradeType", AboutActivity.b(this.a).b.iUpgradeType);
      localIntent.putExtra("activity_type", 4096);
      if (BaseActivity.sTopActivity != null) {
        BaseActivity.sTopActivity.startActivity(localIntent);
      }
    }
    else if ((AboutActivity.b(this.a) != null) && (AboutActivity.b(this.a).b != null))
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004DB2", "0X8004DB2", 0, 0, "", "", UpgradeController.k(), "");
      UpgradeDetailActivity.a(this.a, UpgradeController.a().d(), false, false, true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AboutActivity.4
 * JD-Core Version:    0.7.0.1
 */