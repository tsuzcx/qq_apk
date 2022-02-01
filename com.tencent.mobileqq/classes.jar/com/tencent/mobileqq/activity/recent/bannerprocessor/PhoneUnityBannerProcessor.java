package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.identity.AccountPhoneUnityManager;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;

@KeepClassConstructor
public class PhoneUnityBannerProcessor
  extends BaseBannerProcessor
{
  public PhoneUnityBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(Banner paramBanner)
  {
    return AccountPhoneUnityManager.a((QQAppInterface)this.a.getAppRuntime(), this.a);
  }
  
  public void a()
  {
    BannerManager.a().a(2, 0);
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.PhoneUnityBannerProcessor
 * JD-Core Version:    0.7.0.1
 */