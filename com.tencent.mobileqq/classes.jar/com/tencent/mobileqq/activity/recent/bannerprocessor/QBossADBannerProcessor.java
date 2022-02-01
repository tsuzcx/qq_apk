package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.QbossADBannerConfigInfo;
import com.tencent.mobileqq.activity.recent.QbossADBannerConfigManager;
import com.tencent.mobileqq.activity.recent.QbossADBannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.banner.processor.IBannerViewScroll;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.vip.qqbanner.QbossADBannerCountDownImmersionInfo;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@KeepClassConstructor
public class QBossADBannerProcessor
  extends BaseBannerProcessor
  implements Handler.Callback, IBannerLifecycle, IBannerViewScroll
{
  private QbossADBannerManager a;
  
  public QBossADBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  private void a(Message paramMessage)
  {
    if (AppSetting.d) {}
    do
    {
      return;
      paramMessage = paramMessage.obj;
    } while (!(paramMessage instanceof String));
    ThreadManagerV2.executeOnSubThread(new QBossADBannerProcessor.1(this, (String)paramMessage));
  }
  
  private int b()
  {
    return QzoneConfig.getInstance().getConfig("K_QQ_VAS", "TopBannerRequestDelayInterval", 180);
  }
  
  private void b(Message paramMessage)
  {
    Object localObject = paramMessage.obj;
    if (localObject == null) {
      if (a()) {
        BannerManager.a().a(23, 2, paramMessage);
      }
    }
    while (!(localObject instanceof View[]))
    {
      return;
      BannerManager.a().a(23, 0, null);
      return;
    }
    localObject = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).getHandler(Conversation.class);
    paramMessage = Message.obtain(paramMessage);
    paramMessage.what = 1081;
    ((MqqHandler)localObject).sendMessage(paramMessage);
  }
  
  private void e()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    QbossADBannerConfigInfo localQbossADBannerConfigInfo = QbossADBannerConfigManager.a().a(((QQAppInterface)localObject).getAccount());
    if ((localQbossADBannerConfigInfo != null) && ((localQbossADBannerConfigInfo instanceof QbossADBannerCountDownImmersionInfo))) {
      QbossADBannerConfigManager.a().a((QQAppInterface)localObject, localQbossADBannerConfigInfo, true);
    }
    long l1;
    int i;
    do
    {
      return;
      l1 = ((QQAppInterface)localObject).getLongAccountUin();
      i = b();
    } while (i <= 0);
    long l2 = i;
    localObject = Message.obtain();
    ((Message)localObject).obj = "qboss_banner_pull_refresh";
    ((Message)localObject).what = 3002;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject, l1 % l2 * 1000L);
  }
  
  private void f()
  {
    d();
    ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).getHandler(Conversation.class).sendEmptyMessage(1080);
  }
  
  public int a()
  {
    return super.a();
  }
  
  public View a(Banner paramBanner)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager.a();
    }
    return null;
  }
  
  public void a()
  {
    BannerManager.a().a(23, 0);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager.g();
    }
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (paramMessage != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager.c();
      }
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", 11, 0, "", "", "", "");
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    QbossADBannerManager localQbossADBannerManager = QbossADBannerManager.a((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, BannerManager.a());
    if (localQbossADBannerManager == null) {
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager == null) || (!this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager.getClass().isInstance(localQbossADBannerManager)) || (!localQbossADBannerManager.getClass().isInstance(this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager)))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager = localQbossADBannerManager;
      c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager == null) {
      return false;
    }
    boolean bool = this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager.a();
    QLog.i("QBoss.ADBanner.Manager", 1, "isNeedShowQBossADBanner: " + bool);
    return bool;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager.d();
    }
  }
  
  public void b(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
  }
  
  public void c()
  {
    AppRuntime localAppRuntime = null;
    Banner localBanner = BannerManager.a().a(23);
    if ((localBanner != null) && (localBanner.jdField_a_of_type_AndroidViewView != null) && (localBanner.jdField_a_of_type_Boolean))
    {
      BannerManager.a().a(23, 0, null);
      if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null) {
        localAppRuntime = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime();
      }
      if (localAppRuntime != null) {
        BannerManager.a().b(localAppRuntime, localBanner.jdField_a_of_type_Int);
      }
    }
  }
  
  public void d()
  {
    BannerManager.a().a(23, 0, null);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager.f();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      b(paramMessage);
      continue;
      f();
      continue;
      a(paramMessage);
      continue;
      d();
      continue;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityRecentQbossADBannerManager.h();
        continue;
        e();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.QBossADBannerProcessor
 * JD-Core Version:    0.7.0.1
 */