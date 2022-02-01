package com.tencent.av;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraListener;
import com.tencent.av.opengl.effects.CameraFrame;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.FramePerfData;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class VideoCameraListener
  extends CameraDataProcess
  implements CameraListener
{
  private final VideoController d;
  private boolean e = false;
  private WeakReference<VideoCameraListener.SwitchCameraListener> f = null;
  
  public VideoCameraListener(VideoController paramVideoController)
  {
    this.d = paramVideoController;
  }
  
  public int a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = this.d.k().g;
    if (paramBoolean1)
    {
      this.d.k().M = false;
      this.d.k().aK = false;
      this.d.k().b(paramLong, true);
      if (this.d.k().g == 1) {
        this.d.k().a(paramLong, "afterOpenCamera.1", 2);
      } else if ((this.d.k().g == 3) || (this.d.k().g == 4)) {
        this.d.k().a(paramLong, "afterOpenCamera.2", 4);
      }
      VideoController localVideoController = this.d;
      localVideoController.c(localVideoController.k().g);
    }
    return i;
  }
  
  public void a(long paramLong)
  {
    this.d.aj().a(new Object[] { Integer.valueOf(38), Integer.valueOf(2), Long.valueOf(paramLong) });
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = this.d.k();
    if (((SessionInfo)localObject).g == 2)
    {
      if (paramBoolean)
      {
        ((SessionInfo)localObject).b(paramLong, false);
        if (!((SessionInfo)localObject).I)
        {
          ((SessionInfo)localObject).a(paramLong, "CloseCameraRunnable.1", 1);
          ((SessionInfo)localObject).aK = true;
        }
      }
    }
    else if ((((SessionInfo)localObject).g == 4) && (!((SessionInfo)localObject).I)) {
      ((SessionInfo)localObject).a(paramLong, "CloseCameraRunnable.2", 3);
    }
    this.d.c(((SessionInfo)localObject).g);
    localObject = this.a;
    this.a = null;
    if (localObject != null) {
      ((FramePerfData)localObject).i();
    }
  }
  
  public void a(boolean paramBoolean, VideoCameraListener.SwitchCameraListener paramSwitchCameraListener)
  {
    this.e = paramBoolean;
    this.f = new WeakReference(paramSwitchCameraListener);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setSwitchStart, isStart[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], listener[");
      localStringBuilder.append(paramSwitchCameraListener);
      localStringBuilder.append("]");
      QLog.i("SurfaceTag", 2, localStringBuilder.toString());
    }
  }
  
  public void b()
  {
    long l = AudioHelper.c();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyCameraNoData, seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.i("CameraDataProcess", 2, localStringBuilder.toString());
    }
    this.d.e.a(new Object[] { Integer.valueOf(38), Integer.valueOf(1), Long.valueOf(l) });
  }
  
  public void c()
  {
    EffectsRenderController localEffectsRenderController = this.d.m(true);
    if (localEffectsRenderController != null)
    {
      a(localEffectsRenderController);
      return;
    }
    QLog.i("CameraDataProcess", 1, "checkEffectCtrl, ctrl is null.");
  }
  
  public void d()
  {
    Object localObject = this.f;
    if (localObject != null) {
      ((WeakReference)localObject).clear();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearSwitchCameraListener, isStart[");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append("]");
      QLog.i("SurfaceTag", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void e() {}
  
  public void f()
  {
    this.b = 0;
    this.c = false;
  }
  
  public void onPreviewData(CameraFrame paramCameraFrame)
  {
    if (paramCameraFrame.a())
    {
      paramCameraFrame.e();
      if (QLog.isColorLevel()) {
        QLog.e("OnPreviewData", 2, "onPreviewData data is null");
      }
      return;
    }
    if (this.e)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SurfaceTag", 2, "onPreviewData, first frame for switchCamera");
      }
      Object localObject = this.f;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = (VideoCameraListener.SwitchCameraListener)((WeakReference)localObject).get();
      }
      if (localObject != null) {
        ((VideoCameraListener.SwitchCameraListener)localObject).a();
      }
      this.e = false;
    }
    super.onPreviewData(paramCameraFrame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoCameraListener
 * JD-Core Version:    0.7.0.1
 */