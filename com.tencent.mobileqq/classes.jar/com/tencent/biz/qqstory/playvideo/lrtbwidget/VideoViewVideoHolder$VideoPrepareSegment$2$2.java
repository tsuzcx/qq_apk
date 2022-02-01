package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import com.tencent.biz.qqstory.base.ErrorMessage;
import wtr;
import wtt;
import xvv;

public class VideoViewVideoHolder$VideoPrepareSegment$2$2
  implements Runnable
{
  public VideoViewVideoHolder$VideoPrepareSegment$2$2(wtt paramwtt, int paramInt) {}
  
  public void run()
  {
    xvv.e(this.jdField_a_of_type_Wtt.a.a.a, "onError, setOnDownloadListener [vid, url, errorCode=%d]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    VideoViewVideoHolder.c(this.jdField_a_of_type_Wtt.a.a, 10);
    VideoViewVideoHolder.a(this.jdField_a_of_type_Wtt.a.a, false);
    VideoViewVideoHolder.b(this.jdField_a_of_type_Wtt.a.a, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Wtt.a.a.a(8, "download error");
    wtr.a(this.jdField_a_of_type_Wtt.a, new ErrorMessage(this.jdField_a_of_type_Int, "download error"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment.2.2
 * JD-Core Version:    0.7.0.1
 */