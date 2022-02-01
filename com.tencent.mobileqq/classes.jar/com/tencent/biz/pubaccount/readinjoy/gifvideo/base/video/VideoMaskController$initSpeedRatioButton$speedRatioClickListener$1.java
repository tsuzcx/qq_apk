package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.VideoReportUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IPlayer;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class VideoMaskController$initSpeedRatioButton$speedRatioClickListener$1
  implements View.OnClickListener
{
  VideoMaskController$initSpeedRatioButton$speedRatioClickListener$1(VideoMaskController paramVideoMaskController) {}
  
  public final void onClick(View paramView)
  {
    VideoMaskController.c(this.a);
    VideoReportUtil localVideoReportUtil = VideoReportUtil.a;
    ArticleInfo localArticleInfo = VideoMaskController.a(this.a);
    IPlayer localIPlayer = this.a.a();
    if (localIPlayer != null) {}
    for (long l = localIPlayer.b();; l = 0L)
    {
      localVideoReportUtil.a(localArticleInfo, l, VideoMaskController.a(this.a));
      VideoMaskController.b(this.a);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoMaskController.initSpeedRatioButton.speedRatioClickListener.1
 * JD-Core Version:    0.7.0.1
 */