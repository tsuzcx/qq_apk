package com.tencent.luggage.wxa.f;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;

@TargetApi(14)
class t
  extends o
{
  private static final String a = "t";
  private final TextureView b;
  private int c;
  private int d;
  
  t(Context paramContext, ViewGroup paramViewGroup)
  {
    this.d = paramViewGroup.getMeasuredHeight();
    this.b = ((TextureView)View.inflate(paramContext, 2131629400, paramViewGroup).findViewById(2131447261));
    this.b.setSurfaceTextureListener(new t.1(this, paramViewGroup));
  }
  
  private void c()
  {
    Matrix localMatrix = new Matrix();
    int i = this.c;
    if (i % 180 == 90)
    {
      i = l();
      int j = m();
      float f1 = i;
      float f2 = j;
      float[] arrayOfFloat;
      if (this.c == 90)
      {
        arrayOfFloat = new float[8];
        arrayOfFloat[0] = 0.0F;
        arrayOfFloat[1] = f2;
        arrayOfFloat[2] = 0.0F;
        arrayOfFloat[3] = 0.0F;
        arrayOfFloat[4] = f1;
        arrayOfFloat[5] = f2;
        arrayOfFloat[6] = f1;
        arrayOfFloat[7] = 0.0F;
      }
      else
      {
        arrayOfFloat = new float[8];
        arrayOfFloat[0] = f1;
        arrayOfFloat[1] = 0.0F;
        arrayOfFloat[2] = f1;
        arrayOfFloat[3] = f2;
        arrayOfFloat[4] = 0.0F;
        arrayOfFloat[5] = 0.0F;
        arrayOfFloat[6] = 0.0F;
        arrayOfFloat[7] = f2;
      }
      localMatrix.setPolyToPoly(new float[] { 0.0F, 0.0F, f1, 0.0F, 0.0F, f2, f1, f2 }, 0, arrayOfFloat, 0, 4);
    }
    else if (i == 180)
    {
      localMatrix.postRotate(180.0F, l() / 2, m() / 2);
    }
    localMatrix.postTranslate(0.0F, -(this.b.getHeight() - this.d) >> 1);
    this.b.setTransform(localMatrix);
  }
  
  SurfaceTexture a()
  {
    return this.b.getSurfaceTexture();
  }
  
  void a(int paramInt)
  {
    this.c = paramInt;
    c();
  }
  
  @TargetApi(15)
  void a(int paramInt1, int paramInt2)
  {
    this.b.getSurfaceTexture().setDefaultBufferSize(paramInt1, paramInt2);
  }
  
  Surface e()
  {
    return new Surface(this.b.getSurfaceTexture());
  }
  
  View g()
  {
    return this.b;
  }
  
  Class h()
  {
    return SurfaceTexture.class;
  }
  
  boolean i()
  {
    return this.b.getSurfaceTexture() != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.f.t
 * JD-Core Version:    0.7.0.1
 */