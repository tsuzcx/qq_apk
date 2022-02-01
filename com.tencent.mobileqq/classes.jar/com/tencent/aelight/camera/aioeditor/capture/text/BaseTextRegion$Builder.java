package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class BaseTextRegion$Builder
{
  int a = 0;
  int b = 0;
  int c = 0;
  int d = 0;
  public int e = 0;
  public int f = 0;
  public Bitmap g = null;
  public Typeface h = null;
  public int i = 2;
  
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
    this.a = paramInt1;
    this.b = paramInt2;
    return this;
  }
  
  public Builder a(Bitmap paramBitmap)
  {
    this.g = paramBitmap;
    return this;
  }
  
  public Builder a(Typeface paramTypeface)
  {
    this.h = paramTypeface;
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
    paramBaseTextRegion.i = this.g;
    paramBaseTextRegion.e = this.e;
    paramBaseTextRegion.f = this.f;
    paramBaseTextRegion.c = this.c;
    paramBaseTextRegion.d = this.d;
    paramBaseTextRegion.a = this.a;
    paramBaseTextRegion.b = this.b;
    paramBaseTextRegion.j = this.h;
    paramBaseTextRegion.g = paramBaseTextRegion.a(paramBaseTextRegion.a);
    paramBaseTextRegion.h = paramBaseTextRegion.a(paramBaseTextRegion.b);
    paramBaseTextRegion.k = this.i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.BaseTextRegion.Builder
 * JD-Core Version:    0.7.0.1
 */