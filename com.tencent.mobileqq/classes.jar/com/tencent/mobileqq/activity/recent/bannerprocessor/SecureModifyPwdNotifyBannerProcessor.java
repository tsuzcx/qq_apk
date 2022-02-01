package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.security.ModifyPwdTopBarHelper;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class SecureModifyPwdNotifyBannerProcessor
  extends BaseBannerProcessor
  implements IBannerLifecycle
{
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
    return ModifyPwdTopBarHelper.a().a((QQAppInterface)this.a.getAppRuntime(), this.a);
  }
  
  public void a()
  {
    BannerManager.a().a(3, 0);
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner.a.setVisibility(0);
  }
  
  public void b()
  {
    if (this.a != null) {}
    for (QQAppInterface localQQAppInterface = (QQAppInterface)this.a.getAppRuntime();; localQQAppInterface = null)
    {
      ModifyPwdTopBarHelper.a().a(localQQAppInterface, System.currentTimeMillis());
      return;
    }
  }
  
  public void b(AppRuntime paramAppRuntime) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.SecureModifyPwdNotifyBannerProcessor
 * JD-Core Version:    0.7.0.1
 */