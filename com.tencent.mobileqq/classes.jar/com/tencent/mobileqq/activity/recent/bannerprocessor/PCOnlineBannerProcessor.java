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
  public static final int a = BannerTypeCollections.n;
  public long b;
  private long c;
  private boolean d = false;
  private String e;
  private int h;
  private String i;
  private String j;
  
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
    paramBanner = new TipsBar(this.f);
    paramBanner.setTipsIcon(this.f.getResources().getDrawable(2130839238));
    paramBanner.b(true);
    paramBanner.setCloseListener(new PCOnlineBannerProcessor.1(this));
    paramBanner.setOnClickListener(new PCOnlineBannerProcessor.2(this));
    return paramBanner;
  }
  
  public void a(Message paramMessage, long paramLong, boolean paramBoolean)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    case 2004: 
      this.j = null;
      return;
    case 2003: 
      this.j = paramMessage.getData().getString("pcLoginInfo");
      return;
    case 2002: 
      this.b = paramMessage.getData().getLong("loginAppType");
      return;
    case 2001: 
      this.h = -1;
      return;
    }
    this.e = null;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (!(paramBanner.c instanceof TipsBar)) {
      return;
    }
    paramMessage = (TipsBar)paramBanner.c;
    paramBanner = this.i;
    if ((paramBanner != null) && ("1600000104".equals(paramBanner.trim())))
    {
      paramMessage.setTipsText(this.f.getString(2131887673));
      return;
    }
    if ((LoginDevicesUtils.b(this.h)) && (TextUtils.isEmpty(this.e))) {
      this.e = "手表QQ已登录";
    }
    if (!TextUtils.isEmpty(this.e))
    {
      paramMessage.setTipsText(this.e);
    }
    else
    {
      if (this.c == 77313L) {
        paramBanner = "TIM";
      } else {
        paramBanner = "QQ";
      }
      paramMessage.setTipsText(String.format(this.f.getString(2131892410), new Object[] { paramBanner }));
    }
    int k = this.h;
    if (k == 5) {
      paramMessage.setTipsIcon(this.f.getResources().getDrawable(2130839237));
    } else if (LoginDevicesUtils.b(k)) {
      paramMessage.setTipsIcon(this.f.getResources().getDrawable(2130839239));
    } else {
      paramMessage.setTipsIcon(this.f.getResources().getDrawable(2130839238));
    }
    if (this.h == 4) {
      k = 23;
    } else {
      k = 10;
    }
    ReportController.a(this.f.getAppRuntime(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", k, 0, "", "", "", "");
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
      BannerManager.a().a(a, 0);
      this.j = null;
      BannerManager.a().b(LoginDevicesBannerProcessor.a, 2003);
      this.h = -1;
      this.e = null;
      this.c = 0L;
      BannerManager.a().a(-1, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.PCOnlineBannerProcessor
 * JD-Core Version:    0.7.0.1
 */