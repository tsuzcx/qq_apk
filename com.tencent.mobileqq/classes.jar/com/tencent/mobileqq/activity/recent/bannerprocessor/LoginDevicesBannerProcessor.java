package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qrcode.logindev.LoginDevicesManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class LoginDevicesBannerProcessor
  extends BaseBannerProcessor
{
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public LoginDevicesBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    paramBanner.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130847355));
    paramBanner.a(true);
    paramBanner.setOnClickListener(new LoginDevicesBannerProcessor.1(this));
    return paramBanner;
  }
  
  public void a()
  {
    b();
  }
  
  public void a(Message paramMessage, long paramLong, boolean paramBoolean)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 2000: 
      b();
      return;
    case 2001: 
      this.jdField_a_of_type_Long = paramMessage.getData().getLong("loginDevAppid");
      return;
    case 2002: 
      this.b = paramMessage.getData().getString("pcLoginInfo");
      return;
    }
    this.b = null;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (!(paramBanner.a instanceof TipsBar)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime() == null) {
      return;
    }
    paramBanner = (TipsBar)paramBanner.a;
    paramMessage = (LoginDevicesManager)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getManager(QQManagerFactory.LOGIN_DEVICES_MANAGER);
    String str = paramMessage.a();
    if (TextUtils.isEmpty(str))
    {
      b();
      return;
    }
    paramBanner.setTipsText(str);
    int i = paramMessage.a();
    if (i == 1)
    {
      paramBanner.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130847357));
      return;
    }
    if (i == 2)
    {
      paramBanner.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130847356));
      return;
    }
    if (i == 3)
    {
      paramBanner.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130847358));
      return;
    }
    paramBanner.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130847355));
  }
  
  public void b()
  {
    if (BannerManager.a().a(31))
    {
      this.b = null;
      BannerManager.a().b(14, 2004);
      BannerManager.a().a(31, 0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.LoginDevicesBannerProcessor
 * JD-Core Version:    0.7.0.1
 */