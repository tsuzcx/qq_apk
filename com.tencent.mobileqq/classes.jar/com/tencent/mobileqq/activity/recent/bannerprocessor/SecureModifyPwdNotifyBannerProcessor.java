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
  public static final int a;
  
  static
  {
    jdField_a_of_type_Int = BannerTypeCollections.c;
  }
  
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
    return ((ISafeBlockApi)QRoute.api(ISafeBlockApi.class)).initModifyPwdBanner((BaseQQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
  }
  
  public void a()
  {
    BannerManager.a().a(jdField_a_of_type_Int, 0);
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner.a.setVisibility(0);
  }
  
  public void a(AppRuntime paramAppRuntime) {}
  
  public int b()
  {
    return jdField_a_of_type_Int;
  }
  
  public void b()
  {
    BaseQQAppInterface localBaseQQAppInterface;
    if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null) {
      localBaseQQAppInterface = (BaseQQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
    } else {
      localBaseQQAppInterface = null;
    }
    ((ISafeBlockApi)QRoute.api(ISafeBlockApi.class)).updateBarDisplayStatus(localBaseQQAppInterface, System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.SecureModifyPwdNotifyBannerProcessor
 * JD-Core Version:    0.7.0.1
 */