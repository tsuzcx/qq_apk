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
  private int a;
  private int b;
  private int c = 1;
  private int d = 1;
  private int e;
  private int f = 1;
  private int g;
  @Nullable
  private Integer h;
  @Nullable
  private Integer i;
  @Nullable
  private Integer j;
  @Nullable
  private Integer k;
  
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
  
  @NotNull
  public String a()
  {
    return "video";
  }
  
  public void a(@NotNull AdReportData paramAdReportData)
  {
    Intrinsics.checkParameterIsNotNull(paramAdReportData, "adReportData");
    if (AdReportUtil.a(paramAdReportData) != ReportAction.VIDEO_SEE_TIME) {
      return;
    }
    JSONObject localJSONObject = paramAdReportData.l();
    if (localJSONObject != null) {}
    try
    {
      this.a = localJSONObject.optInt("bt");
      this.b = localJSONObject.optInt("et");
      this.c = localJSONObject.optInt("bf");
      this.d = localJSONObject.optInt("ef");
      paramAdReportData = paramAdReportData.g().scene;
      this.e = 0;
      this.j = Integer.valueOf(a(localJSONObject));
      this.f = b(localJSONObject);
      this.h = Integer.valueOf(c(localJSONObject));
      this.g = localJSONObject.optInt("duration");
      this.i = Integer.valueOf(this.b - this.a);
      this.k = Integer.valueOf(localJSONObject.optInt("videoReplayCount"));
      return;
    }
    catch (Throwable paramAdReportData) {}
  }
  
  @Nullable
  public JSONObject b()
  {
    JSONObject localJSONObject = new JSONObject();
    ReportExKt.a(localJSONObject, "videoBeginTime", Integer.valueOf(this.a));
    ReportExKt.a(localJSONObject, "videoEndTime", Integer.valueOf(this.b));
    ReportExKt.a(localJSONObject, "videoBeginFrame", Integer.valueOf(this.c));
    ReportExKt.a(localJSONObject, "videoEndFrame", Integer.valueOf(this.d));
    ReportExKt.a(localJSONObject, "videoPlayPosition", Integer.valueOf(this.e));
    ReportExKt.a(localJSONObject, "videoEndType", Integer.valueOf(this.f));
    ReportExKt.a(localJSONObject, "videoDuration", Integer.valueOf(this.g));
    ReportExKt.a(localJSONObject, "videoPlayError", this.h);
    ReportExKt.a(localJSONObject, "videoPlayDuration", this.i);
    ReportExKt.a(localJSONObject, "videoPlayType", this.j);
    ReportExKt.a(localJSONObject, "videoReplayCount", this.k);
    return localJSONObject;
  }
  
  public boolean c()
  {
    int m = this.a;
    return true;
  }
  
  public final int d()
  {
    return this.a;
  }
  
  public final int e()
  {
    return this.b;
  }
  
  public final int f()
  {
    return this.c;
  }
  
  public final int g()
  {
    return this.d;
  }
  
  public final int h()
  {
    return this.e;
  }
  
  public final int i()
  {
    return this.f;
  }
  
  @Nullable
  public final Integer j()
  {
    return this.h;
  }
  
  @Nullable
  public final Integer k()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.report.bean.VideoReportObj
 * JD-Core Version:    0.7.0.1
 */