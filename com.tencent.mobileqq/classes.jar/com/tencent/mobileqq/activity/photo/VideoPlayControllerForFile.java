package com.tencent.mobileqq.activity.photo;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VideoPlayControllerForFile
  extends VideoPlayControllerForAIO
  implements FileVideoMediaPlayHelper.OnCaptureVideoFrameImageListener
{
  private VideoPlayControllerForAIO.OnDownloadListener m = null;
  private Map<Long, Float> n = new ConcurrentHashMap();
  private VideoPlayControllerForFile.OnCaptureVideoFrameListener o;
  
  public VideoPlayControllerForFile()
  {
    this.c = new FileVideoMediaPlayHelper();
    ((FileVideoMediaPlayHelper)this.c).a(this);
  }
  
  public float a(long paramLong)
  {
    if (this.n.containsKey(Long.valueOf(paramLong))) {
      return ((Float)this.n.get(Long.valueOf(paramLong))).floatValue();
    }
    return 0.0F;
  }
  
  public void a(VideoPlayControllerForAIO.OnDownloadListener paramOnDownloadListener)
  {
    this.m = paramOnDownloadListener;
    ((FileVideoMediaPlayHelper)this.c).a(new VideoPlayControllerForFile.1(this));
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      VideoPlayControllerForFile.OnCaptureVideoFrameListener localOnCaptureVideoFrameListener = this.o;
      if (localOnCaptureVideoFrameListener != null) {
        localOnCaptureVideoFrameListener.a(paramString);
      }
    }
  }
  
  public boolean d()
  {
    if (this.a == null)
    {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPlay mInfo is null");
      return false;
    }
    if (!super.d()) {
      return false;
    }
    this.a.i = true;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnFileVideoPlay id:");
      ((StringBuilder)localObject).append(this.a.k);
      ((StringBuilder)localObject).append(" set played flag");
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, ((StringBuilder)localObject).toString());
    }
    if ((this.h != null) && (this.a.a))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131913536));
      ((StringBuilder)localObject).append(FileUtil.a(this.a.o));
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(FileUtil.a(this.a.n));
      ((StringBuilder)localObject).append(")");
      localObject = ((StringBuilder)localObject).toString();
      float f = (float)this.a.o / (float)this.a.n;
      this.m.a(this.a.k, f, (String)localObject);
      this.h.a(this.a.k, 11, this.a.r);
    }
    return false;
  }
  
  public void f()
  {
    if (this.a == null)
    {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPause mInfo is null");
      return;
    }
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OnFileVideoPause : ");
      ((StringBuilder)localObject).append(this.a.k);
      QLog.i("PauseDebug", 1, ((StringBuilder)localObject).toString());
    }
    if (this.i)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "OnFileVideoPause user set cancel,igon!");
      }
      return;
    }
    if ((this.l == 3) && (this.a.h) && (this.a.i) && (this.h != null))
    {
      this.a.i = false;
      localObject = new Bundle();
      ((Bundle)localObject).putFloat("progress", a(this.a.k));
      this.h.a(this.a.k, 10, (Bundle)localObject);
      this.c.a();
    }
  }
  
  public void g()
  {
    if (this.a == null)
    {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "onFileVideoCancel mInfo is null");
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFileVideoCancel id:");
      localStringBuilder.append(this.a.k);
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, localStringBuilder.toString());
    }
    this.c.a();
    this.h.a(this.a.k, 12, this.a.r);
  }
  
  public void h()
  {
    if (this.a == null)
    {
      super.h();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, "VideoPlayControllerForFile onItemClick");
    }
    if ((this.a.h) && (this.a.a) && (p()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("file[");
      localStringBuilder.append(this.a.k);
      localStringBuilder.append("] is downloading return!");
      QLog.i("VideoPlayControllerForFile.filevideoPeek", 1, localStringBuilder.toString());
      return;
    }
    super.h();
    if ((this.a.h) && (this.a.j) && (this.a.c.length > 0) && (!TextUtils.isEmpty(this.a.c[0])) && (this.c.c != null)) {
      d();
    }
  }
  
  public void m()
  {
    if (this.c != null) {
      this.c.c();
    }
  }
  
  public long s()
  {
    if (FileVideoMediaPlayHelper.class.isInstance(this.c)) {
      return ((FileVideoMediaPlayHelper)this.c).b();
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.VideoPlayControllerForFile
 * JD-Core Version:    0.7.0.1
 */