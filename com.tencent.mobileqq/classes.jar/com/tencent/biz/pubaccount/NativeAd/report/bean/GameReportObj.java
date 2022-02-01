package com.tencent.biz.pubaccount.NativeAd.report.bean;

import com.tencent.biz.pubaccount.NativeAd.report.IReportObj;
import com.tencent.biz.pubaccount.NativeAd.report.ReportExKt;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/bean/GameReportObj;", "Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "()V", "downloadWay", "", "Ljava/lang/Integer;", "horizonPos", "isGetYyb", "operModule", "getKey", "", "parseAdReportData", "", "adReportData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;", "toJsonObject", "Lorg/json/JSONObject;", "valid", "", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class GameReportObj
  extends IReportObj
{
  private Integer a;
  private Integer b;
  private Integer c;
  private Integer d;
  
  @NotNull
  public String a()
  {
    return "soft";
  }
  
  public void a(@NotNull AdReportData paramAdReportData)
  {
    Intrinsics.checkParameterIsNotNull(paramAdReportData, "adReportData");
  }
  
  @Nullable
  public JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    ReportExKt.a(localJSONObject, "operModule", this.a);
    ReportExKt.a(localJSONObject, "horizonPos", this.b);
    ReportExKt.a(localJSONObject, "downloadWay", this.c);
    ReportExKt.a(localJSONObject, "isGetYyb", this.d);
    return localJSONObject;
  }
  
  public boolean c()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.bean.GameReportObj
 * JD-Core Version:    0.7.0.1
 */