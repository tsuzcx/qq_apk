package com.tencent.mobileqq.arcard.ARWordingBless;

import android.graphics.Bitmap;
import android.graphics.Shader;
import android.graphics.Typeface;

public class RubberStampConfig$RubberStampConfigBuilder
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Shader jdField_a_of_type_AndroidGraphicsShader;
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface;
  private String jdField_a_of_type_JavaLangString;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int = 40;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private String jdField_b_of_type_JavaLangString;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int = -16777216;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private int e;
  private int f = 255;
  private int g;
  private int h;
  private int i = -1;
  private int j;
  private int k;
  private int l = 1;
  
  public RubberStampConfigBuilder a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public RubberStampConfigBuilder a(int paramInt1, int paramInt2)
  {
    this.j = paramInt1;
    this.k = paramInt2;
    return this;
  }
  
  public RubberStampConfigBuilder a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt1 != 0) {
      throw new IllegalArgumentException("This constructor can only be used when the rubberStampPosition is RubberStamp.CUSTOM");
    }
    this.e = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
    return this;
  }
  
  public RubberStampConfigBuilder a(Bitmap paramBitmap)
  {
    this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap;
    return this;
  }
  
  public RubberStampConfigBuilder a(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
    return this;
  }
  
  public RubberStampConfigBuilder a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public RubberStampConfig a()
  {
    return new RubberStampConfig(this, null);
  }
  
  public RubberStampConfigBuilder b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public RubberStampConfigBuilder c(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.arcard.ARWordingBless.RubberStampConfig.RubberStampConfigBuilder
 * JD-Core Version:    0.7.0.1
 */