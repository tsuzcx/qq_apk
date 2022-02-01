package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.res.Resources;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.upgrade.UpgradeTIMWrapper;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@KeepClassConstructor
public class TimUpgradeBannerProcessor
  extends BaseBannerProcessor
  implements Handler.Callback, IBannerLifecycle
{
  public static final int a = BannerTypeCollections.D;
  public boolean b = false;
  public boolean c = false;
  
  public TimUpgradeBannerProcessor(QBaseActivity paramQBaseActivity)
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
    paramBanner.setTipsIcon(this.f.getResources().getDrawable(2130853154));
    paramBanner.b(true);
    UpgradeTIMWrapper localUpgradeTIMWrapper = UpgradeTIMWrapper.a((QQAppInterface)this.f.getAppRuntime());
    paramBanner.setTipsText(localUpgradeTIMWrapper.g);
    paramBanner.setOnClickListener(new TimUpgradeBannerProcessor.1(this, localUpgradeTIMWrapper));
    paramBanner.setCloseListener(new TimUpgradeBannerProcessor.2(this, localUpgradeTIMWrapper));
    paramBanner.setVisibility(8);
    return paramBanner;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner = (TipsBar)paramBanner.c;
    paramBanner.setVisibility(0);
    if ((paramMessage != null) && (paramMessage.obj != null)) {
      paramBanner.setTipsText(((UpgradeTIMWrapper)paramMessage.obj).g);
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.g.removeCallbacksAndMessages(null);
  }
  
  public int b()
  {
    return a;
  }
  
  public void c()
  {
    this.b = false;
    this.c = false;
  }
  
  public void d() {}
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 3000)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "UpgradeTIMWrapper MSG_TIM_UPGRADE_BAR_HIDE");
      }
      UpgradeTIMWrapper localUpgradeTIMWrapper = UpgradeTIMWrapper.a((QQAppInterface)this.f.getAppRuntime());
      localUpgradeTIMWrapper.b();
      UpgradeTIMWrapper.a((QQAppInterface)this.f.getAppRuntime(), localUpgradeTIMWrapper);
      BannerManager.a().a(a, 0, paramMessage);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.TimUpgradeBannerProcessor
 * JD-Core Version:    0.7.0.1
 */