package com.tencent.biz.tribe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Path.FillType;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class VideoLayout
  extends FrameLayout
{
  private int jdField_a_of_type_Int = 0;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  
  public VideoLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public VideoLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public VideoLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      if (this.jdField_a_of_type_AndroidGraphicsPath == null) {
        this.jdField_a_of_type_AndroidGraphicsPath = new Path();
      }
      this.jdField_a_of_type_AndroidGraphicsPath.reset();
      int i = getWidth();
      int j = getPaddingLeft();
      int k = getPaddingRight();
      int m = getHeight();
      int n = getPaddingTop();
      int i1 = getPaddingBottom();
      RectF localRectF = new RectF(getPaddingLeft(), getPaddingTop(), i - j - k + getPaddingLeft(), m - n - i1 + getPaddingTop());
      this.jdField_a_of_type_AndroidGraphicsPath.addRoundRect(localRectF, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, Path.Direction.CCW);
      this.jdField_a_of_type_AndroidGraphicsPath.setFillType(Path.FillType.EVEN_ODD);
      paramCanvas.clipPath(this.jdField_a_of_type_AndroidGraphicsPath);
    }
    super.draw(paramCanvas);
  }
  
  public void setRoundCorner(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.tribe.VideoLayout
 * JD-Core Version:    0.7.0.1
 */