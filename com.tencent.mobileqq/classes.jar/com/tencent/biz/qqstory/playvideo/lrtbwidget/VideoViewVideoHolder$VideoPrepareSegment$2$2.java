package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import com.tencent.biz.qqstory.base.ErrorMessage;
import ucc;
import uce;
import veg;

public class VideoViewVideoHolder$VideoPrepareSegment$2$2
  implements Runnable
{
  public VideoViewVideoHolder$VideoPrepareSegment$2$2(uce paramuce, int paramInt) {}
  
  public void run()
  {
    veg.e(this.jdField_a_of_type_Uce.a.a.a, "onError, setOnDownloadListener [vid, url, errorCode=%d]", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    VideoViewVideoHolder.c(this.jdField_a_of_type_Uce.a.a, 10);
    VideoViewVideoHolder.a(this.jdField_a_of_type_Uce.a.a, false);
    VideoViewVideoHolder.b(this.jdField_a_of_type_Uce.a.a, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Uce.a.a.a(8, "download error");
    ucc.a(this.jdField_a_of_type_Uce.a, new ErrorMessage(this.jdField_a_of_type_Int, "download error"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment.2.2
 * JD-Core Version:    0.7.0.1
 */