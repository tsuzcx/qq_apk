package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr;

import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.ResCheckStep.AdResCheckInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/mgr/SuperMaskDataMgr;", "", "()V", "adData", "getAdData", "()Ljava/lang/Object;", "setAdData", "(Ljava/lang/Object;)V", "adResData", "Lorg/json/JSONObject;", "getAdResData", "()Lorg/json/JSONObject;", "setAdResData", "(Lorg/json/JSONObject;)V", "resCheckInfo", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/ResCheckStep$AdResCheckInfo;", "getResCheckInfo", "()Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/ResCheckStep$AdResCheckInfo;", "setResCheckInfo", "(Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/ResCheckStep$AdResCheckInfo;)V", "isNormalMask", "", "receiveAd", "", "adInfo", "resetDataMgr", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class SuperMaskDataMgr
{
  public static final SuperMaskDataMgr a;
  @Nullable
  private static volatile ResCheckStep.AdResCheckInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSuper_maskStepResCheckStep$AdResCheckInfo;
  @Nullable
  private static volatile Object jdField_a_of_type_JavaLangObject;
  @Nullable
  private static volatile JSONObject jdField_a_of_type_OrgJsonJSONObject;
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSuper_maskMgrSuperMaskDataMgr = new SuperMaskDataMgr();
  }
  
  @Nullable
  public final ResCheckStep.AdResCheckInfo a()
  {
    return jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSuper_maskStepResCheckStep$AdResCheckInfo;
  }
  
  @Nullable
  public final Object a()
  {
    return jdField_a_of_type_JavaLangObject;
  }
  
  @Nullable
  public final JSONObject a()
  {
    return jdField_a_of_type_OrgJsonJSONObject;
  }
  
  public final void a()
  {
    jdField_a_of_type_JavaLangObject = null;
    jdField_a_of_type_OrgJsonJSONObject = (JSONObject)null;
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSuper_maskStepResCheckStep$AdResCheckInfo = (ResCheckStep.AdResCheckInfo)null;
    QLog.d("ReadInJoySuperMaskAd", 1, "resetDataMgr");
  }
  
  public final void a(@Nullable ResCheckStep.AdResCheckInfo paramAdResCheckInfo)
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSuper_maskStepResCheckStep$AdResCheckInfo = paramAdResCheckInfo;
  }
  
  public final void a(@Nullable Object paramObject)
  {
    if (((paramObject instanceof AdvertisementInfo)) && (ReadInJoyAdUtils.h((AdvertisementInfo)paramObject)))
    {
      QLog.d("ReadInJoySuperMaskAd", 1, "receiveAd");
      SuperMaskUIMgr.a.a(1);
      SuperMaskReportMgr.a.b();
      jdField_a_of_type_JavaLangObject = paramObject;
      SuperMaskReportMgr.a(SuperMaskReportMgr.a, "recviceMask", null, 2, null);
      ThreadManagerV2.post((Runnable)new SuperMaskDataMgr.receiveAd.1(paramObject), 10, null, false);
    }
  }
  
  public final void a(@Nullable JSONObject paramJSONObject)
  {
    jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
  }
  
  public final boolean a()
  {
    Object localObject2 = jdField_a_of_type_JavaLangObject;
    Object localObject1 = localObject2;
    if (!(localObject2 instanceof AdvertisementInfo)) {
      localObject1 = null;
    }
    return ReadInJoyAdUtils.i((AdvertisementInfo)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskDataMgr
 * JD-Core Version:    0.7.0.1
 */