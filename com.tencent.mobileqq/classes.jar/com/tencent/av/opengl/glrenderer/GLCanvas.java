package com.tencent.av.opengl.glrenderer;

import android.graphics.Bitmap;
import com.tencent.av.opengl.texture.BasicTexture;

public abstract interface GLCanvas
{
  public abstract Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2);
  
  public abstract GLId a();
  
  public abstract void a(float paramFloat);
  
  public abstract void a(float paramFloat1, float paramFloat2);
  
  public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
  
  public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt);
  
  public abstract void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, GLPaint paramGLPaint);
  
  public abstract void a(int paramInt);
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(BasicTexture paramBasicTexture, int paramInt1, int paramInt2);
  
  public abstract void a(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void a(BasicTexture paramBasicTexture, int paramInt1, int paramInt2, Bitmap paramBitmap, int paramInt3, int paramInt4);
  
  public abstract void a(BasicTexture paramBasicTexture, Bitmap paramBitmap);
  
  public abstract void a(BasicTexture paramBasicTexture, float[] paramArrayOfFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract boolean a(BasicTexture paramBasicTexture);
  
  public abstract int b();
  
  public abstract void b(float paramFloat1, float paramFloat2, float paramFloat3);
  
  public abstract void b(BasicTexture paramBasicTexture);
  
  public abstract int c();
  
  public abstract void d();
  
  public abstract float e();
  
  public abstract void f();
  
  public abstract void g();
  
  public abstract void h();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.opengl.glrenderer.GLCanvas
 * JD-Core Version:    0.7.0.1
 */