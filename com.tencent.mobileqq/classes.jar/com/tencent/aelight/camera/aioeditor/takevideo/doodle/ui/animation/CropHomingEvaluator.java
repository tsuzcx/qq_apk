package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.animation;

import android.animation.TypeEvaluator;

public class CropHomingEvaluator
  implements TypeEvaluator<CropHomeing>
{
  private CropHomeing a;
  
  public CropHomeing a(float paramFloat, CropHomeing paramCropHomeing1, CropHomeing paramCropHomeing2)
  {
    float f1 = paramCropHomeing1.a + (paramCropHomeing2.a - paramCropHomeing1.a) * paramFloat;
    float f2 = paramCropHomeing1.b + (paramCropHomeing2.b - paramCropHomeing1.b) * paramFloat;
    float f3 = paramCropHomeing1.c + (paramCropHomeing2.c - paramCropHomeing1.c) * paramFloat;
    paramFloat = paramCropHomeing1.d + paramFloat * (paramCropHomeing2.d - paramCropHomeing1.d);
    paramCropHomeing1 = this.a;
    if (paramCropHomeing1 == null) {
      this.a = new CropHomeing(f1, f2, f3, paramFloat);
    } else {
      paramCropHomeing1.a(f1, f2, f3, paramFloat);
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.animation.CropHomingEvaluator
 * JD-Core Version:    0.7.0.1
 */