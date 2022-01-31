package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.DisplayMetrics;
import pmv;

public class SliceBitmapDrawable
  extends Drawable
{
  private int jdField_a_of_type_Int;
  private pmv jdField_a_of_type_Pmv;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  
  public SliceBitmapDrawable(Resources paramResources, Bitmap paramBitmap)
  {
    this(new pmv(paramBitmap), paramResources);
    this.jdField_a_of_type_Pmv.b = this.jdField_a_of_type_Int;
  }
  
  public SliceBitmapDrawable(Resources paramResources, SliceBitmapDrawable.SliceBitmap paramSliceBitmap)
  {
    this(new pmv(paramSliceBitmap), paramResources);
    this.jdField_a_of_type_Pmv.b = this.jdField_a_of_type_Int;
  }
  
  private SliceBitmapDrawable(pmv parampmv, Resources paramResources)
  {
    this.jdField_a_of_type_Pmv = parampmv;
    if (paramResources != null) {}
    for (this.jdField_a_of_type_Int = paramResources.getDisplayMetrics().densityDpi;; this.jdField_a_of_type_Int = parampmv.b)
    {
      a();
      return;
    }
  }
  
  private void a()
  {
    this.b = this.jdField_a_of_type_Pmv.jdField_a_of_type_ComTencentComponentMediaImageDrawableSliceBitmapDrawable$SliceBitmap.getScaledWidth(this.jdField_a_of_type_Int);
    this.c = this.jdField_a_of_type_Pmv.jdField_a_of_type_ComTencentComponentMediaImageDrawableSliceBitmapDrawable$SliceBitmap.getScaledHeight(this.jdField_a_of_type_Int);
  }
  
  public static boolean needSlice(Bitmap paramBitmap)
  {
    return (paramBitmap.getWidth() > 2048) || (paramBitmap.getHeight() > 2048);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    this.jdField_a_of_type_Pmv.jdField_a_of_type_ComTencentComponentMediaImageDrawableSliceBitmapDrawable$SliceBitmap.a(paramCanvas, localRect, this.jdField_a_of_type_Pmv.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public Bitmap getBitmap(int paramInt)
  {
    return this.jdField_a_of_type_Pmv.jdField_a_of_type_ComTencentComponentMediaImageDrawableSliceBitmapDrawable$SliceBitmap.getBitmap(paramInt);
  }
  
  public int getByteCount()
  {
    return this.jdField_a_of_type_Pmv.jdField_a_of_type_ComTencentComponentMediaImageDrawableSliceBitmapDrawable$SliceBitmap.getByteCount();
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.jdField_a_of_type_Pmv.jdField_a_of_type_Int;
  }
  
  public int getColumnCount()
  {
    return this.jdField_a_of_type_Pmv.jdField_a_of_type_ComTencentComponentMediaImageDrawableSliceBitmapDrawable$SliceBitmap.getColumnCount();
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    this.jdField_a_of_type_Pmv.jdField_a_of_type_Int = getChangingConfigurations();
    return this.jdField_a_of_type_Pmv;
  }
  
  public int getIntrinsicHeight()
  {
    return this.c;
  }
  
  public int getIntrinsicWidth()
  {
    return this.b;
  }
  
  public int getOpacity()
  {
    if ((this.jdField_a_of_type_Pmv.jdField_a_of_type_ComTencentComponentMediaImageDrawableSliceBitmapDrawable$SliceBitmap.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Pmv.jdField_a_of_type_AndroidGraphicsPaint.getAlpha() < 255)) {
      return -3;
    }
    return -1;
  }
  
  public final Paint getPaint()
  {
    return this.jdField_a_of_type_Pmv.jdField_a_of_type_AndroidGraphicsPaint;
  }
  
  public int getRowCount()
  {
    return this.jdField_a_of_type_Pmv.jdField_a_of_type_ComTencentComponentMediaImageDrawableSliceBitmapDrawable$SliceBitmap.getRowCount();
  }
  
  public Drawable mutate()
  {
    if ((!this.jdField_a_of_type_Boolean) && (super.mutate() == this))
    {
      this.jdField_a_of_type_Pmv = new pmv(this.jdField_a_of_type_Pmv);
      this.jdField_a_of_type_Boolean = true;
    }
    return this;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_Pmv.jdField_a_of_type_AndroidGraphicsPaint.getAlpha())
    {
      this.jdField_a_of_type_Pmv.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setAntiAlias(boolean paramBoolean)
  {
    this.jdField_a_of_type_Pmv.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(paramBoolean);
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_Pmv.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.jdField_a_of_type_Pmv.jdField_a_of_type_AndroidGraphicsPaint.setDither(paramBoolean);
    invalidateSelf();
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.jdField_a_of_type_Pmv.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(paramBoolean);
    invalidateSelf();
  }
  
  public void setTargetDensity(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      int i = paramInt;
      if (paramInt == 0) {
        i = 160;
      }
      this.jdField_a_of_type_Int = i;
      a();
      invalidateSelf();
    }
  }
  
  public void setTargetDensity(Canvas paramCanvas)
  {
    setTargetDensity(paramCanvas.getDensity());
  }
  
  public void setTargetDensity(DisplayMetrics paramDisplayMetrics)
  {
    setTargetDensity(paramDisplayMetrics.densityDpi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.SliceBitmapDrawable
 * JD-Core Version:    0.7.0.1
 */