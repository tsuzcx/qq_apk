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
  private String a;
  private Long b;
  private Integer c;
  private Integer d;
  private Integer e;
  private Integer f;
  private Integer g;
  private Integer h;
  private Integer i;
  private Integer j;
  private Integer k;
  private String l;
  private Integer m;
  private Integer n;
  private String o;
  private Integer p;
  private Integer q;
  
  @NotNull
  public String a()
  {
    return "common";
  }
  
  public final void a(@NotNull ActionEntity paramActionEntity)
  {
    Intrinsics.checkParameterIsNotNull(paramActionEntity, "actionEntity");
    this.n = Integer.valueOf(paramActionEntity.getValue());
  }
  
  public void a(@NotNull AdReportData paramAdReportData)
  {
    Intrinsics.checkParameterIsNotNull(paramAdReportData, "adReportData");
    ReportAction localReportAction = AdReportUtil.a(paramAdReportData);
    Intrinsics.checkExpressionValueIsNotNull(localReportAction, "reportAction");
    this.a = localReportAction.getValue();
    this.b = Long.valueOf(System.currentTimeMillis());
    Object localObject;
    if (paramAdReportData.v() == null)
    {
      localObject = AdReportUtil.b(paramAdReportData);
      Intrinsics.checkExpressionValueIsNotNull(localObject, "AdReportUtil.parseActionEntity(adReportData)");
      localObject = Integer.valueOf(((ActionEntity)localObject).getValue());
    }
    else
    {
      localObject = paramAdReportData.v();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "adReportData.actionEntity");
      localObject = Integer.valueOf(((ActionEntity)localObject).getValue());
    }
    this.n = ((Integer)localObject);
    if ((localReportAction != ReportAction.CLICK) && (localReportAction != ReportAction.CLOSE))
    {
      this.m = Integer.valueOf(0);
    }
    else
    {
      this.h = Integer.valueOf(paramAdReportData.m());
      if ((paramAdReportData.g() != null) && (paramAdReportData.g().mSoftAdType != 0) && (paramAdReportData.g().adClickPos != null))
      {
        localObject = paramAdReportData.g().adClickPos;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "adReportData.advertisementInfo.adClickPos");
        this.h = Integer.valueOf(((AdClickPos)localObject).getValue());
      }
      this.m = AdReportUtil.g(paramAdReportData);
    }
    if (localReportAction == ReportAction.EXPOSE)
    {
      if (!paramAdReportData.u())
      {
        localObject = paramAdReportData.t();
        if ((localObject == null) || (((Integer)localObject).intValue() != 2))
        {
          this.g = Integer.valueOf(1);
          this.k = Integer.valueOf(50);
          this.j = Integer.valueOf(1000);
          break label278;
        }
      }
      this.g = Integer.valueOf(2);
      this.k = Integer.valueOf(1);
      this.j = Integer.valueOf(0);
      label278:
      if (paramAdReportData.g() != null) {
        this.e = Integer.valueOf(paramAdReportData.g().mAdKdPos + 1);
      }
    }
    paramAdReportData = AdSessionManager.a();
    Intrinsics.checkExpressionValueIsNotNull(paramAdReportData, "AdSessionManager.getInstance()");
    this.o = paramAdReportData.b();
    paramAdReportData = AdSessionManager.a();
    Intrinsics.checkExpressionValueIsNotNull(paramAdReportData, "AdSessionManager.getInstance()");
    this.q = Integer.valueOf(paramAdReportData.c());
    paramAdReportData = AdSessionManager.a();
    Intrinsics.checkExpressionValueIsNotNull(paramAdReportData, "AdSessionManager.getInstance()");
    this.p = Integer.valueOf(paramAdReportData.e());
  }
  
  @Nullable
  public JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    ReportExKt.a(localJSONObject, "action", this.a);
    ReportExKt.a(localJSONObject, "actionTime", this.b);
    ReportExKt.a(localJSONObject, "uiType", this.c);
    ReportExKt.a(localJSONObject, "adSlot", this.d);
    ReportExKt.a(localJSONObject, "adSlotOffTop", this.e);
    ReportExKt.a(localJSONObject, "sceneAdNumber", this.f);
    ReportExKt.a(localJSONObject, "exposeType", this.g);
    ReportExKt.a(localJSONObject, "clickPos", this.h);
    ReportExKt.a(localJSONObject, "splashClickDuration", this.i);
    ReportExKt.a(localJSONObject, "exposeDuration", this.j);
    ReportExKt.a(localJSONObject, "exposePercent", this.k);
    ReportExKt.a(localJSONObject, "statisticsSource", this.l);
    ReportExKt.a(localJSONObject, "jumpMode", this.m);
    ReportExKt.a(localJSONObject, "actionEntity", this.n);
    ReportExKt.a(localJSONObject, "scene_trace_id", this.o);
    ReportExKt.a(localJSONObject, "scene_series_num", this.p);
    ReportExKt.a(localJSONObject, "refresh_series_num", this.q);
    return localJSONObject;
  }
  
  public boolean c()
  {
    return this.a != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.bean.CommonReportObj
 * JD-Core Version:    0.7.0.1
 */