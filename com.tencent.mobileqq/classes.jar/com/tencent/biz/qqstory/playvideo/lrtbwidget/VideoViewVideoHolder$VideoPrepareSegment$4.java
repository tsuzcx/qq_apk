package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.playvideo.player.IVideoView.OnCompletionListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;

class VideoViewVideoHolder$VideoPrepareSegment$4
  implements IVideoView.OnCompletionListener
{
  VideoViewVideoHolder$VideoPrepareSegment$4(VideoViewVideoHolder.VideoPrepareSegment paramVideoPrepareSegment, StoryVideoItem paramStoryVideoItem) {}
  
  public void a(IVideoView paramIVideoView)
  {
    if (this.b.isCanceled()) {
      return;
    }
    SLog.a(this.b.b.a, "onCompletion, [videoView], current state = %s", VideoViewVideoHolder.j[this.b.b.m]);
    if (VideoViewVideoHolder.h(this.b.b, 12))
    {
      VideoViewVideoHolder.d(this.b.b, 12);
      this.b.b.u = 1;
      VideoViewVideoHolder.i(this.b.b).a(this.b.b, paramIVideoView, VideoViewVideoHolder.j(this.b.b));
      StoryReportor.c("video_ope", "play_finish", 0, 0, new String[] { this.a.mOwnerUid, "", "", this.a.mVid });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment.4
 * JD-Core Version:    0.7.0.1
 */