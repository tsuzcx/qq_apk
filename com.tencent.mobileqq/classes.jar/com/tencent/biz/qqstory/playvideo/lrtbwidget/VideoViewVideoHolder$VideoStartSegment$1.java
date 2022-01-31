package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import vwa;
import wxe;

class VideoViewVideoHolder$VideoStartSegment$1
  implements Runnable
{
  VideoViewVideoHolder$VideoStartSegment$1(VideoViewVideoHolder.VideoStartSegment paramVideoStartSegment) {}
  
  public void run()
  {
    if (this.a.isCanceled()) {
      return;
    }
    wxe.d(this.a.this$0.jdField_a_of_type_JavaLangString, "VideoStartSegment, mVideoView.start()");
    this.a.this$0.jdField_a_of_type_Vwa.b();
    ThreadManager.getUIHandler().post(new VideoViewVideoHolder.VideoStartSegment.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoStartSegment.1
 * JD-Core Version:    0.7.0.1
 */