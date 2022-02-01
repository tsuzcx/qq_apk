package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr;

import android.os.Handler;
import android.webkit.ValueCallback;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.SuperMaskExtKt;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.api.SuperMaskStep;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.ResCheckStep;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.SuperMaskStepUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class SuperMaskUIMgr$checkResValid$1
  implements Runnable
{
  SuperMaskUIMgr$checkResValid$1(ValueCallback paramValueCallback) {}
  
  public final void run()
  {
    if ((SuperMaskDataMgr.a.a() instanceof AdvertisementInfo))
    {
      Object localObject2;
      if (SuperMaskDataMgr.a.a() == null)
      {
        localObject1 = SuperMaskDataMgr.a;
        localObject2 = SuperMaskDataMgr.a.a();
        if (localObject2 == null) {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo");
        }
        ((SuperMaskDataMgr)localObject1).a(SuperMaskExtKt.a((AdvertisementInfo)localObject2));
      }
      if (SuperMaskDataMgr.a.a() == null)
      {
        localObject1 = SuperMaskDataMgr.a;
        localObject2 = SuperMaskDataMgr.a.a();
        if (localObject2 == null) {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo");
        }
        ((SuperMaskDataMgr)localObject1).a(SuperMaskExtKt.a((AdvertisementInfo)localObject2));
      }
      Object localObject1 = new ResCheckStep(SuperMaskDataMgr.a.a(), SuperMaskDataMgr.a.a(), true, 2);
      boolean bool = SuperMaskStepUtil.a.a("[SHOW]", new SuperMaskStep[] { (SuperMaskStep)localObject1 });
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new SuperMaskUIMgr.checkResValid.1.1(this, bool));
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new SuperMaskUIMgr.checkResValid.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskUIMgr.checkResValid.1
 * JD-Core Version:    0.7.0.1
 */