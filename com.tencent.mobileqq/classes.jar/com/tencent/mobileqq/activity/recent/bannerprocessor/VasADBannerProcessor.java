package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.banner.Banner;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.mobileqq.banner.BannerTypeCollections;
import com.tencent.mobileqq.banner.processor.BaseBannerProcessor;
import com.tencent.mobileqq.banner.processor.IBannerLifecycle;
import com.tencent.mobileqq.banner.processor.IBannerViewScroll;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.vip.ad.TianshuBannerManager;
import cooperation.vip.qqbanner.info.VasADBannerConfigInfo;
import cooperation.vip.qqbanner.info.VasADBannerCountDownImmersionInfo;
import cooperation.vip.qqbanner.manager.VasADBannerManager;
import cooperation.vip.qqbanner.manager.VasADBannerResDownloadManager;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

@KeepClassConstructor
public class VasADBannerProcessor
  extends BaseBannerProcessor
  implements Handler.Callback, IBannerLifecycle, IBannerViewScroll
{
  public static final int a;
  private TianshuBannerManager jdField_a_of_type_CooperationVipAdTianshuBannerManager;
  private VasADBannerManager jdField_a_of_type_CooperationVipQqbannerManagerVasADBannerManager;
  
  static
  {
    jdField_a_of_type_Int = BannerTypeCollections.w;
  }
  
  public VasADBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
    this.jdField_a_of_type_MqqOsMqqHandler = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  private void a(Message paramMessage)
  {
    if (AppSetting.d) {
      return;
    }
    if (this.jdField_a_of_type_CooperationVipAdTianshuBannerManager == null) {
      this.jdField_a_of_type_CooperationVipAdTianshuBannerManager = new TianshuBannerManager((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    }
    TianshuBannerManager localTianshuBannerManager = this.jdField_a_of_type_CooperationVipAdTianshuBannerManager;
    if (localTianshuBannerManager != null) {
      localTianshuBannerManager.a((String)paramMessage.obj);
    }
  }
  
  private void b(Message paramMessage)
  {
    Object localObject = paramMessage.obj;
    if (localObject == null)
    {
      if (a())
      {
        BannerManager.a().a(jdField_a_of_type_Int, 2, paramMessage);
        return;
      }
      BannerManager.a().a(jdField_a_of_type_Int, 0, null);
      return;
    }
    if ((localObject instanceof View[]))
    {
      localObject = ((QQAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).getHandler(Conversation.class);
      paramMessage = Message.obtain(paramMessage);
      paramMessage.what = 1081;
      ((MqqHandler)localObject).sendMessage(paramMessage);
    }
  }
  
  private int c()
  {
    return QzoneConfig.getInstance().getConfig("K_QQ_VAS", "TopBannerRequestDelayInterval", 180);
  }
  
  private void e()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    VasADBannerConfigInfo localVasADBannerConfigInfo = VasADBannerResDownloadManager.a().a(((QQAppInterface)localObject).getAccount());
    if ((localVasADBannerConfigInfo instanceof VasADBannerCountDownImmersionInfo))
    {
      VasADBannerResDownloadManager.a().b((QQAppInterface)localObject, localVasADBannerConfigInfo);
      return;
    }
    long l1 = ((QQAppInterface)localObject).getLongAccountUin();
    int i = c();
    if (i > 0)
    {
      long l2 = i;
      localObject = Message.obtain();
      ((Message)localObject).obj = "vas_banner_pull_refresh";
      ((Message)localObject).what = 3002;
      this.jdField_a_of_type_MqqOsMqqHandler.sendMessageDelayed((Message)localObject, l1 % l2 * 1000L);
    }
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
    paramBanner = this.jdField_a_of_type_CooperationVipQqbannerManagerVasADBannerManager;
    if (paramBanner != null) {
      return paramBanner.a();
    }
    return null;
  }
  
  public void a()
  {
    BannerManager.a().a(jdField_a_of_type_Int, 0);
    Object localObject = this.jdField_a_of_type_CooperationVipQqbannerManagerVasADBannerManager;
    if (localObject != null) {
      ((VasADBannerManager)localObject).f();
    }
    if (this.jdField_a_of_type_CooperationVipAdTianshuBannerManager != null)
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      this.jdField_a_of_type_CooperationVipAdTianshuBannerManager.a((QQAppInterface)localObject);
    }
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (paramMessage != null)
    {
      paramBanner = this.jdField_a_of_type_CooperationVipQqbannerManagerVasADBannerManager;
      if (paramBanner != null) {
        paramBanner.d();
      }
      ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", 11, 0, "", "", "", "");
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacksAndMessages(null);
    paramAppRuntime = this.jdField_a_of_type_CooperationVipAdTianshuBannerManager;
    if (paramAppRuntime != null) {
      paramAppRuntime.a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    VasADBannerManager localVasADBannerManager = this.jdField_a_of_type_CooperationVipQqbannerManagerVasADBannerManager;
    if (localVasADBannerManager != null) {
      localVasADBannerManager.a(paramBoolean);
    }
  }
  
  public boolean a()
  {
    Object localObject = VasADBannerManager.a((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, BannerManager.a());
    if (localObject == null) {
      return false;
    }
    VasADBannerManager localVasADBannerManager = this.jdField_a_of_type_CooperationVipQqbannerManagerVasADBannerManager;
    if ((localVasADBannerManager == null) || (!localVasADBannerManager.getClass().isInstance(localObject)) || (!localObject.getClass().isInstance(this.jdField_a_of_type_CooperationVipQqbannerManagerVasADBannerManager)))
    {
      this.jdField_a_of_type_CooperationVipQqbannerManagerVasADBannerManager = ((VasADBannerManager)localObject);
      c();
    }
    localObject = this.jdField_a_of_type_CooperationVipQqbannerManagerVasADBannerManager;
    if (localObject == null) {
      return false;
    }
    boolean bool = ((VasADBannerManager)localObject).a();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isNeedShowVasADBanner: ");
    ((StringBuilder)localObject).append(bool);
    QLog.i("VasADBanner.Manager", 1, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  public int b()
  {
    return jdField_a_of_type_Int;
  }
  
  public void b()
  {
    VasADBannerManager localVasADBannerManager = this.jdField_a_of_type_CooperationVipQqbannerManagerVasADBannerManager;
    if (localVasADBannerManager != null) {
      localVasADBannerManager.e();
    }
  }
  
  public void c()
  {
    Banner localBanner = BannerManager.a().a(jdField_a_of_type_Int);
    if ((localBanner != null) && (localBanner.jdField_a_of_type_AndroidViewView != null) && (localBanner.jdField_a_of_type_Boolean))
    {
      BannerManager localBannerManager = BannerManager.a();
      int i = jdField_a_of_type_Int;
      AppRuntime localAppRuntime = null;
      localBannerManager.a(i, 0, null);
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
    BannerManager.a().a(jdField_a_of_type_Int, 0, null);
    VasADBannerManager localVasADBannerManager = this.jdField_a_of_type_CooperationVipQqbannerManagerVasADBannerManager;
    if (localVasADBannerManager != null) {
      localVasADBannerManager.b();
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 2000)
    {
      if (i != 2001)
      {
        switch (i)
        {
        default: 
          break;
        case 3003: 
          e();
          break;
        case 3002: 
          a(paramMessage);
          break;
        case 3001: 
          f();
          break;
        case 3000: 
          b(paramMessage);
          break;
        }
      }
      else
      {
        paramMessage = this.jdField_a_of_type_CooperationVipQqbannerManagerVasADBannerManager;
        if (paramMessage != null) {
          paramMessage.g();
        }
      }
    }
    else {
      d();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.VasADBannerProcessor
 * JD-Core Version:    0.7.0.1
 */