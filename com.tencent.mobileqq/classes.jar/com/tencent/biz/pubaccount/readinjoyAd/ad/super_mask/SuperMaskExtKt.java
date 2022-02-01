package com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask;

import com.dataline.util.file.FileUtil;
import com.tencent.biz.pubaccount.NativeAd.data.AdRequestData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementExtInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.materialdownload.MaterialData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskConfigMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskReportMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskResMgr;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.mgr.SuperMaskResMgr.SuperMaskJson;
import com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.step.ResCheckStep.AdResCheckInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdLog;
import com.tencent.mobileqq.kandian.ad.api.IRIJSuperMaskService;
import com.tencent.mobileqq.kandian.repo.daily.api.IDailyModeConfigHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"fillFunExtJsonForClick", "", "advertisementInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;", "type", "", "funcExtDataJson", "Lorg/json/JSONObject;", "funcExt", "fillFunExtJsonForExpose", "origin", "exposeMode", "fillSuperMaskFlag", "Lcom/tencent/biz/pubaccount/NativeAd/data/AdRequestData;", "channelID", "fillToReqMap", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/materialdownload/MaterialData;", "map", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "findLocalResJson", "fixSuperMaskResTypeUpdateError", "getAdId", "isFileExist", "", "isInvalidType", "isManifestFileExit", "toSuperMaskResInfo", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/super_mask/step/ResCheckStep$AdResCheckInfo;", "kandian_ad_feature_impl_release"}, k=2, mv={1, 1, 16})
public final class SuperMaskExtKt
{
  @NotNull
  public static final ResCheckStep.AdResCheckInfo a(@NotNull AdvertisementInfo paramAdvertisementInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAdvertisementInfo, "$this$toSuperMaskResInfo");
    long l = paramAdvertisementInfo.mAdAid;
    Object localObject = paramAdvertisementInfo.mAdvertisementExtInfo;
    if (localObject != null)
    {
      localObject = String.valueOf(((AdvertisementExtInfo)localObject).j);
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    return new ResCheckStep.AdResCheckInfo(String.valueOf(l), (String)localObject, paramAdvertisementInfo.mAdvertisementExtInfo.q);
  }
  
