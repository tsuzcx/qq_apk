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
  private String a;
  private String b;
  private Integer c = Integer.valueOf(1);
  
  @NotNull
  public String a()
  {
    return "control";
  }
  
  public void a(@NotNull AdReportData paramAdReportData)
  {
    Intrinsics.checkParameterIsNotNull(paramAdReportData, "adReportData");
    this.a = AdReportUtil.e(paramAdReportData);
    ReportAction localReportAction = AdReportUtil.a(paramAdReportData);
    Object localObject = ReportAction.VIDEO_SEE_TIME;
    Integer localInteger = Integer.valueOf(0);
    if ((localReportAction != localObject) && (localReportAction != ReportAction.NFB)) {
      localObject = Integer.valueOf(1);
    } else {
      localObject = localInteger;
    }
    this.c = ((Integer)localObject);
    if (paramAdReportData.d() == 28) {
      this.c = localInteger;
    }
    if (((localReportAction == ReportAction.CLICK) || (localReportAction == ReportAction.EXPOSE)) && ((paramAdReportData.d() == 31) || (paramAdReportData.d() == 32))) {
      this.c = localInteger;
    }
    if ((localReportAction == ReportAction.CLICK) && ((paramAdReportData.d() == 27) || (paramAdReportData.d() == 29))) {
      this.c = localInteger;
    }
  }
  
  @Nullable
  public JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    ReportExKt.a(localJSONObject, "ticket", this.a);
    ReportExKt.a(localJSONObject, "debug", this.b);
    ReportExKt.a(localJSONObject, "noForward", this.c);
    return localJSONObject;
  }
  
  public boolean c()
  {
    return this.a != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.bean.ControlReportObj
 * JD-Core Version:    0.7.0.1
 */