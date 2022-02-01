package com.tencent.biz.pubaccount.NativeAd.report;

import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "", "()V", "getKey", "", "parseAdReportData", "", "adReportData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;", "toJsonObject", "Lorg/json/JSONObject;", "valid", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract class IReportObj
{
  @NotNull
  public abstract String a();
  
  @Nullable
  public abstract JSONObject a();
  
  public abstract void a(@NotNull AdReportData paramAdReportData);
  
  public abstract boolean a();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.IReportObj
 * JD-Core Version:    0.7.0.1
 */