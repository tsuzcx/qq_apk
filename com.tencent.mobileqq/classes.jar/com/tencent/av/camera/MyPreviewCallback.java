package com.tencent.av.camera;

import android.annotation.TargetApi;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import com.tencent.av.opengl.effects.CameraFrame;
import com.tencent.av.utils.AudioHelper;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;

public class MyPreviewCallback
  extends CameraCallback
  implements Camera.PreviewCallback
{
  public boolean a;
  
  public MyPreviewCallback(AndroidCamera paramAndroidCamera, CameraPreviewCallback paramCameraPreviewCallback)
  {
    super(paramAndroidCamera, paramCameraPreviewCallback);
    this.jdField_a_of_type_Boolean = true;
  }
  
  private int a(int paramInt)
  {
    int i = ImageFormat.getBitsPerPixel(paramInt);
    float f = i * 1.0F / 8.0F;
    int j = (int)(AndroidCamera.b * AndroidCamera.jdField_a_of_type_Int * f);
    if (AudioHelper.b())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPreviewBufferSize, previewFormat[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], bitPixel[");
      localStringBuilder.append(i);
      localStringBuilder.append("], byteNum[");
      localStringBuilder.append(f);
      localStringBuilder.append("], bufSize[");
      localStringBuilder.append(j);
      localStringBuilder.append("]");
      QLog.w("MyPreviewCallback", 1, localStringBuilder.toString());
    }
    return j;
  }
  
  private boolean a(int paramInt)
  {
    if (paramInt <= 0) {
      return false;
    }
    try
    {
      FrameBufMgr.a().a(paramInt);
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      label17:
      break label17;
    }
    URLDrawable.clearMemoryCache();
    try
    {
      FrameBufMgr.a().a(paramInt);
      return true;
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("allocateFrame failed , size:");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", ");
      localStringBuilder.append(localOutOfMemoryError1.getMessage());
      QLog.e("MyPreviewCallback", 2, localStringBuilder.toString());
      return false;
    }
  }
  
  public void a()
  {
    FrameBufMgr.a().a();
    if (QLog.isColorLevel()) {
      QLog.i("MyPreviewCallback", 2, "release");
    }
  }
  
  public void a(long paramLong, SurfaceTexture paramSurfaceTexture)
  {
    this.jdField_a_of_type_ComTencentAvCameraPreviewCallbackInfo.a();
    int i;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.a() != null))
    {
      boolean bool = a(a(this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.a().getPreviewFormat()));
      i = 2;
      if (bool)
      {
        int j = 0;
        for (int k = 0; j < FrameBufMgr.a().a(); k = i)
        {
          paramSurfaceTexture = FrameBufMgr.a().a(0);
          i = k;
          if (paramSurfaceTexture != null)
          {
            FrameBufMgr.a().a(paramSurfaceTexture, 1);
            this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(paramSurfaceTexture);
            k += 1;
            i = k;
            if (k >= 2) {
              break;
            }
          }
          j += 1;
        }
        this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallbackWithBuffer(this);
        i = 1;
      }
      else
      {
        this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(this);
      }
    }
    else
    {
      i = 3;
      this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_a_of_type_AndroidHardwareCamera.setPreviewCallback(this);
    }
    paramSurfaceTexture = new StringBuilder();
    paramSurfaceTexture.append("setPreviewCallback, type[");
    paramSurfaceTexture.append(i);
    paramSurfaceTexture.append("], seq[");
    paramSurfaceTexture.append(paramLong);
    paramSurfaceTexture.append("]");
    QLog.w("MyPreviewCallback", 1, paramSurfaceTexture.toString());
  }
  
  @TargetApi(8)
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (paramArrayOfByte == null)
    {
      if (AudioHelper.b())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("onPreviewFrame, data is null, Camera[");
        paramArrayOfByte.append(paramCamera);
        paramArrayOfByte.append("], camera[");
        paramArrayOfByte.append(this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_a_of_type_AndroidHardwareCamera);
        paramArrayOfByte.append("]");
        QLog.w("MyPreviewCallback", 1, paramArrayOfByte.toString());
      }
      this.jdField_a_of_type_ComTencentAvCameraPreviewCallbackInfo.b();
      return;
    }
    a(this.jdField_a_of_type_ComTencentAvCameraCameraCallback$PreviewAngleParam);
    int n = paramArrayOfByte.length;
    int i = AndroidCamera.jdField_a_of_type_Int;
    int j = AndroidCamera.b;
    int k = i;
    int m = j;
    if (n != i * j * 3 / 2)
    {
      if (n == 460800)
      {
        i = 640;
        j = 480;
      }
      else if (n == 1382400)
      {
        i = 1280;
        j = 720;
      }
      else if (n == 115200)
      {
        i = 320;
        j = 240;
      }
      k = i;
      m = j;
      if (AudioHelper.b())
      {
        paramCamera = new StringBuilder();
        paramCamera.append("OnPreviewData false, expectSize[");
        paramCamera.append(AndroidCamera.jdField_a_of_type_Int);
        paramCamera.append(", ");
        paramCamera.append(AndroidCamera.b);
        paramCamera.append("], dataLen[");
        paramCamera.append(n);
        paramCamera.append("], fixSize[");
        paramCamera.append(i);
        paramCamera.append(", ");
        paramCamera.append(j);
        paramCamera.append("]");
        QLog.w("MyPreviewCallback", 1, paramCamera.toString());
        m = j;
        k = i;
      }
    }
    this.jdField_a_of_type_ComTencentAvCameraPreviewCallbackInfo.a(this.jdField_a_of_type_ComTencentAvCameraCameraCallback$PreviewAngleParam.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Int, AndroidCamera.d, this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Boolean, this.jdField_a_of_type_ComTencentAvCameraCameraCallback$PreviewAngleParam.c, this.jdField_a_of_type_ComTencentAvCameraCameraCallback$PreviewAngleParam.d, this.jdField_a_of_type_ComTencentAvCameraCameraCallback$PreviewAngleParam.b, n, k, m);
    if (this.jdField_a_of_type_ComTencentAvCameraCameraPreviewCallback != null)
    {
      paramCamera = CameraFrame.a();
      long l = this.jdField_a_of_type_ComTencentAvCameraPreviewCallbackInfo.j;
      i = AndroidCamera.c;
      j = this.jdField_a_of_type_ComTencentAvCameraCameraCallback$PreviewAngleParam.jdField_a_of_type_Int;
      n = this.jdField_a_of_type_ComTencentAvCameraCameraCallback$PreviewAngleParam.b;
      boolean bool;
      if (this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Int == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramCamera.a(l, paramArrayOfByte, k, m, i, j, n, bool, AndroidCamera.d, System.currentTimeMillis());
      this.jdField_a_of_type_ComTencentAvCameraCameraPreviewCallback.onPreviewData(paramCamera);
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_a_of_type_AndroidHardwareCamera != null))
    {
      byte[] arrayOfByte = FrameBufMgr.a().a(0);
      paramCamera = arrayOfByte;
      if (arrayOfByte == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w("MyPreviewCallback", 1, "OnPreviewData, 没有空闲的缓存");
        }
        paramCamera = paramArrayOfByte;
      }
      FrameBufMgr.a().a(paramCamera, 1);
      this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_a_of_type_AndroidHardwareCamera.addCallbackBuffer(paramCamera);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.camera.MyPreviewCallback
 * JD-Core Version:    0.7.0.1
 */