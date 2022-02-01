package com.tencent.biz.pubaccount.NativeAd.report;

import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/ReportData;", "", "()V", "reportJson", "Lorg/json/JSONObject;", "reportJsonMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "appendData", "data", "Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "isEmpty", "", "toReportJsonMap", "toReportJsonObject", "toReportString", "Companion", "kandian-ad-api_release"}, k=1, mv={1, 1, 16})
public final class ReportData
{
  public static final ReportData.Companion a;
  private final HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private final JSONObject jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
  
  static
  {
    jdField_a_of_type_ComTencentBizPubaccountNativeAdReportReportData$Companion = new ReportData.Companion(null);
  }
  
  @NotNull
  public final ReportData a(@Nullable IReportObj paramIReportObj)
  {
    if (paramIReportObj != null)
    {
      JSONObject localJSONObject = paramIReportObj.a();
      if (localJSONObject != null)
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put(paramIReportObj.a(), localJSONObject);
        paramIReportObj = (String)this.jdField_a_of_type_JavaUtilHashMap.put(paramIReportObj.a(), localJSONObject.toString());
      }
    }
    return this;
  }
  
  @Nullable
  public final String a()
  {
    return this.jdField_a_of_type_OrgJsonJSONObject.toString();
  }
  
  @NotNull
  public final HashMap<String, String> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  @Nullable
  public final JSONObject a()
  {
    return this.jdField_a_of_type_OrgJsonJSONObject;
  }
  
  public final boolean a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap.isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.ReportData
 * JD-Core Version:    0.7.0.1
 */