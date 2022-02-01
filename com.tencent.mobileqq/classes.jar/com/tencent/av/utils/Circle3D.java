package com.tencent.av.utils;

import android.annotation.SuppressLint;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class Circle3D
  extends Animation
{
  float jdField_a_of_type_Float;
  private Camera jdField_a_of_type_AndroidGraphicsCamera;
  private final boolean jdField_a_of_type_Boolean;
  float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean;
  float c;
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private float i;
  private final float j;
  private float k;
  private float l;
  
  float a(float paramFloat)
  {
    return (float)Math.sqrt(this.jdField_a_of_type_Float * this.jdField_a_of_type_Float - (paramFloat - this.jdField_b_of_type_Float) * (paramFloat - this.jdField_b_of_type_Float)) + this.c;
  }
  
  @SuppressLint({"NewApi"})
  protected void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f3 = this.h;
    float f1 = this.d;
    float f2 = this.e;
    Matrix localMatrix = paramTransformation.getMatrix();
    this.jdField_a_of_type_AndroidGraphicsCamera.save();
    paramTransformation.setAlpha(f3 + (this.i - f3) * paramFloat);
    f3 = this.k;
    f3 = this.k + (this.l - this.k) * paramFloat;
    float f4 = a(f3);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_AndroidGraphicsCamera.rotateY(f1 + (f2 - f1) * paramFloat);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsCamera.getMatrix(localMatrix);
      this.jdField_a_of_type_AndroidGraphicsCamera.restore();
      localMatrix.preTranslate(-this.f, -this.g);
      localMatrix.postTranslate(this.f, this.g);
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        f1 = -a(f3);
        this.jdField_a_of_type_AndroidGraphicsCamera.translate(f1, f3, this.j * (1.0F - paramFloat));
      }
      else
      {
        this.jdField_a_of_type_AndroidGraphicsCamera.translate(f4, f3, this.j * paramFloat);
      }
    }
  }
  
  public void initialize(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.initialize(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_AndroidGraphicsCamera = new Camera();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.utils.Circle3D
 * JD-Core Version:    0.7.0.1
 */