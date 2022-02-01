package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.view.View;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.NetworkUtil;

class VideoViewVideoHolder$VideoInfoSegment$2
  implements Runnable
{
  VideoViewVideoHolder$VideoInfoSegment$2(VideoViewVideoHolder.VideoInfoSegment paramVideoInfoSegment) {}
  
  public void run()
  {
    if (this.a.isCanceled()) {
      return;
    }
    SLog.e(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "response FAILED get video info of %s", new Object[] { this.a.jdField_a_of_type_JavaLangString });
    VideoViewVideoHolder.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, HardCodeUtil.a(2131716176));
    SLog.d(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "get video info failed, hide loading view");
    VideoViewVideoHolder.c(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 6);
    VideoViewVideoHolder.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, false);
    if (!NetworkUtil.isNetworkAvailable(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_AndroidViewView.getContext())) {
      VideoViewVideoHolder.b(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 880001);
    }
    VideoViewVideoHolder.VideoInfoSegment localVideoInfoSegment = this.a;
    VideoViewVideoHolder.VideoInfoSegment.b(localVideoInfoSegment, new ErrorMessage(VideoViewVideoHolder.b(localVideoInfoSegment.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder), "get video info failed"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoInfoSegment.2
 * JD-Core Version:    0.7.0.1
 */