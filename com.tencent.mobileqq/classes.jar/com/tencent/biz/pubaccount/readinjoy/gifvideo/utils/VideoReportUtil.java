package com.tencent.biz.pubaccount.readinjoy.gifvideo.utils;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.MiniAppData;
import com.tencent.biz.pubaccount.util.KotlinUtilKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/gifvideo/utils/VideoReportUtil;", "", "()V", "ACTION_NAME_MANUAL_STOP_PLAY", "", "ACTION_NAME_MUTE_BTN_CLICK", "ACTION_NAME_SPEED_RATIO_BTN_CLICK", "ACTION_NAME_WATCH_LATER", "TAG", "getBaseR5Builder", "Lcom/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/framewrok/report/RIJTransMergeKanDianReport$ReportR5Builder;", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "currentDuration", "", "miniAppData", "Lcom/tencent/biz/pubaccount/readinjoy/view/fastweb/data/MiniAppData;", "getReportIconLocation", "", "getVideoFromType", "reportData", "", "toUin", "actionName", "r5", "reportManuallyPlayOrStopVideo", "stop", "", "reportMuteBtnClick", "isMute", "reportRatioBtnClick", "speedRatio", "", "reportWatchLaterBtnClick", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoReportUtil
{
  public static final VideoReportUtil a = new VideoReportUtil();
  
  private final int b(ArticleInfo paramArticleInfo)
  {
    if (RIJItemViewType.o((BaseArticleInfo)paramArticleInfo)) {
      return 2;
    }
    if (RIJItemViewType.p((BaseArticleInfo)paramArticleInfo)) {
      return 5;
    }
    return -1;
  }
  
  public final int a(@NotNull ArticleInfo paramArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramArticleInfo, "articleInfo");
    int i = (int)paramArticleInfo.mChannelID;
    if (i == 0) {
      return 3;
    }
    if (i == DailyModeConfigHandler.b()) {
      return 24;
    }
    return -1;
  }
  
  @NotNull
  public final RIJTransMergeKanDianReport.ReportR5Builder a(@NotNull ArticleInfo paramArticleInfo, long paramLong)
  {
    int j = 1;
    Intrinsics.checkParameterIsNotNull(paramArticleInfo, "articleInfo");
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = RIJTransMergeKanDianReport.a();
    localReportR5Builder.b("puin", paramArticleInfo.getSubscribeUin());
    localReportR5Builder.b("vid", paramArticleInfo.getVideoVid());
    localReportR5Builder.a("article_id", paramArticleInfo.mArticleID);
    if (NetworkUtil.h(null))
    {
      i = 2;
      localReportR5Builder.b("net_type", i);
      localReportR5Builder.b("video_duration", paramArticleInfo.getVideoDuration() * 1000);
      localReportR5Builder.b("duration", paramArticleInfo.getVideoDuration() * 1000);
      localReportR5Builder.a("current_duration", paramLong);
      localReportR5Builder.b("video_type", "6");
      localReportR5Builder.b("kandian_mode_new", VideoReporter.a());
      localReportR5Builder.a("channel_id", paramArticleInfo.mChannelID);
      if (!VideoPlayManager.a(paramArticleInfo.getSubscribeUin())) {
        break label270;
      }
    }
    label270:
    for (int i = j;; i = 0)
    {
      localReportR5Builder.b("fans", i);
      localReportR5Builder.a("algorithm_id", paramArticleInfo.mAlgorithmID);
      localReportR5Builder.b("strategy_id", paramArticleInfo.mStrategyId);
      localReportR5Builder.b("video_report_info", paramArticleInfo.videoReportInfo);
      localReportR5Builder.b("is_ads", "0");
      localReportR5Builder.b("aid", paramArticleInfo.innerUniqueID);
      localReportR5Builder.a("channel_id", paramArticleInfo.mChannelID);
      localReportR5Builder.b("video_from_type", String.valueOf(a(paramArticleInfo)));
      Intrinsics.checkExpressionValueIsNotNull(localReportR5Builder, "r5Builder");
      return localReportR5Builder;
      i = 1;
      break;
    }
  }
  
  @Nullable
  public final RIJTransMergeKanDianReport.ReportR5Builder a(@Nullable MiniAppData paramMiniAppData)
  {
    if (paramMiniAppData != null)
    {
      RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = RIJTransMergeKanDianReport.a();
      localReportR5Builder.b("rowkey", paramMiniAppData.c);
      localReportR5Builder.b("icon_location", 4);
      return localReportR5Builder;
    }
    return null;
  }
  
  public final void a(@Nullable ArticleInfo paramArticleInfo, long paramLong, float paramFloat)
  {
    Object localObject;
    if (paramArticleInfo != null)
    {
      localObject = a.a(paramArticleInfo, paramLong);
      if (Float.compare(paramFloat, 1.5F) != 0) {
        break label62;
      }
      ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).b("video_speed", 1);
    }
    for (;;)
    {
      paramArticleInfo = a;
      localObject = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "r5Builder.toString()");
      paramArticleInfo.a("", "0X8009F42", (String)localObject);
      return;
      label62:
      if (Float.compare(paramFloat, 2.0F) == 0) {
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).b("video_speed", 2);
      } else {
        ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).b("video_speed", 0);
      }
    }
  }
  
  public final void a(@Nullable ArticleInfo paramArticleInfo, long paramLong, @Nullable MiniAppData paramMiniAppData)
  {
    RIJTransMergeKanDianReport.ReportR5Builder localReportR5Builder = (RIJTransMergeKanDianReport.ReportR5Builder)null;
    if (paramMiniAppData != null) {
      paramMiniAppData = a(paramMiniAppData);
    }
    for (;;)
    {
      KotlinUtilKt.a(paramArticleInfo, paramMiniAppData, (Function2)VideoReportUtil.reportWatchLaterBtnClick.1.INSTANCE);
      return;
      if (paramArticleInfo != null)
      {
        localReportR5Builder = a(paramArticleInfo, paramLong);
        localReportR5Builder.b("icon_location", b(paramArticleInfo));
        paramMiniAppData = localReportR5Builder;
        if (!TextUtils.isEmpty((CharSequence)paramArticleInfo.videoReportInfo))
        {
          localReportR5Builder.b("short_v", new JSONObject(paramArticleInfo.videoReportInfo).optInt("short_v"));
          paramMiniAppData = localReportR5Builder;
        }
      }
      else
      {
        paramMiniAppData = localReportR5Builder;
      }
    }
  }
  
  public final void a(@Nullable ArticleInfo paramArticleInfo, long paramLong, boolean paramBoolean)
  {
    Object localObject;
    if (paramArticleInfo != null)
    {
      localObject = a.a(paramArticleInfo, paramLong);
      if (!paramBoolean) {
        break label59;
      }
      ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).b("mute_status", 1);
    }
    for (;;)
    {
      paramArticleInfo = a;
      localObject = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "r5Builder.toString()");
      paramArticleInfo.a("", "0X800740E", (String)localObject);
      return;
      label59:
      ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).b("mute_status", 2);
    }
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2, @NotNull String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "toUin");
    Intrinsics.checkParameterIsNotNull(paramString2, "actionName");
    Intrinsics.checkParameterIsNotNull(paramString3, "r5");
    QLog.i("VideoReportUtil", 1, "[reportData] actionName = " + paramString2 + ", r5= " + paramString3);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, paramString1, paramString2, paramString2, 0, 0, "", "", "", paramString3, false);
  }
  
  public final void b(@Nullable ArticleInfo paramArticleInfo, long paramLong, boolean paramBoolean)
  {
    Object localObject;
    if (paramArticleInfo != null)
    {
      localObject = a.a(paramArticleInfo, paramLong);
      if (!paramBoolean) {
        break label59;
      }
      ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).b("stop_status", 1);
    }
    for (;;)
    {
      paramArticleInfo = a;
      localObject = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "r5Builder.toString()");
      paramArticleInfo.a("", "0X800740D", (String)localObject);
      return;
      label59:
      ((RIJTransMergeKanDianReport.ReportR5Builder)localObject).b("stop_status", 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.VideoReportUtil
 * JD-Core Version:    0.7.0.1
 */