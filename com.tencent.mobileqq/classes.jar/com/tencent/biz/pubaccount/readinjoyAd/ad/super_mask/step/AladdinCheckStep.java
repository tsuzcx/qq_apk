package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step;

import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.api.SuperMaskStep;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskConfigMgr;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/AladdinCheckStep;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/SuperMaskStep;", "()V", "doStep", "", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class AladdinCheckStep
  extends SuperMaskStep
{
  public boolean c()
  {
    boolean bool = SuperMaskConfigMgr.a.d();
    return SuperMaskStepUtil.a.a(bool, (SuperMaskStep)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.AladdinCheckStep
 * JD-Core Version:    0.7.0.1
 */