package com.tencent.biz.qqstory.takevideo.slideshow.core;

import android.media.MediaFormat;
import com.tencent.biz.qqstory.takevideo.slideshow.ResultInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWVideoRecorder;
import com.tencent.qphone.base.util.QLog;

public abstract class ToVideoConverter
{
  protected int a;
  protected HWVideoRecorder a;
  protected String a;
  protected String b;
  
  protected void a(int paramInt, String paramString1, String paramString2, MediaFormat paramMediaFormat, SlideItemInfo paramSlideItemInfo, SlideShowProcessor.TaskContext paramTaskContext)
  {
    if (paramTaskContext != null)
    {
      ResultInfo localResultInfo = new ResultInfo();
      localResultInfo.jdField_a_of_type_Long = paramTaskContext.b;
      localResultInfo.jdField_a_of_type_Int = paramInt;
      localResultInfo.jdField_b_of_type_JavaLangString = paramString2;
      localResultInfo.jdField_a_of_type_JavaLangString = paramString1;
      localResultInfo.jdField_a_of_type_AndroidMediaMediaFormat = paramMediaFormat;
      localResultInfo.c = this.jdField_b_of_type_JavaLangString;
      localResultInfo.jdField_a_of_type_Boolean = false;
      localResultInfo.jdField_b_of_type_Int = 1;
      if (paramSlideItemInfo != null)
      {
        localResultInfo.jdField_a_of_type_Boolean = paramSlideItemInfo.jdField_a_of_type_Boolean;
        localResultInfo.jdField_b_of_type_Int = paramSlideItemInfo.c;
      }
      if (paramTaskContext.a != null) {
        paramTaskContext.a.a(localResultInfo);
      }
    }
  }
  
  protected boolean a(SlideShowProcessor.TaskContext paramTaskContext)
  {
    if ((!paramTaskContext.d) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("run exit:");
      localStringBuilder.append(paramTaskContext.b);
      localStringBuilder.append(" currContext.isRun:");
      localStringBuilder.append(paramTaskContext.d);
      QLog.d("ToVideoConverter", 2, localStringBuilder.toString());
    }
    return paramTaskContext.d ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.ToVideoConverter
 * JD-Core Version:    0.7.0.1
 */