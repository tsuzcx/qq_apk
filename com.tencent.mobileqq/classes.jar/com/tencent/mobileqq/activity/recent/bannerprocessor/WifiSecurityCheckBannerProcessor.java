package com.tencent.mobileqq.activity.recent.bannerprocessor;

import MWIFI.SCGet3rdCloudCheck;
import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@KeepClassConstructor
public class WifiSecurityCheckBannerProcessor
  extends BaseBannerProcessor
  implements Handler.Callback, IBannerLifecycle
{
  public WifiSecurityCheckBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  public int a()
  {
    return 4;
  }
  
  public View a(Banner paramBanner)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "initWiFiSecurityBanner");
    }
    paramBanner = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    paramBanner.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130838388));
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner = (TipsBar)paramBanner.a;
    if (paramMessage == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "updateWiFiSecurityBanner");
    }
    paramMessage = (SCGet3rdCloudCheck)paramMessage.obj;
    paramBanner.setTipsText(paramMessage.tips);
    paramBanner.setOnClickListener(new WifiSecurityCheckBannerProcessor.1(this, paramMessage));
    paramBanner.setVisibility(0);
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", 6, 0, "", "", "", "");
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1000);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1000, 7000L);
    paramBanner = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getApplicationContext();
    if (paramMessage.tipsType == 2) {}
    for (int i = 398680;; i = 398678)
    {
      FreeWifiHelper.b(paramBanner, i);
      return;
    }
  }
  
  public void b() {}
  
  public void b(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "handler msg MSG_HIDE_WIFI_SECURITY_CHECK");
      }
      BannerManager.a().a(4, 0, paramMessage);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.WifiSecurityCheckBannerProcessor
 * JD-Core Version:    0.7.0.1
 */