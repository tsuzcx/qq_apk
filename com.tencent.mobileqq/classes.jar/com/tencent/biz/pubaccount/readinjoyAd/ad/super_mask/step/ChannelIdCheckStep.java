package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step;

import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.api.SuperMaskStep;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskReportMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskUIMgr;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/ChannelIdCheckStep;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/SuperMaskStep;", "()V", "doStep", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ChannelIdCheckStep
  extends SuperMaskStep
{
  public boolean a()
  {
    if ((SuperMaskUIMgr.a.b() == 0) || (DailyModeConfigHandler.c(SuperMaskUIMgr.a.b()))) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        SuperMaskReportMgr.a(SuperMaskReportMgr.a, "invalidChannel", null, 2, null);
      }
      return SuperMaskStepUtil.a.a(bool, (SuperMaskStep)this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.ChannelIdCheckStep
 * JD-Core Version:    0.7.0.1
 */