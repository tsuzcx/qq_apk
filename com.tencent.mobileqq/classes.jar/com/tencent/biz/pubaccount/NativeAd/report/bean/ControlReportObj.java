package com.tencent.biz.pubaccount.NativeAd.report.bean;

import com.tencent.biz.pubaccount.NativeAd.report.IReportObj;
import com.tencent.biz.pubaccount.NativeAd.report.ReportExKt;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.NativeAd.report.util.AdReportUtil;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdReportData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/bean/ControlReportObj;", "Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "()V", "debug", "", "noforwardAMS", "", "Ljava/lang/Integer;", "ticket", "getKey", "parseAdReportData", "", "adReportData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;", "toJsonObject", "Lorg/json/JSONObject;", "valid", "", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ControlReportObj
  extends IReportObj
{
  private Integer jdField_a_of_type_JavaLangInteger = Integer.valueOf(1);
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  @NotNull
  public String a()
  {
    return "control";
  }
  
  @Nullable
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    ReportExKt.a(localJSONObject, "ticket", this.jdField_a_of_type_JavaLangString);
    ReportExKt.a(localJSONObject, "debug", this.b);
    ReportExKt.a(localJSONObject, "noForward", this.jdField_a_of_type_JavaLangInteger);
    return localJSONObject;
  }
  
  public void a(@NotNull AdReportData paramAdReportData)
  {
    Intrinsics.checkParameterIsNotNull(paramAdReportData, "adReportData");
    this.jdField_a_of_type_JavaLangString = AdReportUtil.b(paramAdReportData);
    ReportAction localReportAction = AdReportUtil.a(paramAdReportData);
    Object localObject = ReportAction.VIDEO_SEE_TIME;
    Integer localInteger = Integer.valueOf(0);
    if ((localReportAction != localObject) && (localReportAction != ReportAction.NFB)) {
      localObject = Integer.valueOf(1);
    } else {
      localObject = localInteger;
    }
    this.jdField_a_of_type_JavaLangInteger = ((Integer)localObject);
    if (paramAdReportData.b() == 28) {
      this.jdField_a_of_type_JavaLangInteger = localInteger;
    }
    if (((localReportAction == ReportAction.CLICK) || (localReportAction == ReportAction.EXPOSE)) && ((paramAdReportData.b() == 31) || (paramAdReportData.b() == 32))) {
      this.jdField_a_of_type_JavaLangInteger = localInteger;
    }
    if ((localReportAction == ReportAction.CLICK) && ((paramAdReportData.b() == 27) || (paramAdReportData.b() == 29))) {
      this.jdField_a_of_type_JavaLangInteger = localInteger;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaLangString != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.bean.ControlReportObj
 * JD-Core Version:    0.7.0.1
 */