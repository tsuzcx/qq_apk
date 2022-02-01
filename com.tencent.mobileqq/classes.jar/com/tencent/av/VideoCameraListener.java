package com.tencent.av;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.camera.CameraListener;
import com.tencent.av.opengl.effects.CameraFrame;
import com.tencent.av.opengl.effects.EffectsRenderController;
import com.tencent.av.utils.FramePerfData;
import com.tencent.mobileqq.utils.AudioHelper;
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
    if (paramBoolean2) {
      this.jdField_a_of_type_ComTencentAvVideoController.a().q = true;
    }
    if (paramBoolean1)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.a().n = false;
      this.jdField_a_of_type_ComTencentAvVideoController.a().S = false;
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, true);
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().d != 1) {
        break label114;
      }
      this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "afterOpenCamera.1", 2);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.c(this.jdField_a_of_type_ComTencentAvVideoController.a().d);
      return i;
      label114:
      if ((this.jdField_a_of_type_ComTencentAvVideoController.a().d == 3) || (this.jdField_a_of_type_ComTencentAvVideoController.a().d == 4)) {
        this.jdField_a_of_type_ComTencentAvVideoController.a().a(paramLong, "afterOpenCamera.2", 4);
      }
    }
  }
  
  public void a()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.i("CameraDataProcess", 2, "notifyCameraNoData, seq[" + l + "]");
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
    if (((SessionInfo)localObject).d == 2) {
      if (paramBoolean)
      {
        ((SessionInfo)localObject).a(paramLong, false);
        if (!((SessionInfo)localObject).k)
        {
          ((SessionInfo)localObject).a(paramLong, "CloseCameraRunnable.1", 1);
          ((SessionInfo)localObject).S = true;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentAvVideoController.c(((SessionInfo)localObject).d);
      localObject = this.jdField_a_of_type_ComTencentAvUtilsFramePerfData;
      this.jdField_a_of_type_ComTencentAvUtilsFramePerfData = null;
      if (localObject != null) {
        ((FramePerfData)localObject).d();
      }
      return;
      if ((((SessionInfo)localObject).d == 4) && (!((SessionInfo)localObject).k)) {
        ((SessionInfo)localObject).a(paramLong, "CloseCameraRunnable.2", 3);
      }
    }
  }
  
  public void a(CameraFrame paramCameraFrame)
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
      if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
        break label77;
      }
    }
    label77:
    for (VideoCameraListener.SwitchCameraListener localSwitchCameraListener = null;; localSwitchCameraListener = (VideoCameraListener.SwitchCameraListener)this.jdField_a_of_type_MqqUtilWeakReference.get())
    {
      if (localSwitchCameraListener != null) {
        localSwitchCameraListener.a();
      }
      this.b = false;
      super.a(paramCameraFrame);
      return;
    }
  }
  
  public void a(boolean paramBoolean, VideoCameraListener.SwitchCameraListener paramSwitchCameraListener)
  {
    this.b = paramBoolean;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramSwitchCameraListener);
    if (QLog.isColorLevel()) {
      QLog.i("SurfaceTag", 2, "setSwitchStart, isStart[" + paramBoolean + "], listener[" + paramSwitchCameraListener + "]");
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
    if (this.jdField_a_of_type_MqqUtilWeakReference != null) {
      this.jdField_a_of_type_MqqUtilWeakReference.clear();
    }
    if (QLog.isColorLevel()) {
      QLog.i("SurfaceTag", 2, "clearSwitchCameraListener, isStart[" + this.b + "]");
    }
  }
  
  public void d() {}
  
  public void e()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.VideoCameraListener
 * JD-Core Version:    0.7.0.1
 */