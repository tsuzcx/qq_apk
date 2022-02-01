package com.tencent.aelight.camera.ae.album.nocropper;

import android.support.annotation.NonNull;

public class CropState
{
  public static final CropState a = new CropState("STARTED");
  public static final CropState b = new CropState("SUCCESS");
  public static final CropState c = new CropState("ERROR");
  public static final CropState d = new CropState("FAILURE_GESTURE_IN_PROCESS");
  public static final CropState[] e = { a, b, c, d };
  public final String f;
  
  private CropState(@NonNull String paramString)
  {
    this.f = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.nocropper.CropState
 * JD-Core Version:    0.7.0.1
 */