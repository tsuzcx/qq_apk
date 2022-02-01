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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/bean/VideoReportObj;", "Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "()V", "videoBeginFrame", "", "videoBeginTime", "videoDuration", "videoEndFrame", "videoEndTime", "videoEndType", "videoPlayDuration", "Ljava/lang/Integer;", "videoPlayError", "videoPlayPostion", "videoPlayType", "videoReplayCount", "getKey", "", "parseAdReportData", "", "adReportData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;", "parseVideoEndType", "json", "Lorg/json/JSONObject;", "parseVideoPlayError", "parseVideoPlayType", "toJsonObject", "valid", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoReportObj
  extends IReportObj
{
  private int jdField_a_of_type_Int;
  private Integer jdField_a_of_type_JavaLangInteger;
  private int jdField_b_of_type_Int;
  private Integer jdField_b_of_type_JavaLangInteger;
  private int jdField_c_of_type_Int = 1;
  private Integer jdField_c_of_type_JavaLangInteger;
  private int jdField_d_of_type_Int = 1;
  private Integer jdField_d_of_type_JavaLangInteger;
  private int e;
  private int f = 1;
  private int g;
  
  private final int a(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.optBoolean("isClickReplay") == true)) {
      return 12;
    }
    if ((paramJSONObject == null) || (paramJSONObject.optInt("videoReplayCount") != 0)) {
      return 13;
    }
    return 11;
  }
  
  private final int b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return 0;
    }
    return paramJSONObject.optInt("videoEndType", 0);
  }
  
  private final int c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return 0;
    }
    return paramJSONObject.optInt("ps", 0);
  }
  
  @NotNull
  public String a()
  {
    return "video";
  }
  
  @Nullable
  public JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    ReportExKt.a(localJSONObject, "videoBeginTime", Integer.valueOf(this.jdField_a_of_type_Int));
    ReportExKt.a(localJSONObject, "videoEndTime", Integer.valueOf(this.jdField_b_of_type_Int));
    ReportExKt.a(localJSONObject, "videoBeginFrame", Integer.valueOf(this.jdField_c_of_type_Int));
    ReportExKt.a(localJSONObject, "videoEndFrame", Integer.valueOf(this.jdField_d_of_type_Int));
    ReportExKt.a(localJSONObject, "videoPlayPosition", Integer.valueOf(this.e));
    ReportExKt.a(localJSONObject, "videoEndType", Integer.valueOf(this.f));
    ReportExKt.a(localJSONObject, "videoDuration", Integer.valueOf(this.g));
    ReportExKt.a(localJSONObject, "videoPlayError", this.jdField_a_of_type_JavaLangInteger);
    ReportExKt.a(localJSONObject, "videoPlayDuration", this.jdField_b_of_type_JavaLangInteger);
    ReportExKt.a(localJSONObject, "videoPlayType", this.jdField_c_of_type_JavaLangInteger);
    ReportExKt.a(localJSONObject, "videoReplayCount", this.jdField_d_of_type_JavaLangInteger);
    return localJSONObject;
  }
  
  public void a(@NotNull AdReportData paramAdReportData)
  {
    Intrinsics.checkParameterIsNotNull(paramAdReportData, "adReportData");
    if (AdReportUtil.a(paramAdReportData) != ReportAction.VIDEO_SEE_TIME) {}
    do
    {
      return;
      paramAdReportData = paramAdReportData.a();
    } while (paramAdReportData == null);
    try
    {
      this.jdField_a_of_type_Int = paramAdReportData.optInt("bt");
      this.jdField_b_of_type_Int = paramAdReportData.optInt("et");
      this.jdField_c_of_type_Int = paramAdReportData.optInt("bf");
      this.jdField_d_of_type_Int = paramAdReportData.optInt("ef");
      if (paramAdReportData.optBoolean("isVideoFeedsRecommend")) {
        this.e = 11;
      }
      this.jdField_c_of_type_JavaLangInteger = Integer.valueOf(a(paramAdReportData));
      this.f = b(paramAdReportData);
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(c(paramAdReportData));
      this.g = paramAdReportData.optInt("duration");
      this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(this.jdField_b_of_type_Int - this.jdField_a_of_type_Int);
      this.jdField_d_of_type_JavaLangInteger = Integer.valueOf(paramAdReportData.optInt("videoReplayCount"));
      return;
    }
    catch (Throwable paramAdReportData) {}
  }
  
  public boolean a()
  {
    int i = this.jdField_a_of_type_Int;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.bean.VideoReportObj
 * JD-Core Version:    0.7.0.1
 */