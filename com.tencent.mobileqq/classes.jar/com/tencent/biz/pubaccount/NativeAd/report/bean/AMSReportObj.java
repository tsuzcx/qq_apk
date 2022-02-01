package com.tencent.biz.pubaccount.NativeAd.report.bean;

import com.tencent.biz.pubaccount.NativeAd.report.IReportObj;
import com.tencent.biz.pubaccount.NativeAd.report.ReportExKt;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.report.util.AdReportUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/bean/AMSReportObj;", "Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "()V", "amsClickUrl", "", "amsConvUrl", "amsExpUrl", "amsNFBUrl", "getKey", "parseAdReportData", "", "adReportData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;", "toJsonObject", "Lorg/json/JSONObject;", "valid", "", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class AMSReportObj
  extends IReportObj
{
  private String a;
  private String b;
  private String c;
  private String d;
  
  @NotNull
  public String a()
  {
    return "report";
  }
  
  public void a(@NotNull AdReportData paramAdReportData)
  {
    Intrinsics.checkParameterIsNotNull(paramAdReportData, "adReportData");
    ReportAction localReportAction = AdReportUtil.a(paramAdReportData);
    if (localReportAction == null) {
      return;
    }
    int i = AMSReportObj.WhenMappings.$EnumSwitchMapping$0[localReportAction.ordinal()];
    if ((i != 1) && (i != 2))
    {
      if (i != 3)
      {
        if (i != 4) {
          return;
        }
        this.d = AdReportUtil.f(paramAdReportData);
        return;
      }
      if (paramAdReportData.g() != null)
      {
        this.b = paramAdReportData.g().mAdRl;
        this.c = paramAdReportData.g().mAdEffectUrl;
      }
    }
    else if (paramAdReportData.g() != null)
    {
      this.a = paramAdReportData.g().mAdApurl;
    }
  }
  
  @Nullable
  public JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    ReportExKt.a(localJSONObject, "amsExpUrl", this.a);
    ReportExKt.a(localJSONObject, "amsClickUrl", this.b);
    ReportExKt.a(localJSONObject, "amsConvUrl", this.c);
    ReportExKt.a(localJSONObject, "amsNFBUrl", this.d);
    return localJSONObject;
  }
  
  public boolean c()
  {
    return (this.a != null) || (this.b != null) || (this.c != null) || (this.d != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.bean.AMSReportObj
 * JD-Core Version:    0.7.0.1
 */