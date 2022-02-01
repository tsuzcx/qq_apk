package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoR5.Builder;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/VideoFeedsReporter$Companion;", "", "()V", "TAG", "", "doAtClickReport", "", "videoInfo", "Lcom/tencent/biz/pubaccount/VideoInfo;", "doAtExposureReport", "doTopicClickReport", "topicId", "doTopicExposureReport", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoFeedsReporter$Companion
{
  public final void a(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    paramVideoInfo = new VideoR5.Builder("", paramVideoInfo.j, paramVideoInfo.a, paramVideoInfo.g).i(paramVideoInfo.g).a().a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B4DA", "0X800B4DA", 0, 0, "", "", "", paramVideoInfo, false);
  }
  
  public final void a(@NotNull VideoInfo paramVideoInfo, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramString, "topicId");
    paramVideoInfo = new VideoR5.Builder("", paramVideoInfo.j, paramVideoInfo.a, paramVideoInfo.g).i(paramVideoInfo.g).g(paramString).ae(1).a().a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B2A4", "0X800B2A4", 0, 0, "3", "", "", paramVideoInfo, false);
  }
  
  public final void b(@NotNull VideoInfo paramVideoInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    paramVideoInfo = new VideoR5.Builder("", paramVideoInfo.j, paramVideoInfo.a, paramVideoInfo.g).i(paramVideoInfo.g).a().a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B4DC", "0X800B4DC", 0, 0, "", "", "", paramVideoInfo, false);
  }
  
  public final void b(@NotNull VideoInfo paramVideoInfo, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramVideoInfo, "videoInfo");
    Intrinsics.checkParameterIsNotNull(paramString, "topicId");
    paramVideoInfo = new VideoR5.Builder("", paramVideoInfo.j, paramVideoInfo.a, paramVideoInfo.g).i(paramVideoInfo.g).g(paramString).ae(1).a().a();
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800B2A3", "0X800B2A3", 0, 0, "3", "", "", paramVideoInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsReporter.Companion
 * JD-Core Version:    0.7.0.1
 */