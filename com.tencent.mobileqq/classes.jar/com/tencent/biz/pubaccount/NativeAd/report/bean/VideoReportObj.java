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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/NativeAd/report/bean/VideoReportObj;", "Lcom/tencent/biz/pubaccount/NativeAd/report/IReportObj;", "()V", "videoBeginFrame", "", "getVideoBeginFrame", "()I", "setVideoBeginFrame", "(I)V", "videoBeginTime", "getVideoBeginTime", "setVideoBeginTime", "videoDuration", "getVideoDuration", "setVideoDuration", "videoEndFrame", "getVideoEndFrame", "setVideoEndFrame", "videoEndTime", "getVideoEndTime", "setVideoEndTime", "videoEndType", "getVideoEndType", "setVideoEndType", "videoPlayDuration", "getVideoPlayDuration", "()Ljava/lang/Integer;", "setVideoPlayDuration", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "videoPlayError", "getVideoPlayError", "setVideoPlayError", "videoPlayPostion", "getVideoPlayPostion", "setVideoPlayPostion", "videoPlayType", "getVideoPlayType", "setVideoPlayType", "videoReplayCount", "getVideoReplayCount", "setVideoReplayCount", "getKey", "", "parseAdReportData", "", "adReportData", "Lcom/tencent/biz/pubaccount/readinjoyAd/ad/data/AdReportData;", "parseVideoEndType", "json", "Lorg/json/JSONObject;", "parseVideoPlayError", "parseVideoPlayType", "toJsonObject", "valid", "", "kandian_ad_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class VideoReportObj
  extends IReportObj
{
  private int jdField_a_of_type_Int;
  @Nullable
  private Integer jdField_a_of_type_JavaLangInteger;
  private int jdField_b_of_type_Int;
  @Nullable
  private Integer jdField_b_of_type_JavaLangInteger;
  private int jdField_c_of_type_Int = 1;
  @Nullable
  private Integer jdField_c_of_type_JavaLangInteger;
  private int jdField_d_of_type_Int = 1;
  @Nullable
  private Integer jdField_d_of_type_JavaLangInteger;
  private int e;
  private int f = 1;
  private int g;
  
  private final int a(JSONObject paramJSONObject)
  {
    if ((paramJSONObject != null) && (paramJSONObject.optBoolean("isClickReplay") == true)) {
      return 12;
    }
    if ((paramJSONObject != null) && (paramJSONObject.optInt("videoReplayCount") == 0)) {
      return 11;
    }
    return 13;
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
  
  public final int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  @Nullable
  public final Integer a()
  {
    return this.jdField_a_of_type_JavaLangInteger;
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
    if (AdReportUtil.a(paramAdReportData) != ReportAction.VIDEO_SEE_TIME) {
      return;
    }
    JSONObject localJSONObject = paramAdReportData.a();
    if (localJSONObject != null) {}
    try
    {
      this.jdField_a_of_type_Int = localJSONObject.optInt("bt");
      this.jdField_b_of_type_Int = localJSONObject.optInt("et");
      this.jdField_c_of_type_Int = localJSONObject.optInt("bf");
      this.jdField_d_of_type_Int = localJSONObject.optInt("ef");
      paramAdReportData = paramAdReportData.a().scene;
      this.e = 0;
      this.jdField_c_of_type_JavaLangInteger = Integer.valueOf(a(localJSONObject));
      this.f = b(localJSONObject);
      this.jdField_a_of_type_JavaLangInteger = Integer.valueOf(c(localJSONObject));
      this.g = localJSONObject.optInt("duration");
      this.jdField_b_of_type_JavaLangInteger = Integer.valueOf(this.jdField_b_of_type_Int - this.jdField_a_of_type_Int);
      this.jdField_d_of_type_JavaLangInteger = Integer.valueOf(localJSONObject.optInt("videoReplayCount"));
      return;
    }
    catch (Throwable paramAdReportData) {}
  }
  
  public boolean a()
  {
    int i = this.jdField_a_of_type_Int;
    return true;
  }
  
  public final int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  @Nullable
  public final Integer b()
  {
    return this.jdField_c_of_type_JavaLangInteger;
  }
  
  public final int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public final int d()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public final int e()
  {
    return this.e;
  }
  
  public final int f()
  {
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.bean.VideoReportObj
 * JD-Core Version:    0.7.0.1
 */