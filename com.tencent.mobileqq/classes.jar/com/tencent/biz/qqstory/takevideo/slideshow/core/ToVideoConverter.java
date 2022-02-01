package com.tencent.biz.qqstory.takevideo.slideshow.core;

import android.media.MediaFormat;
import com.tencent.biz.qqstory.takevideo.slideshow.ResultInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWVideoRecorder;
import com.tencent.qphone.base.util.QLog;

public abstract class ToVideoConverter
{
  protected int d;
  protected HWVideoRecorder e;
  protected String f;
  protected String g;
  
  protected void a(int paramInt, String paramString1, String paramString2, MediaFormat paramMediaFormat, SlideItemInfo paramSlideItemInfo, SlideShowProcessor.TaskContext paramTaskContext)
  {
    if (paramTaskContext != null)
    {
      ResultInfo localResultInfo = new ResultInfo();
      localResultInfo.a = paramTaskContext.k;
      localResultInfo.b = paramInt;
      localResultInfo.d = paramString2;
      localResultInfo.c = paramString1;
      localResultInfo.e = paramMediaFormat;
      localResultInfo.f = this.g;
      localResultInfo.i = false;
      localResultInfo.j = 1;
      if (paramSlideItemInfo != null)
      {
        localResultInfo.i = paramSlideItemInfo.m;
        localResultInfo.j = paramSlideItemInfo.n;
      }
      if (paramTaskContext.l != null) {
        paramTaskContext.l.a(localResultInfo);
      }
    }
  }
  
  protected boolean a(SlideShowProcessor.TaskContext paramTaskContext)
  {
    if ((!paramTaskContext.j) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("run exit:");
      localStringBuilder.append(paramTaskContext.k);
      localStringBuilder.append(" currContext.isRun:");
      localStringBuilder.append(paramTaskContext.j);
      QLog.d("ToVideoConverter", 2, localStringBuilder.toString());
    }
    return paramTaskContext.j ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.ToVideoConverter
 * JD-Core Version:    0.7.0.1
 */