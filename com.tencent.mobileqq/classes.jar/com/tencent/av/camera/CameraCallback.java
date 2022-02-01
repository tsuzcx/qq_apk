package com.tencent.av.camera;

import android.graphics.SurfaceTexture;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.utils.PhoneStatusTools;

public abstract class CameraCallback
{
  protected int a;
  protected final AndroidCamera a;
  protected final CameraCallback.PreviewAngleParam a;
  protected CameraPreviewCallback a;
  protected PreviewCallbackInfo a;
  
  public CameraCallback(AndroidCamera paramAndroidCamera, CameraPreviewCallback paramCameraPreviewCallback)
  {
    this.jdField_a_of_type_ComTencentAvCameraPreviewCallbackInfo = new PreviewCallbackInfo();
    this.jdField_a_of_type_ComTencentAvCameraCameraPreviewCallback = null;
    this.jdField_a_of_type_ComTencentAvCameraCameraCallback$PreviewAngleParam = new CameraCallback.PreviewAngleParam();
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentAvCameraAndroidCamera = paramAndroidCamera;
    this.jdField_a_of_type_ComTencentAvCameraCameraPreviewCallback = paramCameraPreviewCallback;
  }
  
  public int a(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 0)
    {
      if (paramInt == 90) {
        break label39;
      }
      if (paramInt == 180) {
        break label34;
      }
      if (paramInt == 270) {}
    }
    else
    {
      b = 0;
      break label41;
    }
    byte b = 3;
    break label41;
    label34:
    b = 2;
    break label41;
    label39:
    b = 1;
    label41:
    if (paramBoolean) {}
    for (paramInt = ConfigSystemImpl.a(this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.a, true, false, b, false);; paramInt = ConfigSystemImpl.b(this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.a, true, false, b, false)) {
      return paramInt * 90;
    }
  }
  
  public abstract void a();
  
  public abstract void a(long paramLong, SurfaceTexture paramSurfaceTexture);
  
  public void a(CameraCallback.PreviewAngleParam paramPreviewAngleParam)
  {
    int m = this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.f();
    boolean bool = this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Boolean;
    int i = 0;
    int j;
    if (bool) {
      j = 0;
    } else {
      j = this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.c() * 90;
    }
    int n = this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.g();
    if (this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Int == 1) {
      i = (360 - (m + j) % 360) % 360;
    } else if (this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Int == 2) {
      i = (m - j + 360) % 360;
    }
    i += n;
    if ((m != 270) && (m != 90))
    {
      if (m != 0)
      {
        k = i;
        if (m != 180) {
          break label275;
        }
      }
      if ((n != 90) && (n != 270))
      {
        k = i;
        if (this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Int != 1) {
          break label275;
        }
        k = i;
        if (!this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.d) {
          break label275;
        }
      }
      else
      {
        k = i;
        if (this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Int != 1) {
          break label275;
        }
        k = i;
        if (this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.d) {
          break label275;
        }
      }
    }
    else
    {
      k = i;
      if (n % 180 != 0) {
        break label275;
      }
      k = i;
      if (this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Int != 1) {
        break label275;
      }
      if (a())
      {
        k = i;
        if (!this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.e) {
          break label275;
        }
      }
    }
    int k = i + 180;
    label275:
    if (this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Int == 1)
    {
      if (this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.l > 0)
      {
        i = 360 - this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.l + k;
        break label371;
      }
      i = a(n, this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Boolean);
    }
    else if (this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.m > 0)
    {
      i = this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.m;
    }
    else
    {
      i = b(n, this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.jdField_f_of_type_Boolean);
    }
    i += k;
    label371:
    i = i % 360 / 90;
    if (paramPreviewAngleParam != null)
    {
      paramPreviewAngleParam.jdField_a_of_type_Int = i;
      paramPreviewAngleParam.b = n;
      paramPreviewAngleParam.c = m;
      paramPreviewAngleParam.d = j;
    }
  }
  
  public boolean a()
  {
    int i = this.jdField_a_of_type_Int;
    boolean bool = false;
    if (i == -1) {
      if (PhoneStatusTools.a(this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.a, "ro.qq.orientation").equalsIgnoreCase("ZTE")) {
        this.jdField_a_of_type_Int = 1;
      } else {
        this.jdField_a_of_type_Int = 0;
      }
    }
    if (this.jdField_a_of_type_Int == 1) {
      bool = true;
    }
    return bool;
  }
  
  public int b(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 0)
    {
      if (paramInt == 90) {
        break label39;
      }
      if (paramInt == 180) {
        break label34;
      }
      if (paramInt == 270) {}
    }
    else
    {
      b = 0;
      break label41;
    }
    byte b = 3;
    break label41;
    label34:
    b = 2;
    break label41;
    label39:
    b = 1;
    label41:
    if (paramBoolean) {}
    for (paramInt = ConfigSystemImpl.a(this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.a, false, false, b, false);; paramInt = ConfigSystemImpl.b(this.jdField_a_of_type_ComTencentAvCameraAndroidCamera.a, false, false, b, false)) {
      return paramInt * 90;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.camera.CameraCallback
 * JD-Core Version:    0.7.0.1
 */