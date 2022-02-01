package com.tencent.gdtad.views;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.ShapeDrawable.ShaderFactory;

final class GdtUIUtils$1
  extends ShapeDrawable.ShaderFactory
{
  GdtUIUtils$1(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int[] paramArrayOfInt) {}
  
  public Shader resize(int paramInt1, int paramInt2)
  {
    float f1 = paramInt1;
    float f2 = this.a;
    float f3 = paramInt2;
    return new LinearGradient(f1 * f2, f3 * this.b, f1 * this.c, f3 * this.d, this.e, null, Shader.TileMode.CLAMP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.views.GdtUIUtils.1
 * JD-Core Version:    0.7.0.1
 */