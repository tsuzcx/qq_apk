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
  private SoftReference<Activity> jdField_a_of_type_JavaLangRefSoftReference;
  private boolean jdField_a_of_type_Boolean = false;
  
  public RIJADSuperMaskPopupStep(@NotNull RIJPopupAutomator paramRIJPopupAutomator, Activity paramActivity)
  {
    super(paramRIJPopupAutomator, "RIJADSuperMaskPopupStep");
    this.jdField_a_of_type_JavaLangRefSoftReference = new SoftReference(paramActivity);
  }
  
  private void i()
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
      i = SuperMaskConfigMgr.a.c().getAndAdd(1);
    } else if (((IDailyModeConfigHandler)QRoute.api(IDailyModeConfigHandler.class)).isDaily(paramInt)) {
      i = SuperMaskConfigMgr.a.d().getAndAdd(1);
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
    SuperMaskReportMgr.a.a("beginShowMask", "");
    if (b())
    {
      SuperMaskUIMgr.a.a(4);
      SuperMaskReportMgr.a.a("alertManagerShowAfter", "");
      a(false);
      return;
    }
    SuperMaskReportMgr.a.a("alertManagerShowNow", "");
    i();
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (SuperMaskUIMgr.a.b())
    {
      this.jdField_a_of_type_Boolean = (paramBoolean ^ true);
      if (this.jdField_a_of_type_Boolean) {
        a(false);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
  }
  
  public boolean a()
  {
    return super.a();
  }
  
  public void b()
  {
    super.b();
    ReadInJoySuperMaskAdUtil.a().a();
    SuperMaskPopStepProxy.a();
  }
  
  public boolean b()
  {
    RIJPopupAutomator localRIJPopupAutomator = a();
    if (localRIJPopupAutomator != null) {
      return localRIJPopupAutomator.a();
    }
    return false;
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
  
  protected void g() {}
  
  protected void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJADSuperMaskPopupStep
 * JD-Core Version:    0.7.0.1
 */