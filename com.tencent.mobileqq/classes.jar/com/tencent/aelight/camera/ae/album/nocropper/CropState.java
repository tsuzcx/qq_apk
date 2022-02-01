package com.tencent.aelight.camera.ae.album.nocropper;

import android.support.annotation.NonNull;

public class CropState
{
  public static final CropState a;
  public static final CropState[] a;
  public static final CropState b;
  public static final CropState c;
  public static final CropState d;
  public final String a;
  
  static
  {
    jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperCropState = new CropState("STARTED");
    b = new CropState("SUCCESS");
    c = new CropState("ERROR");
    d = new CropState("FAILURE_GESTURE_IN_PROCESS");
    jdField_a_of_type_ArrayOfComTencentAelightCameraAeAlbumNocropperCropState = new CropState[] { jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperCropState, b, c, d };
  }
  
  private CropState(@NonNull String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.nocropper.CropState
 * JD-Core Version:    0.7.0.1
 */