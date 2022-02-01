package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import com.tencent.biz.qqstory.base.ErrorMessage;
import xsg;
import xsi;
import yuk;

public class VideoViewVideoHolder$VideoPrepareSegment$2$2
  implements Runnable
{
  public VideoViewVideoHolder$VideoPrepareSegment$2$2(xsi paramxsi, int paramInt) {}
  
  public void run()
  {
    yuk.e(this.jdField_a_of_type_Xsi.a.a.a, "onError, setOnDownloadListener [vid, url, errorCode=%d]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    VideoViewVideoHolder.c(this.jdField_a_of_type_Xsi.a.a, 10);
    VideoViewVideoHolder.a(this.jdField_a_of_type_Xsi.a.a, false);
    VideoViewVideoHolder.b(this.jdField_a_of_type_Xsi.a.a, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Xsi.a.a.a(8, "download error");
    xsg.a(this.jdField_a_of_type_Xsi.a, new ErrorMessage(this.jdField_a_of_type_Int, "download error"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment.2.2
 * JD-Core Version:    0.7.0.1
 */