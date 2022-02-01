package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;

class VideoViewVideoHolder$VideoIdleSegment
  extends JobSegment<String, String>
{
  private VideoViewVideoHolder$VideoIdleSegment(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  protected void a(JobContext paramJobContext, String paramString)
  {
    this.a.p.a(null);
    this.a.p.a(null);
    this.a.p.a(null);
    this.a.p.a(null);
    this.a.p.a(null);
    if (VideoViewVideoHolder.n(this.a) == 0)
    {
      SLog.d(this.a.a, "VideoIdleSegment. already idle state");
      notifyResult(paramString);
      return;
    }
    if (VideoViewVideoHolder.n(this.a) < 7)
    {
      SLog.d(this.a.a, "VideoIdleSegment. change to idle directly");
      VideoViewVideoHolder.d(this.a, 0);
      notifyResult(paramString);
      return;
    }
    SLog.b(this.a.a, "VideoIdleSegment. stop video view");
    this.a.p.c();
    VideoViewVideoHolder.d(this.a, 0);
    notifyResult(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoIdleSegment
 * JD-Core Version:    0.7.0.1
 */