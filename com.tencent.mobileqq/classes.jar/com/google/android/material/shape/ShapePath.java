package com.google.android.material.shape;

import android.graphics.Matrix;
import android.graphics.Path;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public class ShapePath
{
  @Deprecated
  public float a;
  private final List<ShapePath.PathOperation> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  @Deprecated
  public float b;
  private final List<ShapePath.ShadowCompatOperation> b;
  @Deprecated
  public float c;
  @Deprecated
  public float d;
  @Deprecated
  public float e;
  @Deprecated
  public float f;
  
  public ShapePath()
  {
    this.jdField_b_of_type_JavaUtilList = new ArrayList();
    a(0.0F, 0.0F);
  }
  
  private void a(float paramFloat)
  {
    if (e() == paramFloat) {
      return;
    }
    float f1 = (paramFloat - e() + 360.0F) % 360.0F;
    if (f1 > 180.0F) {
      return;
    }
    ShapePath.PathArcOperation localPathArcOperation = new ShapePath.PathArcOperation(c(), d(), c(), d());
    ShapePath.PathArcOperation.a(localPathArcOperation, e());
    ShapePath.PathArcOperation.b(localPathArcOperation, f1);
    this.jdField_b_of_type_JavaUtilList.add(new ShapePath.ArcShadowOperation(localPathArcOperation));
    f(paramFloat);
  }
  
  private void a(ShapePath.ShadowCompatOperation paramShadowCompatOperation, float paramFloat1, float paramFloat2)
  {
    a(paramFloat1);
    this.jdField_b_of_type_JavaUtilList.add(paramShadowCompatOperation);
    f(paramFloat2);
  }
  
  private void b(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  private void c(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  private void d(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  private float e()
  {
    return this.e;
  }
  
  private void e(float paramFloat)
  {
    this.d = paramFloat;
  }
  
  private float f()
  {
    return this.f;
  }
  
  private void f(float paramFloat)
  {
    this.e = paramFloat;
  }
  
  private void g(float paramFloat)
  {
    this.f = paramFloat;
  }
  
  float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  @NonNull
  ShapePath.ShadowCompatOperation a(Matrix paramMatrix)
  {
    a(f());
    paramMatrix = new Matrix(paramMatrix);
    return new ShapePath.1(this, new ArrayList(this.jdField_b_of_type_JavaUtilList), paramMatrix);
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    a(paramFloat1, paramFloat2, 270.0F, 0.0F);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    b(paramFloat1);
    c(paramFloat2);
    d(paramFloat1);
    e(paramFloat2);
    f(paramFloat3);
    g((paramFloat3 + paramFloat4) % 360.0F);
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    Object localObject = new ShapePath.PathArcOperation(paramFloat1, paramFloat2, paramFloat3, paramFloat4);
    ShapePath.PathArcOperation.a((ShapePath.PathArcOperation)localObject, paramFloat5);
    ShapePath.PathArcOperation.b((ShapePath.PathArcOperation)localObject, paramFloat6);
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    localObject = new ShapePath.ArcShadowOperation((ShapePath.PathArcOperation)localObject);
    float f1 = paramFloat5 + paramFloat6;
    int i;
    if (paramFloat6 < 0.0F) {
      i = 1;
    } else {
      i = 0;
    }
    paramFloat6 = paramFloat5;
    if (i != 0) {
      paramFloat6 = (paramFloat5 + 180.0F) % 360.0F;
    }
    if (i != 0) {
      paramFloat5 = (180.0F + f1) % 360.0F;
    } else {
      paramFloat5 = f1;
    }
    a((ShapePath.ShadowCompatOperation)localObject, paramFloat6, paramFloat5);
    paramFloat5 = (paramFloat3 - paramFloat1) / 2.0F;
    double d1 = f1;
    d((paramFloat1 + paramFloat3) * 0.5F + paramFloat5 * (float)Math.cos(Math.toRadians(d1)));
    e((paramFloat2 + paramFloat4) * 0.5F + (paramFloat4 - paramFloat2) / 2.0F * (float)Math.sin(Math.toRadians(d1)));
  }
  
  public void a(Matrix paramMatrix, Path paramPath)
  {
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      ((ShapePath.PathOperation)this.jdField_a_of_type_JavaUtilList.get(i)).a(paramMatrix, paramPath);
      i += 1;
    }
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public void b(float paramFloat1, float paramFloat2)
  {
    Object localObject = new ShapePath.PathLineOperation();
    ShapePath.PathLineOperation.a((ShapePath.PathLineOperation)localObject, paramFloat1);
    ShapePath.PathLineOperation.b((ShapePath.PathLineOperation)localObject, paramFloat2);
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    localObject = new ShapePath.LineShadowOperation((ShapePath.PathLineOperation)localObject, c(), d());
    a((ShapePath.ShadowCompatOperation)localObject, ((ShapePath.LineShadowOperation)localObject).a() + 270.0F, ((ShapePath.LineShadowOperation)localObject).a() + 270.0F);
    d(paramFloat1);
    e(paramFloat2);
  }
  
  float c()
  {
    return this.c;
  }
  
  float d()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.shape.ShapePath
 * JD-Core Version:    0.7.0.1
 */