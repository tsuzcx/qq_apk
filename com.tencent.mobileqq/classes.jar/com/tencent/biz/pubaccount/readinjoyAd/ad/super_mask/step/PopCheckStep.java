package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step;

import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.api.SuperMaskStep;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskConfigMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskReportMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/PopCheckStep;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/SuperMaskStep;", "()V", "doStep", "", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class PopCheckStep
  extends SuperMaskStep
{
  public boolean a()
  {
    boolean bool2 = SuperMaskConfigMgr.a.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("神灯配置，更高优先级弹窗展示时请求蒙层：");
    localStringBuilder.append(bool2);
    ReadInJoyAdLog.a("PopCheckStep", localStringBuilder.toString());
    boolean bool1 = true;
    if (bool2)
    {
      bool1 = SuperMaskPopStepProxy.a();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("是否有更高优先级弹窗拦截：");
      localStringBuilder.append(bool1);
      ReadInJoyAdLog.a("PopCheckStep", localStringBuilder.toString());
      if (bool1) {
        SuperMaskReportMgr.a(SuperMaskReportMgr.a, "halfFloatShowNoReq", null, 2, null);
      }
      bool1 = true ^ bool1;
    }
    return SuperMaskStepUtil.a.a(bool1, (SuperMaskStep)this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.PopCheckStep
 * JD-Core Version:    0.7.0.1
 */