package com.tencent.biz.pubaccount.readinjoy.feedspopup.steps;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskConfigMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskDataMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskReportMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskUIMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.SuperMaskPopStepProxy;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoySuperMaskAdUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoySuperMaskAdUtil.RIJSuperMaskAdEventListener;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdLogService;
import com.tencent.mobileqq.kandian.base.automator.BasePopupStep;
import com.tencent.mobileqq.kandian.base.automator.RIJPopupAutomator;
import com.tencent.mobileqq.kandian.repo.daily.api.IDailyModeConfigHandler;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.SoftReference;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;

public class RIJADSuperMaskPopupStep
  extends BasePopupStep
  implements ReadInJoySuperMaskAdUtil.RIJSuperMaskAdEventListener
{
  private SoftReference<Activity> a;
  private boolean b = false;
  
  public RIJADSuperMaskPopupStep(@NotNull RIJPopupAutomator paramRIJPopupAutomator, Activity paramActivity)
  {
    super(paramRIJPopupAutomator, "RIJADSuperMaskPopupStep");
    this.a = new SoftReference(paramActivity);
  }
  
  private void l()
  {
    SuperMaskUIMgr.a.a(new RIJADSuperMaskPopupStep.1(this));
  }
  
  public void a()
  {
    super.a();
    ReadInJoySuperMaskAdUtil.a().a(this);
    SuperMaskPopStepProxy.a(this);
  }
  
  public void a(int paramInt)
  {
    if ((paramInt != 0) && (!((IDailyModeConfigHandler)QRoute.api(IDailyModeConfigHandler.class)).isDaily(paramInt))) {
      return;
    }
    int i = -1;
    if (paramInt == 0) {
      i = SuperMaskConfigMgr.a.h().getAndAdd(1);
    } else if (((IDailyModeConfigHandler)QRoute.api(IDailyModeConfigHandler.class)).isDaily(paramInt)) {
      i = SuperMaskConfigMgr.a.i().getAndAdd(1);
    }
    if (i != 0)
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoySuperMaskAd", "refreshNum != 0");
      a(false);
      SuperMaskUIMgr.a.a(4);
      return;
    }
    if (!(SuperMaskDataMgr.a.a() instanceof AdvertisementInfo))
    {
      ((IRIJAdLogService)QRoute.api(IRIJAdLogService.class)).d("ReadInJoySuperMaskAd", "未收到蒙层回包");
      a(false);
      SuperMaskUIMgr.a.a(4);
      return;
    }
    if (SuperMaskUIMgr.a.d())
    {
      SuperMaskReportMgr.a.a("beginShowMask", "");
      if (j())
      {
        SuperMaskUIMgr.a.a(4);
        SuperMaskReportMgr.a.a("alertManagerShowAfter", "");
        a(false);
        return;
      }
      SuperMaskReportMgr.a.a("alertManagerShowNow", "");
      l();
      return;
    }
    SuperMaskUIMgr.a.a(4);
    IRIJAdLogService localIRIJAdLogService = (IRIJAdLogService)QRoute.api(IRIJAdLogService.class);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("superMask not show, refreshNum = ");
    localStringBuilder.append(i);
    localIRIJAdLogService.d("ReadInJoySuperMaskAd", localStringBuilder.toString());
    a(false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (SuperMaskUIMgr.a.f())
    {
      this.b = (paramBoolean ^ true);
      if (this.b) {
        a(false);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
  }
  
  public void b()
  {
    super.b();
    ReadInJoySuperMaskAdUtil.a().b();
    SuperMaskPopStepProxy.a();
  }
  
  public void c()
  {
    super.c();
  }
  
  public void d()
  {
    super.d();
  }
  
  public void e()
  {
    super.e();
  }
  
  public void f()
  {
    super.f();
  }
  
  public boolean g()
  {
    return super.g();
  }
  
  protected void h() {}
  
  protected void i() {}
  
  public boolean j()
  {
    RIJPopupAutomator localRIJPopupAutomator = k();
    if (localRIJPopupAutomator != null) {
      return localRIJPopupAutomator.i();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJADSuperMaskPopupStep
 * JD-Core Version:    0.7.0.1
 */