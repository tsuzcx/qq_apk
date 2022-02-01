package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.view.View;
import anvx;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.mobileqq.utils.NetworkUtil;
import xil;
import ykq;

public class VideoViewVideoHolder$VideoInfoSegment$2
  implements Runnable
{
  public VideoViewVideoHolder$VideoInfoSegment$2(xil paramxil) {}
  
  public void run()
  {
    if (this.a.isCanceled()) {
      return;
    }
    ykq.e(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "response FAILED get video info of %s", new Object[] { this.a.jdField_a_of_type_JavaLangString });
    VideoViewVideoHolder.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, anvx.a(2131715805));
    ykq.d(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_JavaLangString, "get video info failed, hide loading view");
    VideoViewVideoHolder.c(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 6);
    VideoViewVideoHolder.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, false);
    if (!NetworkUtil.isNetworkAvailable(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder.jdField_a_of_type_AndroidViewView.getContext())) {
      VideoViewVideoHolder.b(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder, 880001);
    }
    xil.b(this.a, new ErrorMessage(VideoViewVideoHolder.b(this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder), "get video info failed"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoInfoSegment.2
 * JD-Core Version:    0.7.0.1
 */