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
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
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
  implements Handler.Callback, IGuardInterface, IBannerLifecycle, IBannerViewScroll
{
  public static final int a = BannerTypeCollections.x;
  private TianshuBannerManager b;
  private VasADBannerManager c;
  
  public VasADBannerProcessor(QBaseActivity paramQBaseActivity)
  {
    super(paramQBaseActivity);
    if (GuardManager.sInstance != null) {
      GuardManager.sInstance.registerCallBack(this);
    }
    this.g = new CustomHandler(Looper.getMainLooper(), this);
  }
  
  private void a(Message paramMessage)
  {
    if (AppSetting.e) {
      return;
    }
    if (this.b == null) {
      this.b = new TianshuBannerManager((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    }
    TianshuBannerManager localTianshuBannerManager = this.b;
    if (localTianshuBannerManager != null) {
      localTianshuBannerManager.a((String)paramMessage.obj);
    }
  }
  
  private void b(Message paramMessage)
  {
    Object localObject = paramMessage.obj;
    if (localObject == null)
    {
      if (e())
      {
        BannerManager.a().a(a, 2, paramMessage);
        return;
      }
      BannerManager.a().a(a, 0, null);
      return;
    }
    if ((localObject instanceof View[]))
    {
      localObject = ((QQAppInterface)this.f.getAppRuntime()).getHandler(Conversation.class);
      paramMessage = Message.obtain(paramMessage);
      paramMessage.what = 1081;
      ((MqqHandler)localObject).sendMessage(paramMessage);
    }
  }
  
  private void h()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    VasADBannerConfigInfo localVasADBannerConfigInfo = VasADBannerResDownloadManager.a().c(((QQAppInterface)localObject).getAccount());
    if ((localVasADBannerConfigInfo instanceof VasADBannerCountDownImmersionInfo))
    {
      VasADBannerResDownloadManager.a().b((QQAppInterface)localObject, localVasADBannerConfigInfo);
      return;
    }
    long l1 = ((QQAppInterface)localObject).getLongAccountUin();
    int i = i();
    if (i > 0)
    {
      long l2 = i;
      localObject = Message.obtain();
      ((Message)localObject).obj = "vas_banner_pull_refresh";
      ((Message)localObject).what = 3002;
      this.g.sendMessageDelayed((Message)localObject, l1 % l2 * 1000L);
    }
  }
  
  private int i()
  {
    return QzoneConfig.getInstance().getConfig("K_QQ_VAS", "TopBannerRequestDelayInterval", 180);
  }
  
  private void j()
  {
    g();
    ((QQAppInterface)this.f.getAppRuntime()).getHandler(Conversation.class).sendEmptyMessage(1080);
  }
  
  public int a()
  {
    return super.a();
  }
  
  public View a(Banner paramBanner)
  {
    paramBanner = this.c;
    if (paramBanner != null) {
      return paramBanner.a();
    }
    return null;
  }
  
  public void a(Banner paramBanner, Message paramMessage)
  {
    if (paramMessage != null)
    {
      paramBanner = this.c;
      if (paramBanner != null) {
        paramBanner.g();
      }
      ReportController.a(this.f.getAppRuntime(), "dc00898", "", "", "0X8009EDE", "0X8009EDE", 11, 0, "", "", "", "");
    }
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    this.g.removeCallbacksAndMessages(null);
    if (GuardManager.sInstance != null) {
      GuardManager.sInstance.unregisterCallback(this);
    }
    paramAppRuntime = this.b;
    if (paramAppRuntime != null) {
      paramAppRuntime.a();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    VasADBannerManager localVasADBannerManager = this.c;
    if (localVasADBannerManager != null) {
      localVasADBannerManager.a(paramBoolean);
    }
  }
  
  public int b()
  {
    return a;
  }
  
  public void c()
  {
    BannerManager.a().a(a, 0);
    Object localObject = this.c;
    if (localObject != null) {
      ((VasADBannerManager)localObject).i();
    }
    if (this.b != null)
    {
      localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      this.b.b((QQAppInterface)localObject);
    }
  }
  
  public void d()
  {
    VasADBannerManager localVasADBannerManager = this.c;
    if (localVasADBannerManager != null) {
      localVasADBannerManager.h();
    }
  }
  
  public boolean e()
  {
    Object localObject = VasADBannerManager.b((BaseActivity)this.f, BannerManager.a());
    if (localObject == null) {
      return false;
    }
    VasADBannerManager localVasADBannerManager = this.c;
    if ((localVasADBannerManager == null) || (!localVasADBannerManager.getClass().isInstance(localObject)) || (!localObject.getClass().isInstance(this.c)))
    {
      this.c = ((VasADBannerManager)localObject);
      f();
    }
    localObject = this.c;
    if (localObject == null) {
      return false;
    }
    boolean bool = ((VasADBannerManager)localObject).e();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isNeedShowVasADBanner: ");
    ((StringBuilder)localObject).append(bool);
    QLog.i("VasADBanner.Manager", 1, ((StringBuilder)localObject).toString());
    return bool;
  }
  
  public void f()
  {
    Banner localBanner = BannerManager.a().a(a);
    if ((localBanner != null) && (localBanner.c != null) && (localBanner.d))
    {
      BannerManager localBannerManager = BannerManager.a();
      int i = a;
      AppRuntime localAppRuntime = null;
      localBannerManager.a(i, 0, null);
      if (this.f != null) {
        localAppRuntime = this.f.getAppRuntime();
      }
      if (localAppRuntime != null) {
        BannerManager.a().b(localAppRuntime, localBanner.a);
      }
    }
  }
  
  public void g()
  {
    BannerManager.a().a(a, 0, null);
    VasADBannerManager localVasADBannerManager = this.c;
    if (localVasADBannerManager != null) {
      localVasADBannerManager.d();
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
          h();
          break;
        case 3002: 
          a(paramMessage);
          break;
        case 3001: 
          j();
          break;
        case 3000: 
          b(paramMessage);
          break;
        }
      }
      else
      {
        paramMessage = this.c;
        if (paramMessage != null) {
          paramMessage.j();
        }
      }
    }
    else {
      g();
    }
    return true;
  }
  
  public void onApplicationBackground() {}
  
  public void onApplicationForeground()
  {
    Message localMessage = Message.obtain();
    localMessage.obj = "vas_banner_resume";
    a(localMessage);
  }
  
  public void onBackgroundTimeTick(long paramLong) {}
  
  public void onBackgroundUnguardTimeTick(long paramLong) {}
  
  public void onLiteTimeTick(long paramLong) {}
  
  public void onScreensStateChanged(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.VasADBannerProcessor
 * JD-Core Version:    0.7.0.1
 */