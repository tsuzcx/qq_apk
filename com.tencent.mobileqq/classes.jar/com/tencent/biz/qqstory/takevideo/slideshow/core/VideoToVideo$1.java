package com.tencent.biz.qqstory.takevideo.slideshow.core;

import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWEncodeListener;
import com.tencent.qphone.base.util.QLog;

class VideoToVideo$1
  implements HWEncodeListener
{
  VideoToVideo$1(VideoToVideo paramVideoToVideo, SlideShowProcessor.ConvertContext paramConvertContext) {}
  
  public void onEncodeError(int paramInt, Throwable arg2)
  {
    synchronized (VideoToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreVideoToVideo))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_a_of_type_Boolean = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "onEncodeError, errorCode= " + paramInt);
      }
      VideoToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreVideoToVideo).notifyAll();
      return;
    }
  }
  
  public void onEncodeFinish(String paramString)
  {
    synchronized (VideoToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreVideoToVideo))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.c = true;
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "onEncodeFinish, filePath= " + paramString);
      }
      VideoToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreVideoToVideo).notifyAll();
      return;
    }
  }
  
  public void onEncodeFrame()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.d) && (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.b))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "cancel mergeVideoTask path : " + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideItemInfo.b + " currContext id : " + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext + "  mCanceled : " + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.b);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreVideoToVideo.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext);
      if (QLog.isColorLevel()) {
        QLog.d("VideoToVideo", 2, "after cancel : " + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.b);
      }
    }
  }
  
  public void onEncodeStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.VideoToVideo.1
 * JD-Core Version:    0.7.0.1
 */