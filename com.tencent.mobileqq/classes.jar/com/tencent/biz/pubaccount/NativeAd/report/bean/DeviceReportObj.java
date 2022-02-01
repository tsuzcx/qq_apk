package com.tencent.biz.pubaccount.NativeAd.report.bean;

import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.NativeAd.report.IReportObj;
import com.tencent.biz.pubaccount.NativeAd.report.ReportExKt;
import com.tencent.biz.pubaccount.NativeAd.report.util.AdReportUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/bean/DeviceReportObj;", "Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "()V", "apnType", "", "Ljava/lang/Integer;", "guid", "", "loginSkey", "omgid", "uin", "", "Ljava/lang/Long;", "userAgent", "getKey", "parseAdReportData", "", "adReportData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;", "toJsonObject", "Lorg/json/JSONObject;", "valid", "", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DeviceReportObj
  extends IReportObj
{
  private String a;
  private Long b;
  private String c;
  private Integer d;
  private String e;
  private String f;
  
  @NotNull
  public String a()
  {
    return "device";
  }
  
  public void a(@NotNull AdReportData paramAdReportData)
  {
    Intrinsics.checkParameterIsNotNull(paramAdReportData, "adReportData");
    paramAdReportData = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getAccount();
    if (paramAdReportData != null) {}
    try
    {
      this.b = Long.valueOf(Long.parseLong(paramAdReportData));
      label38:
      this.c = "";
      this.d = Integer.valueOf(PublicAccountAdUtil.a());
      this.e = AppSetting.g();
      this.f = AdReportUtil.a();
      return;
    }
    catch (Throwable paramAdReportData)
    {
      break label38;
    }
  }
  
  @Nullable
  public JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    ReportExKt.a(localJSONObject, "guid", this.a);
    ReportExKt.a(localJSONObject, "uin", this.b);
    ReportExKt.a(localJSONObject, "omgid", this.c);
    ReportExKt.a(localJSONObject, "apnType", this.d);
    ReportExKt.a(localJSONObject, "userAgent", this.e);
    ReportExKt.a(localJSONObject, "loginSkey", this.f);
    return localJSONObject;
  }
  
  public boolean c()
  {
    return this.b != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.bean.DeviceReportObj
 * JD-Core Version:    0.7.0.1
 */