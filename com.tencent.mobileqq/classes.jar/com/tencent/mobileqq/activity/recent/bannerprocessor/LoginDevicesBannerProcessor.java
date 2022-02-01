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
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class LoginDevicesBannerProcessor
  extends BaseBannerProcessor
{
  public static final int a = BannerTypeCollections.F;
  private long b;
  private String c;
  private String d;
  
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
    paramBanner = new TipsBar(this.f);
    paramBanner.setTipsIcon(this.f.getResources().getDrawable(2130848807));
    paramBanner.a(true);
    paramBanner.setOnClickListener(new LoginDevicesBannerProcessor.1(this));
    return paramBanner;
  }
  
  public void a(Message paramMessage, long paramLong, boolean paramBoolean)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 2003: 
      this.d = null;
      return;
    case 2002: 
      this.d = paramMessage.getData().getString("pcLoginInfo");
      return;
    case 2001: 
      this.b = paramMessage.getData().getLong("loginDevAppid");
      return;
    }
    d();
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (!(paramBanner.c instanceof TipsBar)) {
      return;
    }
    if (this.f.getAppRuntime() == null) {
      return;
    }
    paramBanner = (TipsBar)paramBanner.c;
    paramMessage = (LoginDevicesManager)this.f.getAppRuntime().getManager(QQManagerFactory.LOGIN_DEVICES_MANAGER);
    String str = paramMessage.a();
    if (TextUtils.isEmpty(str))
    {
      d();
      return;
    }
    paramBanner.setTipsText(str);
    int i = paramMessage.b();
    if (i == 1)
    {
      paramBanner.setTipsIcon(this.f.getResources().getDrawable(2130848809));
      return;
    }
    if (i == 2)
    {
      paramBanner.setTipsIcon(this.f.getResources().getDrawable(2130848808));
      return;
    }
    if (i == 3)
    {
      paramBanner.setTipsIcon(this.f.getResources().getDrawable(2130848810));
      return;
    }
    paramBanner.setTipsIcon(this.f.getResources().getDrawable(2130848807));
  }
  
  public int b()
  {
    return a;
  }
  
  public void c()
  {
    d();
  }
  
  public void d()
  {
    if (BannerManager.a().c(a))
    {
      this.d = null;
      BannerManager.a().b(PCOnlineBannerProcessor.a, 2004);
      BannerManager.a().a(a, 0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.LoginDevicesBannerProcessor
 * JD-Core Version:    0.7.0.1
 */