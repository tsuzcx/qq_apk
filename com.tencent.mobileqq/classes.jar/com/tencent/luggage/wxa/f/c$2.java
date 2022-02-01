package com.tencent.luggage.wxa.f;

import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import androidx.annotation.NonNull;

class c$2
  extends CameraCaptureSession.StateCallback
{
  c$2(c paramc) {}
  
  public void onClosed(@NonNull CameraCaptureSession paramCameraCaptureSession)
  {
    if ((this.a.c != null) && (this.a.c.equals(paramCameraCaptureSession))) {
      this.a.c = null;
    }
  }
  
  public void onConfigureFailed(@NonNull CameraCaptureSession paramCameraCaptureSession)
  {
    f.d("Camera2", "Failed to configure capture session.");
    if (!c.a(this.a))
    {
      c.b(this.a);
      return;
    }
    f.c("Camera2", "in safe open mode already, exit");
  }
  
  public void onConfigured(@NonNull CameraCaptureSession paramCameraCaptureSession)
  {
    if (this.a.b == null) {
      return;
    }
    c localc = this.a;
    localc.c = paramCameraCaptureSession;
    c.a(localc, (Rect)localc.d.get(CaptureRequest.SCALER_CROP_REGION));
    this.a.E();
    this.a.F();
    this.a.G();
    this.a.I();
    this.a.H();
    try
    {
      this.a.c.setRepeatingRequest(this.a.d.build(), this.a.a, null);
      return;
    }
    catch (IllegalStateException paramCameraCaptureSession)
    {
      f.c("Camera2", "Failed to start camera preview.", paramCameraCaptureSession);
      return;
    }
    catch (CameraAccessException paramCameraCaptureSession)
    {
      f.c("Camera2", "Failed to start camera preview because it couldn't access camera", paramCameraCaptureSession);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.c.2
 * JD-Core Version:    0.7.0.1
 */