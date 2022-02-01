package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TimUpgradeBannerProcessor$2
  implements View.OnClickListener
{
  TimUpgradeBannerProcessor$2(TimUpgradeBannerProcessor paramTimUpgradeBannerProcessor, UpgradeTIMWrapper paramUpgradeTIMWrapper) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "UpgradeTIMWrapper close banner");
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)TimUpgradeBannerProcessor.c(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorTimUpgradeBannerProcessor).getAppRuntime();
    this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMWrapper.a();
    UpgradeTIMWrapper.a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqUpgradeUpgradeTIMWrapper);
    BannerManager.a().a(29, 0, null);
    ReportController.b(localQQAppInterface, "CliOper", "", "", "0X800865A", "0X800865A", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.TimUpgradeBannerProcessor.2
 * JD-Core Version:    0.7.0.1
 */