package com.tencent.av.camera.api.impl;

import com.tencent.av.camera.CameraListener;
import com.tencent.av.camera.VcCamera;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.qphone.base.util.QLog;

class CameraManagerApiImpl$NoPreviewRunnable
  implements Runnable
{
  public long a = 0L;
  
  CameraManagerApiImpl$NoPreviewRunnable(CameraManagerApiImpl paramCameraManagerApiImpl) {}
  
  public void run()
  {
    boolean bool;
    if (CameraManagerApiImpl.access$500(this.this$0) != null) {
      bool = CameraManagerApiImpl.access$500(this.this$0).l();
    } else {
      bool = false;
    }
    if (QQAudioHelper.f())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("NoPreviewRunnable.run, seq[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("], isCameraOpened[");
      localStringBuilder.append(bool);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("]");
      QLog.w("CameraUtils", 1, localStringBuilder.toString());
    }
    if (CameraManagerApiImpl.access$600(this.this$0) != null) {
      CameraManagerApiImpl.access$600(this.this$0).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.camera.api.impl.CameraManagerApiImpl.NoPreviewRunnable
 * JD-Core Version:    0.7.0.1
 */