package com.tencent.biz.qqstory.view.widget.bubble;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;

public class BubbleDrawable
  extends Drawable
{
  public RectF a;
  public Path b = new Path();
  public BitmapShader c;
  public Paint d = new Paint(1);
  public float e;
  public float f;
  public float g;
  public float h;
  public int i;
  public Bitmap j;
  public int k;
  public int l;
  public boolean m;
  
  private void a()
  {
    Matrix localMatrix = new Matrix();
    localMatrix.set(null);
    int n = this.j.getWidth();
    int i1 = this.j.getHeight();
    localMatrix.postScale(getIntrinsicWidth() / n, getIntrinsicHeight() / i1);
    localMatrix.postTranslate(this.a.left, this.a.top);
    this.c.setLocalMatrix(localMatrix);
  }
  
  private void a(int paramInt, Path paramPath)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3) {
            return;
          }
          d(this.a, paramPath);
          return;
        }
        b(this.a, paramPath);
        return;
      }
      c(this.a, paramPath);
      return;
    }
    a(this.a, paramPath);
  }
  
  private void a(Canvas paramCanvas)
  {
    int n = this.l;
    if (n != 0)
    {
      if (n == 1)
      {
        Bitmap localBitmap = this.j;
        if (localBitmap == null) {
          return;
        }
        if (this.c == null) {
          this.c = new BitmapShader(localBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        }
        this.d.setShader(this.c);
        a();
      }
    }
    else {
      this.d.setColor(this.i);
    }
    a(this.k, this.b);
    paramCanvas.drawPath(this.b, this.d);
  }
  
  private void a(RectF paramRectF, Path paramPath)
  {
    if (this.m) {
      this.h = ((paramRectF.bottom - paramRectF.top) / 2.0F - this.e / 2.0F);
    }
    paramPath.moveTo(this.e + paramRectF.left + this.f, paramRectF.top);
    paramPath.lineTo(paramRectF.width() - this.f, paramRectF.top);
    paramPath.arcTo(new RectF(paramRectF.right - this.f, paramRectF.top, paramRectF.right, this.f + paramRectF.top), 270.0F, 90.0F);
    paramPath.lineTo(paramRectF.right, paramRectF.bottom - this.f);
    paramPath.arcTo(new RectF(paramRectF.right - this.f, paramRectF.bottom - this.f, paramRectF.right, paramRectF.bottom), 0.0F, 90.0F);
    paramPath.lineTo(paramRectF.left + this.e + this.f, paramRectF.bottom);
    float f1 = paramRectF.left;
    float f2 = this.e;
    float f3 = paramRectF.bottom;
    float f4 = this.f;
    paramPath.arcTo(new RectF(f1 + f2, f3 - f4, f4 + paramRectF.left + this.e, paramRectF.bottom), 90.0F, 90.0F);
    paramPath.lineTo(paramRectF.left + this.e, this.g + this.h);
    paramPath.lineTo(paramRectF.left, this.h + this.g / 2.0F);
    paramPath.lineTo(paramRectF.left + this.e, this.h);
    paramPath.lineTo(paramRectF.left + this.e, paramRectF.top + this.f);
    paramPath.arcTo(new RectF(paramRectF.left + this.e, paramRectF.top, this.f + paramRectF.left + this.e, this.f + paramRectF.top), 180.0F, 90.0F);
    paramPath.close();
  }
  
  private void b(RectF paramRectF, Path paramPath)
  {
    if (this.m) {
      this.h = ((paramRectF.right - paramRectF.left) / 2.0F - this.e / 2.0F);
    }
    paramPath.moveTo(paramRectF.left + Math.min(this.h, this.f), paramRectF.top + this.g);
    paramPath.lineTo(paramRectF.left + this.h, paramRectF.top + this.g);
    paramPath.lineTo(paramRectF.left + this.e / 2.0F + this.h, paramRectF.top);
    paramPath.lineTo(paramRectF.left + this.e + this.h, paramRectF.top + this.g);
    paramPath.lineTo(paramRectF.right - this.f, paramRectF.top + this.g);
    paramPath.arcTo(new RectF(paramRectF.right - this.f, paramRectF.top + this.g, paramRectF.right, this.f + paramRectF.top + this.g), 270.0F, 90.0F);
    paramPath.lineTo(paramRectF.right, paramRectF.bottom - this.f);
    paramPath.arcTo(new RectF(paramRectF.right - this.f, paramRectF.bottom - this.f, paramRectF.right, paramRectF.bottom), 0.0F, 90.0F);
    paramPath.lineTo(paramRectF.left + this.f, paramRectF.bottom);
    float f1 = paramRectF.left;
    float f2 = paramRectF.bottom;
    float f3 = this.f;
    paramPath.arcTo(new RectF(f1, f2 - f3, f3 + paramRectF.left, paramRectF.bottom), 90.0F, 90.0F);
    paramPath.lineTo(paramRectF.left, paramRectF.top + this.g + this.f);
    paramPath.arcTo(new RectF(paramRectF.left, paramRectF.top + this.g, this.f + paramRectF.left, this.f + paramRectF.top + this.g), 180.0F, 90.0F);
    paramPath.close();
  }
  
  private void c(RectF paramRectF, Path paramPath)
  {
    if (this.m) {
      this.h = ((paramRectF.bottom - paramRectF.top) / 2.0F - this.e / 2.0F);
    }
    paramPath.moveTo(paramRectF.left + this.f, paramRectF.top);
    paramPath.lineTo(paramRectF.width() - this.f - this.e, paramRectF.top);
    paramPath.arcTo(new RectF(paramRectF.right - this.f - this.e, paramRectF.top, paramRectF.right - this.e, this.f + paramRectF.top), 270.0F, 90.0F);
    paramPath.lineTo(paramRectF.right - this.e, this.h);
    paramPath.lineTo(paramRectF.right, this.h + this.g / 2.0F);
    paramPath.lineTo(paramRectF.right - this.e, this.h + this.g);
    paramPath.lineTo(paramRectF.right - this.e, paramRectF.bottom - this.f);
    paramPath.arcTo(new RectF(paramRectF.right - this.f - this.e, paramRectF.bottom - this.f, paramRectF.right - this.e, paramRectF.bottom), 0.0F, 90.0F);
    paramPath.lineTo(paramRectF.left + this.e, paramRectF.bottom);
    float f1 = paramRectF.left;
    float f2 = paramRectF.bottom;
    float f3 = this.f;
    paramPath.arcTo(new RectF(f1, f2 - f3, f3 + paramRectF.left, paramRectF.bottom), 90.0F, 90.0F);
    paramPath.arcTo(new RectF(paramRectF.left, paramRectF.top, this.f + paramRectF.left, this.f + paramRectF.top), 180.0F, 90.0F);
    paramPath.close();
  }
  
  private void d(RectF paramRectF, Path paramPath)
  {
    if (this.m) {
      this.h = ((paramRectF.right - paramRectF.left) / 2.0F - this.e / 2.0F);
    }
    paramPath.moveTo(paramRectF.left + this.f, paramRectF.top);
    paramPath.lineTo(paramRectF.width() - this.f, paramRectF.top);
    paramPath.arcTo(new RectF(paramRectF.right - this.f, paramRectF.top, paramRectF.right, this.f + paramRectF.top), 270.0F, 90.0F);
    paramPath.lineTo(paramRectF.right, paramRectF.bottom - this.g - this.f);
    paramPath.arcTo(new RectF(paramRectF.right - this.f, paramRectF.bottom - this.f - this.g, paramRectF.right, paramRectF.bottom - this.g), 0.0F, 90.0F);
    paramPath.lineTo(paramRectF.left + this.e + this.h, paramRectF.bottom - this.g);
    paramPath.lineTo(paramRectF.left + this.h + this.e / 2.0F, paramRectF.bottom);
    paramPath.lineTo(paramRectF.left + this.h, paramRectF.bottom - this.g);
    paramPath.lineTo(paramRectF.left + Math.min(this.f, this.h), paramRectF.bottom - this.g);
    float f1 = paramRectF.left;
    float f2 = paramRectF.bottom;
    float f3 = this.f;
    paramPath.arcTo(new RectF(f1, f2 - f3 - this.g, f3 + paramRectF.left, paramRectF.bottom - this.g), 90.0F, 90.0F);
    paramPath.lineTo(paramRectF.left, paramRectF.top + this.f);
    paramPath.arcTo(new RectF(paramRectF.left, paramRectF.top, this.f + paramRectF.left, this.f + paramRectF.top), 180.0F, 90.0F);
    paramPath.close();
  }
  
  public void draw(Canvas paramCanvas)
  {
    a(paramCanvas);
  }
  
  public int getIntrinsicHeight()
  {
    return (int)this.a.height();
  }
  
  public int getIntrinsicWidth()
  {
    return (int)this.a.width();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
  }
  
  public void setAlpha(int paramInt)
  {
    this.d.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.d.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.bubble.BubbleDrawable
 * JD-Core Version:    0.7.0.1
 */