package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;

class VideoViewVideoHolder$VideoPrepareSegment$2$2
  implements Runnable
{
  VideoViewVideoHolder$VideoPrepareSegment$2$2(VideoViewVideoHolder.VideoPrepareSegment.2 param2, int paramInt) {}
  
  public void run()
  {
    SLog.e(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment$2.a.a.a, "onError, setOnDownloadListener [vid, url, errorCode=%d]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    VideoViewVideoHolder.c(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment$2.a.a, 10);
    VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment$2.a.a, false);
    VideoViewVideoHolder.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment$2.a.a, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment$2.a.a.a(8, "download error");
    VideoViewVideoHolder.VideoPrepareSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment$2.a, new ErrorMessage(this.jdField_a_of_type_Int, "download error"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment.2.2
 * JD-Core Version:    0.7.0.1
 */