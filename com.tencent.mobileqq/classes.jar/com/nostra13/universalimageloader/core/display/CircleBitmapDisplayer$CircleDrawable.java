package com.nostra13.universalimageloader.core.display;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

public class CircleBitmapDisplayer$CircleDrawable
  extends Drawable
{
  protected final BitmapShader bitmapShader;
  protected final RectF mBitmapRect;
  protected final RectF mRect = new RectF();
  protected final Paint paint;
  protected float radius;
  protected final Paint strokePaint;
  protected float strokeRadius;
  protected final float strokeWidth;
  
  public CircleBitmapDisplayer$CircleDrawable(Bitmap paramBitmap, Integer paramInteger, float paramFloat)
  {
    this.radius = (Math.min(paramBitmap.getWidth(), paramBitmap.getHeight()) / 2);
    this.bitmapShader = new BitmapShader(paramBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.mBitmapRect = new RectF(0.0F, 0.0F, paramBitmap.getWidth(), paramBitmap.getHeight());
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.paint.setShader(this.bitmapShader);
    this.paint.setFilterBitmap(true);
    this.paint.setDither(true);
    if (paramInteger == null)
    {
      this.strokePaint = null;
    }
    else
    {
      this.strokePaint = new Paint();
      this.strokePaint.setStyle(Paint.Style.STROKE);
      this.strokePaint.setColor(paramInteger.intValue());
      this.strokePaint.setStrokeWidth(paramFloat);
      this.strokePaint.setAntiAlias(true);
    }
    this.strokeWidth = paramFloat;
    this.strokeRadius = (this.radius - paramFloat / 2.0F);
  }
  
  public void draw(Canvas paramCanvas)
  {
    float f = this.radius;
    paramCanvas.drawCircle(f, f, f, this.paint);
    Paint localPaint = this.strokePaint;
    if (localPaint != null)
    {
      f = this.radius;
      paramCanvas.drawCircle(f, f, this.strokeRadius, localPaint);
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.mRect.set(0.0F, 0.0F, paramRect.width(), paramRect.height());
    this.radius = (Math.min(paramRect.width(), paramRect.height()) / 2);
    this.strokeRadius = (this.radius - this.strokeWidth / 2.0F);
    paramRect = new Matrix();
    paramRect.setRectToRect(this.mBitmapRect, this.mRect, Matrix.ScaleToFit.FILL);
    this.bitmapShader.setLocalMatrix(paramRect);
  }
  
  public void setAlpha(int paramInt)
  {
    this.paint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.paint.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer.CircleDrawable
 * JD-Core Version:    0.7.0.1
 */