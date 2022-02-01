package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

public class ApolloGameProcessBar
  extends View
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private String jdField_a_of_type_JavaLangString = "ApolloGameProcessBar";
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private int c = 0;
  
  public ApolloGameProcessBar(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ApolloGameProcessBar(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    if (j == 1073741824) {
      paramInt1 = i;
    }
    do
    {
      return paramInt1;
      paramInt1 = paramInt2;
    } while (j != -2147483648);
    return Math.min(paramInt2, i);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_b_of_type_AndroidGraphicsBitmap == null)) {
      return;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createScaledBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, false);
      this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createScaledBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, false);
      this.jdField_a_of_type_Boolean = true;
    }
    super.onDraw(paramCanvas);
    if (this.c == 0)
    {
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, null);
      return;
    }
    if (this.c == 100)
    {
      paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, 0.0F, 0.0F, null);
      return;
    }
    int i = (int)Math.floor(this.jdField_b_of_type_Int * this.c / 100);
    Bitmap localBitmap1 = Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, 0, 0, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int - i);
    Bitmap localBitmap2 = Bitmap.createBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, 0, this.jdField_b_of_type_Int - i, this.jdField_a_of_type_Int, i);
    paramCanvas.drawBitmap(localBitmap1, 0.0F, 0.0F, null);
    paramCanvas.drawBitmap(localBitmap2, 0.0F, this.jdField_b_of_type_Int - i, null);
    localBitmap1.recycle();
    localBitmap2.recycle();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = a(paramInt1, this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Int = a(paramInt2, this.jdField_b_of_type_Int);
    setMeasuredDimension(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
  }
  
  public void setBitmaps(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap1;
    this.jdField_b_of_type_AndroidGraphicsBitmap = paramBitmap2;
    this.jdField_a_of_type_Int = paramBitmap1.getWidth();
    this.jdField_b_of_type_Int = paramBitmap2.getHeight();
  }
  
  public void setProgress(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_b_of_type_AndroidGraphicsBitmap == null)) {}
    while ((paramInt > 100) || (paramInt < 0)) {
      return;
    }
    this.c = paramInt;
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloGameProcessBar
 * JD-Core Version:    0.7.0.1
 */