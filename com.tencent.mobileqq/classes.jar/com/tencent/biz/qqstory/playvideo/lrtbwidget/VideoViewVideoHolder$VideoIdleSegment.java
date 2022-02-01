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
    this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(null);
    this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(null);
    this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(null);
    this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(null);
    this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(null);
    if (VideoViewVideoHolder.f(this.a) == 0)
    {
      SLog.d(this.a.jdField_a_of_type_JavaLangString, "VideoIdleSegment. already idle state");
      notifyResult(paramString);
      return;
    }
    if (VideoViewVideoHolder.f(this.a) < 7)
    {
      SLog.d(this.a.jdField_a_of_type_JavaLangString, "VideoIdleSegment. change to idle directly");
      VideoViewVideoHolder.a(this.a, 0);
      notifyResult(paramString);
      return;
    }
    SLog.b(this.a.jdField_a_of_type_JavaLangString, "VideoIdleSegment. stop video view");
    this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a();
    VideoViewVideoHolder.a(this.a, 0);
    notifyResult(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoIdleSegment
 * JD-Core Version:    0.7.0.1
 */