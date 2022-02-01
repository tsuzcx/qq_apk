package com.tencent.mobileqq.activity.recent.bannerprocessor;

import MWIFI.SCGet3rdCloudCheck;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class WifiSecurityCheckBannerProcessor$1
  implements View.OnClickListener
{
  WifiSecurityCheckBannerProcessor$1(WifiSecurityCheckBannerProcessor paramWifiSecurityCheckBannerProcessor, SCGet3rdCloudCheck paramSCGet3rdCloudCheck) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "updateWiFiSecurityBanner, onClick");
    }
    FreeWifiHelper.a(WifiSecurityCheckBannerProcessor.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorWifiSecurityCheckBannerProcessor), this.jdField_a_of_type_MWIFISCGet3rdCloudCheck);
    WifiSecurityCheckBannerProcessor.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorWifiSecurityCheckBannerProcessor).removeMessages(1000);
    WifiSecurityCheckBannerProcessor.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorWifiSecurityCheckBannerProcessor).obtainMessage(1000).sendToTarget();
    ReportController.a(WifiSecurityCheckBannerProcessor.b(this.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerprocessorWifiSecurityCheckBannerProcessor).getAppRuntime(), "dc00898", "", "", "0X8009EE2", "0X8009EE2", 6, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.WifiSecurityCheckBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */