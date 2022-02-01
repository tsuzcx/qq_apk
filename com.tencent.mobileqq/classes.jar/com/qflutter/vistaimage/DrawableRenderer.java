package com.qflutter.vistaimage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
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
  private double radius;
  private RendererParams.ImageRepeat repeat = RendererParams.ImageRepeat.NO_REPEAT;
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
      ((StringBuilder)localObject).append(", dx=0");
      ((StringBuilder)localObject).append(", dy=");
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
      ((StringBuilder)localObject).append(", dx=0");
      ((StringBuilder)localObject).append(", dy=");
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
      ((StringBuilder)localObject).append(", dx=0");
      ((StringBuilder)localObject).append(", dy=");
      ((StringBuilder)localObject).append(f1);
      VistaImageLog.d("BitmapRenderer", ((StringBuilder)localObject).toString());
    }
    Object localObject = new Matrix();
    ((Matrix)localObject).setTranslate(f1, f2);
    paramCanvas.concat((Matrix)localObject);
    paramDrawable.setBounds(0, 0, i, j);
    paramDrawable.draw(paramCanvas);
  }
  
  private void renderRepeat(Canvas paramCanvas, Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    if (!(paramDrawable instanceof BitmapDrawable))
    {
      paramCanvas = new StringBuilder();
      paramCanvas.append("[renderRepeat] only BitmapDrawable can draw repeat, ");
      paramCanvas.append(paramDrawable.getClass().getSimpleName());
      VistaImageLog.w("BitmapRenderer", paramCanvas.toString());
      return;
    }
    paramCanvas.drawColor(-65536);
    BitmapDrawable localBitmapDrawable = (BitmapDrawable)paramDrawable;
    if (VistaImageLog.isColorLevel())
    {
      paramDrawable = new StringBuilder();
      paramDrawable.append("[renderRepeat] , viewWidth=");
      paramDrawable.append(paramInt1);
      paramDrawable.append(", viewHeight=");
      paramDrawable.append(paramInt2);
      paramDrawable.append(", repeat=");
      paramDrawable.append(this.repeat);
      VistaImageLog.d("BitmapRenderer", paramDrawable.toString());
    }
    localBitmapDrawable.setBounds(0, 0, paramInt1, paramInt2);
    localBitmapDrawable.setDither(true);
    paramInt1 = DrawableRenderer.1.a[this.repeat.ordinal()];
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          break label204;
        }
        paramDrawable = Shader.TileMode.CLAMP;
      }
      else
      {
        paramDrawable = Shader.TileMode.REPEAT;
        localTileMode = Shader.TileMode.CLAMP;
        break label196;
      }
    }
    else {
      paramDrawable = Shader.TileMode.REPEAT;
    }
    Shader.TileMode localTileMode = Shader.TileMode.REPEAT;
    label196:
    localBitmapDrawable.setTileModeXY(paramDrawable, localTileMode);
    label204:
    localBitmapDrawable.draw(paramCanvas);
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
  
  public void init(RendererParams paramRendererParams)
  {
    this.surface = paramRendererParams.getSurface();
    this.drawable = paramRendererParams.getDrawable();
    this.isClipped = paramRendererParams.isClipped();
    this.fitType = paramRendererParams.getFitType();
    this.viewWidth = paramRendererParams.getViewWidth();
    this.viewHeight = paramRendererParams.getViewHeight();
    this.radius = paramRendererParams.getRadius();
    this.repeat = paramRendererParams.getRepeat();
  }
  
  boolean isGreaterThanZero(double paramDouble)
  {
    return paramDouble > 0.05D;
  }
  
  public void render()
  {
    Object localObject1 = this.surface;
    if (localObject1 == null)
    {
      VistaImageLog.w("BitmapRenderer", "[render] invalid surface");
      return;
    }
    if (this.drawable == null)
    {
      VistaImageLog.w("BitmapRenderer", "[render] invalid drawable");
      return;
    }
    localObject1 = ((Surface)localObject1).lockCanvas(null);
    Object localObject2;
    if (isGreaterThanZero(this.radius))
    {
      localObject2 = new Path();
      RectF localRectF = new RectF(0.0F, 0.0F, this.viewWidth, this.viewHeight);
      double d = this.radius;
      ((Path)localObject2).addRoundRect(localRectF, (float)d, (float)d, Path.Direction.CCW);
      ((Canvas)localObject1).clipPath((Path)localObject2);
    }
    if (this.repeat != RendererParams.ImageRepeat.NO_REPEAT)
    {
      renderRepeat((Canvas)localObject1, this.drawable, this.viewWidth, this.viewHeight);
    }
    else
    {
      if (this.isClipped) {}
      int i;
      do
      {
        renderFillType((Canvas)localObject1, this.drawable, this.viewWidth, this.viewHeight);
        break;
        i = this.fitType;
        if (2 == i)
        {
          renderCoverType((Canvas)localObject1, this.drawable, this.viewWidth, this.viewHeight);
          break;
        }
      } while (i == 0);
      if (6 == i)
      {
        renderScaleDownType((Canvas)localObject1, this.drawable, this.viewWidth, this.viewHeight);
      }
      else if (3 == i)
      {
        renderFitWidthType((Canvas)localObject1, this.drawable, this.viewWidth, this.viewHeight);
      }
      else if (1 == i)
      {
        renderContainType((Canvas)localObject1, this.drawable, this.viewWidth, this.viewHeight);
      }
      else if (4 == i)
      {
        renderFitHeightType((Canvas)localObject1, this.drawable, this.viewWidth, this.viewHeight);
      }
      else if (5 == i)
      {
        renderNoneType((Canvas)localObject1, this.drawable, this.viewWidth, this.viewHeight);
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[render] not supported fitType: ");
        ((StringBuilder)localObject2).append(this.fitType);
        VistaImageLog.e("BitmapRenderer", ((StringBuilder)localObject2).toString());
      }
    }
    this.surface.unlockCanvasAndPost((Canvas)localObject1);
    this.drawable = null;
  }
  
  public void updateDrawable(Drawable paramDrawable)
  {
    this.drawable = paramDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.vistaimage.DrawableRenderer
 * JD-Core Version:    0.7.0.1
 */