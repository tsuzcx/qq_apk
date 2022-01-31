package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import ajjy;
import android.view.View;
import badq;
import com.tencent.biz.qqstory.base.ErrorMessage;
import tpf;
import urk;

public class VideoViewVideoHolder$VideoInfoSegment$2
  implements Runnable
{
  public VideoViewVideoHolder$VideoInfoSegment$2(tpf paramtpf) {}
  
  public void run()
  {
    if (this.a.isCanceled()) {
      return;
    }
    urk.e(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "response FAILED get video info of %s", new Object[] { this.a.jdField_a_of_type_JavaLangString });
    VideoViewVideoHolder.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, ajjy.a(2131650651));
    urk.d(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "get video info failed, hide loading view");
    VideoViewVideoHolder.c(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 6);
    VideoViewVideoHolder.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, false);
    if (!badq.g(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_AndroidViewView.getContext())) {
      VideoViewVideoHolder.b(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 880001);
    }
    tpf.b(this.a, new ErrorMessage(VideoViewVideoHolder.b(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder), "get video info failed"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoInfoSegment.2
 * JD-Core Version:    0.7.0.1
 */