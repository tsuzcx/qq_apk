package com.tencent.biz.pubaccount.NativeAd.report.bean;

import android.content.Context;
import com.tencent.biz.pubaccount.NativeAd.report.IReportObj;
import com.tencent.biz.pubaccount.NativeAd.report.ReportExKt;
import com.tencent.biz.pubaccount.NativeAd.report.util.AdReportUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/bean/AppReportObj;", "Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "()V", "appInstallStatus", "", "getKey", "", "parseAdReportData", "", "adReportData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;", "toJsonObject", "Lorg/json/JSONObject;", "valid", "", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class AppReportObj
  extends IReportObj
{
  private int a;
  
  @NotNull
  public String a()
  {
    return "app";
  }
  
  @Nullable
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    ReportExKt.a(localJSONObject, "appInstallStatus", Integer.valueOf(this.a));
    return localJSONObject;
  }
  
  public void a(@NotNull AdReportData paramAdReportData)
  {
    Intrinsics.checkParameterIsNotNull(paramAdReportData, "adReportData");
    if (paramAdReportData.a() == null) {
      return;
    }
    String str = paramAdReportData.a().packageName;
    Intrinsics.checkExpressionValueIsNotNull(str, "adReportData.advertisementInfo.packageName");
    int i;
    if (((CharSequence)str).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (AdReportUtil.a((Context)BaseApplication.context, paramAdReportData.a().getPackageName()))
      {
        this.a = 1;
        return;
      }
      this.a = 2;
    }
  }
  
  public boolean a()
  {
    return this.a != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.bean.AppReportObj
 * JD-Core Version:    0.7.0.1
 */