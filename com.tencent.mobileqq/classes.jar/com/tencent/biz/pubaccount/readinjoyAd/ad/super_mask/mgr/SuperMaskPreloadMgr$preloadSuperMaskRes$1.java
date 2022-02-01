package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr;

import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJRuntimeUtils;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.TypeCastException;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
final class SuperMaskPreloadMgr$preloadSuperMaskRes$1
  implements Runnable
{
  public static final 1 a = new 1();
  
  public final void run()
  {
    Object localObject = (QQAppInterface)((IRIJRuntimeUtils)QRoute.api(IRIJRuntimeUtils.class)).getAppRuntime();
    if (localObject != null) {
      localObject = ((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.READINJOY_AD_MATERIAL_HANDLER);
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      ((AdMaterialHandler)localObject).a();
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.AdMaterialHandler");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskPreloadMgr.preloadSuperMaskRes.1
 * JD-Core Version:    0.7.0.1
 */