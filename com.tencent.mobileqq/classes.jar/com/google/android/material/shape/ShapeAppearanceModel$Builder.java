package com.google.android.material.shape;

import androidx.annotation.Dimension;
import androidx.annotation.NonNull;

public final class ShapeAppearanceModel$Builder
{
  @NonNull
  private CornerSize jdField_a_of_type_ComGoogleAndroidMaterialShapeCornerSize = new AbsoluteCornerSize(0.0F);
  @NonNull
  private CornerTreatment jdField_a_of_type_ComGoogleAndroidMaterialShapeCornerTreatment = MaterialShapeUtils.a();
  @NonNull
  private EdgeTreatment jdField_a_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment = MaterialShapeUtils.a();
  @NonNull
  private CornerSize jdField_b_of_type_ComGoogleAndroidMaterialShapeCornerSize = new AbsoluteCornerSize(0.0F);
  @NonNull
  private CornerTreatment jdField_b_of_type_ComGoogleAndroidMaterialShapeCornerTreatment = MaterialShapeUtils.a();
  @NonNull
  private EdgeTreatment jdField_b_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment = MaterialShapeUtils.a();
  @NonNull
  private CornerSize jdField_c_of_type_ComGoogleAndroidMaterialShapeCornerSize = new AbsoluteCornerSize(0.0F);
  @NonNull
  private CornerTreatment jdField_c_of_type_ComGoogleAndroidMaterialShapeCornerTreatment = MaterialShapeUtils.a();
  @NonNull
  private EdgeTreatment jdField_c_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment = MaterialShapeUtils.a();
  @NonNull
  private CornerSize jdField_d_of_type_ComGoogleAndroidMaterialShapeCornerSize = new AbsoluteCornerSize(0.0F);
  @NonNull
  private CornerTreatment jdField_d_of_type_ComGoogleAndroidMaterialShapeCornerTreatment = MaterialShapeUtils.a();
  @NonNull
  private EdgeTreatment jdField_d_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment = MaterialShapeUtils.a();
  
  public ShapeAppearanceModel$Builder() {}
  
  public ShapeAppearanceModel$Builder(@NonNull ShapeAppearanceModel paramShapeAppearanceModel)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeCornerTreatment = paramShapeAppearanceModel.jdField_a_of_type_ComGoogleAndroidMaterialShapeCornerTreatment;
    this.jdField_b_of_type_ComGoogleAndroidMaterialShapeCornerTreatment = paramShapeAppearanceModel.jdField_b_of_type_ComGoogleAndroidMaterialShapeCornerTreatment;
    this.jdField_c_of_type_ComGoogleAndroidMaterialShapeCornerTreatment = paramShapeAppearanceModel.jdField_c_of_type_ComGoogleAndroidMaterialShapeCornerTreatment;
    this.jdField_d_of_type_ComGoogleAndroidMaterialShapeCornerTreatment = paramShapeAppearanceModel.jdField_d_of_type_ComGoogleAndroidMaterialShapeCornerTreatment;
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeCornerSize = paramShapeAppearanceModel.jdField_b_of_type_ComGoogleAndroidMaterialShapeCornerSize;
    this.jdField_b_of_type_ComGoogleAndroidMaterialShapeCornerSize = paramShapeAppearanceModel.jdField_c_of_type_ComGoogleAndroidMaterialShapeCornerSize;
    this.jdField_c_of_type_ComGoogleAndroidMaterialShapeCornerSize = paramShapeAppearanceModel.jdField_d_of_type_ComGoogleAndroidMaterialShapeCornerSize;
    this.jdField_d_of_type_ComGoogleAndroidMaterialShapeCornerSize = paramShapeAppearanceModel.e;
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment = paramShapeAppearanceModel.jdField_a_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment;
    this.jdField_b_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment = paramShapeAppearanceModel.jdField_b_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment;
    this.jdField_c_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment = paramShapeAppearanceModel.jdField_c_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment;
    this.jdField_d_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment = paramShapeAppearanceModel.jdField_d_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment;
  }
  
  private static float a(CornerTreatment paramCornerTreatment)
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
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment = paramEdgeTreatment;
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
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeCornerSize = new AbsoluteCornerSize(paramFloat);
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
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeCornerSize = paramCornerSize;
    return this;
  }
  
  @NonNull
  public Builder b(@NonNull CornerTreatment paramCornerTreatment)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialShapeCornerTreatment = paramCornerTreatment;
    float f = a(paramCornerTreatment);
    if (f != -1.0F) {
      b(f);
    }
    return this;
  }
  
  @NonNull
  public Builder b(@NonNull EdgeTreatment paramEdgeTreatment)
  {
    this.jdField_c_of_type_ComGoogleAndroidMaterialShapeEdgeTreatment = paramEdgeTreatment;
    return this;
  }
  
  @NonNull
  public Builder c(@Dimension float paramFloat)
  {
    this.jdField_b_of_type_ComGoogleAndroidMaterialShapeCornerSize = new AbsoluteCornerSize(paramFloat);
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
    this.jdField_b_of_type_ComGoogleAndroidMaterialShapeCornerSize = paramCornerSize;
    return this;
  }
  
  @NonNull
  public Builder c(@NonNull CornerTreatment paramCornerTreatment)
  {
    this.jdField_b_of_type_ComGoogleAndroidMaterialShapeCornerTreatment = paramCornerTreatment;
    float f = a(paramCornerTreatment);
    if (f != -1.0F) {
      c(f);
    }
    return this;
  }
  
  @NonNull
  public Builder d(@Dimension float paramFloat)
  {
    this.jdField_c_of_type_ComGoogleAndroidMaterialShapeCornerSize = new AbsoluteCornerSize(paramFloat);
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
    this.jdField_c_of_type_ComGoogleAndroidMaterialShapeCornerSize = paramCornerSize;
    return this;
  }
  
  @NonNull
  public Builder d(@NonNull CornerTreatment paramCornerTreatment)
  {
    this.jdField_c_of_type_ComGoogleAndroidMaterialShapeCornerTreatment = paramCornerTreatment;
    float f = a(paramCornerTreatment);
    if (f != -1.0F) {
      d(f);
    }
    return this;
  }
  
  @NonNull
  public Builder e(@Dimension float paramFloat)
  {
    this.jdField_d_of_type_ComGoogleAndroidMaterialShapeCornerSize = new AbsoluteCornerSize(paramFloat);
    return this;
  }
  
  @NonNull
  public Builder e(@NonNull CornerSize paramCornerSize)
  {
    this.jdField_d_of_type_ComGoogleAndroidMaterialShapeCornerSize = paramCornerSize;
    return this;
  }
  
  @NonNull
  public Builder e(@NonNull CornerTreatment paramCornerTreatment)
  {
    this.jdField_d_of_type_ComGoogleAndroidMaterialShapeCornerTreatment = paramCornerTreatment;
    float f = a(paramCornerTreatment);
    if (f != -1.0F) {
      e(f);
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.shape.ShapeAppearanceModel.Builder
 * JD-Core Version:    0.7.0.1
 */