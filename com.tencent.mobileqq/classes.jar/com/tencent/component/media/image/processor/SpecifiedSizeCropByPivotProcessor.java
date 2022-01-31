package com.tencent.component.media.image.processor;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.drawable.ScaleDrawable;
import com.tencent.component.media.image.drawable.SpecifiedDrawable;

public class SpecifiedSizeCropByPivotProcessor
  extends CropByPivotProcessor
{
  private final int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean = false;
  private final int b;
  
  public SpecifiedSizeCropByPivotProcessor(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public SpecifiedSizeCropByPivotProcessor(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    this(paramInt1, paramInt2);
    setPivotRate(paramFloat1, paramFloat2);
    if ((paramFloat1 != 0.0F) || (paramFloat2 != 0.0F)) {
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public int getHeight()
  {
    return this.b;
  }
  
  public int getType()
  {
    return super.getType();
  }
  
  public int getWidth()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public Drawable process(Drawable paramDrawable)
  {
    if ((this.jdField_a_of_type_Int <= 0) || (this.b <= 0)) {}
    int i;
    int j;
    do
    {
      return paramDrawable;
      i = paramDrawable.getIntrinsicWidth();
      j = paramDrawable.getIntrinsicHeight();
    } while ((i == this.jdField_a_of_type_Int) && (j == this.b));
    if ((i >= j * 2) || (this.jdField_a_of_type_Boolean)) {}
    for (paramDrawable = new ScaleDrawable(paramDrawable, 10);; paramDrawable = new ScaleDrawable(paramDrawable, 0))
    {
      paramDrawable.setPivot(this.mPivotXRate, this.mPivotYRate);
      return new SpecifiedDrawable(paramDrawable, this.jdField_a_of_type_Int, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.processor.SpecifiedSizeCropByPivotProcessor
 * JD-Core Version:    0.7.0.1
 */