  @Nullable
  public static final JSONObject a(@NotNull AdvertisementInfo paramAdvertisementInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramAdvertisementInfo, "$this$findLocalResJson");
    long l = paramAdvertisementInfo.mAdAid;
    paramAdvertisementInfo = paramAdvertisementInfo.mAdvertisementExtInfo;
    if (paramAdvertisementInfo != null)
    {
      paramAdvertisementInfo = String.valueOf(paramAdvertisementInfo.j);
      if (paramAdvertisementInfo != null) {}
    }
    else
    {
      paramAdvertisementInfo = "";
    }
    paramAdvertisementInfo = SuperMaskResMgr.a.a(String.valueOf(l), paramAdvertisementInfo);
    if (paramAdvertisementInfo != null) {
      return paramAdvertisementInfo.a();
    }
    return null;
  }
  
  public static final void a(@NotNull AdRequestData paramAdRequestData, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramAdRequestData, "$this$fillSuperMaskFlag");
    boolean bool2 = false;
    boolean bool1 = false;
    if (paramInt == 0)
    {
      if (SuperMaskConfigMgr.a.a().getAndAdd(1) == 0) {
        bool1 = true;
      }
      paramAdRequestData.b = bool1;
      if (paramAdRequestData.b) {
        QLog.d("ReadInJoySuperMaskAd", 1, "request SuperMask in recommend");
      }
    }
    else if (((IDailyModeConfigHandler)QRoute.api(IDailyModeConfigHandler.class)).isDaily(paramInt))
    {
      bool1 = bool2;
      if (SuperMaskConfigMgr.a.b().getAndAdd(1) == 0) {
        bool1 = true;
      }
      paramAdRequestData.b = bool1;
      if (paramAdRequestData.b) {
        QLog.d("ReadInJoySuperMaskAd", 1, "request SuperMask in daily");
      }
    }
  }
  
  public static final void a(@Nullable AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, @Nullable JSONObject paramJSONObject1, @NotNull JSONObject paramJSONObject2)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject2, "funcExt");
    if (paramAdvertisementInfo != null)
    {
      AdvertisementExtInfo localAdvertisementExtInfo = paramAdvertisementInfo.mAdvertisementExtInfo;
      if ((localAdvertisementExtInfo != null) && (localAdvertisementExtInfo.m == 3))
      {
        paramJSONObject2.put("is_transparent", "1");
        break label75;
      }
    }
    if (paramAdvertisementInfo != null)
    {
      paramAdvertisementInfo = paramAdvertisementInfo.mAdvertisementExtInfo;
      if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.m == 2)) {
        paramJSONObject2.put("is_transparent", "");
      }
    }
    label75:
    if (paramInt1 == 37) {
      if (paramInt2 == 2)
      {
        paramJSONObject2.put("stat_type", "2");
        QLog.d("ReadInJoySuperMaskAd", 1, "fillReportDataAndReportAdEvent: 宽口径曝光");
      }
      else
      {
        QLog.d("ReadInJoySuperMaskAd", 1, "fillReportDataAndReportAdEvent: 严口径曝光");
      }
    }
    if (paramJSONObject1 != null) {
      paramJSONObject1.put("exposure_info_report", paramJSONObject2.toString());
    }
  }
  
  public static final void a(@Nullable AdvertisementInfo paramAdvertisementInfo, int paramInt, @Nullable JSONObject paramJSONObject1, @NotNull JSONObject paramJSONObject2)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject2, "funcExt");
    if (paramAdvertisementInfo != null)
    {
      AdvertisementExtInfo localAdvertisementExtInfo = paramAdvertisementInfo.mAdvertisementExtInfo;
      if ((localAdvertisementExtInfo != null) && (localAdvertisementExtInfo.m == 3))
      {
        paramJSONObject2.put("is_transparent", "1");
        break label72;
      }
    }
    if (paramAdvertisementInfo != null)
    {
      paramAdvertisementInfo = paramAdvertisementInfo.mAdvertisementExtInfo;
      if ((paramAdvertisementInfo != null) && (paramAdvertisementInfo.m == 2)) {
        paramJSONObject2.put("is_transparent", "");
      }
    }
    label72:
    paramAdvertisementInfo = QRoute.api(IRIJSuperMaskService.class);
    Intrinsics.checkExpressionValueIsNotNull(paramAdvertisementInfo, "QRoute.api(IRIJSuperMaskService::class.java)");
    if (((IRIJSuperMaskService)paramAdvertisementInfo).getHasVolume())
    {
      paramJSONObject2.put("volumn", "1");
      if (paramInt == 27)
      {
        paramAdvertisementInfo = QRoute.api(IRIJSuperMaskService.class);
        Intrinsics.checkExpressionValueIsNotNull(paramAdvertisementInfo, "QRoute.api(IRIJSuperMaskService::class.java)");
        ((IRIJSuperMaskService)paramAdvertisementInfo).setHasVolume(false);
      }
    }
    else
    {
      paramJSONObject2.put("volumn", "0");
      if (paramInt == 28)
      {
        paramAdvertisementInfo = QRoute.api(IRIJSuperMaskService.class);
        Intrinsics.checkExpressionValueIsNotNull(paramAdvertisementInfo, "QRoute.api(IRIJSuperMaskService::class.java)");
        ((IRIJSuperMaskService)paramAdvertisementInfo).setHasVolume(true);
      }
    }
    if (paramInt == 26) {
      if (SuperMaskReportMgr.a.a())
      {
        paramJSONObject2.put("is_jump_mc", "2");
        ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "is_jump_mc = 2");
      }
      else
      {
        paramJSONObject2.put("is_jump_mc", "1");
        ReadInJoyAdLog.a("ReadInJoySuperMaskAd", "is_jump_mc = 1");
      }
    }
    if (paramJSONObject1 != null) {
      paramJSONObject1.put("click_info_report", paramJSONObject2.toString());
    }
  }
  
  public static final void a(@Nullable MaterialData paramMaterialData)
  {
    if (paramMaterialData != null) {}
    try
    {
      localObject1 = new File(paramMaterialData.res_path, "manifest.json");
      if ((!((File)localObject1).exists()) || (!((File)localObject1).isFile()) || (!((File)localObject1).canRead())) {
        break label124;
      }
      localObject2 = new StringBuffer();
      FileUtil.a((StringBuffer)localObject2, ((File)localObject1).getPath());
      localObject1 = ((StringBuffer)localObject2).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "buffer.toString()");
      localObject2 = new JSONObject((String)localObject1);
      localObject1 = ((JSONObject)localObject2).optString("animFileName");
      if (localObject1 == null) {
        break label154;
      }
    }
    catch (Exception paramMaterialData)
    {
      for (;;)
      {
        Object localObject2;
        continue;
        Object localObject1 = "";
      }
    }
    paramMaterialData.animFileName = ((String)localObject1);
    paramMaterialData.superMaskType = ((JSONObject)localObject2).optInt("superMaskType", 0);
    SuperMaskReportMgr.a(SuperMaskReportMgr.a, "updateSuperMaskTypeSuccess", null, 2, null);
    return;
    label124:
    SuperMaskReportMgr.a(SuperMaskReportMgr.a, "dbUpdateNoManifest", null, 2, null);
    return;
    SuperMaskReportMgr.a(SuperMaskReportMgr.a, "updateSuperMaskTypeError", null, 2, null);
  }
  
  public static final void a(@NotNull MaterialData paramMaterialData, @Nullable ConcurrentHashMap<String, Object> paramConcurrentHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramMaterialData, "$this$fillToReqMap");
    if (paramConcurrentHashMap != null) {
      ((Map)paramConcurrentHashMap).put("adId", paramMaterialData.adid);
    }
    if (paramConcurrentHashMap != null) {
      ((Map)paramConcurrentHashMap).put("adSource", paramMaterialData.ad_source);
    }
    if (paramConcurrentHashMap != null) {
      ((Map)paramConcurrentHashMap).put("adMaterial", paramMaterialData.ad_material);
    }
    if (paramConcurrentHashMap != null) {
      ((Map)paramConcurrentHashMap).put("version", Integer.valueOf(paramMaterialData.res_version));
    }
    if (paramConcurrentHashMap != null) {
      ((Map)paramConcurrentHashMap).put("md5", paramMaterialData.res_md5);
    }
    if (paramConcurrentHashMap != null) {
      ((Map)paramConcurrentHashMap).put("adType", Integer.valueOf(paramMaterialData.ad_type));
    }
    if (paramConcurrentHashMap != null) {
      ((Map)paramConcurrentHashMap).put("subAdId", paramMaterialData.sub_adid);
    }
    if (paramConcurrentHashMap != null) {
      ((Map)paramConcurrentHashMap).put("startTime", Long.valueOf(paramMaterialData.start_time));
    }
    if (paramConcurrentHashMap != null) {
      ((Map)paramConcurrentHashMap).put("endTime", Long.valueOf(paramMaterialData.end_time));
    }
    if (paramConcurrentHashMap != null) {
      ((Map)paramConcurrentHashMap).put("deliveryEffect", Integer.valueOf(paramMaterialData.delivery_effect));
    }
    if (paramConcurrentHashMap != null) {
      ((Map)paramConcurrentHashMap).put("normalMask", Integer.valueOf(paramMaterialData.normal_mask));
    }
    if (paramConcurrentHashMap != null) {
      ((Map)paramConcurrentHashMap).put("bidMask", Integer.valueOf(paramMaterialData.bid_mask));
    }
  }
  
  public static final boolean a(@NotNull MaterialData paramMaterialData)
  {
    Intrinsics.checkParameterIsNotNull(paramMaterialData, "$this$isFileExist");
    if (paramMaterialData.animFileName == null) {
      return FileUtils.fileExists(paramMaterialData.res_path);
    }
    paramMaterialData = new File(paramMaterialData.res_path, paramMaterialData.animFileName);
    return (paramMaterialData.exists()) && (paramMaterialData.isFile()) && (paramMaterialData.canRead());
  }
  
  public static final boolean b(@NotNull MaterialData paramMaterialData)
  {
    Intrinsics.checkParameterIsNotNull(paramMaterialData, "$this$isManifestFileExit");
    paramMaterialData = new File(paramMaterialData.res_path, "manifest.json");
    return (paramMaterialData.exists()) && (paramMaterialData.isFile()) && (paramMaterialData.canRead());
  }
  
  public static final boolean c(@Nullable MaterialData paramMaterialData)
  {
    boolean bool = true;
    if (paramMaterialData == null) {
      return true;
    }
    if (paramMaterialData.superMaskType != 0)
    {
      if (paramMaterialData.superMaskType == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.super_mask.SuperMaskExtKt
 * JD-Core Version:    0.7.0.1
 */