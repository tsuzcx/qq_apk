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
import com.tencent.component.media.image.BitmapReference;
import pgd;

public class ImageDrawable
  extends Drawable
{
  private int jdField_a_of_type_Int;
  private BitmapReference jdField_a_of_type_ComTencentComponentMediaImageBitmapReference;
  private pgd jdField_a_of_type_Pgd;
  private boolean jdField_a_of_type_Boolean;
  private int b = -1;
  private int c = -1;
  private int d;
  private int e;
  
  public ImageDrawable(Resources paramResources, BitmapReference paramBitmapReference)
  {
    this(paramResources, paramBitmapReference, -1, -1);
  }
  
  public ImageDrawable(Resources paramResources, BitmapReference paramBitmapReference, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Pgd = new pgd(paramBitmapReference, paramInt1, paramInt2);
    if (paramResources != null) {
      this.jdField_a_of_type_Int = paramResources.getDisplayMetrics().densityDpi;
    }
    setBitmapInternal(paramBitmapReference);
  }
  
  public ImageDrawable(BitmapReference paramBitmapReference)
  {
    this(null, paramBitmapReference, -1, -1);
  }
  
  public ImageDrawable(BitmapReference paramBitmapReference, int paramInt1, int paramInt2)
  {
    this(null, paramBitmapReference, paramInt1, paramInt2);
  }
  
  private ImageDrawable(pgd parampgd, Resources paramResources)
  {
    this.jdField_a_of_type_Pgd = new pgd(parampgd);
    if (paramResources != null)
    {
      this.jdField_a_of_type_Int = paramResources.getDisplayMetrics().densityDpi;
      if (parampgd == null) {
        break label71;
      }
    }
    label71:
    for (parampgd = parampgd.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference;; parampgd = null)
    {
      setBitmapInternal(parampgd);
      return;
      if (parampgd == null) {
        break;
      }
      this.jdField_a_of_type_Int = parampgd.d;
      break;
    }
  }
  
  private void a()
  {
    Bitmap localBitmap = this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference.getBitmap();
    if (localBitmap == null)
    {
      this.c = -1;
      this.b = -1;
      return;
    }
    int j = this.jdField_a_of_type_Int;
    int i;
    if (j == 0)
    {
      i = localBitmap.getWidth();
      if (j != 0) {
        break label84;
      }
    }
    label84:
    for (j = localBitmap.getHeight();; j = localBitmap.getScaledHeight(j))
    {
      long l = computeProperSize(i, j);
      this.b = extractRangeStartFromLong(l);
      this.c = extractRangeEndFromLong(l);
      return;
      i = localBitmap.getScaledWidth(j);
      break;
    }
  }
  
  protected static long computeProperScale(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    float f2 = 1.0F;
    float f1;
    if ((paramInt3 <= 0) && (paramInt4 <= 0))
    {
      f1 = 1.0F;
      if (f1 >= 1.0F) {
        break label70;
      }
      f1 = f2;
    }
    label70:
    for (;;)
    {
      return packRangeInLong((int)(paramInt1 * f1), (int)(f1 * paramInt2));
      if (paramInt3 * paramInt2 > paramInt4 * paramInt1)
      {
        f1 = paramInt3 / paramInt1;
        break;
      }
      f1 = paramInt4 / paramInt2;
      break;
    }
  }
  
  protected static int extractRangeEndFromLong(long paramLong)
  {
    return (int)(0xFFFFFFFF & paramLong);
  }
  
  protected static int extractRangeStartFromLong(long paramLong)
  {
    return (int)(paramLong >>> 32);
  }
  
  protected static long packRangeInLong(int paramInt1, int paramInt2)
  {
    return paramInt1 << 32 | paramInt2;
  }
  
  protected final long computeProperSize(int paramInt1, int paramInt2)
  {
    return computeProperScale(paramInt1, paramInt2, this.jdField_a_of_type_Pgd.jdField_a_of_type_Int, this.jdField_a_of_type_Pgd.b);
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject = this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference;
    if (localObject != null) {}
    for (localObject = ((BitmapReference)localObject).getBitmap();; localObject = null)
    {
      if (localObject != null)
      {
        pgd localpgd = this.jdField_a_of_type_Pgd;
        paramCanvas.drawBitmap((Bitmap)localObject, null, getBounds(), localpgd.jdField_a_of_type_AndroidGraphicsPaint);
      }
      return;
    }
  }
  
  public Bitmap getBitmap()
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference != null) {
      return this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference.getBitmap();
    }
    return null;
  }
  
  public int getBitmapHeight()
  {
    BitmapReference localBitmapReference = this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference;
    if (localBitmapReference == null) {
      return -1;
    }
    return localBitmapReference.getHeight();
  }
  
  public BitmapReference getBitmapRef()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference;
  }
  
  public int getBitmapWidth()
  {
    BitmapReference localBitmapReference = this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference;
    if (localBitmapReference == null) {
      return -1;
    }
    return localBitmapReference.getWidth();
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.jdField_a_of_type_Pgd.c;
  }
  
  public int getClipHeight()
  {
    return this.jdField_a_of_type_Pgd.b;
  }
  
  public int getClipWidth()
  {
    return this.jdField_a_of_type_Pgd.jdField_a_of_type_Int;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    this.jdField_a_of_type_Pgd.c = getChangingConfigurations();
    return this.jdField_a_of_type_Pgd;
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
    BitmapReference localBitmapReference = this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference;
    if ((localBitmapReference == null) || (localBitmapReference.hasAlpha()) || (this.jdField_a_of_type_Pgd.jdField_a_of_type_AndroidGraphicsPaint.getAlpha() < 255)) {
      return -3;
    }
    return -1;
  }
  
  public int getOriginalHeight()
  {
    if (this.e > 0) {
      return this.e;
    }
    return getIntrinsicHeight();
  }
  
  public int getOriginalWidth()
  {
    if (this.d > 0) {
      return this.d;
    }
    return getIntrinsicWidth();
  }
  
  public final Paint getPaint()
  {
    return this.jdField_a_of_type_Pgd.jdField_a_of_type_AndroidGraphicsPaint;
  }
  
  public Drawable mutate()
  {
    if ((!this.jdField_a_of_type_Boolean) && (super.mutate() == this))
    {
      this.jdField_a_of_type_Pgd = new pgd(this.jdField_a_of_type_Pgd);
      this.jdField_a_of_type_Boolean = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
  }
  
  public void resize(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Pgd.jdField_a_of_type_Int != paramInt1) || (this.jdField_a_of_type_Pgd.b != paramInt2))
    {
      this.jdField_a_of_type_Pgd.jdField_a_of_type_Int = paramInt1;
      this.jdField_a_of_type_Pgd.b = paramInt2;
      a();
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_Pgd.jdField_a_of_type_AndroidGraphicsPaint.getAlpha())
    {
      this.jdField_a_of_type_Pgd.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
      invalidateSelf();
    }
  }
  
  public void setAntiAlias(boolean paramBoolean)
  {
    this.jdField_a_of_type_Pgd.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(paramBoolean);
    invalidateSelf();
  }
  
  protected final void setBitmapInternal(BitmapReference paramBitmapReference)
  {
    setBitmapInternal(paramBitmapReference, true);
  }
  
  protected final void setBitmapInternal(BitmapReference paramBitmapReference, boolean paramBoolean)
  {
    if (paramBitmapReference != this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference)
    {
      this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference = paramBitmapReference;
      a();
      if (paramBoolean) {
        invalidateSelf();
      }
    }
  }
  
  public void setBitmapRef(BitmapReference paramBitmapReference)
  {
    setBitmapInternal(paramBitmapReference);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_Pgd.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.jdField_a_of_type_Pgd.jdField_a_of_type_AndroidGraphicsPaint.setDither(paramBoolean);
    invalidateSelf();
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.jdField_a_of_type_Pgd.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(paramBoolean);
    invalidateSelf();
  }
  
  public void setOriginalHeight(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setOriginalWidth(int paramInt)
  {
    this.d = paramInt;
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
      if (this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference != null) {
        a();
      }
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
 * Qualified Name:     com.tencent.component.media.image.drawable.ImageDrawable
 * JD-Core Version:    0.7.0.1
 */