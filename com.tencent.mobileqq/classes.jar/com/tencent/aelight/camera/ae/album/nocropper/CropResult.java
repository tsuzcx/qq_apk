package com.tencent.aelight.camera.ae.album.nocropper;

import com.tencent.qcircle.tavcut.bean.CropConfig;

public class CropResult
{
  public final CropConfig a;
  public final CropInfo b;
  public final CropState c;
  
  private CropResult(CropConfig paramCropConfig, CropState paramCropState)
  {
    this.a = paramCropConfig;
    this.c = paramCropState;
    this.b = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.album.nocropper.CropResult
 * JD-Core Version:    0.7.0.1
 */