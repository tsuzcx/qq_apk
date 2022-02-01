package com.tencent.luggage.wxa.f;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.annotation.NonNull;

abstract class c$a
  extends CameraCaptureSession.CaptureCallback
{
  private int a;
  
  private void a(@NonNull CaptureResult paramCaptureResult)
  {
    int i = this.a;
    if (i != 1)
    {
      if (i != 3)
      {
        if (i != 4) {
          return;
        }
        paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        if ((paramCaptureResult == null) || (paramCaptureResult.intValue() != 5))
        {
          a(5);
          b();
        }
      }
      else
      {
        paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        if ((paramCaptureResult == null) || (paramCaptureResult.intValue() == 5) || (paramCaptureResult.intValue() == 4) || (paramCaptureResult.intValue() == 2)) {
          a(4);
        }
      }
    }
    else
    {
      Integer localInteger = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
      if (localInteger == null) {
        return;
      }
      if ((localInteger.intValue() == 4) || (localInteger.intValue() == 5))
      {
        paramCaptureResult = (Integer)paramCaptureResult.get(CaptureResult.CONTROL_AE_STATE);
        if ((paramCaptureResult != null) && (paramCaptureResult.intValue() != 2))
        {
          a(2);
          a();
          return;
        }
        a(5);
        b();
      }
    }
  }
  
  public abstract void a();
  
  void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public abstract void b();
  
  public void onCaptureCompleted(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull TotalCaptureResult paramTotalCaptureResult)
  {
    a(paramTotalCaptureResult);
  }
  
  public void onCaptureProgressed(@NonNull CameraCaptureSession paramCameraCaptureSession, @NonNull CaptureRequest paramCaptureRequest, @NonNull CaptureResult paramCaptureResult)
  {
    a(paramCaptureResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.c.a
 * JD-Core Version:    0.7.0.1
 */