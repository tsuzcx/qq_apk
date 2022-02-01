package com.tencent.av.camera;

import android.graphics.SurfaceTexture;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.utils.PhoneStatusTools;

public abstract class CameraCallback
{
  protected int a;
  protected AndroidCamera.CameraPreviewCallback a;
  protected final AndroidCamera a;
  protected final CameraCallback.PreviewAngleParam a;
  protected PreviewCallbackInfo a;
  
  public CameraCallback(AndroidCamera paramAndroidCamera, AndroidCamera.CameraPreviewCallback paramCameraPreviewCallback)
  {
    this.jdField_a_of_type_ComTencentAvCameraPreviewCallbackInfo = new PreviewCallbackInfo();
    this.jdField_a_of_type_ComTencentAvCameraAndroidCamera$CameraPreviewCallback = null;
    this.jdField_a_of_type_ComTencentAvCameraCameraCallback$PreviewAngleParam = new CameraCallback.PreviewAngleParam();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentAvCameraAndroidCamera = paramAndroidCamera;
    this.jdField_a_of_type_ComTencentAvCameraAndroidCamera$CameraPreviewCallback = paramCameraPreviewCallback;
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    byte b;
    switch (paramInt)
    {
    default: 
      b = 0;
    }
    while (paramBoolean)
    {
      return ConfigSystemImpl.a(this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.a, true, false, b, false) * 90;
      b = 0;
      continue;
      b = 1;
      continue;
      b = 2;
      continue;
      b = 3;
    }
    return ConfigSystemImpl.b(this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.a, true, false, b, false) * 90;
  }
  
  public abstract void a();
  
  public abstract void a(long paramLong, SurfaceTexture paramSurfaceTexture);
  
  public void a(CameraCallback.PreviewAngleParam paramPreviewAngleParam)
  {
    int i = 0;
    int m = this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.f();
    int j;
    int n;
    label60:
    int k;
    if (this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Boolean)
    {
      j = 0;
      n = this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.g();
      if (this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Int != 1) {
        break label219;
      }
      i = (360 - (m + j) % 360) % 360;
      k = i + n;
      if ((m != 270) && (m != 90)) {
        break label246;
      }
      i = k;
      if (n % 180 == 0)
      {
        i = k;
        if (this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Int == 1) {
          if (a())
          {
            i = k;
            if (!this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.e) {}
          }
          else
          {
            i = k + 180;
          }
        }
      }
      label134:
      if (this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Int != 1) {
        break label370;
      }
      if (this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.l <= 0) {
        break label351;
      }
      i += 360 - this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.l;
    }
    for (;;)
    {
      i = i % 360 / 90;
      if (paramPreviewAngleParam != null)
      {
        paramPreviewAngleParam.jdField_a_of_type_Int = i;
        paramPreviewAngleParam.b = n;
        paramPreviewAngleParam.c = m;
        paramPreviewAngleParam.d = j;
      }
      return;
      j = this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.c() * 90;
      break;
      label219:
      if (this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Int != 2) {
        break label60;
      }
      i = (m - j + 360) % 360;
      break label60;
      label246:
      if (m != 0)
      {
        i = k;
        if (m != 180) {
          break label134;
        }
      }
      if ((n == 90) || (n == 270))
      {
        i = k;
        if (this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Int != 1) {
          break label134;
        }
        i = k;
        if (this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.d) {
          break label134;
        }
        i = k + 180;
        break label134;
      }
      i = k;
      if (this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Int != 1) {
        break label134;
      }
      i = k;
      if (!this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.d) {
        break label134;
      }
      i = k + 180;
      break label134;
      label351:
      i += a(n, this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Boolean);
      continue;
      label370:
      if (this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.m > 0) {
        i += this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.m;
      } else {
        i += b(n, this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Boolean);
      }
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Int == -1) {
      if (!PhoneStatusTools.a(this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.a, "ro.qq.orientation").equalsIgnoreCase("ZTE")) {
        break label43;
      }
    }
    label43:
    for (this.jdField_a_of_type_Int = 1; this.jdField_a_of_type_Int == 1; this.jdField_a_of_type_Int = 0) {
      return true;
    }
    return false;
  }
  
  public int b(int paramInt, boolean paramBoolean)
  {
    byte b;
    switch (paramInt)
    {
    default: 
      b = 0;
    }
    while (paramBoolean)
    {
      return ConfigSystemImpl.a(this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.a, false, false, b, false) * 90;
      b = 0;
      continue;
      b = 1;
      continue;
      b = 2;
      continue;
      b = 3;
    }
    return ConfigSystemImpl.b(this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.a, false, false, b, false) * 90;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.camera.CameraCallback
 * JD-Core Version:    0.7.0.1
 */