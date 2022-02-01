package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.impl;

import android.os.Handler;
import android.webkit.ValueCallback;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.TypeCastException;
import tuw;
import tvc;
import tve;
import tvo;
import tvs;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class SuperMaskUIMgr$checkResValid$1
  implements Runnable
{
  public SuperMaskUIMgr$checkResValid$1(ValueCallback paramValueCallback) {}
  
  public final void run()
  {
    if ((tve.a.a() instanceof AdvertisementInfo))
    {
      Object localObject2;
      if (tve.a.a() == null)
      {
        localObject1 = tve.a;
        localObject2 = tve.a.a();
        if (localObject2 == null) {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo");
        }
        ((tve)localObject1).a(tuw.a((AdvertisementInfo)localObject2));
      }
      if (tve.a.a() == null)
      {
        localObject1 = tve.a;
        localObject2 = tve.a.a();
        if (localObject2 == null) {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo");
        }
        ((tve)localObject1).a(tuw.a((AdvertisementInfo)localObject2));
      }
      Object localObject1 = new tvo(tve.a.a(), tve.a.a(), true, 2);
      boolean bool = tvs.a.a("[SHOW]", new tvc[] { (tvc)localObject1 });
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new SuperMaskUIMgr.checkResValid.1.1(this, bool));
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new SuperMaskUIMgr.checkResValid.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.impl.SuperMaskUIMgr.checkResValid.1
 * JD-Core Version:    0.7.0.1
 */