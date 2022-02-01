package com.tencent.aelight.camera.ae.album.nocropper;

import com.tencent.tavcut.bean.CropConfig;

public class CropResult
{
  public final CropInfo a;
  public final CropState a;
  public final CropConfig a;
  
  private CropResult(CropConfig paramCropConfig, CropState paramCropState)
  {
    this.jdField_a_of_type_ComTencentTavcutBeanCropConfig = paramCropConfig;
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperCropState = paramCropState;
    this.jdField_a_of_type_ComTencentAelightCameraAeAlbumNocropperCropInfo = null;
  }
  
  public static CropResult a()
  {
    return new CropResult(null, CropState.d);
  }
  
  public static CropResult a(CropInfo paramCropInfo)
  {
    return new CropResult(null, CropState.b);
  }
  
  public static CropResult a(CropConfig paramCropConfig)
  {
    return new CropResult(paramCropConfig, CropState.b);
  }
  
  public static CropResult b()
  {
    return new CropResult(null, CropState.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.nocropper.CropResult
 * JD-Core Version:    0.7.0.1
 */