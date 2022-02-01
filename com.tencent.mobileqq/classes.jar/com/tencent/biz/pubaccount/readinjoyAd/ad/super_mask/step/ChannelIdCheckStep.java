package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step;

import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.api.SuperMaskStep;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskReportMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskUIMgr;
import com.tencent.mobileqq.kandian.repo.daily.api.IDailyModeConfigHandler;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/ChannelIdCheckStep;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/SuperMaskStep;", "()V", "doStep", "", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ChannelIdCheckStep
  extends SuperMaskStep
{
  public boolean a()
  {
    boolean bool;
    if ((SuperMaskUIMgr.a.b() != 0) && (!((IDailyModeConfigHandler)QRoute.api(IDailyModeConfigHandler.class)).isDaily(SuperMaskUIMgr.a.b()))) {
      bool = false;
    } else {
      bool = true;
    }
    if (!bool) {
      SuperMaskReportMgr.a(SuperMaskReportMgr.a, "invalidChannel", null, 2, null);
    }
    return SuperMaskStepUtil.a.a(bool, (SuperMaskStep)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.ChannelIdCheckStep
 * JD-Core Version:    0.7.0.1
 */