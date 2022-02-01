package com.tencent.luggage.wxa.f;

import android.hardware.camera2.CameraManager.AvailabilityCallback;
import androidx.annotation.NonNull;
import java.util.Set;

class c$5
  extends CameraManager.AvailabilityCallback
{
  c$5(c paramc) {}
  
  public void onCameraAvailable(@NonNull String paramString)
  {
    super.onCameraAvailable(paramString);
    this.a.e.add(paramString);
  }
  
  public void onCameraUnavailable(@NonNull String paramString)
  {
    super.onCameraUnavailable(paramString);
    this.a.e.remove(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.c.5
 * JD-Core Version:    0.7.0.1
 */