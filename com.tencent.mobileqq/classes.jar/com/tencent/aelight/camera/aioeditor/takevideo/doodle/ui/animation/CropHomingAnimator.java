package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.animation;

import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;

public class CropHomingAnimator
  extends ValueAnimator
{
  private boolean a = false;
  private CropHomingEvaluator b;
  
  public CropHomingAnimator()
  {
    setInterpolator(new AccelerateDecelerateInterpolator());
  }
  
  public void a(CropHomeing paramCropHomeing1, CropHomeing paramCropHomeing2)
  {
    setObjectValues(new Object[] { paramCropHomeing1, paramCropHomeing2 });
    this.a = CropHomeing.a(paramCropHomeing1, paramCropHomeing2);
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public void setObjectValues(Object... paramVarArgs)
  {
    super.setObjectValues(paramVarArgs);
    if (this.b == null) {
      this.b = new CropHomingEvaluator();
    }
    setEvaluator(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.animation.CropHomingAnimator
 * JD-Core Version:    0.7.0.1
 */