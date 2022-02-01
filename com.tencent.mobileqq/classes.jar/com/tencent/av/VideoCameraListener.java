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
  private final VideoController jdField_a_of_type_ComTencentAvVideoController;
  private WeakReference<VideoCameraListener.SwitchCameraListener> jdField_a_of_type_MqqUtilWeakReference = null;
  private boolean b = false;
  
  public VideoCameraListener(VideoController paramVideoController)
  {
    this.jdField_a_of_type_ComTencentAvVideoController = paramVideoController;
  }
  
  public int a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = this.jdField_a_of_type_ComTencentAvVideoController.a().d;
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().n = false;
      this.jdField_a_of_type_ComTencentAvVideoController.a().H = false;
      this.jdField_a_of_type_ComTencentAvVideoController.a().b(paramLong, true);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 1) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "afterOpenCamera.1", 2);
      } else if ((this.jdField_a_of_type_ComTencentAvVideoController.a().d == 3) || (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4)) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "afterOpenCamera.2", 4);
      }
      VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
      localVideoController.c(localVideoController.a().d);
    }
    return i;
  }
  
  public void a()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("notifyCameraNoData, seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.i("CameraDataProcess", 2, localStringBuilder.toString());
    }
    this.jdField_a_of_type_ComTencentAvVideoController.a.a(new Object[] { Integer.valueOf(38), Integer.valueOf(1), Long.valueOf(l) });
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentAvVideoController.a().a(new Object[] { Integer.valueOf(38), Integer.valueOf(2), Long.valueOf(paramLong) });
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    Object localObject = this.jdField_a_of_type_ComTencentAvVideoController.a();
    if (((SessionInfo)localObject).d == 2)
    {
      if (paramBoolean)
      {
        ((SessionInfo)localObject).b(paramLong, false);
        if (!((SessionInfo)localObject).k)
        {
          ((SessionInfo)localObject).a(paramLong, "CloseCameraRunnable.1", 1);
          ((SessionInfo)localObject).H = true;
        }
      }
    }
    else if ((((SessionInfo)localObject).d == 4) && (!((SessionInfo)localObject).k)) {
      ((SessionInfo)localObject).a(paramLong, "CloseCameraRunnable.2", 3);
    }
    this.jdField_a_of_type_ComTencentAvVideoController.c(((SessionInfo)localObject).d);
    localObject = this.jdField_a_of_type_ComTencentAvUtilsFramePerfData;
    this.jdField_a_of_type_ComTencentAvUtilsFramePerfData = null;
    if (localObject != null) {
      ((FramePerfData)localObject).d();
    }
  }
  
  public void a(boolean paramBoolean, VideoCameraListener.SwitchCameraListener paramSwitchCameraListener)
  {
    this.b = paramBoolean;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramSwitchCameraListener);
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
    EffectsRenderController localEffectsRenderController = this.jdField_a_of_type_ComTencentAvVideoController.a(true);
    if (localEffectsRenderController != null)
    {
      a(localEffectsRenderController);
      return;
    }
    QLog.i("CameraDataProcess", 1, "checkEffectCtrl, ctrl is null.");
  }
  
  public void c()
  {
    Object localObject = this.jdField_a_of_type_MqqUtilWeakReference;
    if (localObject != null) {
      ((WeakReference)localObject).clear();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("clearSwitchCameraListener, isStart[");
      ((StringBuilder)localObject).append(this.b);
      ((StringBuilder)localObject).append("]");
      QLog.i("SurfaceTag", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void d() {}
  
  public void e()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onPreviewData(CameraFrame paramCameraFrame)
  {
    if (paramCameraFrame.a())
    {
      paramCameraFrame.b();
      if (QLog.isColorLevel()) {
        QLog.e("OnPreviewData", 2, "onPreviewData data is null");
      }
      return;
    }
    if (this.b)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SurfaceTag", 2, "onPreviewData, first frame for switchCamera");
      }
      Object localObject = this.jdField_a_of_type_MqqUtilWeakReference;
      if (localObject == null) {
        localObject = null;
      } else {
        localObject = (VideoCameraListener.SwitchCameraListener)((WeakReference)localObject).get();
      }
      if (localObject != null) {
        ((VideoCameraListener.SwitchCameraListener)localObject).a();
      }
      this.b = false;
    }
    super.onPreviewData(paramCameraFrame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.VideoCameraListener
 * JD-Core Version:    0.7.0.1
 */