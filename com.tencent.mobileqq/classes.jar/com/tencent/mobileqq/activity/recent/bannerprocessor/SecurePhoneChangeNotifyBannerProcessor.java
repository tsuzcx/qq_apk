package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.util.SecurePhoneBannerManager;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@KeepClassConstructor
public class SecurePhoneChangeNotifyBannerProcessor
  extends BaseBannerProcessor
  implements Handler.Callback, IBannerLifecycle
{
  public static final int a = BannerTypeCollections.e;
  
  public SecurePhoneChangeNotifyBannerProcessor(QBaseActivity paramQBaseActivity)
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "initSecurePhoneBanner");
    }
    return SecurePhoneBannerManager.a().a((QQAppInterface)this.f.getAppRuntime(), this.f);
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner.c.setVisibility(0);
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
    BannerManager.a().a(a, 0);
    SecurePhoneBannerManager.a().b();
  }
  
  public void d()
  {
    QQAppInterface localQQAppInterface;
    if (this.f != null) {
      localQQAppInterface = (QQAppInterface)this.f.getAppRuntime();
    } else {
      localQQAppInterface = null;
    }
    SecurePhoneBannerManager.a().b(localQQAppInterface, this.f);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 3000) {
      SecurePhoneBannerManager.a().b((QQAppInterface)this.f.getAppRuntime(), this.f);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.SecurePhoneChangeNotifyBannerProcessor
 * JD-Core Version:    0.7.0.1
 */