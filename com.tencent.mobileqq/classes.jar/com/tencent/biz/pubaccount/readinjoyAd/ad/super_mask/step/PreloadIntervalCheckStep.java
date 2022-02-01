package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step;

import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.api.SuperMaskStep;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskConfigMgr;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/PreloadIntervalCheckStep;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/SuperMaskStep;", "()V", "doStep", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PreloadIntervalCheckStep
  extends SuperMaskStep
{
  public boolean a()
  {
    long l1 = SuperMaskConfigMgr.a.a();
    long l2 = NetConnInfoCenter.getServerTime();
    if (SuperMaskConfigMgr.a.b() <= 0L) {
      SuperMaskConfigMgr.a.b(1800L);
    }
    if (l2 - l1 >= SuperMaskConfigMgr.a.b()) {}
    for (boolean bool = true;; bool = false) {
      return SuperMaskStepUtil.a.a(bool, (SuperMaskStep)this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.PreloadIntervalCheckStep
 * JD-Core Version:    0.7.0.1
 */