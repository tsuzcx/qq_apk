package com.tencent.biz.pubaccount.NativeAd.report;

import java.util.HashMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/ReportData;", "", "()V", "reportJson", "Lorg/json/JSONObject;", "reportJsonMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "appendData", "data", "Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "isEmpty", "", "toReportJsonMap", "toReportJsonObject", "toReportString", "Companion", "kandian-ad-api_release"}, k=1, mv={1, 1, 16})
public final class ReportData
{
  public static final ReportData.Companion a = new ReportData.Companion(null);
  private final JSONObject b = new JSONObject();
  private final HashMap<String, String> c = new HashMap();
  
  @NotNull
  public final ReportData a(@Nullable IReportObj paramIReportObj)
  {
    if (paramIReportObj != null)
    {
      JSONObject localJSONObject = paramIReportObj.b();
      if (localJSONObject != null)
      {
        this.b.put(paramIReportObj.a(), localJSONObject);
        paramIReportObj = (String)this.c.put(paramIReportObj.a(), localJSONObject.toString());
      }
    }
    return this;
  }
  
  @Nullable
  public final JSONObject a()
  {
    return this.b;
  }
  
  @Nullable
  public final String b()
  {
    return this.b.toString();
  }
  
  @NotNull
  public final HashMap<String, String> c()
  {
    return this.c;
  }
  
  public final boolean d()
  {
    return this.c.isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.ReportData
 * JD-Core Version:    0.7.0.1
 */