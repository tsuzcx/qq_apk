package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr;

import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.api.SuperMaskStep;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.AladdinCheckStep;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.PreloadIntervalCheckStep;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.SuperMaskStepUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/mgr/SuperMaskPreloadMgr;", "", "()V", "checkPreloadIfNeed", "", "preloadSuperMaskRes", "", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class SuperMaskPreloadMgr
{
  public static final SuperMaskPreloadMgr a = new SuperMaskPreloadMgr();
  
  private final boolean b()
  {
    SuperMaskStepUtil localSuperMaskStepUtil = SuperMaskStepUtil.a;
    SuperMaskStep localSuperMaskStep = (SuperMaskStep)new AladdinCheckStep();
    boolean bool1 = false;
    boolean bool2 = localSuperMaskStepUtil.a("[PRELOAD]", new SuperMaskStep[] { localSuperMaskStep, (SuperMaskStep)new PreloadIntervalCheckStep() });
    if ((SuperMaskConfigMgr.a.c() == 1) || (bool2)) {
      bool1 = true;
    }
    return bool1;
  }
  
  public final void a()
  {
    if (!b()) {
      return;
    }
    ThreadManagerV2.excute((Runnable)SuperMaskPreloadMgr.preloadSuperMaskRes.1.a, 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskPreloadMgr
 * JD-Core Version:    0.7.0.1
 */