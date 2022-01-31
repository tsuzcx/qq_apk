package com.tencent.component.media.image.processor;

import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.component.media.image.drawable.ScaleDrawable;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import com.tencent.component.media.image.drawable.SpecifiedDrawable;

public class NormalFeedImageProcessor
  extends CropByPivotProcessor
{
  private static final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(6);
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean = false;
  private int c = 0;
  private int d;
  private int e;
  
  public NormalFeedImageProcessor(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public NormalFeedImageProcessor(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    this(paramInt1, paramInt2);
    setPivotRate(paramFloat1, paramFloat2);
    if ((paramFloat1 != 0.0F) || (paramFloat2 != 0.0F)) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public int getHeight()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public int getType()
  {
    return 5;
  }
  
  public int getWidth()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void keepOrigScale(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.d = paramInt1;
    this.e = paramInt2;
  }
  
  public Drawable process(Drawable paramDrawable)
  {
    if ((this.jdField_a_of_type_Int <= 0) || (this.jdField_b_of_type_Int <= 0)) {}
    int j;
    do
    {
      return paramDrawable;
      i = paramDrawable.getIntrinsicWidth();
      j = paramDrawable.getIntrinsicHeight();
    } while ((i == this.jdField_a_of_type_Int) && (j == this.jdField_b_of_type_Int) && ((paramDrawable instanceof SpecifiedBitmapDrawable)));
    float f;
    if ((this.jdField_b_of_type_Boolean) && (i != 0) && (j != 0) && (this.jdField_a_of_type_Int != 0) && (this.jdField_b_of_type_Int != 0))
    {
      f = i * 1.0F / j;
      if ((Math.abs(f - this.jdField_a_of_type_Int * 1.0F / this.jdField_b_of_type_Int) > 0.05D) && (this.d != 0) && (this.e != 0))
      {
        if (f < this.d * 1.0F / this.e) {
          break label355;
        }
        this.jdField_a_of_type_Int = Math.min(i * 2, this.d);
        this.jdField_b_of_type_Int = ((int)(this.jdField_a_of_type_Int / f));
      }
    }
    if ((i >= j * 2) || (this.jdField_a_of_type_Boolean)) {}
    for (int i = 10;; i = this.c)
    {
      if (!(paramDrawable instanceof ImageDrawable)) {
        break label393;
      }
      try
      {
        BitmapReference localBitmapReference = ((ImageDrawable)paramDrawable).getBitmapRef();
        Object localObject1 = localBitmapReference.getConfig();
        Object localObject2 = ImageManager.getInstance();
        j = this.jdField_a_of_type_Int;
        int k = this.jdField_b_of_type_Int;
        paramDrawable = (Drawable)localObject1;
        if (localObject1 == null) {
          paramDrawable = Bitmap.Config.ARGB_8888;
        }
        paramDrawable = ((ImageManager)localObject2).getBitmap(j, k, paramDrawable);
        localObject1 = new Canvas(paramDrawable.getBitmap());
        localObject2 = new Matrix();
        ScaleDrawable.getMatrix((Matrix)localObject2, i, localBitmapReference.getWidth(), localBitmapReference.getHeight(), this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.mPivotXRate, this.mPivotYRate);
        ((Canvas)localObject1).drawBitmap(localBitmapReference.getBitmap(), (Matrix)localObject2, jdField_a_of_type_AndroidGraphicsPaint);
        if (!localBitmapReference.isRecycled()) {
          localBitmapReference.release();
        }
        paramDrawable = new SpecifiedBitmapDrawable(paramDrawable);
        return paramDrawable;
      }
      catch (OutOfMemoryError paramDrawable)
      {
        paramDrawable.printStackTrace();
        return null;
      }
      label355:
      this.jdField_b_of_type_Int = Math.min(j * 2, this.e);
      this.jdField_a_of_type_Int = ((int)(f * this.jdField_b_of_type_Int));
      break;
    }
    label393:
    paramDrawable = new ScaleDrawable(paramDrawable, i);
    paramDrawable.setPivot(this.mPivotXRate, this.mPivotYRate);
    return new SpecifiedDrawable(paramDrawable, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  public void setDefaultScaleType(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.processor.NormalFeedImageProcessor
 * JD-Core Version:    0.7.0.1
 */