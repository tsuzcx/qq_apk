package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.TipsBar;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.model.PhoneContactManager.IPhoneContactListener;
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
  public PhoneContactManager.IPhoneContactListener a;
  public boolean a;
  
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
    paramBanner.setTipsIcon(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130845128));
    paramBanner.setTipsText(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(2131698648));
    paramBanner.setOnClickListener(new ContactBannerProcessor.1(this));
    return paramBanner;
  }
  
  public void a()
  {
    a(false);
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    BannerManager.a().a(18, 0);
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1000);
    if ((this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener != null) && (paramAppRuntime != null))
    {
      ((PhoneContactManagerImp)paramAppRuntime.getManager(QQManagerFactory.CONTACT_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener);
      this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener = null;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (BannerManager.a().a(18) != null) {
      BannerManager.a().a(18, 0);
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1000);
    if (paramBoolean)
    {
      PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getManager(QQManagerFactory.CONTACT_MANAGER);
      int i;
      if (localPhoneContactManagerImp != null)
      {
        i = localPhoneContactManagerImp.b();
        if (i == 0) {
          this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1000, 1000L);
        }
      }
      else
      {
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener == null) && (!this.jdField_a_of_type_Boolean))
      {
        this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener = new ContactBannerProcessor.2(this);
        localPhoneContactManagerImp.a(this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener);
      }
      paramBoolean = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getSharedPreferences("contact_bind_info" + this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime().getAccount(), 0).getBoolean("key_show_contact_banner", true);
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent.banner", 2, "checkContactBanner, state = " + i + ", isFirstShow = " + paramBoolean);
      }
      if ((i == 1) && (paramBoolean))
      {
        if ((BannerManager.a().a(18) != null) && (BannerManager.a().a(18).b != 2)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "CliOper", "", "", "0X80053D8", "0X80053D8", 0, 0, "", "", "", "");
        }
        BannerManager.a().a(18, 2);
        ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", 13, 0, "", "", "", "");
        return;
      }
      BannerManager.a().a(18, 0);
      return;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(1000);
    this.jdField_a_of_type_MqqOsMqqHandler.sendEmptyMessageDelayed(1000, 1000L);
  }
  
  public void b() {}
  
  public void b(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_Boolean = true;
    if ((this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener != null) && (paramAppRuntime != null))
    {
      ((PhoneContactManagerImp)paramAppRuntime.getManager(QQManagerFactory.CONTACT_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener);
      this.jdField_a_of_type_ComTencentMobileqqModelPhoneContactManager$IPhoneContactListener = null;
    }
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1000) {
      a(true);
    }
    while (paramMessage.what != 2000) {
      return true;
    }
    a(paramMessage.getData().getBoolean("rightNow"));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.ContactBannerProcessor
 * JD-Core Version:    0.7.0.1
 */