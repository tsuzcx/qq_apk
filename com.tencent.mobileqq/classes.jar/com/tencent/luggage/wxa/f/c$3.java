package com.tencent.luggage.wxa.f;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;

class c$3
  extends c.a
{
  c$3(c paramc) {}
  
  public void a()
  {
    this.a.d.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(1));
    a(3);
    try
    {
      if (this.a.c != null) {
        this.a.c.capture(this.a.d.build(), this, null);
      }
      this.a.d.set(CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER, Integer.valueOf(0));
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}catch (IllegalStateException localIllegalStateException) {}catch (CameraAccessException localCameraAccessException) {}
    f.c("Camera2", "Failed to run precapture sequence.", localCameraAccessException);
  }
  
  public void b()
  {
    this.a.J();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.c.3
 * JD-Core Version:    0.7.0.1
 */