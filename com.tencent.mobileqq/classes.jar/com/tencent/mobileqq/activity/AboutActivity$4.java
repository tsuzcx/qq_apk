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
    MyAppApi.a();
    int i;
    Intent localIntent;
    if (MyAppApi.b())
    {
      if (SPSettings.a()) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X8008FFB", "0X8008FFB", i, 0, "", "", "", "");
      localIntent = new Intent(BaseApplication.getContext(), UpgradeActivity.class);
      localIntent.putExtra("StrTitle", AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strTitle);
      localIntent.putExtra("StrUpgradeDesc", AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc);
      localIntent.putExtra("iUpgradeType", AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType);
      localIntent.putExtra("activity_type", 4096);
      if (BaseActivity.sTopActivity != null) {
        BaseActivity.sTopActivity.startActivity(localIntent);
      }
    }
    else if ((AboutActivity.a(this.a).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo != null) && (SPSettings.a(AboutActivity.a(this.a).jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeDetailWrapper$NewApkInfo.a)))
    {
      if (SPSettings.a()) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X8008FFB", "0X8008FFB", i, 0, "", "", "", "");
      localIntent = new Intent(BaseApplication.getContext(), UpgradeActivity.class);
      localIntent.putExtra("StrTitle", AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strTitle);
      localIntent.putExtra("StrUpgradeDesc", AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.strUpgradeDesc);
      localIntent.putExtra("iUpgradeType", AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo.iUpgradeType);
      localIntent.putExtra("activity_type", 4096);
      if (BaseActivity.sTopActivity != null) {
        BaseActivity.sTopActivity.startActivity(localIntent);
      }
    }
    else if ((AboutActivity.a(this.a) != null) && (AboutActivity.a(this.a).jdField_a_of_type_ProtocolKQQConfigUpgradeInfo != null))
    {
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004DB2", "0X8004DB2", 0, 0, "", "", UpgradeController.a(), "");
      UpgradeDetailActivity.a(this.a, UpgradeController.a().a(), false, false, true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AboutActivity.4
 * JD-Core Version:    0.7.0.1
 */