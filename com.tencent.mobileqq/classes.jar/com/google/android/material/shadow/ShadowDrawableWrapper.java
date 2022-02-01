package com.google.android.material.shadow;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.DrawableWrapper;

@Deprecated
public class ShadowDrawableWrapper
  extends DrawableWrapper
{
  static final double a = Math.cos(Math.toRadians(45.0D));
  @NonNull
  final Paint b;
  @NonNull
  final Paint c;
  @NonNull
  final RectF d;
  float e;
  Path f;
  float g;
  float h;
  float i;
  private boolean j;
  private final int k;
  private final int l;
  private final int m;
  private boolean n;
  private float o;
  
  public static float a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      double d1 = paramFloat1 * 1.5F;
      double d2 = a;
      double d3 = paramFloat2;
      Double.isNaN(d3);
      Double.isNaN(d1);
      return (float)(d1 + (1.0D - d2) * d3);
    }
    return paramFloat1 * 1.5F;
  }
  
  private void a()
  {
    float f1 = this.e;
    Object localObject1 = new RectF(-f1, -f1, f1, f1);
    RectF localRectF = new RectF((RectF)localObject1);
    f1 = this.h;
    localRectF.inset(-f1, -f1);
    Object localObject2 = this.f;
    if (localObject2 == null) {
      this.f = new Path();
    } else {
      ((Path)localObject2).reset();
    }
    this.f.setFillType(Path.FillType.EVEN_ODD);
    this.f.moveTo(-this.e, 0.0F);
    this.f.rLineTo(-this.h, 0.0F);
    this.f.arcTo(localRectF, 180.0F, 90.0F, false);
    this.f.arcTo((RectF)localObject1, 270.0F, -90.0F, false);
    this.f.close();
    f1 = -localRectF.top;
    if (f1 > 0.0F)
    {
      f2 = this.e / f1;
      float f3 = (1.0F - f2) / 2.0F;
      localObject2 = this.b;
      i1 = this.k;
      i2 = this.l;
      i3 = this.m;
      Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
      ((Paint)localObject2).setShader(new RadialGradient(0.0F, 0.0F, f1, new int[] { 0, i1, i2, i3 }, new float[] { 0.0F, f2, f3 + f2, 1.0F }, localTileMode));
    }
    localObject2 = this.c;
    f1 = ((RectF)localObject1).top;
    float f2 = localRectF.top;
    int i1 = this.k;
    int i2 = this.l;
    int i3 = this.m;
    localObject1 = Shader.TileMode.CLAMP;
    ((Paint)localObject2).setShader(new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { i1, i2, i3 }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject1));
    this.c.setAntiAlias(false);
  }
  
  private void a(@NonNull Canvas paramCanvas)
  {
    int i3 = paramCanvas.save();
    paramCanvas.rotate(this.o, this.d.centerX(), this.d.centerY());
    float f3 = this.e;
    float f4 = -f3 - this.h;
    float f1 = this.d.width();
    float f5 = f3 * 2.0F;
    if (f1 - f5 > 0.0F) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    int i2;
    if (this.d.height() - f5 > 0.0F) {
      i2 = 1;
    } else {
      i2 = 0;
    }
    f1 = this.i;
    float f6 = f3 / (f1 - 0.5F * f1 + f3);
    float f2 = f3 / (f1 - 0.25F * f1 + f3);
    f1 = f3 / (f1 - f1 * 1.0F + f3);
    int i4 = paramCanvas.save();
    paramCanvas.translate(this.d.left + f3, this.d.top + f3);
    paramCanvas.scale(f6, f2);
    paramCanvas.drawPath(this.f, this.b);
    if (i1 != 0)
    {
      paramCanvas.scale(1.0F / f6, 1.0F);
      paramCanvas.drawRect(0.0F, f4, this.d.width() - f5, -this.e, this.c);
    }
    paramCanvas.restoreToCount(i4);
    i4 = paramCanvas.save();
    paramCanvas.translate(this.d.right - f3, this.d.bottom - f3);
    paramCanvas.scale(f6, f1);
    paramCanvas.rotate(180.0F);
    paramCanvas.drawPath(this.f, this.b);
    if (i1 != 0)
    {
      paramCanvas.scale(1.0F / f6, 1.0F);
      paramCanvas.drawRect(0.0F, f4, this.d.width() - f5, -this.e + this.h, this.c);
    }
    paramCanvas.restoreToCount(i4);
    int i1 = paramCanvas.save();
    paramCanvas.translate(this.d.left + f3, this.d.bottom - f3);
    paramCanvas.scale(f6, f1);
    paramCanvas.rotate(270.0F);
    paramCanvas.drawPath(this.f, this.b);
    if (i2 != 0)
    {
      paramCanvas.scale(1.0F / f1, 1.0F);
      paramCanvas.drawRect(0.0F, f4, this.d.height() - f5, -this.e, this.c);
    }
    paramCanvas.restoreToCount(i1);
    i1 = paramCanvas.save();
    paramCanvas.translate(this.d.right - f3, this.d.top + f3);
    paramCanvas.scale(f6, f2);
    paramCanvas.rotate(90.0F);
    paramCanvas.drawPath(this.f, this.b);
    if (i2 != 0)
    {
      paramCanvas.scale(1.0F / f2, 1.0F);
      paramCanvas.drawRect(0.0F, f4, this.d.height() - f5, -this.e, this.c);
    }
    paramCanvas.restoreToCount(i1);
    paramCanvas.restoreToCount(i3);
  }
  
  private void a(@NonNull Rect paramRect)
  {
    float f1 = this.g * 1.5F;
    this.d.set(paramRect.left + this.g, paramRect.top + f1, paramRect.right - this.g, paramRect.bottom - f1);
    getWrappedDrawable().setBounds((int)this.d.left, (int)this.d.top, (int)this.d.right, (int)this.d.bottom);
    a();
  }
  
  public static float b(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f1 = paramFloat1;
    if (paramBoolean)
    {
      double d1 = paramFloat1;
      double d2 = a;
      double d3 = paramFloat2;
      Double.isNaN(d3);
      Double.isNaN(d1);
      f1 = (float)(d1 + (1.0D - d2) * d3);
    }
    return f1;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if (this.j)
    {
      a(getBounds());
      this.j = false;
    }
    a(paramCanvas);
    super.draw(paramCanvas);
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public boolean getPadding(@NonNull Rect paramRect)
  {
    int i1 = (int)Math.ceil(a(this.g, this.e, this.n));
    int i2 = (int)Math.ceil(b(this.g, this.e, this.n));
    paramRect.set(i2, i1, i2, i1);
    return true;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.j = true;
  }
  
  public void setAlpha(int paramInt)
  {
    super.setAlpha(paramInt);
    this.b.setAlpha(paramInt);
    this.c.setAlpha(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.shadow.ShadowDrawableWrapper
 * JD-Core Version:    0.7.0.1
 */