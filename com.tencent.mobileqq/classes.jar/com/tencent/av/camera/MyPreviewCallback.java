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
  public boolean f = true;
  
  public MyPreviewCallback(AndroidCamera paramAndroidCamera, CameraPreviewCallback paramCameraPreviewCallback)
  {
    super(paramAndroidCamera, paramCameraPreviewCallback);
  }
  
  private int a(int paramInt)
  {
    int i = ImageFormat.getBitsPerPixel(paramInt);
    float f1 = i * 1.0F / 8.0F;
    int j = (int)(AndroidCamera.c * AndroidCamera.b * f1);
    if (AudioHelper.e())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPreviewBufferSize, previewFormat[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], bitPixel[");
      localStringBuilder.append(i);
      localStringBuilder.append("], byteNum[");
      localStringBuilder.append(f1);
      localStringBuilder.append("], bufSize[");
      localStringBuilder.append(j);
      localStringBuilder.append("]");
      QLog.w("MyPreviewCallback", 1, localStringBuilder.toString());
    }
    return j;
  }
  
  private boolean b(int paramInt)
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
  
  public void a(long paramLong, SurfaceTexture paramSurfaceTexture)
  {
    this.a.a();
    int i;
    if ((this.f) && (this.b.b() != null))
    {
      boolean bool = b(a(this.b.b().getPreviewFormat()));
      i = 2;
      if (bool)
      {
        int j = 0;
        for (int k = 0; j < FrameBufMgr.a().c(); k = i)
        {
          paramSurfaceTexture = FrameBufMgr.a().b(0);
          i = k;
          if (paramSurfaceTexture != null)
          {
            FrameBufMgr.a().a(paramSurfaceTexture, 1);
            this.b.k.addCallbackBuffer(paramSurfaceTexture);
            k += 1;
            i = k;
            if (k >= 2) {
              break;
            }
          }
          j += 1;
        }
        this.b.k.setPreviewCallbackWithBuffer(this);
        i = 1;
      }
      else
      {
        this.b.k.setPreviewCallback(this);
      }
    }
    else
    {
      i = 3;
      this.b.k.setPreviewCallback(this);
    }
    paramSurfaceTexture = new StringBuilder();
    paramSurfaceTexture.append("setPreviewCallback, type[");
    paramSurfaceTexture.append(i);
    paramSurfaceTexture.append("], seq[");
    paramSurfaceTexture.append(paramLong);
    paramSurfaceTexture.append("]");
    QLog.w("MyPreviewCallback", 1, paramSurfaceTexture.toString());
  }
  
  public void b()
  {
    FrameBufMgr.a().b();
    if (QLog.isColorLevel()) {
      QLog.i("MyPreviewCallback", 2, "release");
    }
  }
  
  @TargetApi(8)
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (paramArrayOfByte == null)
    {
      if (AudioHelper.e())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("onPreviewFrame, data is null, Camera[");
        paramArrayOfByte.append(paramCamera);
        paramArrayOfByte.append("], camera[");
        paramArrayOfByte.append(this.b.k);
        paramArrayOfByte.append("]");
        QLog.w("MyPreviewCallback", 1, paramArrayOfByte.toString());
      }
      this.a.b();
      return;
    }
    a(this.d);
    int n = paramArrayOfByte.length;
    int i = AndroidCamera.b;
    int j = AndroidCamera.c;
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
      if (AudioHelper.e())
      {
        paramCamera = new StringBuilder();
        paramCamera.append("OnPreviewData false, expectSize[");
        paramCamera.append(AndroidCamera.b);
        paramCamera.append(", ");
        paramCamera.append(AndroidCamera.c);
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
    this.a.a(this.d.a, this.b.l, AndroidCamera.f, this.b.y, this.d.c, this.d.d, this.d.b, n, k, m);
    if (this.c != null)
    {
      paramCamera = CameraFrame.f();
      long l = this.a.k;
      i = AndroidCamera.d;
      j = this.d.a;
      n = this.d.b;
      boolean bool;
      if (this.b.l == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramCamera.a(l, paramArrayOfByte, k, m, i, j, n, bool, AndroidCamera.f, System.currentTimeMillis());
      this.c.onPreviewData(paramCamera);
    }
    if ((this.f) && (this.b.k != null))
    {
      byte[] arrayOfByte = FrameBufMgr.a().b(0);
      paramCamera = arrayOfByte;
      if (arrayOfByte == null)
      {
        if (QLog.isDevelopLevel()) {
          QLog.w("MyPreviewCallback", 1, "OnPreviewData, 没有空闲的缓存");
        }
        paramCamera = paramArrayOfByte;
      }
      FrameBufMgr.a().a(paramCamera, 1);
      this.b.k.addCallbackBuffer(paramCamera);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.camera.MyPreviewCallback
 * JD-Core Version:    0.7.0.1
 */