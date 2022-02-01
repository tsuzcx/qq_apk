package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr;

import android.os.Handler;
import android.webkit.ValueCallback;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import kotlin.Metadata;
import kotlin.TypeCastException;
import uja;
import ujc;
import uje;
import ujp;
import ujt;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class SuperMaskUIMgr$checkResValid$1
  implements Runnable
{
  public SuperMaskUIMgr$checkResValid$1(ValueCallback paramValueCallback) {}
  
  public final void run()
  {
    if ((uje.a.a() instanceof AdvertisementInfo))
    {
      Object localObject2;
      if (uje.a.a() == null)
      {
        localObject1 = uje.a;
        localObject2 = uje.a.a();
        if (localObject2 == null) {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo");
        }
        ((uje)localObject1).a(uja.a((AdvertisementInfo)localObject2));
      }
      if (uje.a.a() == null)
      {
        localObject1 = uje.a;
        localObject2 = uje.a.a();
        if (localObject2 == null) {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo");
        }
        ((uje)localObject1).a(uja.a((AdvertisementInfo)localObject2));
      }
      Object localObject1 = new ujp(uje.a.a(), uje.a.a(), true, 2);
      boolean bool = ujt.a.a("[SHOW]", new ujc[] { (ujc)localObject1 });
      ThreadManagerV2.getUIHandlerV2().post((Runnable)new SuperMaskUIMgr.checkResValid.1.1(this, bool));
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new SuperMaskUIMgr.checkResValid.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskUIMgr.checkResValid.1
 * JD-Core Version:    0.7.0.1
 */