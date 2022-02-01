package com.tencent.av.camera;

import android.graphics.SurfaceTexture;
import com.tencent.av.config.ConfigSystemImpl;
import com.tencent.av.utils.PhoneStatusTools;

public abstract class CameraCallback
{
  protected PreviewCallbackInfo a = new PreviewCallbackInfo();
  protected final AndroidCamera b;
  protected CameraPreviewCallback c = null;
  protected final CameraCallback.PreviewAngleParam d = new CameraCallback.PreviewAngleParam();
  protected int e = -1;
  
  public CameraCallback(AndroidCamera paramAndroidCamera, CameraPreviewCallback paramCameraPreviewCallback)
  {
    this.b = paramAndroidCamera;
    this.c = paramCameraPreviewCallback;
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
      b1 = 0;
      break label41;
    }
    byte b1 = 3;
    break label41;
    label34:
    b1 = 2;
    break label41;
    label39:
    b1 = 1;
    label41:
    if (paramBoolean) {}
    for (paramInt = ConfigSystemImpl.a(this.b.j, true, false, b1, false);; paramInt = ConfigSystemImpl.b(this.b.j, true, false, b1, false)) {
      return paramInt * 90;
    }
  }
  
  public abstract void a(long paramLong, SurfaceTexture paramSurfaceTexture);
  
  public void a(CameraCallback.PreviewAngleParam paramPreviewAngleParam)
  {
    int m = this.b.h();
    boolean bool = this.b.y;
    int i = 0;
    int j;
    if (bool) {
      j = 0;
    } else {
      j = this.b.d() * 90;
    }
    int n = this.b.i();
    if (this.b.l == 1) {
      i = (360 - (m + j) % 360) % 360;
    } else if (this.b.l == 2) {
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
        if (this.b.l != 1) {
          break label275;
        }
        k = i;
        if (!this.b.w) {
          break label275;
        }
      }
      else
      {
        k = i;
        if (this.b.l != 1) {
          break label275;
        }
        k = i;
        if (this.b.w) {
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
      if (this.b.l != 1) {
        break label275;
      }
      if (a())
      {
        k = i;
        if (!this.b.x) {
          break label275;
        }
      }
    }
    int k = i + 180;
    label275:
    if (this.b.l == 1)
    {
      if (this.b.u > 0)
      {
        i = 360 - this.b.u + k;
        break label371;
      }
      i = a(n, this.b.y);
    }
    else if (this.b.v > 0)
    {
      i = this.b.v;
    }
    else
    {
      i = b(n, this.b.y);
    }
    i += k;
    label371:
    i = i % 360 / 90;
    if (paramPreviewAngleParam != null)
    {
      paramPreviewAngleParam.a = i;
      paramPreviewAngleParam.b = n;
      paramPreviewAngleParam.c = m;
      paramPreviewAngleParam.d = j;
    }
  }
  
  public boolean a()
  {
    int i = this.e;
    boolean bool = false;
    if (i == -1) {
      if (PhoneStatusTools.a(this.b.j, "ro.qq.orientation").equalsIgnoreCase("ZTE")) {
        this.e = 1;
      } else {
        this.e = 0;
      }
    }
    if (this.e == 1) {
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
      b1 = 0;
      break label41;
    }
    byte b1 = 3;
    break label41;
    label34:
    b1 = 2;
    break label41;
    label39:
    b1 = 1;
    label41:
    if (paramBoolean) {}
    for (paramInt = ConfigSystemImpl.a(this.b.j, false, false, b1, false);; paramInt = ConfigSystemImpl.b(this.b.j, false, false, b1, false)) {
      return paramInt * 90;
    }
  }
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.camera.CameraCallback
 * JD-Core Version:    0.7.0.1
 */