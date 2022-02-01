package com.tencent.biz.qqstory.takevideo.slideshow;

import com.tencent.mobileqq.richmedia.mediacodec.recorder.HWEncodeListener;
import com.tencent.qphone.base.util.QLog;

class Video2Video$1
  implements HWEncodeListener
{
  Video2Video$1(Video2Video paramVideo2Video) {}
  
  public void onEncodeError(int paramInt, Throwable arg2)
  {
    synchronized (Video2Video.a(this.a))
    {
      Video2Video.b(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d(Video2Video.a, 2, "onEncodeError, errorCode= " + paramInt);
      }
      Video2Video.a(this.a).notifyAll();
      return;
    }
  }
  
  public void onEncodeFinish(String paramString)
  {
    synchronized (Video2Video.a(this.a))
    {
      Video2Video.a(this.a, true);
      if (QLog.isColorLevel()) {
        QLog.d(Video2Video.a, 2, "onEncodeFinish, filePath= " + paramString);
      }
      Video2Video.a(this.a).notifyAll();
      return;
    }
  }
  
  public void onEncodeFrame() {}
  
  public void onEncodeStart() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.Video2Video.1
 * JD-Core Version:    0.7.0.1
 */