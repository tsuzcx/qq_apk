package com.tencent.biz.pubaccount.weishi_new.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.KandianUrlImageView;

public class RoundCornerImageView
  extends KandianUrlImageView
{
  private int jdField_a_of_type_Int;
  private Path jdField_a_of_type_AndroidGraphicsPath = new Path();
  
  public RoundCornerImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RoundCornerImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int i;
    RectF localRectF;
    if (this.jdField_a_of_type_Int > 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      i = getWidth() - getPaddingLeft() - getPaddingRight();
      int j = getHeight();
      int k = getPaddingTop();
      int m = getPaddingBottom();
      localRectF = new RectF(getPaddingLeft(), getPaddingTop(), getPaddingLeft() + i, j - k - m + getPaddingTop());
      if (this.jdField_a_of_type_Int <= 0) {
        break label138;
      }
      i = this.jdField_a_of_type_Int;
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(localRectF, i, i, Path.Direction.CCW);
      this.jdField_a_of_type_AndroidGraphicsPath.setFillType(Path.FillType.EVEN_ODD);
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
      super.onDraw(paramCanvas);
      return;
      label138:
      i /= 30;
    }
  }
  
  public void setCorner(int paramInt)
  {
    if (paramInt < 0) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.view.RoundCornerImageView
 * JD-Core Version:    0.7.0.1
 */