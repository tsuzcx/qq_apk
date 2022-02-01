package com.google.android.material.bottomappbar;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

public class BottomAppBarTopEdgeTreatment
  extends EdgeTreatment
  implements Cloneable
{
  private float a;
  private float b;
  private float c;
  private float d;
  private float e;
  
  public BottomAppBarTopEdgeTreatment(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.b = paramFloat1;
    this.a = paramFloat2;
    c(paramFloat3);
    this.e = 0.0F;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public float a()
  {
    return this.c;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void a(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, @NonNull ShapePath paramShapePath)
  {
    float f1 = this.c;
    if (f1 == 0.0F)
    {
      paramShapePath.b(paramFloat1, 0.0F);
      return;
    }
    f1 = (this.b * 2.0F + f1) / 2.0F;
    float f2 = paramFloat3 * this.a;
    paramFloat2 += this.e;
    paramFloat3 = this.d * paramFloat3 + (1.0F - paramFloat3) * f1;
    if (paramFloat3 / f1 >= 1.0F)
    {
      paramShapePath.b(paramFloat1, 0.0F);
      return;
    }
    float f3 = f1 + f2;
    float f5 = paramFloat3 + f2;
    float f6 = (float)Math.sqrt(f3 * f3 - f5 * f5);
    f3 = paramFloat2 - f6;
    float f4 = paramFloat2 + f6;
    f5 = (float)Math.toDegrees(Math.atan(f6 / f5));
    f6 = 90.0F - f5;
    paramShapePath.b(f3, 0.0F);
    float f7 = f2 * 2.0F;
    paramShapePath.a(f3 - f2, 0.0F, f3 + f2, f7, 270.0F, f5);
    paramShapePath.a(paramFloat2 - f1, -f1 - paramFloat3, paramFloat2 + f1, f1 - paramFloat3, 180.0F - f6, f6 * 2.0F - 180.0F);
    paramShapePath.a(f4 - f2, 0.0F, f4 + f2, f7, 270.0F - f5, f5);
    paramShapePath.b(paramFloat1, 0.0F);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public float b()
  {
    return this.e;
  }
  
  void b(float paramFloat)
  {
    this.e = paramFloat;
  }
  
  float c()
  {
    return this.d;
  }
  
  void c(@FloatRange(from=0.0D) float paramFloat)
  {
    if (paramFloat >= 0.0F)
    {
      this.d = paramFloat;
      return;
    }
    throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
  }
  
  float d()
  {
    return this.b;
  }
  
  void d(float paramFloat)
  {
    this.b = paramFloat;
  }
  
  float e()
  {
    return this.a;
  }
  
  void e(float paramFloat)
  {
    this.a = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment
 * JD-Core Version:    0.7.0.1
 */