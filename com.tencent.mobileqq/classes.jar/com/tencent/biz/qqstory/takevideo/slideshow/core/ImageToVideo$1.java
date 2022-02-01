package com.tencent.biz.qqstory.takevideo.slideshow.core;

import android.graphics.Bitmap;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWEncodeListener;
import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWVideoRecorder;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.qphone.base.util.QLog;

class ImageToVideo$1
  implements HWEncodeListener
{
  ImageToVideo$1(ImageToVideo paramImageToVideo, SlideShowProcessor.ConvertContext paramConvertContext) {}
  
  private boolean a()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder != null) && (ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo) > 0) && (ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo) < this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_a_of_type_Long))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a(3553, ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo), null, null, ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo));
      ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo, ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo) + 42000000L);
      return true;
    }
    return false;
  }
  
  public void onEncodeError(int paramInt, Throwable arg2)
  {
    if (QLog.isColorLevel()) {
      QLog.e("ImageToVideo", 2, "onEncodeError, code:" + paramInt + " taskID:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.d);
    }
    synchronized (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.notifyAll();
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.d)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.d = false;
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_Int = 7;
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_JavaLangString, null, null, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext);
      }
      return;
    }
  }
  
  public void onEncodeFinish(String arg1)
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("ImageToVideo", 2, "onEncodeFinish, taskid:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.d + " finish cost: " + (l1 - this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_b_of_type_Long) + " ms");
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, delete old:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_JavaLangString);
      }
      FileUtils.g(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, rename start:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_JavaLangString);
      }
      if (FileUtils.a(???, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_JavaLangString)) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_Int = 0;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFinish, rename end:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_JavaLangString + " result:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_Int);
      }
      if (FileUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_JavaLangString))
      {
        l1 = FileUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_JavaLangString);
        if (QLog.isColorLevel()) {
          QLog.d("ImageToVideo", 2, "onEncodeFinish, file exist, size:" + l1 + " file:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_JavaLangString);
        }
        label362:
        ??? = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.a();
        l1 = System.currentTimeMillis();
        long l2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_Long;
        StoryReportor.a("actImage2VideoTime", new String[] { l1 - l2 + "" });
        StoryReportor.a("actImage2VideoResult", new String[] { "0" });
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_JavaLangString, ???, null, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext);
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager != null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager.surfaceDestroyed();
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqShortvideoFilterQQFilterRenderManager = null;
        }
        if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder != null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.d();
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder = null;
        }
      }
      synchronized (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.notifyAll();
        return;
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_Int = 7;
        continue;
        if (!QLog.isColorLevel()) {
          break label362;
        }
        QLog.d("ImageToVideo", 2, "onEncodeFinish, file not exist:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_b_of_type_Long + " file:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_JavaLangString);
        break label362;
        StoryReportor.a("actImage2VideoResult", new String[] { "3" });
        FileUtils.g(???);
      }
    }
  }
  
  public void onEncodeFrame()
  {
    if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.d)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeFrame, mRun is false, tasid." + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_b_of_type_Long);
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.c();
      }
    }
    do
    {
      do
      {
        return;
      } while (a());
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.c();
      }
    } while (!QLog.isColorLevel());
    QLog.d("ImageToVideo", 2, "onEncodeFrame, stop recoder, taskid:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_b_of_type_Long);
  }
  
  public void onEncodeStart()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.d)
    {
      long l1 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ImageToVideo", 2, "onEncodeStart, taskid:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_b_of_type_Long);
      }
      if (!ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo))
      {
        ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo, ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo, ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_b_of_type_Int));
        if (ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo) != null)
        {
          ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo).recycle();
          ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo, null);
        }
        long l2 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("ImageToVideo", 2, "onEncodeStart, taskid:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_b_of_type_Long + " run:" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.d + " preProcess cost: " + (l2 - l1) + " ms mGpuBlur:" + ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo));
        }
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_b_of_type_Long = System.currentTimeMillis();
        a();
      }
    }
    do
    {
      return;
      ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo, ImageToVideo.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo, ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo), this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreSlideShowProcessor$ConvertContext.jdField_b_of_type_Int));
      break;
      if (ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo) != null)
      {
        ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo).recycle();
        ImageToVideo.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo, null);
      }
    } while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder == null);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowCoreImageToVideo.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecRecorderHWVideoRecorder.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.ImageToVideo.1
 * JD-Core Version:    0.7.0.1
 */