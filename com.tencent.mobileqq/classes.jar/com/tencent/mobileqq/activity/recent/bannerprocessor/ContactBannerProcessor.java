package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@KeepClassConstructor
public class ContactBannerProcessor
  extends BaseBannerProcessor
  implements Handler.Callback, IBannerLifecycle
{
  public static final int a = BannerTypeCollections.r;
  public boolean b = false;
  public IPhoneContactListener c;
  
  public ContactBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
    this.g = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = new TipsBar(this.f);
    int i;
    if (QQTheme.isNowSimpleUI()) {
      i = 2130846442;
    } else {
      i = 2130846441;
    }
    paramBanner.setTipsIcon(this.f.getResources().getDrawable(i));
    paramBanner.setTipsText(this.f.getString(2131896672));
    paramBanner.setOnClickListener(new ContactBannerProcessor.1(this));
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (!(paramBanner.c instanceof TipsBar)) {
      return;
    }
    paramBanner = (TipsBar)paramBanner.c;
    int i;
    if (QQTheme.isNowSimpleUI()) {
      i = 2130846442;
    } else {
      i = 2130846441;
    }
    paramBanner.setTipsIcon(this.f.getResources().getDrawable(i));
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.b = true;
    if ((this.c != null) && (paramAppRuntime != null))
    {
      ((IPhoneContactService)paramAppRuntime.getRuntimeService(IPhoneContactService.class, "")).removeListener(this.c);
      this.c = null;
    }
    this.g.removeCallbacksAndMessages(null);
  }
  
  public void a(boolean paramBoolean)
  {
    if (BannerManager.a().a(a) != null) {
      BannerManager.a().a(a, 0);
    }
    this.g.removeMessages(1000);
    if (paramBoolean)
    {
      Object localObject = (IPhoneContactService)this.f.getAppRuntime().getRuntimeService(IPhoneContactService.class, "");
      if (localObject != null)
      {
        int i = ((IPhoneContactService)localObject).getBannerState();
        if (i == 0)
        {
          this.g.sendEmptyMessageDelayed(1000, 1000L);
          return;
        }
        if ((this.c == null) && (!this.b))
        {
          this.c = new ContactBannerProcessor.2(this);
          ((IPhoneContactService)localObject).addListener(this.c);
        }
        localObject = this.f;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("contact_bind_info");
        localStringBuilder.append(this.f.getAppRuntime().getAccount());
        paramBoolean = ((QBaseActivity)localObject).getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("key_show_contact_banner", true);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("checkContactBanner, state = ");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append(", isFirstShow = ");
          ((StringBuilder)localObject).append(paramBoolean);
          QLog.d("Q.recent.banner", 2, ((StringBuilder)localObject).toString());
        }
        if ((i == 1) && (paramBoolean))
        {
          if ((BannerManager.a().a(a) != null) && (BannerManager.a().a(a).b != 2)) {
            ReportController.b(this.f.getAppRuntime(), "CliOper", "", "", "0X80053D8", "0X80053D8", 0, 0, "", "", "", "");
          }
          BannerManager.a().a(a, 2);
          ReportController.a(this.f.getAppRuntime(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", 13, 0, "", "", "", "");
          return;
        }
        BannerManager.a().a(a, 0);
      }
    }
    else
    {
      this.g.removeMessages(1000);
      this.g.sendEmptyMessageDelayed(1000, 1000L);
    }
  }
  
  public int b()
  {
    return a;
  }
  
  public void b(AppRuntime paramAppRuntime)
  {
    BannerManager.a().a(a, 0);
    this.g.removeMessages(1000);
    if ((this.c != null) && (paramAppRuntime != null))
    {
      ((IPhoneContactService)paramAppRuntime.getRuntimeService(IPhoneContactService.class, "")).removeListener(this.c);
      this.c = null;
    }
  }
  
  public void c()
  {
    a(false);
  }
  
  public void d() {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000)
    {
      a(true);
      return true;
    }
    if (paramMessage.what == 2000) {
      a(paramMessage.getData().getBoolean("rightNow"));
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.ContactBannerProcessor
 * JD-Core Version:    0.7.0.1
 */