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
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@KeepClassConstructor
public class ContactBannerProcessor
  extends BaseBannerProcessor
  implements Handler.Callback, IBannerLifecycle
{
  public static final int a;
  public IPhoneContactListener a;
  public boolean a;
  
  static
  {
    jdField_a_of_type_Int = BannerTypeCollections.r;
  }
  
  public ContactBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  public int a()
  {
    return 2;
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = new TipsBar(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    paramBanner.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130845005));
    paramBanner.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131698714));
    paramBanner.setOnClickListener(new ContactBannerProcessor.1(this));
    return paramBanner;
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_Boolean = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqPhonecontactListenerIPhoneContactListener != null) && (paramAppRuntime != null))
    {
      ((IPhoneContactService)paramAppRuntime.getRuntimeService(IPhoneContactService.class, "")).removeListener(this.jdField_a_of_type_ComTencentMobileqqPhonecontactListenerIPhoneContactListener);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactListenerIPhoneContactListener = null;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
  
  public void a(boolean paramBoolean)
  {
    if (BannerManager.a().a(jdField_a_of_type_Int) != null) {
      BannerManager.a().a(jdField_a_of_type_Int, 0);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1000);
    if (paramBoolean)
    {
      Object localObject = (IPhoneContactService)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getRuntimeService(IPhoneContactService.class, "");
      if (localObject != null)
      {
        int i = ((IPhoneContactService)localObject).getBannerState();
        if (i == 0)
        {
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1000, 1000L);
          return;
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqPhonecontactListenerIPhoneContactListener == null) && (!this.jdField_a_of_type_Boolean))
        {
          this.jdField_a_of_type_ComTencentMobileqqPhonecontactListenerIPhoneContactListener = new ContactBannerProcessor.2(this);
          ((IPhoneContactService)localObject).addListener(this.jdField_a_of_type_ComTencentMobileqqPhonecontactListenerIPhoneContactListener);
        }
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("contact_bind_info");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getAccount());
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
          if ((BannerManager.a().a(jdField_a_of_type_Int) != null) && (BannerManager.a().a(jdField_a_of_type_Int).b != 2)) {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "CliOper", "", "", "0X80053D8", "0X80053D8", 0, 0, "", "", "", "");
          }
          BannerManager.a().a(jdField_a_of_type_Int, 2);
          ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", 13, 0, "", "", "", "");
          return;
        }
        BannerManager.a().a(jdField_a_of_type_Int, 0);
      }
    }
    else
    {
      this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1000);
      this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1000, 1000L);
    }
  }
  
  public int b()
  {
    return jdField_a_of_type_Int;
  }
  
  public void b() {}
  
  public void b(AppRuntime paramAppRuntime)
  {
    BannerManager.a().a(jdField_a_of_type_Int, 0);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1000);
    if ((this.jdField_a_of_type_ComTencentMobileqqPhonecontactListenerIPhoneContactListener != null) && (paramAppRuntime != null))
    {
      ((IPhoneContactService)paramAppRuntime.getRuntimeService(IPhoneContactService.class, "")).removeListener(this.jdField_a_of_type_ComTencentMobileqqPhonecontactListenerIPhoneContactListener);
      this.jdField_a_of_type_ComTencentMobileqqPhonecontactListenerIPhoneContactListener = null;
    }
  }
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.ContactBannerProcessor
 * JD-Core Version:    0.7.0.1
 */