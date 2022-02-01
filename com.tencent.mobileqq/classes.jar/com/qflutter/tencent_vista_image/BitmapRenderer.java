package com.qflutter.tencent_vista_image;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.Surface;

public class BitmapRenderer
  implements IRenderer
{
  static Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Surface jdField_a_of_type_AndroidViewSurface;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  static
  {
    jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  private static void a(Canvas paramCanvas, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if ((i <= paramInt1) && (j <= paramInt2)) {}
    for (float f1 = 1.0F;; f1 = Math.min(paramInt1 / i, paramInt2 / j))
    {
      float f2 = Math.round((paramInt1 - i * f1) * 0.5F);
      float f3 = Math.round((paramInt2 - j * f1) * 0.5F);
      if (PLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[renderContainType] bmpWidth=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", bmpHeight=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", viewWidth=");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(", viewHeight=");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(", scale=");
        ((StringBuilder)localObject).append(f1);
        ((StringBuilder)localObject).append(", dx=");
        ((StringBuilder)localObject).append(f2);
        ((StringBuilder)localObject).append(", dy=");
        ((StringBuilder)localObject).append(f3);
        PLog.d("BitmapRenderer", ((StringBuilder)localObject).toString());
      }
      Object localObject = new Matrix();
      ((Matrix)localObject).setScale(f1, f1);
      ((Matrix)localObject).postTranslate(f2, f3);
      paramCanvas.drawBitmap(paramBitmap, (Matrix)localObject, jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
  }
  
  private static void b(Canvas paramCanvas, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f2;
    float f1;
    float f3;
    if (i * paramInt2 > paramInt1 * j)
    {
      f2 = paramInt2 * 1.0F / j;
      f1 = (paramInt1 - i * f2) * 0.5F;
      f3 = 0.0F;
    }
    for (;;)
    {
      if (PLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[renderCoverType] bmpWidth=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", bmpHeight=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", viewWidth=");
        ((StringBuilder)localObject).append(paramInt1);
        ((StringBuilder)localObject).append(", viewHeight=");
        ((StringBuilder)localObject).append(paramInt2);
        ((StringBuilder)localObject).append(", scale=");
        ((StringBuilder)localObject).append(f2);
        ((StringBuilder)localObject).append(", dx=");
        ((StringBuilder)localObject).append(f1);
        ((StringBuilder)localObject).append(", dy=");
        ((StringBuilder)localObject).append(f3);
        PLog.d("BitmapRenderer", ((StringBuilder)localObject).toString());
      }
      Object localObject = new Matrix();
      ((Matrix)localObject).setScale(f2, f2);
      ((Matrix)localObject).postTranslate(f1, f3);
      paramCanvas.drawBitmap(paramBitmap, (Matrix)localObject, jdField_a_of_type_AndroidGraphicsPaint);
      return;
      f2 = paramInt1 * 1.0F / i;
      f3 = (paramInt2 - j * f2) * 0.5F;
      f1 = 0.0F;
    }
  }
  
  private static void c(Canvas paramCanvas, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    if (PLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[renderFillType] bmpWidth=");
      localStringBuilder.append(i);
      localStringBuilder.append(", bmpHeight=");
      localStringBuilder.append(j);
      localStringBuilder.append(", viewWidth=");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", viewHeight=");
      localStringBuilder.append(paramInt2);
      PLog.d("BitmapRenderer", localStringBuilder.toString());
    }
    paramCanvas.drawBitmap(paramBitmap, new Rect(0, 0, i, j), new Rect(0, 0, paramInt1, paramInt2), jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private static void d(Canvas paramCanvas, Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    float f1 = paramInt1 * 1.0F / i;
    float f2 = Math.round((paramInt2 - j * f1) * 0.5F);
    if (PLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[renderFitWidthType] bmpWidth=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", bmpHeight=");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(", viewWidth=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", viewHeight=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", scale=");
      ((StringBuilder)localObject).append(f1);
      ((StringBuilder)localObject).append(", dx=0, dy=");
      ((StringBuilder)localObject).append(f2);
      PLog.d("BitmapRenderer", ((StringBuilder)localObject).toString());
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).setScale(f1, f1);
    ((Matrix)localObject).postTranslate(0.0F, f2);
    paramCanvas.drawBitmap(paramBitmap, (Matrix)localObject, jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public void clean()
  {
    if (this.jdField_a_of_type_AndroidViewSurface != null)
    {
      if (this.jdField_a_of_type_AndroidViewSurface.isValid()) {
        this.jdField_a_of_type_AndroidViewSurface.release();
      }
      this.jdField_a_of_type_AndroidViewSurface = null;
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    }
  }
  
  public void init(Surface paramSurface, Bitmap paramBitmap, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_Int = paramInt1;
    this.c = paramInt2;
    this.b = paramInt3;
  }
  
  public void render()
  {
    if (this.jdField_a_of_type_AndroidViewSurface == null)
    {
      PLog.w("BitmapRenderer", "[render] invalid surface");
      return;
    }
    Canvas localCanvas = this.jdField_a_of_type_AndroidViewSurface.lockCanvas(null);
    if (this.jdField_a_of_type_Boolean) {
      localCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, TextureRenderer.IDENTITY_MATRIX, null);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewSurface.unlockCanvasAndPost(localCanvas);
      this.jdField_a_of_type_AndroidGraphicsBitmap = null;
      return;
      if (2 == this.jdField_a_of_type_Int) {
        b(localCanvas, this.jdField_a_of_type_AndroidGraphicsBitmap, this.c, this.b);
      } else if (this.jdField_a_of_type_Int == 0) {
        c(localCanvas, this.jdField_a_of_type_AndroidGraphicsBitmap, this.c, this.b);
      } else if (1 == this.jdField_a_of_type_Int) {
        a(localCanvas, this.jdField_a_of_type_AndroidGraphicsBitmap, this.c, this.b);
      } else if (3 == this.jdField_a_of_type_Int) {
        d(localCanvas, this.jdField_a_of_type_AndroidGraphicsBitmap, this.c, this.b);
      } else {
        PLog.e("BitmapRenderer", "[render] not supported fitType");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.tencent_vista_image.BitmapRenderer
 * JD-Core Version:    0.7.0.1
 */