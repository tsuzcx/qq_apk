package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step;

import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.api.SuperMaskStep;
import com.tencent.mobileqq.studymode.StudyModeManager;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/LearnModeCheckStep;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/SuperMaskStep;", "()V", "doStep", "", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class LearnModeCheckStep
  extends SuperMaskStep
{
  public boolean a()
  {
    boolean bool = StudyModeManager.a();
    return SuperMaskStepUtil.a.a(bool ^ true, (SuperMaskStep)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.LearnModeCheckStep
 * JD-Core Version:    0.7.0.1
 */