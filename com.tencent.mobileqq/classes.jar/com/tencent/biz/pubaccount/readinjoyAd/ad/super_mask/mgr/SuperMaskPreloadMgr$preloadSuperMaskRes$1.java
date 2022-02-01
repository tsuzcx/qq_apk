package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr;

import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import kotlin.Metadata;
import kotlin.TypeCastException;
import pnn;
import uhz;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class SuperMaskPreloadMgr$preloadSuperMaskRes$1
  implements Runnable
{
  public static final 1 a = new 1();
  
  public final void run()
  {
    BusinessHandler localBusinessHandler = pnn.a().getBusinessHandler(BusinessHandlerFactory.READINJOY_AD_MATERIAL_HANDLER);
    if (localBusinessHandler == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialHandler");
    }
    ((uhz)localBusinessHandler).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskPreloadMgr.preloadSuperMaskRes.1
 * JD-Core Version:    0.7.0.1
 */