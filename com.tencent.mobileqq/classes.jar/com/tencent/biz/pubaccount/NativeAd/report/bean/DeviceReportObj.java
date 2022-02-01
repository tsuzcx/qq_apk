package com.tencent.biz.pubaccount.NativeAd.report.bean;

import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.NativeAd.report.IReportObj;
import com.tencent.biz.pubaccount.NativeAd.report.ReportExKt;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/bean/DeviceReportObj;", "Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "()V", "apnType", "", "Ljava/lang/Integer;", "guid", "", "omgid", "uin", "", "Ljava/lang/Long;", "userAgent", "getKey", "parseAdReportData", "", "adReportData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;", "toJsonObject", "Lorg/json/JSONObject;", "valid", "", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class DeviceReportObj
  extends IReportObj
{
  private Integer jdField_a_of_type_JavaLangInteger;
  private Long jdField_a_of_type_JavaLangLong;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  
  @NotNull
  public String a()
  {
    return "device";
  }
  
  @Nullable
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    ReportExKt.a(localJSONObject, "guid", this.jdField_a_of_type_JavaLangString);
    ReportExKt.a(localJSONObject, "uin", this.jdField_a_of_type_JavaLangLong);
    ReportExKt.a(localJSONObject, "omgid", this.b);
    ReportExKt.a(localJSONObject, "apnType", this.jdField_a_of_type_JavaLangInteger);
    ReportExKt.a(localJSONObject, "userAgent", this.c);
    return localJSONObject;
  }
  
  public void a(@NotNull AdReportData paramAdReportData)
  {
    Intrinsics.checkParameterIsNotNull(paramAdReportData, "adReportData");
    paramAdReportData = ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getAppRuntime().getAccount();
    if (paramAdReportData != null) {}
    try
    {
      this.jdField_a_of_type_JavaLangLong = Long.valueOf(Long.parseLong(paramAdReportData));
      label38:
      this.b = "";
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(PublicAccountAdUtil.a());
      this.c = AppSetting.e();
      return;
    }
    catch (Throwable paramAdReportData)
    {
      break label38;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaLangLong != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.bean.DeviceReportObj
 * JD-Core Version:    0.7.0.1
 */