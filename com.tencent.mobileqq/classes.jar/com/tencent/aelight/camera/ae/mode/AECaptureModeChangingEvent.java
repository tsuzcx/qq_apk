package com.tencent.aelight.camera.ae.mode;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public final class AECaptureModeChangingEvent
{
  public final AECaptureMode a;
  public final AECaptureMode b;
  public final int c;
  
  public AECaptureModeChangingEvent(@Nullable AECaptureMode paramAECaptureMode1, @NonNull AECaptureMode paramAECaptureMode2, int paramInt)
  {
    this.a = paramAECaptureMode1;
    this.b = paramAECaptureMode2;
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent
 * JD-Core Version:    0.7.0.1
 */