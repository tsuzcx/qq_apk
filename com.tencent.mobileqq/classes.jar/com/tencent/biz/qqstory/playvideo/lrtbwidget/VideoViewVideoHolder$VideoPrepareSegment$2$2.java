package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;

class VideoViewVideoHolder$VideoPrepareSegment$2$2
  implements Runnable
{
  VideoViewVideoHolder$VideoPrepareSegment$2$2(VideoViewVideoHolder.VideoPrepareSegment.2 param2, int paramInt) {}
  
  public void run()
  {
    SLog.e(this.b.c.b.a, "onError, setOnDownloadListener [vid, url, errorCode=%d]", new Object[] { Integer.valueOf(this.a) });
    VideoViewVideoHolder.c(this.b.c.b, 10);
    VideoViewVideoHolder.a(this.b.c.b, false);
    VideoViewVideoHolder.b(this.b.c.b, this.a);
    this.b.c.b.a(8, "download error");
    VideoViewVideoHolder.VideoPrepareSegment.a(this.b.c, new ErrorMessage(this.a, "download error"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment.2.2
 * JD-Core Version:    0.7.0.1
 */