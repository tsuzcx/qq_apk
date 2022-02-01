package com.tencent.biz.pubaccount.readinjoy.feedspopup.steps;

import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.BasePopupStep;
import com.tencent.biz.pubaccount.readinjoy.feedspopup.RIJPopupAutomator;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskConfigMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskDataMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskReportMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskUIMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.SuperMaskPopStepProxy;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoySuperMaskAdUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoySuperMaskAdUtil.RIJSuperMaskAdEventListener;
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
    if ((paramInt != 0) && (!DailyModeConfigHandler.c(paramInt))) {
      return;
    }
    int i = -1;
    if (paramInt == 0) {
      i = SuperMaskConfigMgr.a.c().getAndAdd(1);
    }
    while (i != 0)
    {
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "refreshNum != 0");
      a(false);
      SuperMaskUIMgr.a.a(4);
      return;
      if (DailyModeConfigHandler.c(paramInt)) {
        i = SuperMaskConfigMgr.a.d().getAndAdd(1);
      }
    }
    if (!(SuperMaskDataMgr.a.a() instanceof AdvertisementInfo))
    {
      ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "未收到蒙层回包");
      a(false);
      SuperMaskUIMgr.a.a(4);
      return;
    }
    if (SuperMaskUIMgr.a.b())
    {
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
      return;
    }
    SuperMaskUIMgr.a.a(4);
    ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "superMask not show, refreshNum = " + i);
    a(false);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (SuperMaskUIMgr.a.c()) {
      if (paramBoolean) {
        break label33;
      }
    }
    label33:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (this.jdField_a_of_type_Boolean) {
        a(false);
      }
      return;
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
    boolean bool = false;
    RIJPopupAutomator localRIJPopupAutomator = a();
    if (localRIJPopupAutomator != null) {
      bool = localRIJPopupAutomator.a();
    }
    return bool;
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
  
  public void g() {}
  
  public void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJADSuperMaskPopupStep
 * JD-Core Version:    0.7.0.1
 */