package com.tencent.av.redpacket.ui;

import android.graphics.Rect;
import com.tencent.av.opengl.glrenderer.GLCanvas;
import com.tencent.av.opengl.texture.BitmapTexture;

public class GLRedPacketGame
{
  public int a;
  public int[] a;
  public Rect[] a;
  public BitmapTexture[] a;
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  
  public void a()
  {
    this.c = (this.jdField_a_of_type_Int * 70 / 160);
    this.d = (this.jdField_a_of_type_Int * 70 / 160);
    this.e = (this.jdField_a_of_type_Int * 5 / 160);
    this.f = (this.b + this.d);
    this.jdField_a_of_type_ArrayOfInt[0] = this.e;
    this.jdField_a_of_type_ArrayOfInt[1] = (this.jdField_a_of_type_Int - this.e - this.c);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int != paramInt1) || (this.b != paramInt2))
    {
      this.jdField_a_of_type_Int = paramInt1;
      this.b = paramInt2;
      a();
    }
  }
  
  public void a(GLCanvas paramGLCanvas)
  {
    long l = System.currentTimeMillis();
    a(paramGLCanvas, 0, l);
    a(paramGLCanvas, 1, l + 1500L);
  }
  
  public void a(GLCanvas paramGLCanvas, int paramInt, long paramLong)
  {
    paramGLCanvas.b();
    paramLong %= 3000L;
    int i = (int)(this.f * paramLong / 2000L - this.d);
    this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[paramInt].set(this.jdField_a_of_type_ArrayOfInt[paramInt], i, this.jdField_a_of_type_ArrayOfInt[paramInt] + this.c, this.d + i);
    float f1;
    float f2;
    if ((paramLong > 250L) && (paramLong < 500L))
    {
      f1 = (float)(paramLong - 250L) / 250.0F;
      f2 = f1;
    }
    for (;;)
    {
      float f3 = f1;
      if (f1 > 0.9F) {
        f3 = 0.9F;
      }
      paramGLCanvas.a(f3);
      int n = this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[paramInt].centerX();
      i = this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[paramInt].centerY();
      int i1 = this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[paramInt].width();
      int j = this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[paramInt].height();
      Rect localRect = this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[paramInt];
      int k = (int)(n - i1 * f2 / 2.0F);
      int m = (int)(i - j * f2 / 2.0F);
      n = (int)(n + i1 * f2 / 2.0F);
      f1 = i;
      localRect.set(k, m, n, (int)(f2 * j / 2.0F + f1));
      i = this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[paramInt].width();
      j = this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[paramInt].height();
      paramGLCanvas.a(-(this.jdField_a_of_type_Int - i) / 2, -(this.b - j) / 2);
      this.jdField_a_of_type_ArrayOfComTencentAvOpenglTextureBitmapTexture[paramInt].a(paramGLCanvas, this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[paramInt].left, this.jdField_a_of_type_ArrayOfAndroidGraphicsRect[paramInt].top, i, j);
      paramGLCanvas.c();
      return;
      if ((paramLong >= 500L) && (paramLong <= 1500L))
      {
        f1 = 1.0F;
        f2 = 1.0F;
      }
      else if ((paramLong > 1500L) && (paramLong < 1750L))
      {
        f1 = (float)(1750L - paramLong) / 250.0F;
        f2 = f1;
      }
      else
      {
        f1 = 0.0F;
        f2 = 1.0F;
      }
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ArrayOfComTencentAvOpenglTextureBitmapTexture[0].a();
    this.jdField_a_of_type_ArrayOfComTencentAvOpenglTextureBitmapTexture[1].a();
    this.jdField_a_of_type_ArrayOfComTencentAvOpenglTextureBitmapTexture = null;
    this.jdField_a_of_type_ArrayOfInt = null;
    this.jdField_a_of_type_ArrayOfAndroidGraphicsRect = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.redpacket.ui.GLRedPacketGame
 * JD-Core Version:    0.7.0.1
 */