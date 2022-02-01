package com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video;

import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder;
import com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.VideoReportUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.IPlayer;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class VideoReportController$reportPlayDuration$1
  extends Lambda
  implements Function0<Unit>
{
  VideoReportController$reportPlayDuration$1(VideoReportController paramVideoReportController)
  {
    super(0);
  }
  
  public final void invoke()
  {
    Object localObject1 = this.this$0.a();
    if (localObject1 != null)
    {
      localObject1 = ((VideoPlayController)localObject1).a();
      if (localObject1 != null)
      {
        Object localObject2 = this.this$0.a();
        if (localObject2 != null)
        {
          localObject2 = ((VideoPlayController)localObject2).a();
          if (localObject2 != null)
          {
            VideoReportUtil localVideoReportUtil = VideoReportUtil.a;
            if (localObject1 == null) {
              throw new TypeCastException("null cannot be cast to non-null type com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo");
            }
            localObject1 = localVideoReportUtil.a((ArticleInfo)localObject1, ((IPlayer)localObject2).b());
            ((RIJTransMergeKanDianReport.ReportR5Builder)localObject1).b("watch_duration", String.valueOf(this.this$0.a()));
            ((RIJTransMergeKanDianReport.ReportR5Builder)localObject1).b("current_duration", String.valueOf(((IPlayer)localObject2).b()));
            localObject2 = VideoReportUtil.a;
            localObject1 = ((RIJTransMergeKanDianReport.ReportR5Builder)localObject1).a();
            Intrinsics.checkExpressionValueIsNotNull(localObject1, "reportBuilder.build()");
            ((VideoReportUtil)localObject2).a("", "0X8007408", (String)localObject1);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.base.video.VideoReportController.reportPlayDuration.1
 * JD-Core Version:    0.7.0.1
 */