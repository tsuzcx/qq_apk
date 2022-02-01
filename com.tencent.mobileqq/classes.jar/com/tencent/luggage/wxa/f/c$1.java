package com.tencent.luggage.wxa.f;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import androidx.annotation.NonNull;

class c$1
  extends CameraDevice.StateCallback
{
  c$1(c paramc) {}
  
  public void onClosed(@NonNull CameraDevice paramCameraDevice)
  {
    c.a(this.a, false);
    this.a.f.b();
  }
  
  public void onDisconnected(@NonNull CameraDevice paramCameraDevice)
  {
    c.a(this.a, false);
    this.a.b = null;
  }
  
  public void onError(@NonNull CameraDevice paramCameraDevice, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onError: ");
    localStringBuilder.append(paramCameraDevice.getId());
    localStringBuilder.append(" (");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(")");
    f.d("Camera2", localStringBuilder.toString());
    c.a(this.a, false);
    this.a.b = null;
  }
  
  public void onOpened(@NonNull CameraDevice paramCameraDevice)
  {
    c localc = this.a;
    localc.b = paramCameraDevice;
    localc.f.a();
    c.a(this.a, true);
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.c.1
 * JD-Core Version:    0.7.0.1
 */