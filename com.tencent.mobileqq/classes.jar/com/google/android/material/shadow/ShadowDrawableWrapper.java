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
  static final double jdField_a_of_type_Double = Math.cos(Math.toRadians(45.0D));
  float jdField_a_of_type_Float;
  private final int jdField_a_of_type_Int;
  @NonNull
  final Paint jdField_a_of_type_AndroidGraphicsPaint;
  Path jdField_a_of_type_AndroidGraphicsPath;
  @NonNull
  final RectF jdField_a_of_type_AndroidGraphicsRectF;
  private boolean jdField_a_of_type_Boolean;
  float jdField_b_of_type_Float;
  private final int jdField_b_of_type_Int;
  @NonNull
  final Paint jdField_b_of_type_AndroidGraphicsPaint;
  private boolean jdField_b_of_type_Boolean;
  float jdField_c_of_type_Float;
  private final int jdField_c_of_type_Int;
  float d;
  private float e;
  
  public static float a(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      double d1 = paramFloat1 * 1.5F;
      double d2 = jdField_a_of_type_Double;
      double d3 = paramFloat2;
      Double.isNaN(d3);
      Double.isNaN(d1);
      return (float)(d1 + (1.0D - d2) * d3);
    }
    return paramFloat1 * 1.5F;
  }
  
  private void a()
  {
    float f1 = this.jdField_a_of_type_Float;
    Object localObject1 = new RectF(-f1, -f1, f1, f1);
    RectF localRectF = new RectF((RectF)localObject1);
    f1 = this.jdField_c_of_type_Float;
    localRectF.inset(-f1, -f1);
    Object localObject2 = this.jdField_a_of_type_AndroidGraphicsPath;
    if (localObject2 == null) {
      this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    } else {
      ((Path)localObject2).reset();
    }
    this.jdField_a_of_type_AndroidGraphicsPath.setFillType(Path.FillType.EVEN_ODD);
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(-this.jdField_a_of_type_Float, 0.0F);
    this.jdField_a_of_type_AndroidGraphicsPath.rLineTo(-this.jdField_c_of_type_Float, 0.0F);
    this.jdField_a_of_type_AndroidGraphicsPath.arcTo(localRectF, 180.0F, 90.0F, false);
    this.jdField_a_of_type_AndroidGraphicsPath.arcTo((RectF)localObject1, 270.0F, -90.0F, false);
    this.jdField_a_of_type_AndroidGraphicsPath.close();
    f1 = -localRectF.top;
    if (f1 > 0.0F)
    {
      f2 = this.jdField_a_of_type_Float / f1;
      float f3 = (1.0F - f2) / 2.0F;
      localObject2 = this.jdField_a_of_type_AndroidGraphicsPaint;
      i = this.jdField_a_of_type_Int;
      j = this.jdField_b_of_type_Int;
      k = this.jdField_c_of_type_Int;
      Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
      ((Paint)localObject2).setShader(new RadialGradient(0.0F, 0.0F, f1, new int[] { 0, i, j, k }, new float[] { 0.0F, f2, f3 + f2, 1.0F }, localTileMode));
    }
    localObject2 = this.jdField_b_of_type_AndroidGraphicsPaint;
    f1 = ((RectF)localObject1).top;
    float f2 = localRectF.top;
    int i = this.jdField_a_of_type_Int;
    int j = this.jdField_b_of_type_Int;
    int k = this.jdField_c_of_type_Int;
    localObject1 = Shader.TileMode.CLAMP;
    ((Paint)localObject2).setShader(new LinearGradient(0.0F, f1, 0.0F, f2, new int[] { i, j, k }, new float[] { 0.0F, 0.5F, 1.0F }, (Shader.TileMode)localObject1));
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(false);
  }
  
  private void a(@NonNull Canvas paramCanvas)
  {
    int k = paramCanvas.save();
    paramCanvas.rotate(this.e, this.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_AndroidGraphicsRectF.centerY());
    float f3 = this.jdField_a_of_type_Float;
    float f4 = -f3 - this.jdField_c_of_type_Float;
    float f1 = this.jdField_a_of_type_AndroidGraphicsRectF.width();
    float f5 = f3 * 2.0F;
    if (f1 - f5 > 0.0F) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (this.jdField_a_of_type_AndroidGraphicsRectF.height() - f5 > 0.0F) {
      j = 1;
    } else {
      j = 0;
    }
    f1 = this.d;
    float f6 = f3 / (f1 - 0.5F * f1 + f3);
    float f2 = f3 / (f1 - 0.25F * f1 + f3);
    f1 = f3 / (f1 - f1 * 1.0F + f3);
    int m = paramCanvas.save();
    paramCanvas.translate(this.jdField_a_of_type_AndroidGraphicsRectF.left + f3, this.jdField_a_of_type_AndroidGraphicsRectF.top + f3);
    paramCanvas.scale(f6, f2);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (i != 0)
    {
      paramCanvas.scale(1.0F / f6, 1.0F);
      paramCanvas.drawRect(0.0F, f4, this.jdField_a_of_type_AndroidGraphicsRectF.width() - f5, -this.jdField_a_of_type_Float, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    paramCanvas.restoreToCount(m);
    m = paramCanvas.save();
    paramCanvas.translate(this.jdField_a_of_type_AndroidGraphicsRectF.right - f3, this.jdField_a_of_type_AndroidGraphicsRectF.bottom - f3);
    paramCanvas.scale(f6, f1);
    paramCanvas.rotate(180.0F);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (i != 0)
    {
      paramCanvas.scale(1.0F / f6, 1.0F);
      paramCanvas.drawRect(0.0F, f4, this.jdField_a_of_type_AndroidGraphicsRectF.width() - f5, -this.jdField_a_of_type_Float + this.jdField_c_of_type_Float, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    paramCanvas.restoreToCount(m);
    int i = paramCanvas.save();
    paramCanvas.translate(this.jdField_a_of_type_AndroidGraphicsRectF.left + f3, this.jdField_a_of_type_AndroidGraphicsRectF.bottom - f3);
    paramCanvas.scale(f6, f1);
    paramCanvas.rotate(270.0F);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (j != 0)
    {
      paramCanvas.scale(1.0F / f1, 1.0F);
      paramCanvas.drawRect(0.0F, f4, this.jdField_a_of_type_AndroidGraphicsRectF.height() - f5, -this.jdField_a_of_type_Float, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    paramCanvas.restoreToCount(i);
    i = paramCanvas.save();
    paramCanvas.translate(this.jdField_a_of_type_AndroidGraphicsRectF.right - f3, this.jdField_a_of_type_AndroidGraphicsRectF.top + f3);
    paramCanvas.scale(f6, f2);
    paramCanvas.rotate(90.0F);
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (j != 0)
    {
      paramCanvas.scale(1.0F / f2, 1.0F);
      paramCanvas.drawRect(0.0F, f4, this.jdField_a_of_type_AndroidGraphicsRectF.height() - f5, -this.jdField_a_of_type_Float, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    paramCanvas.restoreToCount(i);
    paramCanvas.restoreToCount(k);
  }
  
  private void a(@NonNull Rect paramRect)
  {
    float f = this.jdField_b_of_type_Float * 1.5F;
    this.jdField_a_of_type_AndroidGraphicsRectF.set(paramRect.left + this.jdField_b_of_type_Float, paramRect.top + f, paramRect.right - this.jdField_b_of_type_Float, paramRect.bottom - f);
    getWrappedDrawable().setBounds((int)this.jdField_a_of_type_AndroidGraphicsRectF.left, (int)this.jdField_a_of_type_AndroidGraphicsRectF.top, (int)this.jdField_a_of_type_AndroidGraphicsRectF.right, (int)this.jdField_a_of_type_AndroidGraphicsRectF.bottom);
    a();
  }
  
  public static float b(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    float f = paramFloat1;
    if (paramBoolean)
    {
      double d1 = paramFloat1;
      double d2 = jdField_a_of_type_Double;
      double d3 = paramFloat2;
      Double.isNaN(d3);
      Double.isNaN(d1);
      f = (float)(d1 + (1.0D - d2) * d3);
    }
    return f;
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      a(getBounds());
      this.jdField_a_of_type_Boolean = false;
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
    int i = (int)Math.ceil(a(this.jdField_b_of_type_Float, this.jdField_a_of_type_Float, this.jdField_b_of_type_Boolean));
    int j = (int)Math.ceil(b(this.jdField_b_of_type_Float, this.jdField_a_of_type_Float, this.jdField_b_of_type_Boolean));
    paramRect.set(j, i, j, i);
    return true;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void setAlpha(int paramInt)
  {
    super.setAlpha(paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.shadow.ShadowDrawableWrapper
 * JD-Core Version:    0.7.0.1
 */