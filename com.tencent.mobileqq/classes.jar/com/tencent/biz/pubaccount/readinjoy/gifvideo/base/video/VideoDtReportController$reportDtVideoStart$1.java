package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.view.View;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IPlayer;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IVideoView;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoDTReport;
import com.tencent.biz.pubaccount.readinjoy.video.report.VideoDTReport.Builder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "player", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IPlayer;", "videoView", "Lcom/tencent/biz/pubaccount/readinjoy/video/player/wrapper/IVideoView;", "originView", "Landroid/view/View;", "article", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "invoke"}, k=3, mv={1, 1, 16})
final class VideoDtReportController$reportDtVideoStart$1
  extends Lambda
  implements Function4<IPlayer, IVideoView, View, BaseArticleInfo, Unit>
{
  VideoDtReportController$reportDtVideoStart$1(VideoDtReportController paramVideoDtReportController)
  {
    super(4);
  }
  
  public final void invoke(@NotNull IPlayer paramIPlayer, @NotNull IVideoView paramIVideoView, @NotNull View paramView, @NotNull BaseArticleInfo paramBaseArticleInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramIPlayer, "player");
    Intrinsics.checkParameterIsNotNull(paramIVideoView, "videoView");
    Intrinsics.checkParameterIsNotNull(paramView, "originView");
    Intrinsics.checkParameterIsNotNull(paramBaseArticleInfo, "article");
    this.this$0.c(VideoReporter.b());
    paramIVideoView = VideoDTReport.Builder.a((VideoInfo)null).a(this.this$0.a()).a(paramBaseArticleInfo.mChannelID).b(paramBaseArticleInfo.innerUniqueID).c(paramBaseArticleInfo.getSubscribeUin()).b(paramIPlayer.a()).d(this.this$0.b()).c(1).e(paramView.getWidth()).f(paramView.getHeight());
    Intrinsics.checkExpressionValueIsNotNull(paramIVideoView, "VideoDTReport.Builder.ma…Height(originView.height)");
    VideoDTReport.a(paramView.getContext(), paramIPlayer, paramIVideoView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoDtReportController.reportDtVideoStart.1
 * JD-Core Version:    0.7.0.1
 */