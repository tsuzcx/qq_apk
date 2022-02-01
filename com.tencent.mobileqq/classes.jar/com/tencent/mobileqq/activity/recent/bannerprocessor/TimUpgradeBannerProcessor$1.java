package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.upgrade.UpgradeTIMManager;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TimUpgradeBannerProcessor$1
  implements View.OnClickListener
{
  TimUpgradeBannerProcessor$1(TimUpgradeBannerProcessor paramTimUpgradeBannerProcessor, UpgradeTIMWrapper paramUpgradeTIMWrapper) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "UpgradeTIMWrapper click banner, jump");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)TimUpgradeBannerProcessor.a(this.b).getAppRuntime();
    ((UpgradeTIMManager)localQQAppInterface.getManager(QQManagerFactory.TIM_UPGRADE_DOWNLOAD_MANAGER)).a(TimUpgradeBannerProcessor.b(this.b), this.a.h);
    ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8008659", "0X8008659", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.TimUpgradeBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */