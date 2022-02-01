package com.qflutter.vistaimage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.Surface;

class DrawableRenderer
  implements IRenderer
{
  public static final int FIT_TYPE_CONTAIN = 1;
  public static final int FIT_TYPE_COVER = 2;
  public static final int FIT_TYPE_FILL = 0;
  public static final int FIT_TYPE_FITHEIGHT = 4;
  public static final int FIT_TYPE_FITWIDTH = 3;
  public static final int FIT_TYPE_NONE = 5;
  public static final int FIT_TYPE_SCALEDOWN = 6;
  public static final String TAG = "BitmapRenderer";
  private Drawable drawable;
  private int fitType;
  private boolean isClipped;
  private Surface surface;
  private int viewHeight;
  private int viewWidth;
  
  private void renderContainType(Canvas paramCanvas, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    RectF localRectF1 = new RectF(0.0F, 0.0F, i, j);
    RectF localRectF2 = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
    if (VistaImageLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[renderContainType]  srcRect=");
      ((StringBuilder)localObject).append(localRectF1);
      ((StringBuilder)localObject).append(", dstRect=");
      ((StringBuilder)localObject).append(localRectF2);
      VistaImageLog.d("BitmapRenderer", ((StringBuilder)localObject).toString());
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).setRectToRect(localRectF1, localRectF2, Matrix.ScaleToFit.CENTER);
    paramCanvas.concat((Matrix)localObject);
    paramDrawable.setBounds(0, 0, i, j);
    paramDrawable.draw(paramCanvas);
  }
  
  private void renderCoverType(Canvas paramCanvas, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    float f3 = 0.0F;
    float f1;
    float f2;
    if (i * paramInt2 > paramInt1 * j)
    {
      f1 = paramInt2 * 1.0F / j;
      f2 = (paramInt1 - i * f1) * 0.5F;
    }
    else
    {
      f1 = paramInt1 * 1.0F / i;
      f3 = (paramInt2 - j * f1) * 0.5F;
      f2 = 0.0F;
    }
    if (VistaImageLog.isColorLevel())
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
      ((StringBuilder)localObject).append(f1);
      ((StringBuilder)localObject).append(", dx=");
      ((StringBuilder)localObject).append(f2);
      ((StringBuilder)localObject).append(", dy=");
      ((StringBuilder)localObject).append(f3);
      VistaImageLog.d("BitmapRenderer", ((StringBuilder)localObject).toString());
    }
    paramDrawable.setBounds(0, 0, i, j);
    Object localObject = new Matrix();
    ((Matrix)localObject).setScale(f1, f1);
    ((Matrix)localObject).postTranslate(f2, f3);
    paramCanvas.concat((Matrix)localObject);
    paramDrawable.draw(paramCanvas);
  }
  
  private void renderFillType(Canvas paramCanvas, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (VistaImageLog.isColorLevel())
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
      VistaImageLog.d("BitmapRenderer", localStringBuilder.toString());
    }
    paramDrawable.setBounds(0, 0, paramInt1, paramInt2);
    paramDrawable.draw(paramCanvas);
  }
  
  private void renderFitHeightType(Canvas paramCanvas, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    float f1 = paramInt2 * 1.0F / j;
    float f2 = Math.round((paramInt1 - i * f1) * 0.5F);
    if (VistaImageLog.isColorLevel())
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
      VistaImageLog.d("BitmapRenderer", ((StringBuilder)localObject).toString());
    }
    paramDrawable.setBounds(0, 0, i, j);
    Object localObject = new Matrix();
    ((Matrix)localObject).setScale(f1, f1);
    ((Matrix)localObject).postTranslate(f2, 0.0F);
    paramCanvas.concat((Matrix)localObject);
    paramDrawable.draw(paramCanvas);
  }
  
  private void renderFitWidthType(Canvas paramCanvas, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    float f1 = paramInt1 * 1.0F / i;
    float f2 = Math.round((paramInt2 - j * f1) * 0.5F);
    if (VistaImageLog.isColorLevel())
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
      VistaImageLog.d("BitmapRenderer", ((StringBuilder)localObject).toString());
    }
    paramDrawable.setBounds(0, 0, i, j);
    Object localObject = new Matrix();
    ((Matrix)localObject).setScale(f1, f1);
    ((Matrix)localObject).postTranslate(0.0F, f2);
    paramCanvas.concat((Matrix)localObject);
    paramDrawable.draw(paramCanvas);
  }
  
  private void renderNoneType(Canvas paramCanvas, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    float f1 = Math.round((paramInt1 - i) * 0.5F);
    float f2 = Math.round((paramInt2 - j) * 0.5F);
    if (VistaImageLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[renderNoneType] bmpWidth=");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", bmpHeight=");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(", viewWidth=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", viewHeight=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", dx=0, dy=");
      ((StringBuilder)localObject).append(f1);
      VistaImageLog.d("BitmapRenderer", ((StringBuilder)localObject).toString());
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).setTranslate(f1, f2);
    paramCanvas.concat((Matrix)localObject);
    paramDrawable.setBounds(0, 0, i, j);
    paramDrawable.draw(paramCanvas);
  }
  
  private void renderScaleDownType(Canvas paramCanvas, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    float f1;
    if ((i <= paramInt1) && (j <= paramInt2)) {
      f1 = 1.0F;
    } else {
      f1 = Math.min(paramInt1 / i, paramInt2 / j);
    }
    float f2 = Math.round((paramInt1 - i * f1) * 0.5F);
    float f3 = Math.round((paramInt2 - j * f1) * 0.5F);
    if (VistaImageLog.isColorLevel())
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
      VistaImageLog.d("BitmapRenderer", ((StringBuilder)localObject).toString());
    }
    paramDrawable.setBounds(0, 0, i, j);
    Object localObject = new Matrix();
    ((Matrix)localObject).setScale(f1, f1);
    ((Matrix)localObject).postTranslate(f2, f3);
    paramCanvas.concat((Matrix)localObject);
    paramDrawable.draw(paramCanvas);
  }
  
  public void clean()
  {
    Surface localSurface = this.surface;
    if (localSurface != null)
    {
      if (localSurface.isValid()) {
        this.surface.release();
      }
      this.surface = null;
    }
    if (this.drawable != null) {
      this.drawable = null;
    }
  }
  
  public void init(Surface paramSurface, Drawable paramDrawable, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    this.surface = paramSurface;
    this.drawable = paramDrawable;
    this.isClipped = paramBoolean;
    this.fitType = paramInt1;
    this.viewWidth = paramInt2;
    this.viewHeight = paramInt3;
  }
  
  public void render()
  {
    Object localObject = this.surface;
    if (localObject == null)
    {
      VistaImageLog.w("BitmapRenderer", "[render] invalid surface");
      return;
    }
    if (this.drawable == null)
    {
      VistaImageLog.w("BitmapRenderer", "[render] invalid drawable");
      return;
    }
    localObject = ((Surface)localObject).lockCanvas(null);
    if (this.isClipped) {}
    int i;
    do
    {
      renderFillType((Canvas)localObject, this.drawable, this.viewWidth, this.viewHeight);
      break;
      i = this.fitType;
      if (2 == i)
      {
        renderCoverType((Canvas)localObject, this.drawable, this.viewWidth, this.viewHeight);
        break;
      }
    } while (i == 0);
    if (6 == i)
    {
      renderScaleDownType((Canvas)localObject, this.drawable, this.viewWidth, this.viewHeight);
    }
    else if (3 == i)
    {
      renderFitWidthType((Canvas)localObject, this.drawable, this.viewWidth, this.viewHeight);
    }
    else if (1 == i)
    {
      renderContainType((Canvas)localObject, this.drawable, this.viewWidth, this.viewHeight);
    }
    else if (4 == i)
    {
      renderFitHeightType((Canvas)localObject, this.drawable, this.viewWidth, this.viewHeight);
    }
    else if (5 == i)
    {
      renderNoneType((Canvas)localObject, this.drawable, this.viewWidth, this.viewHeight);
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[render] not supported fitType: ");
      localStringBuilder.append(this.fitType);
      VistaImageLog.e("BitmapRenderer", localStringBuilder.toString());
    }
    this.surface.unlockCanvasAndPost((Canvas)localObject);
    this.drawable = null;
  }
  
  public void updateDrawable(Drawable paramDrawable)
  {
    this.drawable = paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.qflutter.vistaimage.DrawableRenderer
 * JD-Core Version:    0.7.0.1
 */