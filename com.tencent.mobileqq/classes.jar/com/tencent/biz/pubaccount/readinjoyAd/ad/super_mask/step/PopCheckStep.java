package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step;

import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.api.SuperMaskStep;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskConfigMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskReportMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/PopCheckStep;", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/api/SuperMaskStep;", "()V", "doStep", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class PopCheckStep
  extends SuperMaskStep
{
  public boolean a()
  {
    boolean bool2 = true;
    boolean bool3 = SuperMaskConfigMgr.a.b();
    ReadInJoyAdLog.a("PopCheckStep", "神灯配置，更高优先级弹窗展示时请求蒙层：" + bool3);
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = SuperMaskPopStepProxy.a();
      ReadInJoyAdLog.a("PopCheckStep", "是否有更高优先级弹窗拦截：" + bool1);
      if (bool1) {
        SuperMaskReportMgr.a(SuperMaskReportMgr.a, "halfFloatShowNoReq", null, 2, null);
      }
      if (bool1) {
        break label100;
      }
    }
    label100:
    for (bool1 = bool2;; bool1 = false) {
      return SuperMaskStepUtil.a.a(bool1, (SuperMaskStep)this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.PopCheckStep
 * JD-Core Version:    0.7.0.1
 */