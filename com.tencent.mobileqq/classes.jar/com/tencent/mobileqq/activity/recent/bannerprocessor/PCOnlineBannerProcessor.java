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
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;

@KeepClassConstructor
public class PCOnlineBannerProcessor
  extends BaseBannerProcessor
{
  public static final int a;
  public long a;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private String c;
  
  static
  {
    jdField_a_of_type_Int = BannerTypeCollections.n;
  }
  
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
    paramBanner.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130839083));
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
    case 2004: 
      this.c = null;
      return;
    case 2003: 
      this.c = paramMessage.getData().getString("pcLoginInfo");
      return;
    case 2002: 
      this.jdField_a_of_type_Long = paramMessage.getData().getLong("loginAppType");
      return;
    case 2001: 
      this.jdField_b_of_type_Int = -1;
      return;
    }
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (!(paramBanner.a instanceof TipsBar)) {
      return;
    }
    paramMessage = (TipsBar)paramBanner.a;
    paramBanner = this.jdField_b_of_type_JavaLangString;
    if ((paramBanner != null) && ("1600000104".equals(paramBanner.trim())))
    {
      paramMessage.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131690753));
      return;
    }
    if ((LoginDevicesUtils.b(this.jdField_b_of_type_Int)) && (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaLangString = "手表QQ已登录";
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramMessage.setTipsText(this.jdField_a_of_type_JavaLangString);
    }
    else
    {
      if (this.jdField_b_of_type_Long == 77313L) {
        paramBanner = "TIM";
      } else {
        paramBanner = "QQ";
      }
      paramMessage.setTipsText(String.format(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131694713), new Object[] { paramBanner }));
    }
    int i = this.jdField_b_of_type_Int;
    if (i == 5) {
      paramMessage.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130839082));
    } else if (LoginDevicesUtils.b(i)) {
      paramMessage.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130839084));
    } else {
      paramMessage.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130839083));
    }
    if (this.jdField_b_of_type_Int == 4) {
      i = 23;
    } else {
      i = 10;
    }
    ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", i, 0, "", "", "", "");
  }
  
  public int b()
  {
    return jdField_a_of_type_Int;
  }
  
  public void b()
  {
    if (BannerManager.a().a(jdField_a_of_type_Int))
    {
      BannerManager.a().a(jdField_a_of_type_Int, 0);
      this.c = null;
      BannerManager.a().b(LoginDevicesBannerProcessor.jdField_a_of_type_Int, 2003);
      this.jdField_b_of_type_Int = -1;
      this.jdField_a_of_type_JavaLangString = null;
      this.jdField_b_of_type_Long = 0L;
      BannerManager.a().a(-1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.PCOnlineBannerProcessor
 * JD-Core Version:    0.7.0.1
 */