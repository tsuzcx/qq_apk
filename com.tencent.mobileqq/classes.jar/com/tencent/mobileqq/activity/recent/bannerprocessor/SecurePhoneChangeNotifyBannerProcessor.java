package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
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
  public SecurePhoneChangeNotifyBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this);
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
    return SecurePhoneBannerManager.a().a((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
  }
  
  public void a()
  {
    BannerManager.a().a(5, 0);
    SecurePhoneBannerManager.a().a();
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    paramBanner.a.setVisibility(0);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null) {}
    for (QQAppInterface localQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();; localQQAppInterface = null)
    {
      SecurePhoneBannerManager.a().a(localQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      return;
    }
  }
  
  public void b(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 3000) {
      SecurePhoneBannerManager.a().a((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.SecurePhoneChangeNotifyBannerProcessor
 * JD-Core Version:    0.7.0.1
 */