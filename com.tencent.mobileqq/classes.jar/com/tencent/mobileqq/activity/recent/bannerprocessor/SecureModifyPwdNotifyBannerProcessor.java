package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class SecureModifyPwdNotifyBannerProcessor
  extends BaseBannerProcessor
  implements IBannerLifecycle
{
  public static final int a = BannerTypeCollections.c;
  
  public SecureModifyPwdNotifyBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(Banner paramBanner)
  {
    return ((ISafeBlockApi)QRoute.api(ISafeBlockApi.class)).initModifyPwdBanner((BaseQQAppInterface)this.f.getAppRuntime(), this.f);
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner.c.setVisibility(0);
  }
  
  public void a(AppRuntime paramAppRuntime) {}
  
  public int b()
  {
    return a;
  }
  
  public void c()
  {
    BannerManager.a().a(a, 0);
  }
  
  public void d()
  {
    BaseQQAppInterface localBaseQQAppInterface;
    if (this.f != null) {
      localBaseQQAppInterface = (BaseQQAppInterface)this.f.getAppRuntime();
    } else {
      localBaseQQAppInterface = null;
    }
    ((ISafeBlockApi)QRoute.api(ISafeBlockApi.class)).updateBarDisplayStatus(localBaseQQAppInterface, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.SecureModifyPwdNotifyBannerProcessor
 * JD-Core Version:    0.7.0.1
 */