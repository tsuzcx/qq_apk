package com.tencent.aelight.camera.ae.mode;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public final class AECaptureModeChangingEvent
{
  public final int a;
  public final AECaptureMode a;
  public final AECaptureMode b;
  
  public AECaptureModeChangingEvent(@Nullable AECaptureMode paramAECaptureMode1, @NonNull AECaptureMode paramAECaptureMode2, int paramInt)
  {
    this.jdField_a_of_type_ComTencentAelightCameraAeModeAECaptureMode = paramAECaptureMode1;
    this.b = paramAECaptureMode2;
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.mode.AECaptureModeChangingEvent
 * JD-Core Version:    0.7.0.1
 */