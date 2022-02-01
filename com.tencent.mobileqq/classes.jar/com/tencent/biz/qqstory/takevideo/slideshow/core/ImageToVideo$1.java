package com.tencent.biz.qqstory.takevideo.slideshow.core;

import android.graphics.Bitmap;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWVideoRecorder;
import com.tencent.qphone.base.util.QLog;

class ImageToVideo$1
  implements HWEncodeListener
{
  ImageToVideo$1(ImageToVideo paramImageToVideo, SlideShowProcessor.ConvertContext paramConvertContext) {}
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder != null) && (ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo) > 0) && (ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo) < this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_a_of_type_Long))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder.a(3553, ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo), null, null, ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo));
      ImageToVideo localImageToVideo = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo;
      ImageToVideo.a(localImageToVideo, ImageToVideo.a(localImageToVideo) + 42000000L);
      return true;
    }
    return false;
  }
  
  public void onEncodeError(int paramInt, Throwable arg2)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ???.append("onEncodeError, code:");
      ???.append(paramInt);
      ???.append(" taskID:");
      ???.append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_b_of_type_Long);
      ???.append(" run:");
      ???.append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.d);
      QLog.e("ImageToVideo", 2, ???.toString());
    }
    synchronized (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.notifyAll();
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.d)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.d = false;
        ??? = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo;
        ???.jdField_a_of_type_Int = 7;
        ???.a(???.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_JavaLangString, null, null, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext);
      }
      return;
    }
  }
  
  public void onEncodeFinish(String arg1)
  {
    long l1 = System.currentTimeMillis();
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onEncodeFinish, taskid:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_b_of_type_Long);
      ((StringBuilder)localObject1).append(" run:");
      ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.d);
      ((StringBuilder)localObject1).append(" finish cost: ");
      ((StringBuilder)localObject1).append(l1 - this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_b_of_type_Long);
      ((StringBuilder)localObject1).append(" ms");
      QLog.d("ImageToVideo", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.d)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onEncodeFinish, delete old:");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_b_of_type_Long);
        ((StringBuilder)localObject1).append(" file:");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_JavaLangString);
        QLog.d("ImageToVideo", 2, ((StringBuilder)localObject1).toString());
      }
      FileUtils.g(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onEncodeFinish, rename start:");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_b_of_type_Long);
        ((StringBuilder)localObject1).append(" file:");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_JavaLangString);
        QLog.d("ImageToVideo", 2, ((StringBuilder)localObject1).toString());
      }
      if (FileUtils.a(???, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_Int = 0;
      } else {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_Int = 7;
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("onEncodeFinish, rename end:");
        ???.append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_b_of_type_Long);
        ???.append(" file:");
        ???.append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_JavaLangString);
        ???.append(" result:");
        ???.append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_Int);
        QLog.d("ImageToVideo", 2, ???.toString());
      }
      if (FileUtil.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_JavaLangString))
      {
        l1 = FileUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ???.append("onEncodeFinish, file exist, size:");
          ???.append(l1);
          ???.append(" file:");
          ???.append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_JavaLangString);
          QLog.d("ImageToVideo", 2, ???.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("onEncodeFinish, file not exist:");
        ???.append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_b_of_type_Long);
        ???.append(" file:");
        ???.append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_JavaLangString);
        QLog.d("ImageToVideo", 2, ???.toString());
      }
      ??? = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder.a();
      l1 = System.currentTimeMillis();
      long l2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_Long;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(l1 - l2);
      ((StringBuilder)localObject1).append("");
      StoryReportor.a("actImage2VideoTime", new String[] { ((StringBuilder)localObject1).toString() });
      StoryReportor.a("actImage2VideoResult", new String[] { "0" });
      localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo;
      ((ImageToVideo)localObject1).a(((ImageToVideo)localObject1).jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_JavaLangString, ???, null, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext);
    }
    else
    {
      StoryReportor.a("actImage2VideoResult", new String[] { "3" });
      FileUtils.g(???);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder.c();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder = null;
    }
    synchronized (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.notifyAll();
      return;
    }
  }
  
  public void onEncodeFrame()
  {
    StringBuilder localStringBuilder;
    if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.d)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onEncodeFrame, mRun is false, tasid.");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_b_of_type_Long);
        QLog.d("ImageToVideo", 2, localStringBuilder.toString());
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder.b();
      }
      return;
    }
    if (!a())
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder.b();
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onEncodeFrame, stop recoder, taskid:");
        localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_b_of_type_Long);
        QLog.d("ImageToVideo", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void onEncodeStart()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.d)
    {
      long l1 = System.currentTimeMillis();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onEncodeStart, taskid:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_b_of_type_Long);
        QLog.d("ImageToVideo", 2, ((StringBuilder)localObject).toString());
      }
      if (!ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo))
      {
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo;
        ImageToVideo.a((ImageToVideo)localObject, ImageToVideo.a((ImageToVideo)localObject, ImageToVideo.a((ImageToVideo)localObject), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_b_of_type_Int));
      }
      else
      {
        localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo;
        ImageToVideo.a((ImageToVideo)localObject, ImageToVideo.b((ImageToVideo)localObject, ImageToVideo.a((ImageToVideo)localObject), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_b_of_type_Int));
      }
      if (ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo) != null)
      {
        ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo).recycle();
        ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo, null);
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onEncodeStart, taskid:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_b_of_type_Long);
        ((StringBuilder)localObject).append(" run:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.d);
        ((StringBuilder)localObject).append(" preProcess cost: ");
        ((StringBuilder)localObject).append(l2 - l1);
        ((StringBuilder)localObject).append(" ms mGpuBlur:");
        ((StringBuilder)localObject).append(ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo));
        QLog.d("ImageToVideo", 2, ((StringBuilder)localObject).toString());
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_b_of_type_Long = System.currentTimeMillis();
      a();
      return;
    }
    if (ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo) != null)
    {
      ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo).recycle();
      ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo, null);
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder != null) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqVideocodecMediacodecRecorderHWVideoRecorder.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.ImageToVideo.1
 * JD-Core Version:    0.7.0.1
 */