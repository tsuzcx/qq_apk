package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qrcode.logindev.LoginDevicesUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;

@KeepClassConstructor
public class PCOnlineBannerProcessor
  extends BaseBannerProcessor
{
  private int jdField_a_of_type_Int;
  public long a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  public PCOnlineBannerProcessor(QBaseActivity paramQBaseActivity)
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
    paramBanner.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130839229));
    paramBanner.b(true);
    paramBanner.setCloseListener(new PCOnlineBannerProcessor.1(this));
    paramBanner.setOnClickListener(new PCOnlineBannerProcessor.2(this));
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
      this.jdField_a_of_type_JavaLangString = null;
      return;
    case 2001: 
      this.jdField_a_of_type_Int = -1;
      return;
    case 2002: 
      this.jdField_a_of_type_Long = paramMessage.getData().getLong("loginAppType");
      return;
    case 2003: 
      this.c = paramMessage.getData().getString("pcLoginInfo");
      return;
    }
    this.c = null;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (!(paramBanner.a instanceof TipsBar)) {
      return;
    }
    paramMessage = (TipsBar)paramBanner.a;
    if ((this.jdField_b_of_type_JavaLangString != null) && ("1600000104".equals(this.jdField_b_of_type_JavaLangString.trim())))
    {
      paramMessage.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131690825));
      return;
    }
    if ((LoginDevicesUtils.b(this.jdField_a_of_type_Int)) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaLangString = "手表QQ已登录";
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramMessage.setTipsText(this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Int != 5) {
        break label209;
      }
      paramMessage.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130839228));
      label123:
      if (this.jdField_a_of_type_Int != 4) {
        break label257;
      }
    }
    label257:
    for (int i = 23;; i = 10)
    {
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", i, 0, "", "", "", "");
      return;
      paramBanner = "QQ";
      if (this.jdField_b_of_type_Long == 77313L) {
        paramBanner = "TIM";
      }
      paramMessage.setTipsText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131694734), new Object[] { paramBanner }));
      break;
      label209:
      if (LoginDevicesUtils.b(this.jdField_a_of_type_Int))
      {
        paramMessage.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130839230));
        break label123;
      }
      paramMessage.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130839229));
      break label123;
    }
  }
  
  public void b()
  {
    if (BannerManager.a().a(14))
    {
      BannerManager.a().a(14, 0);
      this.c = null;
      BannerManager.a().b(31, 2003);
      this.jdField_a_of_type_Int = -1;
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_b_of_type_Long = 0L;
      BannerManager.a().a(-1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.PCOnlineBannerProcessor
 * JD-Core Version:    0.7.0.1
 */