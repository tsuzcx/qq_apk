package com.tencent.biz.pubaccount.NativeAd.report.bean;

import com.tencent.biz.pubaccount.NativeAd.report.AdSessionManager;
import com.tencent.biz.pubaccount.NativeAd.report.IReportObj;
import com.tencent.biz.pubaccount.NativeAd.report.ReportExKt;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.report.util.AdReportUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/bean/CommonReportObj;", "Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "()V", "action", "", "actionEntity", "", "Ljava/lang/Integer;", "actionTime", "", "Ljava/lang/Long;", "adSlot", "adSlotOffTop", "clickPos", "exposeDuration", "exposePercent", "exposeType", "jumpMode", "refreshSeriesNum", "sceneAdNumber", "sceneSeriesNum", "sceneTraceID", "splashClickDuration", "statisticsSource", "uiType", "getKey", "parseAdReportData", "", "adReportData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;", "setActionEntity", "Lcom/tencent/biz/pubaccount/NativeAd/report/constant/ActionEntity;", "toJsonObject", "Lorg/json/JSONObject;", "valid", "", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class CommonReportObj
  extends IReportObj
{
  private Integer jdField_a_of_type_JavaLangInteger;
  private Long jdField_a_of_type_JavaLangLong;
  private String jdField_a_of_type_JavaLangString;
  private Integer jdField_b_of_type_JavaLangInteger;
  private String jdField_b_of_type_JavaLangString;
  private Integer jdField_c_of_type_JavaLangInteger;
  private String jdField_c_of_type_JavaLangString;
  private Integer d;
  private Integer e;
  private Integer f;
  private Integer g;
  private Integer h;
  private Integer i;
  private Integer j;
  private Integer k;
  private Integer l;
  private Integer m;
  
  @NotNull
  public String a()
  {
    return "common";
  }
  
  @Nullable
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    ReportExKt.a(localJSONObject, "action", this.jdField_a_of_type_JavaLangString);
    ReportExKt.a(localJSONObject, "actionTime", this.jdField_a_of_type_JavaLangLong);
    ReportExKt.a(localJSONObject, "uiType", this.jdField_a_of_type_JavaLangInteger);
    ReportExKt.a(localJSONObject, "adSlot", this.jdField_b_of_type_JavaLangInteger);
    ReportExKt.a(localJSONObject, "adSlotOffTop", this.jdField_c_of_type_JavaLangInteger);
    ReportExKt.a(localJSONObject, "sceneAdNumber", this.d);
    ReportExKt.a(localJSONObject, "exposeType", this.e);
    ReportExKt.a(localJSONObject, "clickPos", this.f);
    ReportExKt.a(localJSONObject, "splashClickDuration", this.g);
    ReportExKt.a(localJSONObject, "exposeDuration", this.h);
    ReportExKt.a(localJSONObject, "exposePercent", this.i);
    ReportExKt.a(localJSONObject, "statisticsSource", this.jdField_b_of_type_JavaLangString);
    ReportExKt.a(localJSONObject, "jumpMode", this.j);
    ReportExKt.a(localJSONObject, "actionEntity", this.k);
    ReportExKt.a(localJSONObject, "scene_trace_id", this.jdField_c_of_type_JavaLangString);
    ReportExKt.a(localJSONObject, "scene_series_num", this.l);
    ReportExKt.a(localJSONObject, "refresh_series_num", this.m);
    return localJSONObject;
  }
  
  public final void a(@NotNull ActionEntity paramActionEntity)
  {
    Intrinsics.checkParameterIsNotNull(paramActionEntity, "actionEntity");
    this.k = Integer.valueOf(paramActionEntity.getValue());
  }
  
  public void a(@NotNull AdReportData paramAdReportData)
  {
    Intrinsics.checkParameterIsNotNull(paramAdReportData, "adReportData");
    ReportAction localReportAction = AdReportUtil.a(paramAdReportData);
    Intrinsics.checkExpressionValueIsNotNull(localReportAction, "reportAction");
    this.jdField_a_of_type_JavaLangString = localReportAction.getValue();
    this.jdField_a_of_type_JavaLangLong = Long.valueOf(System.currentTimeMillis());
    Object localObject;
    if (paramAdReportData.a() == null)
    {
      localObject = AdReportUtil.a(paramAdReportData);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "AdReportUtil.parseActionEntity(adReportData)");
      localObject = Integer.valueOf(((ActionEntity)localObject).getValue());
    }
    else
    {
      localObject = paramAdReportData.a();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "adReportData.actionEntity");
      localObject = Integer.valueOf(((ActionEntity)localObject).getValue());
    }
    this.k = ((Integer)localObject);
    if ((localReportAction != ReportAction.CLICK) && (localReportAction != ReportAction.CLOSE))
    {
      this.j = Integer.valueOf(0);
    }
    else
    {
      this.f = Integer.valueOf(paramAdReportData.d());
      if ((paramAdReportData.a() != null) && (paramAdReportData.a().mSoftAdType != 0) && (paramAdReportData.a().adClickPos != null))
      {
        localObject = paramAdReportData.a().adClickPos;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "adReportData.advertisementInfo.adClickPos");
        this.f = Integer.valueOf(((AdClickPos)localObject).getValue());
      }
      this.j = AdReportUtil.a(paramAdReportData);
    }
    if (localReportAction == ReportAction.EXPOSE)
    {
      if (!paramAdReportData.b())
      {
        localObject = paramAdReportData.a();
        if ((localObject == null) || (((Integer)localObject).intValue() != 2))
        {
          this.e = Integer.valueOf(1);
          this.i = Integer.valueOf(50);
          this.h = Integer.valueOf(1000);
          break label278;
        }
      }
      this.e = Integer.valueOf(2);
      this.i = Integer.valueOf(1);
      this.h = Integer.valueOf(0);
      label278:
      if (paramAdReportData.a() != null) {
        this.jdField_c_of_type_JavaLangInteger = Integer.valueOf(paramAdReportData.a().mAdKdPos + 1);
      }
    }
    paramAdReportData = AdSessionManager.a();
    Intrinsics.checkExpressionValueIsNotNull(paramAdReportData, "AdSessionManager.getInstance()");
    this.jdField_c_of_type_JavaLangString = paramAdReportData.a();
    paramAdReportData = AdSessionManager.a();
    Intrinsics.checkExpressionValueIsNotNull(paramAdReportData, "AdSessionManager.getInstance()");
    this.m = Integer.valueOf(paramAdReportData.a());
    paramAdReportData = AdSessionManager.a();
    Intrinsics.checkExpressionValueIsNotNull(paramAdReportData, "AdSessionManager.getInstance()");
    this.l = Integer.valueOf(paramAdReportData.b());
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaLangString != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.bean.CommonReportObj
 * JD-Core Version:    0.7.0.1
 */