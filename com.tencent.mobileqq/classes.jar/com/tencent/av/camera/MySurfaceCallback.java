package com.tencent.av.camera;

import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import com.tencent.av.opengl.effects.CameraFrame;
import com.tencent.qphone.base.util.QLog;

public class MySurfaceCallback
  extends CameraCallback
  implements SurfaceTexture.OnFrameAvailableListener
{
  public MySurfaceCallback(AndroidCamera paramAndroidCamera, CameraPreviewCallback paramCameraPreviewCallback)
  {
    super(paramAndroidCamera, paramCameraPreviewCallback);
  }
  
  public void a() {}
  
  public void a(long paramLong, SurfaceTexture paramSurfaceTexture)
  {
    if (paramSurfaceTexture != null) {
      paramSurfaceTexture.setOnFrameAvailableListener(this);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setPreviewCallback, seq[");
      localStringBuilder.append(paramLong);
      localStringBuilder.append("], surfaceTexture[");
      localStringBuilder.append(paramSurfaceTexture);
      localStringBuilder.append("]");
      QLog.i("SurfaceTag", 2, localStringBuilder.toString());
    }
  }
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    CameraFrame.a(paramSurfaceTexture);
    a(this.jdField_a_of_type_ComTencentAvCameraCameraCallback$PreviewAngleParam);
    int i = AndroidCamera.a;
    int j = AndroidCamera.b;
    this.jdField_a_of_type_ComTencentAvCameraPreviewCallbackInfo.a(this.jdField_a_of_type_ComTencentAvCameraCameraCallback$PreviewAngleParam.a, this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Int, AndroidCamera.d, this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Boolean, this.jdField_a_of_type_ComTencentAvCameraCameraCallback$PreviewAngleParam.c, this.jdField_a_of_type_ComTencentAvCameraCameraCallback$PreviewAngleParam.d, this.jdField_a_of_type_ComTencentAvCameraCameraCallback$PreviewAngleParam.b, 0, i, j);
    if (this.jdField_a_of_type_ComTencentAvCameraCameraPreviewCallback != null)
    {
      CameraFrame localCameraFrame = CameraFrame.a();
      long l = this.jdField_a_of_type_ComTencentAvCameraPreviewCallbackInfo.j;
      int k = AndroidCamera.c;
      int m = this.jdField_a_of_type_ComTencentAvCameraCameraCallback$PreviewAngleParam.a;
      int n = this.jdField_a_of_type_ComTencentAvCameraCameraCallback$PreviewAngleParam.b;
      boolean bool;
      if (this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Int == 1) {
        bool = true;
      } else {
        bool = false;
      }
      localCameraFrame.a(l, paramSurfaceTexture, i, j, k, m, n, bool, AndroidCamera.d, System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentAvCameraCameraPreviewCallback.onPreviewData(localCameraFrame);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.camera.MySurfaceCallback
 * JD-Core Version:    0.7.0.1
 */