package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.ResCheckStep.AdResCheckInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.ad.api.IRIJSuperMaskService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/mgr/SuperMaskDataMgr;", "", "()V", "adData", "getAdData", "()Ljava/lang/Object;", "setAdData", "(Ljava/lang/Object;)V", "adResData", "Lorg/json/JSONObject;", "getAdResData", "()Lorg/json/JSONObject;", "setAdResData", "(Lorg/json/JSONObject;)V", "resCheckInfo", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/ResCheckStep$AdResCheckInfo;", "getResCheckInfo", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/ResCheckStep$AdResCheckInfo;", "setResCheckInfo", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/ResCheckStep$AdResCheckInfo;)V", "isBidMask", "", "isNormalMask", "receiveAd", "", "adInfo", "resetDataMgr", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class SuperMaskDataMgr
{
  public static final SuperMaskDataMgr a = new SuperMaskDataMgr();
  @Nullable
  private static volatile Object b;
  @Nullable
  private static volatile JSONObject c;
  @Nullable
  private static volatile ResCheckStep.AdResCheckInfo d;
  
  @Nullable
  public final Object a()
  {
    return b;
  }
  
  public final void a(@Nullable ResCheckStep.AdResCheckInfo paramAdResCheckInfo)
  {
    d = paramAdResCheckInfo;
  }
  
  public final void a(@Nullable Object paramObject)
  {
    if (((paramObject instanceof AdvertisementInfo)) && (ReadInJoyAdUtils.l((AdvertisementInfo)paramObject)))
    {
      QLog.d("ReadInJoySuperMaskAd", 1, "receiveAd");
      QRouteApi localQRouteApi = QRoute.api(IRIJSuperMaskService.class);
      Intrinsics.checkExpressionValueIsNotNull(localQRouteApi, "QRoute.api(IRIJSuperMaskService::class.java)");
      ((IRIJSuperMaskService)localQRouteApi).setShowStatus(1);
      SuperMaskReportMgr.a.c();
      b = paramObject;
      SuperMaskReportMgr.a(SuperMaskReportMgr.a, "recviceMask", null, 2, null);
      ThreadManagerV2.post((Runnable)new SuperMaskDataMgr.receiveAd.1(paramObject), 10, null, false);
    }
  }
  
  public final void a(@Nullable JSONObject paramJSONObject)
  {
    c = paramJSONObject;
  }
  
  @Nullable
  public final JSONObject b()
  {
    return c;
  }
  
  @Nullable
  public final ResCheckStep.AdResCheckInfo c()
  {
    return d;
  }
  
  public final boolean d()
  {
    Object localObject2 = b;
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof AdvertisementInfo)) {
      localObject1 = null;
    }
    return ReadInJoyAdUtils.m((AdvertisementInfo)localObject1);
  }
  
  public final boolean e()
  {
    Object localObject2 = b;
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof AdvertisementInfo)) {
      localObject1 = null;
    }
    return ReadInJoyAdUtils.n((AdvertisementInfo)localObject1);
  }
  
  public final void f()
  {
    b = null;
    c = (JSONObject)null;
    d = (ResCheckStep.AdResCheckInfo)null;
    QLog.d("ReadInJoySuperMaskAd", 1, "resetDataMgr");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskDataMgr
 * JD-Core Version:    0.7.0.1
 */