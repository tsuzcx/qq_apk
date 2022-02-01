package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class BaseTextRegion$Builder
{
  int a;
  public Bitmap a;
  public Typeface a;
  int b = 0;
  int c = 0;
  int d = 0;
  public int e = 0;
  public int f = 0;
  public int g = 2;
  
  public BaseTextRegion$Builder()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_AndroidGraphicsTypeface = null;
  }
  
  public int a(float paramFloat)
  {
    return AIOUtils.b(paramFloat, BaseApplicationImpl.getApplication().getResources());
  }
  
  public Builder a(float paramFloat1, float paramFloat2)
  {
    this.e = a(paramFloat1);
    this.f = a(paramFloat2);
    return this;
  }
  
  public Builder a(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    this.c = a(paramFloat1);
    this.d = a(paramFloat2);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    return this;
  }
  
  public Builder a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    return this;
  }
  
  public Builder a(Typeface paramTypeface)
  {
    this.jdField_a_of_type_AndroidGraphicsTypeface = paramTypeface;
    return this;
  }
  
  public BaseTextRegion a()
  {
    BaseTextRegion localBaseTextRegion = new BaseTextRegion();
    a(localBaseTextRegion);
    return localBaseTextRegion;
  }
  
  void a(BaseTextRegion paramBaseTextRegion)
  {
    paramBaseTextRegion.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    paramBaseTextRegion.e = this.e;
    paramBaseTextRegion.f = this.f;
    paramBaseTextRegion.c = this.c;
    paramBaseTextRegion.d = this.d;
    paramBaseTextRegion.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    paramBaseTextRegion.b = this.b;
    paramBaseTextRegion.jdField_a_of_type_AndroidGraphicsTypeface = this.jdField_a_of_type_AndroidGraphicsTypeface;
    paramBaseTextRegion.g = paramBaseTextRegion.a(paramBaseTextRegion.jdField_a_of_type_Int);
    paramBaseTextRegion.h = paramBaseTextRegion.a(paramBaseTextRegion.b);
    paramBaseTextRegion.i = this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.BaseTextRegion.Builder
 * JD-Core Version:    0.7.0.1
 */