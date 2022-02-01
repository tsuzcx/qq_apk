package com.tencent.biz.pubaccount.readinjoyAd.ad.ext;

import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.SuperMaskExtKt;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.api.SuperMaskStep;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskConfigMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskReportMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskResMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.AladdinCheckStep;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.LearnModeCheckStep;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.PopCheckStep;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.ShowIntervalCheckStep;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.SuperMaskStepUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"fillPatchParams", "", "adRequestData", "Lcom/tencent/biz/pubaccount/NativeAd/data/AdRequestData;", "json", "Lorg/json/JSONObject;", "adPosType", "", "fillSocialParams", "fillSuperMaskParams", "channelID", "fillTimeLoadParams", "kandian_ad_feature_impl_release"}, k=2, mv={1, 1, 16})
public final class AdRequestExtKt
{
  public static final void a(@Nullable AdRequestData paramAdRequestData, @Nullable JSONObject paramJSONObject)
  {
    if ((paramAdRequestData != null) && (paramAdRequestData.h == 1))
    {
      if (paramJSONObject != null) {
        paramJSONObject.put("reqTimeVideoAdload", paramAdRequestData.h);
      }
      if (paramJSONObject != null) {
        paramJSONObject.put("videoSceneId", paramAdRequestData.i);
      }
      if (paramJSONObject != null) {
        paramJSONObject.put("videoTimeAdLoadLastAdPos", paramAdRequestData.j);
      }
      ReadInJoyAdLog.a("AdDataLink", "request time load ad");
    }
  }
  
  public static final void a(@Nullable AdRequestData paramAdRequestData, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if ((paramAdRequestData != null) && (paramAdRequestData.d == 1) && (paramInt == 1))
    {
      if (paramJSONObject != null) {
        paramJSONObject.put("videoPatchAdFlag", paramAdRequestData.d);
      }
      if (paramJSONObject != null) {
        paramJSONObject.put("prePatchAdCount", paramAdRequestData.e);
      }
      if (paramJSONObject != null) {
        paramJSONObject.put("postPatchAdCount", paramAdRequestData.f);
      }
      ReadInJoyAdLog.a("AdDataLink", "request patch ad");
    }
  }
  
  public static final void a(@Nullable AdRequestData paramAdRequestData, @Nullable JSONObject paramJSONObject, int paramInt1, int paramInt2)
  {
    if (paramAdRequestData != null)
    {
      if ((paramAdRequestData.b) && (paramInt2 == 1))
      {
        if (SuperMaskStepUtil.a.a("[REQUEST]", new SuperMaskStep[] { (SuperMaskStep)new LearnModeCheckStep(), (SuperMaskStep)new AladdinCheckStep(), (SuperMaskStep)new ShowIntervalCheckStep(paramInt1), (SuperMaskStep)new PopCheckStep() })) {}
      }
      else if ((SuperMaskConfigMgr.a.a() != 1) || (!paramAdRequestData.b)) {
        return;
      }
      Object localObject = SuperMaskResMgr.a.a();
      if ((((Map)localObject).isEmpty() ^ true))
      {
        paramAdRequestData = new JSONArray();
        try
        {
          localObject = ((Map)localObject).entrySet().iterator();
          while (((Iterator)localObject).hasNext())
          {
            Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
            ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
            SuperMaskExtKt.a((MaterialData)localEntry.getValue(), localConcurrentHashMap);
            paramAdRequestData.put(new JSONObject((Map)localConcurrentHashMap));
          }
          ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "[REQUEST] : getLocalResList is empty");
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          if (paramJSONObject != null) {
            paramJSONObject.put("superMaskType", 2);
          }
          if (paramJSONObject != null) {
            paramJSONObject.put("reqList", paramAdRequestData);
          }
          SuperMaskReportMgr.a(SuperMaskReportMgr.a, "requestMask", null, paramAdRequestData.length(), 2, null);
          paramJSONObject = new StringBuilder();
          paramJSONObject.append("[REQUEST]");
          paramJSONObject.append(" : add superMask params : ");
          paramJSONObject.append(paramAdRequestData.toString());
          QLog.d("ReadInJoySuperMaskAd", 1, paramJSONObject.toString());
          return;
        }
      }
    }
  }
  
  public static final void b(@Nullable AdRequestData paramAdRequestData, @Nullable JSONObject paramJSONObject, int paramInt)
  {
    if ((paramAdRequestData != null) && (paramAdRequestData.g == 1) && (paramInt == 1))
    {
      if (paramJSONObject != null) {
        paramJSONObject.put("social_card_flag", paramAdRequestData.g);
      }
      ReadInJoyAdLog.a("AdDataLink", "request social small ad");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.ext.AdRequestExtKt
 * JD-Core Version:    0.7.0.1
 */