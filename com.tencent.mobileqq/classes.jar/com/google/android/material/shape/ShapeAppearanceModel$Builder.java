package com.google.android.material.shape;

import androidx.annotation.Dimension;
import androidx.annotation.NonNull;

public final class ShapeAppearanceModel$Builder
{
  @NonNull
  private CornerTreatment a = MaterialShapeUtils.a();
  @NonNull
  private CornerTreatment b = MaterialShapeUtils.a();
  @NonNull
  private CornerTreatment c = MaterialShapeUtils.a();
  @NonNull
  private CornerTreatment d = MaterialShapeUtils.a();
  @NonNull
  private CornerSize e = new AbsoluteCornerSize(0.0F);
  @NonNull
  private CornerSize f = new AbsoluteCornerSize(0.0F);
  @NonNull
  private CornerSize g = new AbsoluteCornerSize(0.0F);
  @NonNull
  private CornerSize h = new AbsoluteCornerSize(0.0F);
  @NonNull
  private EdgeTreatment i = MaterialShapeUtils.b();
  @NonNull
  private EdgeTreatment j = MaterialShapeUtils.b();
  @NonNull
  private EdgeTreatment k = MaterialShapeUtils.b();
  @NonNull
  private EdgeTreatment l = MaterialShapeUtils.b();
  
  public ShapeAppearanceModel$Builder() {}
  
  public ShapeAppearanceModel$Builder(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.a = paramShapeAppearanceModel.b;
    this.b = paramShapeAppearanceModel.c;
    this.c = paramShapeAppearanceModel.d;
    this.d = paramShapeAppearanceModel.e;
    this.e = paramShapeAppearanceModel.f;
    this.f = paramShapeAppearanceModel.g;
    this.g = paramShapeAppearanceModel.h;
    this.h = paramShapeAppearanceModel.i;
    this.i = paramShapeAppearanceModel.j;
    this.j = paramShapeAppearanceModel.k;
    this.k = paramShapeAppearanceModel.l;
    this.l = paramShapeAppearanceModel.m;
  }
  
  private static float f(CornerTreatment paramCornerTreatment)
  {
    if ((paramCornerTreatment instanceof RoundedCornerTreatment)) {
      return ((RoundedCornerTreatment)paramCornerTreatment).a;
    }
    if ((paramCornerTreatment instanceof CutCornerTreatment)) {
      return ((CutCornerTreatment)paramCornerTreatment).a;
    }
    return -1.0F;
  }
  
  @NonNull
  public Builder a(@Dimension float paramFloat)
  {
    return b(paramFloat).c(paramFloat).d(paramFloat).e(paramFloat);
  }
  
  @NonNull
  public Builder a(int paramInt, @Dimension float paramFloat)
  {
    return a(MaterialShapeUtils.a(paramInt)).a(paramFloat);
  }
  
  @NonNull
  public Builder a(int paramInt, @NonNull CornerSize paramCornerSize)
  {
    return b(MaterialShapeUtils.a(paramInt)).b(paramCornerSize);
  }
  
  @NonNull
  public Builder a(@NonNull CornerSize paramCornerSize)
  {
    return b(paramCornerSize).c(paramCornerSize).d(paramCornerSize).e(paramCornerSize);
  }
  
  @NonNull
  public Builder a(@NonNull CornerTreatment paramCornerTreatment)
  {
    return b(paramCornerTreatment).c(paramCornerTreatment).d(paramCornerTreatment).e(paramCornerTreatment);
  }
  
  @NonNull
  public Builder a(@NonNull EdgeTreatment paramEdgeTreatment)
  {
    this.i = paramEdgeTreatment;
    return this;
  }
  
  @NonNull
  public ShapeAppearanceModel a()
  {
    return new ShapeAppearanceModel(this, null);
  }
  
  @NonNull
  public Builder b(@Dimension float paramFloat)
  {
    this.e = new AbsoluteCornerSize(paramFloat);
    return this;
  }
  
  @NonNull
  public Builder b(int paramInt, @NonNull CornerSize paramCornerSize)
  {
    return c(MaterialShapeUtils.a(paramInt)).c(paramCornerSize);
  }
  
  @NonNull
  public Builder b(@NonNull CornerSize paramCornerSize)
  {
    this.e = paramCornerSize;
    return this;
  }
  
  @NonNull
  public Builder b(@NonNull CornerTreatment paramCornerTreatment)
  {
    this.a = paramCornerTreatment;
    float f1 = f(paramCornerTreatment);
    if (f1 != -1.0F) {
      b(f1);
    }
    return this;
  }
  
  @NonNull
  public Builder b(@NonNull EdgeTreatment paramEdgeTreatment)
  {
    this.k = paramEdgeTreatment;
    return this;
  }
  
  @NonNull
  public Builder c(@Dimension float paramFloat)
  {
    this.f = new AbsoluteCornerSize(paramFloat);
    return this;
  }
  
  @NonNull
  public Builder c(int paramInt, @NonNull CornerSize paramCornerSize)
  {
    return d(MaterialShapeUtils.a(paramInt)).d(paramCornerSize);
  }
  
  @NonNull
  public Builder c(@NonNull CornerSize paramCornerSize)
  {
    this.f = paramCornerSize;
    return this;
  }
  
  @NonNull
  public Builder c(@NonNull CornerTreatment paramCornerTreatment)
  {
    this.b = paramCornerTreatment;
    float f1 = f(paramCornerTreatment);
    if (f1 != -1.0F) {
      c(f1);
    }
    return this;
  }
  
  @NonNull
  public Builder d(@Dimension float paramFloat)
  {
    this.g = new AbsoluteCornerSize(paramFloat);
    return this;
  }
  
  @NonNull
  public Builder d(int paramInt, @NonNull CornerSize paramCornerSize)
  {
    return e(MaterialShapeUtils.a(paramInt)).e(paramCornerSize);
  }
  
  @NonNull
  public Builder d(@NonNull CornerSize paramCornerSize)
  {
    this.g = paramCornerSize;
    return this;
  }
  
  @NonNull
  public Builder d(@NonNull CornerTreatment paramCornerTreatment)
  {
    this.c = paramCornerTreatment;
    float f1 = f(paramCornerTreatment);
    if (f1 != -1.0F) {
      d(f1);
    }
    return this;
  }
  
  @NonNull
  public Builder e(@Dimension float paramFloat)
  {
    this.h = new AbsoluteCornerSize(paramFloat);
    return this;
  }
  
  @NonNull
  public Builder e(@NonNull CornerSize paramCornerSize)
  {
    this.h = paramCornerSize;
    return this;
  }
  
  @NonNull
  public Builder e(@NonNull CornerTreatment paramCornerTreatment)
  {
    this.d = paramCornerTreatment;
    float f1 = f(paramCornerTreatment);
    if (f1 != -1.0F) {
      e(f1);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.shape.ShapeAppearanceModel.Builder
 * JD-Core Version:    0.7.0.1
 */