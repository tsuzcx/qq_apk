package com.tencent.aelight.camera.ae.camera.testpkg;

import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.os.Build;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqcamerakit.capture.CameraPreviewCallBack;
import com.tencent.qqcamerakit.capture.CameraProxy;
import com.tencent.qqcamerakit.capture.CameraProxy.CameraAutoFocusCallBack;
import com.tencent.qqcamerakit.capture.CameraProxy.PictureCallback;
import com.tencent.qqcamerakit.capture.CameraSize;
import com.tencent.qqcamerakit.common.Observer;

public class CameraProxyImp
  implements IProxyForTestCap
{
  private final CameraProxy a;
  
  public CameraProxyImp()
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append(" ");
    localStringBuilder.append(Build.MODEL);
    this.a = new CameraProxy(localBaseApplication, null, "Google Pixel 4 XL".equals(localStringBuilder.toString()) ^ true);
  }
  
  public void a()
  {
    this.a.d();
  }
  
  public void a(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  public void a(Matrix paramMatrix, CameraProxy.CameraAutoFocusCallBack paramCameraAutoFocusCallBack, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2)
  {
    this.a.a(paramMatrix, paramCameraAutoFocusCallBack, paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2);
  }
  
  public void a(SurfaceTexture paramSurfaceTexture, CameraPreviewCallBack paramCameraPreviewCallBack)
  {
    this.a.a(paramSurfaceTexture, paramCameraPreviewCallBack);
  }
  
  public void a(CameraSize paramCameraSize1, CameraSize paramCameraSize2, CameraSize paramCameraSize3, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    this.a.a(paramCameraSize1, paramCameraSize2, paramCameraSize3, paramInt1, paramString, paramInt2, paramInt3);
  }
  
  public void a(CameraSize paramCameraSize, boolean paramBoolean, String paramString, int paramInt, CameraProxy.PictureCallback paramPictureCallback)
  {
    this.a.a(paramCameraSize, paramBoolean, paramString, paramInt, paramPictureCallback);
  }
  
  public void a(Observer paramObserver)
  {
    this.a.a(paramObserver);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }
  
  public Object b()
  {
    return this.a.b();
  }
  
  public void b(int paramInt)
  {
    this.a.b(paramInt);
  }
  
  public void b(Observer paramObserver)
  {
    this.a.b(paramObserver);
  }
  
  public void b(boolean paramBoolean)
  {
    this.a.b(paramBoolean);
  }
  
  public void c()
  {
    this.a.c();
  }
  
  public void c(boolean paramBoolean)
  {
    this.a.c(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.testpkg.CameraProxyImp
 * JD-Core Version:    0.7.0.1
 */