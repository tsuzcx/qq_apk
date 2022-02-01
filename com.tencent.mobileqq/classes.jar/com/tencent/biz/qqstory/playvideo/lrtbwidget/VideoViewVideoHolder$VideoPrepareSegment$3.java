package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.os.SystemClock;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.playvideo.player.IVideoView.OnPreparedListener;
import com.tencent.biz.qqstory.support.logging.SLog;

class VideoViewVideoHolder$VideoPrepareSegment$3
  implements IVideoView.OnPreparedListener
{
  VideoViewVideoHolder$VideoPrepareSegment$3(VideoViewVideoHolder.VideoPrepareSegment paramVideoPrepareSegment, StoryVideoItem paramStoryVideoItem) {}
  
  public void a(IVideoView paramIVideoView)
  {
    if (this.b.isCanceled()) {
      return;
    }
    SLog.a(this.b.b.a, "onPrepared, [videoView=%d]", Integer.valueOf(System.identityHashCode(paramIVideoView)));
    VideoViewVideoHolder.a(this.b.b, "VP", SystemClock.uptimeMillis());
    this.b.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment.3
 * JD-Core Version:    0.7.0.1
 */