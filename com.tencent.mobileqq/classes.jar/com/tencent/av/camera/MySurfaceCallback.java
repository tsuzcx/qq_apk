package com.tencent.av.camera;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.av.opengl.effects.CameraFrame;
import com.tencent.qphone.base.util.QLog;

public class MySurfaceCallback
  extends CameraCallback
  implements SurfaceTexture.OnFrameAvailableListener
{
  public MySurfaceCallback(AndroidCamera paramAndroidCamera, AndroidCamera.CameraPreviewCallback paramCameraPreviewCallback)
  {
    super(paramAndroidCamera, paramCameraPreviewCallback);
  }
  
  public void a() {}
  
  public void a(long paramLong, SurfaceTexture paramSurfaceTexture)
  {
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.setOnFrameAvailableListener(this);
    }
    if (QLog.isColorLevel()) {
      QLog.i("SurfaceTag", 2, "setPreviewCallback, seq[" + paramLong + "], surfaceTexture[" + paramSurfaceTexture + "]");
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    CameraFrame.a(paramSurfaceTexture);
    a(this.jdField_a_of_type_ComTencentAvCameraCameraCallback$PreviewAngleParam);
    int i = AndroidCamera.a;
    int j = AndroidCamera.b;
    this.jdField_a_of_type_ComTencentAvCameraPreviewCallbackInfo.a(this.jdField_a_of_type_ComTencentAvCameraCameraCallback$PreviewAngleParam.a, this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Int, AndroidCamera.d, this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Boolean, this.jdField_a_of_type_ComTencentAvCameraCameraCallback$PreviewAngleParam.c, this.jdField_a_of_type_ComTencentAvCameraCameraCallback$PreviewAngleParam.d, this.jdField_a_of_type_ComTencentAvCameraCameraCallback$PreviewAngleParam.b, 0, i, j);
    CameraFrame localCameraFrame;
    long l;
    int k;
    int m;
    int n;
    if (this.jdField_a_of_type_ComTencentAvCameraAndroidCamera$CameraPreviewCallback != null)
    {
      localCameraFrame = CameraFrame.a();
      l = this.jdField_a_of_type_ComTencentAvCameraPreviewCallbackInfo.j;
      k = AndroidCamera.c;
      m = this.jdField_a_of_type_ComTencentAvCameraCameraCallback$PreviewAngleParam.a;
      n = this.jdField_a_of_type_ComTencentAvCameraCameraCallback$PreviewAngleParam.b;
      if (this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Int != 1) {
        break label171;
      }
    }
    label171:
    for (boolean bool = true;; bool = false)
    {
      localCameraFrame.a(l, paramSurfaceTexture, i, j, k, m, n, bool, AndroidCamera.d, System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentAvCameraAndroidCamera$CameraPreviewCallback.a(localCameraFrame);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.camera.MySurfaceCallback
 * JD-Core Version:    0.7.0.1
 */