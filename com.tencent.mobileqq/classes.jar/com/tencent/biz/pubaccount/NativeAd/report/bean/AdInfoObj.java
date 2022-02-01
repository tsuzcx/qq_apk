package com.tencent.biz.pubaccount.NativeAd.report.bean;

import com.tencent.biz.pubaccount.NativeAd.report.IReportObj;
import com.tencent.biz.pubaccount.NativeAd.report.ReportExKt;
import com.tencent.biz.pubaccount.NativeAd.report.util.AdReportUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/bean/AdInfoObj;", "Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "()V", "aindex", "", "getKey", "parseAdReportData", "", "adReportData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;", "toJsonObject", "Lorg/json/JSONObject;", "valid", "", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class AdInfoObj
  extends IReportObj
{
  private String a;
  
  @NotNull
  public String a()
  {
    return "adinfo";
  }
  
  public void a(@NotNull AdReportData paramAdReportData)
  {
    Intrinsics.checkParameterIsNotNull(paramAdReportData, "adReportData");
    this.a = AdReportUtil.h(paramAdReportData);
  }
  
  @Nullable
  public JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      ReportExKt.a(localJSONObject, "aindex", this.a);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      label20:
      break label20;
    }
    ReportExKt.a(localJSONObject, "aindex", "");
    return localJSONObject;
  }
  
  public boolean c()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.bean.AdInfoObj
 * JD-Core Version:    0.7.0.1
 */