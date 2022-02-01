package com.tencent.mobileqq.bubble;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

class AnimatorPathDrawable
  extends Drawable
{
  public Bitmap a;
  public boolean b = false;
  public int c = -1;
  public int d = -1;
  private Paint e = new Paint(6);
  
  public AnimatorPathDrawable(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
    this.c = paramBitmap.getWidth();
    this.d = paramBitmap.getHeight();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = super.getBounds();
    if (this.b)
    {
      paramCanvas.save();
      paramCanvas.scale(-1.0F, 1.0F, localRect.centerX(), localRect.centerY());
    }
    paramCanvas.drawBitmap(this.a, null, super.getBounds(), this.e);
    if (this.b) {
      paramCanvas.restore();
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.c;
  }
  
  public int getIntrinsicWidth()
  {
    return this.d;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.e.getAlpha())
    {
      this.e.setAlpha(paramInt);
      super.invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.e.setColorFilter(paramColorFilter);
    super.invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.e.setDither(paramBoolean);
    super.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.AnimatorPathDrawable
 * JD-Core Version:    0.7.0.1
 */