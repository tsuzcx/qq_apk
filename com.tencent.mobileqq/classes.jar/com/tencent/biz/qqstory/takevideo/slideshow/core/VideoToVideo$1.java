package com.tencent.biz.qqstory.takevideo.slideshow.core;

import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.mobileqq.videocodec.mediacodec.recorder.HWEncodeListener;
import com.tencent.qphone.base.util.QLog;

class VideoToVideo$1
  implements HWEncodeListener
{
  VideoToVideo$1(VideoToVideo paramVideoToVideo, SlideShowProcessor.ConvertContext paramConvertContext) {}
  
  public void onEncodeError(int paramInt, Throwable arg2)
  {
    synchronized (VideoToVideo.a(this.b))
    {
      this.a.f = true;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onEncodeError, errorCode= ");
        localStringBuilder.append(paramInt);
        QLog.d("VideoToVideo", 2, localStringBuilder.toString());
      }
      VideoToVideo.a(this.b).notifyAll();
      return;
    }
  }
  
  public void onEncodeFinish(String paramString)
  {
    synchronized (VideoToVideo.a(this.b))
    {
      this.a.h = true;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onEncodeFinish, filePath= ");
        localStringBuilder.append(paramString);
        QLog.d("VideoToVideo", 2, localStringBuilder.toString());
      }
      VideoToVideo.a(this.b).notifyAll();
      return;
    }
  }
  
  public void onEncodeFrame()
  {
    Object localObject = this.a;
    if ((localObject != null) && (!((SlideShowProcessor.ConvertContext)localObject).j) && (!this.a.g))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("cancel mergeVideoTask path : ");
        ((StringBuilder)localObject).append(this.a.e.f);
        ((StringBuilder)localObject).append(" currContext id : ");
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append("  mCanceled : ");
        ((StringBuilder)localObject).append(this.a.g);
        QLog.d("VideoToVideo", 2, ((StringBuilder)localObject).toString());
      }
      this.b.b(this.a);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("after cancel : ");
        ((StringBuilder)localObject).append(this.a.g);
        QLog.d("VideoToVideo", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
  
  public void onEncodeStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.VideoToVideo.1
 * JD-Core Version:    0.7.0.1
 */