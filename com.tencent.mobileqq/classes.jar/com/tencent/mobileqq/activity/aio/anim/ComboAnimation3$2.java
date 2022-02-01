package com.tencent.mobileqq.activity.aio.anim;

import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

class ComboAnimation3$2
  extends Animation
{
  private float b = 0.0F;
  private float c = 0.0F;
  
  ComboAnimation3$2(ComboAnimation3 paramComboAnimation3) {}
  
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f1 = this.a.e;
    float f2 = 1.0F;
    if (paramFloat < f1 * 11.0F) {
      f1 = paramFloat / (this.a.e * 11.0F);
    } else if (paramFloat < this.a.e * 20.0F) {
      f1 = 1.0F;
    } else {
      f1 = 1.0F - (paramFloat - this.a.e * 20.0F) / (this.a.e * 4.0F);
    }
    if (paramFloat < this.a.e * 6.0F) {
      f2 = 1.0F + paramFloat / (this.a.e * 6.0F) * 0.5F;
    } else if (paramFloat < this.a.e * 11.0F) {
      f2 = 1.5F - (paramFloat - this.a.e * 6.0F) * 0.5F / (this.a.e * 5.0F);
    }
    paramTransformation.setAlpha(f1);
    paramTransformation.getMatrix().setScale(f2, f2, this.b, this.c);
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.b = (paramInt1 * 0.5F);
    this.c = (paramInt2 * 0.5F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.ComboAnimation3.2
 * JD-Core Version:    0.7.0.1
 */