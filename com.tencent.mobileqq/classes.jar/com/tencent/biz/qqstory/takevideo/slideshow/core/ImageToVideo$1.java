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
    if ((this.b.e != null) && (ImageToVideo.c(this.b) > 0) && (ImageToVideo.d(this.b) < this.a.d))
    {
      this.b.e.a(3553, ImageToVideo.c(this.b), null, null, ImageToVideo.d(this.b));
      ImageToVideo localImageToVideo = this.b;
      ImageToVideo.a(localImageToVideo, ImageToVideo.d(localImageToVideo) + 42000000L);
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
      ???.append(this.a.k);
      ???.append(" run:");
      ???.append(this.a.j);
      QLog.e("ImageToVideo", 2, ???.toString());
    }
    synchronized (this.b)
    {
      this.b.notifyAll();
      if (this.a.j)
      {
        this.a.j = false;
        ??? = this.b;
        ???.d = 7;
        ???.a(???.d, this.a.a, this.b.f, null, null, this.a);
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
      ((StringBuilder)localObject1).append(this.a.k);
      ((StringBuilder)localObject1).append(" run:");
      ((StringBuilder)localObject1).append(this.a.j);
      ((StringBuilder)localObject1).append(" finish cost: ");
      ((StringBuilder)localObject1).append(l1 - this.b.c);
      ((StringBuilder)localObject1).append(" ms");
      QLog.d("ImageToVideo", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.a.j)
    {
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onEncodeFinish, delete old:");
        ((StringBuilder)localObject1).append(this.a.k);
        ((StringBuilder)localObject1).append(" file:");
        ((StringBuilder)localObject1).append(this.b.f);
        QLog.d("ImageToVideo", 2, ((StringBuilder)localObject1).toString());
      }
      FileUtils.k(this.b.f);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("onEncodeFinish, rename start:");
        ((StringBuilder)localObject1).append(this.a.k);
        ((StringBuilder)localObject1).append(" file:");
        ((StringBuilder)localObject1).append(this.b.f);
        QLog.d("ImageToVideo", 2, ((StringBuilder)localObject1).toString());
      }
      if (FileUtils.a(???, this.b.f)) {
        this.b.d = 0;
      } else {
        this.b.d = 7;
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("onEncodeFinish, rename end:");
        ???.append(this.a.k);
        ???.append(" file:");
        ???.append(this.b.f);
        ???.append(" result:");
        ???.append(this.b.d);
        QLog.d("ImageToVideo", 2, ???.toString());
      }
      if (FileUtil.d(this.b.f))
      {
        l1 = FileUtil.f(this.b.f);
        if (QLog.isColorLevel())
        {
          ??? = new StringBuilder();
          ???.append("onEncodeFinish, file exist, size:");
          ???.append(l1);
          ???.append(" file:");
          ???.append(this.b.f);
          QLog.d("ImageToVideo", 2, ???.toString());
        }
      }
      else if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ???.append("onEncodeFinish, file not exist:");
        ???.append(this.a.k);
        ???.append(" file:");
        ???.append(this.b.f);
        QLog.d("ImageToVideo", 2, ???.toString());
      }
      ??? = this.b.e.d();
      l1 = System.currentTimeMillis();
      long l2 = this.b.b;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(l1 - l2);
      ((StringBuilder)localObject1).append("");
      StoryReportor.a("actImage2VideoTime", new String[] { ((StringBuilder)localObject1).toString() });
      StoryReportor.a("actImage2VideoResult", new String[] { "0" });
      localObject1 = this.b;
      ((ImageToVideo)localObject1).a(((ImageToVideo)localObject1).d, this.a.a, this.b.f, ???, null, this.a);
    }
    else
    {
      StoryReportor.a("actImage2VideoResult", new String[] { "3" });
      FileUtils.k(???);
    }
    if (this.b.a != null)
    {
      this.b.a.surfaceDestroyed();
      this.b.a = null;
    }
    if (this.b.e != null)
    {
      this.b.e.e();
      this.b.e = null;
    }
    synchronized (this.b)
    {
      this.b.notifyAll();
      return;
    }
  }
  
  public void onEncodeFrame()
  {
    StringBuilder localStringBuilder;
    if (!this.a.j)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onEncodeFrame, mRun is false, tasid.");
        localStringBuilder.append(this.a.k);
        QLog.d("ImageToVideo", 2, localStringBuilder.toString());
      }
      if (this.b.e != null) {
        this.b.e.b();
      }
      return;
    }
    if (!a())
    {
      if (this.b.e != null) {
        this.b.e.b();
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onEncodeFrame, stop recoder, taskid:");
        localStringBuilder.append(this.a.k);
        QLog.d("ImageToVideo", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void onEncodeStart()
  {
    if (this.a.j)
    {
      long l1 = System.currentTimeMillis();
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onEncodeStart, taskid:");
        ((StringBuilder)localObject).append(this.a.k);
        QLog.d("ImageToVideo", 2, ((StringBuilder)localObject).toString());
      }
      if (!ImageToVideo.a(this.b))
      {
        localObject = this.b;
        ImageToVideo.a((ImageToVideo)localObject, ImageToVideo.a((ImageToVideo)localObject, ImageToVideo.b((ImageToVideo)localObject), this.a.b, this.a.c));
      }
      else
      {
        localObject = this.b;
        ImageToVideo.a((ImageToVideo)localObject, ImageToVideo.b((ImageToVideo)localObject, ImageToVideo.b((ImageToVideo)localObject), this.a.b, this.a.c));
      }
      if (ImageToVideo.b(this.b) != null)
      {
        ImageToVideo.b(this.b).recycle();
        ImageToVideo.a(this.b, null);
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onEncodeStart, taskid:");
        ((StringBuilder)localObject).append(this.a.k);
        ((StringBuilder)localObject).append(" run:");
        ((StringBuilder)localObject).append(this.a.j);
        ((StringBuilder)localObject).append(" preProcess cost: ");
        ((StringBuilder)localObject).append(l2 - l1);
        ((StringBuilder)localObject).append(" ms mGpuBlur:");
        ((StringBuilder)localObject).append(ImageToVideo.a(this.b));
        QLog.d("ImageToVideo", 2, ((StringBuilder)localObject).toString());
      }
      this.b.c = System.currentTimeMillis();
      a();
      return;
    }
    if (ImageToVideo.b(this.b) != null)
    {
      ImageToVideo.b(this.b).recycle();
      ImageToVideo.a(this.b, null);
    }
    if (this.b.e != null) {
      this.b.e.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.ImageToVideo.1
 * JD-Core Version:    0.7.0.1
 */