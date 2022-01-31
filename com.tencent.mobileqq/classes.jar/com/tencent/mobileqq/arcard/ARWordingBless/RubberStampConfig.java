package com.tencent.mobileqq.arcard.ARWordingBless;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.util.Pair;

public class RubberStampConfig
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Shader jdField_a_of_type_AndroidGraphicsShader;
  private Typeface jdField_a_of_type_AndroidGraphicsTypeface = Typeface.DEFAULT;
  private String jdField_a_of_type_JavaLangString;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private String jdField_b_of_type_JavaLangString;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  
  private RubberStampConfig(RubberStampConfig.RubberStampConfigBuilder paramRubberStampConfigBuilder)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = RubberStampConfig.RubberStampConfigBuilder.a(paramRubberStampConfigBuilder);
    this.jdField_a_of_type_Int = RubberStampConfig.RubberStampConfigBuilder.a(paramRubberStampConfigBuilder);
    this.jdField_b_of_type_Int = RubberStampConfig.RubberStampConfigBuilder.b(paramRubberStampConfigBuilder);
    this.jdField_c_of_type_Int = RubberStampConfig.RubberStampConfigBuilder.c(paramRubberStampConfigBuilder);
    this.jdField_d_of_type_Int = RubberStampConfig.RubberStampConfigBuilder.d(paramRubberStampConfigBuilder);
    this.jdField_a_of_type_JavaLangString = RubberStampConfig.RubberStampConfigBuilder.a(paramRubberStampConfigBuilder);
    this.e = RubberStampConfig.RubberStampConfigBuilder.e(paramRubberStampConfigBuilder);
    this.jdField_b_of_type_JavaLangString = RubberStampConfig.RubberStampConfigBuilder.b(paramRubberStampConfigBuilder);
    this.jdField_b_of_type_AndroidGraphicsBitmap = RubberStampConfig.RubberStampConfigBuilder.b(paramRubberStampConfigBuilder);
    this.f = RubberStampConfig.RubberStampConfigBuilder.f(paramRubberStampConfigBuilder);
    this.jdField_a_of_type_AndroidGraphicsShader = RubberStampConfig.RubberStampConfigBuilder.a(paramRubberStampConfigBuilder);
    this.jdField_a_of_type_Float = RubberStampConfig.RubberStampConfigBuilder.a(paramRubberStampConfigBuilder);
    this.g = RubberStampConfig.RubberStampConfigBuilder.g(paramRubberStampConfigBuilder);
    this.h = RubberStampConfig.RubberStampConfigBuilder.h(paramRubberStampConfigBuilder);
    this.i = RubberStampConfig.RubberStampConfigBuilder.i(paramRubberStampConfigBuilder);
    this.jdField_c_of_type_Float = RubberStampConfig.RubberStampConfigBuilder.b(paramRubberStampConfigBuilder);
    this.jdField_d_of_type_Float = RubberStampConfig.RubberStampConfigBuilder.c(paramRubberStampConfigBuilder);
    this.jdField_b_of_type_Float = RubberStampConfig.RubberStampConfigBuilder.d(paramRubberStampConfigBuilder);
    this.j = RubberStampConfig.RubberStampConfigBuilder.j(paramRubberStampConfigBuilder);
    this.k = RubberStampConfig.RubberStampConfigBuilder.k(paramRubberStampConfigBuilder);
    this.jdField_a_of_type_AndroidGraphicsTypeface = RubberStampConfig.RubberStampConfigBuilder.a(paramRubberStampConfigBuilder);
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null)
    {
      this.l = this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth();
      this.m = this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight();
      return;
    }
    a();
  }
  
  public static Pair a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    switch (paramInt1)
    {
    default: 
      return new Pair(Integer.valueOf(paramInt2 / 2 - paramInt4 / 2), Integer.valueOf(paramInt3 / 2 + paramInt5 / 2));
    case 1: 
      return new Pair(Integer.valueOf(0), Integer.valueOf(paramInt5));
    case 2: 
      return new Pair(Integer.valueOf(paramInt2 / 2 - paramInt4 / 2), Integer.valueOf(paramInt5));
    case 3: 
      return new Pair(Integer.valueOf(paramInt2 - paramInt4), Integer.valueOf(paramInt5));
    case 4: 
      return new Pair(Integer.valueOf(0), Integer.valueOf(paramInt3 / 2 + paramInt5 / 2));
    case 5: 
      return new Pair(Integer.valueOf(paramInt2 / 2 - paramInt4 / 2), Integer.valueOf(paramInt3 / 2 + paramInt5 / 2));
    case 6: 
      return new Pair(Integer.valueOf(paramInt2 - paramInt4), Integer.valueOf(paramInt3 / 2 + paramInt5 / 2));
    case 7: 
      return new Pair(Integer.valueOf(0), Integer.valueOf(paramInt3));
    case 8: 
      return new Pair(Integer.valueOf(paramInt2 / 2 - paramInt4 / 2), Integer.valueOf(paramInt3));
    }
    return new Pair(Integer.valueOf(paramInt2 - paramInt4), Integer.valueOf(paramInt3));
  }
  
  private void a()
  {
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setUnderlineText(false);
    localPaint.setTextSize(a());
    localPaint.setTypeface(a());
    Rect localRect = new Rect();
    String str = b();
    localPaint.getTextBounds(str, 0, str.length(), localRect);
    this.l = localRect.width();
    this.m = localRect.height();
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  protected Bitmap a()
  {
    return this.jdField_b_of_type_AndroidGraphicsBitmap;
  }
  
  public Shader a()
  {
    return this.jdField_a_of_type_AndroidGraphicsShader;
  }
  
  public Typeface a()
  {
    return this.jdField_a_of_type_AndroidGraphicsTypeface;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  public int b()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public float c()
  {
    return this.jdField_c_of_type_Float;
  }
  
  public int c()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public float d()
  {
    return this.jdField_d_of_type_Float;
  }
  
  public int d()
  {
    return this.e;
  }
  
  public int e()
  {
    return this.f;
  }
  
  public int f()
  {
    return this.g;
  }
  
  public int g()
  {
    return this.h;
  }
  
  public int h()
  {
    return this.i;
  }
  
  public int i()
  {
    return this.j;
  }
  
  public int j()
  {
    return this.k;
  }
  
  public int k()
  {
    return this.l;
  }
  
  public int l()
  {
    return this.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.arcard.ARWordingBless.RubberStampConfig
 * JD-Core Version:    0.7.0.1
 */