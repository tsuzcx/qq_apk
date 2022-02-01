package com.tencent.biz.pubaccount.NativeAd.report.bean;

import com.tencent.biz.pubaccount.NativeAd.report.IReportObj;
import com.tencent.biz.pubaccount.NativeAd.report.ReportExKt;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/bean/AdLoadReportObj;", "Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "()V", "lastAdDistance", "", "lastAdDistanceVV", "lastAdTime", "getKey", "parseAdReportData", "", "adReportData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;", "toJsonObject", "Lorg/json/JSONObject;", "valid", "", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class AdLoadReportObj
  extends IReportObj
{
  private String a;
  private String b;
  private String c;
  
  @NotNull
  public String a()
  {
    return "adload";
  }
  
  @Nullable
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localObject1 = this.a;
      localObject3 = null;
      if (localObject1 == null) {
        break label131;
      }
      localObject1 = Integer.valueOf(Integer.parseInt((String)localObject1));
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject3;
        String str;
        continue;
        Object localObject2 = null;
        continue;
        localObject2 = null;
      }
    }
    ReportExKt.a(localJSONObject, "lastAdDistance", localObject1);
    localObject1 = this.b;
    if (localObject1 != null)
    {
      localObject1 = Integer.valueOf(Integer.parseInt((String)localObject1));
      ReportExKt.a(localJSONObject, "lastAdDuration", localObject1);
      str = this.c;
      localObject1 = localObject3;
      if (str != null) {
        localObject1 = Integer.valueOf(Integer.parseInt(str));
      }
      ReportExKt.a(localJSONObject, "lastAdDistanceVV", localObject1);
      return localJSONObject;
      ReportExKt.a(localJSONObject, "lastAdDistance", Integer.valueOf(0));
      ReportExKt.a(localJSONObject, "lastAdDuration", Integer.valueOf(0));
      ReportExKt.a(localJSONObject, "lastAdDistanceVV", Integer.valueOf(0));
      return localJSONObject;
    }
  }
  
  public void a(@NotNull AdReportData paramAdReportData)
  {
    Intrinsics.checkParameterIsNotNull(paramAdReportData, "adReportData");
    try
    {
      paramAdReportData = new JSONObject(paramAdReportData.e().optString("exposure_info_report"));
      this.a = paramAdReportData.optString("last_ad_distance");
      this.b = paramAdReportData.optString("last_ad_time");
      this.c = paramAdReportData.optString("last_ad_distance_vv");
      return;
    }
    catch (Throwable paramAdReportData) {}
  }
  
  public boolean a()
  {
    return this.a != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.bean.AdLoadReportObj
 * JD-Core Version:    0.7.0.1
 */