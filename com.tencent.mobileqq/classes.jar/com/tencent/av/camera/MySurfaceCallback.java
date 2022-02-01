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
  
  public void b() {}
  
  public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
  {
    CameraFrame.a(paramSurfaceTexture);
    a(this.d);
    int i = AndroidCamera.b;
    int j = AndroidCamera.c;
    this.a.a(this.d.a, this.b.l, AndroidCamera.f, this.b.y, this.d.c, this.d.d, this.d.b, 0, i, j);
    if (this.c != null)
    {
      CameraFrame localCameraFrame = CameraFrame.f();
      long l = this.a.k;
      int k = AndroidCamera.d;
      int m = this.d.a;
      int n = this.d.b;
      boolean bool;
      if (this.b.l == 1) {
        bool = true;
      } else {
        bool = false;
      }
      localCameraFrame.a(l, paramSurfaceTexture, i, j, k, m, n, bool, AndroidCamera.f, System.currentTimeMillis());
      this.c.onPreviewData(localCameraFrame);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.camera.MySurfaceCallback
 * JD-Core Version:    0.7.0.1
 */