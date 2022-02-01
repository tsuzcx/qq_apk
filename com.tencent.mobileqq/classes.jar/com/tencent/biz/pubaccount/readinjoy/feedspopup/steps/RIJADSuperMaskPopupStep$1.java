package com.tencent.biz.pubaccount.readinjoy.feedspopup.steps;

import android.webkit.ValueCallback;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskReportMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskUIMgr;

class RIJADSuperMaskPopupStep$1
  implements ValueCallback<Boolean>
{
  RIJADSuperMaskPopupStep$1(RIJADSuperMaskPopupStep paramRIJADSuperMaskPopupStep) {}
  
  public void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      SuperMaskReportMgr.a.a("hasResourceInfo", "");
      SuperMaskUIMgr.a.a(RIJADSuperMaskPopupStep.a(this.a));
      SuperMaskUIMgr.a.a();
      this.a.a(true);
      return;
    }
    SuperMaskReportMgr.a.a("noResourceInfo", "");
    SuperMaskUIMgr.a.a(4);
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.feedspopup.steps.RIJADSuperMaskPopupStep.1
 * JD-Core Version:    0.7.0.1
 */