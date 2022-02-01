package com.tencent.biz.qqcircle.widgets;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import cooperation.qqcircle.report.QCircleReportHelper;
import feedcloud.FeedCloudMeta.StVideoUrl;
import java.util.Collections;

class QCircleBaseVideoView$2
  implements Runnable
{
  QCircleBaseVideoView$2(QCircleBaseVideoView paramQCircleBaseVideoView, FeedCloudMeta.StVideoUrl paramStVideoUrl) {}
  
  public void run()
  {
    if (this.this$0.getSuperPlayer() != null)
    {
      QLog.i("BaseVideoView", 1, String.format("triggerDowngradeVideoUrl:url: %s, startoffset:%d, levelType:%d", new Object[] { this.a.playUrl.get(), Integer.valueOf((int)this.this$0.getSuperPlayer().getCurrentPositionMs()), Integer.valueOf(this.a.levelType.get()) }));
      this.this$0.setVideoPath(null, this.a.playUrl.get(), (int)this.this$0.getSuperPlayer().getCurrentPositionMs());
      QCircleBaseVideoView localQCircleBaseVideoView = this.this$0;
      QCircleBaseVideoView.c(localQCircleBaseVideoView, localQCircleBaseVideoView.getVideoPlayId(), "video_play_downgrade_url", this.this$0.getData(), Collections.singletonList(QCircleReportHelper.newEntry("video_url", this.a.playUrl.get())));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.QCircleBaseVideoView.2
 * JD-Core Version:    0.7.0.1
 */